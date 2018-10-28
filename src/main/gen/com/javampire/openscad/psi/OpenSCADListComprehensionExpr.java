// This is a generated file. Not intended for manual editing.
package com.javampire.openscad.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface OpenSCADListComprehensionExpr extends OpenSCADExpr {

  @Nullable
  OpenSCADExpr getExpr();

  @NotNull
  List<OpenSCADForElement> getForElementList();

  @NotNull
  List<OpenSCADIfElement> getIfElementList();

  @NotNull
  List<OpenSCADLetElement> getLetElementList();

}
