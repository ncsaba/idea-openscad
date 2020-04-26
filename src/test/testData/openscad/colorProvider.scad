include <subColorProvider.scad>

module colorProvide() {
    color("#FF0002") cube([var3, var3, var3]);
    color("Blue") cube([var3, var3, var3]);
    color("Crimson", 1.0) cube([var3, var3, var3]);
    color([100/255, 100/255, 100/255]) cube([var3, var3, var3]);
    color(c = [100/255, 100/255, 100/255]) cube([var3, var3, var3]);
    color(c = [100/255, 100/255, 100/255], alpha = 1.0) cube([var3, var3, var3]);
}

var1 = 2;
var2 = var1;
