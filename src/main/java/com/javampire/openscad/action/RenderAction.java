package com.javampire.openscad.action;

import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.List;

public class RenderAction extends OpenSCADExecutableAction {

    @Override
    protected List<String> getArguments(@NotNull AnActionEvent event) {
        return Collections.singletonList(event.getData(CommonDataKeys.VIRTUAL_FILE).getPath());
    }
}
