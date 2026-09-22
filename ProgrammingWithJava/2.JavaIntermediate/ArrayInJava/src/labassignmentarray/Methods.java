/*
A list of the methods in this file 
 01. double findHighest(double[] arr)
 02. double findLowest(double[] arr)
 03. double calculateSum(double[] arr)
 04. double calculateAverage(double[] arr)
 05. int countBelowValue(double[] arr, double threshold)
 06. double[] reverseSort(double[] arr)
 07. int[] getFinalGrades(int[] mid, int[] fin, int[] ass)
 08. double calculateAverage(int[] arr)
 09. int findHighestIndex(int[] arr)
 10. int findLowestIndex(int[] arr)
 11. int findFrequency(int[] array, int intValue)
 12. void displayArray(double[] arr, String description)
 */
package labassignmentarray;

/**
 *
 * @author User
 */
public class Methods {// to start a public class named 

    // --- Stock Price Methods ---

    /**
     * Finds the highest (maximum) value in a double array.
     * @param arr The array of double values.
     * @return The highest value in the array.
     */
    public static double findHighest(double[] arr) {// to declare a method named findHighest with double type and with double type paramter named arr in it
        if (arr == null || arr.length == 0) {// to check if the array passed through this method is null or with no elements
            return Double.NaN; // to return no number if the array is null or it has no element in it.
        }
        double max = arr[0];// to declare an array with double type and initiat with the firt elements in the first address of the array.
        for (int i = 1; i < arr.length; i++) {// to start a loop from 2nd address of the array and loop until less than of thhe array lenth (as max variable initiated with storing 1st value of the array)
            if (arr[i] > max) {// to check every elements of the array if each of them is greater then the fisrt value (stored in max variable
                max = arr[i];// to store the any element of the array match the condition of the above line means greater than the value stored in the max value.
            }
        }
        return max;// it will return last value stored in the max variable (from the loop everytime it is been updated if it get greater value than the existing value)
    }

    /**
     * Finds the lowest (minimum) value in a double array.
     * @param arr The array of double values.
     * @return The lowest value in the array.
     */
    public static double findLowest(double[] arr) {// to declare a method named findLowest with double type with double type parameter named arr in it
        if (arr == null || arr.length == 0) { // to check if the array passed through this method is null or with no elements
            return Double.NaN;// to return no value or number if the array is null or it has no element in it.
        }
        double min = arr[0];// to delare a double typed array with the first value of the array arr[0]
        for (double element : arr) {// declare a for loop to loop through the array named arr 
            if (element < min) {// to check every elements inside the aree if they are smaller then the fisrt elements arr[0]
                min = element;// to store or update the min variable value if the above line condition is true means any elements is smaller than the previous
            }
        }
        return min; // to return the last value stored in the min variable after completing the above for loop. It got the lowest value after loop as it  check all elements comparing with the previous one. 
    }

    /**
     * Calculates the sum of all elements in a double array.
     * @param arr The array of double values.
     * @return The sum of the array elements.
     */
    public static double calculateSum(double[] arr) {//  to declare a method named calculateSume in double type with a double typed parameter named arr.
        if (arr == null || arr.length == 0) {// to check if the array passed through this method is null or with no elements
            return 0.0;// to return 0.0 if the above condition is true.
        }
        double sum = 0.0;// to declare a double typed variable named sum with initial value 0.0 in it.
        for (double element : arr) {// to run a for loop to loop through the all elements of the array, it will take every value individually in the element variable.
            sum += element;//to add every elements when the for loop continue to te last elements of the array 
        }
        return sum; // to return the last result got from the above for loop adding all elements of the arr.
    }

    /**
     * Calculates the average (mean) of the elements in a double array.
     * Overloads calculateSum(double[]).
     * @param arr The array of double values.
     * @return The average value, or 0.0 if the array is empty.
     */
    public static double calculateAverage(double[] arr) {// to declare a method named calculateAverage with double type and with array parameter named arr
        if (arr == null || arr.length == 0) {//  to check if the array passed through this method is null or with no elements in it.
            return 0.0;// to return 0.0 value if the above condition is true.
        }
        return calculateSum(arr) / arr.length;// to calculate the average calling calculateSum method and divide the sum by the length of array(number of elements)
    }

