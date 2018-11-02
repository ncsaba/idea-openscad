package com.javampire.openscad.psi.stub;

import com.intellij.psi.stubs.*;
import com.intellij.util.io.StringRef;
import com.javampire.openscad.OpenSCADLanguage;
import com.javampire.openscad.psi.OpenSCADVariableDeclaration;
import com.javampire.openscad.psi.impl.OpenSCADVariableDeclarationImpl;
import com.javampire.openscad.psi.impl.OpenSCADVariableStubImpl;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import static com.javampire.openscad.psi.stub.index.OpenSCADVariableIndex.VARIABLE;

public class OpenSCADVariableStubElementType extends IStubElementType<OpenSCADVariableStub, OpenSCADVariableDeclaration> {

    public static final OpenSCADVariableStubElementType INSTANCE = new OpenSCADVariableStubElementType();

    public OpenSCADVariableStubElementType() {
        super("OPEN_SCAD_VARIABLE", OpenSCADLanguage.INSTANCE);
    }

    @Override
    public OpenSCADVariableDeclaration createPsi(@NotNull OpenSCADVariableStub stub) {
        return new OpenSCADVariableDeclarationImpl(stub, this);
    }

    @NotNull
    @Override
    public OpenSCADVariableStub createStub(@NotNull OpenSCADVariableDeclaration psi, StubElement parentStub) {
        return new OpenSCADVariableStubImpl(parentStub, psi.getName());
    }

    @NotNull
    @Override
    public String getExternalId() {
        return "OpenSCAD.variable";
    }

    @Override
    public void serialize(@NotNull OpenSCADVariableStub stub, @NotNull StubOutputStream dataStream) throws IOException {
        dataStream.writeName(stub.getName());
    }

    @NotNull
    @Override
    public OpenSCADVariableStub deserialize(@NotNull StubInputStream dataStream, StubElement parentStub) throws IOException {
        final StringRef ref = dataStream.readName();
        return new OpenSCADVariableStubImpl(parentStub, ref != null ? ref.getString() : null);
    }

    @Override
    public void indexStub(@NotNull OpenSCADVariableStub stub, @NotNull IndexSink sink) {
        sink.occurrence(VARIABLE, stub.getName());
    }
}
