package arraysminibook;

/**
 *
 * @author islammd
 */
// ==============================
// CHAPTER 2 – DECLARING AND INITIALIZING ARRAYS
// ==============================

/*
----------------------------------------
Chapter 2: Declaring and Initializing Arrays
----------------------------------------

WHAT THIS CHAPTER COVERS:
• Syntax of declaring arrays
• Understanding memory allocation and fixed size
• How indices work (0-based)
• Live Demo: creating, storing, and printing array elements
----------------------------------------
 */
class Chapter2_Declaring {

    /*
    ----------------------------------------
    CONCEPT:
    ----------------------------------------
    Declaring an array tells Java two things:
      1. What type of data it will hold.
      2. How many elements (size) it should have.

    SYNTAX:
        dataType[] arrayName = new dataType[size];

    Example:
        int[] numbers = new int[5];

    This line tells Java to make space for 5 integers in memory.
    Every slot initially holds the *default value* for that type (0 for int, null for objects).

    Arrays in Java are **0-based**, meaning the first element has index 0,
    and the last element is at index (length – 1).
    ----------------------------------------
     */
    // ----------------------------------------
    // LIVE DEMO 2: Declaring and Filling an Array
    // ----------------------------------------

    /*public static void liveDemo2() {

        System.out.println("LIVE DEMO 2: Declaring and Filling an Array");
        System.out.println("-------------------------------------------");

        int[] numbers = new int[4];     // declares 4 integer elements
        numbers[0] = 10;
        numbers[1] = 20;
        numbers[2] = 30;
        numbers[3] = 40;

        System.out.println("Printing the 4 elements:");
        for (int i = 0; i < numbers.length; i++) {
            System.out.println("Index " + i + " → " + numbers[i]);
        }

        System.out.println();
        System.out.println("Expected Output:");
        System.out.println("Index 0 → 10");
        System.out.println("Index 1 → 20");
        System.out.println("Index 2 → 30");
        System.out.println("Index 3 → 40");
        System.out.println();

        System.out.println("Remember: Index starts at 0, so numbers[3] is the 4th element.");
    }*/

 /*
    ----------------------------------------
    COMMON PITFALL:
    ----------------------------------------
    Accessing an index beyonnnnnnd the array’s limit causes:

        java.lang.ArrayIndexOutOfBoundsException

    Example of wrong code:
        numbers[4] = 99;   // ERROR! valid indices are 0–3
    ----------------------------------------

    TRY THIS:
    ----------------------------------------
    1. Create a String array named fruits with size 3.
    2. Assign three fruit names.
    3. Print each with its index number.
    ----------------------------------------
    
    *@Md Alamgir Hossain
     */
    static void livePrac() {
        System.out.println("Live Prac 2: Creating a String Array named fruites with size and assignig three fruit names");
        System.out.println("----------------------------------------");
        System.out.println("Challenges solution by Md Alamgir Hossain ");
        System.out.println("----------------------------------------");
        String[] fruits = new String[3];
        fruits[0] = "Banana";
        fruits[1] = "Mango";
        fruits[2] = "PineApple";
        System.out.println(" Printing the 3 fruits Name: ");
        for (int i = 0; i < fruits.length; i++) {
            System.out.println("The fruit's name " + (i + 1) + " is : " + fruits[i]);
        }
    }

    public static void main(String[] args) {
        //liveDemo2();
        livePrac();
    }
}
