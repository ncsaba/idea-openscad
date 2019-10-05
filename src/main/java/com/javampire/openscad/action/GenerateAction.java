package com.javampire.openscad.action;

import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.vfs.VirtualFile;
import com.javampire.openscad.settings.OpenSCADSettings;
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
    protected String getCommand(@NotNull AnActionEvent event) {
        final OpenSCADSettings openSCADSettings = OpenSCADSettings.getInstance();
        final VirtualFile virtualFile = event.getData(CommonDataKeys.VIRTUAL_FILE);
        String filename = virtualFile.getPath();
        return "\"" + openSCADSettings.openSCADExecutable + "\" -o " + filename.substring(0, filename.lastIndexOf('.')) + "." + this.type + " " + event.getData(CommonDataKeys.VIRTUAL_FILE).getPath();
    }
}
