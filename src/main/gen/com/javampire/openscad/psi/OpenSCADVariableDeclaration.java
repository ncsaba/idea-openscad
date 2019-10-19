// This is a generated file. Not intended for manual editing.
package com.javampire.openscad.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import com.intellij.psi.StubBasedPsiElement;
import com.javampire.openscad.psi.stub.OpenSCADVariableStub;
import com.intellij.navigation.ItemPresentation;

public interface OpenSCADVariableDeclaration extends OpenSCADNamedElement, StubBasedPsiElement<OpenSCADVariableStub> {

  @Nullable
  OpenSCADExpr getExpr();

  ItemPresentation getPresentation();

  PsiElement getNameIdentifier();

}
