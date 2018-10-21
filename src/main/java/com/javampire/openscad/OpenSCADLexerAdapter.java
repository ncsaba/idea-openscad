package com.javampire.openscad;

import com.intellij.lexer.FlexAdapter;
import com.intellij.lexer.FlexLexer;

import java.io.Reader;

public class OpenSCADLexerAdapter extends FlexAdapter {
    public OpenSCADLexerAdapter(FlexLexer lexer) {
        super(lexer);
    }

    public OpenSCADLexerAdapter() {
        super(new OpenSCADLexer((Reader) null));
    }
}
