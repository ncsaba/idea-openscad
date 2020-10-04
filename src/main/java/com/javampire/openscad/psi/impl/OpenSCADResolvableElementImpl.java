package com.javampire.openscad.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiReference;
import com.javampire.openscad.psi.*;
import com.javampire.openscad.psi.stub.index.OpenSCADFunctionIndex;
import com.javampire.openscad.psi.stub.index.OpenSCADModuleIndex;
import com.javampire.openscad.psi.stub.index.OpenSCADVariableIndex;
import com.javampire.openscad.references.OpenSCADCallReference;
import com.javampire.openscad.references.OpenSCADReferenceResolver;
import org.jetbrains.annotations.NotNull;

public abstract class OpenSCADResolvableElementImpl
        extends OpenSCADNamedElementImpl
        implements OpenSCADResolvableElement {

    private static final Logger LOG = Logger.getInstance("#com.javampire.openscad.psi.impl.OpenSCADResolvableElementImpl");

    public OpenSCADResolvableElementImpl(@NotNull ASTNode node) {
        super(node);
    }

    public OpenSCADReferenceResolver getReferenceResolver() {
        if (
                this instanceof OpenSCADModuleObjNameRef
                        || this instanceof OpenSCADModuleOpNameRef
                        || this instanceof OpenSCADCommonOpRef
                        || this instanceof OpenSCADBuiltinObjRef
        ) {
            return OpenSCADModuleIndex.getInstance();
        } else if (
                this instanceof OpenSCADFunctionNameRef
                        || this instanceof OpenSCADBuiltinExprRef
        ) {
            return OpenSCADFunctionIndex.getInstance();
        } else if (this instanceof OpenSCADVariableRefExpr) {
            return OpenSCADVariableIndex.getInstance();
        } else {
            final String name = getName();
            LOG.warn("getReferenceResolver(not handled named element of type " + getClass().getName() + "): " + name);
        }
        return null;
    }

    public PsiReference getReference() {
        return new OpenSCADCallReference(this, new TextRange(0, getTextLength()));
    }

}
