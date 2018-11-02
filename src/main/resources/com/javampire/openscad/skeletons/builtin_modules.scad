
// Linear Extrusion is a modeling operation that takes a 2D polygon as input
// and extends it in the third dimension. This way a 3D shape is created.
// Keep in mind that extrusion is always performed from XY plane to the
// height indicate along Z axis; so if you rotate or apply other transformations
// before extrusion, the extrusion is applied to the projection of the 2D polygon
// to the XY plane.
//
// Usage:
//     linear_extrude(
//         height = fanwidth,
//         center = true,
//         convexity = 10,
//         twist = -fanrot,
//         slices = 20,
//         scale = 1.0
//     ) {...}
//
// You must use parameter names due to a backward compatibility issue.
//
// <height> must be positive.
//
// If the extrusion fails for a non-trivial 2D shape, try setting the
// convexity parameter (the default is not 10, but 10 is a "good" value to try).
//
// Twist is the number of degrees of through which the shape is extruded.
// Setting the parameter twist = 360 will extrude through one revolution.
// The twist direction follows the left hand rule.
//
// Center is similar to the parameter center of cylinders. If center is false
// the linear extrusion Z range is from 0 to height; if it is true, the range
// is from -height/2 to height/2.
//
// The slices parameter defines the number of intermediate points along the Z
// axis of the extrusion. Its default increases with the value of twist.
// Explicitly setting slices may improve the output refinement.
// The special variables $fn, $fs and $fa can also be used to improve the output.
// If slices is not defined, its value is taken from the defined $fn value.
//
// <scale> scales the 2D shape by this value over the height of the extrusion.
// Scale can be a scalar or a vector. Note that if scale is a vector, the resulting
// side walls may be nonplanar. Use twist=0 and the slices parameter to avoid asymmetry.
//
//
module linear_extrude(height = fanwidth, center = true, convexity = 10, twist = -fanrot, slices = 20, scale = 1.0) {
    children();
}

// Rotational extrusion spins a 2D shape around the Z-axis to form a solid which has
// rotational symmetry. One way to think of this operation is to imagine a Potter's
// wheel placed on the X-Y plane with its axis of rotation pointing up towards +Z.
// Then place the to-be-made object on this virtual Potter's wheel (possibly extended
// down below the X-Y plane towards -Z, take the cross-section of this object on the
// X-Z plane but keep only the right half (X >= 0). That is the 2D shape that need to
// be fed to rotate_extrude() as the child in order to generate this solid.
//
// Since a 2D shape is rendered by OpenSCAD on the X-Y plane, an alternative way to
// think of this operation is as follows: spins a 2D shape around the Y-axis to form
// a solid. The resultant solid is placed so that its axis of rotation lies along
// the Z-axis.
//
// It can not be used to produce a helix or screw threads.
//
// The 2D shape needs to lie completely on either the right (recommended) or the left
// side of the Y-axis. More precisely speaking, each vertex of the shape must have
// either x >= 0 or x <= 0. If the shape crosses the X axis a warning will be shown
// in the console windows and the rotate_extrude() will be ignored. For OpenSCAD
// versions prior to 2016.xxxx, if the shape is in the negative axis the faces will
// be inside-out, which may cause undesired effects.
//
// Usage:
//     rotate_extrude(
//         angle = 360,
//         convexity = 2
//     ) {...}
//
// You must use parameter names due to a backward compatibility issue.
//
// Parameters:
//
// convexity
//     If the extrusion fails for a non-trival 2D shape, try setting the convexity
//     parameter (the default is not 10, but 10 is a "good" value to try). See
//     explanation further down.
//
// angle [Note: Requires version 2016.XX]
//     Defaults to 360. Specifies the number of degrees to sweep, starting at the
//     positive X axis. The direction of the sweep follows the Right Hand Rule,
//     hence a negative angle will sweep clockwise.
//
// Mesh refinement:
//     Increasing the number of fragments that the 2D shape is composed of will
//     improve the quality of the mesh, but take longer to render.
//     The number of fragments used by the extrusion can also be increased by setting the $fn parameter.
//
//
module rotate_extrude(angle=360, convexity=2) {
    children();
}

// Rotates its child 'a' degrees about the axis of the coordinate system or around
// an arbitrary axis. The argument names are optional if the arguments are given
// in the same order as specified.
//
// Usage:
//     rotate(a = deg_a, v = [x, y, z]) { ... }
//     // or
//     rotate(deg_a, [x, y, z]) { ... }
//     rotate(a = [deg_x, deg_y, deg_z]) { ... }
//     rotate([deg_x, deg_y, deg_z]) { ... }
//
// The 'a' argument (deg_a) can be an array, as expressed in the later usage above;
// when deg_a is an array, the 'v' argument is ignored. Where 'a' specifies multiple
// axes then the rotation is applied in the following order: x, y, z.
// That means the code:
//
//     rotate(a=[ax,ay,az]) {...}
//
// is equivalent to:
//
//     rotate(a=[0,0,az]) rotate(a=[0,ay,0]) rotate(a=[ax,0,0]) {...}
//
// The optional argument 'v' is a vector and allows you to set an arbitrary axis about
// which the object will be rotated.
//
// For example, to flip an object upside-down, you can rotate your object 180 degrees
// around the 'y' axis.
//
//     rotate(a=[0,180,0]) { ... }
//
// This is frequently simplified to
//
//     rotate([0,180,0]) { ... }
//
// When specifying a single axis the 'v' argument allows you to specify which axis is
// the basis for rotation. For example, the equivalent to the above, to rotate just
// around y
//
//     rotate(a=180, v=[0,1,0]) { ... }
//
// When specifying a single axis, 'v' is a vector defining an arbitrary axis for rotation;
// this is different from the multiple axis above. For example, rotate your object 45 degrees
// around the axis defined by the vector [1,1,0],
//
//     rotate(a=45, v=[1,1,0]) { ... }
//
// Rotate with a single scalar argument rotates around the Z axis. This is useful in 2D
// contexts where that is the only axis for rotation. For example:
//
//     rotate(45) square(10);
//
// Rotation rule help:
//
//     rotate([a, b, c]) { ... };
//
// "a" is a rotation about the X axis, from the +Y axis, toward the +Z axis.
// "b" is a rotation about the Y axis, from the +Z axis, toward the +X axis.
// "c" is a rotation about the Z axis, from the +X axis, toward the +Y axis.
//
// These are all cases of the Right Hand Rule. Point your right thumb along the positive axis,
// your fingers show the direction of rotation.
//
// Thus if "a" is fixed to zero, and "b" and "c" are manipulated appropriately,
// this is the spherical coordinate system.
// So, to construct a cylinder from the origin to some other point (x,y,z):
//
//     x= 10; y = 10; z = 10; // point coordinates of end of cylinder
//
//     length = norm([x,y,z]);  // radial distance
//     b = acos(z/length); // inclination angle
//     c = atan2(y,x);     // azimuthal angle
//
//     rotate([0, b, c])
//         cylinder(h=length, r=0.5);
//     %cube([x,y,z]); // corner of cube should coincide with end of cylinder
//
//
module rotate(a = deg_a, v = [x, y, z]) {
    children();
}

// Translates (moves) its child elements along the specified vector.
// The argument name is optional.
//
// Example:
//     translate(v = [x, y, z]) { ... }
//
//     cube(2,center = true);
//     translate([5,0,0])
//        sphere(1,center = true);
//
//
module translate(v=[x, y, z]) {
    children();
}

// Scales its child elements using the specified vector. The argument name is optional.
//
// Usage Example:
//     scale(v = [x, y, z]) { ... }
//
//     cube(10);
//     translate([15,0,0]) scale([0.5,1,2]) cube(10);
//
// Note:
//     Do not use negative scale values. Negative scale values appear to work for previews,
//     but they lead to unpredictable errors when rendering through CGAL. Use the mirror()
//     function instead.
//
//
module scale(v = [x, y, z]) {
    children();
}

// Modifies the size of the child object to match the given x,y, and z.
//
// resize() is a CGAL operation, and like others such as render() operates
// with full geometry, so even in preview will take time to process.
//
// Usage Example:
//
//     // resize the sphere to extend 30 in x, 60 in y, and 10 in the z directions.
//     resize(newsize=[30,60,10]) sphere(r=10);
//
// If x,y, or z is 0 then that dimension is left as-is.
//
//     // resize the 1x1x1 cube to 2x2x1
//     resize([2,2,0]) cube();
//
// If the 'auto' parameter is set to true, it will auto-scale any 0-dimensions
// to match. For example:
//
//     // resize the 1x2x0.5 cube to 7x14x3.5
//     resize([7,0,0], auto=true) cube([1,2,0.5]);
//
// The 'auto' parameter can also be used if you only wish to auto-scale a
// single dimension, and leave the other as-is.
//
//     // resize to 10x8x1. Note that the z dimension is left alone.
//     resize([10,0,0], auto=[true,true,false]) cube([5,4,1]);
//
//
module resize(newsize=[0, 0, 0], auto=[false, false, false]) {
    children();
}

