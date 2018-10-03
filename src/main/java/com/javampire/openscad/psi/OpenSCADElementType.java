package com.javampire.openscad.psi;

import com.intellij.psi.tree.IElementType;
import com.javampire.openscad.OpenSCADLanguage;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class OpenSCADElementType extends IElementType {
    public OpenSCADElementType(@NotNull @NonNls String debugName) {
        super(debugName, OpenSCADLanguage.INSTANCE);
    }
}
