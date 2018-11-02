
// Mathematical cosine function of degrees.
//
// Parameters:
//
// <degrees>
//     Decimal. Angle in degrees.
//
// Usage example:
//
// for(i=[0:36])
//     translate([i*10,0,0])
//        cylinder(r=5,h=cos(i*10)*50+60);
//
//
function cos(degrees) = cos(degrees);

// Mathematical sine function of degrees.
//
// Parameters:
//
// <degrees>
//     Decimal. Angle in degrees.
//
// Usage example 1:
//
// for (i = [0:5]) {
//   echo(360*i/6, sin(360*i/6)*80, cos(360*i/6)*80);
//   translate([sin(360*i/6)*80, cos(360*i/6)*80, 0 ])
//     cylinder(h = 200, r=10);
// }
//
// Usage example 2:
//
//  for(i=[0:36])
//     translate([i*10,0,0])
//        cylinder(r=5,h=sin(i*10)*50+60);
//
//
function sin(degrees) = sin(degrees);

// Mathematical tangent function of degrees.
//
// Parameters:
//
// <degrees>
//     Decimal. Angle in degrees.
//
// Usage example:
//
// for (i = [0:5]) {
//   echo(360*i/6, tan(360*i/6)*80);
//   translate([tan(360*i/6)*80, 0, 0 ])
//     cylinder(h = 200, r=10);
// }
//
//
function tan(degrees) = tan(degrees);

// Mathematical arccosine, or inverse cosine, expressed in degrees.
//
// Parameters:
//
// <x>
//     Decimal cosine in the interval [-1, 1].
//
// Returns:
//     inverse cosine of x expressed in degrees
//
//
function acos(x) = acos(x);

// Mathematical arcsine, or inverse sine, expressed in degrees.
//
// Parameters:
//
// <x>
//     Decimal sine in the interval [-1, 1].
//
// Returns:
//     inverse sine of x expressed in degrees
//
//
function asin(x) = asin(x);

// Mathematical arctangent, or inverse tangent, expressed in degrees.
//
// Parameters:
//
// <x>
//     Decimal tangent to be inversed.
//
// Returns:
//     principal value of the arc tangent of x, expressed in degrees
//
//
function atan(x) = atan(x);

// Mathematical two-argument atan function, taking y as its first argument.
//
// Parameters:
//
// <y>
//     opposite side length
// <x>
//     adjacent side length
//
// Returns:
//     principal value of the arc tangent of y/x, expressed in degrees
//
//
function atan2(y, x) = atan2(y, x);


// Mathematical absolute value function.
//
// Parameters:
//
// <x>
//     Signed decimal number.
//
// Returns:
//     positive value of a signed decimal number
//
// Usage examples:
//
//   abs(-5.0);
//   abs(0);
//   abs(8.0);
//
// Results:
//
//   5.0
//   0.0
//   8.0
//
//
function abs(x) = abs(x);

// Mathematical ceiling function.
//
// Parameters:
//
// <x>
//     Signed decimal number.
//
// Returns:
//     next highest integer value by rounding up value if necessary
//
// Usage example:
//
//   echo(ceil(4.4),ceil(-4.4));
//
// Result:
//
//   ECHO: 5, -4
//
//
function ceil(x) = ceil(x);

// [Note: Requires version 2015.03]
//
// Return a vector containing the arguments.
// Where an argument is a vector the elements of the
// vector are individually added to the result vector.
// Strings are distinct from vectors in this case.
//
// Parameters:
//
// <value1>, <value2>, ...
//     Any number of values of any type.
//
// Returns:
//     vector containing the arguments
//
// Usage examples:
//
//   echo(concat("a","b","c","d","e","f"));      // produces ECHO: ["a", "b", "c", "d", "e", "f"]
//   echo(concat(["a","b","c"],["d","e","f"]));  // produces ECHO: ["a", "b", "c", "d", "e", "f"]
//   echo(concat(1,2,3,4,5,6));                  // produces ECHO: [1, 2, 3, 4, 5, 6]
//
// Vector of vectors:
//
//   echo(concat([ [1],[2] ], [ [3] ]));         // produces ECHO: [[1], [2], [3]]
//
// Contrast with strings:
//
//   echo(concat([1,2,3],[4,5,6]));              // produces ECHO: [1, 2, 3, 4, 5, 6]
//   echo(concat("abc","def"));                  // produces ECHO: ["abc", "def"]
//   echo(str("abc","def"));                     // produces ECHO: "abcdef"
//
//
function concat(values) = concat(values);

