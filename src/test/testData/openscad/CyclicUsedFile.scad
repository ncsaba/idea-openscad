use <SubColorProvider.scad>

function multiply(x, y) = x * y;
function x(abc) = abc;

module toto(a, b) {
    echo(a);
    echo(b);
}

x = let(abc = 1, xyz = a) let(def = 2) a + xyz + def;

let(xyz = 1) cube([1, 1, xyz]);
