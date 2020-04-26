package com.javampire.openscad.color;

import com.intellij.openapi.editor.ElementColorProvider;
import com.intellij.psi.PsiElement;
import com.intellij.ui.JBColor;
import com.javampire.openscad.psi.OpenSCADTypes;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.awt.Color;

class OpenSCADColorProvider implements ElementColorProvider {

    @Nullable
    @Override
    public Color getColorFrom(@NotNull PsiElement element) {
        if (element.getNode().getElementType() == OpenSCADTypes.STRING_LITERAL) {
            final String text = element.getText();
            return JBColor.decode(text.substring(1, text.length() - 1));
        }

        return null;
    }

    @Override
    public void setColorTo(@NotNull PsiElement element, @NotNull Color color) {
    }
}
