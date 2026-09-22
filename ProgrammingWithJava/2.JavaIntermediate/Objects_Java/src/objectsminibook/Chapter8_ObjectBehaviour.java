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
// CHAPTER 8 – OBJECT BEHAVIOUR (INSTANCE METHODS)
// ===========================================================

/*
------------------------------------------------------------
Chapter 8: Object Behaviour (Instance Methods)
------------------------------------------------------------
This chapter explains how objects perform actions. Methods
belonging to an object are called instance methods. These
methods use and modify the object's own fields.

Understanding behaviour is essential because objects are not
useful if they only store data—they need actions that reflect
their purpose in the program.

WHAT THIS CHAPTER COVERS:
• The role of instance methods
• How methods use the object's fields
• Behaviour that computes values (area, perimeter, etc.)
• Behaviour that changes state
• A demonstration using a Circle
------------------------------------------------------------
*/

class Chapter8_ObjectBehaviour {

    /*
    ------------------------------------------------------------
    1. CONCEPT — WHAT IS OBJECT BEHAVIOUR?
    ------------------------------------------------------------
    Behaviour is what an object can *do*.

    Each object method:
        • belongs to the class
        • uses the object's own fields
        • may change the object's internal state
        • may compute and return values

    Example:
        Circle c = new Circle(5);
        double a = c.getArea();   // behaviour

    The method getArea() uses the radius stored in that specific
    circle object.
    ------------------------------------------------------------
    */


    // ------------------------------------------------------------
    // 2. LIVE DEMO – BEHAVIOUR WITH CIRCLE OBJECT
    // ------------------------------------------------------------

    static class Circle {

        private double radius;

        public Circle(double r) {
            if (r > 0) {
                radius = r;
            }
        }

        public double getRadius() {
            return radius;
        }

        public void grow(double amount) {
            if (amount > 0) {
                radius += amount;
            }
        }

        public double getArea() {
            return Math.PI * radius * radius;
        }

        public double getCircumference() {
            return 2 * Math.PI * radius;
        }
    }


    public static void liveDemo8() {

        System.out.println("LIVE DEMO 8: Behaviour in Action");
        System.out.println("--------------------------------");

        Circle c = new Circle(3);

        System.out.println("Initial radius: " + c.getRadius());
        System.out.println("Area:           " + c.getArea());
        System.out.println("Circumference:  " + c.getCircumference());

        c.grow(2); // radius increased

        System.out.println("New radius:     " + c.getRadius());
        System.out.println("New area:       " + c.getArea());

        System.out.println();
        System.out.println("Expected Output (approx):");
        System.out.println("Initial radius: 3.0");
        System.out.println("Area:           28.274...");
        System.out.println("Circumference:  18.849...");
        System.out.println("New radius:     5.0");
        System.out.println("New area:       78.539...");
        System.out.println();

        System.out.println("Explanation:");
        System.out.println("Methods compute values using the object's fields,");
        System.out.println("and behaviour like grow() modifies those fields.");
    }


    /*
    ------------------------------------------------------------
    3. EXTENSION DISCUSSION
    ------------------------------------------------------------
    Behaviour makes objects useful. Without behaviour, an object
    is just a container for data. Behaviour can include:

      • computations (area, perimeter, salary, totals)
      • state changes (grow, shrink, deposit, withdraw)
      • validations (check input, enforce rules)
      • interactions between objects (compare values)

    As a class evolves, behaviour grows to capture everything
    the real-world concept should be able to do.
    ------------------------------------------------------------
    */


    /*
    ------------------------------------------------------------
    4. TRY THIS
    ------------------------------------------------------------
    1. Create a class Temperature with a private field celsius.

    2. Add methods:
         - convertToFahrenheit()
         - convertToKelvin()
         - raise(double amount)     // increases temperature
         - lower(double amount)     // decreases temperature

    3. Create a Temperature object and call all methods to verify
       each behaviour works correctly.
    ------------------------------------------------------------
    */


    public static void main(String[] args) {
        liveDemo8();
    }
}

