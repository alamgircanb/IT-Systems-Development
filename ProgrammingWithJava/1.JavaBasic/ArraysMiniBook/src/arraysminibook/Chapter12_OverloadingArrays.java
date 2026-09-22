package arraysminibook;

/**
 *
 * @author islammd
 */
// ==============================
// CHAPTER 12 – OVERLOADING METHODS WITH ARRAYS
// ==============================

/*
----------------------------------------
Chapter 12: Overloading Methods with Arrays
----------------------------------------

WHAT THIS CHAPTER COVERS:
• Understanding method overloading with arrays
• Writing multiple versions of a method (different parameter types)
• Live Demo: overloaded average() and populate() methods
----------------------------------------
 */
import java.util.Random;

class Chapter12_OverloadingArrays {

    /*
    ----------------------------------------
    CONCEPT:
    ----------------------------------------
    Method overloading means having multiple methods
    with the same name but different parameter lists.

    You can overload methods that accept:
      • different data types (int[], double[], etc.)
      • different numbers of parameters

    The compiler chooses the correct method automatically
    based on the argument types in the call.
    ----------------------------------------
     */
    // ----------------------------------------
    // LIVE DEMO 16: Overloaded average() Methods
    // ----------------------------------------
    /*public static double average(int[] arr) {
        int sum = 0;
        for (int n : arr) {
            sum += n;
        }
        return (double) sum / arr.length;
    }

    public static double average(double[] arr) {
        double sum = 0;
        for (double n : arr) {
            sum += n;
        }
        return sum / arr.length;
    }

    public static void liveDemo16() {

        System.out.println("LIVE DEMO 16: Overloaded average() Methods");
        System.out.println("------------------------------------------");

        int[] intScores = {80, 90, 70};
        double[] dblScores = {82.5, 91.0, 73.5};

        System.out.println("Average (int array)   = " + average(intScores));
        System.out.println("Average (double array)= " + average(dblScores));

        System.out.println();
        System.out.println("Expected Output:");
        System.out.println("Average (int array)   = 80.0");
        System.out.println("Average (double array)= 82.33333333333333");
        System.out.println();
    }

    // ----------------------------------------
    // LIVE DEMO 17: Overloaded populate() Methods
    // ----------------------------------------
    static void populate(int[] arr) {
        Random r = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = r.nextInt(101); // 0–100
        }
    }

    static void populate(double[] arr) {
        Random r = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Math.round(r.nextDouble() * 10000.0) / 100.0;
        }
    }

    public static void liveDemo17() {

        System.out.println("LIVE DEMO 17: Overloaded populate() Methods");
        System.out.println("-------------------------------------------");

        int[] numbers = new int[5];
        double[] decimals = new double[3];

        populate(numbers);
        populate(decimals);

        System.out.println("Random integers:");
        for (int n : numbers) {
            System.out.print(n + " ");
        }
        System.out.println("\n");

        System.out.println("Random decimals:");
        for (double d : decimals) {
            System.out.print(d + " ");
        }
        System.out.println("\n");

        System.out.println("Expected Output Example:");
        System.out.println("Random integers: 42 98 7 56 80");
        System.out.println("Random decimals: 17.25 43.88 79.32");
        System.out.println();
    }*/

 /*
    ----------------------------------------
    NOTE:
    ----------------------------------------
    Overloading lets us reuse method names
    for logically identical operations on different data types.

    Students can now reuse their Methods class
    from the previous module and expand it to handle arrays.
    ----------------------------------------

    TRY THIS:
    ----------------------------------------
    1. Create two methods sum(int[]) and sum(double[]).
    2. Test both with different arrays.
    3. Print the total for each version.
    ----------------------------------------
     */
    static int sum(int[] arr) {
        int total = 0;
        for (int n : arr) {
            total += n;
        }
        return total;
    }

    static double sum(double[] arr) {
        double total = 0.0;
        for (double n : arr) {
            total += n;
        }
        return total;
    }

    public static void livePrac12() {
        System.out.println("LIVE Prac 12: Overloaded sum() Methods (TRY THIS SOLUTION)");
        System.out.println("----------------------------------------");
        System.out.println("Challenges solution by Md Alamgir Hossain ");
        System.out.println("----------------------------------------");

        // 1. To Test with int array
        int[] intNumbers = {5, 10, 15, 20};
        int intSum = sum(intNumbers);
        System.out.println("Test 1: Integer Array Sum");
        System.out.print("Array: [5, 10, 15, 20]");
        System.out.println("Total: " + intSum);

        System.out.println();

        // 2. To Test with double array
        double[] dblNumbers = {1.5, 2.5, 3.0, 5.0};
        double dblSum = sum(dblNumbers);
        System.out.println("Test 2: Double Array Sum");
        System.out.print("Array: [1.5, 2.5, 3.0, 5.0] ");
        System.out.println("Total: " + dblSum);

        System.out.println();
        System.out.println("Expected Output (for Test Arrays):");
        System.out.println("Total (int): 50");
        System.out.println("Total (double): 12.0");
    }

    public static void main(String[] args) {
        //liveDemo16();
        System.out.println();
        //liveDemo17();
        System.out.println("-------------------------");
        livePrac12();

    }
}
