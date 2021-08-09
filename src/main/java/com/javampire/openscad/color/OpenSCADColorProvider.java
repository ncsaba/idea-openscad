package com.javampire.openscad.color;

import com.intellij.openapi.editor.ElementColorProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFileFactory;
import com.intellij.psi.util.PsiTreeUtil;
import com.intellij.xml.util.ColorMap;
import com.javampire.openscad.OpenSCADFileType;
import com.javampire.openscad.psi.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.awt.*;
import java.util.List;

class OpenSCADColorProvider implements ElementColorProvider {

    @Nullable
    @Override
    public Color getColorFrom(@NotNull PsiElement element) {
        if ("color".equals(element.getText()) && element.getNode().getElementType() == OpenSCADTypes.IDENTIFIER) {
            final PsiElement grandParentBlock = element.getParent().getParent();
            if (grandParentBlock instanceof OpenSCADBuiltinOp) {
                final OpenSCADBuiltinOp colorBlock = (OpenSCADBuiltinOp) grandParentBlock;
                String colorDef = null;
                final List<OpenSCADArgAssignment> assignmentList = colorBlock.getArgAssignmentList().getArgAssignmentList();
                if (assignmentList.size() > 0) {
                    // Testing if first element is a parameter reference ("c" of "alpha")
                    PsiElement colorDefElement = assignmentList.get(0).getFirstChild();
                    if (colorDefElement instanceof OpenSCADParameterReference) {
                        colorDefElement = getColorFromParameterReferencedAssignment(assignmentList);
                    }

                    if (colorDefElement instanceof OpenSCADLiteralExpr && colorDefElement.getFirstChild().getNode().getElementType() == OpenSCADTypes.STRING_LITERAL) {
                        colorDef = getColorFromLiteralExpr((OpenSCADLiteralExpr) colorDefElement);
                    } else if (colorDefElement instanceof OpenSCADVectorExpr) {
                        // Specific openscad case, RGB are given as float values, converting them as hexa
                        colorDef = getColorFromVectorDef((OpenSCADVectorExpr) colorDefElement);
                    }
                }

                if (colorDef != null) {
                    // Standard hexadecimal or string color definition
                    return ColorMap.getColor(colorDef);
                }
            }
        }
        return null;
    }

    private PsiElement getColorFromParameterReferencedAssignment(final List<OpenSCADArgAssignment> assignmentList) {
        // Searching for assignment with "c" as parameter reference
        for (final OpenSCADArgAssignment assignment : assignmentList) {
            if ("c".equals(assignment.getFirstChild().getText())) {
                return assignment.getLastChild();
            }
        }
        return null;
    }

    private String getColorFromLiteralExpr(final OpenSCADLiteralExpr element) {
        String colorDef = element.getText();
        return colorDef.substring(1, colorDef.length() - 1);
    }

    private String getColorFromVectorDef(final OpenSCADVectorExpr colorVectorExp) {
        StringBuilder hexaValue = new StringBuilder("#");
        for (PsiElement child : colorVectorExp.getChildren()) {
            if (child instanceof OpenSCADDivExpr) {
                final String colorValue = child.getFirstChild().getText();
                try {
                    hexaValue.append(Integer.toHexString(Integer.parseInt(colorValue)));
                } catch (NumberFormatException ignored) {
                    // Not a simple fraction, might be an expression, dropping it
                    return null;
                }
            }
        }
        return hexaValue.toString();
    }

    @Override
    public void setColorTo(@NotNull PsiElement element, @NotNull Color color) {
        final OpenSCADBuiltinOp colorBlock = (OpenSCADBuiltinOp) element.getParent().getParent();
        final List<OpenSCADArgAssignment> assignmentList = colorBlock.getArgAssignmentList().getArgAssignmentList();

        // Testing if first element is a parameter reference ("c" of "alpha")
        PsiElement colorDefElement = assignmentList.get(0).getFirstChild();
        if (colorDefElement instanceof OpenSCADParameterReference) {
            colorDefElement = getColorFromParameterReferencedAssignment(assignmentList);
        }
        assert colorDefElement != null;

        if (colorDefElement instanceof OpenSCADVectorExpr) {
            final OpenSCADDivExpr[] divElements = PsiTreeUtil.getChildrenOfType(colorDefElement, OpenSCADDivExpr.class);
            if (divElements != null && divElements.length == 3) {
                divElements[0].getFirstChild().replace(getColorIntLitteral(colorDefElement, color.getRed()));
                divElements[1].getFirstChild().replace(getColorIntLitteral(colorDefElement, color.getGreen()));
                divElements[2].getFirstChild().replace(getColorIntLitteral(colorDefElement, color.getBlue()));
            }
        } else {
            colorDefElement.getFirstChild().replace(getColorStringLitteral(colorDefElement, color));
        }
    }

    private PsiElement getColorStringLitteral(PsiElement element, Color color) {
        final String newColorHex = String.format("%02x%02x%02x", color.getRed(), color.getGreen(), color.getBlue());
        final String newText = "color(\"#" + newColorHex + "\");";
        return PsiFileFactory.getInstance(element.getProject())
                .createFileFromText(newColorHex, OpenSCADFileType.INSTANCE, newText)
                .getFirstChild()
                .getFirstChild()
                .getLastChild()
                .getFirstChild()
                .getNextSibling()
                .getFirstChild()
                .getFirstChild();
    }

    private PsiElement getColorIntLitteral(PsiElement element, int colorValue) {
        PsiElement returnElement = PsiFileFactory.getInstance(element.getProject())
                .createFileFromText(String.valueOf(colorValue), OpenSCADFileType.INSTANCE, "a = " + colorValue + ";")
                .getFirstChild();

        returnElement = PsiTreeUtil.findChildOfType(returnElement, OpenSCADLiteralExpr.class);
        assert returnElement != null;
        return returnElement.getFirstChild();
    }
}
