// This is a generated file. Not intended for manual editing.
package com.javampire.openscad.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.javampire.openscad.psi.OpenSCADTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.javampire.openscad.psi.*;

public class OpenSCADArgDeclarationListImpl extends ASTWrapperPsiElement implements OpenSCADArgDeclarationList {

  public OpenSCADArgDeclarationListImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull OpenSCADVisitor visitor) {
    visitor.visitArgDeclarationList(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof OpenSCADVisitor) accept((OpenSCADVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<OpenSCADArgDeclaration> getArgDeclarationList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, OpenSCADArgDeclaration.class);
  }

}
