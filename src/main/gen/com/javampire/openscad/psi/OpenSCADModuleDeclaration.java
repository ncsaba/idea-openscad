// This is a generated file. Not intended for manual editing.
package com.javampire.openscad.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import com.intellij.psi.StubBasedPsiElement;
import com.javampire.openscad.psi.stub.OpenSCADModuleStub;
import com.intellij.navigation.ItemPresentation;

public interface OpenSCADModuleDeclaration extends OpenSCADNamedElement, StubBasedPsiElement<OpenSCADModuleStub> {

  @NotNull
  OpenSCADArgDeclarationList getArgDeclarationList();

  @Nullable
  OpenSCADAssignment getAssignment();

  @Nullable
  OpenSCADFunctionDeclaration getFunctionDeclaration();

  @Nullable
  OpenSCADModuleDeclaration getModuleDeclaration();

  @Nullable
  OpenSCADObject getObject();

  ItemPresentation getPresentation();

  PsiElement setName(String newName);

  PsiElement getNameIdentifier();

}
