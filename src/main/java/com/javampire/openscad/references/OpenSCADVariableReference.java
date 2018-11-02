package com.javampire.openscad.references;

import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.*;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.util.ArrayUtil;
import com.javampire.openscad.psi.OpenSCADNamedElement;
import com.javampire.openscad.psi.OpenSCADVariableDeclaration;
import com.javampire.openscad.psi.stub.index.OpenSCADVariableIndex;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class OpenSCADVariableReference extends PsiReferenceBase<OpenSCADNamedElement> implements PsiPolyVariantReference {

    private static final Logger LOG = Logger.getInstance("#com.javampire.openscad.references.OpenSCADVariableReference");

    private String variableName;

    public OpenSCADVariableReference(@NotNull OpenSCADNamedElement element, TextRange textRange) {
        super(element, textRange);
        variableName = element.getName();
    }

    @NotNull
    @Override
    public ResolveResult[] multiResolve(boolean incompleteCode) {
        Project project = myElement.getProject();
        final Collection<OpenSCADVariableDeclaration> variables = OpenSCADVariableIndex.getInstance().get(this.variableName, project, GlobalSearchScope.allScope(project));
        LOG.debug("multiResolve variables:" + variables);
        final List<ResolveResult> results = new ArrayList<ResolveResult>();
        for (OpenSCADVariableDeclaration variable : variables) {
            results.add(new PsiElementResolveResult(variable));
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
        return "VariableReference(" + this.variableName + ", " + getRangeInElement() + ")";
    }
}
