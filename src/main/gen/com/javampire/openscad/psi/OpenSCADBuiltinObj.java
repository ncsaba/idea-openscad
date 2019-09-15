// This is a generated file. Not intended for manual editing.
package com.javampire.openscad.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface OpenSCADBuiltinObj extends OpenSCADObject {

  @Nullable
  OpenSCADArgAssignmentList getArgAssignmentList();

  @Nullable
  OpenSCADBuiltinObjRef getBuiltinObjRef();

  @Nullable
  OpenSCADBuiltinOp getBuiltinOp();

  @Nullable
  OpenSCADFunctionDeclaration getFunctionDeclaration();

  @Nullable
  OpenSCADModuleDeclaration getModuleDeclaration();

  @Nullable
  OpenSCADVariableDeclaration getVariableDeclaration();

}
