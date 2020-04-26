package com.javampire.openscad.psi.impl;

import com.intellij.extapi.psi.StubBasedPsiElementBase;
import com.intellij.lang.ASTNode;
import com.intellij.lang.Language;
import com.intellij.psi.PsiElement;
import com.intellij.psi.stubs.IStubElementType;
import com.javampire.openscad.OpenSCADLanguage;
import com.javampire.openscad.psi.OpenSCADElementFactory;
import com.javampire.openscad.psi.OpenSCADTypes;
import com.javampire.openscad.psi.stub.OpenSCADVariableStub;
import org.jetbrains.annotations.NotNull;

public class OpenSCADVariableDeclarationStubElementImpl extends StubBasedPsiElementBase<OpenSCADVariableStub> {

    public OpenSCADVariableDeclarationStubElementImpl(@NotNull OpenSCADVariableStub stub, @NotNull IStubElementType nodeType) {
        super(stub, nodeType);
    }

    public OpenSCADVariableDeclarationStubElementImpl(@NotNull ASTNode node) {
        super(node);
    }

    @Override
    @NotNull
    public Language getLanguage() {
        return OpenSCADLanguage.INSTANCE;
    }

    @Override
    public String getName() {
        final OpenSCADVariableStub stub = getStub();
        if (stub != null) {
            return stub.getName();
        }
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

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" + getNode().getElementType().toString() + ")";
    }
}
