package arraysminibook;

/**
 *
 * @author islammd
 */
// ==============================
// CHAPTER 6 – SUMMATION AND AVERAGE CALCULATIONS
// ==============================

/*
----------------------------------------
Chapter 6: Summation and Average Calculations
----------------------------------------

WHAT THIS CHAPTER COVERS:
• How to use arrays with accumulator variables
• Summing and averaging numeric data
• How these operations prepare for analysis tasks
• Live Demo: generating, summing, and averaging random numbers
----------------------------------------
 */
import java.util.Random;

class Chapter6_SumAndAverage {

    /*
    ----------------------------------------
    CONCEPT:
    ----------------------------------------
    One of the most common uses of arrays is to process numeric data.

    To compute a total or an average:
      • use a loop to *accumulate* values into a single variable.
      • then divide the total by the array length.

    Example pattern:
        int sum = 0;
        for (int i = 0; i < numbers.length; i++)
            sum += numbers[i];
    ----------------------------------------
     */
    // ----------------------------------------
    // LIVE DEMO 6: Generate, Sum, and Average Random Integers
    // ----------------------------------------
    /*public static void liveDemo6() {

        System.out.println("LIVE DEMO 6: Summation and Average of Random Integers");
        System.out.println("-----------------------------------------------------");

        Random rand = new Random();
        int[] values = new int[20];

        System.out.println("Populating array with 10 random integers (0–100):");
        for (int i = 0; i < values.length; i++) {
            values[i] = rand.nextInt(101);
            System.out.print(values[i] + " ");

        }
        System.out.println("\n");

        int sum = 0;
        for (int n : values) {
            sum += n;
        }

        double average = (double) sum / values.length;

        System.out.println("Total Sum = " + sum);
        System.out.println("Average   = " + average);
    
    
     System.out.println("-----------------------------------------------------");
    
     System.out.println();
        System.out.println("Expected Output Example:");
        System.out.println("Populating array with 20 random integers (0–100):");
        System.out.println("34 99 75 21 88 16 45 90 50 67");
        System.out.println("Total Sum = 585");
        System.out.println("Average   = 58.5");
        System.out.println();

        System.out.println("Your values will differ because of random generation.");
    }*/
 /*
    ----------------------------------------
    NOTE:
    ----------------------------------------
    The accumulator pattern (sum += value)
    is essential for statistics, reporting, and finance tasks.

    This forms the foundation for:
      - Average test scores
      - Total expenses
      - Stock-price analysis (Assignment 2)
    ----------------------------------------

    TRY THIS:
    ----------------------------------------
    1. Generate an array of 20 random integers (0–100).
    2. Compute and print how many numbers are ABOVE the average.
    3. Hint: use a second loop and an if condition.
    ----------------------------------------
     */
    public static void livePrac6() {

        System.out.println("LIVE Prac 6: Summation and Average of Random Integers");
        System.out.println("----------------------------------------");
        System.out.println("Challenges solution by Md Alamgir Hossain ");
        System.out.println("----------------------------------------");

        Random rand = new Random();
        int[] values = new int[20];

        System.out.println("Populating array with 10 random integers (0–100):");
        for (int i = 0; i < values.length; i++) {
            values[i] = rand.nextInt(101);
            System.out.print(values[i] + " ");

        }
        System.out.println("\n");

        int sum = 0;
        for (int n : values) {
            sum += n;
        }

        double average = (double) sum / values.length;
        int counter = 0;
        for (int n : values) {
            if (n > average) {
                counter++;
                System.out.printf("The number (%d) bigger than average is (%d)\n", counter, n);
            }

        }
        System.out.printf("The total count of bigger than average number is: (%d)\n", counter);
    }

    public static void main(String[] args) {
        //liveDemo6();
        livePrac6();
    }
}
