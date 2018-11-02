package com.javampire.openscad.structureview;

import com.intellij.ide.util.treeView.AbstractTreeNode;
import com.intellij.ide.util.treeView.smartTree.*;
import com.intellij.navigation.ItemPresentation;
import com.intellij.util.PlatformIcons;
import com.javampire.openscad.OpenSCADBundle;
import com.javampire.openscad.OpenSCADIcons;
import com.javampire.openscad.psi.*;
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

    private static final ItemPresentation IMPORT_GROUP_ITEM = new GroupPresentation(
            OpenSCADBundle.message("com.javampire.openscad.grouper.imports"),
            OpenSCADIcons.FILE
    );

    private static final ItemPresentation VARIABLE_GROUP_ITEM = new GroupPresentation(
            OpenSCADBundle.message("com.javampire.openscad.grouper.variables"),
            PlatformIcons.VARIABLE_ICON
    );

    private static final ItemPresentation NO_GROUP_ITEM = new GroupPresentation(
            OpenSCADBundle.message("com.javampire.openscad.grouper.invalid"),
            PlatformIcons.INVALID_ENTRY_ICON
    );

    public static final Map<Class, ItemPresentation> ITEM_PRESENTATION_MAP = new LinkedHashMap<>();
    static {
        ITEM_PRESENTATION_MAP.put(OpenSCADUseItem.class, IMPORT_GROUP_ITEM);
        ITEM_PRESENTATION_MAP.put(OpenSCADIncludeItem.class, IMPORT_GROUP_ITEM);
        ITEM_PRESENTATION_MAP.put(OpenSCADFunctionDeclaration.class, FUNCTION_GROUP_ITEM);
        ITEM_PRESENTATION_MAP.put(OpenSCADModuleDeclaration.class, MODULE_GROUP_ITEM);
        ITEM_PRESENTATION_MAP.put(OpenSCADVariableDeclaration.class, VARIABLE_GROUP_ITEM);
    }

    @NotNull
    @Override
    public Collection<Group> group(@NotNull AbstractTreeNode parent, @NotNull Collection<TreeElement> children) {
        if (parent.getValue() instanceof ElementGroup) return Collections.emptyList();
        final LinkedHashMap<ItemPresentation, Group> result = new LinkedHashMap<>();
        for (Map.Entry<Class, ItemPresentation> entry : ITEM_PRESENTATION_MAP.entrySet()) {
            final Class itemType = entry.getKey();
            final ItemPresentation presentation = entry.getValue();
            ElementGroup group = (ElementGroup) result.get(presentation);
            if (group == null) {
                group = new ElementGroup(children, itemType);
                if (group.presentation != NO_GROUP_ITEM && ! group.children.isEmpty()) {
                    result.put(presentation, group);
                }
            } else {
                group.addChildren(children, itemType);
            }
        }
        return result.values();
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

        private final Collection<TreeElement> children;
        private final ItemPresentation presentation;

        public ElementGroup(@NotNull Collection<TreeElement> candidateChildren, Class itemType) {
            this.children = new ArrayList<>();
            this.presentation = ITEM_PRESENTATION_MAP.getOrDefault(itemType, NO_GROUP_ITEM);
            addChildren(candidateChildren, itemType);
        }

        private void addChildren(@NotNull Collection<TreeElement> candidateChildren, Class itemType) {
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
