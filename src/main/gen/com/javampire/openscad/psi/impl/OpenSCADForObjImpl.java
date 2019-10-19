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

public class OpenSCADForObjImpl extends OpenSCADObjectImpl implements OpenSCADForObj {

  public OpenSCADForObjImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull OpenSCADVisitor visitor) {
    visitor.visitForObj(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof OpenSCADVisitor) accept((OpenSCADVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public OpenSCADFullArgDeclarationList getFullArgDeclarationList() {
    return findNotNullChildByClass(OpenSCADFullArgDeclarationList.class);
  }

  @Override
  @Nullable
  public OpenSCADFunctionDeclaration getFunctionDeclaration() {
    return findChildByClass(OpenSCADFunctionDeclaration.class);
  }

  @Override
  @Nullable
  public OpenSCADModuleDeclaration getModuleDeclaration() {
    return findChildByClass(OpenSCADModuleDeclaration.class);
  }

  @Override
  @Nullable
  public OpenSCADVariableDeclaration getVariableDeclaration() {
    return findChildByClass(OpenSCADVariableDeclaration.class);
  }

}
