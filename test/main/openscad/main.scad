include <dep1.scad>

dep1module(); // code completion should work

dep11module(); // code completion should work

t2var = var1; // code completions should work

function t2function(t2arg1, t2arg2) = [t2arg1 * t2arg2];

module t2module(t2arg1, t2arg2) {
    echo(t2arg1) ; // code completions should work
    echo(t2var) ; // code completion should work
    dep1module(); // code completion should work
    module innerModule(t2arg3) {
        echo(t2arg3) ; // code completion should work
        for (t2for = [3:5]) {
            if (t2for != 4)
                let(t2arg4 = "test") echo(t2for, t2arg4); // code completion should work for both variables
        }
        if (true)
            cube([t2, 1, 12]);

        translate([1, 0, 0]) children(0); // code completion should work
    }
}

t2module("a1", "a2"); // code completion should work

a = 3; b = 5;

// echo() prints values before evaluating the expression
r1 = a * b; // ECHO: 3, 5
r1 = echo(a, b) a * b; // ECHO: 3, 5

// using let it's still easy to output the result
r2 = let(r = 2 * a * b) r; // ECHO: 30
r2 = let(r = 2 * a * b)
echo(r) r; // ECHO: 30

// use echo statement for showing results
echo(r1, r2); // ECHO: 15, 30

v = [4, 7, 9, 12];
function result(x) = echo(result = x) x;
function sum(x, i = 0) = echo(str("x[", i, "]=", x[i])) result(len(x) > i ? x[i] + sum(x, i + 1) : 0);
echo("sum(v) = ", sum(v));