// Calculates the cross product of two vectors in 3D space.
//
// Using invalid input parameters (e.g. vectors with a length different from
// 3 or other types) will produce an undefined result.
//
// Parameters:
//
// <v1>, <v2>
//     3D vectors.
//
// Returns:
//     a vector that is perpendicular to both of the input vectors
//
// Usage examples:
//
//    echo(cross([2, 3, 4], [5, 6, 7]));   // produces ECHO: [-3, 6, -3]
//    echo(cross([2, 1, -3], [0, 4, 5]));  // produces ECHO: [17, -10, 8]
//    echo(cross([2, 3, 4], "5"));         // produces ECHO: undef
//
//
function cross(v1, v2) = cross(v1, v2);

// Mathematical exp function.
//
// Parameters:
//
// <x>
//     Signed decimal number.
//
// Returns:
//     base-e exponential function of x, which is the number e raised to the power x
//
// Usage example:
//
//    echo(exp(1),exp(ln(3)*4));  // produces ECHO: 2.71828, 81
//
//
function exp(x) = exp(x);

// Mathematical floor function.
//
// Parameters:
//
// <x>
//     Signed decimal number.
//
// Returns:
//     largest integer not greater than x
//
// Usage example:
//
//    echo(floor(4.4),floor(-4.4));  // produces ECHO: 4, -5
//
//
function floor(x) = floor(x);

// Mathematical natural logarithm.
//
// Parameters:
//
// <x>
//     Positive decimal number.
//
// Returns:
//     base-e (natural) logarithm of x
//
// Usage example:
//
//    echo(ln(4.4),ln(-4.4),ln(0));  // produces ECHO: 1.486, nan, -inf
//
//
function ln(x) = ln(x);

// Mathematical length function.
//
// Parameters:
//
// <value>
//     A vector, array or string value.
//
// Returns:
//     length of an array, a vector or a string parameter
//
// Usage examples:
//
//   str1="abcdef"; len_str1=len(str1);
//   echo(str1,len_str1);
//
//   a=6; len_a=len(a);
//   echo(a,len_a);
//
//   array1=[1,2,3,4,5,6,7,8]; len_array1=len(array1);
//   echo(array1,len_array1);
//
//   array2=[[0,0],[0,1],[1,0],[1,1]]; len_array2=len(array2);
//   echo(array2,len_array2);
//
//   len_array2_2=len(array2[2]);
//   echo(array2[2],len_array2_2);
//
// Results:
//
//   ECHO: "abcdef", 6
//   ECHO: 6, undef
//   ECHO: [1, 2, 3, 4, 5, 6, 7, 8], 8
//   ECHO: [[0, 0], [0, 1], [1, 0], [1, 1]], 4
//   ECHO: [1, 0], 2
//
// This function allows (e.g.) the parsing of an array, a vector or a string.
//
// Usage examples:
//
//   str2="4711";
//   for (i=[0:len(str2)-1])
//	     echo(str("digit ",i+1,"  :  ",str2[i]));
//
// Results:
//
//   ECHO: "digit 1  :  4"
//   ECHO: "digit 2  :  7"
//   ECHO: "digit 3  :  1"
//   ECHO: "digit 4  :  1"
//
// Note that the len() function is not defined when a simple variable is passed
// as the parameter.
//
// This is useful when handling parameters to a module, similar to how shapes can be
// defined as a single number, or as an [x,y,z] vector; i.e. cube(5) or cube([5,5,5])
//
// For example:
//
//   module doIt(size) {
//	   if (len(size) == undef) {
//		 // size is a number, use it for x,y & z. (or could be undef)
//		 do([size,size,size]);
//	   } else {
//		 // size is a vector, (could be a string but that would be stupid)
//		 do(size);
//	   }
//   }
//
//   doIt(5);	// equivalent to [5,5,5]
//   doIt([5,5,5]);	// similar to cube(5) v's cube([5,5,5])
//
//
function len(value) = len(value);

// Mathematical logarithm to the base 10.
//
// Parameters:
//
// <x>
//     Positive decimal number.
//
// Returns:
//     base-10 logarithm of x
//
// Usage example:
//
//    log(1000) = 3
//
//
function log(x) = log(x);

