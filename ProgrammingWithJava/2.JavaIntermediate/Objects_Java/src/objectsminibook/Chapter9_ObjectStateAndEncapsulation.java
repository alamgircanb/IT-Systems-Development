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
// CHAPTER 9 – OBJECT STATE AND ENCAPSULATION
// ===========================================================

/*
------------------------------------------------------------
Chapter 9: Object State and Encapsulation
------------------------------------------------------------
Up to this point, we have seen that an object stores values
(fields) and provides behaviour (methods). This chapter focuses
on how an object protects its state through encapsulation.

Encapsulation is one of the core pillars of object-oriented
programming. It ensures that an object controls how its internal
data changes over time.

WHAT THIS CHAPTER COVERS:
• What "state" means in an object
• Why encapsulation is necessary
• How objects protect and validate their data
• How behaviour manages state changes
• A complete demonstration using an Account
------------------------------------------------------------
*/

class Chapter9_ObjectStateAndEncapsulation {

    /*
    ------------------------------------------------------------
    1. CONCEPT — WHAT IS OBJECT STATE?
    ------------------------------------------------------------
    An object's state is the collection of values stored in its
    fields at any given moment.

    Examples of object state:
      • A BankAccount’s balance
      • A Student’s GPA and name
      • A Circle’s radius
      • A Temperature’s current value

    Every object carries its state with it.

    ------------------------------------------------------------
    WHY STATE MUST BE PROTECTED
    ------------------------------------------------------------
    If fields are left unprotected:

        account.balance = -99999;
        rectangle.width = -20;

    the object becomes invalid or unpredictable.

    To prevent this, classes:
      • keep fields private
      • use methods to manage changes
      • validate updates before applying them

    This protection is called **encapsulation**.
    ------------------------------------------------------------
    */


    // ------------------------------------------------------------
    // 2. LIVE DEMO – ENCAPSULATION WITH AN ACCOUNT
    // ------------------------------------------------------------

    static class Account {

        private double balance;

        public Account(double initialBalance) {
            if (initialBalance >= 0) {
                balance = initialBalance;
            }
        }

        public double getBalance() {
            return balance;
        }

        public void deposit(double amount) {
            if (amount > 0) {
                balance += amount;
            }
        }

        public void withdraw(double amount) {
            if (amount > 0 && amount <= balance) {
                balance -= amount;
            }
        }
    }


    public static void liveDemo9() {

        System.out.println("LIVE DEMO 9: Account Encapsulation Example");
        System.out.println("-------------------------------------------");

        Account a = new Account(500);

        System.out.println("Starting balance: " + a.getBalance());

        a.deposit(200);
        System.out.println("After deposit:    " + a.getBalance());

        a.withdraw(100);
        System.out.println("After withdrawal: " + a.getBalance());

        a.withdraw(1000);   // invalid, ignored safely
        System.out.println("After invalid withdrawal: " + a.getBalance());

        System.out.println();
        System.out.println("Expected Output:");
        System.out.println("Starting balance: 500.0");
        System.out.println("After deposit:    700.0");
        System.out.println("After withdrawal: 600.0");
        System.out.println("After invalid withdrawal: 600.0");
        System.out.println();

        System.out.println("Explanation:");
        System.out.println("The object controls its state. Invalid updates are ignored.");
    }


    /*
    ------------------------------------------------------------
    3. EXTENSION DISCUSSION
    ------------------------------------------------------------
    Encapsulation gives the class the ability to enforce all rules
    related to its data. It prevents outside code from making
    changes the class does not approve.

    For example:
      • An account should never go negative.
      • A rectangle cannot have negative dimensions.
      • A date must represent a valid calendar day.
      • An employee’s salary must stay within limits.

    When rules change in the future, the class updates its methods
    without affecting the code that uses the object. This keeps
    programs stable as they grow.
    ------------------------------------------------------------
    */


    /*
    ------------------------------------------------------------
    4. TRY THIS
    ------------------------------------------------------------
    1. Create a class called Wallet with a private balance.

    2. Provide methods:
         - addMoney(double amount)
         - removeMoney(double amount)
         - getBalance()

    3. Ensure removeMoney(...) does not allow the balance to
       become negative.

    4. Create a Wallet object and test all behaviours.
    ------------------------------------------------------------
    */


    public static void main(String[] args) {
        liveDemo9();
    }
}

