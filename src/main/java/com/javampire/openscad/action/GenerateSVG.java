package com.javampire.openscad.action;

import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class GenerateSVG extends GenerateAction {

    private final static String STL = "svg";

    public GenerateSVG() {
        super(STL);
    }

    public GenerateSVG(Icon icon) {
        super(icon, STL);
    }

    public GenerateSVG(@Nullable @Nls(capitalization = Nls.Capitalization.Title) String text) {
        super(text, STL);
    }

    public GenerateSVG(@Nullable @Nls(capitalization = Nls.Capitalization.Title) String text, @Nullable @Nls(capitalization = Nls.Capitalization.Sentence) String description, @Nullable Icon icon) {
        super(text, description, icon, STL);
    }
}
