// This is a generated file. Not intended for manual editing.
package com.javampire.openscad.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.javampire.openscad.psi.OpenSCADTypes.*;
import com.javampire.openscad.psi.*;
import com.intellij.navigation.ItemPresentation;
import com.intellij.psi.PsiReference;

public class OpenSCADRefExprImpl extends OpenSCADNamedElementImpl implements OpenSCADRefExpr {

  public OpenSCADRefExprImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull OpenSCADVisitor visitor) {
    visitor.visitRefExpr(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof OpenSCADVisitor) accept((OpenSCADVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public OpenSCADExpr getExpr() {
    return findChildByClass(OpenSCADExpr.class);
  }

  public ItemPresentation getPresentation() {
    return OpenSCADPsiImplUtil.getPresentation(this);
  }

  public String getName() {
    return OpenSCADPsiImplUtil.getName(this);
  }

  public PsiElement setName(String newName) {
    return OpenSCADPsiImplUtil.setName(this, newName);
  }

  public PsiElement getNameIdentifier() {
    return OpenSCADPsiImplUtil.getNameIdentifier(this);
  }

  public PsiReference getReference() {
    return OpenSCADPsiImplUtil.getReference(this);
  }

}
