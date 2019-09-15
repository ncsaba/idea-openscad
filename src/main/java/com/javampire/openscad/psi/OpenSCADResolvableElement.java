package com.javampire.openscad.psi;

import com.javampire.openscad.references.OpenSCADReferenceResolver;

public interface OpenSCADResolvableElement extends OpenSCADNamedElement {

    OpenSCADReferenceResolver getReferenceResolver();

}
