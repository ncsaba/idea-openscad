package com.javampire.openscad.formatter;

import com.intellij.formatting.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.TokenType;
import com.intellij.psi.codeStyle.CommonCodeStyleSettings;
import com.intellij.psi.formatter.common.AbstractBlock;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

import static com.javampire.openscad.psi.OpenSCADTypes.BLOCK_OBJ;

public class OpenSCADBlock extends AbstractBlock {

    private final OpenSCADIndentBuilder myOpenSCADIndentBuilder;
    private final CommonCodeStyleSettings mySettings;
    private final SpacingBuilder mySpacingBuilder;

    protected OpenSCADBlock(@NotNull ASTNode node,
                            @Nullable Alignment alignment,
                            @Nullable Wrap wrap,
                            @NotNull CommonCodeStyleSettings settings,
                            @NotNull SpacingBuilder spacingBuilder,
                            @NotNull OpenSCADIndentBuilder openSCADIndentBuilder) {
        super(node, wrap, alignment);
        mySettings = settings;
        mySpacingBuilder = spacingBuilder;
        myOpenSCADIndentBuilder = openSCADIndentBuilder;
    }

    @Override
    public Indent getIndent() {
        return myOpenSCADIndentBuilder.getChildIndent(myNode);
    }

    @Override
    protected List<Block> buildChildren() {
        List<Block> blocks = new ArrayList<Block>();
        for (ASTNode child = myNode.getFirstChildNode(); child != null; child = child.getTreeNext()) {
            // Filtering blank and empty elements
            if (child.getElementType() != TokenType.WHITE_SPACE && child.getTextRange().getLength() > 0) {
                blocks.add(new OpenSCADBlock(child, null, myWrap, mySettings, mySpacingBuilder, myOpenSCADIndentBuilder));
            }
        }
        return blocks;
    }

    @Nullable
    @Override
    public Spacing getSpacing(@Nullable Block child1, @NotNull Block child2) {
        return mySpacingBuilder.getSpacing(this, child1, child2);
    }

    @Override
    public boolean isLeaf() {
        return myNode.getFirstChildNode() == null;
    }

    @NotNull
    @Override
    public ChildAttributes getChildAttributes(int newChildIndex) {
        if (myNode.getElementType() == BLOCK_OBJ) {
            return new ChildAttributes(Indent.getNormalIndent(), null);
        } else {
            return new ChildAttributes(Indent.getNoneIndent(), null);
        }
    }
}
