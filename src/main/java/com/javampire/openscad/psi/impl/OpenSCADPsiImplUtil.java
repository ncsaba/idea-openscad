package com.javampire.openscad.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.navigation.ItemPresentation;
import com.intellij.psi.PsiElement;
import com.javampire.openscad.OpenSCADIcons;
import com.javampire.openscad.OpenSCADParserDefinition;
import com.javampire.openscad.psi.OpenSCADFunctionDeclaration;
import com.javampire.openscad.psi.OpenSCADModuleDeclaration;
import com.javampire.openscad.psi.OpenSCADTypes;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class OpenSCADPsiImplUtil {

    public static ItemPresentation getPresentation(final PsiElement element) {
        return new ItemPresentation() {
            @Nullable
            @Override
            public String getPresentableText() {
                if (OpenSCADParserDefinition.NAMED_ELEMENTS.contains(element.getNode().getElementType())) {
                    ASTNode nameNode = element.getNode().findChildByType(OpenSCADTypes.IDENTIFIER);
                    if (nameNode != null) {
                        return nameNode.getText();
                    } else {
                        return "Unnamed module/function";
                    }
                }
                return "Unknown element"; // element.getKey();
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
