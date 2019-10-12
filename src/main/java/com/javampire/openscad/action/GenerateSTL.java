package com.javampire.openscad.action;

import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class GenerateSTL extends GenerateAction {

    private final static String STL = "stl";

    public GenerateSTL() {
        super(STL);
    }

    public GenerateSTL(Icon icon) {
        super(icon, STL);
    }

    public GenerateSTL(@Nullable @Nls(capitalization = Nls.Capitalization.Title) String text) {
        super(text, STL);
    }

    public GenerateSTL(@Nullable @Nls(capitalization = Nls.Capitalization.Title) String text, @Nullable @Nls(capitalization = Nls.Capitalization.Sentence) String description, @Nullable Icon icon) {
        super(text, description, icon, STL);
    }
}
