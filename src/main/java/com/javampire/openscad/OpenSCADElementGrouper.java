package com.javampire.openscad;

import com.intellij.ide.util.treeView.AbstractTreeNode;
import com.intellij.ide.util.treeView.smartTree.*;
import com.intellij.navigation.ItemPresentation;
import com.intellij.util.PlatformIcons;
import com.javampire.openscad.psi.OpenSCADFunctionDeclaration;
import com.javampire.openscad.psi.OpenSCADModuleDeclaration;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.util.*;

public class OpenSCADElementGrouper implements Grouper {

    private static final ItemPresentation MODULE_GROUP_ITEM = new GroupPresentation(
            OpenSCADBundle.message("com.javampire.openscad.grouper.modules"),
            OpenSCADIcons.MODULE
    );

    private static final ItemPresentation FUNCTION_GROUP_ITEM = new GroupPresentation(
            OpenSCADBundle.message("com.javampire.openscad.grouper.functions"),
            OpenSCADIcons.FUNCTION
    );

    private static final ItemPresentation NO_GROUP_ITEM = new GroupPresentation(
            "Invalid",
            PlatformIcons.INVALID_ENTRY_ICON
    );

    public static final Map<Class, ItemPresentation> ITEM_PRESENTATION_MAP = new HashMap<>();
    static {
        ITEM_PRESENTATION_MAP.put(OpenSCADModuleDeclaration.class, MODULE_GROUP_ITEM);
        ITEM_PRESENTATION_MAP.put(OpenSCADFunctionDeclaration.class, FUNCTION_GROUP_ITEM);
    }

    @NotNull
    @Override
    public Collection<Group> group(@NotNull AbstractTreeNode parent, @NotNull Collection<TreeElement> children) {
        if (parent.getValue() instanceof ElementGroup) return Collections.emptyList();
        Collection<Group> result = new ArrayList<>();
        for (Class itemType : ITEM_PRESENTATION_MAP.keySet()) {
            final ElementGroup group = new ElementGroup(children, itemType);
            if (group.presentation != NO_GROUP_ITEM) {
                result.add(group);
            }
        }
        return result;
    }

    @NotNull
    @Override
    public ActionPresentation getPresentation() {
        return new ActionPresentationData(
                OpenSCADBundle.message("com.javampire.openscad.grouper.group_by_item_type"),
                null,
                OpenSCADIcons.ELEMENT_GROUPER
        );
    }

    @NotNull
    @Override
    public String getName() {
        return "OPENSCAD_ELEMENT_GROUPER";
    }

    private static class ElementGroup implements Group {

        private final Class itemType;
        private final Collection<TreeElement> children;
        private final ItemPresentation presentation;

        public ElementGroup(@NotNull Collection<TreeElement> candidateChildren, Class itemType) {
            this.children = new ArrayList<>();
            this.itemType = itemType;
            this.presentation = ITEM_PRESENTATION_MAP.getOrDefault(itemType, NO_GROUP_ITEM);
            for (TreeElement item : candidateChildren) {
                if (item instanceof OpenSCADStructureViewElement && itemType.isInstance(((OpenSCADStructureViewElement)item).getValue())) {
                    this.children.add(item);
                }
            }
        }

        @NotNull
        @Override
        public ItemPresentation getPresentation() {
            return this.presentation;
        }

        @NotNull
        @Override
        public Collection<TreeElement> getChildren() {
            return this.children;
        }
    }

    private static class GroupPresentation implements ItemPresentation {

        private final String presentableText;
        private final Icon icon;

        public GroupPresentation(String presentableText, Icon icon) {
            this.presentableText = presentableText;
            this.icon = icon;
        }

        @Nullable
        @Override
        public String getPresentableText() {
            return this.presentableText;
        }

        @Nullable
        @Override
        public String getLocationString() {
            return null;
        }

        @Nullable
        @Override
        public Icon getIcon(boolean unused) {
            return this.icon;
        }

    }
}
