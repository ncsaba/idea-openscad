package com.javampire.openscad.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.javampire.openscad.psi.OpenSCADElementFactory;
import com.javampire.openscad.psi.OpenSCADNamedElement;
import com.javampire.openscad.psi.OpenSCADTypes;
import org.jetbrains.annotations.NotNull;

public abstract class OpenSCADNamedElementImpl extends ASTWrapperPsiElement implements OpenSCADNamedElement {

    public OpenSCADNamedElementImpl(@NotNull ASTNode node) {
        super(node);
    }

    @Override
    public String getName() {
        final ASTNode nameNode = getNode().findChildByType(OpenSCADTypes.IDENTIFIER);
        if (nameNode != null) {
            return nameNode.getText();
        }
        return null;
    }

    public PsiElement setName(@NotNull String newName) {
        final ASTNode nameNode = getNode().findChildByType(OpenSCADTypes.IDENTIFIER);
        if (nameNode != null) {
            PsiElement newNameElement = OpenSCADElementFactory.createIdentifier(getProject(), newName);
            getNode().replaceChild(nameNode, newNameElement.getNode());
        }
        return this;
    }
}