// Mirrors the child element on a plane through the origin. The argument to
// mirror() is the normal vector of a plane intersecting the origin through
// which to mirror the object.
//
// Function signature:
//
//     mirror(v = [x, y, z]) { ... }
//
// Examples
//
// The original is on the right side. Note that mirror doesn't make a copy.
// Like rotate and scale, it changes the object.
//
//     hand(); // original
//     mirror([1,0,0]) hand();
//
//     hand(); // original
//     mirror([1,1,0]) hand();
//
//     hand(); // original
//     mirror([1,1,1]) hand();
//
//     rotate([0,0,10]) cube([3,2,1]);
//     mirror([1,0,0]) translate([1,0,0]) rotate([0,0,10]) cube([3,2,1]);
//
//
module mirror(v = [x, y, z]) {
    children();
}

// Multiplies the geometry of all child elements with the given 4x4
// transformation matrix.
//
// Usage: multmatrix(m = [...]) { ... }
//
// This is a breakdown of what you can do with the independent elements
// in the matrix (for the first three rows):
//
//     [Scale X]  [Scale X sheared along Y]  [Scale X sheared along Z]  [Translate X]
//     [Scale Y sheared along X]  [Scale Y]  [Scale Y sheared along Z]  [Translate Y]
//     [Scale Z sheared along X]  [Scale Z sheared along Y]  [Scale Z]  [Translate Z]
//
// The fourth row is used in 3D environments to define a view of the object.
// It is not used in OpenSCAD and should be [0,0,0,1]
//
// Example which rotates by 45 degrees in XY plane and translates by
// [10,20,30], ie the same as translate([10,20,30]) rotate([0,0,45])
// would do:
//
//     angle=45;
//     multmatrix(m = [ [cos(angle), -sin(angle), 0, 10],
//                      [sin(angle),  cos(angle), 0, 20],
//                      [         0,           0, 1, 30],
//                      [         0,           0, 0,  1]
//                   ]) union() {
//        cylinder(r=10.0,h=10,center=false);
//        cube(size=[10,10,10],center=false);
//     }
//
// Example that skews a model, something that is not possible with the
// other transformations. Also shows you can have the matrix in a variable:
//
//     M = [ [ 1  , 0  , 0  , 0   ],
//           [ 0  , 1  , 0.7, 0   ],  // The "0.7" is the skew value; pushed along the y axis
//           [ 0  , 0  , 1  , 0   ],
//           [ 0  , 0  , 0  , 1   ] ] ;
//     multmatrix(M) {  union() {
//         cylinder(r=10.0,h=10,center=false);
//         cube(size=[10,10,10],center=false);
//     } }
//
//
module multmatrix() {
    children();
}

// Displays the child elements using the specified RGB color + alpha value.
// This is only used for the F5 preview as CGAL and STL (F6) do not currently
// support color. The alpha value will default to 1.0 (opaque) if not specified.
//
// Function signature:
//
//     color( c = [r, g, b, a] ) { ... }
//     color( c = [r, g, b], alpha = 1.0 ) { ... }
//     color( "colorname", 1.0 ) { ... }
//
// Note that the r, g, b, a values are limited to floating point values in the
// range [0,1] rather than the more traditional integers { 0 ... 255 }.
// However, nothing prevents you to using R, G, B values from {0 ... 255} with
// appropriate scaling:
//
//     color([ R/255, G/255, B/255 ]) { ... }
//
// Since version 2011.12, colors can also be defined by name (case insensitive).
// For example, to create a red sphere, you can write:
//
//     color("red") sphere(5);
//
// Alpha is specified as an extra parameter for named colors:
//
//     color("Blue",0.5) cube(5);
//
// The available color names are taken from the World Wide Web consortium's
// SVG color list (http://www.w3.org/TR/css3-color/).
//
// Example 1: A 3-D multicolor sine wave
//
// Here's a code fragment that draws a wavy multicolor object
//
//     for(i=[0:36]) {
//       for(j=[0:36]) {
//         color( [0.5+sin(10*i)/2, 0.5+sin(10*j)/2, 0.5+sin(10*(i+j))/2] )
//         translate( [i, j, 0] )
//         cube( size = [1, 1, 11+10*cos(10*i)*sin(10*j)] );
//       }
//     }
//
// Being that -1<=sin(x)<=1 then 0<=(1/2 + sin(x)/2)<=1 , allowing for the
// RGB components assigned to color to remain within the [0,1] interval.
//
// Example 2
//
// In cases where you want to optionally set a color based on a parameter you can use the following trick:
//
//     module myModule(withColors=false) {
//         c=withColors?"red":undef;
//         color(c) circle(r=10);
//     }
//
// Setting the colorname to undef will keep the default colors.
//
//
module color(c = [r, g, b], alpha = 1.0) {
    children();
}

// Offset allows moving 2D outlines outward or inward by a given amount.
//
// This is useful for making thin walls, by differencing a positive-offset
// exterior and a negative-offset interior.
//
// Fillet: offset(r=-3) offset(delta=+3) rounds all inside (concave) corners,
// and leaves flat walls unchanged. However, holes less than 2*r in diameter
// will vanish.
//
// Round: offset(r=+3) offset(delta=-3) rounds all outside (convex) corners,
// and leaves flat walls unchanged. However, walls less than 2*r thick will
// vanish.
//
// Parameters
//
// r | delta
//     Double. Amount to offset the polygon. When negative, the polygon is
//     offset inwards. The parameter r specifies the radius that is used to
//     generate rounded corners, using delta gives straight edges.
//
// Example 1:
//
//     linear_extrude(height = 60, twist = 90, slices = 60) {
//        difference() {
//          offset(r = 10) {
//           square(20, center = true);
//          }
//          offset(r = 8) {
//            square(20, center = true);
//          }
//        }
//     }
//
// Example 2:
//
//     module fillet(r) {
//        offset(r = -r) {
//          offset(delta = r) {
//            children();
//          }
//        }
//     }
//
//
module offset(r, delta) {
    children();
}

// Displays the minkowski sum of child nodes.
//
// Usage example:
//
// Say you have a flat box, and you want a rounded edge. There are many ways
// to do this, but minkowski is very elegant. Take your box, and a cylinder:
//
//     $fn=50;
//     cube([10,10,1]);
//     cylinder(r=2,h=1);
//
// Then, do a minkowski sum of them (note that the outer dimensions of the
// box are now 10+2+2 = 14 units by 14 units by 2 units high as the heights
// of the objects are summed):
//
//     $fn=50;
//     minkowski()
//     {
//       cube([10,10,1]);
//       cylinder(r=2,h=1);
//     }
//
// NB: The origin of the second object is used for the addition. If the second
// object is not centered, then the addition will be asymmetric. The following
// minkowski sums are different: the first expands the original cube by 0.5 units
// in all directions, both positive and negative. The second expands it by +1 in
// each positive direction, but doesn't expand in the negative directions.
//
//     minkowski() {
//         cube([10, 10, 1]);
//         cylinder(1, center=true);
//     }
//
//     minkowski() {
//         cube([10, 10, 1]);
//         cylinder(1);
//     }
//
//
module minkowski() {
    children();
}

// Displays the convex hull of child nodes.
//
// Usage example:
//
//     hull() {
//         translate([15,10,0]) circle(10);
//         circle(10);
//     }
//
// Hull with 2D arguments can only produce a 2D result; translating
// the constituent 2D parts in the Z direction has no effect.
//
//
module hull() {
    children();
}

// Creates a union of all its child nodes. This is the sum of all children (logical or).
// May be used with either 2D or 3D objects, but don't mix them.
//
// Usage example:
//
//     union() {
//         cylinder (h = 4, r=1, center = true, $fn=100);
//         rotate ([90,0,0]) cylinder (h = 4, r=0.9, center = true, $fn=100);
//     }
//
// Remark:
//     union is implicit when not used. But it is mandatory, for example,
//     in difference to group first child nodes into one.
//
//
module union() {
    children();
}

