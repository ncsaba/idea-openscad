package com.javampire.openscad;

import com.intellij.lexer.FlexAdapter;

import java.io.Reader;

public class OpenSCADLexerAdapter extends FlexAdapter {
    public OpenSCADLexerAdapter() {
        super(new OpenSCADLexer((Reader) null));
    }
}
