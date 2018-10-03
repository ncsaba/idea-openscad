package com.javampire.openscad.psi;

import com.intellij.psi.tree.IElementType;
import com.javampire.openscad.OpenSCADLanguage;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class OpenSCADTokenType extends IElementType {
    public OpenSCADTokenType(@NotNull @NonNls String debugName) {
        super(debugName, OpenSCADLanguage.INSTANCE);
    }

    @Override
    public String toString() {
        return "OpenSCADTokenType." + super.toString();
    }
}
