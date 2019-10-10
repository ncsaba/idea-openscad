package com.javampire.openscad.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiReference;
import com.javampire.openscad.psi.OpenSCADImportElement;
import com.javampire.openscad.references.OpenSCADImportReference;
import org.jetbrains.annotations.NotNull;

public class OpenSCADImportElementImpl extends ASTWrapperPsiElement implements OpenSCADImportElement {

    public OpenSCADImportElementImpl(@NotNull ASTNode node) {
        super(node);
    }

    public String getImportPath() {
        return getText();
    }

    public PsiReference getReference() {
        return new OpenSCADImportReference(this, new TextRange(0, getTextLength()));
    }

}
