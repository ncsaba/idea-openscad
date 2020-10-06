package com.javampire.openscad.psi.stub.index;

import com.intellij.openapi.project.Project;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.psi.stubs.StringStubIndexExtension;
import com.intellij.psi.stubs.StubIndex;
import com.intellij.psi.stubs.StubIndexKey;
import com.javampire.openscad.psi.OpenSCADFunctionDeclaration;
import com.javampire.openscad.references.OpenSCADReferenceResolver;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;

public class OpenSCADFunctionIndex
        extends StringStubIndexExtension<OpenSCADFunctionDeclaration>
        implements OpenSCADReferenceResolver {

    public static final StubIndexKey<String, OpenSCADFunctionDeclaration> FUNCTION = StubIndexKey.createIndexKey("OpenSCAD.function.name");

    private static final OpenSCADFunctionIndex INSTANCE = new OpenSCADFunctionIndex();

    public static OpenSCADFunctionIndex getInstance() {
        return INSTANCE;
    }

    @NotNull
    @Override
    public StubIndexKey<String, OpenSCADFunctionDeclaration> getKey() {
        return FUNCTION;
    }

    @Override
    public Collection<OpenSCADFunctionDeclaration> get(@NotNull final String functionName,
                                                       @NotNull final Project project,
                                                       @NotNull final GlobalSearchScope scope) {
        return StubIndex.getElements(getKey(), functionName, project, null, OpenSCADFunctionDeclaration.class);
    }

}
