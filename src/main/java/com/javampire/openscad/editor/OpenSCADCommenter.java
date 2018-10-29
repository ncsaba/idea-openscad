package com.javampire.openscad.editor;

import com.intellij.lang.CodeDocumentationAwareCommenterEx;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.psi.PsiComment;
import com.intellij.psi.PsiElement;
import com.intellij.psi.tree.IElementType;
import com.javampire.openscad.psi.OpenSCADTypes;
import org.jetbrains.annotations.Nullable;

public class OpenSCADCommenter implements CodeDocumentationAwareCommenterEx {

    private static final Logger LOG = Logger.getInstance("#com.javampire.openscad.OpenSCADCommenter");

    @Override
    public String getLineCommentPrefix() {
        return "//";
    }

    @Override
    public String getBlockCommentPrefix() {
        return "/*";
    }

    @Override
    public String getBlockCommentSuffix() {
        return "*/";
    }

    @Override
    public String getCommentedBlockCommentPrefix() {
        return null;
    }

    @Override
    public String getCommentedBlockCommentSuffix() {
        return null;
    }

    @Override
    @Nullable
    public IElementType getLineCommentTokenType() {
        return OpenSCADTypes.END_OF_LINE_COMMENT;
    }

    @Override
    @Nullable
    public IElementType getBlockCommentTokenType() {
        return OpenSCADTypes.C_STYLE_COMMENT;
    }

    @Override
    @Nullable
    public IElementType getDocumentationCommentTokenType() {
        return OpenSCADTypes.DOC_COMMENT;
    }

    @Override
    public String getDocumentationCommentPrefix() {
        return "/**";
    }

    @Override
    public String getDocumentationCommentLinePrefix() {
        return "*";
    }

    @Override
    public String getDocumentationCommentSuffix() {
        return "*/";
    }

    @Override
    public boolean isDocumentationComment(final PsiComment element) {
        LOG.info("isDocumentationComment called with: " + element);
        return false;
    }

    @Override
    public boolean isDocumentationCommentText(final PsiElement element) {
        LOG.info("isDocumentationCommentText called with: " + element);
        return false;
    }
}
