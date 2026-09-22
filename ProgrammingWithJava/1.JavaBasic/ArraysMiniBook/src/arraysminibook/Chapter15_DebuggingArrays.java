/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arraysminibook;

/**
 *
 * @author islammd
 */



// ==============================
// CHAPTER 15 – DEBUGGING ARRAYS
// ==============================

/*
----------------------------------------
Chapter 15: Debugging Arrays
----------------------------------------

WHAT THIS CHAPTER COVERS:
• Common array-related runtime errors
• Step-by-step reasoning during troubleshooting
• Live Demos: off-by-one error and uninitialized access
----------------------------------------
*/

class Chapter15_DebuggingArrays {

    /*
    ----------------------------------------
    CONCEPT:
    ----------------------------------------
    When working with arrays, the two most common sources of bugs are:

      1. **Index Errors**
         - Accessing an invalid index (negative or beyond length-1)

      2. **Uninitialized Arrays**
         - Declaring an array reference but never allocating memory.

    Debugging means tracing the program’s behavior
    until we identify where the logic deviates from intention.
    ----------------------------------------
    */

    // ----------------------------------------
    // LIVE DEMO 22: ArrayIndexOutOfBoundsException
    // ----------------------------------------

    public static void liveDemo22() {

        System.out.println("LIVE DEMO 22: Demonstrating Index Error");
        System.out.println("----------------------------------------");

        int[] numbers = { 1, 2, 3, 4, 5 };

        try {
            for (int i = 0; i <= numbers.length; i++) { // ❌ intentional error
                System.out.println("numbers[" + i + "] = " + numbers[i]);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ERROR: Tried to access invalid index!");
            System.out.println("Valid indices: 0 to " + (numbers.length - 1));
        }

        System.out.println();
        System.out.println("Expected Output:");
        System.out.println("numbers[0] = 1 ... numbers[4] = 5");
        System.out.println("ERROR: Tried to access invalid index!");
        System.out.println();
    }

    // ----------------------------------------
    // LIVE DEMO 23: Uninitialized Array Reference
    // ----------------------------------------

    public static void liveDemo23() {

        System.out.println("LIVE DEMO 23: Uninitialized Array Reference");
        System.out.println("-------------------------------------------");

        int[] data = null; // declared but not allocated

        try {
            System.out.println("Attempting to access data[0]...");
            System.out.println(data[0]); // ❌ NullPointerException
        } catch (NullPointerException e) {
            System.out.println("ERROR: Array not initialized!");
            System.out.println("You must use 'new' to allocate memory.");
        }

        System.out.println();
        System.out.println("Expected Output:");
        System.out.println("ERROR: Array not initialized!");
        System.out.println();
    }

    /*
    ----------------------------------------
    NOTE:
    ----------------------------------------
    Students often encounter these exact issues in labs.
    Show them how to read stack traces carefully.

    A strong debugging mindset saves more time than memorizing syntax.
    ----------------------------------------

    TRY THIS:
    ----------------------------------------
    1. Write a program that intentionally causes ArrayIndexOutOfBounds.
    2. Then fix it by adjusting your loop condition.
    3. Add a print statement inside the catch block to confirm recovery.
    ----------------------------------------
    */

    public static void main(String[] args) {
        liveDemo22();
        System.out.println();
        liveDemo23();
    }
}