    /**
     * Calculates the number of elements in an array that are below a given value.
     * @param arr The array of double values.
     * @param threshold The value to check against.
     * @return The count of elements below the threshold.
     */
    public static int countBelowValue(double[] arr, double threshold) {// to declare an integer type method named countBelowvalue with to double parameter, here we will pass array and a value to compare the array elements with this  value 
        if (arr == null || arr.length == 0) {//  to check if the array passed through this method is null or with no elements in it.
            return 0;// to return integer type value (0) if the array is empty or wit no element
        }
        int count = 0;// to declare a integer variable named counter with zero initial value
        for (double element : arr) {//  to run a for loop to take all elements to a double type variable named element
            if (element < threshold) {// to run a check a condition if the value got from passed through parameter threshold is greater thhen the each element of the array
                count++;// increase the counter value by 1 if the above condition is true.
            }
        }
        return count;// to return the lastest count value got from the above loop
    }

    /**
     * Sorts a double array in ascending order, then reverses it to achieve a
     * descending (highest to lowest) order.
     *
     * @param arr The array of double values to be sorted and reversed.
     * @return A new array with elements sorted in descending order.
     */
    public static double[] reverseSort(double[] arr) {// to declare double array type method, It will return a new array after reverse sorting.
        if (arr == null || arr.length == 0) {// to check if the array passed through this method is null or with no elements in it. 
            return new double[0];// return a new array with zero element if the array pass through arr is empty or no elements in it.
        }
        double[] sortedArr = java.util.Arrays.copyOf(arr, arr.length);// to create an array copy to avoid modifying the original array unless required.


        java.util.Arrays.sort(sortedArr); // 1. Sort the array in ascending order (built-in Java Arrays method is efficient)

        
        double[] reversedArr = new double[sortedArr.length];//2. Reverse the sorted array (descending order)
        for (int i = 0; i < sortedArr.length; i++) {// to run a for loop start from zero (0) and go through until sortedArr length
            reversedArr[i] = sortedArr[sortedArr.length - 1 - i];//to reverse the original sortedArr and to store it to reversedArr.
        }

        return reversedArr;// to retrun new reveresed array elements when it would be called.
    }

    // --- Student Grade Methods ---

    /**
     * Calculates the final grades for all students based on weighted scores.
     * Suggested signature: public static int[] getFinalGrades(int[] mid, int[] fin, int[] ass)
     * Grade distribution: Assignments 15%, Midterm 40%, Final 45%.
     * @param mid Array of midterm scores.
     * @param fin Array of final scores.
     * @param ass Array of assignment grades.
     * @return A new array containing the calculated final grades (rounded to int).
     */
    public static int[] getFinalGrades(int[] mid, int[] fin, int[] ass) {// to declare an integer type array method named getFinalGrade with the parameter mid, fin, ass all in integer type
        // Assume arrays are parallel and of the same length
        int numStudents = mid.length;// declare an integer variable named numStudents with value equal to mid.length
        int[] finalGrades = new int[numStudents];// to declare an integer type array named finalGrade with length equal to length of mid array considerig all parallel array are in same size

        // Grade Distribution Weights
        final double ASSIGNMENT_WEIGHT = 0.15;  // to declare a double type variable named ASSIGNMENT_WEIGHT with restriction final value 0.15
        final double MIDTERM_WEIGHT = 0.40;     //to declare a double type variable named MIDTERM_WEIGHT with restriction final value 0.40
        final double FINAL_WEIGHT = 0.45;      //to declare a double type variable named FINAL_WEIGHT with restriction final value 0.45

        for (int i = 0; i < numStudents; i++) {// to run a for loop to loop through each student (index i) to calculate their individual final grade
            double grade = (ass[i] * ASSIGNMENT_WEIGHT) +// to multiply all elements in the ass array by the ASSIGNMENT_WEIGHT to get it contribution to total final grade
                           (mid[i] * MIDTERM_WEIGHT) +//to multiply all elements in the mid array by the MIDTERM_WEIGHT to get it contribution to total final grade
                           (fin[i] * FINAL_WEIGHT);//to multiply all elements in the fin array by the FINAL_WEIGHT to get it contribution to total final grade
                            // this block of code will multiply every elements of the three arrays by their respective weigth and add every segments contribution to get final grade.
            // Populate the array with the calculated (and rounded) final grade
            finalGrades[i] = (int) Math.round(grade);// to pass rounded (integer) grade value to finalGrades array 
        }
        return finalGrades;// to return the method output that is final grades got at the end of loop.
    }

