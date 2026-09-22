
package arraysminibook;

/**
 *
 * @author islammd
 */

// ==============================
// CHAPTER 9 – SEARCHING ARRAYS
// ==============================

/*
----------------------------------------
Chapter 9: Searching Arrays
----------------------------------------

WHAT THIS CHAPTER COVERS:
• How to search for a specific value inside an array
• Counting occurrences and returning positions
• Live Demos: linear search and frequency counting
----------------------------------------
*/
import java.util.Scanner;
class Chapter9_Searching {

    /*
    ----------------------------------------
    CONCEPT:
    ----------------------------------------
    The simplest search is called a **linear search** —
    we check each element one by one until we find what we’re looking for.

    We can use this approach to:
      • Find the position of a target value.
      • Count how many times a value appears.
    ----------------------------------------
    */

    // ----------------------------------------
    // LIVE DEMO 11: Searching for a Specific Value
    // ----------------------------------------

   /* public static void liveDemo11() {

        System.out.println("LIVE DEMO 11: Searching for a Specific Value");
        System.out.println("--------------------------------------------");

        int[] numbers = { 5, 8, 12, 7, 8, 3, 8, 10 };
        int target = 8;

        boolean found = false;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == target) {
                System.out.println("Found " + target + " at index " + i);
                found = true;
            }
        }

        if (!found) {
            System.out.println("Value not found.");
        }

        System.out.println();
        System.out.println("Expected Output:");
        System.out.println("Found 8 at index 1");
        System.out.println("Found 8 at index 4");
        System.out.println("Found 8 at index 6");
        System.out.println();
    }*/

    // ----------------------------------------
    // LIVE DEMO 12: Counting Frequency of a Value
    // ----------------------------------------

  /*  public static void liveDemo12() {

        System.out.println("LIVE DEMO 12: Counting Frequency of a Value");
        System.out.println("-------------------------------------------");

        int[] survey = { 1, 2, 2, 1, 3, 2, 3, 1, 2, 1 };
        int target = 2;
        int count = 0;

        for (int n : survey) {
            if (n == target) {
                count++;
            }
        }

        System.out.println("Value " + target + " occurs " + count + " times.");

        System.out.println();
        System.out.println("Expected Output:");
        System.out.println("Value 2 occurs 4 times.");
        System.out.println();
    }*/

    /*
    ----------------------------------------
    NOTE:
    ----------------------------------------
    Searching is the foundation for analysis tasks.
    It appears directly in:
      • Practice Exercise (cafeteria survey)
      • Assignment 2 (findFrequency)
    ----------------------------------------

    TRY THIS:
    ----------------------------------------
    1. Write a program that asks the user for a number and reports whether it exists in an array.
    2. Then count how many times it appears.
    3. Challenge: extend this idea to count how many scores are above 90.
    ----------------------------------------
    */
    
    public static void livePrac12() {

        System.out.println("LIVE Prac 12: Finding and reports a number if it exits in an array");
        System.out.println("----------------------------------------");
        System.out.println("Challenges solution by Md Alamgir Hossain ");
        System.out.println("----------------------------------------");

        Scanner input = new Scanner (System.in);
        System.out.println("Please enter a number : ");
        int userNumber = input.nextInt();
        
        
        int[] survey = { 1, 2, 2, 1, 3, 2, 3, 1, 2, 1 };
        int count = 0;

        for (int n : survey) {
            if (n == userNumber) {
                count++;
            }
            else if (n>90) {
                
            }
        }

        System.out.println("Your Number " + userNumber+ " found " + count + " times.");
          System.out.println("-------------------------------------------");
    }
  
     public static void livePracScore() {

        System.out.println("LIVE Prac 12: Finding any scores above 90 in an array");
        System.out.println("-------------------------------------------");

      
        int[] scores = { 100, 75, 99,55, 120, 200, 30,75,25, 101 };
        int count = 0;

        for (int n : scores) {
            if (n>90) {
                count++;
            }
        }

        System.out.println( count + " numbers in the array is above 90 ");
    }
    
    
    public static void main(String[] args) {
       // liveDemo11();
        //liveDemo12();
        livePrac12();
        livePracScore();
    }
}

