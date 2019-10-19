// This is a generated file. Not intended for manual editing.
package com.javampire.openscad.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import com.javampire.openscad.psi.impl.*;

public interface OpenSCADTypes {

  IElementType AND_EXPR = OpenSCADElementFactory.getElementType("AND_EXPR");
  IElementType ARG_ASSIGNMENT = OpenSCADElementFactory.getElementType("ARG_ASSIGNMENT");
  IElementType ARG_ASSIGNMENT_LIST = OpenSCADElementFactory.getElementType("ARG_ASSIGNMENT_LIST");
  IElementType ARG_DECLARATION = OpenSCADElementFactory.getElementType("ARG_DECLARATION");
  IElementType ARG_DECLARATION_LIST = OpenSCADElementFactory.getElementType("ARG_DECLARATION_LIST");
  IElementType BACKGROUND_OP = OpenSCADElementFactory.getElementType("BACKGROUND_OP");
  IElementType BLOCK_OBJ = OpenSCADElementFactory.getElementType("BLOCK_OBJ");
  IElementType BUILTIN_EXPR = OpenSCADElementFactory.getElementType("BUILTIN_EXPR");
  IElementType BUILTIN_EXPR_REF = OpenSCADElementFactory.getElementType("BUILTIN_EXPR_REF");
  IElementType BUILTIN_OBJ = OpenSCADElementFactory.getElementType("BUILTIN_OBJ");
  IElementType BUILTIN_OBJ_REF = OpenSCADElementFactory.getElementType("BUILTIN_OBJ_REF");
  IElementType BUILTIN_OP = OpenSCADElementFactory.getElementType("BUILTIN_OP");
  IElementType COMMON_OP_REF = OpenSCADElementFactory.getElementType("COMMON_OP_REF");
  IElementType CONDITIONAL_EXPR = OpenSCADElementFactory.getElementType("CONDITIONAL_EXPR");
  IElementType DEBUG_OP = OpenSCADElementFactory.getElementType("DEBUG_OP");
  IElementType DISABLE_OP = OpenSCADElementFactory.getElementType("DISABLE_OP");
  IElementType DIV_EXPR = OpenSCADElementFactory.getElementType("DIV_EXPR");
  IElementType ELVIS_EXPR = OpenSCADElementFactory.getElementType("ELVIS_EXPR");
  IElementType EMPTY_OBJ = OpenSCADElementFactory.getElementType("EMPTY_OBJ");
  IElementType EXPR = OpenSCADElementFactory.getElementType("EXPR");
  IElementType FOR_ELEMENT = OpenSCADElementFactory.getElementType("FOR_ELEMENT");
  IElementType FOR_OBJ = OpenSCADElementFactory.getElementType("FOR_OBJ");
  IElementType FULL_ARG_DECLARATION = OpenSCADElementFactory.getElementType("FULL_ARG_DECLARATION");
  IElementType FULL_ARG_DECLARATION_LIST = OpenSCADElementFactory.getElementType("FULL_ARG_DECLARATION_LIST");
  IElementType FUNCTION_CALL_EXPR = OpenSCADElementFactory.getElementType("FUNCTION_CALL_EXPR");
  IElementType FUNCTION_DECLARATION = OpenSCADElementFactory.getElementType("FUNCTION_DECLARATION");
  IElementType FUNCTION_NAME_REF = OpenSCADElementFactory.getElementType("FUNCTION_NAME_REF");
  IElementType IF_ELEMENT = OpenSCADElementFactory.getElementType("IF_ELEMENT");
  IElementType IF_OBJ = OpenSCADElementFactory.getElementType("IF_OBJ");
  IElementType INCLUDE_ITEM = OpenSCADElementFactory.getElementType("INCLUDE_ITEM");
  IElementType INCLUDE_PATH_REF = OpenSCADElementFactory.getElementType("INCLUDE_PATH_REF");
  IElementType INDEX_EXPR = OpenSCADElementFactory.getElementType("INDEX_EXPR");
  IElementType LET_ELEMENT = OpenSCADElementFactory.getElementType("LET_ELEMENT");
  IElementType LIST_COMPREHENSION_EXPR = OpenSCADElementFactory.getElementType("LIST_COMPREHENSION_EXPR");
  IElementType LITERAL_EXPR = OpenSCADElementFactory.getElementType("LITERAL_EXPR");
  IElementType MINUS_EXPR = OpenSCADElementFactory.getElementType("MINUS_EXPR");
  IElementType MODIFIER_OP = OpenSCADElementFactory.getElementType("MODIFIER_OP");
  IElementType MODULE_CALL_OBJ = OpenSCADElementFactory.getElementType("MODULE_CALL_OBJ");
  IElementType MODULE_CALL_OP = OpenSCADElementFactory.getElementType("MODULE_CALL_OP");
  IElementType MODULE_DECLARATION = OpenSCADElementFactory.getElementType("MODULE_DECLARATION");
  IElementType MODULE_OBJ_NAME_REF = OpenSCADElementFactory.getElementType("MODULE_OBJ_NAME_REF");
  IElementType MODULE_OP_NAME_REF = OpenSCADElementFactory.getElementType("MODULE_OP_NAME_REF");
  IElementType MODULO_EXPR = OpenSCADElementFactory.getElementType("MODULO_EXPR");
  IElementType MUL_EXPR = OpenSCADElementFactory.getElementType("MUL_EXPR");
  IElementType OBJECT = OpenSCADElementFactory.getElementType("OBJECT");
  IElementType OPERATOR = OpenSCADElementFactory.getElementType("OPERATOR");
  IElementType OR_EXPR = OpenSCADElementFactory.getElementType("OR_EXPR");
  IElementType PARAMETER_REFERENCE = OpenSCADElementFactory.getElementType("PARAMETER_REFERENCE");
  IElementType PAREN_EXPR = OpenSCADElementFactory.getElementType("PAREN_EXPR");
  IElementType PLUS_EXPR = OpenSCADElementFactory.getElementType("PLUS_EXPR");
  IElementType QUALIFICATION_EXPR = OpenSCADElementFactory.getElementType("QUALIFICATION_EXPR");
  IElementType RANGE_EXPR = OpenSCADElementFactory.getElementType("RANGE_EXPR");
  IElementType ROOT_OP = OpenSCADElementFactory.getElementType("ROOT_OP");
  IElementType UNARY_MIN_EXPR = OpenSCADElementFactory.getElementType("UNARY_MIN_EXPR");
  IElementType UNARY_NEGATE_EXPR = OpenSCADElementFactory.getElementType("UNARY_NEGATE_EXPR");
  IElementType UNARY_PLUS_EXPR = OpenSCADElementFactory.getElementType("UNARY_PLUS_EXPR");
  IElementType USE_ITEM = OpenSCADElementFactory.getElementType("USE_ITEM");
  IElementType VARIABLE_DECLARATION = OpenSCADElementFactory.getElementType("VARIABLE_DECLARATION");
  IElementType VARIABLE_REF_EXPR = OpenSCADElementFactory.getElementType("VARIABLE_REF_EXPR");
  IElementType VECTOR_EXPR = OpenSCADElementFactory.getElementType("VECTOR_EXPR");

