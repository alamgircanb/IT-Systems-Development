
package arraysminibook;

/**
 *
 * @author islammd
 */


// ==============================
// CHAPTER 16 – PROJECT CHALLENGE: ARRAYS IN ACTION
// ==============================

/*
----------------------------------------
Chapter 16: Project Challenge – Arrays in Action
----------------------------------------

WHAT THIS CHAPTER COVERS:
• Applying array skills to real-world problems
• Integrating methods, loops, and array logic together
• Two guided challenges:
     (a) Stock Price Analyzer
     (b) Student Grades Calculator
----------------------------------------
*/

import java.util.Arrays;

class Chapter16_ProjectChallenge {

    /*
    ----------------------------------------
    CONCEPT:
    ----------------------------------------
    This chapter ties together everything we’ve learned so far.

    Instead of giving complete solutions, we’ll *plan* and *guide*
    two sample projects similar to the assignments.

    Students should think, plan, and code step-by-step.
    ----------------------------------------
    */

    // ----------------------------------------
    // LIVE DEMO 24: Guided Project – Stock Price Analyzer
    // ----------------------------------------

    public static void liveDemo24() {

        System.out.println("LIVE DEMO 24: Stock Price Analyzer (Guided Project)");
        System.out.println("---------------------------------------------------");

        double[] closingPrice = { 25.0, 38.25, 39.50, 38.75, 37.33, 37.22, 29.56, 31.05, 30.77, 38.25 };

        // Step 1 – Display all data
        System.out.println("Stock closing prices: " + Arrays.toString(closingPrice));

        // Step 2 – Find highest, lowest, and average
        double max = closingPrice[0];
        double min = closingPrice[0];
        double sum = 0;

        for (double price : closingPrice) {
            if (price > max) max = price;
            if (price < min) min = price;
            sum += price;
        }

        double avg = sum / closingPrice.length;

        // Step 3 – Display summary
        System.out.printf("Highest Price: %.2f%n", max);
        System.out.printf("Lowest Price:  %.2f%n", min);
        System.out.printf("Average Price: %.2f%n", avg);

        System.out.println();
        System.out.println("Expected Output Example:");
        System.out.println("Highest Price: 39.50");
        System.out.println("Lowest Price: 29.56");
        System.out.println("Average Price: 34.77");
        System.out.println();

        System.out.println("Note: Students will later add user input, reverse sorting, and method calls.");
    }

    // ----------------------------------------
    // LIVE DEMO 25: Guided Project – Student Grades Calculator
    // ----------------------------------------

    public static void liveDemo25() {

        System.out.println("LIVE DEMO 25: Student Grades Calculator (Guided Project)");
        System.out.println("--------------------------------------------------------");

        String[] name = { "Robin", "Jo", "Kelly", "Jaimie" };
        int[] midtermScore = { 28, 78, 92, 83 };
        int[] finalScore = { 58, 75, 96, 79 };
        int[] assignmentGrade = { 33, 80, 90, 83 };

        // Step 1 – Display arrays
        System.out.println("Names: " + Arrays.toString(name));
        System.out.println("Midterm: " + Arrays.toString(midtermScore));
        System.out.println("Final: " + Arrays.toString(finalScore));
        System.out.println("Assignment: " + Arrays.toString(assignmentGrade));

        // Step 2 – Compute final grades
        int[] finalGrade = new int[name.length];
        for (int i = 0; i < name.length; i++) {
            finalGrade[i] = (int) (assignmentGrade[i] * 0.15 +
                                   midtermScore[i] * 0.40 +
                                   finalScore[i] * 0.45);
        }

        // Step 3 – Display each student’s final grade
        System.out.println("\nFinal Grades:");
        for (int i = 0; i < name.length; i++) {
            System.out.println(name[i] + " → " + finalGrade[i]);
        }

        // Step 4 – Find class average
        double sum = 0;
        for (int grade : finalGrade)
            sum += grade;

        System.out.printf("%nClass Average: %.2f%n", sum / finalGrade.length);

        System.out.println();
        System.out.println("Expected Output Example:");
        System.out.println("Robin → 46");
        System.out.println("Jo → 76");
        System.out.println("Kelly → 94");
        System.out.println("Jaimie → 82");
        System.out.println("Class Average: 74.5");
        System.out.println();

        System.out.println("Note: This guided demo prepares students for Assignment 2.");
        System.out.println("Encourage them to extend it with larger arrays, new students, and method reusability.");
    }

    /*
    ----------------------------------------
    NOTE:
    ----------------------------------------
    Each of these projects combines:
      • Declaration, traversal, and method calls
      • Conditional logic and accumulation
      • Parallel arrays for relational data

    Remind students: design first, code second.
    ----------------------------------------

    TRY THIS:
    ----------------------------------------
    1. Extend the Stock Price Analyzer to calculate:
         – number of days below average
         – total cost of buying one share daily
    2. Extend the Student Grades Calculator to:
         – add two new students
         – display highest and lowest final grades
         – count how many passed (grade ≥ 60)
    ----------------------------------------
    */

    public static void main(String[] args) {
        liveDemo24();
        System.out.println();
        liveDemo25();
    }
}
