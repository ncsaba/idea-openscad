package com.javampire.openscad.formatter;

import com.intellij.formatting.FormattingModel;
import com.intellij.formatting.FormattingModelBuilder;
import com.intellij.formatting.Indent;
import com.intellij.lang.ASTNode;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.util.TextRange;
import com.intellij.openapi.util.registry.Registry;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiRecursiveElementVisitor;
import com.intellij.psi.codeStyle.CodeStyleSettings;
import com.intellij.psi.codeStyle.CommonCodeStyleSettings;
import com.intellij.psi.formatter.DocumentBasedFormattingModel;
import com.intellij.psi.formatter.FormattingDocumentModelImpl;
import com.intellij.psi.formatter.PsiBasedFormattingModel;
import com.javampire.openscad.OpenSCADLanguage;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class OpenSCADFormattingModelBuilder implements FormattingModelBuilder {
    private static final Logger LOG = Logger.getInstance("#com.javampire.openscad.formatter.OpenSCADFormattingModelBuilder");

    @NotNull
    @Override
    public FormattingModel createModel(PsiElement element, CodeStyleSettings settings) {
        LOG.info("In createModel");
        ASTNode node = element.getNode();
        LOG.info("node : " + node.toString());
        assert node != null;
        PsiFile containingFile = element.getContainingFile().getViewProvider().getPsi(OpenSCADLanguage.INSTANCE);
        LOG.info("containingFile : " + containingFile.toString());
        assert containingFile != null : element.getContainingFile();
        ASTNode astNode = containingFile.getNode();
        LOG.info("astNode : " + astNode.toString());
        assert astNode != null;
        CommonCodeStyleSettings openSCADSettings = settings.getCommonSettings(OpenSCADLanguage.INSTANCE);
        LOG.info("commonSettings : " + openSCADSettings.toString());
        OpenSCADCodeStyleSettings customSettings = settings.getCustomSettings(OpenSCADCodeStyleSettings.class);
        LOG.info("customSettings : " + customSettings.toString());

        /*final OpenSCADBlock block = new OpenSCADBlock(astNode, Indent.getAbsoluteNoneIndent(), null, new FormattingContext(openSCADSettings, new AlignmentProvider(), customSettings, false));
        return new PsiBasedFormattingModel(containingFile, block, FormattingDocumentModelImpl.createOn(containingFile));*/
        return null;
    }
}
