package com.javampire.openscad;

import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;
import com.intellij.openapi.options.colors.AttributesDescriptor;
import com.intellij.openapi.options.colors.ColorDescriptor;
import com.intellij.openapi.options.colors.ColorSettingsPage;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.util.Map;

public class OpenSCADColorSettingsPage implements ColorSettingsPage {
    private static final AttributesDescriptor[] DESCRIPTORS = new AttributesDescriptor[]{
            new AttributesDescriptor("Include", OpenSCADSyntaxHighlighter.IMPORT),
            new AttributesDescriptor("Include path", OpenSCADSyntaxHighlighter.IMPORT_PATH),
            new AttributesDescriptor("Identifier", OpenSCADSyntaxHighlighter.IDENTIFIER),
            new AttributesDescriptor("Keyword", OpenSCADSyntaxHighlighter.KEYWORD),
            new AttributesDescriptor("Builtin geometric operator", OpenSCADSyntaxHighlighter.OPERATOR_KEYWORD),
            new AttributesDescriptor("Builtin object primitive", OpenSCADSyntaxHighlighter.OBJECT_KEYWORD),
            new AttributesDescriptor("Builtin function", OpenSCADSyntaxHighlighter.FUNCTION_KEYWORD),
            new AttributesDescriptor("Number", OpenSCADSyntaxHighlighter.NUMBER),
            new AttributesDescriptor("String", OpenSCADSyntaxHighlighter.STRING),
            new AttributesDescriptor("Separator", OpenSCADSyntaxHighlighter.SEPARATOR),
            new AttributesDescriptor("Brackets", OpenSCADSyntaxHighlighter.BRACKETS),
            new AttributesDescriptor("Braces", OpenSCADSyntaxHighlighter.BRACES),
            new AttributesDescriptor("Parantheses", OpenSCADSyntaxHighlighter.PARENTHESES),
            new AttributesDescriptor("Comment", OpenSCADSyntaxHighlighter.COMMENT),
            new AttributesDescriptor("Operation sign", OpenSCADSyntaxHighlighter.OPERATION_SIGN),
    };

    @Nullable
    @Override
    public Icon getIcon() {
        return OpenSCADIcons.FILE;
    }

    @NotNull
    @Override
    public SyntaxHighlighter getHighlighter() {
        return new OpenSCADSyntaxHighlighter();
    }

    @NotNull
    @Override
    public String getDemoText() {
        return "/*\nYou are reading the \".scad\" entry\nfor OpenSCAD files.\n*/\n" +
               "use <some/path/used_file.scad>\n" +
               "include </another/path/included_file.scad>\n" +
               "\n" +
               "$fn=64;\n" +
               "some_var = 127;  // line-end comment about some_var\n" +
               "module some_module(var1=1, var2, foo) {\n" +
               "    translate([1,2,3]) cylinder(1,2,3);\n" +
               "    var1 = \"string_value\";\n" +
               "}\n" +
               "function some_function(var1, var2=\"string value\") =\n    foo + sin(1.128e+10);\n" +
               "if (x < max([1,10]) || x > 20 && x == 15)\n    sphere(x);\nelse\n    cube(x);\n\n";
    }

    @Nullable
    @Override
    public Map<String, TextAttributesKey> getAdditionalHighlightingTagToDescriptorMap() {
        return null;
    }

    @NotNull
    @Override
    public AttributesDescriptor[] getAttributeDescriptors() {
        return DESCRIPTORS;
    }

    @NotNull
    @Override
    public ColorDescriptor[] getColorDescriptors() {
        return ColorDescriptor.EMPTY_ARRAY;
    }

    @NotNull
    @Override
    public String getDisplayName() {
        return "OpenSCAD";
    }
}
