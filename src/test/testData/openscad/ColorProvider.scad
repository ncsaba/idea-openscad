include <subColorProvider.scad>

module colorProvide() {
    var3 = 5;
    color("#923192") cube([var3, var3, var3]);
    color("Blue", 0.5) cube([var3, var3, var3]);
    color(c = "#a81b38", alpha = 0.5) cube([var3, var3, var3]);
    color([137 / 255, 129 / 255, 32 / 255]) cube([var3, var3, var3]);
    color(c = [125 / 255, 45 / 255, 45 / 255]) cube([var3, var3, var3]);
    color(alpha = 1.0, c = [29 / 255, 165 / 255, 85 / 255]) cube([var3, var3, var3]);
}

var1 = 200;
var2 = var1;
var2 = "toto";