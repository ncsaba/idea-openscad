package com.javampire.openscad.references;

import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.*;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.util.ArrayUtil;
import com.javampire.openscad.psi.OpenSCADModuleDeclaration;
import com.javampire.openscad.psi.OpenSCADNamedElement;
import com.javampire.openscad.psi.stub.index.OpenSCADModuleIndex;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class OpenSCADModuleReference extends PsiReferenceBase<OpenSCADNamedElement> implements PsiPolyVariantReference {

    private static final Logger LOG = Logger.getInstance("#com.javampire.openscad.references.OpenSCADModuleReference");

    private String moduleName;

    public OpenSCADModuleReference(@NotNull OpenSCADNamedElement element, TextRange textRange) {
        super(element, textRange);
        moduleName = element.getName();
    }

    @NotNull
    @Override
    public ResolveResult[] multiResolve(boolean incompleteCode) {
        Project project = myElement.getProject();
        final Collection<OpenSCADModuleDeclaration> modules = OpenSCADModuleIndex.getInstance().get(this.moduleName, project, GlobalSearchScope.allScope(project));
        LOG.debug("multiResolve modules:" + modules);
        final List<ResolveResult> results = new ArrayList<ResolveResult>();
        for (OpenSCADModuleDeclaration module : modules) {
            results.add(new PsiElementResolveResult(module));
        }
        LOG.debug("multiResolve results:" + results);
        return results.toArray(new ResolveResult[0]);
    }

    @Nullable
    @Override
    public PsiElement resolve() {
        LOG.debug("resolve called");
        final ResolveResult[] resolveResults = multiResolve(false);
        return resolveResults.length == 1 ? resolveResults[0].getElement() : null;
    }

    @NotNull
    @Override
    public Object[] getVariants() {
        // TODO: implement (this is used for code completion)
        LOG.debug("getVariants called");
        return ArrayUtil.EMPTY_OBJECT_ARRAY;
    }

    @Override
    public String toString() {
        return "ModuleReference(" + this.moduleName + ", " + getRangeInElement() + ")";
    }

}
