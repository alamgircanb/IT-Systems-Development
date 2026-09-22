package arraysminibook;

/**
 *
 * @author islammd
 */
// ==============================
// CHAPTER 13 – SORTING AND REVERSING ARRAYS
// ==============================

/*
----------------------------------------
Chapter 13: Sorting and Reversing Arrays
----------------------------------------

WHAT THIS CHAPTER COVERS:
• Introduction to sorting (ascending and descending)
• Writing custom methods to reorder data
• Live Demo: bubble sort and reverse array
----------------------------------------
 */
import java.util.Arrays;
import java.util.Random;

class Chapter13_SortingAndReversing {

    /*
    ----------------------------------------
    CONCEPT:
    ----------------------------------------
    Sorting means arranging values in a particular order.

    The simplest sorting algorithm to understand is **Bubble Sort**:
      • Compare each pair of adjacent elements.
      • Swap them if they are in the wrong order.
      • Repeat until no swaps remain.

    To reverse an array, swap elements from the ends moving inward.
    ----------------------------------------
     */
    // ----------------------------------------
    // LIVE DEMO 18: Sorting an Array in Ascending Order
    // ----------------------------------------
    public static void liveDemo18() {

        System.out.println("LIVE DEMO 18: Sorting an Array in Ascending Order");
        System.out.println("-------------------------------------------------");

        int[] numbers = {42, 15, 8, 23, 4, 16};
        System.out.println("Original array: " + Arrays.toString(numbers));

        // Simple bubble sort
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = 0; j < numbers.length - i - 1; j++) {
                if (numbers[j] > numbers[j + 1]) {
                    int temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                }
            }
        }

        System.out.println("Sorted array:   " + Arrays.toString(numbers));
        System.out.println();
        System.out.println("Expected Output:");
        System.out.println("Original array: [42, 15, 8, 23, 4, 16]");
        System.out.println("Sorted array:   [4, 8, 15, 16, 23, 42]");
        System.out.println();
    }

    // ----------------------------------------
    // LIVE DEMO 19: Reversing an Array (Descending Order)
    // ----------------------------------------
    public static void liveDemo19() {

        System.out.println("LIVE DEMO 19: Reversing an Array (Descending Order)");
        System.out.println("---------------------------------------------------");

        int[] numbers = {4, 8, 15, 16, 23, 42};
        System.out.println("Original sorted array: " + Arrays.toString(numbers));

        for (int i = 0; i < numbers.length / 2; i++) {
            int temp = numbers[i];
            numbers[i] = numbers[numbers.length - 1 - i];
            numbers[numbers.length - 1 - i] = temp;
        }

        System.out.println("Reversed array:        " + Arrays.toString(numbers));
        System.out.println();
        System.out.println("Expected Output:");
        System.out.println("Original sorted array: [4, 8, 15, 16, 23, 42]");
        System.out.println("Reversed array:        [42, 23, 16, 15, 8, 4]");
        System.out.println();
    }

    /*
    ----------------------------------------
    NOTE:
    ----------------------------------------
    Sorting is fundamental for organizing data.
    The reverse method ties directly to:
      - Assignment 2 (reverseSort() task)
      - Later advanced sorting lessons

    Emphasize clarity over performance at this stage.
    ----------------------------------------

    TRY THIS:
    ----------------------------------------
    1. Create an array of 10 random integers.
    2. Sort it using Arrays.sort().
    3. Then reverse it manually to show descending order.
    ----------------------------------------
     */
    public static void RandomArrayInt10() {

        System.out.println("TRY THIS: Sorting and Reversing 10 Random Integers");
        System.out.println("----------------------------------------");
        System.out.println("Challenges solution by Md Alamgir Hossain ");
        System.out.println("----------------------------------------");

        // 1. Create an array of 10 random integers
        int size = 10;
        int maxRandomValue = 100; // Limit random numbers to 0-99 for simplicity
        int[] randomNumbers = new int[size];
        Random rand = new Random();

        for (int i = 0; i < size; i++) {
            randomNumbers[i] = rand.nextInt(maxRandomValue) + 1; // Generate random int from 1 to 100
        }

        System.out.println("1. Original Random Array: " + Arrays.toString(randomNumbers));

        // 2. Sort it using Arrays.sort() (Ascending Order)
        // This is a highly optimized, dual-pivot quicksort implementation.
        Arrays.sort(randomNumbers);

        System.out.println("2. Sorted (Ascending) Array: " + Arrays.toString(randomNumbers));

        // 3. Then reverse it manually to show descending order
        int n = randomNumbers.length;
        for (int i = 0; i < n / 2; i++) {
            // Swap element at i with element at n - 1 - i
            int temp = randomNumbers[i];
            randomNumbers[i] = randomNumbers[n - 1 - i];
            randomNumbers[n - 1 - i] = temp;
        }

        System.out.println("3. Reversed (Descending) Array: " + Arrays.toString(randomNumbers));
        System.out.println();
    }

    public static void main(String[] args) {
        //liveDemo18();
        System.out.println();
        //liveDemo19();
        System.out.println();
        RandomArrayInt10();
    }
}
