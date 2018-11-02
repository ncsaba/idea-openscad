package com.javampire.openscad.psi.impl;

import com.intellij.psi.stubs.StubBase;
import com.intellij.psi.stubs.StubElement;
import com.javampire.openscad.psi.OpenSCADVariableDeclaration;
import com.javampire.openscad.psi.stub.OpenSCADVariableStub;
import com.javampire.openscad.psi.stub.OpenSCADVariableStubElementType;

public class OpenSCADVariableStubImpl extends StubBase<OpenSCADVariableDeclaration> implements OpenSCADVariableStub {

    private final String name;

    public OpenSCADVariableStubImpl(StubElement parent, String name) {
        super(parent, OpenSCADVariableStubElementType.INSTANCE);
        this.name = name;
    }


    @Override
    public String getName() {
        return this.name;
    }

}
