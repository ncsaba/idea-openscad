package com.javampire.openscad.references;

import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.*;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.util.ArrayUtil;
import com.javampire.openscad.psi.OpenSCADFunctionDeclaration;
import com.javampire.openscad.psi.OpenSCADNamedElement;
import com.javampire.openscad.psi.stub.index.OpenSCADFunctionIndex;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class OpenSCADFunctionReference extends PsiReferenceBase<OpenSCADNamedElement> implements PsiPolyVariantReference {

    private static final Logger LOG = Logger.getInstance("#com.javampire.openscad.references.OpenSCADFunctionReference");

    private String functionName;

    public OpenSCADFunctionReference(@NotNull OpenSCADNamedElement element, TextRange textRange) {
        super(element, textRange);
        functionName = element.getName();
    }

    @NotNull
    @Override
    public ResolveResult[] multiResolve(boolean incompleteCode) {
        Project project = myElement.getProject();
        final Collection<OpenSCADFunctionDeclaration> functions = OpenSCADFunctionIndex.getInstance().get(this.functionName, project, GlobalSearchScope.allScope(project));
        LOG.debug("multiResolve functions:" + functions);
        final List<ResolveResult> results = new ArrayList<ResolveResult>();
        for (OpenSCADFunctionDeclaration function : functions) {
            results.add(new PsiElementResolveResult(function));
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
        return "FunctionReference(" + this.functionName + ", " + getRangeInElement() + ")";
    }
}
