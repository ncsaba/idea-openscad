package com.javampire.openscad;

import com.intellij.ide.projectView.PresentationData;
import com.intellij.ide.structureView.StructureViewTreeElement;
import com.intellij.ide.util.treeView.smartTree.SortableTreeElement;
import com.intellij.ide.util.treeView.smartTree.TreeElement;
import com.intellij.navigation.ItemPresentation;
import com.intellij.psi.NavigatablePsiElement;
import com.intellij.psi.PsiElement;
import com.intellij.psi.util.PsiTreeUtil;
import com.javampire.openscad.psi.OpenSCADFile;
import com.javampire.openscad.psi.OpenSCADFunctionDeclaration;
import com.javampire.openscad.psi.OpenSCADModuleDeclaration;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class OpenSCADStructureViewElement implements StructureViewTreeElement, SortableTreeElement {

    private NavigatablePsiElement element;

    OpenSCADStructureViewElement(NavigatablePsiElement element) {
        this.element = element;
    }

    @Override
    public Object getValue() {
        return element;
    }

    @Override
    public void navigate(boolean requestFocus) {
        element.navigate(requestFocus);
    }

    @Override
    public boolean canNavigate() {
        return element.canNavigate();
    }

    @Override
    public boolean canNavigateToSource() {
        return element.canNavigateToSource();
    }

    @NotNull
    @Override
    public String getAlphaSortKey() {
        final ItemPresentation presentation = element.getPresentation();
        if (presentation == null) {
            return "";
        }
        String name = presentation.getPresentableText();
        return name != null ? name : "";
    }

    @NotNull
    @Override
    public ItemPresentation getPresentation() {
        ItemPresentation presentation = element.getPresentation();
        return presentation != null ? presentation : new PresentationData();
    }

    @NotNull
    @Override
    public TreeElement[] getChildren() {
        if (element instanceof OpenSCADFile) {
            final List<TreeElement> treeElements = new ArrayList<>();
            final List<PsiElement> navigatableElements = PsiTreeUtil.getChildrenOfAnyType(
                    element, OpenSCADModuleDeclaration.class, OpenSCADFunctionDeclaration.class
            );
            for (PsiElement element : navigatableElements) {
                final OpenSCADStructureViewElement child = new OpenSCADStructureViewElement((NavigatablePsiElement)element);
                treeElements.add(child);
            }
            return treeElements.toArray(new TreeElement[0]);
        } else {
            return EMPTY_ARRAY;
        }
    }

}
