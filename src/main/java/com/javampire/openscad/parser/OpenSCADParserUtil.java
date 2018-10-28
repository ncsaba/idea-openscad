package com.javampire.openscad.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.parser.GeneratedParserUtilBase;

public class OpenSCADParserUtil extends GeneratedParserUtilBase {

    /**
     * Parse an expression with the group priority reset to 0. This is necessary in the inner part of
     * index expressions where the group priority would be set too high because the index expression itself
     * has high priority.
     */
    public static boolean innerExpression(PsiBuilder builder, int level) {
        return OpenSCADParser.expr(builder, level, 0);
    };

}