    /**
     * Calculates the average of all elements in an integer array.
     * Overloads calculateAverage(double[]).
     * @param arr The array of integer values.
     * @return The average value as a double.
     */
    public static double calculateAverage(int[] arr) {/* to declare a double type method to calculate the average of the grade. 
        It is a method overloading because we have another method in same name but with different parameters. 
        When we will call the method with calculateAverage name it will then try to match with the parameter types to decide with method will be called*/
        if (arr == null || arr.length == 0) {//  to check if the array passed through the parameter arr is empty or with no elements
            return 0.0;// to return a double type return value (0.0) if the above condition is true.
        }
        int sum = 0;// to declare an integer type variable named sum with zero initial value.
        for (int element : arr) {// to run a for loop to take the array elements to an integer elements named elements 
            sum += element;// to sum every elements when loop run until last elements of the array.
        }
        return (double) sum / arr.length;// to return the method output, here sum of the all array elements is divided by the array lenght or number of elements to calculate average.
    }

    /**
     * Finds the index of the highest value in an integer array.
     * Used to find the student with the highest grade.
     * @param arr The array of integer values.
     * @return The index of the highest value. Returns -1 if array is empty.
     */
    public static int findHighestIndex(int[] arr) {// to declare an integer typed method named findHightestIndex with an integer type parameter named arr.
        if (arr == null || arr.length == 0) {// to check if the array passed through the parameter array named arr is empty or null. 
            return -1;// to return -1 index address if the above condition is true. Usually array indexing starts from 0, if an array does not have any elements it's index is -1.
        }
        int max = arr[0];// to declare an integer variable named max by taking the first value index as initial value.
        int maxIndex = 0;// to declare an integer variable named maxIndex with initial value 0.
        for (int i = 1; i < arr.length; i++) {//to run a for loop starting from 1 to the lengh of the arr array.
            if (arr[i] > max) {// to check every value by index if the value is greater than the first value stored in max variable
                max = arr[i];// to update the max variable value if the above condition is true means any value greater then the previous value.
                maxIndex = i;// to update the index based on the latest max value
            }
        }
        return maxIndex;// to return the index of the max value
    }

    /**
     * Finds the index of the lowest value in an integer array.
     * Used to find the student with the lowest grade.
     * @param arr The array of integer values.
     * @return The index of the lowest value. Returns -1 if array is empty.
     */
    public static int findLowestIndex(int[] arr) {//to declare an integer typed method named findHightestIndex with an integer type parameter named arr.
        if (arr == null || arr.length == 0) {// to check if the array passed through the parameter array named arr is empty or null. 
            return -1;// to return -1 index address if the above condition is true. Usually array indexing starts from 0, if an array does not have any elements it's index is -1.
        }
        int min = arr[0];//to declare an integer variable named min by taking the first value index as initial value.
        int minIndex = 0;// to declare an integer variable named minIndex with initial value 0.
        for (int i = 1; i < arr.length; i++) {//to run a for loop starting from 1 to the lengh of the arr array.
            if (arr[i] < min) {// to check every value by index if the value is smaller than the first value stored in max variable
                min = arr[i];// to update the min variable value if the above condition is true means any value smaller then the previous value.
                minIndex = i;//to update the index based on the latest max value
            }
        }
        return minIndex;//to return the index of the min value
    }

    /**
     * Counts the frequency of elements in an array that are equal to or greater than a given value.
     * Suggested signature: public static int findFrequency(int[] array, int intValue)
     * @param array The array of integer values.
     * @param intValue The threshold value.
     * @return The number of elements (frequency) that meet the condition.
     */
    public static int findFrequency(int[] array, int intValue) {// to create an integer method named findFrequency with one array type parameter and one integer type parameter
        if (array == null || array.length == 0) {// to check if the array passed through the parameter array named arr is empty or null. 
            return 0;// to return an integer type return value (0) if the above condition is true.
        }
        int count = 0;// to declare an integer type variable named count with initial value 0.
        for (int element : array) {// to run a for loop with integer type variable named element to take each array value in it.
            if (element >= intValue) {// to compare every elements of the array with the value passed through into inValue parameter.
                count++;// to count the value if the above condition is true means count all value if the element is more than equal to inValue 
            }
        }
        return count;// to return the latest count value at the end of the for loop.
    }

    /**
     * Displays the elements of a double array to the output windows.
     * @param arr The array of double values.
     * @param description A string description for the output.
     */
    public static void displayArray(double[] arr, String description) {// to create a void type method named displayArray, I will call it to print my array result if applicable
        System.out.println("\n-- " + description + " --");// to print a text line
        System.out.print("{");// to print print opening curley bracket
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%.2f", arr[i]);// to print the element in array named arr with two decimal format.
            if (i < arr.length - 1) {// to print a comm after every element but not after last elements (-1)
                System.out.print(", ");// to print a comma (,) after every elements 
            }
        }
        System.out.println("}");// to print closing curley bracket.
    }
}
    

