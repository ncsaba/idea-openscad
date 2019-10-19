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

public class OpenSCADIfObjImpl extends OpenSCADObjectImpl implements OpenSCADIfObj {

  public OpenSCADIfObjImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull OpenSCADVisitor visitor) {
    visitor.visitIfObj(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof OpenSCADVisitor) accept((OpenSCADVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<OpenSCADFunctionDeclaration> getFunctionDeclarationList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, OpenSCADFunctionDeclaration.class);
  }

  @Override
  @NotNull
  public List<OpenSCADModuleDeclaration> getModuleDeclarationList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, OpenSCADModuleDeclaration.class);
  }

  @Override
  @NotNull
  public List<OpenSCADObject> getObjectList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, OpenSCADObject.class);
  }

  @Override
  @NotNull
  public List<OpenSCADParenExpr> getParenExprList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, OpenSCADParenExpr.class);
  }

  @Override
  @NotNull
  public List<OpenSCADVariableDeclaration> getVariableDeclarationList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, OpenSCADVariableDeclaration.class);
  }

}
