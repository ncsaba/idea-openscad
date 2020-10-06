use <cyclicUsedFile.scad>

module subColorProvider() {
    var3 = multiply(2,3); // autocompletion should not trigger cyclic dependencies loading stack overflow
}