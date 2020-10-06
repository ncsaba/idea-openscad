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
import com.javampire.openscad.psi.stub.OpenSCADFunctionStub;
import com.intellij.psi.stubs.IStubElementType;

public class OpenSCADFunctionDeclarationImpl extends OpenSCADFunctionDeclarationStubElementImpl implements OpenSCADFunctionDeclaration {

  public OpenSCADFunctionDeclarationImpl(@NotNull OpenSCADFunctionStub stub, @NotNull IStubElementType type) {
    super(stub, type);
  }

  public OpenSCADFunctionDeclarationImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull OpenSCADVisitor visitor) {
    visitor.visitFunctionDeclaration(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof OpenSCADVisitor) accept((OpenSCADVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public OpenSCADArgDeclarationList getArgDeclarationList() {
    return findChildByClass(OpenSCADArgDeclarationList.class);
  }

  @Override
  @Nullable
  public OpenSCADEchoObj getEchoObj() {
    return findChildByClass(OpenSCADEchoObj.class);
  }

  @Override
  @Nullable
  public OpenSCADExpr getExpr() {
    return findChildByClass(OpenSCADExpr.class);
  }

  @Override
  public ItemPresentation getPresentation() {
    return OpenSCADPsiImplUtil.getPresentation(this);
  }

  @Override
  public PsiElement getNameIdentifier() {
    return OpenSCADPsiImplUtil.getNameIdentifier(this);
  }

}
