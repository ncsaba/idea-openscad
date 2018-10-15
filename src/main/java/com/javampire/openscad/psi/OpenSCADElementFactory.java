package com.javampire.openscad.psi;

import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFileFactory;
import com.intellij.psi.tree.IElementType;
import com.javampire.openscad.OpenSCADFileType;
import com.javampire.openscad.psi.stub.OpenSCADFunctionStubElementType;
import com.javampire.openscad.psi.stub.OpenSCADModuleStubElementType;

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

    public static IElementType getElementType(String debugName) {
        if ("MODULE_DECLARATION".equals(debugName)) {
            return OpenSCADModuleStubElementType.INSTANCE;
        } else if ("FUNCTION_DECLARATION".equals(debugName)) {
            return OpenSCADFunctionStubElementType.INSTANCE;
        } else {
            return new OpenSCADElementType(debugName);
        }
    }

}
