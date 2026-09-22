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
// CHAPTER 7 – GETTERS AND SETTERS
// ===========================================================

/*
------------------------------------------------------------
Chapter 7: Getters and Setters
------------------------------------------------------------
This chapter explains how classes safely expose their data
through controlled methods rather than public fields. Many
learners initially prefer using public fields because it feels
simpler, but doing so breaks encapsulation and allows invalid
values to enter the object.

Getters and setters fix this by providing a structured and
safe way to read and update object data.

WHAT THIS CHAPTER COVERS:
• Why direct field access is dangerous
• What getters and setters do
• How to apply validation in setters
• How getters expose values cleanly
• A complete demonstration using a Rectangle
------------------------------------------------------------
*/

class Chapter7_GettersAndSetters {

    /*
    ------------------------------------------------------------
    1. CONCEPT — WHY GETTERS AND SETTERS EXIST
    ------------------------------------------------------------
    Private fields protect the internal state of an object.
    However, objects still need controlled ways for the outside
    world to:

        • read values   → getters
        • update values → setters

    A setter's main job:
      -> validate data before storing it.

    A getter’s job:
      -> return the stored value without allowing direct access.

    Example:
        rectangle.width = -20;      // invalid if public
        rectangle.setWidth(-20);    // setter can reject it

    Setters enforce rules.
    Getters provide safe access.
    ------------------------------------------------------------
    */


    // ------------------------------------------------------------
    // 2. LIVE DEMO – RECTANGLE WITH VALIDATION
    // ------------------------------------------------------------

    static class Rectangle {

        private double width;
        private double height;

        public void setWidth(double w) {
            if (w > 0) {
                width = w;
            }
        }

        public void setHeight(double h) {
            if (h > 0) {
                height = h;
            }
        }

        public double getWidth()  { return width; }
        public double getHeight() { return height; }

        public double getArea() {
            return width * height;
        }
    }


    public static void liveDemo7() {

        System.out.println("LIVE DEMO 7: Using Getters and Setters");
        System.out.println("----------------------------------------");

        Rectangle r = new Rectangle();

        r.setWidth(4.5);
        r.setHeight(3.0);

        // Invalid height is ignored safely
        r.setHeight(-10);

        System.out.println("Width:  " + r.getWidth());
        System.out.println("Height: " + r.getHeight());
        System.out.println("Area:   " + r.getArea());

        System.out.println();
        System.out.println("Expected Output:");
        System.out.println("Width:  4.5");
        System.out.println("Height: 3.0");
        System.out.println("Area:   13.5");
        System.out.println();

        System.out.println("Explanation:");
        System.out.println("Setters allowed only valid values to be stored,");
        System.out.println("and getters provided clean access to the fields.");
    }


    /*
    ------------------------------------------------------------
    3. EXTENSION DISCUSSION
    ------------------------------------------------------------
    Getters and setters allow consistent decision-making inside
    the class.

    For example, a setter can:
      • round values
      • clamp values to a range
      • convert negative inputs to positive
      • trigger additional computations
      • track changes for logs or auditing

    A getter can:
      • compute values dynamically
      • return protected views of data
      • ensure the caller receives a safe, consistent output

    This separation of responsibility—fields are internal,
    getters/setters manage access—is a core part of clean design.
    ------------------------------------------------------------
    */


    /*
    ------------------------------------------------------------
    4. TRY THIS
    ------------------------------------------------------------
    1. Create a class called Student with private fields:
         - name
         - gpa

    2. Write setGpa(double value) so it accepts only values
       between 0.0 and 4.0, ignoring anything outside the range.

    3. Write getGpa() and a display method to show name and GPA.

    4. Create a Student object and test all methods.
    ------------------------------------------------------------
    */


    public static void main(String[] args) {
        liveDemo7();
    }
}
