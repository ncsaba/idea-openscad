package com.javampire.openscad.parser;

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
import com.javampire.openscad.OpenSCADLanguage;
import com.javampire.openscad.lexer.OpenSCADLexerAdapter;
import com.javampire.openscad.psi.OpenSCADFile;
import org.jetbrains.annotations.NotNull;

import static com.javampire.openscad.psi.OpenSCADTypes.*;

public class OpenSCADParserDefinition implements ParserDefinition {

    // the sets defined below are used for syntax highlighting

    public static final TokenSet WHITE_SPACES = TokenSet.create(TokenType.WHITE_SPACE);

    public static final TokenSet COMMENTS = TokenSet.create(
            END_OF_LINE_COMMENT, C_STYLE_COMMENT,
            DOC_COMMENT, BLOCK_COMMENT
    );

    public static final TokenSet STRINGS = TokenSet.create(
            STRING_LITERAL
    );

    public static final TokenSet OPERATOR_KEYWORDS = TokenSet.create(
            BUILTIN_OP
    );

    public static final TokenSet LANGUAGE_KEYWORDS = TokenSet.create(
            ELSE_KEYWORD, FALSE_KEYWORD, FOR_KEYWORD,
            FUNCTION_KEYWORD, IF_KEYWORD,
            LET_KEYWORD, MODULE_KEYWORD,
            TRUE_KEYWORD, UNDEF_KEYWORD
    );

    public static final TokenSet OBJECT_KEYWORDS = TokenSet.create(
            BUILTIN_OBJ
    );

    public static final TokenSet FUNCTION_KEYWORDS = TokenSet.create(
            BUILTIN_EXPR
    );

    public static final TokenSet PREDEFINED_SYMBOLS = TokenSet.create(
            AND, OR, PLUS,
            MINUS, PERC, DIV,
            MUL, LT, LE,
            GT, GE, NE,
            EQ, EQUALS
    );

    public static final TokenSet SEPARATOR_SYMBOLS = TokenSet.create(
            COLON, SEMICOLON, COMMA
    );

    public static final TokenSet ANGLE_BRACKETS_TOKENS = TokenSet.create(
            INCLUDE_START, INCLUDE_END
    );

    public static final TokenSet PARENTHESES_TOKENS = TokenSet.create(
            LPARENTH, RPARENTH
    );

    public static final TokenSet BRACES_TOKENS = TokenSet.create(
            LBRACE, RBRACE
    );

    public static final TokenSet BRACKETS_TOKENS = TokenSet.create(
            LBRACKET, RBRACKET
    );

    public static final TokenSet LINE_COMMENT_TOKENS = TokenSet.create(
            END_OF_LINE_COMMENT
    );

    // The sets below are used for code folding

    /** Used for folding import section (can include comments too) */
    public static final TokenSet IMPORT_FOLDING_TOKENS = TokenSet.create(
            END_OF_LINE_COMMENT, INCLUDE_ITEM, USE_ITEM
    );

    // The sets below are used for element naming/renaming

    /** These elements have their name in the first child with INCLUDE_PATH token type */
    public static final TokenSet IMPORT_TOKENS = TokenSet.create(
            INCLUDE_ITEM, USE_ITEM
    );

    /** These elements have their name in the first child with IDENTIFIER token type */
    public static final TokenSet NAMED_ELEMENTS = TokenSet.create(
            MODULE_DECLARATION, FUNCTION_DECLARATION,
            ARG_DECLARATION, FULL_ARG_DECLARATION,
            MODULE_OP_NAME_REF, MODULE_OBJ_NAME_REF,
            FUNCTION_NAME_REF, PARAMETER_REFERENCE,
            VARIABLE_REF_EXPR, VARIABLE_DECLARATION,
            BUILTIN_EXPR_REF, BUILTIN_OBJ_REF,
            COMMON_OP_REF
    );

    /** These elements can't be renamed */
    public static final TokenSet NON_RENAMABLE_ELEMENTS = TokenSet.create(
            BUILTIN_EXPR_REF, BUILTIN_OBJ_REF,
            COMMON_OP_REF
    );

    /** These elements have their doc-string attached to the parent */
    public static final TokenSet DOC_IN_PARENT = TokenSet.create(
            IDENTIFIER
    );

    // The sets below are used for spacing feature in formatting

    public static final TokenSet LOGICAL_OPERATORS = TokenSet.create(
            AND, OR
    );

    public static final TokenSet EQUALITY_OPERATORS = TokenSet.create(
            EQ, NE
    );

    public static final TokenSet RELATIONAL_OPERATORS = TokenSet.create(
            LT, LE, GT, GE
    );

    public static final TokenSet ADDITIVE_OPERATORS = TokenSet.create(
            MINUS, PLUS
    );

    public static final TokenSet MULTIPLICATIVE_OPERATORS = TokenSet.create(
            DIV, MUL, PERC
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
        return STRINGS;
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

    public SpaceRequirements spaceExistenceTypeBetweenTokens(ASTNode left, ASTNode right) {
        return SpaceRequirements.MAY;
    }

    @NotNull
    public PsiElement createElement(ASTNode node) {
        return Factory.createElement(node);
    }
}
