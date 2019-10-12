package com.javampire.openscad.editor;

import com.intellij.lang.ASTNode;
import com.intellij.lang.folding.FoldingBuilderEx;
import com.intellij.lang.folding.FoldingDescriptor;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.tree.TokenSet;
import com.javampire.openscad.psi.OpenSCADTypes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.javampire.openscad.parser.OpenSCADParserDefinition.IMPORT_FOLDING_TOKENS;
import static com.javampire.openscad.parser.OpenSCADParserDefinition.LINE_COMMENT_TOKENS;

public class OpenSCADFoldingBuilder extends FoldingBuilderEx {
    @NotNull
    @Override
    public FoldingDescriptor[] buildFoldRegions(@NotNull PsiElement root, @NotNull Document document, boolean quick) {
        List<FoldingDescriptor> descriptors = new ArrayList<FoldingDescriptor>();
        addFoldsForElement(descriptors, root, document, quick);
        return descriptors.toArray(new FoldingDescriptor[descriptors.size()]);
    }

    @Nullable
    @Override
    public String getPlaceholderText(@NotNull ASTNode node) {
        return "...";
    }

    @Override
    public boolean isCollapsedByDefault(@NotNull ASTNode node) {
        return false;
    }

    private static PsiElement addFoldsForElement(@NotNull List<FoldingDescriptor> list,
                                                 @NotNull PsiElement element,
                                                 @NotNull Document document,
                                                 boolean quick) {
        ASTNode node = element.getNode();
        if (node == null) {
            return element;
        }
        if (node.getElementType() == OpenSCADTypes.END_OF_LINE_COMMENT) {
            return addFoldsForStatementBlock(list, element, document, LINE_COMMENT_TOKENS, "//...");
        }
        if (IMPORT_FOLDING_TOKENS.contains(node.getElementType())) {
            return addFoldsForStatementBlock(list, element, document, IMPORT_FOLDING_TOKENS, "include/use <...>");
        }
        if (node.getElementType() == OpenSCADTypes.BLOCK_OBJ) {
            foldIfMultiLine(list, element, document, "{...}");
        } else if (node.getElementType() == OpenSCADTypes.C_STYLE_COMMENT) {
            foldIfMultiLine(list, element, document, "/* ... */");
            return element;
        } else if (node.getElementType() == OpenSCADTypes.DOC_COMMENT) {
            foldIfMultiLine(list, element, document, "/** ... */");
            return element;
        } else if (node.getElementType() == OpenSCADTypes.BLOCK_COMMENT) {
            foldIfMultiLine(list, element, document, "//...");
            return element;
        } else {
            PsiElement firstChild = element.getFirstChild();
            if (firstChild != null) {
                final ASTNode childNode = firstChild.getNode();
                // fold all multi-line elements which start a parenthesis/bracket
                if (childNode != null) {
                    final IElementType childElementType = childNode.getElementType();
                    if (childElementType == OpenSCADTypes.LPARENTH) {
                        foldIfMultiLine(list, element, document, "(...)");
                    } else if (childElementType == OpenSCADTypes.LBRACKET) {
                        foldIfMultiLine(list, element, document, "[...]");
                    }
                }
            }
        }
        PsiElement[] children = element.getChildren();
        if (children.length > 0) {
            for (PsiElement current = element.getFirstChild(); current != null; current = current.getNextSibling()) {
                current = addFoldsForElement(list, current, document, quick);
            }
        }
        return element;
    }

    /**
     * We want to allow to fold subsequent single line comments like
     * <pre>
     *     // this is comment line 1
     *     // this is comment line 2
     * </pre>
     * <p>
     * This method is also used to fold include and use statements.
     *
     * @param list    fold descriptors holder to store newly created descriptor (if any)
     * @param element element to check
     * @return the last element processed (possibly the same as the original one)
     */
    private static PsiElement addFoldsForStatementBlock(@NotNull List<FoldingDescriptor> list,
                                                        @NotNull PsiElement element,
                                                        @NotNull Document document,
                                                        @NotNull TokenSet allowedTokens,
                                                        @NotNull String placeHolderText) {
        ASTNode node = element.getNode();
        if (node == null) {
            return element;
        }
        PsiElement end = null;
        PsiElement last = element;
        for (PsiElement current = element.getNextSibling(); current != null; current = current.getNextSibling()) {
            node = current.getNode();
            if (node == null) {
                break;
            }
            IElementType elementType = node.getElementType();
            if (allowedTokens.contains(elementType)) {
                end = current;
                last = current;
            } else if (elementType != TokenType.WHITE_SPACE) {
                break;
            }
        }
        if (end != null) {
            final int startOffset = element.getTextRange().getStartOffset();
            final int endOffset = end.getTextRange().getEndOffset();
            final boolean isMultiLine = document.getLineNumber(startOffset) != document.getLineNumber(endOffset);
            if (isMultiLine) {
                list.add(
                        new FoldingDescriptor(
                                element.getNode(),
                                new TextRange(startOffset, endOffset),
                                null,
                                placeHolderText,
                                false,
                                Collections.emptySet()
                        )
                );
            }
        }
        return last;
    }

    private static void foldIfMultiLine(@NotNull List<FoldingDescriptor> list,
                                        @NotNull PsiElement element,
                                        @NotNull Document document,
                                        @NotNull String placeHolderText) {
        final int startOffset = element.getTextRange().getStartOffset();
        final int endOffset = element.getTextRange().getEndOffset();
        boolean multiLine = document.getLineNumber(startOffset) != document.getLineNumber(endOffset);
        if (multiLine) {
            list.add(
                    new FoldingDescriptor(
                            element.getNode(),
                            new TextRange(startOffset, endOffset),
                            null,
                            placeHolderText,
                            false,
                            Collections.emptySet()
                    )
            );
        }
    }
}
