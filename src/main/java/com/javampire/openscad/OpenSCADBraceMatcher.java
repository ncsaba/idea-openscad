package com.javampire.openscad;

import com.intellij.lang.BracePair;
import com.intellij.lang.PairedBraceMatcher;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IElementType;
import com.javampire.openscad.psi.OpenSCADTypes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class OpenSCADBraceMatcher implements PairedBraceMatcher {

    private final BracePair[] PAIRS = new BracePair[]{
            new BracePair(OpenSCADTypes.LPARENTH, OpenSCADTypes.RPARENTH, false),
            new BracePair(OpenSCADTypes.LBRACKET, OpenSCADTypes.RBRACKET, false),
            new BracePair(OpenSCADTypes.LBRACE, OpenSCADTypes.RBRACE, true),
            new BracePair(OpenSCADTypes.INCLUDE_START, OpenSCADTypes.INCLUDE_END, false)};


    @NotNull
    @Override
    public BracePair[] getPairs() {
        return PAIRS;
    }


    @Override
    public boolean isPairedBracesAllowedBeforeType(@NotNull IElementType lbraceType, @Nullable IElementType contextType) {
        return true;
    }


    @Override
    public int getCodeConstructStart(final PsiFile file, int openingBraceOffset) {
        return openingBraceOffset;
    }
}
