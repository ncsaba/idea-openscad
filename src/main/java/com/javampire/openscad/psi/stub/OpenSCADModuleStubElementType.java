package com.javampire.openscad.psi.stub;

import com.intellij.psi.stubs.*;
import com.intellij.util.io.StringRef;
import com.javampire.openscad.OpenSCADLanguage;
import com.javampire.openscad.psi.OpenSCADModuleDeclaration;
import com.javampire.openscad.psi.impl.OpenSCADModuleDeclarationImpl;
import com.javampire.openscad.psi.impl.OpenSCADModuleStubImpl;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import static com.javampire.openscad.psi.stub.index.OpenSCADModuleIndex.MODULE;

public class OpenSCADModuleStubElementType extends IStubElementType<OpenSCADModuleStub, OpenSCADModuleDeclaration> {

    public static final OpenSCADModuleStubElementType INSTANCE = new OpenSCADModuleStubElementType();

    public OpenSCADModuleStubElementType() {
        super("OPEN_SCAD_MODULE", OpenSCADLanguage.INSTANCE);
    }

    @Override
    public OpenSCADModuleDeclaration createPsi(@NotNull OpenSCADModuleStub stub) {
        return new OpenSCADModuleDeclarationImpl(stub, this);
    }

    @NotNull
    @Override
    public OpenSCADModuleStub createStub(@NotNull OpenSCADModuleDeclaration psi, StubElement parentStub) {
        return new OpenSCADModuleStubImpl(parentStub, psi.getName());
    }

    @NotNull
    @Override
    public String getExternalId() {
        return "OpenSCAD.module";
    }

    @Override
    public void serialize(@NotNull OpenSCADModuleStub stub, @NotNull StubOutputStream dataStream) throws IOException {
        dataStream.writeName(stub.getName());
    }

    @NotNull
    @Override
    public OpenSCADModuleStub deserialize(@NotNull StubInputStream dataStream, StubElement parentStub) throws IOException {
        final StringRef ref = dataStream.readName();
        return new OpenSCADModuleStubImpl(parentStub, ref != null ? ref.getString() : null);
    }

    @Override
    public void indexStub(@NotNull OpenSCADModuleStub stub, @NotNull IndexSink sink) {
        sink.occurrence(MODULE, stub.getName());
    }
}
