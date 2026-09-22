package arraysminibook;

import java.util.Arrays;

/**
 *
 * @author islammd
 */
// ==============================
// CHAPTER 14 – ENHANCED FOR LOOP AND 2-D ARRAYS
// ==============================

/*
----------------------------------------
Chapter 14: Enhanced For Loop and 2-D Arrays
----------------------------------------

WHAT THIS CHAPTER COVERS:
• The enhanced for-each loop (simpler traversal)
• How to iterate through arrays without indexes
• Introduction to two-dimensional arrays
• Live Demos: using for-each and printing 2D matrices
----------------------------------------
 */
class Chapter14_EnhancedForAnd2D {

    /*
    ----------------------------------------
    CONCEPT 1: ENHANCED FOR LOOP
    ----------------------------------------
    Java’s enhanced for loop (for-each) offers a cleaner way
    to traverse arrays when we only need to *read* values.

    SYNTAX:
        for (dataType variable : arrayName) {
            // use variable
        }

    Example:
        for (int n : numbers)
            System.out.println(n);
    ----------------------------------------
     */
    // ----------------------------------------
    // LIVE DEMO 20: Using the Enhanced For Loop
    // ----------------------------------------
    /* public static void liveDemo20() {

        System.out.println("LIVE DEMO 20: Using the Enhanced For Loop");
        System.out.println("------------------------------------------");

        int[] numbers = {5, 10, 15, 20};

        System.out.println("Using classic for loop:");
        for (int i = 0; i < numbers.length; i++) {
            System.out.println("numbers[" + i + "] = " + numbers[i]);
        }

        System.out.println("\nUsing enhanced for loop:");
        for (int n : numbers) {
            System.out.println("Value = " + n);

        }

        System.out.println();
        System.out.println("Expected Output:");
        System.out.println("numbers[0] = 5");
        System.out.println("numbers[1] = 10");
        System.out.println("numbers[2] = 15");
        System.out.println("numbers[3] = 20");
        System.out.println("Value = 5");
        System.out.println("Value = 10");
        System.out.println("Value = 15");
        System.out.println("Value = 20");
        System.out.println();
    }

    /*
    ----------------------------------------
    CONCEPT 2: TWO-DIMENSIONAL ARRAYS
    ----------------------------------------
    A 2-D array is an *array of arrays* — think of it as a table
    with rows and columns.

        int[][] matrix = new int[3][3];

    You can access an element with two indices:
        matrix[row][col]

    ----------------------------------------
     */
    // ----------------------------------------
    // LIVE DEMO 21: Creating and Printing a 2D Array
    // ----------------------------------------
    public static void liveDemo21() {

        System.out.println("LIVE DEMO 21: Creating and Printing a 2D Array");
        System.out.println("----------------------------------------------");

        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        System.out.println("Matrix values:");
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }

        System.out.println();
        System.out.println("Expected Output:");
        System.out.println("1 2 3");
        System.out.println("4 5 6");
        System.out.println("7 8 9");
        System.out.println();
    }

 /*
    ----------------------------------------
    NOTE:
    ----------------------------------------
    Enhanced for loops simplify reading but not modification.
    2-D arrays introduce students to multi-level data —
    useful for seating charts, game boards, or spreadsheets.

    Encourage visual analogies: rows = shelves, columns = boxes on each shelf.
    ----------------------------------------*/
    public static void livePracExtra() {

        System.out.println("LIVE DEMO 20: Using the Enhanced For Loop");
        System.out.println("----------------------------------------");

        int[] numbers = {5, 10, 15, 20};

        System.out.println("Using classic for loop:");
        for (int i = 0; i < numbers.length; i++) {
            System.out.println("numbers[" + i + "] = " + numbers[i]);
        }

        System.out.println("\nUsing enhanced for loop:");
        int sum = 0;
        for (int n : numbers) {
            sum += n;
            System.out.println("Value = " + n);
            System.out.println("Value Sum = " + sum);

        }

        System.out.println("------------------------------");
        System.out.println("Running Sum = " + sum);
    }

    /*TRY THIS:
    ----------------------------------------
    1. Create a 2x3 int matrix of your own data.
    2. Print it using nested loops.
    3. Then compute the sum of all numbers in the matrix.
    ----------------------------------------
     */
    public static void matrix2And3() {

        System.out.println("TRY THIS Solution:");
        System.out.println("--------------------");

        // 1. Create a 2x3 int matrix
        int[][] myMatrix = {
            {10, 20, 30}, // Matrix Row 0
            {5, 15, 25} // Matrix Row 1
        };

        int totalSum = 0;

        // 2. Print it using nested loops
        System.out.println("My 2x3 Matrix:");
        for (int row = 0; row < myMatrix.length; row++) {
            for (int col = 0; col < myMatrix[row].length; col++) {
                int value = myMatrix[row][col];
                System.out.print(value + " "); // \t for tab spacing

                // 3. Compute the sum of all numbers
                totalSum += value;
            }
            System.out.println(); // Newline after each row
        }

        // Print the final sum
        System.out.println("\nSum of all elements: " + totalSum);
    }

    public static void matrix2And3Add() {

        System.out.println("TRY THIS Solution (Corrected for Matrix Addition):");
        System.out.println("----------------------------------------------");

        // 1. Create two 2x3 int matrices
        int[][] myMatrix = {
            {10, 20, 30}, // Matrix A Row 0
            {5, 15, 25} // Matrix A Row 1
        };
        int[][] myMatrix1 = {
            {10, 20, 30}, // Matrix B Row 0
            {5, 15, 25} // Matrix B Row 1
        };

        // Check if matrices are compatible for addition (same dimensions)
        int rows = myMatrix.length;    // Should be 2
        int cols = myMatrix[0].length; // Should be 3

        // 2. Create the result matrix (2x3)
        int[][] sumMatrix = new int[rows][cols];

        // 3. Perform Matrix Addition and compute totalSum
        int totalSum = 0;

        System.out.println("The sum of the two matrices is:");
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                // Matrix Addition: Sum[i][j] = A[i][j] + B[i][j]
                sumMatrix[row][col] = myMatrix[row][col] + myMatrix1[row][col];

                // Print the result matrix element
                System.out.print(sumMatrix[row][col] + " ");

                // Compute the sum of all elements in the result matrix
                totalSum += sumMatrix[row][col];
            }
            System.out.println(); // Newline after each row
        }

        System.out.println("\nSum of all elements in the result matrix: " + totalSum);

        // This line is for demonstration of the final matrix content (optional)
        // Note: Arrays.toString() on a 2D array gives a confusing output unless using Arrays.deepToString()
        System.out.println("The sum matrix content (using deepToString): " + Arrays.deepToString(sumMatrix));
    }

    public static void main(String[] args) {
        //liveDemo20();
        System.out.println("Challenges solution by Md Alamgir Hossain ");
        System.out.println("----------------------------------------");
        System.out.println();
        // liveDemo21();
        System.out.println("----------------------");
        matrix2And3();
        System.out.println("----------------------");
        livePracExtra();
        matrix2And3Add();
    }
}

/////////////////done