// Subtracts the 2nd (and all further) child nodes from the first one (logical and not).
// May be used with either 2D or 3D objects, but don't mix them.
//
// Usage example:
//
//     difference() {
//         cylinder (h = 4, r=1, center = true, $fn=100);
//         rotate ([90,0,0]) cylinder (h = 4, r=0.9, center = true, $fn=100);
//     }
//
// Difference with multiple children(note in the second example the result
// of adding a union of the 1st and 2nd children):
//
//     // Usage example for difference of multiple children:
//     $fn=90;
//     difference(){
//                                                 cylinder(r=5,h=20,center=true);
//         rotate([00,140,-45]) color("LightBlue") cylinder(r=2,h=25,center=true);
//         rotate([00,40,-50])                     cylinder(r=2,h=30,center=true);
//         translate([0,0,-10])rotate([00,40,-50]) cylinder(r=1.4,h=30,center=true);
//     }
//
//     // second instance with added union
//     translate([10,10,0]){
//         difference(){
//           union(){        // combine 1st and 2nd children
//                                                     cylinder(r=5,h=20,center=true);
//             rotate([00,140,-45]) color("LightBlue") cylinder(r=2,h=25,center=true);
//           }
//           rotate([00,40,-50])                       cylinder(r=2,h=30,center=true);
//           translate([0,0,-10])rotate([00,40,-50])   cylinder(r=1.4,h=30,center=true);
//         }
//     }
//
//
module difference() {
    children();
}

// Creates the intersection of all child nodes. This keeps the overlapping
// portion (logical and). Only the area which is common or shared by all
// children is retained.
//
// May be used with either 2D or 3D objects, but don't mix them.
//
// Usage example:
//
//     intersection() {
//         cylinder (h = 4, r=1, center = true, $fn=100);
//         rotate ([90,0,0]) cylinder (h = 4, r=0.9, center = true, $fn=100);
//     }
//
//
module intersection() {
    children();
}

// Warning:
//     Using render, always calculates the CSG model for this tree
//     (even in OpenCSG preview mode).
//     This can make previewing very slow and OpenSCAD to appear to hang/freeze.
//
// Usage example:
//
//     render(convexity = 1) { ... }
//
// Parameter:
//
// convexity
//     Integer. The convexity parameter specifies the maximum number of front and
//     back sides a ray intersecting the object might penetrate. This parameter is
//     only needed for correctly displaying the object in OpenCSG preview mode and
//     has no effect on the polyhedron rendering.
//     Setting it to 10 should work fine for most cases.
//
//
module render(convexity = 1) {
    children();
}

// Using the projection() function, you can create 2d drawings from 3d models,
// and export them to the dxf format. It works by projecting a 3D model to the
// (x,y) plane, with z at 0.
//
// If cut=true, only points with z=0 will be considered (effectively cutting the object),
// with cut=false(the default), points above and below the plane will be considered as well
// (creating a proper projection).
//
//
module projection(cut=false) {
    children();
}

// Creates a cube in the first octant. When center is true, the cube is centered
// on the origin. Argument names are optional if given in the order shown here.
//
//     cube(size = [x,y,z], center = true/false);
//     cube(size =  x ,     center = true/false);
//
// Parameters:
//
//     size
//         single value, cube with all sides this length
//         3 value array [x,y,z], cube with dimensions x, y and z.
//
//     center
//         false (default), 1st (positive) octant, one corner at (0,0,0)
//         true, cube is centered at (0,0,0)
//
// Default values:
//
//     cube();   yields:  cube(size = [1, 1, 1], center = false);
//
// Example 1 - all these are equivalent:
//
//     cube(size = 18);
//     cube(18);
//     cube([18,18,18]);
//     cube(18,false);
//     cube([18,18,18],false);
//     cube([18,18,18],center=false);
//     cube(size = [18,18,18], center = false);
//     cube(center = false,size = [18,18,18] );
//
// Example 2 - equivalent scripts:
//
//     cube([18,28,8],true);
//     box=[18,28,8];cube(box,true);
//
//
module cube(size = [1, 1, 1], center = false){}

// Creates a cylinder or cone centered about the z axis. When center is true,
// it is also centered vertically along the z axis.
//
// Parameter names are optional if given in the order shown here. If a parameter
// is named, all following parameters must also be named.
//
// NOTE:
//     If r, d, d1 or d2 are used they must be named.
//
//     cylinder(h = height, r1 = BottomRadius, r2 = TopRadius, center = true/false);
//
// Parameters
//
//     h : height of the cylinder or cone
//     r  : radius of cylinder. r1 = r2 = r.
//     r1 : radius, bottom of cone.
//     r2 : radius, top of cone.
//     d  : diameter of cylinder. r1 = r2 = d /2.
//     d1 : diameter, bottom of cone. r1 = d1 /2
//     d2 : diameter, top of cone. r2 = d2 /2
//
//     center:
//        false (default), z ranges from 0 to h
//        true, z ranges from -h/2 to +h/2
//
//     $fa : minimum angle (in degrees) of each fragment.
//     $fs : minimum circumferential length of each fragment.
//     $fn : fixed number of fragments in 360 degrees. Values of 3 or more override $fa and $fs
//
// NOTES:
//     d,d1,d2 require 2014.03 or later. Debian is currently known to be behind this;
//
//     $fa, $fs and $fn must be named.
//
// Defaults:
//     cylinder();  yields: cylinder($fn = 0, $fa = 12, $fs = 2, h = 1, r1 = 1, r2 = 1, center = false);
//
// Example 1 - equivalent scripts:
//
//     cylinder(h=15, r1=9.5, r2=19.5, center=false);
//     cylinder(  15,    9.5,    19.5, false);
//     cylinder(  15,    9.5,    19.5);
//     cylinder(  15,    9.5, d2=39  );
//     cylinder(  15, d1=19,  d2=39  );
//     cylinder(  15, d1=19,  r2=19.5);
//
// Example 2 - equivalent scripts:
//
//     cylinder(h=15, r1=10, r2=0, center=true);
//     cylinder(  15,    10,    0,        true);
//     cylinder(h=15, d1=20, d2=0, center=true);
//
// Example 3 - equivalent scripts:
//
//     cylinder(h=20, r=10, center=true);
//     cylinder(  20,   10, 10,true);
//     cylinder(  20, d=20, center=true);
//     cylinder(  20,r1=10, d2=20, center=true);
//     cylinder(  20,r1=10, d2=2*10, center=true);
//
// Larger values of $fn create smoother, more circular, surfaces at the cost of
// longer rendering time. Some use medium values during development for the faster
// rendering, then change to a larger value for the final F6 rendering.
//
// However, use of small values can produce some interesting non circular objects.
// Examples:
//
//     cylinder(20,20,20,$fn=3);
//     cylinder(20,20,00,$fn=4);
//     cylinder(20,20,10,$fn=4);
//
// When using cylinder() with difference() to place holes in objects, the holes
// will be undersized. This is because circular paths are approximated with
// polygons inscribed within in a circle. The points of the polygon are on
// the circle, but straight lines between are inside. To have all of the hole
// larger than the true circle, the polygon must lie wholly outside of the circle
// (circumscribed).
//
// Notes on accuracy:
//     Circle objects are approximated. The algorithm for doing this matters
//     when you want 3d printed holes to be the right size.
//
//
module cylinder(
    h = 1, r1 = 1, r2 = 1, center = false,
    r = undef, d = undef, d1 = undef, d2 = undef,
    $fn = 0, $fa = 12, $fs = 2
){}

// This function prints the contents to the compilation window (aka Console).
// Useful for debugging code. Also see the String function str().
//
// Numeric values are rounded to 5 significant digits.
//
// The OpenSCAD console supports a subset of HTML markup language. See Qt Docs
// for details.
//
// It can be handy to use 'variable=variable' as the expression to easily label
// the variables, see the example below.
//
// Usage examples:
//
//     my_h=50;
//     my_r=100;
//     echo("This is a cylinder with h=", my_h, " and r=", my_r);
//     echo(my_h=my_h,my_r=my_r); // shortcut
//     cylinder(h=my_h, r=my_r);
//
//     echo("<b>Hello</b> <i>Qt!</i>");
//
// Shows in the Console as:
//
//     ECHO: "This is a cylinder with h=", 50, " and r=", 100
//     ECHO: my_h = 50, my_r = 100
//     ECHO: "Hello Qt!"
//
// An example for the rounding:
//
//     a=1.0;
//     b=1.000002;
//     echo(a);
//     echo(b);
//
//     if(a==b){ //while echoed the same, the values are still distinct
//         echo ("a==b");
//     }else if(a>b){
//         echo ("a>b");
//     }else if(a<b){
//         echo ("a<b");
//     }else{
//         echo ("???");
//     }
//
// Small and large Numbers:
//
//     c=1000002;
//     d=0.000002;
//     echo(c); //1e+06
//     echo(d); //2e-06
//
// Working HTML examples:
//
//     echo("<h1>Heading</h1>");
//     echo("<b>Bold</b> <i>italic</i> <big>big</big>");
//     echo("i<sub>1</sub><sup>2<sup>");
//     echo("<font color='red'>red</font> <font color='green'>green</font> <font color='blue'>blue</font>");
//
// Not really working HTML examples:
//
//     echo("<img src='http://www.openscad.org/assets/img/logo.png'></img>");
//     echo("<a href='http://en.wikibooks.org/'>wikibooks</a>");
//
// Note:
//     the Output can be copy and pasted into OpenOffice, where both the image
//     and the link work fine.
//
//
module echo(values){}

