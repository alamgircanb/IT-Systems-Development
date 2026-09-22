package arraysminibook;

/**
 *
 * @author islammd
 */
// ==============================
// CHAPTER 3 – ARRAY INITIALIZER LISTS
// ==============================

/*
----------------------------------------
Chapter 3: Array Initializer Lists
----------------------------------------

WHAT THIS CHAPTER COVERS:
• Quick ways to declare and fill arrays in one line
• Difference between new keyword and literal lists
• Live Demo: fixed-size literal arrays
----------------------------------------
 */
class Chapter3_InitializerLists {

    /*
    ----------------------------------------
    CONCEPT:
    ----------------------------------------
    Sometimes we already know the values we want an array to contain.
    Instead of creating an empty array and filling it later,
    we can use an *initializer list*.

    SYNTAX:
        dataType[] arrayName = { value1, value2, value3 };

    Java automatically counts how many elements there are and sets the length.
    ----------------------------------------
     */
    // ----------------------------------------
    // LIVE DEMO 3: Creating Arrays with Literal Values
    // ----------------------------------------
    /* public static void liveDemo3() {

        System.out.println("LIVE DEMO 3: Creating Arrays with Literal Values");
        System.out.println("------------------------------------------------");

        int[] quizScores = {85, 90, 78, 92, 88};
        System.out.println("The array has " + quizScores.length + " elements.\n");

        System.out.println("Printing quiz scores:");
        for (int i = 0; i < quizScores.length; i++) {
            System.out.println("quizScores[" + i + "] = " + quizScores[i]);
        }

        System.out.println();
        System.out.println("Expected Output:");
        System.out.println("quizScores[0] = 85");
        System.out.println("quizScores[1] = 90");
        System.out.println("quizScores[2] = 78");
        System.out.println("quizScores[3] = 92");
        System.out.println("quizScores[4] = 88");
        System.out.println();

        System.out.println("Initializer lists are ideal for test data or short fixed datasets.");
    }*/

 /*
    ----------------------------------------
    CONCEPT 2: COMPARISON WITH NEW KEYWORD
    ----------------------------------------
    The two statements below create identical arrays:

        int[] a = {3, 5, 6};
        int[] b = new int[3];
        b[0] = 3; b[1] = 5; b[2] = 6;

    Both arrays have the same content.
    The first approach (initializer list) is shorter and clearer when values are known ahead of time.
    ----------------------------------------

    TRY THIS:
    ----------------------------------------
    1. Declare a double array named prices with these values:
         2.5, 3.9, 4.1, 5.75
    2. Print all values and then compute their total.
    3. Predict the expected output before running your program.
    ----------------------------------------
    *@author Md Alamgir Hossain
     */
    static void prices() {
        System.out.println("Live Prac: Creating Arrays with literal Values ");
        System.out.println("----------------------------------------");
        System.out.println("Challenges solution by Md Alamgir Hossain ");
        System.out.println("----------------------------------------");
        double[] prices = {2.5, 3.9, 4.1, 5.75};
        System.out.println("The length of the Price Array is " + prices.length);

        System.out.println("Printing all values: ");
        double sum = 0;
        for (int i = 0; i < prices.length; i++) {
            System.out.println("Prices [" + prices[i] + "]");

            sum += prices[i];

        }
        System.out.println("The sum of all prices are: " + sum);

    }
    static void hight() {
        // Declaration and Initialization
        double[][] hightWeight = new double[4][4];
        
        // Corrected Assignment: Use the array variable name (hightWeight)
        hightWeight[0][0] = 75.0; 
        hightWeight[0][1] = 75; 
        
        // Example: Print the assigned values to verify
        System.out.println("hightWeight[0][0]: " + hightWeight[0][0]);
        System.out.println("hightWeight[0][1]: " + hightWeight[0][1]);
    }

    public static void main(String[] args) {
        hight();
    }
    }

    
    

