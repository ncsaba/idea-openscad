package com.javampire.openscad;

import com.intellij.lang.Language;

public class OpenSCADLanguage extends Language {
    public static final OpenSCADLanguage INSTANCE = new OpenSCADLanguage();

    private OpenSCADLanguage() {
        super("OpenSCAD");
    }
}
