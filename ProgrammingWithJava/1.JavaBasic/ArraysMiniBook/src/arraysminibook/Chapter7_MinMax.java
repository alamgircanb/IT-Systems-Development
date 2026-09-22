package arraysminibook;

/**
 *
 * @author islammd
 */
// ==============================
// CHAPTER 7 – FINDING LARGEST AND SMALLEST VALUES
// ==============================

/*
----------------------------------------
Chapter 7: Finding Largest and Smallest Values
----------------------------------------

WHAT THIS CHAPTER COVERS:
• How to compare array elements
• Using loops to track maximum and minimum values
• Live Demos: finding largest and smallest numbers
----------------------------------------
 */
class Chapter7_MinMax {

    /*
    ----------------------------------------
    CONCEPT:
    ----------------------------------------
    To find the largest or smallest element in an array:
      1. Start by assuming the first element is the answer.
      2. Compare each subsequent value.
      3. Replace the stored value if a new max/min is found.

    Example:
        int max = numbers[0];
        for (int i = 1; i < numbers.length; i++)
            if (numbers[i] > max)
                max = numbers[i];
    ----------------------------------------
     */
    // ----------------------------------------
    // LIVE DEMO 7: Finding the Largest Value
    // ----------------------------------------
    /* public static void liveDemo7() {

        System.out.println("LIVE DEMO 7: Finding the Largest Value");
        System.out.println("--------------------------------------");

        int[] numbers = {45, 67, 23, 89, 12, 99, 54};

        int largest = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > largest) {
                largest = numbers[i];
            }
        }

        System.out.println("The largest value is: " + largest);

        System.out.println();
        System.out.println("Expected Output:");
        System.out.println("The largest value is: 99");
        System.out.println();
    }

    // ----------------------------------------
    // LIVE DEMO 8: Finding the Smallest Value
    // ----------------------------------------
    public static void liveDemo8() {

        System.out.println("LIVE DEMO 8: Finding the Smallest Value");
        System.out.println("---------------------------------------");

        int[] numbers = {45, 67, 23, 89, 12, 99, 54};

        int smallest = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] < smallest) {
                smallest = numbers[i];

            }

        }

        System.out.println("The smallest value is: " + smallest);// to print the smallest number
        

        System.out.println();
        System.out.println("Expected Output:");
        System.out.println("The smallest value is: 12");
        System.out.println();
    }*/

 /*
    ----------------------------------------
    NOTE:
    ----------------------------------------
    The same logic can be extended to:
      • Finding highest/lowest stock price (Assignment 2)
      • Tracking minimum test score
      • Locating smallest element for sorting algorithms
    ----------------------------------------

    TRY THIS:
    ----------------------------------------
    1. Modify the program to display BOTH the largest and smallest values.
    2. Then display the difference between them.
    3. Challenge: count how many elements are equal to the smallest value.
    ----------------------------------------
     */
    public static void livePrac8() {

        System.out.println("LIVE Prac 8: Finding both Largest and Smallest and count any value equal to smallest");
        System.out.println("----------------------------------------");
        System.out.println("Challenges solution by Md Alamgir Hossain ");
        System.out.println("----------------------------------------");

        int[] numbers = {45, 67, 23, 89, 12, 99, 54};

        int smallest = numbers[0];
        int largest = numbers[0];
        int countSmallest = 0;
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] < smallest) {
                smallest = numbers[i];

            } else if (numbers[i] == smallest) {
                countSmallest++;

            }

            if (numbers[i] > largest) {
                largest = numbers[i];
            }

        }
        System.out.println("The smallest value is: " + smallest);// to print the smallest number
        System.out.println("The Largest value is: " + largest);
        System.out.println("Number of Smallest Number is: " + countSmallest);// to print the smallest number count
        System.out.println("The difference Between them is: " + (largest - smallest));// to print the difference between largest and smallest
    }

    public static void main(String[] args) {
        // liveDemo7();
        //liveDemo8();
        livePrac8();
    }
}
