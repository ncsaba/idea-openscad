package com.javampire.openscad;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class OpenSCADFileType extends LanguageFileType {
    public static final OpenSCADFileType INSTANCE = new OpenSCADFileType();

    private OpenSCADFileType() {
        super(OpenSCADLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public String getName() {
        return "OpenSCAD";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "OpenSCAD file";
    }

    @NotNull
    @Override
    public String getDefaultExtension() {
        return "scad";
    }

    @Nullable
    @Override
    public Icon getIcon() {
        return OpenSCADIcons.FILE;
    }
}