// Look up value in table, and linearly interpolate if there's no exact match.
// The first argument is the key to look up the value for. The second is the
// lookup table (a vector of key-value pairs).
//
// Parameters:
//
// key
//     A lookup key
//
// lookup_table
//     <key, value> array
//
// Returns:
//     interpolated value based on the given key and lookup table
//
// Notes:
//     There is a bug where out-of-range keys will return the first value in the list.
//     Newer versions of Openscad should use the top or bottom end of the table as
//     appropriate instead.
//
// Usage example:
//
//    Will create a sort of 3D chart made out of cylinders of different height.
//
//    function get_cylinder_h(p) = lookup(p, [
//      [ -200, 5 ],
//      [ -50, 20 ],
//      [ -20, 18 ],
//      [ +80, 25 ],
//      [ +150, 2 ]
//    ]);
//
//    for (i = [-100:5:+100]) {
//      // echo(i, get_cylinder_h(i));
//      translate([ i, 0, -30 ]) cylinder(r1 = 6, r2 = 2, h = get_cylinder_h(i)*3);
//    }
//
//
function lookup(key, lookup_table) = lookup(key, lookup_table);

// Returns the maximum of the parameters. If a single vector is given as parameter,
// returns the maximum element of that vector (requires OpenSCAD version 2014.06 or later).
//
// Parameters:
//
// <values>
//     Two or more decimals, or a vector of decimals (requires OpenSCAD version 2014.06 or later).
//
// Returns:
//     maximum of the parameters, or the the maximum element of a vector
//
// Usage examples:
//
//     max(3.0, 5.0)
//     max(8.0, 3.0, 4.0, 5.0)
//     max([8, 3, 4, 5])
//
// Results:
//
//     5
//     8
//     8
//
//
function max(values) = max(values);

// Returns the minimum of the parameters. If a single vector is given as parameter,
// returns the minimum element of that vector (requires OpenSCAD version 2014.06 or later).
//
// Parameters:
//
// <values>
//     Two or more decimals, or a vector of decimals (requires OpenSCAD version 2014.06 or later).
//
// Returns:
//     maximum of the parameters, or the the maximum element of a vector
//
// Usage examples:
//
//     max(3.0, 5.0)
//     max(8.0, 3.0, 4.0, 5.0)
//     max([8, 3, 4, 5])
//
// Results:
//
//     3
//     3
//     3
//
//
function min(values) = min(values);

// Returns the euclidean norm of a vector. Note this returns the actual numeric
// length while len returns the number of elements in the vector or array.
//
// Parameters:
//
// <vector>
//     Vector of any number of elements.
//
// Returns:
//     euclidian norm of the vector
//
// Usage examples:
//
//     a = [1, 2, 3, 4];
//     b = "abcd";
//     c = [];
//     d = "";
//     e = [[1, 2, 3, 4], [1, 2, 3], [1, 2], [1]];
//     echo(norm(a));     // 5.47723
//     echo(norm(b));     // undef
//     echo(norm(c));     // 0
//     echo(norm(d));     // undef
//     echo(norm(e[0]));  // 5.47723
//     echo(norm(e[1]));  // 3.74166
//     echo(norm(e[2]));  // 2.23607
//     echo(norm(e[3]));  // 1
//
//
function norm(vector) = norm(vector);

// Mathematical power function.
//
// Parameters:
//
// <base>
//     Decimal base.
// <exponent>
//     Decimal exponent.
//
// Returns:
//     base^exponent
//
// Usage examples:
//
//     for (i = [0:5]) {
//       translate([i*25,0,0]) {
//         cylinder(h = pow(2,i)*5, r=10);
//         echo (i, pow(2,i));
//       }
//     }
//
//     echo(pow(10,2)); // means 10^2 or 10*10
//     // result: ECHO: 100
//
//     echo(pow(10,3)); // means 10^3 or 10*10*10
//     // result: ECHO: 1000
//
//     echo(pow(125,1/3)); // means 125^(0.333...) which equals calculating the cube root of 125
//     // result: ECHO: 5
//
//
function pow(base, exponent) = pow(base, exponent);

// Random number generator. Generates a constant vector of pseudo random numbers,
// much like an array. The numbers are doubles not integers. When generating only
// one number, you still call it with variable[0]
//
// Parameters:
//
// min_value
//     Minimum value of random number range
//
// max_value
//     Maximum value of random number range
//
// value_count
//     Number of random numbers to return as a vector
//
// seed_value (optional)
//     Seed value for random number generator for repeatable results. On versions
//     before late 2015, seed_value gets rounded to the nearest integer
//
// Returns:
//     Constant vector of pseudo random numbers
//
// Usage examples:
//
//      // get a single number
//      single_rand = rands(0,10,1)[0];
//      echo(single_rand);
//
//      // get a vector of 4 numbers
//      seed=42;
//      random_vect=rands(5,15,4,seed);
//      echo( "Random Vector: ",random_vect);
//      sphere(r=5);
//      for(i=[0:3]) {
//        rotate(360*i/4) {
//          translate([10+random_vect[i],0,0])
//            sphere(r=random_vect[i]/2);
//        }
//      }
//      // ECHO: "Random Vector: ", [8.7454, 12.9654, 14.5071, 6.83435]
//
//
function rands(min_value, max_value, value_count, seed_value) = rands(min_value, max_value, value_count, seed_value);

