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
// CHAPTER 12 – MODELING REAL SYSTEMS
// ===========================================================

/*
------------------------------------------------------------
Chapter 12: Modeling Real Systems
------------------------------------------------------------
Object-oriented programming is powerful because it allows you
to model real-world systems using classes. This chapter shows
how requirements from an assignment or specification translate
into well-designed classes.

This chapter prepares you for larger tasks such as Assignment 3
(Account, ChangeMachine, Wallet) by showing the core thinking
process — WITHOUT giving away solutions.

WHAT THIS CHAPTER COVERS:
• Turning requirements into classes
• Identifying fields and behaviours from descriptions
• Following UML as a design contract
• Thinking about object responsibilities
• A demonstration using a simplified vending model
------------------------------------------------------------
*/

class Chapter12_ModelingRealSystems {

    /*
    ------------------------------------------------------------
    1. CONCEPT — FROM REALITY TO CODE
    ------------------------------------------------------------
    Designing a class starts with two questions:

    • What information should this object remember?   (fields)
    • What actions should this object perform?        (methods)

    These questions create the foundation for modeling.

    Examples:
      • A Wallet remembers money and adds/removes amounts.
      • An Account remembers its balance and processes deposits.
      • A Date remembers day, month, and year and can validate itself.
      • A ChangeMachine remembers coins and calculates outputs.

    All systems follow the same pattern:
        Real idea → fields + behaviour → class
    ------------------------------------------------------------
    */

    /*
    ------------------------------------------------------------
    2. UML GUIDES THE STRUCTURE
    ------------------------------------------------------------
    In assignments and practice exercises, UML tells you:

      • exact field names
      • visibility (+ public, - private)
      • method names
      • required parameters
      • return types

    UML removes the guesswork.

    Your job is to convert the diagram into valid Java code
    following the rules learned in earlier chapters.
    ------------------------------------------------------------
    */


    // ------------------------------------------------------------
    // 3. LIVE DEMO – SIMPLE MODELING EXAMPLE (Vending Slot)
    // ------------------------------------------------------------

    static class Slot {

        private String productName;
        private int quantity;

        public Slot(String name, int qty) {
            if (qty >= 0) {
                productName = name;
                quantity = qty;
            }
        }

        public void dispense() {
            if (quantity > 0) {
                quantity--;
            }
        }

        public int getQuantity() {
            return quantity;
        }

        public String getProductName() {
            return productName;
        }
    }


    public static void liveDemo12() {

        System.out.println("LIVE DEMO 12: Modeling a Simple System");
        System.out.println("----------------------------------------");

        Slot s = new Slot("Chips", 3);

        System.out.println("Product: " + s.getProductName());
        System.out.println("Starting quantity: " + s.getQuantity());

        s.dispense();
        s.dispense();

        System.out.println("Remaining: " + s.getQuantity());

        System.out.println();
        System.out.println("Expected Output:");
        System.out.println("Product: Chips");
        System.out.println("Starting quantity: 3");
        System.out.println("Remaining: 1");
        System.out.println();

        System.out.println("Explanation:");
        System.out.println("This class models a vending machine slot using:");
        System.out.println("- private fields (productName, quantity)");
        System.out.println("- constructor initialization");
        System.out.println("- behaviour that updates state safely");
    }


    /*
    ------------------------------------------------------------
    4. EXTENSION DISCUSSION
    ------------------------------------------------------------
    Real systems require many interconnected classes. When
    building them:

      • Identify the responsibilities of each class
      • Keep each class focused on ONE purpose
      • Protect fields using private
      • Provide behaviour using methods
      • Follow UML carefully when provided

    Assignments such as Account and ChangeMachine follow exactly
    these principles — turning a real problem into structured,
    reliable code.
    ------------------------------------------------------------
    */


    /*
    ------------------------------------------------------------
    5. TRY THIS
    ------------------------------------------------------------
    1. Design a class Item with fields:
         - name
         - price

    2. Add methods to:
         - update the price safely
         - display the item

    3. Create several Item objects and print their properties.

    4. Think about how these Item objects could be used in a
       larger system such as an inventory or menu.
    ------------------------------------------------------------
    */


    public static void main(String[] args) {
        liveDemo12();
    }
}

