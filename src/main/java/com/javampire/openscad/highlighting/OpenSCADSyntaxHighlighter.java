package com.javampire.openscad.highlighting;

import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.HighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
import com.javampire.openscad.lexer.OpenSCADLexerAdapter;
import com.javampire.openscad.psi.OpenSCADTypes;
import org.jetbrains.annotations.NotNull;

import static com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;
import static com.javampire.openscad.parser.OpenSCADParserDefinition.*;

public class OpenSCADSyntaxHighlighter extends SyntaxHighlighterBase {
    public static final TextAttributesKey SEPARATOR =
            createTextAttributesKey("OPENSCAD_SEPARATOR", DefaultLanguageHighlighterColors.COMMA);
    public static final TextAttributesKey STRING =
            createTextAttributesKey("OPENSCAD_STRING", DefaultLanguageHighlighterColors.STRING);
    public static final TextAttributesKey IMPORT_PATH =
            createTextAttributesKey("OPENSCAD_IMPORT_PATH", STRING);
    public static final TextAttributesKey NUMBER =
            createTextAttributesKey("OPENSCAD_NUMBER", DefaultLanguageHighlighterColors.NUMBER);
    public static final TextAttributesKey IDENTIFIER =
            createTextAttributesKey("OPENSCAD_IDENTIFIER", DefaultLanguageHighlighterColors.IDENTIFIER);
    public static final TextAttributesKey BRACES =
            createTextAttributesKey("OPENSCAD_BRACES", SEPARATOR);
    public static final TextAttributesKey BRACKETS =
            createTextAttributesKey("OPENSCAD_BRACKETS", SEPARATOR);
    public static final TextAttributesKey ANGLE_BRACKETS =
            createTextAttributesKey("OPENSCAD_ANGLE_BRACKETS", SEPARATOR);
    public static final TextAttributesKey PARENTHESES =
            createTextAttributesKey("OPENSCAD_PARENTHESES", SEPARATOR);
    public static final TextAttributesKey OPERATION_SIGN =
            createTextAttributesKey("OPENSCAD_OPERATION_SIGN", SEPARATOR);
    public static final TextAttributesKey COMMENT =
            createTextAttributesKey("OPENSCAD_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT);
    public static final TextAttributesKey BAD_CHARACTER =
            createTextAttributesKey("OPENSCAD_BAD_CHARACTER", HighlighterColors.BAD_CHARACTER);
    public static final TextAttributesKey KEYWORD =
            createTextAttributesKey("OPENSCAD_KEYWORD", DefaultLanguageHighlighterColors.KEYWORD);
    public static final TextAttributesKey IMPORT =
            createTextAttributesKey("OPENSCAD_IMPORT", KEYWORD);
    public static final TextAttributesKey OPERATOR_KEYWORD =
            createTextAttributesKey("OPENSCAD_OPERATOR_KEYWORD", KEYWORD);
    public static final TextAttributesKey OBJECT_KEYWORD =
            createTextAttributesKey("OPENSCAD_OBJECT_KEYWORD", KEYWORD);
    public static final TextAttributesKey FUNCTION_KEYWORD =
            createTextAttributesKey("OPENSCAD_FUNCTION_KEYWORD", KEYWORD);

    private static final TextAttributesKey[] BAD_CHAR_KEYS = new TextAttributesKey[]{BAD_CHARACTER};
    private static final TextAttributesKey[] SEPARATOR_KEYS = new TextAttributesKey[]{SEPARATOR};
    private static final TextAttributesKey[] COMMENT_KEYS = new TextAttributesKey[]{COMMENT};
    private static final TextAttributesKey[] IMPORT_KEYS = new TextAttributesKey[]{IMPORT};
    private static final TextAttributesKey[] IMPORT_PATH_KEYS = new TextAttributesKey[]{IMPORT_PATH};
    private static final TextAttributesKey[] STRING_KEYS = new TextAttributesKey[]{STRING};
    private static final TextAttributesKey[] NUMBER_KEYS = new TextAttributesKey[]{NUMBER};
    private static final TextAttributesKey[] IDENTIFIER_KEYS = new TextAttributesKey[]{IDENTIFIER};
    private static final TextAttributesKey[] BRACES_KEYS = new TextAttributesKey[]{BRACES};
    private static final TextAttributesKey[] BRACKETS_KEYS = new TextAttributesKey[]{BRACKETS};
    private static final TextAttributesKey[] ANGLE_BRACKETS_KEYS = new TextAttributesKey[]{ANGLE_BRACKETS};
    private static final TextAttributesKey[] PARENTHESES_KEYS = new TextAttributesKey[]{PARENTHESES};
    private static final TextAttributesKey[] OPERATION_SIGN_KEYS = new TextAttributesKey[]{OPERATION_SIGN};
    private static final TextAttributesKey[] KEYWORD_KEYS = new TextAttributesKey[]{KEYWORD};
    private static final TextAttributesKey[] OPERATOR_KEYWORD_KEYS = new TextAttributesKey[]{OPERATOR_KEYWORD};
    private static final TextAttributesKey[] OBJECT_KEYWORD_KEYS = new TextAttributesKey[]{OBJECT_KEYWORD};
    private static final TextAttributesKey[] FUNCTION_KEYWORD_KEYS = new TextAttributesKey[]{FUNCTION_KEYWORD};
    private static final TextAttributesKey[] EMPTY_KEYS = new TextAttributesKey[0];

    @NotNull
    @Override
    public Lexer getHighlightingLexer() {
        return new OpenSCADLexerAdapter(new OpenSCADHighlightingLexer(null));
    }

    @NotNull
    @Override
    public TextAttributesKey[] getTokenHighlights(IElementType tokenType) {
        if (ANGLE_BRACKETS_TOKENS.contains(tokenType)) {
            return ANGLE_BRACKETS_KEYS;
        } else if (tokenType.equals(OpenSCADTypes.USE_KEYWORD) || tokenType.equals(OpenSCADTypes.INCLUDE_KEYWORD)) {
            return IMPORT_KEYS;
        } else if (tokenType.equals(OpenSCADTypes.INCLUDE_PATH)) {
            return IMPORT_PATH_KEYS;
        } else if (tokenType.equals(OpenSCADTypes.IDENTIFIER)) {
            return IDENTIFIER_KEYS;
        } else if (tokenType.equals(OpenSCADTypes.NUMBER_LITERAL)) {
            return NUMBER_KEYS;
        } else if (tokenType.equals(OpenSCADTypes.STRING_LITERAL)) {
            return STRING_KEYS;
        } else if (BRACES_TOKENS.contains(tokenType)) {
            return BRACES_KEYS;
        } else if (SEPARATOR_SYMBOLS.contains(tokenType)) {
            return SEPARATOR_KEYS;
        } else if (BRACKETS_TOKENS.contains(tokenType)) {
            return BRACKETS_KEYS;
        } else if (PARENTHESES_TOKENS.contains(tokenType)) {
            return PARENTHESES_KEYS;
        } else if (OPERATOR_KEYWORDS.contains(tokenType)) {
            return OPERATOR_KEYWORD_KEYS;
        } else if (OBJECT_KEYWORDS.contains(tokenType)) {
            return OBJECT_KEYWORD_KEYS;
        } else if (FUNCTION_KEYWORDS.contains(tokenType)) {
            return FUNCTION_KEYWORD_KEYS;
        } else if (LANGUAGE_KEYWORDS.contains(tokenType)) {
            return KEYWORD_KEYS;
        } else if (PREDEFINED_SYMBOLS.contains(tokenType)) {
            return OPERATION_SIGN_KEYS;
        } else if (COMMENTS.contains(tokenType)) {
            return COMMENT_KEYS;
        } else if (tokenType.equals(TokenType.BAD_CHARACTER)) {
            return BAD_CHAR_KEYS;
        } else {
            return EMPTY_KEYS;
        }
    }
}
