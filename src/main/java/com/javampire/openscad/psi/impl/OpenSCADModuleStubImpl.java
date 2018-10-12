package com.javampire.openscad.psi.impl;

import com.intellij.psi.stubs.StubBase;
import com.intellij.psi.stubs.StubElement;
import com.javampire.openscad.psi.OpenSCADModuleDeclaration;
import com.javampire.openscad.psi.stub.OpenSCADModuleStub;
import com.javampire.openscad.psi.stub.OpenSCADModuleStubElementType;

public class OpenSCADModuleStubImpl extends StubBase<OpenSCADModuleDeclaration> implements OpenSCADModuleStub {

    private final String name;

    public OpenSCADModuleStubImpl(StubElement parent, String name) {
        super(parent, OpenSCADModuleStubElementType.INSTANCE);
        this.name = name;
    }


    @Override
    public String getName() {
        return this.name;
    }

}
