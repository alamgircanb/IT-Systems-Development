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
// CHAPTER 4 – UML CLASS STRUCTURE
// ===========================================================

/*
------------------------------------------------------------
Chapter 4: UML Class Structure
------------------------------------------------------------
This chapter explains how UML (Unified Modeling Language)
diagrams represent classes. UML is not code — it is a visual
language used to describe the structure of a class clearly.

UML diagrams appear in Practice Exercise 3 and Assignment 3.
Understanding UML is essential for turning requirements into
working code.

What this chapter explains:
• The purpose of UML class diagrams
• How fields and methods appear in UML
• Visibility symbols (+, -)
• Mapping UML diagrams into Java code
• A demonstration converting UML to Java
------------------------------------------------------------
*/

class Chapter4_UMLClassStructure {

    /*
    ------------------------------------------------------------
    1. CONCEPT — WHAT IS UML?
    ------------------------------------------------------------
    UML is a standard way to describe the blueprint of a class.
    It tells you:

      • which fields the class must have
      • which methods belong to the class
      • whether each item is public or private

    UML does NOT show:
      • method bodies (code)
      • how the program runs
      • any Java syntax

    UML only describes structure.

    ------------------------------------------------------------
    UML CLASS BOX STRUCTURE
    ------------------------------------------------------------
    Every UML class diagram has three sections:

        +---------------------------+
        |  ClassName                |
        +---------------------------+
        |  fields (attributes)      |
        +---------------------------+
        |  methods (operations)     |
        +---------------------------+

    ------------------------------------------------------------
    VISIBILITY SYMBOLS
    ------------------------------------------------------------
    UML uses symbols to show access level:

        +   public
        -   private

    These symbols map directly to Java:
        + name : String     → public String name;
        - radius : double   → private double radius;
    ------------------------------------------------------------
    */


    // ------------------------------------------------------------
    // 2. LIVE DEMO – CONVERTING UML TO JAVA
    // ------------------------------------------------------------

    /*
        UML for Circle:

        +-------------------------+
        |        Circle           |
        +-------------------------+
        | - radius : double       |
        +-------------------------+
        | + setRadius(r: double)  |
        | + getRadius() : double  |
        | + getArea()  : double   |
        +-------------------------+
    */

    static class Circle {

        private double radius;

        public void setRadius(double r) {
            if (r > 0) {
                radius = r;
            }
        }

        public double getRadius() {
            return radius;
        }

        public double getArea() {
            return Math.PI * radius * radius;
        }
    }


    public static void liveDemo4() {

        System.out.println("LIVE DEMO 4: Converting UML to Java");
        System.out.println("------------------------------------");

        Circle c = new Circle();
        c.setRadius(5);

        System.out.println("Radius: " + c.getRadius());
        System.out.println("Area:   " + c.getArea());

        System.out.println();
        System.out.println("Expected Output (approx):");
        System.out.println("Radius: 5.0");
        System.out.println("Area:   78.53981633974483");
        System.out.println();

        System.out.println("Explanation:");
        System.out.println("The Java class follows the UML exactly:");
        System.out.println("- radius is private");
        System.out.println("- methods match the UML names and types");
    }


    /*
    ------------------------------------------------------------
    3. EXTENSION DISCUSSION
    ------------------------------------------------------------
    UML diagrams give a clear contract:  
    “Here is exactly what the class must contain.”

    When assignments or practice exercises include UML:
      • follow the diagram exactly
      • match field names
      • match method names
      • match visibility (+ or -)

    UML removes guessing. The design is already provided.
    ------------------------------------------------------------
    */


    /*
    ------------------------------------------------------------
    4. TRY THIS
    ------------------------------------------------------------
    1. Draw a UML diagram for a Rectangle class with fields:
         - width (private)
         - height (private)

    2. Add methods:
         - setWidth(w)
         - setHeight(h)
         - getArea()

    3. Convert your UML into a Java class and create one object
       to test all methods.
    ------------------------------------------------------------
    */


    public static void main(String[] args) {
        liveDemo4();
    }
}

