/*
 2. Write a method that takes an integer value and returns the number with its digits reversed. Incorporate
the method into an application that reads a value from the user, calls the method and displays the result
 */
package reversedigits;
import java.util.Scanner;// to import Scanner class from util library


public class ReverseDigits {

    /**
     * @param n The integer value to reverse (e.g., 12345 or -987).
     * @return The integer with its digits reversed, or 0 if the reversed number
     */
    public static int reverseNumber(int n) {
        // Use a long to store the reversed number. This prevents intermediate
        // overflow when the reversed value is larger than Integer.MAX_VALUE,
        // allowing us to perform a safe check at the end.
        long reversed = 0;
        
        // We use 'n' directly. In Java, integer division and modulus with
        // negative numbers correctly preserve the sign of the digits.
        int number = n;

        while (number != 0) {
            // Get the last digit of the number
            int digit = number % 10;
            
            // Build the reversed number: shift current digits left and add the new one
            reversed = reversed * 10 + digit;
            
            // Remove the last digit from the number
            number /= 10;
        }

        // Final check: If the reversed number on the 'long' variable is outside
        // the range of a standard 'int', we return 0 to indicate overflow.
        if (reversed > Integer.MAX_VALUE || reversed < Integer.MIN_VALUE) {
            return 0; 
        }

        // The result is safe, so cast the long back to an int and return.
        return (int) reversed;
    }

    /**
     * The main method to run the application.
     * Reads input from the user, calls the reverseNumber method, and displays the result.
     * @param args
     */
    public static void main(String[] args) {
        // Initialize Scanner for user input
        Scanner input;
        input = new Scanner(System.in); // to declare input method inside scanner class

        System.out.println("--- Digit Reverser Application ---");
        System.out.print("Enter an integer (e.g., 12345 or -987): ");

        // Check if the input is actually an integer
        if (input.hasNextInt()) {
            int originalNumber = input.nextInt();

            // Call the reversal method
            int reversedNumber = reverseNumber(originalNumber);

            System.out.println("\nOriginal Number: " + originalNumber);
            
            // If the reversed number is 0 but the original wasn't, indicate overflow
            if (reversedNumber == 0 && originalNumber != 0) {
                 System.out.println("Reversed Number: 0 (Overflow occurred)");
            } else {
                 System.out.println("Reversed Number: " + reversedNumber);
            }

        } else {
            // Handle non-integer input gracefully
            System.out.println("\nError: Invalid input. Please enter a whole integer number.");
        }

       
        input.close(); // Close input method
    }
}
