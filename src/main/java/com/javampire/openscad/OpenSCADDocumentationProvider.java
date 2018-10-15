package com.javampire.openscad;

import com.intellij.lang.documentation.AbstractDocumentationProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.javampire.openscad.psi.OpenSCADFunctionDeclaration;
import com.javampire.openscad.psi.OpenSCADModuleDeclaration;
import com.javampire.openscad.psi.OpenSCADNamedElement;
import com.javampire.openscad.psi.impl.OpenSCADPsiImplUtil;
import org.jetbrains.annotations.Nullable;

public class OpenSCADDocumentationProvider extends AbstractDocumentationProvider {

    @Override
    @Nullable
    public String getQuickNavigateInfo(PsiElement element, PsiElement originalElement) {
        if (element instanceof OpenSCADModuleDeclaration) {
            return getLocationString(element) + "\nmodule " +
                    OpenSCADPsiImplUtil.getNameWithArgumentList((OpenSCADNamedElement) element, true);
        } else if (element instanceof OpenSCADFunctionDeclaration) {
            return getLocationString(element) + "\nfunction " +
                    OpenSCADPsiImplUtil.getNameWithArgumentList((OpenSCADNamedElement) element, true);
        }
        return null;
    }

    private static String getLocationString(PsiElement element) {
        PsiFile file = element.getContainingFile();
        return file != null ? " [" + file.getName() + "]" : "";
    }

}
