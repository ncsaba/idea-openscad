package com.javampire.openscad.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.navigation.ItemPresentation;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiReference;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.util.PsiTreeUtil;
import com.intellij.util.IncorrectOperationException;
import com.intellij.util.PlatformIcons;
import com.javampire.openscad.OpenSCADIcons;
import com.javampire.openscad.parser.OpenSCADParserDefinition;
import com.javampire.openscad.psi.OpenSCADNamedElement;
import com.javampire.openscad.psi.OpenSCADTypes;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.util.regex.Pattern;

public class OpenSCADPsiImplUtil {

    private static final Logger LOG = Logger.getInstance("#com.javampire.openscad.psi.impl.OpenSCADPsiImplUtil");

    public static ItemPresentation getPresentation(final PsiElement element) {
        return new ItemPresentation() {
            @Nullable
            @Override
            public String getPresentableText() {
                if (OpenSCADParserDefinition.NAMED_ELEMENTS.contains(element.getNode().getElementType())) {
                    final ASTNode nameNode = element.getNode().findChildByType(OpenSCADTypes.IDENTIFIER);
                    if (nameNode != null) {
                        return nameNode.getText();
                    }
                } else if (OpenSCADParserDefinition.IMPORT_TOKENS.contains(element.getNode().getElementType())) {
                    final ASTNode pathNode = element.getNode().findChildByType(OpenSCADTypes.INCLUDE_PATH_REF);
                    if (pathNode != null) {
                        return pathNode.getText().replaceAll("^.*/([^/]*)$", "$1");
                    }
                }
                return null;
            }

            @Override
            public String getLocationString() {
                return element.getContainingFile().getName();
            }

            @Nullable
            @Override
            public Icon getIcon(boolean unused) {
                if (element.getNode().getElementType() == OpenSCADTypes.MODULE_DECLARATION) {
                    return OpenSCADIcons.MODULE;
                }
                if (element.getNode().getElementType() == OpenSCADTypes.FUNCTION_DECLARATION) {
                    return OpenSCADIcons.FUNCTION;
                }
                if (element.getNode().getElementType() == OpenSCADTypes.VARIABLE_DECLARATION) {
                    return PlatformIcons.VARIABLE_ICON;
                }
                if (OpenSCADParserDefinition.IMPORT_TOKENS.contains(element.getNode().getElementType())) {
                    return OpenSCADIcons.FILE;
                }
                return null;
            }
        };
    }

    public static PsiElement setName(PsiElement element, String newName) {
        if (OpenSCADParserDefinition.NON_RENAMABLE_ELEMENTS.contains(element.getNode().getElementType())) {
            throw new IncorrectOperationException("Builtin functions/modules can't be renamed");
        }
        return element;
    }

    public static PsiElement getNameIdentifier(PsiElement element) {
        if (OpenSCADParserDefinition.NAMED_ELEMENTS.contains(element.getNode().getElementType())) {
            final ASTNode nameNode = element.getNode().findChildByType(OpenSCADTypes.IDENTIFIER);
            if (nameNode != null) {
                return nameNode.getPsi();
            }
        } else if (element.getNode().getElementType() == OpenSCADTypes.QUALIFICATION_EXPR) {
            final ASTNode nameNode = element.getNode().getLastChildNode();
            if (nameNode != null && nameNode.getElementType() == OpenSCADTypes.IDENTIFIER) {
                return nameNode.getPsi();
            }
        }
        return null;
    }

    public static PsiReference getReference(PsiElement element) {
        // TODO: implement parameter references
        LOG.warn("Unhandled reference element in file: " + element.getContainingFile().getOriginalFile().getName() + ", offset: " + element.getTextOffset() + ". Element: " + element + ", text: " + element.getText());
        return null;
    }

    /**
     * Builds the declaration of a module or a function, consisting of name + argument list
     * @param element a module or a function
     * @return name(arg1, ...)
     */
    public static String getNameWithArgumentList(OpenSCADNamedElement element, boolean shortForm) {
        StringBuilder buf = new StringBuilder();
        buf.append(element.getName());
        final ASTNode argListNode = element.getNode().findChildByType(OpenSCADTypes.ARG_DECLARATION_LIST);
        if (argListNode == null) {
            buf.append("()");
        } else if (argListNode.getTextLength() > 100 && shortForm) {
            buf.append("(...)");
        } else {
            buf.append(argListNode.getText());
        }
        return buf.toString();
    }

    public static Pattern MULTILINE_PATTERN = Pattern.compile("\\R");

    public static boolean isMultiLine(PsiElement element) {
        return MULTILINE_PATTERN.matcher(element.getText()).find();
    }

    @Nullable
    public static String getDocString(PsiElement element) {
        if (element == null) {
            return null;
        }
        final ASTNode node = element.getNode();
        if (node == null) {
            return null;
        }
        if (OpenSCADParserDefinition.DOC_IN_PARENT.contains(node.getElementType())) {
            return getDocString(element.getParent());
        }
        final PsiReference reference = element.getReference();
        if (reference != null) {
            return getDocString(reference.resolve());
        }
        PsiElement docElement = PsiTreeUtil.skipWhitespacesBackward(element);
        if (docElement == null) {
            return null;
        }
        ASTNode docNode = docElement.getNode();
        if (docNode == null) {
            return null;
        }
        String text = docElement.getText();
        if (text == null) {
            return null;
        }
        IElementType docNodeElementType = docNode.getElementType();
        if (docNodeElementType == OpenSCADTypes.BLOCK_COMMENT) {
            text = text.replaceAll("(?sm)^\\s*//", "");
        } else if (docNodeElementType != OpenSCADTypes.DOC_COMMENT) {
            text = null;
        } else {
            text = text.replaceFirst("(?s)^\\s*/\\*\\*", "");
            text = text.replaceFirst("(?s)\\s*\\*/\\s*$", "");
            text = text.replaceAll("(?sm)^\\s*\\*", "");
        }
        // If there's no documentation comment placed before the element, and if the element
        // is on one line with an end of line comment, take that comment as documentation
        if (text == null && ! isMultiLine(element)) {
            final PsiElement nextComment = PsiTreeUtil.skipWhitespacesForward(element);
            if (nextComment == null) {
                return null;
            }
            final ASTNode commentNode = nextComment.getNode();
            if (commentNode == null) {
                return null;
            }
            if (commentNode.getElementType() == OpenSCADTypes.END_OF_LINE_COMMENT) {
                for (PsiElement wsElement : PsiTreeUtil.getElementsOfRange(element, nextComment)) {
                    if (isMultiLine(wsElement)) {
                        return null;
                    }
                }
                text = commentNode.getText();
                text = text.replaceAll("(?sm)^\\s*//", "");
            }
        }
        if (text != null) {
            text = text.replaceAll("<", "&lt;");
            text = text.replaceAll(">", "&gt;");
            text = "<pre>" + text + "</pre>";
        }
        LOG.debug("Help text: " + text);
        return text;
    }

}