// [Note: Requires version nightly build]
//
// Assert evaluates a logical expression. If the expression evaluates to false, the
// generation of the preview/render is stopped with an error. A string representation
// of the expression and, if given, the message is output to the console.
//
// Parameters
//
// condition
//     Expression. The expression to be evaluated as check for the assertion.
//
// message
//     String. Optional message to be output in case the assertion failed.
//
// Examples
//
// The simplest example is a simple assert(false);, e.g. in a file named assert_example1.scad.
//
//     cube();
//     assert(false);
//     sphere();
//
//     // ERROR: Assertion 'false' failed in file assert_example1.scad, line 2
//
// This example has little use, but the simple assert(false);
// can be used in code sections that should be unreachable.
//
// Checking parameters
//
// A useful example is checking the validity of input parameters:
//
//     module row(cnt = 3){
//         // Count has to be a positive integer greater 0
//         assert(cnt > 0);
//         for (i = [1 : cnt]) {
//             translate([i * 2, 0, 0]) sphere();
//         }
//     }
//
//     row(0);
//
//     // ERROR: Assertion '(cnt > 0)' failed in file assert_example2.scad, line 3
//
// Adding message
//
// When writing a library, it could be useful to output additional
// information to the user in case of an failed assertion.
//
//     module row(cnt = 3){
//         assert(cnt > 0, "Count has to be a positive integer greater 0");
//         for(i = [1 : cnt]) {
//             translate([i * 2, 0, 0]) sphere();
//         }
//     }
//
//     row(0);
//
//     // ERROR: Assertion '(cnt > 0)': "Count has to be a positive integer greater 0" failed in file assert_example3.scad, line 2
//
//
module assert(condition, message){}

// Creates a sphere at the origin of the coordinate system.
// The r argument name is optional. To use d instead of r, d must be named.
//
// Parameters
//
//     r
//         Radius. This is the radius of the sphere. The resolution of the
//         sphere will be based on the size of the sphere and the $fa, $fs
//         and $fn variables.
//
//     d
//         Diameter. This is the diameter of the sphere.
//
//     $fa
//         Fragment angle in degrees
//     $fs
//         Fragment size in mm
//     $fn
//         Resolution
//
// NOTE:
//     d is only available in versions later than 2014.03.
//     Debian is currently known to be behind this.
//
// Default values:
//     sphere();   yields:   sphere($fn = 0, $fa = 12, $fs = 2, r = 1);
//
// Usage examples:
//
//     sphere(r = 1);
//     sphere(r = 5);
//     sphere(r = 10);
//     sphere(d = 2);
//     sphere(d = 10);
//     sphere(d = 20);
//
//     // this will create a high resolution sphere with a 2mm radius
//     sphere(2, $fn=100);
//
//     // will also create a 2mm high resolution sphere but this one
//     // does not have as many small triangles on the poles of the sphere
//     sphere(2, $fa=5, $fs=0.1);
//
//
module sphere(r = 1, d = undef, $fn = 0, $fa = 12, $fs = 2){}

