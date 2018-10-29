package com.javampire.openscad.documentation;

import com.intellij.lang.documentation.AbstractDocumentationProvider;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.editor.Editor;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.javampire.openscad.psi.OpenSCADFunctionDeclaration;
import com.javampire.openscad.psi.OpenSCADModuleDeclaration;
import com.javampire.openscad.psi.OpenSCADNamedElement;
import com.javampire.openscad.psi.impl.OpenSCADPsiImplUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class OpenSCADDocumentationProvider extends AbstractDocumentationProvider {

    private static final Logger LOG = Logger.getInstance("#com.javampire.openscad.OpenSCADDocumentationProvider");

    @Nullable
    @Override
    public PsiElement getCustomDocumentationElement(
            @NotNull Editor editor, @NotNull PsiFile file, @Nullable PsiElement contextElement
    ) {
        LOG.debug("getCustomDocumentationElement called with: " + contextElement);
        // return super.getCustomDocumentationElement(editor, file, contextElement);
        return contextElement;
    }

    @Override
    public String generateDoc(PsiElement element, @Nullable PsiElement originalElement) {
        LOG.debug("generateDoc called with: " + element + ", " + originalElement);
        return OpenSCADPsiImplUtil.getDocString(element);
    }

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
