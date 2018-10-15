package com.javampire.openscad.psi.stub;

import com.intellij.psi.stubs.*;
import com.intellij.util.io.StringRef;
import com.javampire.openscad.OpenSCADLanguage;
import com.javampire.openscad.psi.OpenSCADFunctionDeclaration;
import com.javampire.openscad.psi.impl.OpenSCADFunctionDeclarationImpl;
import com.javampire.openscad.psi.impl.OpenSCADFunctionStubImpl;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import static com.javampire.openscad.psi.stub.index.OpenSCADFunctionIndex.FUNCTION;

public class OpenSCADFunctionStubElementType extends IStubElementType<OpenSCADFunctionStub, OpenSCADFunctionDeclaration> {

    public static final OpenSCADFunctionStubElementType INSTANCE = new OpenSCADFunctionStubElementType();

    public OpenSCADFunctionStubElementType() {
        super("OPEN_SCAD_FUNCTION", OpenSCADLanguage.INSTANCE);
    }

    @Override
    public OpenSCADFunctionDeclaration createPsi(@NotNull OpenSCADFunctionStub stub) {
        return new OpenSCADFunctionDeclarationImpl(stub, this);
    }

    @NotNull
    @Override
    public OpenSCADFunctionStub createStub(@NotNull OpenSCADFunctionDeclaration psi, StubElement parentStub) {
        return new OpenSCADFunctionStubImpl(parentStub, psi.getName());
    }

    @NotNull
    @Override
    public String getExternalId() {
        return "OpenSCAD.function";
    }

    @Override
    public void serialize(@NotNull OpenSCADFunctionStub stub, @NotNull StubOutputStream dataStream) throws IOException {
        dataStream.writeName(stub.getName());
    }

    @NotNull
    @Override
    public OpenSCADFunctionStub deserialize(@NotNull StubInputStream dataStream, StubElement parentStub) throws IOException {
        final StringRef ref = dataStream.readName();
        return new OpenSCADFunctionStubImpl(parentStub, ref != null ? ref.getString() : null);
    }

    @Override
    public void indexStub(@NotNull OpenSCADFunctionStub stub, @NotNull IndexSink sink) {
        sink.occurrence(FUNCTION, stub.getName());
    }
}
