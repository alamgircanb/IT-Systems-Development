/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objectsminibook;

/**
 *
 * @author islammd
 */
// ===========================================================
// CHAPTER 5 – CONSTRUCTORS
// ===========================================================

/*
------------------------------------------------------------
Chapter 5: Constructors
------------------------------------------------------------
This chapter explains what constructors are, why they are
needed, how they differ from regular methods, and how they
help objects begin their life in a valid state.

Beginners often struggle with constructors because they look
like methods but behave differently. This chapter clears up
those misunderstandings step-by-step.

WHAT THIS CHAPTER COVERS:
• What a constructor does
• Default vs parameterized constructors
• How fields are initialized properly
• Why constructors have no return type
• A complete demonstration
------------------------------------------------------------
*/

class Chapter5_Constructors {

    /*
    ------------------------------------------------------------
    1. CONCEPT — WHAT IS A CONSTRUCTOR?
    ------------------------------------------------------------
    A constructor is a special piece of code that runs
    automatically when an object is created.

    Example:
        Circle c = new Circle(5);

    When Java sees “new Circle(5)”, it:
      • allocates memory
      • sets up the fields
      • calls the constructor to initialize the object

    ------------------------------------------------------------
    KEY CHARACTERISTICS OF CONSTRUCTORS
    ------------------------------------------------------------
    • They have the SAME NAME as the class.
    • They have NO return type (not even void).
    • They run automatically during object creation.
    • They are used to place the object in a valid initial state.

    ------------------------------------------------------------
    WHY CONSTRUCTORS MATTER
    ------------------------------------------------------------
    Without constructors, an object might begin its life with
    invalid or unfinished data.

    Example of a problem:
        Circle c = new Circle();
        c.radius = -10;   // invalid

    Constructors allow the class to enforce rules:
      • A circle must not start with a negative radius.
      • An employee must have an initial name.
      • An account must begin with a starting balance.

    Initialization becomes consistent, safe, and controlled.
    ------------------------------------------------------------
    */


    // ------------------------------------------------------------
    // 2. LIVE DEMO – DEFAULT AND PARAMETERIZED CONSTRUCTORS
    // ------------------------------------------------------------

    static class Circle {

        private double radius;

        // Default constructor
        public Circle() {
            radius = 1.0;   // safe default
        }

        // Parameterized constructor
        public Circle(double r) {
            if (r > 0) {
                radius = r;
            } else {
                radius = 1.0;
            }
        }

        public double getRadius() {
            return radius;
        }

        public double getArea() {
            return Math.PI * radius * radius;
        }
    }


    public static void liveDemo5() {

        System.out.println("LIVE DEMO 5: Constructors in Action");
        System.out.println("-----------------------------------");

        Circle c1 = new Circle();      // default constructor
        Circle c2 = new Circle(5.0);   // parameterized

        System.out.println("c1 radius: " + c1.getRadius());
        System.out.println("c2 radius: " + c2.getRadius());
        System.out.println("c2 area:   " + c2.getArea());

        System.out.println();
        System.out.println("Expected Output (approx):");
        System.out.println("c1 radius: 1.0");
        System.out.println("c2 radius: 5.0");
        System.out.println("c2 area:   78.53981633974483");
        System.out.println();

        System.out.println("Explanation:");
        System.out.println("The default constructor gives a safe starting radius.");
        System.out.println("The parameterized constructor allows custom initialization.");
    }


    /*
    ------------------------------------------------------------
    3. EXTENSION DISCUSSION
    ------------------------------------------------------------
    Constructors give classes flexibility. A class can offer:

      • A default state for simplicity
      • Multiple constructors for different needs
      • Validation to ensure proper initialization

    Over time, a class may grow to include:
      • a copy constructor
      • a constructor that builds from existing data
      • a constructor that reads configuration values

    Every version must guarantee that the object begins life in
    a valid, predictable state.
    ------------------------------------------------------------
    */


    /*
    ------------------------------------------------------------
    4. TRY THIS
    ------------------------------------------------------------
    1. Create a Rectangle class with private width and height.

    2. Add two constructors:
         - A default constructor that sets both to 1.0
         - A parameterized constructor that accepts width and height

    3. Create objects using both constructors and print their
       areas to confirm the initialization works correctly.
    ------------------------------------------------------------
    */


    public static void main(String[] args) {
        liveDemo5();
    }
}

