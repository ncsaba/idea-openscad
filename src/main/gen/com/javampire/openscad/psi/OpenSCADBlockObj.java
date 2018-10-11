// This is a generated file. Not intended for manual editing.
package com.javampire.openscad.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface OpenSCADBlockObj extends OpenSCADObject {

  @NotNull
  List<OpenSCADAssignment> getAssignmentList();

  @NotNull
  List<OpenSCADFunctionDeclaration> getFunctionDeclarationList();

  @NotNull
  List<OpenSCADModuleDeclaration> getModuleDeclarationList();

  @NotNull
  List<OpenSCADObject> getObjectList();

}
