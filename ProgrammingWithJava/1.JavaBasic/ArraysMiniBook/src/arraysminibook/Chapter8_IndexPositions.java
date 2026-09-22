package arraysminibook;

/**
 *
 * @author islammd
 */
// ==============================
// CHAPTER 8 – FINDING INDEX POSITIONS (MIN/MAX INDEX)
// ==============================

/*
----------------------------------------
Chapter 8: Finding Index Positions (Min/Max Index)
----------------------------------------

WHAT THIS CHAPTER COVERS:
• How to track WHERE a specific value occurs in an array
• Using an index variable to remember positions
• Live Demo: finding index of maximum and minimum values
----------------------------------------
 */
class Chapter8_IndexPositions {

    /*
    ----------------------------------------
    CONCEPT:
    ----------------------------------------
    When we find the largest or smallest value,
    we often also want to know *where* it is located.

    Approach:
      1. Start by assuming index 0 holds the target value.
      2. Loop through the array.
      3. Whenever a new max/min is found, store its index.

    Example:
        int indexOfMax = 0;
        for (int i = 1; i < numbers.length; i++)
            if (numbers[i] > numbers[indexOfMax])
                indexOfMax = i;
    ----------------------------------------
     */
    // ----------------------------------------
    // LIVE DEMO 9: Finding the Index of the Largest Value
    // ----------------------------------------
    /*  public static void liveDemo9() {

        System.out.println("LIVE DEMO 9: Finding the Index of the Largest Value");
        System.out.println("----------------------------------------------------");

        int[] data = {45, 67, 23, 89, 12, 99, 54};

        int indexOfMax = 0; // assume first element is largest
        for (int i = 1; i < data.length; i++) {
            if (data[i] > data[indexOfMax]) {
                indexOfMax = i;
            }
        }

        System.out.println("Largest value = " + data[indexOfMax]);
        System.out.println("Index position = " + indexOfMax);

        System.out.println();
        System.out.println("Expected Output:");
        System.out.println("Largest value = 99");
        System.out.println("Index position = 5");
        System.out.println();
    }

    // ----------------------------------------
    // LIVE DEMO 10: Finding the Index of the Smallest Value
    // ----------------------------------------
    public static void liveDemo10() {

        System.out.println("LIVE Demo 10: Finding the Index of the Smallest Value");
        System.out.println("----------------------------------------");
        System.out.println("Challenges solution by Md Alamgir Hossain ");
        System.out.println("----------------------------------------");

        int[] data = {45, 67, 23, 89, 12, 99, 54};

        int indexOfMin = 0;
        for (int i = 1; i < data.length; i++) {
            if (data[i] < data[indexOfMin]) {
                indexOfMin = i;
            }
        }

        System.out.println("Smallest value = " + data[indexOfMin]);
        System.out.println("Index position = " + indexOfMin);

        System.out.println();
        System.out.println("Expected Output:");
        System.out.println("Smallest value = 12");
        System.out.println("Index position = 4");
        System.out.println();
    }*/

 /*
    ----------------------------------------
    NOTE:
    ----------------------------------------
    This same logic is required in:
      - Practice Exercise Q5 (getMinIndex)
      - Assignment 2 (locating best/worst scores)
    Students often forget to update the *index* variable.
    Emphasize tracking both value AND position.
    ----------------------------------------

    TRY THIS:
    ----------------------------------------
    1. Write a method getMaxIndex(int[] arr) that returns the index of the largest element.
    2. Test it using the array {10, 4, 21, 8, 19}.
    3. Then print both value and index.
    ----------------------------------------
     */
    static int getMaxIndex(int[] data) {// to declare an integer array method with parameter data
        
        System.out.println("----------------------------------------");
        System.out.println("Challenges solution by Md Alamgir Hossain ");
        System.out.println("----------------------------------------");
        
        
        int indexOfmax = 0;// to declare a integer variable named indexofmax with zero initial;
        for (int i = 1; i < data.length; i++) {// iterate a loop till array length starting from 1, as indexofmax variable will start with zero

            if (data[i] > data[indexOfmax]) {// to check the array address with max value
                indexOfmax = i;// to store the value of i into indexofmax variable if the condition is true. 
            }
        }
        return indexOfmax;// finally return the indextofmax value 
    }

    public static void main(String[] args) {
        //liveDemo9();
        //liveDemo10();
        int[] testArray = {10, 4, 21, 8, 19};
        int maxIndex = getMaxIndex(testArray);
        if (maxIndex != -1) {
            int maxValue = testArray[maxIndex];

            System.out.println("Largest Value = " + maxValue);
            System.out.println("Index Position = " + maxIndex);
        }
    }
}
