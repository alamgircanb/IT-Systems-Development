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
// CHAPTER 6 – THE this KEYWORD
// ===========================================================

/*
------------------------------------------------------------
Chapter 6: The this Keyword
------------------------------------------------------------
The this keyword is one of the most misunderstood aspects of
Java for beginners. Many assume it is optional or decorative,
but it plays an important role in clarity and correctness.

This chapter explains the exact purpose of this, when it is
required, and how it improves program readability.

WHAT THIS CHAPTER COVERS:
• Why this exists
• How it distinguishes fields from parameters
• Using this() to call another constructor
• Demonstration showing naming conflicts
------------------------------------------------------------
*/

class Chapter6_ThisKeyword {

    /*
    ------------------------------------------------------------
    1. CONCEPT — WHAT DOES this MEAN?
    ------------------------------------------------------------
    this refers to the current object — the object that called
    the method.

    When writing:
        this.radius = radius;

    The left side refers to the object's field.
    The right side refers to the method's parameter.

    Without this, Java becomes confused when names overlap.

    ------------------------------------------------------------
    WHY NAME SHADOWING IS A PROBLEM
    ------------------------------------------------------------
    Consider:

        public void setRadius(double radius) {
            radius = radius;   // does nothing!
        }

    Both names refer to the parameter.  
    The field never receives the value.

    Using this fixes the issue:

        this.radius = radius;

    Now:
        • this.radius → field
        • radius      → parameter

    ------------------------------------------------------------
    ANOTHER USE: CALLING OTHER CONSTRUCTORS
    ------------------------------------------------------------
    Java allows a constructor to call another constructor
    inside the same class using:

        this(parameters)

    Example:
        public Circle() {
            this(1.0);   // call parameterized constructor
        }

    This avoids repeating initialization code.
    ------------------------------------------------------------
    */


    // ------------------------------------------------------------
    // 2. LIVE DEMO – USING this FOR CLARITY
    // ------------------------------------------------------------

    static class Circle {

        private double radius;

        public Circle(double radius) {
            this.radius = radius;   // fixes name shadowing
        }

        public double getRadius() {
            return radius;
        }
    }


    public static void liveDemo6() {

        System.out.println("LIVE DEMO 6: Understanding \"this\"");
        System.out.println("-----------------------------------");

        Circle c = new Circle(7.5);
        System.out.println("Circle radius: " + c.getRadius());

        System.out.println();
        System.out.println("Expected Output:");
        System.out.println("Circle radius: 7.5");
        System.out.println();

        System.out.println("Explanation:");
        System.out.println("this.radius refers to the object's field,");
        System.out.println("while radius refers to the parameter.");
    }


    /*
    ------------------------------------------------------------
    3. EXTENSION DISCUSSION
    ------------------------------------------------------------
    Using this makes the code easier to read and reduces errors.
    It becomes especially important when:

      • fields and parameters have the same name
      • constructors chain together
      • methods return the current object
      • large classes need clarity about which value is used

    Even when names do not overlap, many developers prefer to use
    this to make the relationship between fields and the object
    more explicit.
    ------------------------------------------------------------
    */


    /*
    ------------------------------------------------------------
    4. TRY THIS
    ------------------------------------------------------------
    1. Create a class called Book with fields title and pages.

    2. Write a constructor Book(String title, int pages) that
       uses this to assign both values.

    3. Create a Book object and print the fields to confirm the
       values were stored correctly.
    ------------------------------------------------------------
    */


    public static void main(String[] args) {
        liveDemo6();
    }
}

