// This is a generated file. Not intended for manual editing.
package com.javampire.openscad.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface OpenSCADModuleDeclaration extends PsiElement {

  @NotNull
  OpenSCADArgDeclarationList getArgDeclarationList();

  @Nullable
  OpenSCADAssignment getAssignment();

  @Nullable
  OpenSCADObject getObject();

}
