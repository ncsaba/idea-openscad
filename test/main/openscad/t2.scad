use <ta.scad>

tamodule(); // code completion should work

t2var = "t2var";

function t2function(t2arg1, t2arg2) = [t2arg1 * t2arg2];

module t2module(t2arg1, t2arg2) {
    echo(t2arg1); // code completions should work
    echo(t2var); // code completion should work
    tamodule(); // code completion should work
    module innerModule(t2arg3) {
        echo(t2arg3); // code completion should work
        for (t2for = [3:5]) {
            if (t2for != 4)
                echo(t2for); // code completion should work
        }
    }
}

t2module("a1", "a2"); // code completion should work