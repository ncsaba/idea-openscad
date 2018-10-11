// This is a generated file. Not intended for manual editing.
package com.javampire.openscad.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static com.javampire.openscad.psi.OpenSCADTypes.*;
import static com.intellij.lang.parser.GeneratedParserUtilBase.*;
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
    if (t == ABS_EXPR) {
      r = abs_expr(b, 0);
    }
    else if (t == ACOS_EXPR) {
      r = acos_expr(b, 0);
    }
    else if (t == ARG_ASSIGNMENT) {
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
    else if (t == ASIN_EXPR) {
      r = asin_expr(b, 0);
    }
    else if (t == ASSERT_OBJ) {
      r = assert_obj(b, 0);
    }
    else if (t == ASSIGN_OP) {
      r = assign_op(b, 0);
    }
    else if (t == ASSIGNMENT) {
      r = assignment(b, 0);
    }
    else if (t == ATAN_2_EXPR) {
      r = atan2_expr(b, 0);
    }
    else if (t == ATAN_EXPR) {
      r = atan_expr(b, 0);
    }
    else if (t == BACKGROUND_OP) {
      r = background_op(b, 0);
    }
    else if (t == BLOCK_OBJ) {
      r = block_obj(b, 0);
    }
    else if (t == BUILTIN_OBJ) {
      r = builtin_obj(b, 0);
    }
    else if (t == BUILTIN_OP) {
      r = builtin_op(b, 0);
    }
    else if (t == CEIL_EXPR) {
      r = ceil_expr(b, 0);
    }
    else if (t == CHILD_OBJ) {
      r = child_obj(b, 0);
    }
    else if (t == CHILDREN_OBJ) {
      r = children_obj(b, 0);
    }
    else if (t == CHR_EXPR) {
      r = chr_expr(b, 0);
    }
    else if (t == CIRCLE_OBJ) {
      r = circle_obj(b, 0);
    }
    else if (t == COLOR_OP) {
      r = color_op(b, 0);
    }
    else if (t == CONCAT_EXPR) {
      r = concat_expr(b, 0);
    }
    else if (t == COS_EXPR) {
      r = cos_expr(b, 0);
    }
    else if (t == CROSS_EXPR) {
      r = cross_expr(b, 0);
    }
    else if (t == CUBE_OBJ) {
      r = cube_obj(b, 0);
    }
    else if (t == CYLINDER_OBJ) {
      r = cylinder_obj(b, 0);
    }
    else if (t == DEBUG_OP) {
      r = debug_op(b, 0);
    }
    else if (t == DIFFERENCE_OP) {
      r = difference_op(b, 0);
    }
    else if (t == DISABLE_OP) {
      r = disable_op(b, 0);
    }
    else if (t == ECHO_OBJ) {
      r = echo_obj(b, 0);
    }
    else if (t == ELLIPSE_OBJ) {
      r = ellipse_obj(b, 0);
    }
    else if (t == ELSE_OP) {
      r = else_op(b, 0);
    }
    else if (t == EMPTY_OBJ) {
      r = empty_obj(b, 0);
    }
    else if (t == EXP_EXPR) {
      r = exp_expr(b, 0);
    }
    else if (t == EXPR) {
      r = expr(b, 0, -1);
    }
    else if (t == FLOOR_EXPR) {
      r = floor_expr(b, 0);
    }
    else if (t == FOR_ELEMENT) {
      r = for_element(b, 0);
    }
    else if (t == FOR_OP) {
      r = for_op(b, 0);
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
    else if (t == HULL_OP) {
      r = hull_op(b, 0);
    }
    else if (t == IF_ELEMENT) {
      r = if_element(b, 0);
    }
    else if (t == IF_OP) {
      r = if_op(b, 0);
    }
    else if (t == IMPORT_DXF_OBJ) {
      r = import_dxf_obj(b, 0);
    }
    else if (t == IMPORT_OBJ) {
      r = import_obj(b, 0);
    }
    else if (t == IMPORT_STL_OBJ) {
      r = import_stl_obj(b, 0);
    }
    else if (t == INCLUDE_ITEM) {
      r = include_item(b, 0);
    }
    else if (t == INTERSECTION_FOR_OP) {
      r = intersection_for_op(b, 0);
    }
    else if (t == INTERSECTION_OP) {
      r = intersection_op(b, 0);
    }
    else if (t == LEN_EXPR) {
      r = len_expr(b, 0);
    }
    else if (t == LET_ELEMENT) {
      r = let_element(b, 0);
    }
    else if (t == LET_EXPR) {
      r = let_expr(b, 0);
    }
    else if (t == LET_OP) {
      r = let_op(b, 0);
    }
    else if (t == LINEAR_EXTRUDE_OP) {
      r = linear_extrude_op(b, 0);
    }
    else if (t == LN_EXPR) {
      r = ln_expr(b, 0);
    }
    else if (t == LOG_EXPR) {
      r = log_expr(b, 0);
    }
    else if (t == LOOKUP_EXPR) {
      r = lookup_expr(b, 0);
    }
    else if (t == MAX_EXPR) {
      r = max_expr(b, 0);
    }
    else if (t == MIN_EXPR) {
      r = min_expr(b, 0);
    }
    else if (t == MINKOWSKI_OP) {
      r = minkowski_op(b, 0);
    }
    else if (t == MIRROR_OP) {
      r = mirror_op(b, 0);
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
    else if (t == MODULE_OBJ_REFERENCE) {
      r = module_obj_reference(b, 0);
    }
    else if (t == MODULE_OP_REFERENCE) {
      r = module_op_reference(b, 0);
    }
    else if (t == MULTMATRIX_OP) {
      r = multmatrix_op(b, 0);
    }
    else if (t == NORM_EXPR) {
      r = norm_expr(b, 0);
    }
    else if (t == OBJECT) {
      r = object(b, 0);
    }
    else if (t == OFFSET_OP) {
      r = offset_op(b, 0);
    }
    else if (t == OPERATOR) {
      r = operator(b, 0);
    }
    else if (t == PARAMETER_REFERENCE) {
      r = parameter_reference(b, 0);
    }
    else if (t == PARENT_MODULE_EXPR) {
      r = parent_module_expr(b, 0);
    }
    else if (t == POLYGON_OBJ) {
      r = polygon_obj(b, 0);
    }
    else if (t == POLYHEDRON_OBJ) {
      r = polyhedron_obj(b, 0);
    }
    else if (t == POW_EXPR) {
      r = pow_expr(b, 0);
    }
    else if (t == PROJECTION_OBJ) {
      r = projection_obj(b, 0);
    }
    else if (t == RANDS_EXPR) {
      r = rands_expr(b, 0);
    }
    else if (t == RENDER_OP) {
      r = render_op(b, 0);
    }
    else if (t == RESIZE_OP) {
      r = resize_op(b, 0);
    }
    else if (t == ROOT_OP) {
      r = root_op(b, 0);
    }
    else if (t == ROTATE_EXTRUDE_OP) {
      r = rotate_extrude_op(b, 0);
    }
    else if (t == ROTATE_OP) {
      r = rotate_op(b, 0);
    }
    else if (t == ROUND_EXPR) {
      r = round_expr(b, 0);
    }
    else if (t == SCALE_OP) {
      r = scale_op(b, 0);
    }
    else if (t == SEARCH_EXPR) {
      r = search_expr(b, 0);
    }
    else if (t == SELECT_EXPR) {
      r = select_expr(b, 0);
    }
    else if (t == SIGN_EXPR) {
      r = sign_expr(b, 0);
    }
    else if (t == SIN_EXPR) {
      r = sin_expr(b, 0);
    }
    else if (t == SPHERE_OBJ) {
      r = sphere_obj(b, 0);
    }
    else if (t == SQRT_EXPR) {
      r = sqrt_expr(b, 0);
    }
    else if (t == SQUARE_OBJ) {
      r = square_obj(b, 0);
    }
    else if (t == STR_EXPR) {
      r = str_expr(b, 0);
    }
    else if (t == SURFACE_OBJ) {
      r = surface_obj(b, 0);
    }
    else if (t == TAN_EXPR) {
      r = tan_expr(b, 0);
    }
    else if (t == TEXT_OBJ) {
      r = text_obj(b, 0);
    }
    else if (t == TRANSLATE_OP) {
      r = translate_op(b, 0);
    }
    else if (t == UNION_OP) {
      r = union_op(b, 0);
    }
    else if (t == USE_ITEM) {
      r = use_item(b, 0);
    }
    else if (t == VARIABLE_DECLARATION) {
      r = variable_declaration(b, 0);
    }
    else if (t == VERSION_EXPR) {
      r = version_expr(b, 0);
    }
    else if (t == VERSION_NUM_EXPR) {
      r = version_num_expr(b, 0);
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
    create_token_set_(ASSERT_OBJ, BLOCK_OBJ, BUILTIN_OBJ, CHILDREN_OBJ,
      CHILD_OBJ, CIRCLE_OBJ, CUBE_OBJ, CYLINDER_OBJ,
      ECHO_OBJ, ELLIPSE_OBJ, EMPTY_OBJ, IMPORT_DXF_OBJ,
      IMPORT_OBJ, IMPORT_STL_OBJ, MODULE_CALL_OBJ, OBJECT,
      POLYGON_OBJ, POLYHEDRON_OBJ, PROJECTION_OBJ, SPHERE_OBJ,
      SQUARE_OBJ, SURFACE_OBJ, TEXT_OBJ),
    create_token_set_(ASSIGN_OP, BACKGROUND_OP, BUILTIN_OP, COLOR_OP,
      DEBUG_OP, DIFFERENCE_OP, DISABLE_OP, ELSE_OP,
      FOR_OP, HULL_OP, IF_OP, INTERSECTION_FOR_OP,
      INTERSECTION_OP, LET_OP, LINEAR_EXTRUDE_OP, MINKOWSKI_OP,
      MIRROR_OP, MODIFIER_OP, MODULE_CALL_OP, MULTMATRIX_OP,
      OFFSET_OP, OPERATOR, RENDER_OP, RESIZE_OP,
      ROOT_OP, ROTATE_EXTRUDE_OP, ROTATE_OP, SCALE_OP,
      TRANSLATE_OP, UNION_OP),
    create_token_set_(ABS_EXPR, ACOS_EXPR, AND_EXPR, ASIN_EXPR,
      ATAN_2_EXPR, ATAN_EXPR, BUILTIN_EXPR, CALL_EXPR,
      CEIL_EXPR, CHR_EXPR, CONCAT_EXPR, CONDITIONAL_EXPR,
      COS_EXPR, CROSS_EXPR, DIV_EXPR, ELVIS_EXPR,
      EXPR, EXP_EXPR, FLOOR_EXPR, INDEX_EXPR,
      LEN_EXPR, LET_EXPR, LIST_COMPREHENSION_EXPR, LITERAL_EXPR,
      LN_EXPR, LOG_EXPR, LOOKUP_EXPR, MAX_EXPR,
      MINUS_EXPR, MIN_EXPR, MODULO_EXPR, MUL_EXPR,
      NORM_EXPR, OR_EXPR, PARENT_MODULE_EXPR, PAREN_EXPR,
      PLUS_EXPR, POW_EXPR, RANDS_EXPR, RANGE_EXPR,
      REF_EXPR, ROUND_EXPR, SEARCH_EXPR, SELECT_EXPR,
      SIGN_EXPR, SIN_EXPR, SQRT_EXPR, STR_EXPR,
      TAN_EXPR, UNARY_MIN_EXPR, UNARY_NEGATE_EXPR, UNARY_PLUS_EXPR,
      VECTOR_EXPR, VERSION_EXPR, VERSION_NUM_EXPR),
  };

  /* ********************************************************** */
  // ABS_KEYWORD arg_assignment_list
  public static boolean abs_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "abs_expr")) return false;
    if (!nextTokenIs(b, ABS_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ABS_KEYWORD);
    r = r && arg_assignment_list(b, l + 1);
    exit_section_(b, m, ABS_EXPR, r);
    return r;
  }

  /* ********************************************************** */
  // ACOS_KEYWORD arg_assignment_list
  public static boolean acos_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "acos_expr")) return false;
    if (!nextTokenIs(b, ACOS_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ACOS_KEYWORD);
    r = r && arg_assignment_list(b, l + 1);
    exit_section_(b, m, ACOS_EXPR, r);
    return r;
  }

  /* ********************************************************** */
  // [ parameter_reference EQUALS ] expr
  public static boolean arg_assignment(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "arg_assignment")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ARG_ASSIGNMENT, "<arg assignment>");
    r = arg_assignment_0(b, l + 1);
    r = r && expr(b, l + 1, -1);
    exit_section_(b, l, m, r, false, null);
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
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    r = r && arg_declaration_1(b, l + 1);
    exit_section_(b, m, ARG_DECLARATION, r);
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
  // LPARENTH arg_declaration? ( COMMA+ arg_declaration )* RPARENTH
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

  // ( COMMA+ arg_declaration )*
  private static boolean arg_declaration_list_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "arg_declaration_list_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!arg_declaration_list_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "arg_declaration_list_2", c)) break;
    }
    return true;
  }

  // COMMA+ arg_declaration
  private static boolean arg_declaration_list_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "arg_declaration_list_2_0")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = arg_declaration_list_2_0_0(b, l + 1);
    p = r; // pin = 1
    r = r && arg_declaration(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // COMMA+
  private static boolean arg_declaration_list_2_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "arg_declaration_list_2_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    while (r) {
      int c = current_position_(b);
      if (!consumeToken(b, COMMA)) break;
      if (!empty_element_parsed_guard_(b, "arg_declaration_list_2_0_0", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ASIN_KEYWORD arg_assignment_list
  public static boolean asin_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "asin_expr")) return false;
    if (!nextTokenIs(b, ASIN_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ASIN_KEYWORD);
    r = r && arg_assignment_list(b, l + 1);
    exit_section_(b, m, ASIN_EXPR, r);
    return r;
  }

  /* ********************************************************** */
  // ASSERT_KEYWORD arg_assignment_list SEMICOLON
  public static boolean assert_obj(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "assert_obj")) return false;
    if (!nextTokenIs(b, ASSERT_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ASSERT_KEYWORD);
    r = r && arg_assignment_list(b, l + 1);
    r = r && consumeToken(b, SEMICOLON);
    exit_section_(b, m, ASSERT_OBJ, r);
    return r;
  }

  /* ********************************************************** */
  // ASSIGN_KEYWORD LPARENTH full_arg_declaration_list RPARENTH
  public static boolean assign_op(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "assign_op")) return false;
    if (!nextTokenIs(b, ASSIGN_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, ASSIGN_KEYWORD, LPARENTH);
    r = r && full_arg_declaration_list(b, l + 1);
    r = r && consumeToken(b, RPARENTH);
    exit_section_(b, m, ASSIGN_OP, r);
    return r;
  }

  /* ********************************************************** */
  // variable_declaration EQUALS expr SEMICOLON
  public static boolean assignment(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "assignment")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = variable_declaration(b, l + 1);
    r = r && consumeToken(b, EQUALS);
    r = r && expr(b, l + 1, -1);
    r = r && consumeToken(b, SEMICOLON);
    exit_section_(b, m, ASSIGNMENT, r);
    return r;
  }

  /* ********************************************************** */
  // ATAN2_KEYWORD arg_assignment_list
  public static boolean atan2_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atan2_expr")) return false;
    if (!nextTokenIs(b, ATAN2_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ATAN2_KEYWORD);
    r = r && arg_assignment_list(b, l + 1);
    exit_section_(b, m, ATAN_2_EXPR, r);
    return r;
  }

  /* ********************************************************** */
  // ATAN_KEYWORD arg_assignment_list
  public static boolean atan_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atan_expr")) return false;
    if (!nextTokenIs(b, ATAN_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ATAN_KEYWORD);
    r = r && arg_assignment_list(b, l + 1);
    exit_section_(b, m, ATAN_EXPR, r);
    return r;
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
  // cube_obj
  //               | cylinder_obj
  //               | echo_obj
  //               | assert_obj
  //               | sphere_obj
  //               | polyhedron_obj
  //               | projection_obj
  //               | square_obj
  //               | circle_obj
  //               | ellipse_obj
  //               | polygon_obj
  //               | text_obj
  //               | surface_obj
  //               | child_obj
  //               | children_obj
  //               | import_obj
  //               | import_dxf_obj
  //               | import_stl_obj
  public static boolean builtin_obj(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "builtin_obj")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _COLLAPSE_, BUILTIN_OBJ, "<builtin obj>");
    r = cube_obj(b, l + 1);
    if (!r) r = cylinder_obj(b, l + 1);
    if (!r) r = echo_obj(b, l + 1);
    if (!r) r = assert_obj(b, l + 1);
    if (!r) r = sphere_obj(b, l + 1);
    if (!r) r = polyhedron_obj(b, l + 1);
    if (!r) r = projection_obj(b, l + 1);
    if (!r) r = square_obj(b, l + 1);
    if (!r) r = circle_obj(b, l + 1);
    if (!r) r = ellipse_obj(b, l + 1);
    if (!r) r = polygon_obj(b, l + 1);
    if (!r) r = text_obj(b, l + 1);
    if (!r) r = surface_obj(b, l + 1);
    if (!r) r = child_obj(b, l + 1);
    if (!r) r = children_obj(b, l + 1);
    if (!r) r = import_obj(b, l + 1);
    if (!r) r = import_dxf_obj(b, l + 1);
    if (!r) r = import_stl_obj(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // for_op
  //              | intersection_for_op
  //              | else_op
  //              | if_op
  //              | linear_extrude_op
  //              | rotate_extrude_op
  //              | rotate_op
  //              | translate_op
  //              | scale_op
  //              | resize_op
  //              | mirror_op
  //              | multmatrix_op
  //              | color_op
  //              | offset_op
  //              | minkowski_op
  //              | hull_op
  //              | union_op
  //              | difference_op
  //              | intersection_op
  //              | render_op
  //              | assign_op
  //              | let_op
  public static boolean builtin_op(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "builtin_op")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _COLLAPSE_, BUILTIN_OP, "<builtin op>");
    r = for_op(b, l + 1);
    if (!r) r = intersection_for_op(b, l + 1);
    if (!r) r = else_op(b, l + 1);
    if (!r) r = if_op(b, l + 1);
    if (!r) r = linear_extrude_op(b, l + 1);
    if (!r) r = rotate_extrude_op(b, l + 1);
    if (!r) r = rotate_op(b, l + 1);
    if (!r) r = translate_op(b, l + 1);
    if (!r) r = scale_op(b, l + 1);
    if (!r) r = resize_op(b, l + 1);
    if (!r) r = mirror_op(b, l + 1);
    if (!r) r = multmatrix_op(b, l + 1);
    if (!r) r = color_op(b, l + 1);
    if (!r) r = offset_op(b, l + 1);
    if (!r) r = minkowski_op(b, l + 1);
    if (!r) r = hull_op(b, l + 1);
    if (!r) r = union_op(b, l + 1);
    if (!r) r = difference_op(b, l + 1);
    if (!r) r = intersection_op(b, l + 1);
    if (!r) r = render_op(b, l + 1);
    if (!r) r = assign_op(b, l + 1);
    if (!r) r = let_op(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // CEIL_KEYWORD arg_assignment_list
  public static boolean ceil_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ceil_expr")) return false;
    if (!nextTokenIs(b, CEIL_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, CEIL_KEYWORD);
    r = r && arg_assignment_list(b, l + 1);
    exit_section_(b, m, CEIL_EXPR, r);
    return r;
  }

  /* ********************************************************** */
  // CHILD_KEYWORD arg_assignment_list SEMICOLON
  public static boolean child_obj(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "child_obj")) return false;
    if (!nextTokenIs(b, CHILD_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, CHILD_KEYWORD);
    r = r && arg_assignment_list(b, l + 1);
    r = r && consumeToken(b, SEMICOLON);
    exit_section_(b, m, CHILD_OBJ, r);
    return r;
  }

  /* ********************************************************** */
  // CHILDREN_KEYWORD arg_assignment_list SEMICOLON
  public static boolean children_obj(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "children_obj")) return false;
    if (!nextTokenIs(b, CHILDREN_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, CHILDREN_KEYWORD);
    r = r && arg_assignment_list(b, l + 1);
    r = r && consumeToken(b, SEMICOLON);
    exit_section_(b, m, CHILDREN_OBJ, r);
    return r;
  }

  /* ********************************************************** */
  // CHR_KEYWORD arg_assignment_list
  public static boolean chr_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "chr_expr")) return false;
    if (!nextTokenIs(b, CHR_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, CHR_KEYWORD);
    r = r && arg_assignment_list(b, l + 1);
    exit_section_(b, m, CHR_EXPR, r);
    return r;
  }

  /* ********************************************************** */
  // CIRCLE_KEYWORD arg_assignment_list SEMICOLON
  public static boolean circle_obj(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "circle_obj")) return false;
    if (!nextTokenIs(b, CIRCLE_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, CIRCLE_KEYWORD);
    r = r && arg_assignment_list(b, l + 1);
    r = r && consumeToken(b, SEMICOLON);
    exit_section_(b, m, CIRCLE_OBJ, r);
    return r;
  }

  /* ********************************************************** */
  // COLOR_KEYWORD arg_assignment_list
  public static boolean color_op(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "color_op")) return false;
    if (!nextTokenIs(b, COLOR_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COLOR_KEYWORD);
    r = r && arg_assignment_list(b, l + 1);
    exit_section_(b, m, COLOR_OP, r);
    return r;
  }

  /* ********************************************************** */
  // C_STYLE_COMMENT | DOC_COMMENT | END_OF_LINE_COMMENT
  static boolean comment_item(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "comment_item")) return false;
    boolean r;
    r = consumeToken(b, C_STYLE_COMMENT);
    if (!r) r = consumeToken(b, DOC_COMMENT);
    if (!r) r = consumeToken(b, END_OF_LINE_COMMENT);
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
  // CONCAT_KEYWORD arg_assignment_list
  public static boolean concat_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "concat_expr")) return false;
    if (!nextTokenIs(b, CONCAT_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, CONCAT_KEYWORD);
    r = r && arg_assignment_list(b, l + 1);
    exit_section_(b, m, CONCAT_EXPR, r);
    return r;
  }

  /* ********************************************************** */
  // COS_KEYWORD arg_assignment_list
  public static boolean cos_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "cos_expr")) return false;
    if (!nextTokenIs(b, COS_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COS_KEYWORD);
    r = r && arg_assignment_list(b, l + 1);
    exit_section_(b, m, COS_EXPR, r);
    return r;
  }

  /* ********************************************************** */
  // CROSS_KEYWORD arg_assignment_list
  public static boolean cross_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "cross_expr")) return false;
    if (!nextTokenIs(b, CROSS_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, CROSS_KEYWORD);
    r = r && arg_assignment_list(b, l + 1);
    exit_section_(b, m, CROSS_EXPR, r);
    return r;
  }

  /* ********************************************************** */
  // CUBE_KEYWORD arg_assignment_list SEMICOLON
  public static boolean cube_obj(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "cube_obj")) return false;
    if (!nextTokenIs(b, CUBE_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, CUBE_KEYWORD);
    r = r && arg_assignment_list(b, l + 1);
    r = r && consumeToken(b, SEMICOLON);
    exit_section_(b, m, CUBE_OBJ, r);
    return r;
  }

  /* ********************************************************** */
  // CYLINDER_KEYWORD arg_assignment_list SEMICOLON
  public static boolean cylinder_obj(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "cylinder_obj")) return false;
    if (!nextTokenIs(b, CYLINDER_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, CYLINDER_KEYWORD);
    r = r && arg_assignment_list(b, l + 1);
    r = r && consumeToken(b, SEMICOLON);
    exit_section_(b, m, CYLINDER_OBJ, r);
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
  // DIFFERENCE_KEYWORD arg_assignment_list
  public static boolean difference_op(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "difference_op")) return false;
    if (!nextTokenIs(b, DIFFERENCE_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, DIFFERENCE_KEYWORD);
    r = r && arg_assignment_list(b, l + 1);
    exit_section_(b, m, DIFFERENCE_OP, r);
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
  // ECHO_KEYWORD arg_assignment_list SEMICOLON
  public static boolean echo_obj(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "echo_obj")) return false;
    if (!nextTokenIs(b, ECHO_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ECHO_KEYWORD);
    r = r && arg_assignment_list(b, l + 1);
    r = r && consumeToken(b, SEMICOLON);
    exit_section_(b, m, ECHO_OBJ, r);
    return r;
  }

  /* ********************************************************** */
  // ELLIPSE_KEYWORD arg_assignment_list SEMICOLON
  public static boolean ellipse_obj(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ellipse_obj")) return false;
    if (!nextTokenIs(b, ELLIPSE_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ELLIPSE_KEYWORD);
    r = r && arg_assignment_list(b, l + 1);
    r = r && consumeToken(b, SEMICOLON);
    exit_section_(b, m, ELLIPSE_OBJ, r);
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
  // EXP_KEYWORD arg_assignment_list
  public static boolean exp_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "exp_expr")) return false;
    if (!nextTokenIs(b, EXP_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, EXP_KEYWORD);
    r = r && arg_assignment_list(b, l + 1);
    exit_section_(b, m, EXP_EXPR, r);
    return r;
  }

  /* ********************************************************** */
  // FLOOR_KEYWORD arg_assignment_list
  public static boolean floor_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "floor_expr")) return false;
    if (!nextTokenIs(b, FLOOR_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, FLOOR_KEYWORD);
    r = r && arg_assignment_list(b, l + 1);
    exit_section_(b, m, FLOOR_EXPR, r);
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
  // FOR_KEYWORD full_arg_declaration_list
  public static boolean for_op(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "for_op")) return false;
    if (!nextTokenIs(b, FOR_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, FOR_KEYWORD);
    r = r && full_arg_declaration_list(b, l + 1);
    exit_section_(b, m, FOR_OP, r);
    return r;
  }

  /* ********************************************************** */
  // IDENTIFIER EQUALS expr
  public static boolean full_arg_declaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "full_arg_declaration")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, IDENTIFIER, EQUALS);
    r = r && expr(b, l + 1, -1);
    exit_section_(b, m, FULL_ARG_DECLARATION, r);
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
  // HULL_KEYWORD arg_assignment_list
  public static boolean hull_op(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "hull_op")) return false;
    if (!nextTokenIs(b, HULL_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, HULL_KEYWORD);
    r = r && arg_assignment_list(b, l + 1);
    exit_section_(b, m, HULL_OP, r);
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
  // IMPORT_DXF_KEYWORD arg_assignment_list SEMICOLON
  public static boolean import_dxf_obj(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "import_dxf_obj")) return false;
    if (!nextTokenIs(b, IMPORT_DXF_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IMPORT_DXF_KEYWORD);
    r = r && arg_assignment_list(b, l + 1);
    r = r && consumeToken(b, SEMICOLON);
    exit_section_(b, m, IMPORT_DXF_OBJ, r);
    return r;
  }

  /* ********************************************************** */
  // IMPORT_KEYWORD arg_assignment_list SEMICOLON
  public static boolean import_obj(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "import_obj")) return false;
    if (!nextTokenIs(b, IMPORT_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IMPORT_KEYWORD);
    r = r && arg_assignment_list(b, l + 1);
    r = r && consumeToken(b, SEMICOLON);
    exit_section_(b, m, IMPORT_OBJ, r);
    return r;
  }

  /* ********************************************************** */
  // IMPORT_STL_KEYWORD arg_assignment_list SEMICOLON
  public static boolean import_stl_obj(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "import_stl_obj")) return false;
    if (!nextTokenIs(b, IMPORT_STL_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IMPORT_STL_KEYWORD);
    r = r && arg_assignment_list(b, l + 1);
    r = r && consumeToken(b, SEMICOLON);
    exit_section_(b, m, IMPORT_STL_OBJ, r);
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
  // INTERSECTION_FOR_KEYWORD full_arg_declaration_list
  public static boolean intersection_for_op(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "intersection_for_op")) return false;
    if (!nextTokenIs(b, INTERSECTION_FOR_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, INTERSECTION_FOR_KEYWORD);
    r = r && full_arg_declaration_list(b, l + 1);
    exit_section_(b, m, INTERSECTION_FOR_OP, r);
    return r;
  }

  /* ********************************************************** */
  // INTERSECTION_KEYWORD arg_assignment_list
  public static boolean intersection_op(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "intersection_op")) return false;
    if (!nextTokenIs(b, INTERSECTION_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, INTERSECTION_KEYWORD);
    r = r && arg_assignment_list(b, l + 1);
    exit_section_(b, m, INTERSECTION_OP, r);
    return r;
  }

  /* ********************************************************** */
  // comment_item
  //     | include_item
  //     | use_item
  //     | statement
  static boolean item_(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "item_")) return false;
    boolean r;
    r = comment_item(b, l + 1);
    if (!r) r = include_item(b, l + 1);
    if (!r) r = use_item(b, l + 1);
    if (!r) r = statement(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // LEN_KEYWORD arg_assignment_list
  public static boolean len_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "len_expr")) return false;
    if (!nextTokenIs(b, LEN_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LEN_KEYWORD);
    r = r && arg_assignment_list(b, l + 1);
    exit_section_(b, m, LEN_EXPR, r);
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
  // LET_KEYWORD full_arg_declaration_list expr
  public static boolean let_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "let_expr")) return false;
    if (!nextTokenIs(b, LET_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LET_KEYWORD);
    r = r && full_arg_declaration_list(b, l + 1);
    r = r && expr(b, l + 1, -1);
    exit_section_(b, m, LET_EXPR, r);
    return r;
  }

  /* ********************************************************** */
  // LET_KEYWORD LPARENTH full_arg_declaration_list RPARENTH
  public static boolean let_op(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "let_op")) return false;
    if (!nextTokenIs(b, LET_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, LET_KEYWORD, LPARENTH);
    r = r && full_arg_declaration_list(b, l + 1);
    r = r && consumeToken(b, RPARENTH);
    exit_section_(b, m, LET_OP, r);
    return r;
  }

  /* ********************************************************** */
  // LINEAR_EXTRUDE_KEYWORD arg_assignment_list
  public static boolean linear_extrude_op(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "linear_extrude_op")) return false;
    if (!nextTokenIs(b, LINEAR_EXTRUDE_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LINEAR_EXTRUDE_KEYWORD);
    r = r && arg_assignment_list(b, l + 1);
    exit_section_(b, m, LINEAR_EXTRUDE_OP, r);
    return r;
  }

  /* ********************************************************** */
  // LN_KEYWORD arg_assignment_list
  public static boolean ln_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ln_expr")) return false;
    if (!nextTokenIs(b, LN_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LN_KEYWORD);
    r = r && arg_assignment_list(b, l + 1);
    exit_section_(b, m, LN_EXPR, r);
    return r;
  }

  /* ********************************************************** */
  // LOG_KEYWORD arg_assignment_list
  public static boolean log_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "log_expr")) return false;
    if (!nextTokenIs(b, LOG_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LOG_KEYWORD);
    r = r && arg_assignment_list(b, l + 1);
    exit_section_(b, m, LOG_EXPR, r);
    return r;
  }

  /* ********************************************************** */
  // LOOKUP_KEYWORD arg_assignment_list
  public static boolean lookup_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lookup_expr")) return false;
    if (!nextTokenIs(b, LOOKUP_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LOOKUP_KEYWORD);
    r = r && arg_assignment_list(b, l + 1);
    exit_section_(b, m, LOOKUP_EXPR, r);
    return r;
  }

  /* ********************************************************** */
  // MAX_KEYWORD arg_assignment_list
  public static boolean max_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "max_expr")) return false;
    if (!nextTokenIs(b, MAX_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, MAX_KEYWORD);
    r = r && arg_assignment_list(b, l + 1);
    exit_section_(b, m, MAX_EXPR, r);
    return r;
  }

  /* ********************************************************** */
  // MIN_KEYWORD arg_assignment_list
  public static boolean min_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "min_expr")) return false;
    if (!nextTokenIs(b, MIN_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, MIN_KEYWORD);
    r = r && arg_assignment_list(b, l + 1);
    exit_section_(b, m, MIN_EXPR, r);
    return r;
  }

  /* ********************************************************** */
  // MINKOWSKI_KEYWORD arg_assignment_list
  public static boolean minkowski_op(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "minkowski_op")) return false;
    if (!nextTokenIs(b, MINKOWSKI_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, MINKOWSKI_KEYWORD);
    r = r && arg_assignment_list(b, l + 1);
    exit_section_(b, m, MINKOWSKI_OP, r);
    return r;
  }

  /* ********************************************************** */
  // MIRROR_KEYWORD arg_assignment_list
  public static boolean mirror_op(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "mirror_op")) return false;
    if (!nextTokenIs(b, MIRROR_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, MIRROR_KEYWORD);
    r = r && arg_assignment_list(b, l + 1);
    exit_section_(b, m, MIRROR_OP, r);
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
  // module_obj_reference arg_assignment_list SEMICOLON
  public static boolean module_call_obj(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_call_obj")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = module_obj_reference(b, l + 1);
    r = r && arg_assignment_list(b, l + 1);
    r = r && consumeToken(b, SEMICOLON);
    exit_section_(b, m, MODULE_CALL_OBJ, r);
    return r;
  }

  /* ********************************************************** */
  // module_op_reference arg_assignment_list
  public static boolean module_call_op(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_call_op")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = module_op_reference(b, l + 1);
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
  public static boolean module_obj_reference(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_obj_reference")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    exit_section_(b, m, MODULE_OBJ_REFERENCE, r);
    return r;
  }

  /* ********************************************************** */
  // IDENTIFIER
  public static boolean module_op_reference(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "module_op_reference")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    exit_section_(b, m, MODULE_OP_REFERENCE, r);
    return r;
  }

  /* ********************************************************** */
  // MULTMATRIX_KEYWORD arg_assignment_list
  public static boolean multmatrix_op(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "multmatrix_op")) return false;
    if (!nextTokenIs(b, MULTMATRIX_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, MULTMATRIX_KEYWORD);
    r = r && arg_assignment_list(b, l + 1);
    exit_section_(b, m, MULTMATRIX_OP, r);
    return r;
  }

  /* ********************************************************** */
  // NORM_KEYWORD arg_assignment_list
  public static boolean norm_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "norm_expr")) return false;
    if (!nextTokenIs(b, NORM_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, NORM_KEYWORD);
    r = r && arg_assignment_list(b, l + 1);
    exit_section_(b, m, NORM_EXPR, r);
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
  // OFFSET_KEYWORD arg_assignment_list
  public static boolean offset_op(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "offset_op")) return false;
    if (!nextTokenIs(b, OFFSET_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OFFSET_KEYWORD);
    r = r && arg_assignment_list(b, l + 1);
    exit_section_(b, m, OFFSET_OP, r);
    return r;
  }

  /* ********************************************************** */
  // item_*
  static boolean openSCADFile(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "openSCADFile")) return false;
    while (true) {
      int c = current_position_(b);
      if (!item_(b, l + 1)) break;
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
  // PARENT_MODULE_KEYWORD arg_assignment_list
  public static boolean parent_module_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parent_module_expr")) return false;
    if (!nextTokenIs(b, PARENT_MODULE_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, PARENT_MODULE_KEYWORD);
    r = r && arg_assignment_list(b, l + 1);
    exit_section_(b, m, PARENT_MODULE_EXPR, r);
    return r;
  }

  /* ********************************************************** */
  // POLYGON_KEYWORD arg_assignment_list SEMICOLON
  public static boolean polygon_obj(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "polygon_obj")) return false;
    if (!nextTokenIs(b, POLYGON_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, POLYGON_KEYWORD);
    r = r && arg_assignment_list(b, l + 1);
    r = r && consumeToken(b, SEMICOLON);
    exit_section_(b, m, POLYGON_OBJ, r);
    return r;
  }

  /* ********************************************************** */
  // POLYHEDRON_KEYWORD arg_assignment_list SEMICOLON
  public static boolean polyhedron_obj(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "polyhedron_obj")) return false;
    if (!nextTokenIs(b, POLYHEDRON_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, POLYHEDRON_KEYWORD);
    r = r && arg_assignment_list(b, l + 1);
    r = r && consumeToken(b, SEMICOLON);
    exit_section_(b, m, POLYHEDRON_OBJ, r);
    return r;
  }

  /* ********************************************************** */
  // POW_KEYWORD arg_assignment_list
  public static boolean pow_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pow_expr")) return false;
    if (!nextTokenIs(b, POW_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, POW_KEYWORD);
    r = r && arg_assignment_list(b, l + 1);
    exit_section_(b, m, POW_EXPR, r);
    return r;
  }

  /* ********************************************************** */
  // PROJECTION_KEYWORD arg_assignment_list SEMICOLON
  public static boolean projection_obj(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "projection_obj")) return false;
    if (!nextTokenIs(b, PROJECTION_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, PROJECTION_KEYWORD);
    r = r && arg_assignment_list(b, l + 1);
    r = r && consumeToken(b, SEMICOLON);
    exit_section_(b, m, PROJECTION_OBJ, r);
    return r;
  }

  /* ********************************************************** */
  // RANDS_KEYWORD arg_assignment_list
  public static boolean rands_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "rands_expr")) return false;
    if (!nextTokenIs(b, RANDS_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, RANDS_KEYWORD);
    r = r && arg_assignment_list(b, l + 1);
    exit_section_(b, m, RANDS_EXPR, r);
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
  // RENDER_KEYWORD arg_assignment_list
  public static boolean render_op(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "render_op")) return false;
    if (!nextTokenIs(b, RENDER_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, RENDER_KEYWORD);
    r = r && arg_assignment_list(b, l + 1);
    exit_section_(b, m, RENDER_OP, r);
    return r;
  }

  /* ********************************************************** */
  // RESIZE_KEYWORD arg_assignment_list
  public static boolean resize_op(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "resize_op")) return false;
    if (!nextTokenIs(b, RESIZE_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, RESIZE_KEYWORD);
    r = r && arg_assignment_list(b, l + 1);
    exit_section_(b, m, RESIZE_OP, r);
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
  // ROTATE_EXTRUDE_KEYWORD arg_assignment_list
  public static boolean rotate_extrude_op(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "rotate_extrude_op")) return false;
    if (!nextTokenIs(b, ROTATE_EXTRUDE_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ROTATE_EXTRUDE_KEYWORD);
    r = r && arg_assignment_list(b, l + 1);
    exit_section_(b, m, ROTATE_EXTRUDE_OP, r);
    return r;
  }

  /* ********************************************************** */
  // ROTATE_KEYWORD arg_assignment_list
  public static boolean rotate_op(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "rotate_op")) return false;
    if (!nextTokenIs(b, ROTATE_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ROTATE_KEYWORD);
    r = r && arg_assignment_list(b, l + 1);
    exit_section_(b, m, ROTATE_OP, r);
    return r;
  }

  /* ********************************************************** */
  // ROUND_KEYWORD arg_assignment_list
  public static boolean round_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "round_expr")) return false;
    if (!nextTokenIs(b, ROUND_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ROUND_KEYWORD);
    r = r && arg_assignment_list(b, l + 1);
    exit_section_(b, m, ROUND_EXPR, r);
    return r;
  }

  /* ********************************************************** */
  // SCALE_KEYWORD arg_assignment_list
  public static boolean scale_op(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "scale_op")) return false;
    if (!nextTokenIs(b, SCALE_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SCALE_KEYWORD);
    r = r && arg_assignment_list(b, l + 1);
    exit_section_(b, m, SCALE_OP, r);
    return r;
  }

  /* ********************************************************** */
  // SEARCH_KEYWORD arg_assignment_list
  public static boolean search_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "search_expr")) return false;
    if (!nextTokenIs(b, SEARCH_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SEARCH_KEYWORD);
    r = r && arg_assignment_list(b, l + 1);
    exit_section_(b, m, SEARCH_EXPR, r);
    return r;
  }

  /* ********************************************************** */
  // SELECT_KEYWORD arg_assignment_list
  public static boolean select_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "select_expr")) return false;
    if (!nextTokenIs(b, SELECT_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SELECT_KEYWORD);
    r = r && arg_assignment_list(b, l + 1);
    exit_section_(b, m, SELECT_EXPR, r);
    return r;
  }

  /* ********************************************************** */
  // SIGN_KEYWORD arg_assignment_list
  public static boolean sign_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "sign_expr")) return false;
    if (!nextTokenIs(b, SIGN_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SIGN_KEYWORD);
    r = r && arg_assignment_list(b, l + 1);
    exit_section_(b, m, SIGN_EXPR, r);
    return r;
  }

  /* ********************************************************** */
  // SIN_KEYWORD arg_assignment_list
  public static boolean sin_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "sin_expr")) return false;
    if (!nextTokenIs(b, SIN_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SIN_KEYWORD);
    r = r && arg_assignment_list(b, l + 1);
    exit_section_(b, m, SIN_EXPR, r);
    return r;
  }

  /* ********************************************************** */
  // SPHERE_KEYWORD arg_assignment_list SEMICOLON
  public static boolean sphere_obj(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "sphere_obj")) return false;
    if (!nextTokenIs(b, SPHERE_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SPHERE_KEYWORD);
    r = r && arg_assignment_list(b, l + 1);
    r = r && consumeToken(b, SEMICOLON);
    exit_section_(b, m, SPHERE_OBJ, r);
    return r;
  }

  /* ********************************************************** */
  // SQRT_KEYWORD arg_assignment_list
  public static boolean sqrt_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "sqrt_expr")) return false;
    if (!nextTokenIs(b, SQRT_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SQRT_KEYWORD);
    r = r && arg_assignment_list(b, l + 1);
    exit_section_(b, m, SQRT_EXPR, r);
    return r;
  }

  /* ********************************************************** */
  // SQUARE_KEYWORD arg_assignment_list SEMICOLON
  public static boolean square_obj(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "square_obj")) return false;
    if (!nextTokenIs(b, SQUARE_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SQUARE_KEYWORD);
    r = r && arg_assignment_list(b, l + 1);
    r = r && consumeToken(b, SEMICOLON);
    exit_section_(b, m, SQUARE_OBJ, r);
    return r;
  }

  /* ********************************************************** */
  // object | assignment | module_declaration | function_declaration
  static boolean statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement")) return false;
    boolean r;
    r = object(b, l + 1);
    if (!r) r = assignment(b, l + 1);
    if (!r) r = module_declaration(b, l + 1);
    if (!r) r = function_declaration(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // STR_KEYWORD arg_assignment_list
  public static boolean str_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "str_expr")) return false;
    if (!nextTokenIs(b, STR_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, STR_KEYWORD);
    r = r && arg_assignment_list(b, l + 1);
    exit_section_(b, m, STR_EXPR, r);
    return r;
  }

  /* ********************************************************** */
  // SURFACE_KEYWORD arg_assignment_list SEMICOLON
  public static boolean surface_obj(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "surface_obj")) return false;
    if (!nextTokenIs(b, SURFACE_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SURFACE_KEYWORD);
    r = r && arg_assignment_list(b, l + 1);
    r = r && consumeToken(b, SEMICOLON);
    exit_section_(b, m, SURFACE_OBJ, r);
    return r;
  }

  /* ********************************************************** */
  // TAN_KEYWORD arg_assignment_list
  public static boolean tan_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tan_expr")) return false;
    if (!nextTokenIs(b, TAN_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, TAN_KEYWORD);
    r = r && arg_assignment_list(b, l + 1);
    exit_section_(b, m, TAN_EXPR, r);
    return r;
  }

  /* ********************************************************** */
  // TEXT_KEYWORD arg_assignment_list SEMICOLON
  public static boolean text_obj(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "text_obj")) return false;
    if (!nextTokenIs(b, TEXT_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, TEXT_KEYWORD);
    r = r && arg_assignment_list(b, l + 1);
    r = r && consumeToken(b, SEMICOLON);
    exit_section_(b, m, TEXT_OBJ, r);
    return r;
  }

  /* ********************************************************** */
  // TRANSLATE_KEYWORD arg_assignment_list
  public static boolean translate_op(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "translate_op")) return false;
    if (!nextTokenIs(b, TRANSLATE_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, TRANSLATE_KEYWORD);
    r = r && arg_assignment_list(b, l + 1);
    exit_section_(b, m, TRANSLATE_OP, r);
    return r;
  }

  /* ********************************************************** */
  // UNION_KEYWORD arg_assignment_list
  public static boolean union_op(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "union_op")) return false;
    if (!nextTokenIs(b, UNION_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, UNION_KEYWORD);
    r = r && arg_assignment_list(b, l + 1);
    exit_section_(b, m, UNION_OP, r);
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
  // IDENTIFIER
  public static boolean variable_declaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variable_declaration")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
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
  // VERSION_KEYWORD arg_assignment_list
  public static boolean version_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "version_expr")) return false;
    if (!nextTokenIs(b, VERSION_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, VERSION_KEYWORD);
    r = r && arg_assignment_list(b, l + 1);
    exit_section_(b, m, VERSION_EXPR, r);
    return r;
  }

  /* ********************************************************** */
  // VERSION_NUM_KEYWORD arg_assignment_list
  public static boolean version_num_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "version_num_expr")) return false;
    if (!nextTokenIs(b, VERSION_NUM_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, VERSION_NUM_KEYWORD);
    r = r && arg_assignment_list(b, l + 1);
    exit_section_(b, m, VERSION_NUM_EXPR, r);
    return r;
  }

  /* ********************************************************** */
  // Expression root: expr
  // Operator priority table:
  // 0: BINARY(elvis_expr) BINARY(conditional_expr)
  // 1: BINARY(plus_expr) BINARY(minus_expr)
  // 2: BINARY(and_expr) BINARY(or_expr)
  // 3: BINARY(mul_expr) BINARY(div_expr) BINARY(modulo_expr)
  // 4: PREFIX(unary_plus_expr) PREFIX(unary_min_expr) PREFIX(unary_negate_expr)
  // 5: POSTFIX(call_expr) POSTFIX(qualification_expr) BINARY(index_expr)
  // 6: ATOM(builtin_expr) ATOM(variable_ref_expr) ATOM(literal_expr) PREFIX(paren_expr)
  //    PREFIX(list_comprehension_expr) ATOM(range_expr) ATOM(vector_expr)
  public static boolean expr(PsiBuilder b, int l, int g) {
    if (!recursion_guard_(b, l, "expr")) return false;
    addVariant(b, "<expr>");
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, "<expr>");
    r = unary_plus_expr(b, l + 1);
    if (!r) r = unary_min_expr(b, l + 1);
    if (!r) r = unary_negate_expr(b, l + 1);
    if (!r) r = builtin_expr(b, l + 1);
    if (!r) r = variable_ref_expr(b, l + 1);
    if (!r) r = literal_expr(b, l + 1);
    if (!r) r = paren_expr(b, l + 1);
    if (!r) r = list_comprehension_expr(b, l + 1);
    if (!r) r = range_expr(b, l + 1);
    if (!r) r = vector_expr(b, l + 1);
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
      else if (g < 1 && consumeTokenSmart(b, PLUS)) {
        r = expr(b, l, 1);
        exit_section_(b, l, m, PLUS_EXPR, r, true, null);
      }
      else if (g < 1 && consumeTokenSmart(b, MINUS)) {
        r = expr(b, l, 1);
        exit_section_(b, l, m, MINUS_EXPR, r, true, null);
      }
      else if (g < 2 && consumeTokenSmart(b, AND)) {
        r = expr(b, l, 2);
        exit_section_(b, l, m, AND_EXPR, r, true, null);
      }
      else if (g < 2 && consumeTokenSmart(b, OR)) {
        r = expr(b, l, 2);
        exit_section_(b, l, m, OR_EXPR, r, true, null);
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
      else if (g < 5 && leftMarkerIs(b, REF_EXPR) && arg_assignment_list(b, l + 1)) {
        r = true;
        exit_section_(b, l, m, CALL_EXPR, r, true, null);
      }
      else if (g < 5 && parseTokensSmart(b, 0, DOT, IDENTIFIER)) {
        r = true;
        exit_section_(b, l, m, REF_EXPR, r, true, null);
      }
      else if (g < 5 && consumeTokenSmart(b, LBRACKET)) {
        r = report_error_(b, expr(b, l, 5));
        r = consumeToken(b, RBRACKET) && r;
        exit_section_(b, l, m, INDEX_EXPR, r, true, null);
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

  // let_expr
  //                | cos_expr
  //                | sin_expr
  //                | tan_expr
  //                | acos_expr
  //                | asin_expr
  //                | atan_expr
  //                | atan2_expr
  //                | abs_expr
  //                | ceil_expr
  //                | concat_expr
  //                | cross_expr
  //                | exp_expr
  //                | floor_expr
  //                | ln_expr
  //                | len_expr
  //                | log_expr
  //                | lookup_expr
  //                | max_expr
  //                | min_expr
  //                | norm_expr
  //                | pow_expr
  //                | rands_expr
  //                | round_expr
  //                | sign_expr
  //                | sqrt_expr
  //                | str_expr
  //                | chr_expr
  //                | select_expr
  //                | search_expr
  //                | version_expr
  //                | version_num_expr
  //                | parent_module_expr
  public static boolean builtin_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "builtin_expr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _COLLAPSE_, BUILTIN_EXPR, "<builtin expr>");
    r = let_expr(b, l + 1);
    if (!r) r = cos_expr(b, l + 1);
    if (!r) r = sin_expr(b, l + 1);
    if (!r) r = tan_expr(b, l + 1);
    if (!r) r = acos_expr(b, l + 1);
    if (!r) r = asin_expr(b, l + 1);
    if (!r) r = atan_expr(b, l + 1);
    if (!r) r = atan2_expr(b, l + 1);
    if (!r) r = abs_expr(b, l + 1);
    if (!r) r = ceil_expr(b, l + 1);
    if (!r) r = concat_expr(b, l + 1);
    if (!r) r = cross_expr(b, l + 1);
    if (!r) r = exp_expr(b, l + 1);
    if (!r) r = floor_expr(b, l + 1);
    if (!r) r = ln_expr(b, l + 1);
    if (!r) r = len_expr(b, l + 1);
    if (!r) r = log_expr(b, l + 1);
    if (!r) r = lookup_expr(b, l + 1);
    if (!r) r = max_expr(b, l + 1);
    if (!r) r = min_expr(b, l + 1);
    if (!r) r = norm_expr(b, l + 1);
    if (!r) r = pow_expr(b, l + 1);
    if (!r) r = rands_expr(b, l + 1);
    if (!r) r = round_expr(b, l + 1);
    if (!r) r = sign_expr(b, l + 1);
    if (!r) r = sqrt_expr(b, l + 1);
    if (!r) r = str_expr(b, l + 1);
    if (!r) r = chr_expr(b, l + 1);
    if (!r) r = select_expr(b, l + 1);
    if (!r) r = search_expr(b, l + 1);
    if (!r) r = version_expr(b, l + 1);
    if (!r) r = version_num_expr(b, l + 1);
    if (!r) r = parent_module_expr(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // IDENTIFIER
  public static boolean variable_ref_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variable_ref_expr")) return false;
    if (!nextTokenIsSmart(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenSmart(b, IDENTIFIER);
    exit_section_(b, m, REF_EXPR, r);
    return r;
  }

  // TRUE_KEYWORD
  //                | FALSE_KEYWORD
  //                | UNDEF_KEYWORD
  //                | NUMBER_LITERAL
  //                | SQ_STRING_LITERAL
  //                | DQ_STRING_LITERAL
  public static boolean literal_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "literal_expr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, LITERAL_EXPR, "<literal expr>");
    r = consumeTokenSmart(b, TRUE_KEYWORD);
    if (!r) r = consumeTokenSmart(b, FALSE_KEYWORD);
    if (!r) r = consumeTokenSmart(b, UNDEF_KEYWORD);
    if (!r) r = consumeTokenSmart(b, NUMBER_LITERAL);
    if (!r) r = consumeTokenSmart(b, SQ_STRING_LITERAL);
    if (!r) r = consumeTokenSmart(b, DQ_STRING_LITERAL);
    exit_section_(b, l, m, r, false, null);
    return r;
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

  // LBRACKET for_element (if_element | let_element)*
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

  // (if_element | let_element)*
  private static boolean list_comprehension_expr_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "list_comprehension_expr_0_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!list_comprehension_expr_0_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "list_comprehension_expr_0_2", c)) break;
    }
    return true;
  }

  // if_element | let_element
  private static boolean list_comprehension_expr_0_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "list_comprehension_expr_0_2_0")) return false;
    boolean r;
    r = if_element(b, l + 1);
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

  final static Parser recover_vector_parser_ = new Parser() {
    public boolean parse(PsiBuilder b, int l) {
      return recover_vector(b, l + 1);
    }
  };
}
