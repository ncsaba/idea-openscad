package com.javampire.openscad;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import com.javampire.openscad.psi.OpenSCADTypes;
import com.intellij.psi.TokenType;

%%

%class OpenSCADLexer
%implements FlexLexer
%unicode
%function advance
%type IElementType
%eof{  return;
%eof}

CRLF=\R
BLANK=[\ \n\t\f]
WHITE_SPACE={CRLF} | {BLANK}
INCLUDE_PATH=[^<>]+

C_STYLE_COMMENT=("/*"[^"*"]{COMMENT_TAIL})|"/*"
DOC_COMMENT="/*""*"+("/"|([^"/""*"]{COMMENT_TAIL}))?
COMMENT_TAIL=([^"*"]*("*"+[^"*""/"])?)*("*"+"/")?
END_OF_LINE_COMMENT="/""/"[^\r\n]*

IDENTIFIER = [:jletter:] [:jletterdigit:]*

DIGIT = [0-9]
DECIMAL = {DIGIT}+ "."? | {DIGIT}* "." {DIGIT}+
NUMBER_LITERAL = {DECIMAL} ([Ee] [+-]? {DIGIT}+)?

ESCAPE_SEQUENCE = \\[^]
SQ_STRING_LITERAL = "'" ([^\\\'] | {ESCAPE_SEQUENCE})* "'"?
DQ_STRING_LITERAL = \"  ([^\\\"] | {ESCAPE_SEQUENCE})* \"?

%state INCLUDE_PATH

%%

<YYINITIAL> {

    "include"                   { yybegin(INCLUDE_PATH); return OpenSCADTypes.INCLUDE_KEYWORD; }
    "use"                       { yybegin(INCLUDE_PATH); return OpenSCADTypes.USE_KEYWORD; }

    "false"                     { return OpenSCADTypes.FALSE_KEYWORD; }
    "true"                      { return OpenSCADTypes.TRUE_KEYWORD; }
    "undef"                     { return OpenSCADTypes.UNDEF_KEYWORD; }

    "assign"	                { return OpenSCADTypes.ASSIGN_KEYWORD; }
    "echo"	                    { return OpenSCADTypes.ECHO_KEYWORD; }
    "else"		                { return OpenSCADTypes.ELSE_KEYWORD; }
    "for"                       { return OpenSCADTypes.FOR_KEYWORD; }
    "function"	                { return OpenSCADTypes.FUNCTION_KEYWORD; }
    "if"                        { return OpenSCADTypes.IF_KEYWORD; }
    "intersection_for"          { return OpenSCADTypes.INTERSECTION_FOR_KEYWORD; }
    "let"                       { return OpenSCADTypes.LET_KEYWORD; }
    "module"	                { return OpenSCADTypes.MODULE_KEYWORD; }

    "cube"                      { return OpenSCADTypes.CUBE_KEYWORD; }
    "cylinder"                  { return OpenSCADTypes.CYLINDER_KEYWORD; }
    "echo"                      { return OpenSCADTypes.ECHO_KEYWORD; }
    "assert"                    { return OpenSCADTypes.ASSERT_KEYWORD; }
    "sphere"                    { return OpenSCADTypes.SPHERE_KEYWORD; }
    "polyhedron"                { return OpenSCADTypes.POLYHEDRON_KEYWORD; }
    "projection"                { return OpenSCADTypes.PROJECTION_KEYWORD; }
    "square"                    { return OpenSCADTypes.SQUARE_KEYWORD; }
    "circle"                    { return OpenSCADTypes.CIRCLE_KEYWORD; }
    "ellipse"                   { return OpenSCADTypes.ELLIPSE_KEYWORD; }
    "polygon"                   { return OpenSCADTypes.POLYGON_KEYWORD; }
    "text"                      { return OpenSCADTypes.TEXT_KEYWORD; }
    "surface"                   { return OpenSCADTypes.SURFACE_KEYWORD; }
    "child"                     { return OpenSCADTypes.CHILD_KEYWORD; }
    "children"                  { return OpenSCADTypes.CHILDREN_KEYWORD; }
    "import"                    { return OpenSCADTypes.IMPORT_KEYWORD; }
    "import_dxf"                { return OpenSCADTypes.IMPORT_DXF_KEYWORD; }
    "import_stl"                { return OpenSCADTypes.IMPORT_STL_KEYWORD; }

    "linear_extrude"            { return OpenSCADTypes.LINEAR_EXTRUDE_KEYWORD; }
    "rotate_extrude"            { return OpenSCADTypes.ROTATE_EXTRUDE_KEYWORD; }
    "rotate"                    { return OpenSCADTypes.ROTATE_KEYWORD; }
    "translate"                 { return OpenSCADTypes.TRANSLATE_KEYWORD; }
    "scale"                     { return OpenSCADTypes.SCALE_KEYWORD; }
    "resize"                    { return OpenSCADTypes.RESIZE_KEYWORD; }
    "mirror"                    { return OpenSCADTypes.MIRROR_KEYWORD; }
    "multmatrix"                { return OpenSCADTypes.MULTMATRIX_KEYWORD; }
    "color"                     { return OpenSCADTypes.COLOR_KEYWORD; }
    "offset"                    { return OpenSCADTypes.OFFSET_KEYWORD; }
    "minkowski"                 { return OpenSCADTypes.MINKOWSKI_KEYWORD; }
    "hull"                      { return OpenSCADTypes.HULL_KEYWORD; }
    "union"                     { return OpenSCADTypes.UNION_KEYWORD; }
    "difference"                { return OpenSCADTypes.DIFFERENCE_KEYWORD; }
    "intersection"              { return OpenSCADTypes.INTERSECTION_KEYWORD; }
    "render"                    { return OpenSCADTypes.RENDER_KEYWORD; }

    "let"                       { return OpenSCADTypes.LET_KEYWORD; }
    "cos"                       { return OpenSCADTypes.COS_KEYWORD; }
    "sin"                       { return OpenSCADTypes.SIN_KEYWORD; }
    "tan"                       { return OpenSCADTypes.TAN_KEYWORD; }
    "acos"                      { return OpenSCADTypes.ACOS_KEYWORD; }
    "asin"                      { return OpenSCADTypes.ASIN_KEYWORD; }
    "atan"                      { return OpenSCADTypes.ATAN_KEYWORD; }
    "atan2"                     { return OpenSCADTypes.ATAN2_KEYWORD; }
    "abs"                       { return OpenSCADTypes.ABS_KEYWORD; }
    "ceil"                      { return OpenSCADTypes.CEIL_KEYWORD; }
    "concat"                    { return OpenSCADTypes.CONCAT_KEYWORD; }
    "cross"                     { return OpenSCADTypes.CROSS_KEYWORD; }
    "exp"                       { return OpenSCADTypes.EXP_KEYWORD; }
    "floor"                     { return OpenSCADTypes.FLOOR_KEYWORD; }
    "ln"                        { return OpenSCADTypes.LN_KEYWORD; }
    "len"                       { return OpenSCADTypes.LEN_KEYWORD; }
    "log"                       { return OpenSCADTypes.LOG_KEYWORD; }
    "lookup"                    { return OpenSCADTypes.LOOKUP_KEYWORD; }
    "max"                       { return OpenSCADTypes.MAX_KEYWORD; }
    "min"                       { return OpenSCADTypes.MIN_KEYWORD; }
    "norm"                      { return OpenSCADTypes.NORM_KEYWORD; }
    "pow"                       { return OpenSCADTypes.POW_KEYWORD; }
    "rands"                     { return OpenSCADTypes.RANDS_KEYWORD; }
    "round"                     { return OpenSCADTypes.ROUND_KEYWORD; }
    "sign"                      { return OpenSCADTypes.SIGN_KEYWORD; }
    "sqrt"                      { return OpenSCADTypes.SQRT_KEYWORD; }
    "str"                       { return OpenSCADTypes.STR_KEYWORD; }
    "chr"                       { return OpenSCADTypes.CHR_KEYWORD; }
    "select"                    { return OpenSCADTypes.SELECT_KEYWORD; }
    "search"                    { return OpenSCADTypes.SEARCH_KEYWORD; }
    "version"                   { return OpenSCADTypes.VERSION_KEYWORD; }
    "version_num"               { return OpenSCADTypes.VERSION_NUM_KEYWORD; }
    "parent_module"             { return OpenSCADTypes.PARENT_MODULE_KEYWORD; }

    "="                         { return OpenSCADTypes.EQUALS; }
    ";"                         { return OpenSCADTypes.SEMICOLON; }
    ","                         { return OpenSCADTypes.COMMA; }
    "-"                         { return OpenSCADTypes.MINUS; }
    "+"                         { return OpenSCADTypes.PLUS; }
    "/"                         { return OpenSCADTypes.DIV; }
    "*"                         { return OpenSCADTypes.MUL; }
    "%"                         { return OpenSCADTypes.PERC; }
    "?"                         { return OpenSCADTypes.QUERY; }
    ":"                         { return OpenSCADTypes.COLON; }
    "("                         { return OpenSCADTypes.LPARENTH; }
    ")"                         { return OpenSCADTypes.RPARENTH; }
    "{"                         { return OpenSCADTypes.LBRACE; }
    "}"                         { return OpenSCADTypes.RBRACE; }
    "["                         { return OpenSCADTypes.LBRACKET; }
    "]"                         { return OpenSCADTypes.RBRACKET; }
    "#"                         { return OpenSCADTypes.HASH; }

    "<"                         { return OpenSCADTypes.LT; }
    "<="                        { return OpenSCADTypes.LE; }
    ">"                         { return OpenSCADTypes.GT; }
    ">="                        { return OpenSCADTypes.GE; }
    "=="                        { return OpenSCADTypes.EQ; }
    "!="                        { return OpenSCADTypes.NE; }

    "&&"                        { return OpenSCADTypes.AND; }
    "||"                        { return OpenSCADTypes.OR; }
    "!"                         { return OpenSCADTypes.EXCL; }

    {C_STYLE_COMMENT}           { return OpenSCADTypes.C_STYLE_COMMENT; }
    {DOC_COMMENT}               { return OpenSCADTypes.DOC_COMMENT; }
    {END_OF_LINE_COMMENT}       { return OpenSCADTypes.END_OF_LINE_COMMENT; }

    {NUMBER_LITERAL}            { return OpenSCADTypes.NUMBER_LITERAL; }
    {IDENTIFIER}                { return OpenSCADTypes.IDENTIFIER; }
    {SQ_STRING_LITERAL}         { return OpenSCADTypes.SQ_STRING_LITERAL; }
    {DQ_STRING_LITERAL}         { return OpenSCADTypes.DQ_STRING_LITERAL; }

}

{WHITE_SPACE}+                  { return TokenType.WHITE_SPACE; }

<INCLUDE_PATH> {
    "<"                         { return OpenSCADTypes.INCLUDE_START; }
    {INCLUDE_PATH}              { return OpenSCADTypes.INCLUDE_PATH; }
    ">"                         { yybegin(YYINITIAL); return OpenSCADTypes.INCLUDE_END; }
}

[^]                             { return TokenType.BAD_CHARACTER; }
