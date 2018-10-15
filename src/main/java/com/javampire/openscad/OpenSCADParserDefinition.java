package com.javampire.openscad;

import com.intellij.lang.ASTNode;
import com.intellij.lang.ParserDefinition;
import com.intellij.lang.PsiParser;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.project.Project;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IStubFileElementType;
import com.intellij.psi.tree.TokenSet;
import com.javampire.openscad.parser.OpenSCADParser;
import com.javampire.openscad.psi.OpenSCADFile;
import com.javampire.openscad.psi.OpenSCADTypes;
import org.jetbrains.annotations.NotNull;

public class OpenSCADParserDefinition implements ParserDefinition {

    // the sets defined below are used for syntax highlighting

    public static final TokenSet WHITE_SPACES = TokenSet.create(TokenType.WHITE_SPACE);
    public static final TokenSet COMMENTS = TokenSet.create(
            OpenSCADTypes.END_OF_LINE_COMMENT, OpenSCADTypes.C_STYLE_COMMENT, OpenSCADTypes.DOC_COMMENT
    );

    public static final TokenSet OPERATOR_KEYWORDS = TokenSet.create(
            OpenSCADTypes.ASSIGN_KEYWORD, OpenSCADTypes.COLOR_KEYWORD, OpenSCADTypes.DIFFERENCE_KEYWORD,
            OpenSCADTypes.INTERSECTION_FOR_KEYWORD, OpenSCADTypes.INTERSECTION_KEYWORD,
            OpenSCADTypes.LINEAR_EXTRUDE_KEYWORD, OpenSCADTypes.MINKOWSKI_KEYWORD,
            OpenSCADTypes.MIRROR_KEYWORD, OpenSCADTypes.MULTMATRIX_KEYWORD, OpenSCADTypes.OFFSET_KEYWORD,
            OpenSCADTypes.PROJECTION_KEYWORD, OpenSCADTypes.RENDER_KEYWORD, OpenSCADTypes.RESIZE_KEYWORD,
            OpenSCADTypes.ROTATE_EXTRUDE_KEYWORD, OpenSCADTypes.ROTATE_KEYWORD, OpenSCADTypes.SCALE_KEYWORD,
            OpenSCADTypes.TRANSLATE_KEYWORD, OpenSCADTypes.UNION_KEYWORD
    );

    public static final TokenSet LANGUAGE_KEYWORDS = TokenSet.create(
            OpenSCADTypes.ELSE_KEYWORD, OpenSCADTypes.FALSE_KEYWORD, OpenSCADTypes.FOR_KEYWORD,
            OpenSCADTypes.FUNCTION_KEYWORD, OpenSCADTypes.IF_KEYWORD, OpenSCADTypes.INCLUDE_KEYWORD,
            OpenSCADTypes.LET_KEYWORD, OpenSCADTypes.MODULE_KEYWORD, OpenSCADTypes.PARENT_MODULE_KEYWORD,
            OpenSCADTypes.TRUE_KEYWORD, OpenSCADTypes.UNDEF_KEYWORD, OpenSCADTypes.USE_KEYWORD,
            OpenSCADTypes.VERSION_KEYWORD, OpenSCADTypes.VERSION_NUM_KEYWORD
    );

    public static final TokenSet OBJECT_KEYWORDS = TokenSet.create(
            OpenSCADTypes.ASSERT_KEYWORD, OpenSCADTypes.CHILDREN_KEYWORD, OpenSCADTypes.CHILD_KEYWORD,
            OpenSCADTypes.CIRCLE_KEYWORD, OpenSCADTypes.CUBE_KEYWORD, OpenSCADTypes.CYLINDER_KEYWORD,
            OpenSCADTypes.ECHO_KEYWORD, OpenSCADTypes.ELLIPSE_KEYWORD, OpenSCADTypes.HULL_KEYWORD,
            OpenSCADTypes.IMPORT_DXF_KEYWORD, OpenSCADTypes.IMPORT_KEYWORD, OpenSCADTypes.IMPORT_STL_KEYWORD,
            OpenSCADTypes.SPHERE_KEYWORD, OpenSCADTypes.SQUARE_KEYWORD, OpenSCADTypes.SURFACE_KEYWORD,
            OpenSCADTypes.TEXT_KEYWORD, OpenSCADTypes.POLYGON_KEYWORD
    );

