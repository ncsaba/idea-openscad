package com.javampire.openscad.color;

import com.intellij.lang.Language;
import com.intellij.openapi.command.CommandProcessor;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.ElementColorProvider;
import com.intellij.psi.PsiDocumentManager;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFileFactory;
import com.intellij.psi.util.PsiTreeUtil;
import com.intellij.xml.util.ColorMap;
import com.javampire.openscad.psi.OpenSCADTypes;
import com.javampire.openscad.psi.impl.OpenSCADBuiltinOpImpl;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.awt.Color;
import java.util.Objects;

class OpenSCADColorProvider implements ElementColorProvider {

    @Nullable
    @Override
    public Color getColorFrom(@NotNull PsiElement element) {
        if (element.getNode().getElementType() == OpenSCADTypes.STRING_LITERAL) {
            final PsiElement colorParent = PsiTreeUtil.getParentOfType(element, OpenSCADBuiltinOpImpl.class);
            if (colorParent != null && colorParent.getText().startsWith("color")) {
                final String colorDef = element.getText();
                return ColorMap.getColor(colorDef.substring(1, colorDef.length() - 1));
            }
        }
        return null;
    }

    @Override
    public void setColorTo(@NotNull PsiElement element, @NotNull Color color) {
        final Document document = PsiDocumentManager.getInstance(element.getProject()).getDocument(element.getContainingFile());
        Runnable command = null;
        if (element.getNode().getElementType() == OpenSCADTypes.STRING_LITERAL) {
            command = () -> {
                @NotNull final Language language = Objects.requireNonNull(Language.findLanguageByID("OpenSCAD"));

                final PsiElement newElement = PsiFileFactory.getInstance(element.getProject())
                        .createFileFromText(language, createColorHex(color)).getOriginalElement();

                element.replace(newElement);
            };
        }

        if (command != null) {
            CommandProcessor.getInstance()
                    .executeCommand(element.getProject(), command, "openscad.change.color.command.text", null, document);
        }
    }

    private String createColorHex(Color color) {
        return String.format("\"#%02x%02x%02x\"", color.getRed(), color.getGreen(), color.getBlue());
    }
}