// A polyhedron is the most general 3D primitive solid. It can be used to
// create any regular or irregular shape including those with concave as
// well as convex features. Curved surfaces are approximated by a series
// of flat surfaces.
//
//     // before 2014.03:
//     polyhedron(
//         points = [ [X0, Y0, Z0], [X1, Y1, Z1], ... ],
//         triangles = [ [P0, P1, P2], ... ],
//         convexity = N
//     );
//     // 2014.03 & later:
//     polyhedron(
//         points = [ [X0, Y0, Z0], [X1, Y1, Z1], ... ],
//         faces = [ [P0, P1, P2, P3, ...], ... ],
//         convexity = N
//     );
//
// Parameters
//
//     points
//         Vector of 3d points or vertices. Each point is in turn a vector,
//         [x,y,z], of its coordinates. Points may be defined in any order.
//         N points are referenced, in the order defined, as 0 to N-1.
//
//     triangles (deprecated in version 2014.03, use faces)
//         Vector of faces which collectively enclose the solid. Each face
//         is a vector containing the indices (0 based) of 3 points from the
//         points vector.
//
//     faces (introduced in version 2014.03)
//         Vector of faces which collectively enclose the solid. Each face is
//         a vector containing the indices (0 based) of 3 or more points from
//         the points vector. Faces may be defined in any order. Define enough
//         faces to fully enclose the solid, with no overlap.
//         Points which describe a single face must all be on the same plane.
//
//     convexity
//         Integer. The convexity parameter specifies the maximum number of
//         faces a ray intersecting the object might penetrate. This parameter
//         is only needed for correctly displaying the object in OpenCSG preview
//         mode. It has no effect on the polyhedron rendering. For display problems,
//         setting it to 10 should work fine for most cases.
//
// Default values:
//     polyhedron(); yields: polyhedron(points = undef, faces = undef, convexity = 1);
//
// All faces must have points ordered in the same direction . OpenSCAD prefers
// clockwise when looking at each face from outside inwards. The back is viewed
// from the back, the bottom from the bottom, etc..
//
// Example 1 - using polyhedron to generate cube( [ 10, 7, 5 ] ):
//
//     CubePoints = [
//       [  0,  0,  0 ],  //0
//       [ 10,  0,  0 ],  //1
//       [ 10,  7,  0 ],  //2
//       [  0,  7,  0 ],  //3
//       [  0,  0,  5 ],  //4
//       [ 10,  0,  5 ],  //5
//       [ 10,  7,  5 ],  //6
//       [  0,  7,  5 ]]; //7
//
//     CubeFaces = [
//       [0,1,2,3],  // bottom
//       [4,5,1,0],  // front
//       [7,6,5,4],  // top
//       [5,6,2,1],  // right
//       [6,7,3,2],  // back
//       [7,4,0,3]]; // left
//
//     polyhedron( CubePoints, CubeFaces );
//
// Equivalent descriptions of the bottom face:
//       [0,1,2,3],
//       [0,1,2,3,0],
//       [1,2,3,0],
//       [2,3,0,1],
//       [3,0,1,2],
//       [0,1,2],[2,3,0],   // 2 triangles with no overlap
//       [1,2,3],[3,0,1],
//       [1,2,3],[0,1,3],
//
// Example 2 - a square base pyramid:
//
//     polyhedron(
//       points=[ [10,10,0],[10,-10,0],[-10,-10,0],[-10,10,0], // the four points at base
//                [0,0,10]  ],                                 // the apex point
//       faces=[ [0,1,4],[1,2,4],[2,3,4],[3,0,4],              // each triangle side
//                   [1,0,3],[2,1,3] ]                         // two triangles for square base
//     );
//
// Example 3 - a triangular prism:
//
//     module prism(l, w, h){
//         polyhedron(
//                 points=[[0,0,0], [l,0,0], [l,w,0], [0,w,0], [0,w,h], [l,w,h]],
//                 faces=[[0,1,2,3],[5,4,3,2],[0,4,5,1],[0,3,4],[5,2,1]]
//                 );
//
//         // preview unfolded (do not include in your function
//         z = 0.08;
//         separation = 2;
//         border = .2;
//         translate([0,w+separation,0])
//             cube([l,w,z]);
//         translate([0,w+separation+w+border,0])
//             cube([l,h,z]);
//         translate([0,w+separation+w+border+h+border,0])
//             cube([l,sqrt(w*w+h*h),z]);
//         translate([l+border,w+separation+w+border+h+border,0])
//             polyhedron(
//                 points=[[0,0,0],[h,0,0],[0,sqrt(w*w+h*h),0], [0,0,z],[h,0,z],[0,sqrt(w*w+h*h),z]],
//                 faces=[[0,1,2], [3,5,4], [0,3,4,1], [1,4,5,2], [2,5,3,0]]
//             );
//         translate([0-border,w+separation+w+border+h+border,0])
//             polyhedron(
//                 points=[[0,0,0],[0-h,0,0],[0,sqrt(w*w+h*h),0], [0,0,z],[0-h,0,z],[0,sqrt(w*w+h*h),z]],
//                 faces=[[1,0,2],[5,3,4],[0,1,4,3],[1,2,5,4],[2,0,3,5]]
//             );
//         }
//
//     prism(10, 5, 3);
//
// Debugging polyhedra
//
// Mistakes in defining polyhedra include not having all faces with the same order,
// overlap of faces and missing faces or portions of faces. As a general rule, the
// polyhedron faces should also satisfy (manifold conditions):
//
//     * exactly two faces should meet at any polyhedron edge.
//
//     * if two faces have a vertex in common, they should be in
//       the same cycle face-edge around the vertex.
//
// The first rule eliminates polyhedron like two cubes with a common edge and not
// watertight models; the second excludes polyhedron like two cubes with a common
// vertex.
//
// When viewed from the outside, the points describing each face must be in the same
// order . OpenSCAD prefers CW, and provides a mechanism for detecting CCW. When the
// thrown together view (F12) is used with F5, CCW faces are shown in pink. Reorder
// the points for incorrect faces. Rotate the object to view all faces. The pink view
// can be turned off with F10.
//
// OpenSCAD allows, temporarily, commenting out part of the face descriptions so that
// only the remaining faces are displayed. Use // to comment out the rest of the line.
// Use /* and */ to start and end a comment block. This can be part of a line or extend
// over several lines. Viewing only part of the faces can be helpful in determining the
// right points for an individual face. Note that a solid is not shown, only the faces.
// If using F12, all faces have one pink side. Commenting some faces helps also to show
// any internal face.
//
// Example - showing only 2 faces:
//
//     CubeFaces = [
//     /* [0,1,2,3],  // bottom
//        [4,5,1,0],  // front */
//        [7,6,5,4],  // top
//     /* [5,6,2,1],  // right
//        [6,7,3,2],  // back */
//        [7,4,0,3]]; // left
//
// After defining a polyhedron, its preview may seem correct. The polyhedron alone may
// even render fine. However to be sure it is a valid manifold and that it will generate
// a valid STL file, union it with any cube and render it (F6). If the polyhedron disappears,
// it means that it is not correct. Revise the winding order of all faces and the two rules
// stated above.
//
// Example 4 - a more complex polyhedron with mis-ordered faces:
//
//     // Bad polyhedron
//     polyhedron(
//         points = [
//             [0, -10, 60], [0, 10, 60], [0, 10, 0], [0, -10, 0], [60, -10, 60], [60, 10, 60],
//             [10, -10, 50], [10, 10, 50], [10, 10, 30], [10, -10, 30], [30, -10, 50], [30, 10, 50]
//         ],
//         faces = [
//               [0,2,3], [0,1,2], [0,4,5], [0,5,1], [5,4,2], [2,4,3],
//               [6,8,9], [6,7,8], [6,10,11], [6,11,7], [10,8,11],
//               [10,9,8], [0,3,9], [9,0,6], [10,6, 0], [0,4,10],
//               [3,9,10], [3,10,4], [1,7,11], [1,11,5], [1,7,8],
//               [1,8,2], [2,8,11], [2,11,5]
//          ]
//     );
//
// When you select 'Thrown together' from the view menu and compile the design
// (not compile and render!) you will see a preview with the mis-oriented polygons
// highlighted. Unfortunately this highlighting is not possible in the OpenCSG
// preview mode because it would interfere with the way the OpenCSG preview mode
// is implemented.)
//
// A correct polyhedron would be the following:
//
//     polyhedron(
//         points = [
//             [0, -10, 60], [0, 10, 60], [0, 10, 0], [0, -10, 0], [60, -10, 60], [60, 10, 60],
//             [10, -10, 50], [10, 10, 50], [10, 10, 30], [10, -10, 30], [30, -10, 50], [30, 10, 50]
//         ],
//         faces = [
//             [0,3,2], [0,2,1], [4,0,5], [5,0,1], [5,2,4], [4,2,3],
//             [6,8,9], [6,7,8], [6,10,11],[6,11,7], [10,8,11],
//             [10,9,8], [3,0,9], [9,0,6], [10,6, 0], [0,4,10],
//             [3,9,10], [3,10,4], [1,7,11], [1,11,5], [1,8,7],
//             [2,8,1], [8,2,11], [5,11,2]
//         ]
//     );
//
// Beginner's tip:
//     If you don't really understand "orientation", try to identify the mis-oriented
//     pink faces and then invert the sequence of the references to the points vectors
//     until you get it right. E.g. in the above example, the third triangle ([0,4,5])
//     was wrong and we fixed it as [4,0,5]. Remember that a face list is a circular
//     list. In addition, you may select "Show Edges" from the "View Menu", print a
//     screen capture and number both the points and the faces. In our example, the
//     points are annotated in black and the faces in blue. Turn the object around
//     and make a second copy from the back if needed. This way you can keep track.
//
// Clockwise Technique:
//     Orientation is determined by clockwise circular indexing. This means that if
//     you're looking at the triangle (in this case [4,0,5]) from the outside you'll
//     see that the path is clockwise around the center of the face. The winding order
//     [4,0,5] is clockwise and therefore good. The winding order [0,4,5] is
//     counter-clockwise and therefore bad. Likewise, any other clockwise order of
//     [4,0,5] works: [5,4,0] & [0,5,4] are good too. If you use the clockwise technique,
//     you'll always have your faces outside (outside of OpenSCAD, other programs do use
//     counter-clockwise as the outside though).
//
// Think of it as a Left Hand Rule:
//     If you hold the face and the fingers of your right hand curls is the same order
//     as the points, then your thumb points outwards.
//
// Succinct description of a 'Polyhedron'
//     * Points define all of the points/vertices in the shape.
//     * Faces is a list of flat polygons that connect up the points/vertices.
//
// Each point, in the point list, is defined with a 3-tuple x,y,z position specification.
// Points in the point list are automatically enumerated starting from zero for use in
// the faces list (0,1,2,3,... etc).
//
// Each face, in the faces list, is defined by selecting 3 or more of the points
// (using the point order number) out of the point list.
//
// e.g. faces=[ [0,1,2] ] defines a triangle from the first point
// (points are zero referenced) to the second point and then to the third point.
//
// When looking at any face from the outside, the face must list all points in a
// clockwise order.
//
// Alternate Face Descriptions
//
// Before 2014.03, faces could only be described via triangles. Since 2014.03, a
// face description can have any number of points. The points, all in the same plane,
// must be listed in the proper order. Since version ???, the face vertices do not
// have to be planar: OpenSCAD will do its best to internally subdivide the face in
// triangles. Note that this may lead to different results depending on the chosen
// face triangulation. If a specific result is needed, the non planar face should be
// broken in triangular pieces by the user.
//
// An alternate (correct) face definition for Example 4:
//
//     faces = [
//       [0,3,2,1], [0,1,5,4],   [2,3,4,5],    // outside
//       [6,7,8,9], [7,6,10,11], [11,10,9,8],  // inside
//       [0,4,3,0,6,9,10,6],                   // front
//       [1,2,5,1,7,11,8,7]                    // back
//     ]
//
// Point repetitions in a polyhedron point list
//
// The point list of the polyhedron definition may have repetitions.
// When two or more points have the same coordinates they are considered
// the same polyhedron vertex. So, the following polyhedron:
//
//     points = [[ 0, 0, 0], [10, 0, 0], [ 0,10, 0],
//               [ 0, 0, 0], [10, 0, 0], [ 0,10, 0],
//               [ 0,10, 0], [10, 0, 0], [ 0, 0,10],
//               [ 0, 0, 0], [ 0, 0,10], [10, 0, 0],
//               [ 0, 0, 0], [ 0, 0,10], [ 0,10, 0]];
//     polyhedron(points, [[0,1,2], [3,4,5], [6,7,8], [9,10,11]] );
//
// define the same tetrahedron as:
//
//     points = [[0,0,0], [0,10,0], [10,0,0], [0,0,10]];
//     polyhedron(points, [[0,2,1], [0,1,3], [1,2,3], [0,3,2]] );
//
//
module polyhedron(points = undef, faces = undef, triangles = undef, convexity = 1){}

// Creates a square or rectangle in the first quadrant. When center is true
// the square is centered on the origin. Argument names are optional if given
// in the order shown here.
//
//     square(size = [x, y], center = true/false);
//     square(size =  x    , center = true/false);
//
// Parameters:
//
//     size
//         single value, square with both sides this length
//         2 value array [x,y], rectangle with dimensions x and y
//
//     center
//         false (default), 1st (positive) quadrant, one corner at (0,0)
//         true, square is centered at (0,0)
//
// Default values:
//     square();   yields:  square(size = [1, 1], center = false);
//
// Example 1 - 10x10 square equivalent scripts:
//
//     square(size = 10);
//     square(10);
//     square([10,10]);
//
//     square(10,false);
//     square([10,10],false);
//     square([10,10],center=false);
//     square(size = [10, 10], center = false);
//     square(center = false,size = [10, 10] );
//
// Example 2 - 20x10 square equivalent scripts:
//
//     square([20,10],true);
//     a=[20,10];square(a,true);
//
//
module square(size = [1, 1], center = false){}

