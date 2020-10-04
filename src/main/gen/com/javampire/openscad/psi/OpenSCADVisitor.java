// This is a generated file. Not intended for manual editing.
package com.javampire.openscad.psi;

import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.PsiElement;
import com.intellij.psi.StubBasedPsiElement;
import com.javampire.openscad.psi.stub.OpenSCADFunctionStub;
import com.javampire.openscad.psi.stub.OpenSCADVariableStub;
import com.javampire.openscad.psi.stub.OpenSCADModuleStub;

public class OpenSCADVisitor extends PsiElementVisitor {

  public void visitAndExpr(@NotNull OpenSCADAndExpr o) {
    visitExpr(o);
  }

  public void visitArgAssignment(@NotNull OpenSCADArgAssignment o) {
    visitPsiElement(o);
  }

  public void visitArgAssignmentList(@NotNull OpenSCADArgAssignmentList o) {
    visitPsiElement(o);
  }

  public void visitArgDeclaration(@NotNull OpenSCADArgDeclaration o) {
    visitNamedElement(o);
  }

  public void visitArgDeclarationList(@NotNull OpenSCADArgDeclarationList o) {
    visitPsiElement(o);
  }

  public void visitBackgroundOp(@NotNull OpenSCADBackgroundOp o) {
    visitOperator(o);
  }

  public void visitBlockObj(@NotNull OpenSCADBlockObj o) {
    visitObject(o);
  }

  public void visitBuiltinExpr(@NotNull OpenSCADBuiltinExpr o) {
    visitExpr(o);
  }

  public void visitBuiltinExprRef(@NotNull OpenSCADBuiltinExprRef o) {
    visitResolvableElement(o);
  }

  public void visitBuiltinObj(@NotNull OpenSCADBuiltinObj o) {
    visitObject(o);
  }

  public void visitBuiltinObjRef(@NotNull OpenSCADBuiltinObjRef o) {
    visitResolvableElement(o);
  }

  public void visitBuiltinOp(@NotNull OpenSCADBuiltinOp o) {
    visitOperator(o);
  }

  public void visitCommonOpRef(@NotNull OpenSCADCommonOpRef o) {
    visitResolvableElement(o);
  }

  public void visitConditionalExpr(@NotNull OpenSCADConditionalExpr o) {
    visitExpr(o);
  }

  public void visitDebugOp(@NotNull OpenSCADDebugOp o) {
    visitOperator(o);
  }

  public void visitDisableOp(@NotNull OpenSCADDisableOp o) {
    visitOperator(o);
  }

  public void visitDivExpr(@NotNull OpenSCADDivExpr o) {
    visitExpr(o);
  }

  public void visitEchoCallObj(@NotNull OpenSCADEchoCallObj o) {
    visitObject(o);
  }

  public void visitEchoObj(@NotNull OpenSCADEchoObj o) {
    visitObject(o);
  }

  public void visitEchoObjRef(@NotNull OpenSCADEchoObjRef o) {
    visitResolvableElement(o);
  }

  public void visitElvisExpr(@NotNull OpenSCADElvisExpr o) {
    visitExpr(o);
  }

  public void visitEmptyObj(@NotNull OpenSCADEmptyObj o) {
    visitObject(o);
  }

  public void visitExpr(@NotNull OpenSCADExpr o) {
    visitPsiElement(o);
  }

  public void visitForElement(@NotNull OpenSCADForElement o) {
    visitPsiElement(o);
  }

  public void visitForObj(@NotNull OpenSCADForObj o) {
    visitObject(o);
  }

  public void visitFullArgDeclaration(@NotNull OpenSCADFullArgDeclaration o) {
    visitNamedElement(o);
  }

  public void visitFullArgDeclarationList(@NotNull OpenSCADFullArgDeclarationList o) {
    visitPsiElement(o);
  }

  public void visitFunctionCallExpr(@NotNull OpenSCADFunctionCallExpr o) {
    visitExpr(o);
  }

  public void visitFunctionDeclaration(@NotNull OpenSCADFunctionDeclaration o) {
    visitNamedElement(o);
    // visitStubBasedPsiElement(o);
  }

  public void visitFunctionNameRef(@NotNull OpenSCADFunctionNameRef o) {
    visitResolvableElement(o);
  }

  public void visitIfElement(@NotNull OpenSCADIfElement o) {
    visitPsiElement(o);
  }

