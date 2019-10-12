package com.javampire.openscad.action;

import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import org.jetbrains.annotations.NotNull;

public class RenderAction extends OpenSCADExecutableAction {

    @Override
    protected String getArguments(@NotNull AnActionEvent event) {
        return event.getData(CommonDataKeys.VIRTUAL_FILE).getPath();
    }
}
