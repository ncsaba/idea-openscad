package com.javampire.openscad.formatter;

import com.intellij.formatting.Indent;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.IElementType;

import static com.javampire.openscad.parser.OpenSCADParserDefinition.BRACES_TOKENS;
import static com.javampire.openscad.psi.OpenSCADTypes.*;

public class OpenSCADIndentBuilder {

    public Indent getChildIndent(ASTNode node) {
        IElementType elementType = node.getElementType();
        ASTNode parent = node.getTreeParent();

        // Parent node early exit
        if (parent == null || parent.getTreeParent() == null) {
            return Indent.getNoneIndent();
        }
        IElementType parentType = parent.getElementType();

        if (parentType == BLOCK_OBJ && !BRACES_TOKENS.contains(elementType)) { // Indent all BLOCK_OBJ (surrounded by brackets) children by default
            return Indent.getNormalIndent();
        } else if (parentType == BUILTIN_OBJ && elementType != BUILTIN_OP && elementType != BUILTIN_OBJ_REF) { // Indent statements in BUILTIN_OBJ without brackets
            return Indent.getNormalIndent();
        } else if (parentType == IF_OBJ && (elementType == BUILTIN_OBJ || elementType == FOR_OBJ)) { // Indent statements in IF_OBJ without brackets
            return Indent.getNormalIndent();
        }

        return Indent.getNoneIndent();
    }
}
