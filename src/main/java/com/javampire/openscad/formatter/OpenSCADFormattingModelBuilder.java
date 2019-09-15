package com.javampire.openscad.formatter;

import com.intellij.formatting.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.codeStyle.CodeStyleSettings;
import com.intellij.psi.codeStyle.CommonCodeStyleSettings;
import com.javampire.openscad.OpenSCADLanguage;
import org.jetbrains.annotations.NotNull;

import static com.javampire.openscad.parser.OpenSCADParserDefinition.*;


public class OpenSCADFormattingModelBuilder implements FormattingModelBuilder {


    @NotNull
    @Override
    public FormattingModel createModel(PsiElement element, CodeStyleSettings settings) {

        PsiFile containingFile = element.getContainingFile().getViewProvider().getPsi(OpenSCADLanguage.INSTANCE);
        ASTNode astNode = containingFile.getNode();
        CommonCodeStyleSettings openSCADSettings = settings.getCommonSettings(OpenSCADLanguage.INSTANCE);

        final OpenSCADBlock fileBlock = new OpenSCADBlock(
                astNode,
                null,
                Wrap.createWrap(WrapType.NONE, false),
                openSCADSettings,
                createSpacingBuilder(openSCADSettings),
                new OpenSCADIndentBuilder());
        return FormattingModelProvider.createFormattingModelForPsiFile(element.getContainingFile(), fileBlock, openSCADSettings.getRootSettings());
    }

    private SpacingBuilder createSpacingBuilder(CommonCodeStyleSettings settings) {
        // Configure spacing rules below
        return new SpacingBuilder(settings.getRootSettings(), OpenSCADLanguage.INSTANCE)
                .around(ONE_AROUND_SPACING_TOKENS).spaces(1)
                .before(ONE_BEFORE_SPACING_TOKENS).spaces(1)
                .after(ONE_AFTER_SPACING_TOKENS).spaces(1)
                .before(NONE_BEFORE_SPACING_TOKENS).none()
                .after(NONE_AFTER_SPACING_TOKENS).none()
                ;
    }
}
