package com.javampire.openscad.psi.impl;

import com.intellij.psi.stubs.StubBase;
import com.intellij.psi.stubs.StubElement;
import com.javampire.openscad.psi.OpenSCADFunctionDeclaration;
import com.javampire.openscad.psi.stub.OpenSCADFunctionStub;
import com.javampire.openscad.psi.stub.OpenSCADFunctionStubElementType;

public class OpenSCADFunctionStubImpl extends StubBase<OpenSCADFunctionDeclaration> implements OpenSCADFunctionStub {

    private final String name;

    public OpenSCADFunctionStubImpl(StubElement parent, String name) {
        super(parent, OpenSCADFunctionStubElementType.INSTANCE);
        this.name = name;
    }


    @Override
    public String getName() {
        return this.name;
    }

}
