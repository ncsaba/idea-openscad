package com.javampire.openscad.psi.impl;

import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.lang.ASTNode;
import com.intellij.navigation.ItemPresentation;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiReference;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.tree.TokenSet;
import com.intellij.psi.util.PsiTreeUtil;
import com.intellij.util.IncorrectOperationException;
import com.intellij.util.PlatformIcons;
import com.javampire.openscad.OpenSCADIcons;
import com.javampire.openscad.parser.OpenSCADParserDefinition;
import com.javampire.openscad.psi.OpenSCADNamedElement;
import com.javampire.openscad.psi.OpenSCADTypes;
import com.javampire.openscad.psi.OpenSCADVariableDeclaration;
import com.javampire.openscad.psi.stub.OpenSCADVariableStubElementType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class OpenSCADPsiImplUtil {

    private static final Logger LOG = Logger.getInstance("#com.javampire.openscad.psi.impl.OpenSCADPsiImplUtil");

    private static Pattern MULTILINE_PATTERN = Pattern.compile("\\R");

    public static ItemPresentation getPresentation(@NotNull final PsiElement element) {
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

    public static PsiElement setName(@NotNull PsiElement element, String newName) {
        if (OpenSCADParserDefinition.NON_RENAMABLE_ELEMENTS.contains(element.getNode().getElementType())) {
            throw new IncorrectOperationException("Builtin functions/modules can't be renamed");
        }
        return element;
    }

    public static PsiElement getNameIdentifier(@NotNull PsiElement element) {
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
        LOG.debug("Unhandled reference element: " + element);
        return null;
    }

    /**
     * Builds the declaration of a module or a function, consisting of name + argument list
     *
     * @param element a module or a function
     * @return name(arg1, ...)
     */
    public static String getNameWithArgumentList(@NotNull OpenSCADNamedElement element, boolean shortForm) {
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

    private static boolean isMultiLine(@NotNull PsiElement element) {
        return MULTILINE_PATTERN.matcher(element.getText()).find();
    }

    @Nullable
    public static String getDocString(@Nullable PsiElement element) {
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
        if (text == null && !isMultiLine(element)) {
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


    /**
     * Recursively get all variables declaration accessible to element, i.e. before element and before its parents.
     *
     * @param element Element for which accessible variables will be returned.
     * @return List of accessible variable declarations.
     */
    public static List<OpenSCADVariableDeclaration> getAccessibleVariableDeclaration(@NotNull final PsiElement element) {
        final PsiElement parent = element.getParent();

        // Get parent accessible variables if any
        List<OpenSCADVariableDeclaration> variableDeclarationsInParent = (parent == null || parent instanceof PsiFileBase) ? new ArrayList<>() : getAccessibleVariableDeclaration(parent);

        // Loop from first sibling to element (variables declared after elements are not accessible)
        if (parent != null) {
            for (PsiElement sibling = parent.getFirstChild(); sibling != null && sibling != element; sibling = sibling.getNextSibling()) {
                if (sibling.getNode().getElementType() == OpenSCADVariableStubElementType.INSTANCE) {
                    variableDeclarationsInParent.add((OpenSCADVariableDeclaration) sibling);
                }
            }
        }

        return variableDeclarationsInParent;
    }

    /**
     * Recursively get all parents of types elementTypes.
     *
     * @param element      Element for which matching parents will be returned.
     * @param elementTypes Allowed parent types.
     * @return List of matching parents.
     */
    public static List<PsiElement> getParentsOfType(@Nullable PsiElement element, @NotNull TokenSet elementTypes) {
        List<PsiElement> matchingParents = new ArrayList<>();
        if (element != null && !(element instanceof PsiFileBase)) {
            element = element.getParent();
        }
        while (element != null) {
            if (elementTypes.contains(element.getNode().getElementType())) {
                matchingParents.add(element);
            }
            element = element.getParent();
        }
        return matchingParents;
    }

}
