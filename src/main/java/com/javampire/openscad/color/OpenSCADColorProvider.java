package com.javampire.openscad.color;

import com.intellij.openapi.editor.ElementColorProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFileFactory;
import com.intellij.psi.util.PsiTreeUtil;
import com.intellij.xml.util.ColorMap;
import com.javampire.openscad.OpenSCADFileType;
import com.javampire.openscad.psi.OpenSCADTypes;
import com.javampire.openscad.psi.impl.OpenSCADBuiltinObjImpl;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.awt.Color;

class OpenSCADColorProvider implements ElementColorProvider {

    @Nullable
    @Override
    public Color getColorFrom(@NotNull PsiElement element) {
        final PsiElement fullColorBlock = getOpenSCADBuiltinObj(element);
        if (fullColorBlock != null) {
            final String colorDef = element.getText();
            return ColorMap.getColor(colorDef.substring(1, colorDef.length() - 1));
        }

        return null;
    }

    @Override
    public void setColorTo(@NotNull PsiElement element, @NotNull Color color) {
        final PsiElement fullColorBlock = getOpenSCADBuiltinObj(element);
        if (fullColorBlock != null) {
            final String newText = createColorHex(color) + fullColorBlock.getChildren()[1].getText();

            final PsiElement newElement = PsiFileFactory.getInstance(element.getProject())
                    .createFileFromText("tmp.scad", OpenSCADFileType.INSTANCE, newText).getFirstChild();
            fullColorBlock.replace(newElement);
        }
    }

    private OpenSCADBuiltinObjImpl getOpenSCADBuiltinObj(PsiElement element) {
        if (element.getNode().getElementType() == OpenSCADTypes.STRING_LITERAL) {
            final OpenSCADBuiltinObjImpl fullColorBlock = PsiTreeUtil.getParentOfType(element, OpenSCADBuiltinObjImpl.class);
            if (fullColorBlock != null && fullColorBlock.getText().startsWith("color")) {
                return fullColorBlock;
            }
        }
        return null;
    }

    private String createColorHex(Color color) {
        return String.format("color(\"#%02x%02x%02x\")", color.getRed(), color.getGreen(), color.getBlue());
    }
}
