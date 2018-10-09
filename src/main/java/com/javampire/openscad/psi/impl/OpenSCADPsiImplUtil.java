package com.javampire.openscad.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.navigation.ItemPresentation;
import com.intellij.psi.PsiElement;
import com.javampire.openscad.OpenSCADIcons;
import com.javampire.openscad.OpenSCADParserDefinition;
import com.javampire.openscad.psi.*;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class OpenSCADPsiImplUtil {

    public static ItemPresentation getPresentation(final PsiElement element) {
        return new ItemPresentation() {
            @Nullable
            @Override
            public String getPresentableText() {
                if (OpenSCADParserDefinition.NAMED_ELEMENTS.contains(element.getNode().getElementType())) {
                    final ASTNode nameNode = element.getNode().findChildByType(OpenSCADTypes.IDENTIFIER);
                    if (nameNode != null) {
                        return nameNode.getText();
                    } else {
                        return "Unnamed module/function";
                    }
                }
                if (element instanceof OpenSCADUseItem || element instanceof OpenSCADIncludeItem) {
                    final ASTNode pathNode = element.getNode().findChildByType(OpenSCADTypes.INCLUDE_PATH);
                    if (pathNode != null) {
                        return pathNode.getText().replaceAll("^.*/([^/]*)$", "$1");
                    } else {
                        return "Empty import";
                    }
                }
                return "Unknown element";
            }

            @Nullable
            @Override
            public String getLocationString() {
                return element.getContainingFile().getName();
            }

            @Nullable
            @Override
            public Icon getIcon(boolean unused) {
                if (element instanceof OpenSCADModuleDeclaration) {
                    return OpenSCADIcons.MODULE;
                }
                if (element instanceof OpenSCADFunctionDeclaration) {
                    return OpenSCADIcons.FUNCTION;
                }
                return OpenSCADIcons.FILE;
            }
        };
    }

}
