// This is a generated file. Not intended for manual editing.
package com.javampire.openscad.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface OpenSCADEchoCallObj extends OpenSCADObject {

  @Nullable
  OpenSCADFunctionDeclaration getFunctionDeclaration();

  @Nullable
  OpenSCADModuleDeclaration getModuleDeclaration();

  @NotNull
  List<OpenSCADObject> getObjectList();

  @Nullable
  OpenSCADVariableDeclaration getVariableDeclaration();

}
