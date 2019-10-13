package com.javampire.openscad.action;

import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class GeneratePNG extends GenerateAction {

    private final static String STL = "png";

    public GeneratePNG() {
        super(STL);
    }

    public GeneratePNG(Icon icon) {
        super(icon, STL);
    }

    public GeneratePNG(@Nullable @Nls(capitalization = Nls.Capitalization.Title) String text) {
        super(text, STL);
    }

    public GeneratePNG(@Nullable @Nls(capitalization = Nls.Capitalization.Title) String text, @Nullable @Nls(capitalization = Nls.Capitalization.Sentence) String description, @Nullable Icon icon) {
        super(text, description, icon, STL);
    }
}
