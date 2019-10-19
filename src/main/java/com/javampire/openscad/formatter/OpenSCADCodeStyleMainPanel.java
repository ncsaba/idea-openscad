package com.javampire.openscad.formatter;

import com.intellij.application.options.TabbedLanguageCodeStylePanel;
import com.intellij.psi.codeStyle.CodeStyleSettings;
import com.javampire.openscad.OpenSCADLanguage;

public class OpenSCADCodeStyleMainPanel extends TabbedLanguageCodeStylePanel {
    protected OpenSCADCodeStyleMainPanel(CodeStyleSettings currentSettings, CodeStyleSettings settings) {
        super(OpenSCADLanguage.INSTANCE, currentSettings, settings);
    }

    @Override
    protected void initTabs(CodeStyleSettings settings) {
        addIndentOptionsTab(settings);
        addSpacesTab(settings);
        addWrappingAndBracesTab(settings);
    }
}
