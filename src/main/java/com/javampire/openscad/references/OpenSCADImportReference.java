package com.javampire.openscad.references;

import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.module.ModuleUtil;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.*;
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
        List<PsiFile> fileList;
        if (module != null) {
            // If it is an external library
            fileList = OpenSCADResolver.findModuleLibrary(module, importPath);
            if (fileList.isEmpty()) {
                // If not, might be inner module file
                fileList = OpenSCADResolver.findModuleContentFile(module, importPath);
            }
        } else {
            // If it is an external library
            fileList = OpenSCADResolver.findProjectLibrary(myElement.getProject(), importPath);
            if (fileList.isEmpty()) {
                // If not, might be inner module file
                fileList = OpenSCADResolver.findProjectContentFile(myElement.getProject(), importPath);
            }
        }
        final List<ResolveResult> results = new ArrayList<>();
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

    @Override
    public String toString() {
        return "ImportReference(" + this.importPath + ", " + getRangeInElement() + ")";
    }
}
