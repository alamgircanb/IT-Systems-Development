package arraysminibook;

/**
 *
 * @author islammd
 */
// ==============================
// CHAPTER 4 – USING ARRAY LENGTH AND LOOPS
// ==============================

/*
----------------------------------------
Chapter 4: Using Array Length and Loops
----------------------------------------

WHAT THIS CHAPTER COVERS:
• How to access the array’s length
• Using loops to traverse arrays safely
• Why hard-coding limits causes errors
• Live Demo: looping through arrays dynamically
----------------------------------------
 */
import java.util.Random;

class Chapter4_LengthAndLoops {

    /*
    ----------------------------------------
    CONCEPT:
    ----------------------------------------
    Every array in Java automatically stores its own size.
    You can access this with the `.length` property.

        int[] scores = { 5, 10, 15 };
        System.out.println(scores.length);  // prints 3

    The `.length` value is extremely useful because it allows you to write
    loops that automatically adapt to the array’s size — no need to hard-code numbers.
    ----------------------------------------
     */
    // ----------------------------------------
    // LIVE DEMO 4: Looping Using .length
    // ----------------------------------------
    public static void liveDemo4() {

        System.out.println("LIVE DEMO 4: Looping Using .length");
        System.out.println("----------------------------------");

        int[] numbers = {2, 4, 6, 8, 10, 12};

        System.out.println("There are " + numbers.length + " elements in this array.\n");
        System.out.println("Printing each element using the length property:\n");

        for (int i = 0; i < numbers.length; i++) {
            System.out.println("numbers[" + i + "] = " + numbers[i]);
        }

        System.out.println();
        System.out.println("Expected Output:");
        System.out.println("numbers[0] = 2");
        System.out.println("numbers[1] = 4");
        System.out.println("numbers[2] = 6");
        System.out.println("numbers[3] = 8");
        System.out.println("numbers[4] = 10");
        System.out.println("numbers[5] = 12");
        System.out.println();

        System.out.println("Because the loop uses numbers.length,");
        System.out.println("it will always print every element — even if the array size changes later.");
    }

 /*
    ----------------------------------------
    COMMON ERROR:
    ----------------------------------------
    Using <= instead of < in the loop condition.

        for (int i = 0; i <= numbers.length; i++)  // ❌ WRONG
            System.out.println(numbers[i]);

    The last index is (length – 1). Using <= will attempt to access one
    position beyond the valid range and cause:
        java.lang.ArrayIndexOutOfBoundsException
    ----------------------------------------

    TRY THIS:
    ----------------------------------------
    1. Create an array of 8 random integers between 1–50.
    2. Use a for loop with .length to print all elements.
    3. Then, print only the elements that are divisible by 5.
    ----------------------------------------
    *@author Md Alamgir Hossain
     */
    static void liveDemo4prec() {
        System.out.println("LIVE DEMO 4: Looping Using .length");
        System.out.println("----------------------------------------");
        System.out.println("Challenges solution by Md Alamgir Hossain ");
        System.out.println("----------------------------------------");
        Random rand = new Random();
        int[] values = new int[8];

        System.out.println("Populating array with 10 random integers (0–100):");
        for (int i = 0; i < values.length; i++) {
            values[i] = rand.nextInt(50);
            System.out.println("Values [" + i + "] = " + values[i]);

        }
        System.out.println(" -----------------------------------");
        System.out.println(" Now I will show you My Practic Part");
        System.out.println(" -----------------------------------");
        for (int n : values) {
            if (n % 5 == 0) {

                System.out.println("Values divided by 5 is [" + n + "]");
            }
        }
    }

    public static void main(String[] args) {
        //liveDemo4();
        liveDemo4prec();
    }
}
