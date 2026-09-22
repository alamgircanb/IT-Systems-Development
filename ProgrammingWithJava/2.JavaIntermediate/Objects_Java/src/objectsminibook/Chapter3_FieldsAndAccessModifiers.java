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
// CHAPTER 3 – FIELDS AND ACCESS MODIFIERS
// ===========================================================

/*
------------------------------------------------------------
Chapter 3: Fields and Access Modifiers
------------------------------------------------------------
This chapter explains how objects store information internally
and how Java controls access to that information. Many learners
believe fields should always be public because it feels simpler.
However, this creates major problems as programs grow.

This chapter builds a clear, strong understanding of:
• What fields are
• Why fields should normally be private
• What “access modifiers” do
• How encapsulation protects object data
• A demonstration showing incorrect vs correct usage
------------------------------------------------------------
*/

class Chapter3_FieldsAndAccessModifiers {

    /*
    ------------------------------------------------------------
    1. CONCEPT — WHAT ARE FIELDS?
    ------------------------------------------------------------
    Fields are variables that belong to an object.  
    They represent the object’s **state**.

    Example fields for a House:
      • squareFootage
      • numberOfBedrooms
      • hasGarage

    Fields are the information each object stores separately.

    ------------------------------------------------------------
    WHY MAKING FIELDS PUBLIC IS A PROBLEM
    ------------------------------------------------------------
    If fields are public:
        anyone can change them
        anytime
        to anything

    This breaks the idea of controlled behaviour.

    Example of the problem:

        House h = new House();
        h.squareFootage = -500;   // invalid but allowed if public

    This creates objects with impossible or dangerous values.

    ------------------------------------------------------------
    PRIVATE FIELDS — THE SAFE DEFAULT
    ------------------------------------------------------------
    Fields should almost always be declared **private**.

    private:
      • hides the field from outside access
      • prevents accidental misuse
      • forces changes to happen through methods
      • allows validation before updating values

    This idea is called **encapsulation**:
      → internal details are protected and controlled
    ------------------------------------------------------------
    */


    // ------------------------------------------------------------
    // 2. LIVE DEMO – PRIVATE VS PUBLIC FIELDS
    // ------------------------------------------------------------

    static class HouseBad {

        // BAD DESIGN: fields are directly accessible
        public int squareFootage;
    }

    static class HouseGood {

        // GOOD DESIGN: fields are private
        private int squareFootage;

        public void setSquareFootage(int sqft) {
            if (sqft > 0) {
                squareFootage = sqft;
            }
        }

        public int getSquareFootage() {
            return squareFootage;
        }
    }


    public static void liveDemo3() {

        System.out.println("LIVE DEMO 3: Public vs Private Fields");
        System.out.println("--------------------------------------");

        // Bad version
        HouseBad h1 = new HouseBad();
        h1.squareFootage = -200;  // allowed but incorrect
        System.out.println("Bad house square footage: " + h1.squareFootage);

        // Good version
        HouseGood h2 = new HouseGood();
        h2.setSquareFootage(1200);   // valid
        h2.setSquareFootage(-500);   // ignored safely
        System.out.println("Good house square footage: " + h2.getSquareFootage());

        System.out.println();
        System.out.println("Expected Output:");
        System.out.println("Bad house square footage: -200");
        System.out.println("Good house square footage: 1200");
        System.out.println();

        System.out.println("Explanation:");
        System.out.println("Using private fields protects the object from invalid data.");
    }


    /*
    ------------------------------------------------------------
    3. EXTENSION DISCUSSION
    ------------------------------------------------------------
    Private fields allow a class to enforce rules. This makes
    objects reliable and prevents unexpected behaviour.

    For example, future versions of the House class might:
      • add a minimum allowed square footage
      • keep track of renovations
      • ensure values never move backwards unless allowed

    None of this is possible when fields are public. Using private
    fields combined with methods gives full control over how data
    enters the object and how it changes over time.
    ------------------------------------------------------------
    */


    /*
    ------------------------------------------------------------
    4. TRY THIS
    ------------------------------------------------------------
    1. Create a class called Student with private fields:
         - name
         - grade

    2. Add a method setGrade(int g) that only accepts values
       between 0 and 100.

    3. Create a Student object, set its grade, then print the
       stored value using a getGrade() method.
    ------------------------------------------------------------
    */


    public static void main(String[] args) {
        liveDemo3();
    }
}

