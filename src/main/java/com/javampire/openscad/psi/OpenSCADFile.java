package com.javampire.openscad.psi;

import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import com.javampire.openscad.OpenSCADFileType;
import com.javampire.openscad.OpenSCADLanguage;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public class OpenSCADFile extends PsiFileBase {
    public OpenSCADFile(@NotNull FileViewProvider viewProvider) {
        super(viewProvider, OpenSCADLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public FileType getFileType() {
        return OpenSCADFileType.INSTANCE;
    }

    @Override
    public String toString() {
        return "OpenSCAD File";
    }

    @Override
    public Icon getIcon(int flags) {
        return super.getIcon(flags);
    }
}
