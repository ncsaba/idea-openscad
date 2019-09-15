package com.javampire.openscad.references;

import com.intellij.openapi.project.Project;
import com.intellij.psi.search.GlobalSearchScope;
import com.javampire.openscad.psi.OpenSCADNamedElement;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;

public interface OpenSCADReferenceResolver {

    Collection<? extends OpenSCADNamedElement> get(@NotNull final String referencedName,
                                                   @NotNull final Project project,
                                                   @NotNull final GlobalSearchScope scope);
}