// Returns the greatest or least integer part, respectively, if the numeric input is positive or negative.
//
// Parameters:
//
// <x>
//     Signed decimal value.
//
// Returns:
//     greatest or least integer part, respectively, if the numeric input is positive or negative
//
// Usage examples:
//
//     round(x.5) = x+1.
//
//     round(x.49) = x.
//
//     round(-(x.5)) = -(x+1).
//
//     round(-(x.49)) = -x.
//
//
//     round(5.4); //-> 5
//
//     round(5.5); //-> 6
//
//     round(5.6); //-> 6
//
//
function round(x) = round(x);

// Mathematical signum function.
//
// Parameters:
//
// <x>
//     Signed decimal value.
//
// Returns:
//     unit value that extracts the sign of x
//
// Usage examples:
//
//     sign(-5.0);
//     sign(0);
//     sign(8.0);
//
// Results:
//
//     -1.0
//     0.0
//     1.0
//
//
function sign(x) = sign(x);

// Mathematical square root function.
//
// Parameters:
//
// <x>
//     Positive decimal value.
//
// Returns:
//     square root of x
//
// Usage examples:
//
//     translate([sqrt(100),0,0])sphere(100);
//
//
function sqrt(x) = sqrt(x);

// Convert all arguments to strings and concatenate.
//
// Parameters:
//
// <values>
//     Any number of values of any type.
//
// Returns:
//     string result of concatenating the given values
//
// Usage examples:
//
//     number=2;
//     echo ("This is ",number,3," and that's it.");
//     echo (str("This is ",number,3," and that's it."));
//
// Results:
//
//     ECHO: "This is ", 2, 3, " and that's it."
//     ECHO: "This is 23 and that's it."
//
//
function str(values) = str(values);

// [Note: Requires version 2015.03]
//
// Convert numbers to a string containing character with the corresponding code.
// OpenSCAD uses Unicode, so the number is interpreted as Unicode code point.
// Numbers outside the valid code point range will produce an empty string.
//
// Parameters:
//
// chr(Number)
//     Convert one code point to a string of length 1 (number of
//     bytes depending on UTF-8 encoding) if the code point is valid.
//
// chr(Vector)
//     Convert all code points given in the argument vector to a string.
//
// chr(Range)
//     Convert all code points produced by the range argument to a string.
//
// Returns:
//     string result of converting the code point(s) to characters
//
// Usage examples:
//
//     echo(chr(65), chr(97));      // ECHO: "A", "a"
//     echo(chr(65, 97));           // ECHO: "Aa"
//     echo(chr([66, 98]));         // ECHO: "Bb"
//     echo(chr([97 : 2 : 102]));   // ECHO: "ace"
//     echo(chr(-3));               // ECHO: ""
//     echo(chr(9786), chr(9788));  // ECHO: "☺", "☼"
//     echo(len(chr(9788)));        // ECHO: 1
//
// Note:
//     When used with echo() the output to the console for character
//     codes greater than 127 is platform dependent.
//
//
function chr(value) = chr(value);

