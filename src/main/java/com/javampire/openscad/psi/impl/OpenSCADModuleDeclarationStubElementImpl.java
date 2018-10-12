package com.javampire.openscad.psi.impl;

import com.intellij.extapi.psi.StubBasedPsiElementBase;
import com.intellij.lang.ASTNode;
import com.intellij.lang.Language;
import com.intellij.psi.stubs.IStubElementType;
import com.javampire.openscad.OpenSCADLanguage;
import com.javampire.openscad.psi.stub.OpenSCADModuleStub;
import org.jetbrains.annotations.NotNull;

public class OpenSCADModuleDeclarationStubElementImpl extends StubBasedPsiElementBase<OpenSCADModuleStub> {

    public OpenSCADModuleDeclarationStubElementImpl(@NotNull OpenSCADModuleStub stub, @NotNull IStubElementType nodeType) {
        super(stub, nodeType);
    }

    public OpenSCADModuleDeclarationStubElementImpl(@NotNull ASTNode node) {
        super(node);
    }

    @Override
    @NotNull
    public Language getLanguage() {
        return OpenSCADLanguage.INSTANCE;
    }

}
