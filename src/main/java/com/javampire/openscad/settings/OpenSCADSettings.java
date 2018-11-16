package com.javampire.openscad.settings;

import com.intellij.openapi.components.PersistentStateComponent;
import com.intellij.openapi.components.ServiceManager;
import com.intellij.openapi.components.State;
import com.intellij.openapi.components.Storage;
import com.intellij.openapi.util.text.StringUtil;
import com.intellij.util.xmlb.XmlSerializerUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.File;

@State(name = "OpenSCADSettings", storages = @Storage("OpenSCADSettings.xml"))
public class OpenSCADSettings implements PersistentStateComponent<OpenSCADSettings> {

    public String openSCADExecutable = null;

    public static OpenSCADSettings getInstance() {
        return ServiceManager.getService(OpenSCADSettings.class);
    }

    @Override
    public OpenSCADSettings getState() {
        return this;
    }

    @Override
    public void loadState(@NotNull OpenSCADSettings state) {
        XmlSerializerUtil.copyBean(state, this);
    }

    @Nullable
    public String getOpenSCADExecutable() {
        return openSCADExecutable;
    }

    public static boolean hasExecutable() {
        String executable = OpenSCADSettings.getInstance().getOpenSCADExecutable();
        return ! StringUtil.isEmptyOrSpaces(executable) && new File(executable).canExecute();
    }

    public void setOpenSCADExecutable(@NotNull final String openSCADExecutable) {
        this.openSCADExecutable = openSCADExecutable;
    }

}
