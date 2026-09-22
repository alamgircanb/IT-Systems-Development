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
// CHAPTER 11 – PASSING OBJECTS TO METHODS
// ===========================================================

/*
------------------------------------------------------------
Chapter 11: Passing Objects to Methods
------------------------------------------------------------
In Java, objects are often given to methods so the method can
inspect, compare, or modify the object. Understanding how this
works is critical for working with real systems where methods
manage multiple objects and transfer values between them.

WHAT THIS CHAPTER COVERS:
• What it means to pass an object to a method
• How Java passes object references
• How methods can modify object state
• Why this is different from passing primitive values
• A demonstration using Account objects
------------------------------------------------------------
*/

class Chapter11_PassingObjectsToMethods {

    /*
    ------------------------------------------------------------
    1. CONCEPT — HOW OBJECTS ARE PASSED TO METHODS
    ------------------------------------------------------------
    When you pass a primitive value (like int or double) to a
    method, Java passes a **copy** of the value.

    But when you pass an **object**, Java passes the **reference**.

    What this means:
      • The method receives a reference pointing to the same object.
      • If the method changes the object’s fields, the change stays.

    Diagram:

        Account a = new Account(100);
        doSomething(a);

        Inside doSomething:
              ↓
        same Account object in memory

    The method does NOT receive a copy of the object — only a copy
    of the reference (the address).
    ------------------------------------------------------------
    */

    // ------------------------------------------------------------
    // 2. LIVE DEMO – METHOD OPERATING ON OBJECT STATE
    // ------------------------------------------------------------

    static class Account {

        private double balance;

        public Account(double initial) {
            if (initial >= 0) balance = initial;
        }

        public double getBalance() {
            return balance;
        }

        public void deposit(double amount) {
            if (amount > 0) balance += amount;
        }
    }

    // Method that receives the object
    public static void bonusDeposit(Account a, double bonus) {
        if (bonus > 0) {
            a.deposit(bonus);
        }
    }

    public static void liveDemo11() {

        System.out.println("LIVE DEMO 11: Passing Objects to Methods");
        System.out.println("------------------------------------------");

        Account acc = new Account(300);
        System.out.println("Initial balance: " + acc.getBalance());

        bonusDeposit(acc, 50);
        System.out.println("After bonus:     " + acc.getBalance());

        System.out.println();
        System.out.println("Expected Output:");
        System.out.println("Initial balance: 300.0");
        System.out.println("After bonus:     350.0");
        System.out.println();

        System.out.println("Explanation:");
        System.out.println("The bonusDeposit() method changed the object passed to it.");
        System.out.println("This works because Java passes the reference, not a copy.");
    }


    /*
    ------------------------------------------------------------
    3. EXTENSION DISCUSSION
    ------------------------------------------------------------
    Passing objects allows methods to coordinate work between
    several objects. This becomes important for real-world tasks:

      • transferring money between accounts
      • comparing two shapes
      • checking if two dates match
      • updating multiple objects inside a manager class

    Larger systems depend heavily on this pattern. Understanding
    that methods receive a reference — and can modify the object —
    is crucial for writing correct behaviour.
    ------------------------------------------------------------
    */


    /*
    ------------------------------------------------------------
    4. TRY THIS
    ------------------------------------------------------------
    1. Create two Account objects with different starting balances.

    2. Write a method transfer(Account from, Account to, double amt)
       that:
         - withdraws amt from the first account
         - deposits amt into the second
         - ignores invalid transfers

    3. Test several valid and invalid transfers.
    ------------------------------------------------------------
    */


    public static void main(String[] args) {
        liveDemo11();
    }
}