// Creates a circle at the origin. All parameters, except r, must be named.
//
//     circle(r=radius | d=diameter);
//
// Parameters
//
//     r:
//         circle radius. r name is the only one optional with circle.
//     d:
//         circle diameter (only available in versions later than 2014.03).
//
//     $fa:
//         minimum angle (in degrees) of each fragment.
//     $fs:
//         minimum circumferential length of each fragment.
//     $fn:
//         fixed number of fragments in 360 degrees.
//         Values of 3 or more override $fa and $fs
//
// $fa, $fs and $fn must be named.
//
// Defaults:
//     circle();  yields: circle($fn = 0, $fa = 12, $fs = 2, r = 1);
//
// Circle resolution is based on size, using $fa or $fs.
// For a small, high resolution circle you can make a large circle,
// then scale it down, or you could set $fn or other special variables.
//
// Note:
//     These examples exceed the resolution of a 3d printer as well
//     as of the display screen.
//
// Example 1:
//
//     // create a high resolution circle with a radius of 2.
//     scale([1/100, 1/100, 1/100]) circle(200);
//     // Another way:
//     circle(2, $fn=50);
//
// Example 2 - equivalent scripts:
//
//     circle(10);
//     circle(r=10);
//     circle(d=20);
//     circle(d=2+9*2);
//
// Example 3 - ellipse equivalent scripts:
//
//     // An ellipse can be created from a circle by using either
//     // scale() or resize() to make the x and y dimensions unequal.
//
//     resize([30,10])circle(d=20);
//     scale([1.5,.5])circle(d=20);
//
// Example 4 - regular polygon:
//
//     // A regular polygon of 3 or more sides can be created by a hack
//     // of using circle() with $fn set to the number of sides.
//     // But DON'T USE IT! The only purpose of circle is creating circles
//     // and ellipses. Software is free to render and process them as circles.
//     // Also $fn can be redefined and your "polygons" will become true circles.
//     // Use the code below instead:
//
//     module regular_polygon(order, r=1){
//         angles=[ for (i = [0:order-1]) i*(360/order) ];
//         coords=[ for (th=angles) [r*cos(th), r*sin(th)] ];
//         polygon(coords);
//     }
//
//     // The polygon is inscribed within the circle with all sides (and angles)
//     // equal. One corner points to the positive x direction. For irregular
//     // shapes see the polygon primitive below.
//
//     translate([-42,  0]){circle(20,$fn=3);%circle(20,$fn=90);}
//     translate([  0,  0]) circle(20,$fn=4);
//     translate([ 42,  0]) circle(20,$fn=5);
//     translate([-42,-42]) circle(20,$fn=6);
//     translate([  0,-42]) circle(20,$fn=8);
//     translate([ 42,-42]) circle(20,$fn=12);
//
//     color("black"){
//         translate([-42,  0,1])text("3",7,,center);
//         translate([  0,  0,1])text("4",7,,center);
//         translate([ 42,  0,1])text("5",7,,center);
//         translate([-42,-42,1])text("6",7,,center);
//         translate([  0,-42,1])text("8",7,,center);
//         translate([ 42,-42,1])text("12",7,,center);
//     }
//
//
module circle(r = 1, d = undef, $fn = 0, $fa = 12, $fs = 2){}

// Creates a multiple sided shape from a list of x,y coordinates.
// A polygon is the most powerful 2D object. It can create anything
// that circle and squares can, as well as much more. This includes
// irregular shapes with both concave and convex edges. In addition
// it can place holes within that shape.
//
//     polygon(points = [ [x, y], ... ], paths = [ [p1, p2, p3..], ...], convexity = N);
//
// Parameters
//
//     points
//         The list of x,y points of the polygon. : A vector of 2 element vectors.
//         Note: points are indexed from 0 to n-1.
//
//     paths
//         default
//             If no path is specified, all points are used in the order listed.
//         single vector
//             The order to traverse the points. Uses indices
//             from 0 to n-1. May be in a different order and
//             use all or part, of the points listed.
//         multiple vectors
//             Creates primary and secondary shapes. Secondary
//             shapes are subtracted from the primary shape
//             (like difference). Secondary shapes may be wholly
//             or partially within the primary shape.
//         A closed shape is created by returning from the last
//         point specified to the first.
//
//     convexity
//         Integer number of "inward" curves, ie. expected path
//         crossings of an arbitrary line through the polygon.
//         The convexity parameter specifies the maximum number of front sides
//         (back sides) a ray intersecting the object might penetrate. This
//         parameter is only needed for correctly displaying the object in
//         OpenCSG preview mode and has no effect on the polyhedron rendering.
//
// Defaults:
//     polygon();  yields:  polygon(points = undef, paths = undef, convexity = 1);
//
// Example 1 - no holes equivalent scripts:
//
//     polygon(points=[[0,0],[100,0],[130,50],[30,50]]);
//     polygon([[0,0],[100,0],[130,50],[30,50]], paths=[[0,1,2,3]]);
//     polygon([[0,0],[100,0],[130,50],[30,50]],[[3,2,1,0]]);
//     polygon([[0,0],[100,0],[130,50],[30,50]],[[1,0,3,2]]);
//
//     a=[[0,0],[100,0],[130,50],[30,50]];
//     b=[[3,0,1,2]];
//     polygon(a);
//     polygon(a,b);
//     polygon(a,[[2,3,0,1,2]]);
//
// Example 2 - one hole equivalent scripts:
//
//     // The 1st path vector, [0,1,2], selects the points,
//     // [0,0],[100,0],[0,100], for the primary shape.
//     // The 2nd path vector, [3,4,5], selects the points,
//     // [10,10],[80,10],[10,80], for the secondary shape.
//     // The secondary shape is subtracted from the primary
//     // ( think difference() ).
//     // Since the secondary is wholly within the primary,
//     // it leaves a shape with a hole.
//
//     polygon(points=[[0,0],[100,0],[0,100],[10,10],[80,10],[10,80]], paths=[[0,1,2],[3,4,5]],convexity=10);
//
//     triangle_points =[[0,0],[100,0],[0,100],[10,10],[80,10],[10,80]];
//     triangle_paths =[[0,1,2],[3,4,5]];
//     polygon(triangle_points,triangle_paths,10);
//
// Example 3 - multi hole:
//
//     // NOTE: concat() requires 2015.03 or later
//     a0 = [[0,0],[100,0],[130,50],[30,50]];     // main
//     b0 = [1,0,3,2];
//     a1 = [[20,20],[40,20],[30,30]];            // hole 1
//     b1 = [4,5,6];
//     a2 = [[50,20],[60,20],[40,30]];            // hole 2
//     b2 = [7,8,9];
//     a3 = [[65,10],[80,10],[80,40],[65,40]];    // hole 3
//     b3 = [10,11,12,13];
//     a4 = [[98,10],[115,40],[85,40],[85,10]];   // hole 4
//     b4 = [14,15,16,17];
//     a  = concat (a0,a1,a2,a3,a4);
//     b  = [b0,b1,b2,b3,b4];
//     polygon(a,b);
//     //alternate
//     polygon(a,[b0,b1,b2,b3,b4]);
//
//
module polygon(points = undef, paths = undef, convexity = 1){}

