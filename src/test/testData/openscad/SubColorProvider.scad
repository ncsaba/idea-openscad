use <CyclicUsedFile.scad>

module subColorProvider() {
    var3 = multiply(2, 3); // autocompletion should not trigger cyclic dependencies loading stack overflow
}

a = xxxxx + yyyyy *
    zzzz;

b = bbbb ?
    xxx :
        yyyy;

c = let (
    xx = 1,
    yy = 2
) xx + yy;

multmatrix(m = [
        [u[0], v[0], w[0], p0[0]],
        [u[1], v[1], w[1], p0[1]],
        [u[2], v[2], w[2], p0[2]],
        [0, 0, 0, 1]
    ]) cylinder(r = r, h = h);
