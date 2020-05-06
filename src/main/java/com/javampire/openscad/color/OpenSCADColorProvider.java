package com.javampire.openscad.color;

import com.intellij.openapi.editor.ElementColorProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFileFactory;
import com.intellij.psi.util.PsiTreeUtil;
import com.intellij.xml.util.ColorMap;
import com.javampire.openscad.OpenSCADFileType;
import com.javampire.openscad.psi.OpenSCADTypes;
import com.javampire.openscad.psi.impl.OpenSCADBuiltinObjImpl;
import com.javampire.openscad.psi.impl.OpenSCADBuiltinOpImpl;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.awt.Color;

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
        if (element.getNode().getElementType() == OpenSCADTypes.STRING_LITERAL) {
            final PsiElement colorBlockWithBody = PsiTreeUtil.getParentOfType(element, OpenSCADBuiltinObjImpl.class);
            if (colorBlockWithBody != null) {
                final String newText = createColorHex(color) + colorBlockWithBody.getChildren()[1].getText();

                final PsiElement newElement = PsiFileFactory.getInstance(element.getProject())
                        .createFileFromText("tmp.scad", OpenSCADFileType.INSTANCE, newText).getFirstChild();
                colorBlockWithBody.replace(newElement);
            }
        }
    }

    private String createColorHex(Color color) {
        return String.format("color(\"#%02x%02x%02x\")", color.getRed(), color.getGreen(), color.getBlue());
    }
}