// The text module creates text as a 2D geometric object, using fonts
// installed on the local system or provided as separate font file.
//
// Note:
//     Requires version 2015.03
//
// Parameters
//
//     text:
//         String. The text to generate.
//
//     size:
//         Decimal. The generated text will have approximately an ascent
//         of the given value (height above the baseline). Default is 10.
//         Note that specific fonts will vary somewhat and may not fill
//         the size specified exactly, usually slightly smaller.
//
//     font:
//         String. The name of the font that should be used. This is not
//         the name of the font file, but the logical font name (internally
//         handled by the fontconfig library). This can also include a style
//         parameter, see below. A list of installed fonts & styles can be
//         obtained using the font list dialog (Help -> Font List).
//
//     halign:
//         String. The horizontal alignment for the text. Possible values are
//         "left", "center" and "right". Default is "left".
//
//     valign:
//         String. The vertical alignment for the text. Possible values are
//         "top", "center", "baseline" and "bottom". Default is "baseline".
//
//     spacing:
//         Decimal. Factor to increase/decrease the character spacing.
//         The default value of 1 will result in the normal spacing for
//         the font, giving a value greater than 1 will cause the letters
//         to be spaced further apart.
//
//     direction:
//         String. Direction of the text flow. Possible values are
//         "ltr" (left-to-right), "rtl" (right-to-left),
//         "ttb" (top-to-bottom) and "btt" (bottom-to-top).
//         Default is "ltr".
//
//     language:
//         String. The language of the text. Default is "en".
//
//     script:
//         String. The script of the text. Default is "latin".
//
//     $fn:
//         used for subdividing the curved path segments provided by freetype
//
// Example 1:
//
//     text("OpenSCAD");
//
// Note:
//     To allow specification of particular Unicode characters you can specify
//     them in a string with the following escape codes;
//
//     \x03 - single hex character (only allowed values are 01h - 7fh)
//
//     \u0123 - unicode char with 4 hexadecimal digits (note: Lowercase)
//
//     \U012345 - unicode char with 6 hexadecimal digits (note: Uppercase)
//
//
// Example 2:
//
//     t="\u20AC10 \u263A"; // 10 euro and a smilie
//
// Using Fonts & Styles
//
// Fonts are specified by their logical font name; in addition a style parameter
// can be added to select a specific font style like "bold" or "italic", such as:
//
//     font="Liberation Sans:style=Bold Italic"
//
// The font list dialog shows the font name and the font style for each available
// font. For reference, the dialog also displays the location of the font file.
// You can drag a font in the font list, into the editor window to use in the
// text() statement.
//
// OpenSCAD includes the fonts Liberation Mono, Liberation Sans, Liberation Sans Narrow
// and Liberation Serif. Hence, as fonts in general differ by platform type, use of
// these included fonts is likely to be portable across platforms.
//
// For common/casual text usage, the specification of one of these fonts is recommended
// for this reason. Liberation Sans is the default font to encourage this.
//
//
// In addition to the installed fonts, it's possible to add project specific font files.
// Supported font file formats are TrueType Fonts (*.ttf) and OpenType Fonts (*.otf).
// The files need to be registered with use<>.
//
//     use <ttf/paratype-serif/PTF55F.ttf>
//
// After the registration, the font will also be listed in the font list dialog,
// so in case logical name of a font is unknown, it can be looked up there are it
// was registered.
//
// OpenSCAD uses fontconfig to find and manage fonts, so it's possible to list the
// system configured fonts on command line using the fontconfig tools in a format
// similar to the GUI dialog.
//
//     $ fc-list -f "%-60{{%{family[0]}%{:style[0]=}}}%{file}\n" | sort
//
//     ...
//     Liberation Mono:style=Bold Italic /usr/share/fonts/truetype/liberation2/LiberationMono-BoldItalic.ttf
//     Liberation Mono:style=Bold        /usr/share/fonts/truetype/liberation2/LiberationMono-Bold.ttf
//     Liberation Mono:style=Italic      /usr/share/fonts/truetype/liberation2/LiberationMono-Italic.ttf
//     Liberation Mono:style=Regular     /usr/share/fonts/truetype/liberation2/LiberationMono-Regular.ttf
//     ...
//
// Example 3:
//
//     square(10);
//
//     translate([15, 15]) {
//         text("OpenSCAD", font = "Liberation Sans");
//     }
//
//     translate([15, 0]) {
//         text("OpenSCAD", font = "Liberation Sans:style=Bold Italic");
//     }
//
// Vertical alignment
//
//     top
//         The text is aligned with the top of the bounding box at the given Y coordinate.
//
//     center
//         The text is aligned with the center of the bounding box at the given Y coordinate.
//
//     baseline
//         The text is aligned with the font baseline at the given Y coordinate. This is the default.
//
//     bottom
//         The text is aligned with the bottom of the bounding box at the given Y coordinate.
//
// Example 4 - OpenSCAD vertical text alignment:
//
//     text = "Align";
//     font = "Liberation Sans";
//
//     valign = [
//         [  0, "top"],
//         [ 40, "center"],
//         [ 75, "baseline"],
//         [110, "bottom"]
//     ];
//
//     for (a = valign) {
//         translate([10, 120 - a[0], 0]) {
//             color("red") cube([135, 1, 0.1]);
//             color("blue") cube([1, 20, 0.1]);
//             linear_extrude(height = 0.5) {
//                 text(
//                     text = str(text,"_",a[1]),
//                     font = font,
//                     size = 20,
//                     valign = a[1]
//                 );
//             }
//         }
//     }
//
// Horizontal alignment
//
//     left
//         The text is aligned with the left side of the bounding box at the given X coordinate. This is the default.
//
//     center
//         The text is aligned with the center of the bounding box at the given X coordinate.
//
//     right
//         The text is aligned with the right of the bounding box at the given X coordinate.
//
// Example 5 - OpenSCAD horizontal text alignment:
//
//     text = "Align";
//     font = "Liberation Sans";
//
//     halign = [
//         [10, "left"],
//         [50, "center"],
//         [90, "right"]
//     ];
//
//     for (a = halign) {
//         translate([140, a[0], 0]) {
//             color("red") cube([115, 2,0.1]);
//             color("blue") cube([2, 20,0.1]);
//             linear_extrude(height = 0.5) {
//                 text(
//                     text = str(text,"_",a[1]),
//                     font = font,
//                     size = 20,
//                     halign = a[1]
//                 );
//             }
//         }
//     }
//
// Renderable 3D text can be easily produced using the linear_extrude(height) operator.
//
//
module text(
    text = undef,
    size = 10,
    font = undef,
    halign = "left",
    valign = "baseline",
    spacing = 1,
    direction = "ltr",
    language = "en",
    script = "latin"
){}

// Surface reads Heightmap information from text or image files.
//
// Parameters
//
//     file
//         String. The path to the file containing the heightmap data.
//
//     center
//         Boolean. This determines the positioning of the generated object.
//         If true, object is centered in X- and Y-axis. Otherwise, the object
//         is placed in the positive quadrant. Defaults to false.
//
//     invert
//         Boolean. Inverts how the color values of imported images are
//         translated into height values. This has no effect when importing
//         text data files. Defaults to false.
//         [Note: Requires version 2015.03]
//
//     convexity
//         Integer. The convexity parameter specifies the maximum number of
//         front sides (back sides) a ray intersecting the object might penetrate.
//         This parameter is only needed for correctly displaying the object in
//         OpenCSG preview mode and has no effect on the final rendering.
//
// Text file format
//
// The format for text based heightmaps is a matrix of numbers that represent
// the height for a specific point. Rows are mapped to the Y-axis, columns to
// the X axis. The numbers must be separated by spaces or tabs. Empty lines
// and lines starting with a # character are ignored.
//
// Images
//
// [Note: Requires version 2015.03]
//
// Currently only PNG images are supported. Alpha channel information of the
// image is ignored and the height for the pixel is determined by converting
// the color value to Grayscale using the linear luminance for the sRGB color
// space (Y = 0.2126R + 0.7152G + 0.0722B). The gray scale values are scaled
// to be in the range 0 to 100.
//
// Example 1:
//
// //surface.scad
// surface(file = "surface.dat", center = true, convexity = 5);
// %translate([0,0,5])cube([10,10,10], center =true);
//
// #surface.dat
// 10 9 8 7 6 5 5 5 5 5
// 9 8 7 6 6 4 3 2 1 0
// 8 7 6 6 4 3 2 1 0 0
// 7 6 6 4 3 2 1 0 0 0
// 6 6 4 3 2 1 1 0 0 0
// 6 6 3 2 1 1 1 0 0 0
// 6 6 2 1 1 1 1 0 0 0
// 6 6 1 0 0 0 0 0 0 0
// 3 1 0 0 0 0 0 0 0 0
// 3 0 0 0 0 0 0 0 0 0
//
// Example 2
//
//  // example010.dat generated using octave:
//  // d = (sin(1:0.2:10)' * cos(1:0.2:10)) * 10;
//  // save("example010.dat", "d");
//  intersection() {
//    surface(file = "example010.dat", center = true, convexity = 5);
//    rotate(45, [0, 0, 1]) surface(file = "example010.dat", center = true, convexity = 5);
//  }
//
//
module surface(file=None, center=false, invert=false, convexity=1){}

// Deprecated:
//     Please use children() module as of release 2014.03 and later.
//
// Use of children() allows modules to act as operators applied to any or
// all of the objects within this module instantiation. In use, operator
// modules do not end with a semi-colon.
//
// Up to release 2013.06 the now deprecated child() module was used instead.
// This can be translated to the new children() according to the table:
//
// +--------------------------------------+-----------------------------+
// |             up to 2013.06            |       2014.03 and later     |
// +--------------------------------------+-----------------------------+
// |  child()                             |  children(0)                |
// +--------------------------------------+-----------------------------+
// |  child(x)                            |  children(x)                |
// +--------------------------------------+-----------------------------+
// |  for (a = [0:$children-1]) child(a)  |  children([0:$children-1])  |
// +--------------------------------------+-----------------------------+
//
//
module child(){}