    public static final TokenSet FUNCTION_KEYWORDS = TokenSet.create(
            OpenSCADTypes.ABS_KEYWORD, OpenSCADTypes.ACOS_KEYWORD, OpenSCADTypes.ASIN_KEYWORD,
            OpenSCADTypes.ATAN2_KEYWORD, OpenSCADTypes.ATAN_KEYWORD, OpenSCADTypes.CEIL_KEYWORD,
            OpenSCADTypes.CHR_KEYWORD, OpenSCADTypes.CONCAT_KEYWORD, OpenSCADTypes.COS_KEYWORD,
            OpenSCADTypes.CROSS_KEYWORD, OpenSCADTypes.EXP_KEYWORD, OpenSCADTypes.FLOOR_KEYWORD,
            OpenSCADTypes.LEN_KEYWORD, OpenSCADTypes.LN_KEYWORD, OpenSCADTypes.LOG_KEYWORD,
            OpenSCADTypes.LOOKUP_KEYWORD, OpenSCADTypes.MAX_KEYWORD, OpenSCADTypes.MIN_KEYWORD,
            OpenSCADTypes.NORM_KEYWORD, OpenSCADTypes.POLYHEDRON_KEYWORD, OpenSCADTypes.POW_KEYWORD,
            OpenSCADTypes.RANDS_KEYWORD, OpenSCADTypes.ROUND_KEYWORD, OpenSCADTypes.SEARCH_KEYWORD,
            OpenSCADTypes.SELECT_KEYWORD, OpenSCADTypes.SIGN_KEYWORD, OpenSCADTypes.SIN_KEYWORD,
            OpenSCADTypes.SQRT_KEYWORD, OpenSCADTypes.STR_KEYWORD, OpenSCADTypes.TAN_KEYWORD
    );

    public static final TokenSet PREDEFINED_SYMBOLS = TokenSet.create(
            OpenSCADTypes.AND, OpenSCADTypes.OR, OpenSCADTypes.PLUS,
            OpenSCADTypes.MINUS, OpenSCADTypes.PERC, OpenSCADTypes.DIV,
            OpenSCADTypes.MUL, OpenSCADTypes.LT, OpenSCADTypes.LE,
            OpenSCADTypes.GT, OpenSCADTypes.GE, OpenSCADTypes.NE,
            OpenSCADTypes.EQ, OpenSCADTypes.EQUALS
    );

    public static final TokenSet SEPARATOR_SYMBOLS = TokenSet.create(
            OpenSCADTypes.COLON, OpenSCADTypes.SEMICOLON, OpenSCADTypes.COMMA
    );

    public static final TokenSet ANGLE_BRACKETS_TOKENS = TokenSet.create(
            OpenSCADTypes.INCLUDE_START, OpenSCADTypes.INCLUDE_END
    );

    public static final TokenSet PARENTHESES_TOKENS = TokenSet.create(
            OpenSCADTypes.LPARENTH, OpenSCADTypes.RPARENTH
    );

    public static final TokenSet BRACES_TOKENS = TokenSet.create(
            OpenSCADTypes.LBRACE, OpenSCADTypes.RBRACE
    );

    public static final TokenSet BRACKETS_TOKENS = TokenSet.create(
            OpenSCADTypes.LBRACKET, OpenSCADTypes.RBRACKET
    );

    public static final TokenSet LINE_COMMENT_TOKENS = TokenSet.create(
            OpenSCADTypes.END_OF_LINE_COMMENT
    );

    // The sets below are used for code folding

    /** Used for folding import section (can include comments too) */
    public static final TokenSet IMPORT_FOLDING_TOKENS = TokenSet.create(
            OpenSCADTypes.END_OF_LINE_COMMENT, OpenSCADTypes.INCLUDE_ITEM, OpenSCADTypes.USE_ITEM
    );

    // The sets below are used for element naming/renaming

    /** These elements have their name in the first child with INCLUDE_PATH token type */
    public static final TokenSet IMPORT_TOKENS = TokenSet.create(
            OpenSCADTypes.INCLUDE_ITEM, OpenSCADTypes.USE_ITEM
    );

    /** These elements have their name in the first child with IDENTIFIER token type */
    public static final TokenSet NAMED_ELEMENTS = TokenSet.create(
            OpenSCADTypes.MODULE_DECLARATION, OpenSCADTypes.FUNCTION_DECLARATION,
            OpenSCADTypes.ARG_DECLARATION, OpenSCADTypes.FULL_ARG_DECLARATION,
            OpenSCADTypes.MODULE_OP_NAME_REF, OpenSCADTypes.MODULE_OBJ_NAME_REF,
            OpenSCADTypes.FUNCTION_NAME_REF, OpenSCADTypes.PARAMETER_REFERENCE,
            OpenSCADTypes.VARIABLE_REF_EXPR
    );

    public static final IStubFileElementType FILE = new IStubFileElementType(OpenSCADLanguage.INSTANCE);

    @NotNull
    @Override
    public Lexer createLexer(Project project) {
        return new OpenSCADLexerAdapter();
    }

    @NotNull
    public TokenSet getWhitespaceTokens() {
        return WHITE_SPACES;
    }

    @NotNull
    public TokenSet getCommentTokens() {
        return COMMENTS;
    }

    @NotNull
    public TokenSet getStringLiteralElements() {
        return TokenSet.EMPTY;
    }

    @NotNull
    public PsiParser createParser(final Project project) {
        return new OpenSCADParser();
    }

    @Override
    public IStubFileElementType getFileNodeType() {
        return FILE;
    }

    public PsiFile createFile(FileViewProvider viewProvider) {
        return new OpenSCADFile(viewProvider);
    }

    public SpaceRequirements spaceExistanceTypeBetweenTokens(ASTNode left, ASTNode right) {
        return SpaceRequirements.MAY;
    }

    @NotNull
    public PsiElement createElement(ASTNode node) {
        return OpenSCADTypes.Factory.createElement(node);
    }
}
