package com.javampire.openscad.psi.stub.index;

import com.intellij.openapi.project.Project;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.psi.stubs.StringStubIndexExtension;
import com.intellij.psi.stubs.StubIndex;
import com.intellij.psi.stubs.StubIndexKey;
import com.javampire.openscad.psi.OpenSCADVariableDeclaration;
import com.javampire.openscad.references.OpenSCADReferenceResolver;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;

public class OpenSCADVariableIndex
        extends StringStubIndexExtension<OpenSCADVariableDeclaration>
        implements OpenSCADReferenceResolver
{

    public static final StubIndexKey<String, OpenSCADVariableDeclaration> VARIABLE = StubIndexKey.createIndexKey("OpenSCAD.variable.name");

    private static final OpenSCADVariableIndex INSTANCE = new OpenSCADVariableIndex();

    public static OpenSCADVariableIndex getInstance() {
        return INSTANCE;
    }

    @NotNull
    @Override
    public StubIndexKey<String, OpenSCADVariableDeclaration> getKey() {
        return VARIABLE;
    }

    @Override
    public Collection<OpenSCADVariableDeclaration> get(@NotNull final String variableName,
                                                       @NotNull final Project project,
                                                       @NotNull final GlobalSearchScope scope)
    {
        return StubIndex.getElements(getKey(), variableName, project, null, OpenSCADVariableDeclaration.class);
    }

}
