package arraysminibook;

/**
 *
 * @author islammd
 */
// ==============================
// CHAPTER 11 – PASSING ARRAYS TO METHODS
// ==============================

/*
----------------------------------------
Chapter 11: Passing Arrays to Methods
----------------------------------------

WHAT THIS CHAPTER COVERS:
• How arrays are passed as references to methods
• Writing reusable methods for array processing
• Live Demo: printArray() and getAverage()
----------------------------------------
 */
import static arraysminibook.Chapter8_IndexPositions.getMaxIndex;
import java.util.Random;

class Chapter11_PassingArrays {

    /*
    ----------------------------------------
    CONCEPT:
    ----------------------------------------
    Arrays can be passed as arguments to methods,
    just like primitive values — but with one key difference:
    arrays are **passed by reference**.

    This means:
      • The method receives a reference to the same memory location.
      • Any changes made inside the method affect the original array.

    SYNTAX EXAMPLE:
        public static void printArray(int[] arr) {
            for (int n : arr)
                System.out.print(n + " ");
        }

        printArray(numbers); // call
    ----------------------------------------
     */
    // ----------------------------------------
    // LIVE DEMO 14: Printing an Array with a Method
    // ----------------------------------------
   /* public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println("arr[" + i + "] = " + arr[i]);
        }
    }

    public static void liveDemo14() {

        System.out.println("LIVE DEMO 14: Passing Arrays to Methods (printArray)");
        System.out.println("----------------------------------------------------");

        int[] numbers = {3, 6, 9, 12, 15};
        System.out.println("Array contents:");
        printArray(numbers);

        System.out.println();
        System.out.println("Expected Output:");
        System.out.println("arr[0] = 3");
        System.out.println("arr[1] = 6");
        System.out.println("arr[2] = 9");
        System.out.println("arr[3] = 12");
        System.out.println("arr[4] = 15");
        System.out.println();
    }

    // ----------------------------------------
    // LIVE DEMO 15: Calculating Average Using a Method
    // ----------------------------------------
    public static double getAverage(double[] arr) {
        double sum = 0;
        for (double n : arr) {
            sum += n;
        }
        return sum / arr.length;
    }

    public static void liveDemo15() {

        System.out.println("LIVE DEMO 15: Calculating Average Using a Method");
        System.out.println("------------------------------------------------");

        double[] grades = {85.5, 90.0, 78.5, 92.5};

        double avg = getAverage(grades);

        System.out.println("Average grade = " + avg);

        System.out.println();
        System.out.println("Expected Output:");
        System.out.println("Average grade = 86.625");
        System.out.println();

        System.out.println("Note: Arrays are passed by reference,");
        System.out.println("so methods can process the same data without copying it.");
    }*/

    /*
    ----------------------------------------
    NOTE:
    ----------------------------------------
    This chapter bridges your previous “Methods” module with array logic.
    It reinforces:
      - Method signatures using array parameters
      - Reusability of functions like printArray(), getMax(), etc.
    ----------------------------------------

    TRY THIS:
    ----------------------------------------
    1. Write a method getMax(int[] arr) that returns the largest value.
    2. In main(), create an array of random numbers and call getMax().
    3. Then write a second method getMin(int[] arr) and test it.
    ----------------------------------------
     */
    static int getMaxIndex(int[] data) {
        if (data == null || data.length == 0) {
            // Handle edge case for an empty or null array, though the 
            // array in main is guaranteed to be non-empty.
            return -1;
        }

        int indexOfmax = 0; // Assume the first element is the max
        for (int i = 1; i < data.length; i++) {
            if (data[i] > data[indexOfmax]) {
                indexOfmax = i; // Update index if a larger element is found
            }
        }
        return indexOfmax;
    }

    static int getMax(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Array must not be null or empty.");
        }

        int maxValue = arr[0]; // Start with the first value as the max
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > maxValue) {
                maxValue = arr[i]; // Update the value if a larger one is found
            }
        }
        return maxValue;
    }

    static int getMin(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Array must not be null or empty.");
        }

        int minValue = arr[0]; // Start with the first value as the min
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < minValue) {
                minValue = arr[i]; // Update the value if a smaller one is found
            }
        }
        return minValue;
    }

    
    
    public static void main(String[] args) {
       // liveDemo14();
        System.out.println();
       // liveDemo15();
       
       System.out.println("----------------------------------------");
        System.out.println("Challenges solution by Md Alamgir Hossain ");
        System.out.println("----------------------------------------");
        
        Random rand = new Random();
     
        int maxRandomValue = 15; // Random numbers will be between 0 and 99
        int[] values = new int[15];

        // 2. Populate the array with random numbers
        for (int i = 0; i < values.length; i++) {
            values[i] = rand.nextInt(maxRandomValue);
        }

        // 3. Print the array contents
        System.out.println("Generated Array (Size: 15, Range: 0-" + (maxRandomValue - 1) + "):");
        System.out.print("[ ");
        for (int val : values) {
            System.out.print(val + " ");
        }
        System.out.println("]");
        System.out.println("----------------------------------------");

        // 4. Test the methods
        
        // Test getMax (Value)
        int maxValue = getMax(values);
        System.out.println("Maximum Value (using getMax): " + maxValue);
        
        // Test getMin (Value)
        int minValue = getMin(values);
        System.out.println("Minimum Value (using getMin): " + minValue);
        
        // Test getMaxIndex (Index)
        int maxIndex = getMaxIndex(values);
        System.out.println("Index of Max Value (using getMaxIndex): " + maxIndex);
        
        // Verify the index and value match
        if (maxIndex != -1) {
            System.out.println("Max Value at Index " + maxIndex + " is: " + values[maxIndex]);
        }
    }
}

        
    

