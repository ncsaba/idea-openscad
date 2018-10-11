package com.javampire.openscad.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.javampire.openscad.psi.OpenSCADNamedElement;
import org.jetbrains.annotations.NotNull;

public abstract class OpenSCADNamedElementImpl extends ASTWrapperPsiElement implements OpenSCADNamedElement {

    public OpenSCADNamedElementImpl(@NotNull ASTNode node) {
        super(node);
    }

}