// The search() function is a general-purpose function to find one or more
// (or all) occurrences of a value or list of values in a vector, string or
// more complex list-of-list construct.
//
// Usage
//     search( match_value , string_or_vector [, num_returns_per_match [, index_col_num ] ] );
//
// Parameters:
//
// match_value
//     Can be a single value or vector of values.
//     Strings are treated as vectors-of-characters to iterate over;
//     the search function does not search for substrings.
//     Note:
//         If match_value is a vector of strings, search will look
//         for exact string matches. See Example 9 below.
//
// string_or_vector
//     The string or vector to search for matches.
//
// num_returns_per_match (default: 1)
//     By default, search only looks for one match per element of match_value
//     to return as a list of indices.
//     If num_returns_per_match > 1, search returns a list of lists of up to
//     num_returns_per_match index values for each element of match_value.
//     See Example 8 below.
//     If num_returns_per_match = 0, search returns a list of lists of all
//     matching index values for each element of match_value.
//     See Example 6 below.
//
// index_col_num (default: 0)
//
//     When string_or_vector is a vector-of-vectors, multidimensional table or
//     more complex list-of-lists construct, the match_value may not be found
//     in the first (index_col_num = 0) column.
//     See Example 5 below for a simple usage example.
//
// Returns:
//     vector of search results
//
// See example023.scad included with OpenSCAD for a renderable example.
//
// Example 1:
//     search("a","abcdabcd"); -> [0]
//
// Example 2:
//     search("e","abcdabcd"); -> []
//
// Example 3:
//     search("a","abcdabcd",0); -> [[0, 4]]
//
// Example 4:
//     data=[ ["a",1],["b",2],["c",3],["d",4],["a",5],["b",6],["c",7],["d",8],["e",9] ];
//     search("a", data, num_returns_per_match=0); -> [[0, 4]] (see also Example 6 below)
//
// Example 5:
//     //Search on different column; return Index values
//     data= [ ["a",1],["b",2],["c",3],["d",4],["a",5],["b",6],["c",7],["d",8],["e",3] ];
//     search(3, data, num_returns_per_match=0, index_col_num=1);
// Returns:
//     [2, 8]
//
// Example 6:
//     // Search on list of values, return all matches per search vector element.
//     data= [ ["a",1],["b",2],["c",3],["d",4],["a",5],["b",6],["c",7],["d",8],["e",9] ];
//     search("abc", data, num_returns_per_match=0);
// Returns:
//     [[0, 4], [1, 5], [2, 6]]
//
// Example 7:
//     // Search on list of values, return first match per search vector element;
//     // special case return vector.
//     data = [ ["a",1],["b",2],["c",3],["d",4],["a",5],["b",6],["c",7],["d",8],["e",9] ];
//     search("abc", data, num_returns_per_match=1);
// Returns:
//     [0, 1, 2]
//
// Example 8:
//     // Search on list of values, return first two matches per search vector element;
//     // vector of vectors.
//     data= [ ["a",1],["b",2],["c",3],["d",4],["a",5],["b",6],["c",7],["d",8],["e",9] ];
//     search("abce", data, num_returns_per_match=2);
// Returns:
//     [[0, 4], [1, 5], [2, 6], [8]]
//
// Example 9:
//     // Search on list of strings
//     lTable2=[ ["cat",1],["b",2],["c",3],["dog",4],["a",5],["b",6],["c",7],["d",8],["e",9],["apple",10],["a",11] ];
//     lSearch2=["b","zzz","a","c","apple","dog"];
//     l2=search(lSearch2,lTable2);
//     echo(str("Default list string search (",lSearch2,"): ",l2));
// Returns
//     ECHO: "Default list string search (["b", "zzz", "a", "c", "apple", "dog"]): [1, [], 4, 2, 9, 3]"
//
// Getting the right results
//     // workout which vectors get the results
//     v=[ ["O",2],["p",3],["e",9],["n",4],["S",5],["C",6],["A",7],["D",8] ];
//     //
//     echo(v[0]);                        // -> ["O",2]
//     echo(v[1]);                        // -> ["p",3]
//     echo(v[1][0],v[1][1]);             // -> "p",3
//     echo(search("p",v));               // find "p" -> [1]
//     echo(search("p",v)[0]);            // -> 1
//     echo(search(9,v,0,1));             // find  9  -> [2]
//     echo(v[search(9,v,0,1)[0]]);       // -> ["e",9]
//     echo(v[search(9,v,0,1)[0]][0]);    // -> "e"
//     echo(v[search(9,v,0,1)[0]][1]);    // -> 9
//     echo(v[search("p",v,1,0)[0]][1]);  // -> 3
//     echo(v[search("p",v,1,0)[0]][0]);  // -> "p"
//     echo(v[search("d",v,1,0)[0]][0]);  // "d" not found -> undef
//     echo(v[search("D",v,1,0)[0]][1]);  // -> 8
//
//
function search(match_value , string_or_vector, num_returns_per_match, index_col_num) = search(match_value , string_or_vector, num_returns_per_match, index_col_num);

// OpenSCAD version number.
//
// Returns:
//     OpenSCAD version as a vector, e.g. [2011, 09, 23]
//
//
function version() = version();

// OpenSCAD version number.
//
// Returns:
//     OpenSCAD version as a number, e.g. 20110923
//
//
function version_num() = version_num();

// $parent_modules contains the number of modules in the instantiation stack.
// parent_module(i) returns the name of the module i levels above the current
// module in the instantiation stack. The stack is independent of where the
// modules are defined. It's where they're instantiated that counts. This can
// be used to e.g. build BOMs.
//
// Parameters:
//
// <i>
//     number of levels to go up the instantiation stack.
//
// Example:
//
//     module top() {
//       children();
//     }
//     module middle() {
//       children();
//     }
//     top() middle() echo(parent_module(0));  // prints "middle"
//     top() middle() echo(parent_module(1));  // prints "top"
//
//
function parent_module(i) = parent_module(i);
