package com.javampire.openscad.action;

import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public abstract class GenerateAction extends OpenSCADExecutableAction {

    String type = "";

    public GenerateAction(String type) {
        super();
        this.type = type;
    }

    public GenerateAction(Icon icon, String type) {
        super(null, null, icon);
        this.type = type;
    }

    public GenerateAction(@Nullable @Nls(capitalization = Nls.Capitalization.Title) String text, String type) {
        super(text, null, null);
        this.type = type;
    }

    public GenerateAction(@Nullable @Nls(capitalization = Nls.Capitalization.Title) String text, @Nullable @Nls(capitalization = Nls.Capitalization.Sentence) String description, @Nullable Icon icon, String type) {
        super(text, description, icon);
        this.type = type;
    }

    @Override
    protected String getArguments(@NotNull AnActionEvent event) {
        final String filename = event.getData(CommonDataKeys.VIRTUAL_FILE).getPath();
        final String generatedFileName = filename.substring(0, filename.lastIndexOf('.') + 1) + this.type;
        return "-o " + generatedFileName + " " + filename;
    }
}
