package com.javampire.openscad.references;

import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.module.ModuleUtil;
import com.intellij.openapi.project.ProjectUtil;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.*;
import com.intellij.util.ArrayUtil;
import com.javampire.openscad.psi.OpenSCADImportElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class OpenSCADImportReference extends PsiReferenceBase<OpenSCADImportElement> implements PsiPolyVariantReference {

    private static final Logger LOG = Logger.getInstance("#com.javampire.openscad.references.OpenSCADImportReference");

    private String importPath;

    public OpenSCADImportReference(@NotNull OpenSCADImportElement element, TextRange textRange) {
        super(element, textRange);
        importPath = element.getImportPath();
    }

    @NotNull
    @Override
    public ResolveResult[] multiResolve(boolean incompleteCode) {
        final Module module = ModuleUtil.findModuleForPsiElement(myElement);
        final List<PsiFile> fileList;
        if (module == null) {
            fileList = OpenSCADResolver.findFilesByRelativePath(myElement.getProject(), importPath);
        } else {
            fileList = OpenSCADResolver.findFilesByRelativePath(module, importPath);
        }
        final List<ResolveResult> results = new ArrayList<ResolveResult>();
        for (PsiFile f : fileList) {
            results.add(new PsiElementResolveResult(f));
        }
        return results.toArray(new ResolveResult[0]);
    }

    @Nullable
    @Override
    public PsiElement resolve() {
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
        return "ImportReference(" + this.importPath + ", " + getRangeInElement() + ")";
    }
}