  public void visitIfObj(@NotNull OpenSCADIfObj o) {
    visitObject(o);
  }

  public void visitIncludeItem(@NotNull OpenSCADIncludeItem o) {
    visitPsiElement(o);
  }

  public void visitIncludePathRef(@NotNull OpenSCADIncludePathRef o) {
    visitPsiElement(o);
  }

  public void visitIndexExpr(@NotNull OpenSCADIndexExpr o) {
    visitExpr(o);
  }

  public void visitLetElement(@NotNull OpenSCADLetElement o) {
    visitPsiElement(o);
  }

  public void visitListComprehensionExpr(@NotNull OpenSCADListComprehensionExpr o) {
    visitExpr(o);
  }

  public void visitLiteralExpr(@NotNull OpenSCADLiteralExpr o) {
    visitExpr(o);
  }

  public void visitMinusExpr(@NotNull OpenSCADMinusExpr o) {
    visitExpr(o);
  }

  public void visitModifierOp(@NotNull OpenSCADModifierOp o) {
    visitOperator(o);
  }

  public void visitModuleCallObj(@NotNull OpenSCADModuleCallObj o) {
    visitObject(o);
  }

  public void visitModuleCallOp(@NotNull OpenSCADModuleCallOp o) {
    visitOperator(o);
  }

  public void visitModuleDeclaration(@NotNull OpenSCADModuleDeclaration o) {
    visitNamedElement(o);
    // visitStubBasedPsiElement(o);
  }

  public void visitModuleObjNameRef(@NotNull OpenSCADModuleObjNameRef o) {
    visitResolvableElement(o);
  }

  public void visitModuleOpNameRef(@NotNull OpenSCADModuleOpNameRef o) {
    visitResolvableElement(o);
  }

  public void visitModuloExpr(@NotNull OpenSCADModuloExpr o) {
    visitExpr(o);
  }

  public void visitMulExpr(@NotNull OpenSCADMulExpr o) {
    visitExpr(o);
  }

  public void visitObject(@NotNull OpenSCADObject o) {
    visitPsiElement(o);
  }

  public void visitOperator(@NotNull OpenSCADOperator o) {
    visitPsiElement(o);
  }

  public void visitOrExpr(@NotNull OpenSCADOrExpr o) {
    visitExpr(o);
  }

  public void visitParameterReference(@NotNull OpenSCADParameterReference o) {
    visitNamedElement(o);
  }

  public void visitParenExpr(@NotNull OpenSCADParenExpr o) {
    visitExpr(o);
  }

  public void visitPlusExpr(@NotNull OpenSCADPlusExpr o) {
    visitExpr(o);
  }

  public void visitQualificationExpr(@NotNull OpenSCADQualificationExpr o) {
    visitExpr(o);
    // visitResolvableElement(o);
  }

  public void visitRangeExpr(@NotNull OpenSCADRangeExpr o) {
    visitExpr(o);
  }

  public void visitRootOp(@NotNull OpenSCADRootOp o) {
    visitOperator(o);
  }

  public void visitUnaryMinExpr(@NotNull OpenSCADUnaryMinExpr o) {
    visitExpr(o);
  }

  public void visitUnaryNegateExpr(@NotNull OpenSCADUnaryNegateExpr o) {
    visitExpr(o);
  }

  public void visitUnaryPlusExpr(@NotNull OpenSCADUnaryPlusExpr o) {
    visitExpr(o);
  }

  public void visitUseItem(@NotNull OpenSCADUseItem o) {
    visitPsiElement(o);
  }

  public void visitVariableDeclaration(@NotNull OpenSCADVariableDeclaration o) {
    visitNamedElement(o);
    // visitStubBasedPsiElement(o);
  }

  public void visitVariableRefExpr(@NotNull OpenSCADVariableRefExpr o) {
    visitExpr(o);
    // visitResolvableElement(o);
  }

  public void visitVectorExpr(@NotNull OpenSCADVectorExpr o) {
    visitExpr(o);
  }

  public void visitNamedElement(@NotNull OpenSCADNamedElement o) {
    visitPsiElement(o);
  }

  public void visitResolvableElement(@NotNull OpenSCADResolvableElement o) {
    visitPsiElement(o);
  }

  public void visitPsiElement(@NotNull PsiElement o) {
    visitElement(o);
  }

}