  IElementType AND = new OpenSCADTokenType("AND");
  IElementType BLOCK_COMMENT = new OpenSCADTokenType("BLOCK_COMMENT");
  IElementType COLON = new OpenSCADTokenType("COLON");
  IElementType COMMA = new OpenSCADTokenType("COMMA");
  IElementType C_STYLE_COMMENT = new OpenSCADTokenType("C_STYLE_COMMENT");
  IElementType DIV = new OpenSCADTokenType("DIV");
  IElementType DOC_COMMENT = new OpenSCADTokenType("DOC_COMMENT");
  IElementType DOT = new OpenSCADTokenType("DOT");
  IElementType ELSE_KEYWORD = new OpenSCADTokenType("ELSE_KEYWORD");
  IElementType END_OF_LINE_COMMENT = new OpenSCADTokenType("END_OF_LINE_COMMENT");
  IElementType EQ = new OpenSCADTokenType("EQ");
  IElementType EQUALS = new OpenSCADTokenType("EQUALS");
  IElementType EXCL = new OpenSCADTokenType("EXCL");
  IElementType FALSE_KEYWORD = new OpenSCADTokenType("FALSE_KEYWORD");
  IElementType FOR_KEYWORD = new OpenSCADTokenType("FOR_KEYWORD");
  IElementType FUNCTION_KEYWORD = new OpenSCADTokenType("FUNCTION_KEYWORD");
  IElementType GE = new OpenSCADTokenType("GE");
  IElementType GT = new OpenSCADTokenType("GT");
  IElementType HASH = new OpenSCADTokenType("HASH");
  IElementType IDENTIFIER = new OpenSCADTokenType("IDENTIFIER");
  IElementType IF_KEYWORD = new OpenSCADTokenType("IF_KEYWORD");
  IElementType INCLUDE_END = new OpenSCADTokenType("INCLUDE_END");
  IElementType INCLUDE_KEYWORD = new OpenSCADTokenType("INCLUDE_KEYWORD");
  IElementType INCLUDE_PATH = new OpenSCADTokenType("INCLUDE_PATH");
  IElementType INCLUDE_START = new OpenSCADTokenType("INCLUDE_START");
  IElementType LBRACE = new OpenSCADTokenType("LBRACE");
  IElementType LBRACKET = new OpenSCADTokenType("LBRACKET");
  IElementType LE = new OpenSCADTokenType("LE");
  IElementType LET_KEYWORD = new OpenSCADTokenType("LET_KEYWORD");
  IElementType LPARENTH = new OpenSCADTokenType("LPARENTH");
  IElementType LT = new OpenSCADTokenType("LT");
  IElementType MINUS = new OpenSCADTokenType("MINUS");
  IElementType MODULE_KEYWORD = new OpenSCADTokenType("MODULE_KEYWORD");
  IElementType MUL = new OpenSCADTokenType("MUL");
  IElementType NE = new OpenSCADTokenType("NE");
  IElementType NUMBER_LITERAL = new OpenSCADTokenType("NUMBER_LITERAL");
  IElementType OR = new OpenSCADTokenType("OR");
  IElementType PERC = new OpenSCADTokenType("PERC");
  IElementType PLUS = new OpenSCADTokenType("PLUS");
  IElementType QUERY = new OpenSCADTokenType("QUERY");
  IElementType RBRACE = new OpenSCADTokenType("RBRACE");
  IElementType RBRACKET = new OpenSCADTokenType("RBRACKET");
  IElementType RPARENTH = new OpenSCADTokenType("RPARENTH");
  IElementType SEMICOLON = new OpenSCADTokenType("SEMICOLON");
  IElementType STRING_LITERAL = new OpenSCADTokenType("STRING_LITERAL");
  IElementType TRUE_KEYWORD = new OpenSCADTokenType("TRUE_KEYWORD");
  IElementType UNDEF_KEYWORD = new OpenSCADTokenType("UNDEF_KEYWORD");
  IElementType USE_KEYWORD = new OpenSCADTokenType("USE_KEYWORD");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == AND_EXPR) {
        return new OpenSCADAndExprImpl(node);
      }
      else if (type == ARG_ASSIGNMENT) {
        return new OpenSCADArgAssignmentImpl(node);
      }
      else if (type == ARG_ASSIGNMENT_LIST) {
        return new OpenSCADArgAssignmentListImpl(node);
      }
      else if (type == ARG_DECLARATION) {
        return new OpenSCADArgDeclarationImpl(node);
      }
      else if (type == ARG_DECLARATION_LIST) {
        return new OpenSCADArgDeclarationListImpl(node);
      }
      else if (type == BACKGROUND_OP) {
        return new OpenSCADBackgroundOpImpl(node);
      }
      else if (type == BLOCK_OBJ) {
        return new OpenSCADBlockObjImpl(node);
      }
      else if (type == BUILTIN_EXPR) {
        return new OpenSCADBuiltinExprImpl(node);
      }
      else if (type == BUILTIN_EXPR_REF) {
        return new OpenSCADBuiltinExprRefImpl(node);
      }
      else if (type == BUILTIN_OBJ) {
        return new OpenSCADBuiltinObjImpl(node);
      }
      else if (type == BUILTIN_OBJ_REF) {
        return new OpenSCADBuiltinObjRefImpl(node);
      }
      else if (type == BUILTIN_OP) {
        return new OpenSCADBuiltinOpImpl(node);
      }
      else if (type == COMMON_OP_REF) {
        return new OpenSCADCommonOpRefImpl(node);
      }
      else if (type == CONDITIONAL_EXPR) {
        return new OpenSCADConditionalExprImpl(node);
      }
      else if (type == DEBUG_OP) {
        return new OpenSCADDebugOpImpl(node);
      }
      else if (type == DISABLE_OP) {
        return new OpenSCADDisableOpImpl(node);
      }
      else if (type == DIV_EXPR) {
        return new OpenSCADDivExprImpl(node);
      }
      else if (type == ELVIS_EXPR) {
        return new OpenSCADElvisExprImpl(node);
      }
      else if (type == EMPTY_OBJ) {
        return new OpenSCADEmptyObjImpl(node);
      }
      else if (type == FOR_ELEMENT) {
        return new OpenSCADForElementImpl(node);
      }
      else if (type == FOR_OBJ) {
        return new OpenSCADForObjImpl(node);
      }
      else if (type == FULL_ARG_DECLARATION) {
        return new OpenSCADFullArgDeclarationImpl(node);
      }
      else if (type == FULL_ARG_DECLARATION_LIST) {
        return new OpenSCADFullArgDeclarationListImpl(node);
      }
      else if (type == FUNCTION_CALL_EXPR) {
        return new OpenSCADFunctionCallExprImpl(node);
      }
      else if (type == FUNCTION_DECLARATION) {
        return new OpenSCADFunctionDeclarationImpl(node);
      }
      else if (type == FUNCTION_NAME_REF) {
        return new OpenSCADFunctionNameRefImpl(node);
      }
      else if (type == IF_ELEMENT) {
        return new OpenSCADIfElementImpl(node);
      }
      else if (type == IF_OBJ) {
        return new OpenSCADIfObjImpl(node);
      }
      else if (type == INCLUDE_ITEM) {
        return new OpenSCADIncludeItemImpl(node);
      }
      else if (type == INCLUDE_PATH_REF) {
        return new OpenSCADIncludePathRefImpl(node);
      }
      else if (type == INDEX_EXPR) {
        return new OpenSCADIndexExprImpl(node);
      }
      else if (type == LET_ELEMENT) {
        return new OpenSCADLetElementImpl(node);
      }
      else if (type == LIST_COMPREHENSION_EXPR) {
        return new OpenSCADListComprehensionExprImpl(node);
      }
      else if (type == LITERAL_EXPR) {
        return new OpenSCADLiteralExprImpl(node);
      }
      else if (type == MINUS_EXPR) {
        return new OpenSCADMinusExprImpl(node);
      }
      else if (type == MODULE_CALL_OBJ) {
        return new OpenSCADModuleCallObjImpl(node);
      }
      else if (type == MODULE_CALL_OP) {
        return new OpenSCADModuleCallOpImpl(node);
      }
      else if (type == MODULE_DECLARATION) {
        return new OpenSCADModuleDeclarationImpl(node);
      }
      else if (type == MODULE_OBJ_NAME_REF) {
        return new OpenSCADModuleObjNameRefImpl(node);
      }
      else if (type == MODULE_OP_NAME_REF) {
        return new OpenSCADModuleOpNameRefImpl(node);
      }
      else if (type == MODULO_EXPR) {
        return new OpenSCADModuloExprImpl(node);
      }
      else if (type == MUL_EXPR) {
        return new OpenSCADMulExprImpl(node);
      }
      else if (type == OBJECT) {
        return new OpenSCADObjectImpl(node);
      }
      else if (type == OR_EXPR) {
        return new OpenSCADOrExprImpl(node);
      }
      else if (type == PARAMETER_REFERENCE) {
        return new OpenSCADParameterReferenceImpl(node);
      }
      else if (type == PAREN_EXPR) {
        return new OpenSCADParenExprImpl(node);
      }
      else if (type == PLUS_EXPR) {
        return new OpenSCADPlusExprImpl(node);
      }
      else if (type == QUALIFICATION_EXPR) {
        return new OpenSCADQualificationExprImpl(node);
      }
      else if (type == RANGE_EXPR) {
        return new OpenSCADRangeExprImpl(node);
      }
      else if (type == ROOT_OP) {
        return new OpenSCADRootOpImpl(node);
      }
      else if (type == UNARY_MIN_EXPR) {
        return new OpenSCADUnaryMinExprImpl(node);
      }
      else if (type == UNARY_NEGATE_EXPR) {
        return new OpenSCADUnaryNegateExprImpl(node);
      }
      else if (type == UNARY_PLUS_EXPR) {
        return new OpenSCADUnaryPlusExprImpl(node);
      }
      else if (type == USE_ITEM) {
        return new OpenSCADUseItemImpl(node);
      }
      else if (type == VARIABLE_DECLARATION) {
        return new OpenSCADVariableDeclarationImpl(node);
      }
      else if (type == VARIABLE_REF_EXPR) {
        return new OpenSCADVariableRefExprImpl(node);
      }
      else if (type == VECTOR_EXPR) {
        return new OpenSCADVectorExprImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
