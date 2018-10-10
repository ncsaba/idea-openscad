package com.javampire.openscad.psi;

import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFileFactory;
import com.javampire.openscad.OpenSCADFileType;

public class OpenSCADElementFactory {

    public static PsiElement createIdentifier(Project project, String name) {
        final OpenSCADFile file = createFile(project, name + "=0;");
        return file.getFirstChild();
    }

    public static OpenSCADFile createFile(Project project, String text) {
        String name = "dummy.scad";
        return (OpenSCADFile) PsiFileFactory.getInstance(project).
                createFileFromText(name, OpenSCADFileType.INSTANCE, text);
    }

}
