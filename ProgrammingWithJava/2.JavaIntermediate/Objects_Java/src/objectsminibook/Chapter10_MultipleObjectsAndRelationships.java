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
// CHAPTER 10 – MULTIPLE OBJECTS AND RELATIONSHIPS
// ===========================================================

/*
------------------------------------------------------------
Chapter 10: Multiple Objects and Relationships
------------------------------------------------------------
Most programs create not just one object, but many. A system
may manage dozens of students, hundreds of accounts, or
thousands of shapes. This chapter explains how multiple objects
co-exist and how they relate to each other.

WHAT THIS CHAPTER COVERS:
• Creating several objects from the same class
• Objects with different states
• Comparing objects using behaviour
• Basic object-to-object relationships
• Demonstration with multiple Rectangles
------------------------------------------------------------
*/

class Chapter10_MultipleObjectsAndRelationships {

    /*
    ------------------------------------------------------------
    1. CONCEPT — MULTIPLE OBJECTS FROM ONE CLASS
    ------------------------------------------------------------
    A class is a blueprint.  
    You can create as many objects as needed from it.

    Example:
        Rectangle r1 = new Rectangle();
        Rectangle r2 = new Rectangle();

    Each object has:
      • its own state
      • its own memory
      • its own behaviour
    ------------------------------------------------------------
    WHY THIS MATTERS
    ------------------------------------------------------------
    Real-world programs constantly work with many objects:

      • many customers
      • many transactions
      • many products
      • many game characters

    Each object represents its own meaningful unit.
    ------------------------------------------------------------
    */


    // ------------------------------------------------------------
    // 2. LIVE DEMO – MULTIPLE RECTANGLES
    // ------------------------------------------------------------

    static class Rectangle {

        private double width;
        private double height;

        public Rectangle(double w, double h) {
            if (w > 0 && h > 0) {
                width = w;
                height = h;
            }
        }

        public double getArea() {
            return width * height;
        }
    }


    public static void liveDemo10() {

        System.out.println("LIVE DEMO 10: Working with Multiple Objects");
        System.out.println("--------------------------------------------");

        Rectangle r1 = new Rectangle(4, 8);
        Rectangle r2 = new Rectangle(6, 3);
        Rectangle r3 = new Rectangle(10, 2);

        System.out.println("Area r1: " + r1.getArea());
        System.out.println("Area r2: " + r2.getArea());
        System.out.println("Area r3: " + r3.getArea());

        System.out.println();
        System.out.println("Expected Output:");
        System.out.println("Area r1: 32.0");
        System.out.println("Area r2: 18.0");
        System.out.println("Area r3: 20.0");
        System.out.println();

        System.out.println("Explanation:");
        System.out.println("Each Rectangle object has different dimensions and stores");
        System.out.println("its own state. Behaviour uses those stored values.");
    }


    /*
    ------------------------------------------------------------
    3. EXTENSION DISCUSSION
    ------------------------------------------------------------
    Once you have multiple objects, you can compare them or build
    relationships between them.

    Examples:
      • Compare which Rectangle has the larger area.
      • Compare two Students by GPA.
      • Compare two Accounts by balance.
      • Build a Team containing multiple Player objects.

    Relationships help build more advanced systems, such as:
      • a bank with many accounts
      • a store with many products
      • a graphics program with many shapes

    Understanding multiple objects is essential for real projects.
    ------------------------------------------------------------
    */


    /*
    ------------------------------------------------------------
    4. TRY THIS
    ------------------------------------------------------------
    1. Create a class Box with width, height, and depth.

    2. Add a method getVolume() that computes width * height * depth.

    3. Create three Box objects with different sizes.

    4. Print their volumes and determine which Box has the largest
       volume by comparing them manually using the results.
    ------------------------------------------------------------
    */


    public static void main(String[] args) {
        liveDemo10();
    }
}

