package com.javampire.openscad.structureview;

import com.intellij.ide.structureView.StructureViewModel;
import com.intellij.ide.structureView.StructureViewModelBase;
import com.intellij.ide.structureView.StructureViewTreeElement;
import com.intellij.ide.util.treeView.smartTree.Grouper;
import com.intellij.ide.util.treeView.smartTree.Sorter;
import com.intellij.openapi.editor.Editor;
import com.intellij.psi.PsiFile;
import com.javampire.openscad.psi.*;
import org.jetbrains.annotations.NotNull;

public class OpenSCADStructureViewModel
        extends StructureViewModelBase
        implements StructureViewModel.ElementInfoProvider {

    private static final Grouper[] GROUPERS = {new OpenSCADElementGrouper()};

    public OpenSCADStructureViewModel(PsiFile psiFile, Editor editor) {
        super(psiFile, editor, new OpenSCADStructureViewElement(psiFile));
        withSuitableClasses(
                OpenSCADModuleDeclaration.class,
                OpenSCADFunctionDeclaration.class,
                OpenSCADUseItem.class,
                OpenSCADIncludeItem.class,
                OpenSCADVariableDeclaration.class
        );
        withSorters(Sorter.ALPHA_SORTER);
    }

    @Override
    public boolean isAlwaysShowsPlus(StructureViewTreeElement element) {
        return false;
    }

    @Override
    public boolean isAlwaysLeaf(StructureViewTreeElement element) {
        return element instanceof OpenSCADFile;
    }

    @NotNull
    @Override
    public Grouper[] getGroupers() {
        return GROUPERS;
    }
}
