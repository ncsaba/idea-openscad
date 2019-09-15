package com.javampire.openscad.lexer;

import com.intellij.lexer.FlexAdapter;
import com.intellij.lexer.FlexLexer;

public class OpenSCADLexerAdapter extends FlexAdapter {
    public OpenSCADLexerAdapter(FlexLexer lexer) {
        super(lexer);
    }

    public OpenSCADLexerAdapter() {
        super(new OpenSCADLexer(null));
    }
}
