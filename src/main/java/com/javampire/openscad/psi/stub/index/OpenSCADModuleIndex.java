package com.javampire.openscad.psi.stub.index;

import com.intellij.openapi.project.Project;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.psi.stubs.StringStubIndexExtension;
import com.intellij.psi.stubs.StubIndex;
import com.intellij.psi.stubs.StubIndexKey;
import com.javampire.openscad.psi.OpenSCADModuleDeclaration;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;

public class OpenSCADModuleIndex extends StringStubIndexExtension<OpenSCADModuleDeclaration> {

    public static final StubIndexKey<String, OpenSCADModuleDeclaration> MODULE = StubIndexKey.createIndexKey("OpenSCAD.module.name");

    private static final OpenSCADModuleIndex INSTANCE = new OpenSCADModuleIndex();

    public static OpenSCADModuleIndex getInstance() {
        return INSTANCE;
    }

    @NotNull
    @Override
    public StubIndexKey<String, OpenSCADModuleDeclaration> getKey() {
        return MODULE;
    }

    @Override
    public Collection<OpenSCADModuleDeclaration> get(@NotNull final String moduleName,
                                                     @NotNull final Project project,
                                                     @NotNull final GlobalSearchScope scope)
    {
        return StubIndex.getElements(getKey(), moduleName, project, null, OpenSCADModuleDeclaration.class);
    }

}