// Use of children() allows modules to act as operators applied to any or all
// of the objects within this module instantiation. In use, operator modules
// do not end with a semi-colon.
//
//     name ( parameter values ){scope of operator}
//
// Children
//
// Objects are indexed via integers from 0 to $children-1. OpenSCAD sets $children
// to the total number of objects within the scope. Objects grouped into a sub
// scope are treated as one child. See example of separate children below and
// Scope of variables.
//
//     children();                         all children
//     children(index);                    value or variable to select one child
//     children([start : step : end]);     select from start to end incremented by step
//     children([start : end]);            step defaults to 1 or -1
//     children([vector]);                 selection of several children
//
// Example 1 - Use all children:
//
//     module move(x=0,y=0,z=0,rx=0,ry=0,rz=0)
//     { translate([x,y,z])rotate([rx,ry,rz]) children(); }
//
//     move(10)           cube(10,true);
//     move(-10)          cube(10,true);
//     move(z=7.07, ry=45)cube(10,true);
//     move(z=-7.07,ry=45)cube(10,true);
//
// Example 2 - Use only the first child, multiple times:
//
//     module lineup(num, space) {
//        for (i = [0 : num-1])
//          translate([ space*i, 0, 0 ]) children(0);
//     }
//
//     lineup(5, 65){ sphere(30);cube(35);}
//
// Example 3 - Separate action for each child:
//
//     module SeparateChildren(space){
//         for ( i= [0:1:$children-1])   // step needed in case $children < 2
//             translate([i*space,0,0]) {
//                 children(i);
//                 text(str(i));
//             }
//     }
//
//     SeparateChildren(-20){
//         cube(5);              // 0
//         sphere(5);            // 1
//         translate([0,20,0]){  // 2
//             cube(5);
//             sphere(5);
//         }
//         cylinder(15);         // 3
//         cube(8,true);         // 4
//     }
//     translate([0,40,0])color("lightblue")
//         SeparateChildren(20){cube(3,true);}
//
// Example 4 - Multiple ranges:
//
//     module MultiRange(){
//        color("lightblue") children([0:1]);
//        color("lightgreen")children([2:$children-2]);
//        color("lightpink") children($children-1);
//     }
//
//     MultiRange()
//     {
//        cube(5);              // 0
//        sphere(5);            // 1
//        translate([0,20,0]){  // 2
//          cube(5);
//          sphere(5);
//        }
//        cylinder(15);         // 3
//        cube(8,true);         // 4
//     }
//
// Example 5:
//
//     // Objects
//     module arrow(){
//         cylinder(10);
//         cube([4,.5,3],true);
//         cube([.5,4,3],true);
//         translate([0,0,10]) cylinder(4,2,0,true);
//     }
//
//     module cannon(){
//         difference(){union()
//           {sphere(10);cylinder(40,10,8);} cylinder(41,4,4);
//     } }
//
//     module base(){
//         difference(){
//           cube([40,30,20],true);
//           translate([0,0,5])  cube([50,20,15],true);
//     } }
//
//     // Operators
//     module aim(elevation,azimuth=0) {
//         rotate([0,0,azimuth]) {
//             rotate([0,90-elevation,0])
//                 children(0);
//             children([1:1:$children-1]);   // step needed in case $children < 2
//         }
//     }
//
//     aim(30,20)arrow();
//     aim(35,270)cannon();
//     aim(15){cannon();base();}
//
//     module RotaryCluster(radius=30,number=8)
//         for (azimuth =[0:360/number:359])
//           rotate([0,0,azimuth])
//             translate([radius,0,0]) { children();
//               translate([40,0,30]) text(str(azimuth)); }
//
//     RotaryCluster(200,7) color("lightgreen") aim(15){cannon();base();}
//     rotate([0,0,110]) RotaryCluster(100,4.5) aim(35)cannon();
//     color("LightBlue")aim(55,30){cannon();base();}
//
//
module children(child_index=None){}

// [Note: Requires version 2015.03-2]
//
// Imports a file for use in the current OpenSCAD model. OpenSCAD currently
// supports import of DXF, OFF and STL (both ASCII and Binary) files.
// The file extension is used to determine which type.
//
// OpenSCAD can export files as  STL, OFF, AMF, DXF, SVG, CSG OR PNG(Image).
//
// These file types created by OpenSCAD, or others, can be imported as follows:
//
//     STL, OFF and DXF are imported using import().
//     CSG can be imported using include<> or loaded like an SCAD file
//     PNG can be imported using surface()
//     There are open pull requests for SVG and AMF, which require a bit more work/testing.
//     The file suffix is used to determine type.
//
// The File >> Open command may be used to insert this command. The file type
// filter of the Open File dialog may only show OpenSCAD files, but file name
// can be replaced with a wildcard (e.g. *.stl) to browse to additional file types.
//
// Parameters
//
//     <file>
//         A string containing the path to the STL, OFF or DXF file.:If the give path
//         is not absolute, it is resolved relative to the importing script. Note that
//         when using include<> with a script that uses import(), this is relative to
//         the script doing the include<>.
//
//     <convexity>
//         An Integer. The convexity parameter specifies the maximum number of front
//         sides (back sides) a ray intersecting the object might penetrate.
//         This parameter is only needed for correctly displaying the object in OpenCSG
//         preview mode and has no effect on the polyhedron rendering. Optional.
//
//     <layer>
//         For DXF import only, specify a specific layer to import. Optional.
//
// Example:
//
//     import("example012.stl", convexity=3);
//     import("D:/Documents and Settings/User/My Documents/Gear.stl", convexity=3);
//
// Windows users must "escape" the backslashes by writing them doubled, or replace the
// backslashes with forward slashes.
//
//     // Read a layer of a 2D DXF file and create a 3D shape.
//     linear_extrude(height = 5, center = true, convexity = 10)
//             import_dxf(file = "example009.dxf", layer = "plate");
//
// In the latest version of OpenSCAD, import() is now used for importing both 2D
// (DXF for extrusion) and 3D (STL) files.
//
// If you want to render the imported STL file later, you have to make sure that the STL
// file is "clean". This means that the mesh has to be manifold and should not contain
// holes nor self-intersections. If the STL is not clean, you might get errors like:
//
//     CGAL error in CGAL_Build_PolySet: CGAL ERROR: assertion violation!
//     Expr: check_protocoll == 0
//     File: /home/don/openscad_deps/mxe/usr/i686-pc-mingw32/include/CGAL/Polyhedron_incremental_builder_3.h
//     Line: 199
//
// or
//
//     CGAL error in CGAL_Nef_polyhedron3(): CGAL ERROR: assertion violation!
//     Expr: pe_prev->is_border() || !internal::Plane_constructor<Plane>::get_plane(pe_prev->facet(),pe_prev->facet()->plane()).is_degenerate()
//     File: /home/don/openscad_deps/mxe/usr/i686-pc-mingw32/include/CGAL/Nef_3/polyhedron_3_to_nef_3.h
//     Line: 253
//
// In order to clean the STL file, you have the following options:
//
//     * use http://wiki.netfabb.com/Semi-Automatic_Repair_Options .
//       This will repair the holes but not the self-intersections;
//     * use netfabb basic. This free software doesn't have the option
//       to close holes nor can it fix the self-intersections;
//     * use MeshLab, This free software can fix all the issues.
//
// Using MeshLab, you can do:
//
//     * Render - Show non Manif Edges
//     * Render - Show non Manif Vertices
//     * if found, use Filters - Selection - Select non Manifold Edges or
//       Select non Manifold Vertices - Apply - Close. Then click button
//       'Delete the current set of selected vertices...' or check
//       http://www.youtube.com/watch?v=oDx0Tgy0UHo for an instruction video.
//       The screen should show "0 non manifold edges", "0 non manifold vertices"
//     * Next, you can click the icon 'Fill Hole', select all the holes and click
//       Fill and then Accept. You might have to redo this action a few times.
//     * Use File - Export Mesh to save the STL.
//
// If Meshlab can't fill the last hole then Blender might help:
//
//     * Start Blender
//     * `X, 1` to remove the default object
//     * File, Import, Stl
//     * `Tab` to edit the mesh
//     * `A` to de-select all vertices
//     * `Alt+Ctrl+Shift+M` to select all non-manifold vertices
//     * `MMB` to rotate, `Shift+MMB` to pan, `wheel` to zoom
//     * `C` for "circle" select, `Esc` to finish
//     * `Alt+M, 1` to merge or `Space` and search for "merge" as alternative
//     * Merging vertices is a useful way of filling holes where the vertices
//       are so closely packed that the slight change in geometry is unimportant
//       compared to the precision of a typical 3D printer
//
//
module import(file=None, convexity=1, layer=None){}

// DEPRECATED:
//     Will be removed in future releases. Use import() instead.
//
// Read a DXF file and create a 2D shape.
//
//     linear_extrude(height = 5, center = true, convexity = 10)
//             import_dxf(file = "example009.dxf", layer = "plate");
//
//
module import_dxf(){}

// DEPRECATED:
//     Will be removed in future releases. Use import() instead.
//
// Imports an STL file for use in the current OpenSCAD model.
//
//     import_stl("body.stl", convexity = 5);
//
//
module import_stl(){}
