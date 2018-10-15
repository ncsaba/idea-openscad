// This is a generated file. Not intended for manual editing.
package com.javampire.openscad.psi;

import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.PsiElement;
import com.intellij.psi.StubBasedPsiElement;
import com.javampire.openscad.psi.stub.OpenSCADModuleStub;
import com.javampire.openscad.psi.stub.OpenSCADFunctionStub;

public class OpenSCADVisitor extends PsiElementVisitor {

  public void visitAbsExpr(@NotNull OpenSCADAbsExpr o) {
    visitExpr(o);
  }

  public void visitAcosExpr(@NotNull OpenSCADAcosExpr o) {
    visitExpr(o);
  }

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

  public void visitAsinExpr(@NotNull OpenSCADAsinExpr o) {
    visitExpr(o);
  }

  public void visitAssertObj(@NotNull OpenSCADAssertObj o) {
    visitObject(o);
  }

  public void visitAssignOp(@NotNull OpenSCADAssignOp o) {
    visitOperator(o);
  }

  public void visitAssignment(@NotNull OpenSCADAssignment o) {
    visitPsiElement(o);
  }

  public void visitAtan2Expr(@NotNull OpenSCADAtan2Expr o) {
    visitExpr(o);
  }

  public void visitAtanExpr(@NotNull OpenSCADAtanExpr o) {
    visitExpr(o);
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

  public void visitBuiltinObj(@NotNull OpenSCADBuiltinObj o) {
    visitObject(o);
  }

  public void visitBuiltinOp(@NotNull OpenSCADBuiltinOp o) {
    visitOperator(o);
  }

  public void visitCeilExpr(@NotNull OpenSCADCeilExpr o) {
    visitExpr(o);
  }

  public void visitChildObj(@NotNull OpenSCADChildObj o) {
    visitObject(o);
  }

  public void visitChildrenObj(@NotNull OpenSCADChildrenObj o) {
    visitObject(o);
  }

  public void visitChrExpr(@NotNull OpenSCADChrExpr o) {
    visitExpr(o);
  }

  public void visitCircleObj(@NotNull OpenSCADCircleObj o) {
    visitObject(o);
  }

  public void visitColorOp(@NotNull OpenSCADColorOp o) {
    visitOperator(o);
  }

  public void visitConcatExpr(@NotNull OpenSCADConcatExpr o) {
    visitExpr(o);
  }

  public void visitConditionalExpr(@NotNull OpenSCADConditionalExpr o) {
    visitExpr(o);
  }

  public void visitCosExpr(@NotNull OpenSCADCosExpr o) {
    visitExpr(o);
  }

  public void visitCrossExpr(@NotNull OpenSCADCrossExpr o) {
    visitExpr(o);
  }

  public void visitCubeObj(@NotNull OpenSCADCubeObj o) {
    visitObject(o);
  }

  public void visitCylinderObj(@NotNull OpenSCADCylinderObj o) {
    visitObject(o);
  }

  public void visitDebugOp(@NotNull OpenSCADDebugOp o) {
    visitOperator(o);
  }

  public void visitDifferenceOp(@NotNull OpenSCADDifferenceOp o) {
    visitOperator(o);
  }

  public void visitDisableOp(@NotNull OpenSCADDisableOp o) {
    visitOperator(o);
  }

  public void visitDivExpr(@NotNull OpenSCADDivExpr o) {
    visitExpr(o);
  }

  public void visitEchoObj(@NotNull OpenSCADEchoObj o) {
    visitObject(o);
  }

  public void visitEllipseObj(@NotNull OpenSCADEllipseObj o) {
    visitObject(o);
  }

  public void visitElseOp(@NotNull OpenSCADElseOp o) {
    visitOperator(o);
  }

  public void visitElvisExpr(@NotNull OpenSCADElvisExpr o) {
    visitExpr(o);
  }

  public void visitEmptyObj(@NotNull OpenSCADEmptyObj o) {
    visitObject(o);
  }

  public void visitExpExpr(@NotNull OpenSCADExpExpr o) {
    visitExpr(o);
  }

  public void visitExpr(@NotNull OpenSCADExpr o) {
    visitPsiElement(o);
  }

  public void visitFloorExpr(@NotNull OpenSCADFloorExpr o) {
    visitExpr(o);
  }

  public void visitForElement(@NotNull OpenSCADForElement o) {
    visitPsiElement(o);
  }

  public void visitForOp(@NotNull OpenSCADForOp o) {
    visitOperator(o);
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
    visitNamedElement(o);
  }

  public void visitHullOp(@NotNull OpenSCADHullOp o) {
    visitOperator(o);
  }

  public void visitIfElement(@NotNull OpenSCADIfElement o) {
    visitPsiElement(o);
  }

  public void visitIfOp(@NotNull OpenSCADIfOp o) {
    visitOperator(o);
  }

  public void visitImportDxfObj(@NotNull OpenSCADImportDxfObj o) {
    visitObject(o);
  }

  public void visitImportObj(@NotNull OpenSCADImportObj o) {
    visitObject(o);
  }

  public void visitImportStlObj(@NotNull OpenSCADImportStlObj o) {
    visitObject(o);
  }

  public void visitIncludeItem(@NotNull OpenSCADIncludeItem o) {
    visitPsiElement(o);
  }

  public void visitIndexExpr(@NotNull OpenSCADIndexExpr o) {
    visitExpr(o);
  }

  public void visitIntersectionForOp(@NotNull OpenSCADIntersectionForOp o) {
    visitOperator(o);
  }

  public void visitIntersectionOp(@NotNull OpenSCADIntersectionOp o) {
    visitOperator(o);
  }

  public void visitLenExpr(@NotNull OpenSCADLenExpr o) {
    visitExpr(o);
  }

  public void visitLetElement(@NotNull OpenSCADLetElement o) {
    visitPsiElement(o);
  }

  public void visitLetExpr(@NotNull OpenSCADLetExpr o) {
    visitExpr(o);
  }

  public void visitLetOp(@NotNull OpenSCADLetOp o) {
    visitOperator(o);
  }

  public void visitLinearExtrudeOp(@NotNull OpenSCADLinearExtrudeOp o) {
    visitOperator(o);
  }

  public void visitListComprehensionExpr(@NotNull OpenSCADListComprehensionExpr o) {
    visitExpr(o);
  }

  public void visitLiteralExpr(@NotNull OpenSCADLiteralExpr o) {
    visitExpr(o);
  }

  public void visitLnExpr(@NotNull OpenSCADLnExpr o) {
    visitExpr(o);
  }

  public void visitLogExpr(@NotNull OpenSCADLogExpr o) {
    visitExpr(o);
  }

  public void visitLookupExpr(@NotNull OpenSCADLookupExpr o) {
    visitExpr(o);
  }

  public void visitMaxExpr(@NotNull OpenSCADMaxExpr o) {
    visitExpr(o);
  }

  public void visitMinExpr(@NotNull OpenSCADMinExpr o) {
    visitExpr(o);
  }

  public void visitMinkowskiOp(@NotNull OpenSCADMinkowskiOp o) {
    visitOperator(o);
  }

  public void visitMinusExpr(@NotNull OpenSCADMinusExpr o) {
    visitExpr(o);
  }

  public void visitMirrorOp(@NotNull OpenSCADMirrorOp o) {
    visitOperator(o);
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
    visitNamedElement(o);
  }

  public void visitModuleOpNameRef(@NotNull OpenSCADModuleOpNameRef o) {
    visitNamedElement(o);
  }

  public void visitModuloExpr(@NotNull OpenSCADModuloExpr o) {
    visitExpr(o);
  }

  public void visitMulExpr(@NotNull OpenSCADMulExpr o) {
    visitExpr(o);
  }

  public void visitMultmatrixOp(@NotNull OpenSCADMultmatrixOp o) {
    visitOperator(o);
  }

  public void visitNormExpr(@NotNull OpenSCADNormExpr o) {
    visitExpr(o);
  }

  public void visitObject(@NotNull OpenSCADObject o) {
    visitPsiElement(o);
  }

  public void visitOffsetOp(@NotNull OpenSCADOffsetOp o) {
    visitOperator(o);
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

  public void visitParentModuleExpr(@NotNull OpenSCADParentModuleExpr o) {
    visitExpr(o);
  }

  public void visitPlusExpr(@NotNull OpenSCADPlusExpr o) {
    visitExpr(o);
  }

  public void visitPolygonObj(@NotNull OpenSCADPolygonObj o) {
    visitObject(o);
  }

  public void visitPolyhedronObj(@NotNull OpenSCADPolyhedronObj o) {
    visitObject(o);
  }

  public void visitPowExpr(@NotNull OpenSCADPowExpr o) {
    visitExpr(o);
  }

  public void visitProjectionObj(@NotNull OpenSCADProjectionObj o) {
    visitObject(o);
  }

  public void visitQualificationExpr(@NotNull OpenSCADQualificationExpr o) {
    visitExpr(o);
    // visitNamedElement(o);
  }

  public void visitRandsExpr(@NotNull OpenSCADRandsExpr o) {
    visitExpr(o);
  }

  public void visitRangeExpr(@NotNull OpenSCADRangeExpr o) {
    visitExpr(o);
  }

  public void visitRenderOp(@NotNull OpenSCADRenderOp o) {
    visitOperator(o);
  }

  public void visitResizeOp(@NotNull OpenSCADResizeOp o) {
    visitOperator(o);
  }

  public void visitRootOp(@NotNull OpenSCADRootOp o) {
    visitOperator(o);
  }

  public void visitRotateExtrudeOp(@NotNull OpenSCADRotateExtrudeOp o) {
    visitOperator(o);
  }

  public void visitRotateOp(@NotNull OpenSCADRotateOp o) {
    visitOperator(o);
  }

  public void visitRoundExpr(@NotNull OpenSCADRoundExpr o) {
    visitExpr(o);
  }

  public void visitScaleOp(@NotNull OpenSCADScaleOp o) {
    visitOperator(o);
  }

  public void visitSearchExpr(@NotNull OpenSCADSearchExpr o) {
    visitExpr(o);
  }

  public void visitSelectExpr(@NotNull OpenSCADSelectExpr o) {
    visitExpr(o);
  }

  public void visitSignExpr(@NotNull OpenSCADSignExpr o) {
    visitExpr(o);
  }

  public void visitSinExpr(@NotNull OpenSCADSinExpr o) {
    visitExpr(o);
  }

  public void visitSphereObj(@NotNull OpenSCADSphereObj o) {
    visitObject(o);
  }

  public void visitSqrtExpr(@NotNull OpenSCADSqrtExpr o) {
    visitExpr(o);
  }

  public void visitSquareObj(@NotNull OpenSCADSquareObj o) {
    visitObject(o);
  }

  public void visitStrExpr(@NotNull OpenSCADStrExpr o) {
    visitExpr(o);
  }

  public void visitSurfaceObj(@NotNull OpenSCADSurfaceObj o) {
    visitObject(o);
  }

  public void visitTanExpr(@NotNull OpenSCADTanExpr o) {
    visitExpr(o);
  }

  public void visitTextObj(@NotNull OpenSCADTextObj o) {
    visitObject(o);
  }

  public void visitTranslateOp(@NotNull OpenSCADTranslateOp o) {
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

  public void visitUnionOp(@NotNull OpenSCADUnionOp o) {
    visitOperator(o);
  }

  public void visitUseItem(@NotNull OpenSCADUseItem o) {
    visitPsiElement(o);
  }

  public void visitVariableDeclaration(@NotNull OpenSCADVariableDeclaration o) {
    visitNamedElement(o);
  }

  public void visitVariableRefExpr(@NotNull OpenSCADVariableRefExpr o) {
    visitExpr(o);
    // visitNamedElement(o);
  }

  public void visitVectorExpr(@NotNull OpenSCADVectorExpr o) {
    visitExpr(o);
  }

  public void visitVersionExpr(@NotNull OpenSCADVersionExpr o) {
    visitExpr(o);
  }

  public void visitVersionNumExpr(@NotNull OpenSCADVersionNumExpr o) {
    visitExpr(o);
  }

  public void visitNamedElement(@NotNull OpenSCADNamedElement o) {
    visitPsiElement(o);
  }

  public void visitPsiElement(@NotNull PsiElement o) {
    visitElement(o);
  }

}
