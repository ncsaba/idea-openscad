package com.javampire.openscad.action;

import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.javampire.openscad.settings.OpenSCADSettings;
import org.jetbrains.annotations.NotNull;

public class RenderAction extends OpenSCADExecutableAction {

    @Override
    protected String getCommand(@NotNull AnActionEvent event) {
        final OpenSCADSettings openSCADSettings = OpenSCADSettings.getInstance();
        return "\"" + openSCADSettings.openSCADExecutable + "\" " + event.getData(CommonDataKeys.VIRTUAL_FILE).getPath();
    }
}
