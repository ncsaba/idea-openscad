package com.javampire.openscad.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.navigation.ItemPresentation;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiReference;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.util.PsiTreeUtil;
import com.intellij.util.PlatformIcons;
import com.javampire.openscad.OpenSCADIcons;
import com.javampire.openscad.parser.OpenSCADParserDefinition;
import com.javampire.openscad.psi.*;
import com.javampire.openscad.references.OpenSCADFunctionReference;
import com.javampire.openscad.references.OpenSCADModuleReference;
import com.javampire.openscad.references.OpenSCADVariableReference;
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
                    final ASTNode pathNode = element.getNode().findChildByType(OpenSCADTypes.INCLUDE_PATH);
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

    public static String getName(final PsiElement element) {
        if (OpenSCADParserDefinition.NAMED_ELEMENTS.contains(element.getNode().getElementType())) {
            final ASTNode nameNode = element.getNode().findChildByType(OpenSCADTypes.IDENTIFIER);
            if (nameNode != null) {
                return nameNode.getText();
            }
        } else if (element.getNode().getElementType() == OpenSCADTypes.QUALIFICATION_EXPR) {
            final ASTNode nameNode = element.getNode().getLastChildNode();
            if (nameNode != null && nameNode.getElementType() == OpenSCADTypes.IDENTIFIER) {
                return nameNode.getText();
            }
        }
        return null;
    }

    public static PsiElement setName(PsiElement element, String newName) {
        if (OpenSCADParserDefinition.NON_RENAMABLE_ELEMENTS.contains(element.getNode().getElementType())) {
            // Builtin functions/modules can't be renamed
            return element;
        } else if (OpenSCADParserDefinition.NAMED_ELEMENTS.contains(element.getNode().getElementType())) {
            final ASTNode nameNode = element.getNode().findChildByType(OpenSCADTypes.IDENTIFIER);
            if (nameNode != null) {
                PsiElement newNameElement = OpenSCADElementFactory.createIdentifier(element.getProject(), newName);
                element.getNode().replaceChild(nameNode, newNameElement.getNode());
            }
        } else if (element.getNode().getElementType() == OpenSCADTypes.QUALIFICATION_EXPR) {
            final ASTNode nameNode = element.getNode().getLastChildNode();
            if (nameNode != null && nameNode.getElementType() == OpenSCADTypes.IDENTIFIER) {
                PsiElement newNameElement = OpenSCADElementFactory.createIdentifier(element.getProject(), newName);
                element.getNode().replaceChild(nameNode, newNameElement.getNode());
            }
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
        // TODO: implement variable/parameter references
        // TODO: implement import references
        PsiReference ref;
        if (element instanceof OpenSCADNamedElement) {
            final String name = ((OpenSCADNamedElement) element).getName();
            if (name != null) {
                if (element instanceof OpenSCADModuleObjNameRef || element instanceof OpenSCADModuleOpNameRef) {
                    ref = new OpenSCADModuleReference((OpenSCADNamedElement) element, new TextRange(0, element.getTextLength()));
                    return ref;
                } else if (element instanceof OpenSCADFunctionNameRef) {
                    ref = new OpenSCADFunctionReference((OpenSCADNamedElement) element, new TextRange(0, element.getTextLength()));
                    return ref;
                } else if (element instanceof OpenSCADVariableRefExpr) {
                    ref = new OpenSCADVariableReference((OpenSCADNamedElement) element, new TextRange(0, element.getTextLength()));
                    return ref;
                } else if (element instanceof OpenSCADBuiltinExprRef) {
                    ref = new OpenSCADFunctionReference((OpenSCADNamedElement) element, new TextRange(0, element.getTextLength()));
                    return ref;
                } else if (element instanceof OpenSCADBuiltinObjRef) {
                    ref = new OpenSCADModuleReference((OpenSCADNamedElement) element, new TextRange(0, element.getTextLength()));
                    return ref;
                } else if (element instanceof OpenSCADCommonOpRef) {
                    ref = new OpenSCADModuleReference((OpenSCADNamedElement) element, new TextRange(0, element.getTextLength()));
                    return ref;
                } else {
                    LOG.warn("getReference(not handled named element of type " + element.getClass().getName() + "): " + name);
                }
            } else {
                LOG.warn("getReference(named element of type " + element.getClass().getName() + "): null name");
            }
        } else {
            LOG.warn(element + "(no getName)");
        }
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
