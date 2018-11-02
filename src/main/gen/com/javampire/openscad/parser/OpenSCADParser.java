// This is a generated file. Not intended for manual editing.
package com.javampire.openscad.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static com.javampire.openscad.psi.OpenSCADTypes.*;
import static com.javampire.openscad.parser.OpenSCADParserUtil.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class OpenSCADParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, EXTENDS_SETS_);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    if (t == ARG_ASSIGNMENT) {
      r = arg_assignment(b, 0);
    }
    else if (t == ARG_ASSIGNMENT_LIST) {
      r = arg_assignment_list(b, 0);
    }
    else if (t == ARG_DECLARATION) {
      r = arg_declaration(b, 0);
    }
    else if (t == ARG_DECLARATION_LIST) {
      r = arg_declaration_list(b, 0);
    }
    else if (t == BACKGROUND_OP) {
      r = background_op(b, 0);
    }
    else if (t == BLOCK_OBJ) {
      r = block_obj(b, 0);
    }
    else if (t == BUILTIN_EXPR_REF) {
      r = builtin_expr_ref(b, 0);
    }
    else if (t == BUILTIN_OBJ) {
      r = builtin_obj(b, 0);
    }
    else if (t == BUILTIN_OBJ_REF) {
      r = builtin_obj_ref(b, 0);
    }
    else if (t == BUILTIN_OP) {
      r = builtin_op(b, 0);
    }
    else if (t == COMMON_OP_REF) {
      r = common_op_ref(b, 0);
    }
    else if (t == DEBUG_OP) {
      r = debug_op(b, 0);
    }
    else if (t == DISABLE_OP) {
      r = disable_op(b, 0);
    }
    else if (t == ELSE_OP) {
      r = else_op(b, 0);
    }
    else if (t == EMPTY_OBJ) {
      r = empty_obj(b, 0);
    }
    else if (t == EXPR) {
      r = expr(b, 0, -1);
    }
    else if (t == FOR_ELEMENT) {
      r = for_element(b, 0);
    }
    else if (t == FULL_ARG_DECLARATION) {
      r = full_arg_declaration(b, 0);
    }
    else if (t == FULL_ARG_DECLARATION_LIST) {
      r = full_arg_declaration_list(b, 0);
    }
    else if (t == FUNCTION_DECLARATION) {
      r = function_declaration(b, 0);
    }
    else if (t == FUNCTION_NAME_REF) {
      r = function_name_ref(b, 0);
    }
    else if (t == IF_ELEMENT) {
      r = if_element(b, 0);
    }
    else if (t == IF_OP) {
      r = if_op(b, 0);
    }
    else if (t == INCLUDE_ITEM) {
      r = include_item(b, 0);
    }
    else if (t == LET_ELEMENT) {
      r = let_element(b, 0);
    }
    else if (t == MODIFIER_OP) {
      r = modifier_op(b, 0);
    }
    else if (t == MODULE_CALL_OBJ) {
      r = module_call_obj(b, 0);
    }
    else if (t == MODULE_CALL_OP) {
      r = module_call_op(b, 0);
    }
    else if (t == MODULE_DECLARATION) {
      r = module_declaration(b, 0);
    }
    else if (t == MODULE_OBJ_NAME_REF) {
      r = module_obj_name_ref(b, 0);
    }
    else if (t == MODULE_OP_NAME_REF) {
      r = module_op_name_ref(b, 0);
    }
    else if (t == OBJECT) {
      r = object(b, 0);
    }
    else if (t == OPERATOR) {
      r = operator(b, 0);
    }
    else if (t == PARAMETER_REFERENCE) {
      r = parameter_reference(b, 0);
    }
    else if (t == ROOT_OP) {
      r = root_op(b, 0);
    }
    else if (t == USE_ITEM) {
      r = use_item(b, 0);
    }
    else if (t == VARIABLE_DECLARATION) {
      r = variable_declaration(b, 0);
    }
    else {
      r = parse_root_(t, b, 0);
    }
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return openSCADFile(b, l + 1);
  }

  public static final TokenSet[] EXTENDS_SETS_ = new TokenSet[] {
    create_token_set_(BLOCK_OBJ, BUILTIN_OBJ, EMPTY_OBJ, MODULE_CALL_OBJ,
      OBJECT),
    create_token_set_(BACKGROUND_OP, BUILTIN_OP, DEBUG_OP, DISABLE_OP,
      ELSE_OP, IF_OP, MODIFIER_OP, MODULE_CALL_OP,
      OPERATOR, ROOT_OP),
    create_token_set_(AND_EXPR, BUILTIN_EXPR, CONDITIONAL_EXPR, DIV_EXPR,
      ELVIS_EXPR, EXPR, FUNCTION_CALL_EXPR, INDEX_EXPR,
      LIST_COMPREHENSION_EXPR, LITERAL_EXPR, MINUS_EXPR, MODULO_EXPR,
      MUL_EXPR, OR_EXPR, PAREN_EXPR, PLUS_EXPR,
      QUALIFICATION_EXPR, RANGE_EXPR, UNARY_MIN_EXPR, UNARY_NEGATE_EXPR,
      UNARY_PLUS_EXPR, VARIABLE_REF_EXPR, VECTOR_EXPR),
  };

  /* ********************************************************** */
  // [ parameter_reference EQUALS ] expr
  public static boolean arg_assignment(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "arg_assignment")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ARG_ASSIGNMENT, "<arg assignment>");
    r = arg_assignment_0(b, l + 1);
    r = r && expr(b, l + 1, -1);
    exit_section_(b, l, m, r, false, recover_arg_parser_);
    return r;
  }

  // [ parameter_reference EQUALS ]
  private static boolean arg_assignment_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "arg_assignment_0")) return false;
    arg_assignment_0_0(b, l + 1);
    return true;
  }

  // parameter_reference EQUALS
  private static boolean arg_assignment_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "arg_assignment_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = parameter_reference(b, l + 1);
    r = r && consumeToken(b, EQUALS);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // LPARENTH arg_assignment? ( COMMA+ arg_assignment )* RPARENTH
  public static boolean arg_assignment_list(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "arg_assignment_list")) return false;
    if (!nextTokenIs(b, LPARENTH)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, ARG_ASSIGNMENT_LIST, null);
    r = consumeToken(b, LPARENTH);
    p = r; // pin = 1
    r = r && report_error_(b, arg_assignment_list_1(b, l + 1));
    r = p && report_error_(b, arg_assignment_list_2(b, l + 1)) && r;
    r = p && consumeToken(b, RPARENTH) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // arg_assignment?
  private static boolean arg_assignment_list_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "arg_assignment_list_1")) return false;
    arg_assignment(b, l + 1);
    return true;
  }

  // ( COMMA+ arg_assignment )*
  private static boolean arg_assignment_list_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "arg_assignment_list_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!arg_assignment_list_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "arg_assignment_list_2", c)) break;
    }
    return true;
  }

  // COMMA+ arg_assignment
  private static boolean arg_assignment_list_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "arg_assignment_list_2_0")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = arg_assignment_list_2_0_0(b, l + 1);
    p = r; // pin = 1
    r = r && arg_assignment(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // COMMA+
  private static boolean arg_assignment_list_2_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "arg_assignment_list_2_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    while (r) {
      int c = current_position_(b);
      if (!consumeToken(b, COMMA)) break;
      if (!empty_element_parsed_guard_(b, "arg_assignment_list_2_0_0", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // IDENTIFIER [EQUALS expr]
  public static boolean arg_declaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "arg_declaration")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ARG_DECLARATION, "<arg declaration>");
    r = consumeToken(b, IDENTIFIER);
    r = r && arg_declaration_1(b, l + 1);
    exit_section_(b, l, m, r, false, recover_arg_parser_);
    return r;
  }

  // [EQUALS expr]
  private static boolean arg_declaration_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "arg_declaration_1")) return false;
    arg_declaration_1_0(b, l + 1);
    return true;
  }

  // EQUALS expr
  private static boolean arg_declaration_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "arg_declaration_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, EQUALS);
    r = r && expr(b, l + 1, -1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // LPARENTH arg_declaration? ( COMMA arg_declaration? )* RPARENTH
  public static boolean arg_declaration_list(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "arg_declaration_list")) return false;
    if (!nextTokenIs(b, LPARENTH)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, ARG_DECLARATION_LIST, null);
    r = consumeToken(b, LPARENTH);
    p = r; // pin = 1
    r = r && report_error_(b, arg_declaration_list_1(b, l + 1));
    r = p && report_error_(b, arg_declaration_list_2(b, l + 1)) && r;
    r = p && consumeToken(b, RPARENTH) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // arg_declaration?
  private static boolean arg_declaration_list_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "arg_declaration_list_1")) return false;
    arg_declaration(b, l + 1);
    return true;
  }

  // ( COMMA arg_declaration? )*
  private static boolean arg_declaration_list_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "arg_declaration_list_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!arg_declaration_list_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "arg_declaration_list_2", c)) break;
    }
    return true;
  }

  // COMMA arg_declaration?
  private static boolean arg_declaration_list_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "arg_declaration_list_2_0")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = consumeToken(b, COMMA);
    p = r; // pin = 1
    r = r && arg_declaration_list_2_0_1(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // arg_declaration?
  private static boolean arg_declaration_list_2_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "arg_declaration_list_2_0_1")) return false;
    arg_declaration(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // PERC
  public static boolean background_op(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "background_op")) return false;
    if (!nextTokenIs(b, PERC)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, PERC);
    exit_section_(b, m, BACKGROUND_OP, r);
    return r;
  }

  /* ********************************************************** */
  // LBRACE statement* RBRACE
  public static boolean block_obj(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block_obj")) return false;
    if (!nextTokenIs(b, LBRACE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LBRACE);
    r = r && block_obj_1(b, l + 1);
    r = r && consumeToken(b, RBRACE);
    exit_section_(b, m, BLOCK_OBJ, r);
    return r;
  }

  // statement*
  private static boolean block_obj_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block_obj_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!statement(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "block_obj_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // "cos"
  //                    | "sin"
  //                    | "tan"
  //                    | "acos"
  //                    | "asin"
  //                    | "atan"
  //                    | "atan2"
  //                    | "abs"
  //                    | "ceil"
  //                    | "concat"
  //                    | "cross"
  //                    | "exp"
  //                    | "floor"
  //                    | "ln"
  //                    | "len"
  //                    | "log"
  //                    | "lookup"
  //                    | "max"
  //                    | "min"
  //                    | "norm"
  //                    | "pow"
  //                    | "rands"
  //                    | "round"
  //                    | "sign"
  //                    | "sqrt"
  //                    | "str"
  //                    | "chr"
  //                    | "select"
  //                    | "search"
  //                    | "version"
  //                    | "version_num"
  //                    | "parent_module"
  public static boolean builtin_expr_ref(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "builtin_expr_ref")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BUILTIN_EXPR_REF, "<builtin expr ref>");
    r = consumeToken(b, "cos");
    if (!r) r = consumeToken(b, "sin");
    if (!r) r = consumeToken(b, "tan");
    if (!r) r = consumeToken(b, "acos");
    if (!r) r = consumeToken(b, "asin");
    if (!r) r = consumeToken(b, "atan");
    if (!r) r = consumeToken(b, "atan2");
    if (!r) r = consumeToken(b, "abs");
    if (!r) r = consumeToken(b, "ceil");
    if (!r) r = consumeToken(b, "concat");
    if (!r) r = consumeToken(b, "cross");
    if (!r) r = consumeToken(b, "exp");
    if (!r) r = consumeToken(b, "floor");
    if (!r) r = consumeToken(b, "ln");
    if (!r) r = consumeToken(b, "len");
    if (!r) r = consumeToken(b, "log");
    if (!r) r = consumeToken(b, "lookup");
    if (!r) r = consumeToken(b, "max");
    if (!r) r = consumeToken(b, "min");
    if (!r) r = consumeToken(b, "norm");
    if (!r) r = consumeToken(b, "pow");
    if (!r) r = consumeToken(b, "rands");
    if (!r) r = consumeToken(b, "round");
    if (!r) r = consumeToken(b, "sign");
    if (!r) r = consumeToken(b, "sqrt");
    if (!r) r = consumeToken(b, "str");
    if (!r) r = consumeToken(b, "chr");
    if (!r) r = consumeToken(b, "select");
    if (!r) r = consumeToken(b, "search");
    if (!r) r = consumeToken(b, "version");
    if (!r) r = consumeToken(b, "version_num");
    if (!r) r = consumeToken(b, "parent_module");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // builtin_obj_ref arg_assignment_list SEMICOLON
  public static boolean builtin_obj(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "builtin_obj")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BUILTIN_OBJ, "<builtin obj>");
    r = builtin_obj_ref(b, l + 1);
    r = r && arg_assignment_list(b, l + 1);
    r = r && consumeToken(b, SEMICOLON);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // "cube"
  //                   | "cylinder"
  //                   | "echo"
  //                   | "assert"
  //                   | "sphere"
  //                   | "polyhedron"
  //                   | "square"
  //                   | "circle"
  //                   | "polygon"
  //                   | "text"
  //                   | "surface"
  //                   | "child"
  //                   | "children"
  //                   | "import"
  //                   | "import_dxf"
  //                   | "import_stl"
  public static boolean builtin_obj_ref(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "builtin_obj_ref")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BUILTIN_OBJ_REF, "<builtin obj ref>");
    r = consumeToken(b, "cube");
    if (!r) r = consumeToken(b, "cylinder");
    if (!r) r = consumeToken(b, "echo");
    if (!r) r = consumeToken(b, "assert");
    if (!r) r = consumeToken(b, "sphere");
    if (!r) r = consumeToken(b, "polyhedron");
    if (!r) r = consumeToken(b, "square");
    if (!r) r = consumeToken(b, "circle");
    if (!r) r = consumeToken(b, "polygon");
    if (!r) r = consumeToken(b, "text");
    if (!r) r = consumeToken(b, "surface");
    if (!r) r = consumeToken(b, "child");
    if (!r) r = consumeToken(b, "children");
    if (!r) r = consumeToken(b, "import");
    if (!r) r = consumeToken(b, "import_dxf");
    if (!r) r = consumeToken(b, "import_stl");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // else_op // else_op needs to be before if_op here
  //              | if_op
  //              | (common_op_ref arg_assignment_list)
  //              | (full_arg_op_identifier full_arg_declaration_list)
  public static boolean builtin_op(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "builtin_op")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _COLLAPSE_, BUILTIN_OP, "<builtin op>");
    r = else_op(b, l + 1);
    if (!r) r = if_op(b, l + 1);
    if (!r) r = builtin_op_2(b, l + 1);
    if (!r) r = builtin_op_3(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // common_op_ref arg_assignment_list
  private static boolean builtin_op_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "builtin_op_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = common_op_ref(b, l + 1);
    r = r && arg_assignment_list(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // full_arg_op_identifier full_arg_declaration_list
  private static boolean builtin_op_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "builtin_op_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = full_arg_op_identifier(b, l + 1);
    r = r && full_arg_declaration_list(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // C_STYLE_COMMENT | DOC_COMMENT | END_OF_LINE_COMMENT | BLOCK_COMMENT
  static boolean comment_item(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "comment_item")) return false;
    boolean r;
    r = consumeToken(b, C_STYLE_COMMENT);
    if (!r) r = consumeToken(b, DOC_COMMENT);
    if (!r) r = consumeToken(b, END_OF_LINE_COMMENT);
    if (!r) r = consumeToken(b, BLOCK_COMMENT);
    return r;
  }

  /* ********************************************************** */
  // "linear_extrude"
  //                 | "rotate_extrude"
  //                 | "rotate"
  //                 | "translate"
  //                 | "scale"
  //                 | "resize"
  //                 | "mirror"
  //                 | "multmatrix"
  //                 | "color"
  //                 | "offset"
  //                 | "minkowski"
  //                 | "hull"
  //                 | "union"
  //                 | "difference"
  //                 | "intersection"
  //                 | "render"
  //                 | "projection"
  public static boolean common_op_ref(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "common_op_ref")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, COMMON_OP_REF, "<common op ref>");
    r = consumeToken(b, "linear_extrude");
    if (!r) r = consumeToken(b, "rotate_extrude");
    if (!r) r = consumeToken(b, "rotate");
    if (!r) r = consumeToken(b, "translate");
    if (!r) r = consumeToken(b, "scale");
    if (!r) r = consumeToken(b, "resize");
    if (!r) r = consumeToken(b, "mirror");
    if (!r) r = consumeToken(b, "multmatrix");
    if (!r) r = consumeToken(b, "color");
    if (!r) r = consumeToken(b, "offset");
    if (!r) r = consumeToken(b, "minkowski");
    if (!r) r = consumeToken(b, "hull");
    if (!r) r = consumeToken(b, "union");
    if (!r) r = consumeToken(b, "difference");
    if (!r) r = consumeToken(b, "intersection");
    if (!r) r = consumeToken(b, "render");
    if (!r) r = consumeToken(b, "projection");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // operator object
  static boolean compound_obj(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "compound_obj")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = operator(b, l + 1);
    r = r && object(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // HASH
  public static boolean debug_op(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "debug_op")) return false;
    if (!nextTokenIs(b, HASH)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, HASH);
    exit_section_(b, m, DEBUG_OP, r);
    return r;
  }

  /* ********************************************************** */
  // variable_declaration | module_declaration | function_declaration
  static boolean declaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "declaration")) return false;
    boolean r;
    r = variable_declaration(b, l + 1);
    if (!r) r = module_declaration(b, l + 1);
    if (!r) r = function_declaration(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // MUL
  public static boolean disable_op(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "disable_op")) return false;
    if (!nextTokenIs(b, MUL)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, MUL);
    exit_section_(b, m, DISABLE_OP, r);
    return r;
  }

  /* ********************************************************** */
  // if_op object ELSE_KEYWORD
  public static boolean else_op(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "else_op")) return false;
    if (!nextTokenIs(b, IF_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = if_op(b, l + 1);
    r = r && object(b, l + 1);
    r = r && consumeToken(b, ELSE_KEYWORD);
    exit_section_(b, m, ELSE_OP, r);
    return r;
  }

  /* ********************************************************** */
  // SEMICOLON
  public static boolean empty_obj(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "empty_obj")) return false;
    if (!nextTokenIs(b, SEMICOLON)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SEMICOLON);
    exit_section_(b, m, EMPTY_OBJ, r);
    return r;
  }

  /* ********************************************************** */
  // FOR_KEYWORD full_arg_declaration_list
  public static boolean for_element(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "for_element")) return false;
    if (!nextTokenIs(b, FOR_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, FOR_KEYWORD);
    r = r && full_arg_declaration_list(b, l + 1);
    exit_section_(b, m, FOR_ELEMENT, r);
    return r;
  }

  /* ********************************************************** */
  // IDENTIFIER EQUALS expr
  public static boolean full_arg_declaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "full_arg_declaration")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FULL_ARG_DECLARATION, "<full arg declaration>");
    r = consumeTokens(b, 0, IDENTIFIER, EQUALS);
    r = r && expr(b, l + 1, -1);
    exit_section_(b, l, m, r, false, recover_arg_parser_);
    return r;
  }

  /* ********************************************************** */
  // LPARENTH full_arg_declaration? ( COMMA+ full_arg_declaration )* RPARENTH
  public static boolean full_arg_declaration_list(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "full_arg_declaration_list")) return false;
    if (!nextTokenIs(b, LPARENTH)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, FULL_ARG_DECLARATION_LIST, null);
    r = consumeToken(b, LPARENTH);
    p = r; // pin = 1
    r = r && report_error_(b, full_arg_declaration_list_1(b, l + 1));
    r = p && report_error_(b, full_arg_declaration_list_2(b, l + 1)) && r;
    r = p && consumeToken(b, RPARENTH) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // full_arg_declaration?
  private static boolean full_arg_declaration_list_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "full_arg_declaration_list_1")) return false;
    full_arg_declaration(b, l + 1);
    return true;
  }

  // ( COMMA+ full_arg_declaration )*
  private static boolean full_arg_declaration_list_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "full_arg_declaration_list_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!full_arg_declaration_list_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "full_arg_declaration_list_2", c)) break;
    }
    return true;
  }

  // COMMA+ full_arg_declaration
  private static boolean full_arg_declaration_list_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "full_arg_declaration_list_2_0")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = full_arg_declaration_list_2_0_0(b, l + 1);
    p = r; // pin = 1
    r = r && full_arg_declaration(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // COMMA+
  private static boolean full_arg_declaration_list_2_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "full_arg_declaration_list_2_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    while (r) {
      int c = current_position_(b);
      if (!consumeToken(b, COMMA)) break;
      if (!empty_element_parsed_guard_(b, "full_arg_declaration_list_2_0_0", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // "intersection_for"
  //                                  | "assign"
  //                                  | FOR_KEYWORD
  //                                  | LET_KEYWORD
  static boolean full_arg_op_identifier(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "full_arg_op_identifier")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "intersection_for");
    if (!r) r = consumeToken(b, "assign");
    if (!r) r = consumeToken(b, FOR_KEYWORD);
    if (!r) r = consumeToken(b, LET_KEYWORD);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // FUNCTION_KEYWORD IDENTIFIER arg_declaration_list EQUALS expr SEMICOLON
  public static boolean function_declaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_declaration")) return false;
    if (!nextTokenIs(b, FUNCTION_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, FUNCTION_KEYWORD, IDENTIFIER);
    r = r && arg_declaration_list(b, l + 1);
    r = r && consumeToken(b, EQUALS);
    r = r && expr(b, l + 1, -1);
    r = r && consumeToken(b, SEMICOLON);
    exit_section_(b, m, FUNCTION_DECLARATION, r);
    return r;
  }

  /* ********************************************************** */
  // IDENTIFIER
  public static boolean function_name_ref(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_name_ref")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    exit_section_(b, m, FUNCTION_NAME_REF, r);
    return r;
  }

  /* ********************************************************** */
  // IF_KEYWORD LPARENTH expr RPARENTH
  public static boolean if_element(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_element")) return false;
    if (!nextTokenIs(b, IF_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, IF_KEYWORD, LPARENTH);
    r = r && expr(b, l + 1, -1);
    r = r && consumeToken(b, RPARENTH);
    exit_section_(b, m, IF_ELEMENT, r);
    return r;
  }

  /* ********************************************************** */
  // IF_KEYWORD LPARENTH expr RPARENTH
  public static boolean if_op(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_op")) return false;
    if (!nextTokenIs(b, IF_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, IF_KEYWORD, LPARENTH);
    r = r && expr(b, l + 1, -1);
    r = r && consumeToken(b, RPARENTH);
    exit_section_(b, m, IF_OP, r);
    return r;
  }

  /* ********************************************************** */
  // INCLUDE_KEYWORD INCLUDE_START INCLUDE_PATH INCLUDE_END
  public static boolean include_item(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "include_item")) return false;
    if (!nextTokenIs(b, INCLUDE_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, INCLUDE_KEYWORD, INCLUDE_START, INCLUDE_PATH, INCLUDE_END);
    exit_section_(b, m, INCLUDE_ITEM, r);
    return r;
  }

  /* ********************************************************** */
  // statement
  //     | include_item
  //     | use_item
  //     | comment_item
  static boolean item(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "item")) return false;
    boolean r;
    r = statement(b, l + 1);
    if (!r) r = include_item(b, l + 1);
    if (!r) r = use_item(b, l + 1);
    if (!r) r = comment_item(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // LET_KEYWORD full_arg_declaration_list
  public static boolean let_element(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "let_element")) return false;
    if (!nextTokenIs(b, LET_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LET_KEYWORD);
    r = r && full_arg_declaration_list(b, l + 1);
    exit_section_(b, m, LET_ELEMENT, r);
    return r;
  }

  /* ********************************************************** */
  // background_op
  //               | debug_op
  //               | root_op
  //               | disable_op
  public static boolean modifier_op(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "modifier_op")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _COLLAPSE_, MODIFIER_OP, "<modifier op>");
    r = background_op(b, l + 1);
    if (!r) r = debug_op(b, l + 1);
    if (!r) r = root_op(b, l + 1);
    if (!r) r = disable_op(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // module_obj_name_ref arg_assignment_list SEMICOLON
  public static boolean module_call_obj(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_call_obj")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = module_obj_name_ref(b, l + 1);
    r = r && arg_assignment_list(b, l + 1);
    r = r && consumeToken(b, SEMICOLON);
    exit_section_(b, m, MODULE_CALL_OBJ, r);
    return r;
  }

  /* ********************************************************** */
  // module_op_name_ref arg_assignment_list
  public static boolean module_call_op(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_call_op")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = module_op_name_ref(b, l + 1);
    r = r && arg_assignment_list(b, l + 1);
    exit_section_(b, m, MODULE_CALL_OP, r);
    return r;
  }

  /* ********************************************************** */
  // MODULE_KEYWORD IDENTIFIER arg_declaration_list statement
  public static boolean module_declaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_declaration")) return false;
    if (!nextTokenIs(b, MODULE_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, MODULE_KEYWORD, IDENTIFIER);
    r = r && arg_declaration_list(b, l + 1);
    r = r && statement(b, l + 1);
    exit_section_(b, m, MODULE_DECLARATION, r);
    return r;
  }

  /* ********************************************************** */
  // IDENTIFIER
  public static boolean module_obj_name_ref(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_obj_name_ref")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    exit_section_(b, m, MODULE_OBJ_NAME_REF, r);
    return r;
  }

  /* ********************************************************** */
  // IDENTIFIER
  public static boolean module_op_name_ref(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_op_name_ref")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    exit_section_(b, m, MODULE_OP_NAME_REF, r);
    return r;
  }

  /* ********************************************************** */
  // builtin_obj
  //          | module_call_obj
  //          | block_obj
  //          | compound_obj
  //          | empty_obj
  public static boolean object(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "object")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _COLLAPSE_, OBJECT, "<object>");
    r = builtin_obj(b, l + 1);
    if (!r) r = module_call_obj(b, l + 1);
    if (!r) r = block_obj(b, l + 1);
    if (!r) r = compound_obj(b, l + 1);
    if (!r) r = empty_obj(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // item*
  static boolean openSCADFile(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "openSCADFile")) return false;
    while (true) {
      int c = current_position_(b);
      if (!item(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "openSCADFile", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // builtin_op
  //            | modifier_op
  //            | module_call_op
  public static boolean operator(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "operator")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _COLLAPSE_, OPERATOR, "<operator>");
    r = builtin_op(b, l + 1);
    if (!r) r = modifier_op(b, l + 1);
    if (!r) r = module_call_op(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // IDENTIFIER
  public static boolean parameter_reference(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parameter_reference")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    exit_section_(b, m, PARAMETER_REFERENCE, r);
    return r;
  }

  /* ********************************************************** */
  // ! (COMMA | RPARENTH)
  static boolean recover_arg(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "recover_arg")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !recover_arg_0(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // COMMA | RPARENTH
  private static boolean recover_arg_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "recover_arg_0")) return false;
    boolean r;
    r = consumeToken(b, COMMA);
    if (!r) r = consumeToken(b, RPARENTH);
    return r;
  }

  /* ********************************************************** */
  // ! (COMMA | RBRACKET)
  static boolean recover_vector(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "recover_vector")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !recover_vector_0(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // COMMA | RBRACKET
  private static boolean recover_vector_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "recover_vector_0")) return false;
    boolean r;
    r = consumeToken(b, COMMA);
    if (!r) r = consumeToken(b, RBRACKET);
    return r;
  }

  /* ********************************************************** */
  // EXCL
  public static boolean root_op(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "root_op")) return false;
    if (!nextTokenIs(b, EXCL)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, EXCL);
    exit_section_(b, m, ROOT_OP, r);
    return r;
  }

  /* ********************************************************** */
  // object | declaration
  static boolean statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement")) return false;
    boolean r;
    r = object(b, l + 1);
    if (!r) r = declaration(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // USE_KEYWORD INCLUDE_START INCLUDE_PATH INCLUDE_END
  public static boolean use_item(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "use_item")) return false;
    if (!nextTokenIs(b, USE_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, USE_KEYWORD, INCLUDE_START, INCLUDE_PATH, INCLUDE_END);
    exit_section_(b, m, USE_ITEM, r);
    return r;
  }

  /* ********************************************************** */
  // IDENTIFIER EQUALS expr SEMICOLON
  public static boolean variable_declaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variable_declaration")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, IDENTIFIER, EQUALS);
    r = r && expr(b, l + 1, -1);
    r = r && consumeToken(b, SEMICOLON);
    exit_section_(b, m, VARIABLE_DECLARATION, r);
    return r;
  }

  /* ********************************************************** */
  // expr
  static boolean vector_item(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "vector_item")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_);
    r = expr(b, l + 1, -1);
    exit_section_(b, l, m, r, false, recover_vector_parser_);
    return r;
  }

  /* ********************************************************** */
  // Expression root: expr
  // Operator priority table:
  // 0: BINARY(elvis_expr) BINARY(conditional_expr)
  // 1: BINARY(and_expr) BINARY(or_expr)
  // 2: BINARY(plus_expr) BINARY(minus_expr)
  // 3: BINARY(mul_expr) BINARY(div_expr) BINARY(modulo_expr)
  // 4: PREFIX(unary_plus_expr) PREFIX(unary_min_expr) PREFIX(unary_negate_expr)
  // 5: PREFIX(paren_expr) PREFIX(list_comprehension_expr) ATOM(range_expr) ATOM(vector_expr)
  //    ATOM(literal_expr) ATOM(builtin_expr) ATOM(function_call_expr) POSTFIX(index_expr)
  //    POSTFIX(qualification_expr) ATOM(variable_ref_expr)
  public static boolean expr(PsiBuilder b, int l, int g) {
    if (!recursion_guard_(b, l, "expr")) return false;
    addVariant(b, "<expr>");
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, "<expr>");
    r = unary_plus_expr(b, l + 1);
    if (!r) r = unary_min_expr(b, l + 1);
    if (!r) r = unary_negate_expr(b, l + 1);
    if (!r) r = paren_expr(b, l + 1);
    if (!r) r = list_comprehension_expr(b, l + 1);
    if (!r) r = range_expr(b, l + 1);
    if (!r) r = vector_expr(b, l + 1);
    if (!r) r = literal_expr(b, l + 1);
    if (!r) r = builtin_expr(b, l + 1);
    if (!r) r = function_call_expr(b, l + 1);
    if (!r) r = variable_ref_expr(b, l + 1);
    p = r;
    r = r && expr_0(b, l + 1, g);
    exit_section_(b, l, m, null, r, p, null);
    return r || p;
  }

  public static boolean expr_0(PsiBuilder b, int l, int g) {
    if (!recursion_guard_(b, l, "expr_0")) return false;
    boolean r = true;
    while (true) {
      Marker m = enter_section_(b, l, _LEFT_, null);
      if (g < 0 && consumeTokenSmart(b, QUERY)) {
        r = report_error_(b, expr(b, l, 0));
        r = elvis_expr_1(b, l + 1) && r;
        exit_section_(b, l, m, ELVIS_EXPR, r, true, null);
      }
      else if (g < 0 && conditional_expr_0(b, l + 1)) {
        r = expr(b, l, 0);
        exit_section_(b, l, m, CONDITIONAL_EXPR, r, true, null);
      }
      else if (g < 1 && consumeTokenSmart(b, AND)) {
        r = expr(b, l, 1);
        exit_section_(b, l, m, AND_EXPR, r, true, null);
      }
      else if (g < 1 && consumeTokenSmart(b, OR)) {
        r = expr(b, l, 1);
        exit_section_(b, l, m, OR_EXPR, r, true, null);
      }
      else if (g < 2 && consumeTokenSmart(b, PLUS)) {
        r = expr(b, l, 2);
        exit_section_(b, l, m, PLUS_EXPR, r, true, null);
      }
      else if (g < 2 && consumeTokenSmart(b, MINUS)) {
        r = expr(b, l, 2);
        exit_section_(b, l, m, MINUS_EXPR, r, true, null);
      }
      else if (g < 3 && consumeTokenSmart(b, MUL)) {
        r = expr(b, l, 3);
        exit_section_(b, l, m, MUL_EXPR, r, true, null);
      }
      else if (g < 3 && consumeTokenSmart(b, DIV)) {
        r = expr(b, l, 3);
        exit_section_(b, l, m, DIV_EXPR, r, true, null);
      }
      else if (g < 3 && consumeTokenSmart(b, PERC)) {
        r = expr(b, l, 3);
        exit_section_(b, l, m, MODULO_EXPR, r, true, null);
      }
      else if (g < 5 && index_expr_0(b, l + 1)) {
        r = true;
        exit_section_(b, l, m, INDEX_EXPR, r, true, null);
      }
      else if (g < 5 && parseTokensSmart(b, 0, DOT, IDENTIFIER)) {
        r = true;
        exit_section_(b, l, m, QUALIFICATION_EXPR, r, true, null);
      }
      else {
        exit_section_(b, l, m, null, false, false, null);
        break;
      }
    }
    return r;
  }

  // COLON expr
  private static boolean elvis_expr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "elvis_expr_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COLON);
    r = r && expr(b, l + 1, -1);
    exit_section_(b, m, null, r);
    return r;
  }

  // LT | GT | LE | GE | EQ | NE
  private static boolean conditional_expr_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "conditional_expr_0")) return false;
    boolean r;
    r = consumeTokenSmart(b, LT);
    if (!r) r = consumeTokenSmart(b, GT);
    if (!r) r = consumeTokenSmart(b, LE);
    if (!r) r = consumeTokenSmart(b, GE);
    if (!r) r = consumeTokenSmart(b, EQ);
    if (!r) r = consumeTokenSmart(b, NE);
    return r;
  }

  public static boolean unary_plus_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unary_plus_expr")) return false;
    if (!nextTokenIsSmart(b, PLUS)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, null);
    r = consumeTokenSmart(b, PLUS);
    p = r;
    r = p && expr(b, l, 4);
    exit_section_(b, l, m, UNARY_PLUS_EXPR, r, p, null);
    return r || p;
  }

  public static boolean unary_min_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unary_min_expr")) return false;
    if (!nextTokenIsSmart(b, MINUS)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, null);
    r = consumeTokenSmart(b, MINUS);
    p = r;
    r = p && expr(b, l, 4);
    exit_section_(b, l, m, UNARY_MIN_EXPR, r, p, null);
    return r || p;
  }

  public static boolean unary_negate_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unary_negate_expr")) return false;
    if (!nextTokenIsSmart(b, EXCL)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, null);
    r = consumeTokenSmart(b, EXCL);
    p = r;
    r = p && expr(b, l, 4);
    exit_section_(b, l, m, UNARY_NEGATE_EXPR, r, p, null);
    return r || p;
  }

  public static boolean paren_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "paren_expr")) return false;
    if (!nextTokenIsSmart(b, LPARENTH)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, null);
    r = consumeTokenSmart(b, LPARENTH);
    p = r;
    r = p && expr(b, l, -1);
    r = p && report_error_(b, consumeToken(b, RPARENTH)) && r;
    exit_section_(b, l, m, PAREN_EXPR, r, p, null);
    return r || p;
  }

  public static boolean list_comprehension_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "list_comprehension_expr")) return false;
    if (!nextTokenIsSmart(b, LBRACKET)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, null);
    r = list_comprehension_expr_0(b, l + 1);
    p = r;
    r = p && expr(b, l, -1);
    r = p && report_error_(b, consumeToken(b, RBRACKET)) && r;
    exit_section_(b, l, m, LIST_COMPREHENSION_EXPR, r, p, null);
    return r || p;
  }

  // LBRACKET for_element (for_element | if_element | let_element)*
  private static boolean list_comprehension_expr_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "list_comprehension_expr_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenSmart(b, LBRACKET);
    r = r && for_element(b, l + 1);
    r = r && list_comprehension_expr_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (for_element | if_element | let_element)*
  private static boolean list_comprehension_expr_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "list_comprehension_expr_0_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!list_comprehension_expr_0_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "list_comprehension_expr_0_2", c)) break;
    }
    return true;
  }

  // for_element | if_element | let_element
  private static boolean list_comprehension_expr_0_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "list_comprehension_expr_0_2_0")) return false;
    boolean r;
    r = for_element(b, l + 1);
    if (!r) r = if_element(b, l + 1);
    if (!r) r = let_element(b, l + 1);
    return r;
  }

  // LBRACKET expr COLON expr [ COLON expr ] RBRACKET
  public static boolean range_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "range_expr")) return false;
    if (!nextTokenIsSmart(b, LBRACKET)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenSmart(b, LBRACKET);
    r = r && expr(b, l + 1, -1);
    r = r && consumeToken(b, COLON);
    r = r && expr(b, l + 1, -1);
    r = r && range_expr_4(b, l + 1);
    r = r && consumeToken(b, RBRACKET);
    exit_section_(b, m, RANGE_EXPR, r);
    return r;
  }

  // [ COLON expr ]
  private static boolean range_expr_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "range_expr_4")) return false;
    range_expr_4_0(b, l + 1);
    return true;
  }

  // COLON expr
  private static boolean range_expr_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "range_expr_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenSmart(b, COLON);
    r = r && expr(b, l + 1, -1);
    exit_section_(b, m, null, r);
    return r;
  }

  // LBRACKET [ vector_item ( COMMA+ (vector_item | &RBRACKET) )* ] RBRACKET
  public static boolean vector_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "vector_expr")) return false;
    if (!nextTokenIsSmart(b, LBRACKET)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, VECTOR_EXPR, null);
    r = consumeTokenSmart(b, LBRACKET);
    p = r; // pin = 1
    r = r && report_error_(b, vector_expr_1(b, l + 1));
    r = p && consumeToken(b, RBRACKET) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // [ vector_item ( COMMA+ (vector_item | &RBRACKET) )* ]
  private static boolean vector_expr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "vector_expr_1")) return false;
    vector_expr_1_0(b, l + 1);
    return true;
  }

  // vector_item ( COMMA+ (vector_item | &RBRACKET) )*
  private static boolean vector_expr_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "vector_expr_1_0")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = vector_item(b, l + 1);
    p = r; // pin = 1
    r = r && vector_expr_1_0_1(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // ( COMMA+ (vector_item | &RBRACKET) )*
  private static boolean vector_expr_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "vector_expr_1_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!vector_expr_1_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "vector_expr_1_0_1", c)) break;
    }
    return true;
  }

  // COMMA+ (vector_item | &RBRACKET)
  private static boolean vector_expr_1_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "vector_expr_1_0_1_0")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = vector_expr_1_0_1_0_0(b, l + 1);
    p = r; // pin = 1
    r = r && vector_expr_1_0_1_0_1(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // COMMA+
  private static boolean vector_expr_1_0_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "vector_expr_1_0_1_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenSmart(b, COMMA);
    while (r) {
      int c = current_position_(b);
      if (!consumeTokenSmart(b, COMMA)) break;
      if (!empty_element_parsed_guard_(b, "vector_expr_1_0_1_0_0", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // vector_item | &RBRACKET
  private static boolean vector_expr_1_0_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "vector_expr_1_0_1_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = vector_item(b, l + 1);
    if (!r) r = vector_expr_1_0_1_0_1_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &RBRACKET
  private static boolean vector_expr_1_0_1_0_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "vector_expr_1_0_1_0_1_1")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_);
    r = consumeTokenSmart(b, RBRACKET);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // TRUE_KEYWORD
  //                | FALSE_KEYWORD
  //                | UNDEF_KEYWORD
  //                | NUMBER_LITERAL
  //                | STRING_LITERAL
  public static boolean literal_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "literal_expr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, LITERAL_EXPR, "<literal expr>");
    r = consumeTokenSmart(b, TRUE_KEYWORD);
    if (!r) r = consumeTokenSmart(b, FALSE_KEYWORD);
    if (!r) r = consumeTokenSmart(b, UNDEF_KEYWORD);
    if (!r) r = consumeTokenSmart(b, NUMBER_LITERAL);
    if (!r) r = consumeTokenSmart(b, STRING_LITERAL);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // builtin_expr_ref arg_assignment_list
  //                | LET_KEYWORD full_arg_declaration_list expr
  public static boolean builtin_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "builtin_expr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BUILTIN_EXPR, "<builtin expr>");
    r = builtin_expr_0(b, l + 1);
    if (!r) r = builtin_expr_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // builtin_expr_ref arg_assignment_list
  private static boolean builtin_expr_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "builtin_expr_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = builtin_expr_ref(b, l + 1);
    r = r && arg_assignment_list(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // LET_KEYWORD full_arg_declaration_list expr
  private static boolean builtin_expr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "builtin_expr_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenSmart(b, LET_KEYWORD);
    r = r && full_arg_declaration_list(b, l + 1);
    r = r && expr(b, l + 1, -1);
    exit_section_(b, m, null, r);
    return r;
  }

  // function_name_ref arg_assignment_list
  public static boolean function_call_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_call_expr")) return false;
    if (!nextTokenIsSmart(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = function_name_ref(b, l + 1);
    r = r && arg_assignment_list(b, l + 1);
    exit_section_(b, m, FUNCTION_CALL_EXPR, r);
    return r;
  }

  // LBRACKET <<innerExpression>> RBRACKET
  private static boolean index_expr_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "index_expr_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenSmart(b, LBRACKET);
    r = r && innerExpression(b, l + 1);
    r = r && consumeToken(b, RBRACKET);
    exit_section_(b, m, null, r);
    return r;
  }

  // IDENTIFIER
  public static boolean variable_ref_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variable_ref_expr")) return false;
    if (!nextTokenIsSmart(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenSmart(b, IDENTIFIER);
    exit_section_(b, m, VARIABLE_REF_EXPR, r);
    return r;
  }

  static final Parser recover_arg_parser_ = new Parser() {
    public boolean parse(PsiBuilder b, int l) {
      return recover_arg(b, l + 1);
    }
  };
  static final Parser recover_vector_parser_ = new Parser() {
    public boolean parse(PsiBuilder b, int l) {
      return recover_vector(b, l + 1);
    }
  };
}
