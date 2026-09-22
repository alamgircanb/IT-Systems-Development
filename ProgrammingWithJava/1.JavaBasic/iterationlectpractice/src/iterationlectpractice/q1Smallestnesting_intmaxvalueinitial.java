/*
 This Java code finds the smallest of five integer numbers entered by the user. It correctly implements a robust method for finding a minimum value by initializing the tracker to the largest possible integer value.

Code Functionality
The program uses a while loop to iterate exactly five times (counter goes from 0 to 4). In each iteration, it performs the following steps:

Reads Input: Prompts the user to enter a number and stores it in the number variable.

Finds Minimum: It compares the entered number with the current value of smallest.

If the number is less than smallest, the value of smallest is updated to the number. This is the core logic for tracking the minimum.

Updates Counter: The loop control variable, counter, is incremented by 1.

Provides Feedback: Prints the currently entered number, the updated counter value, and the smallest number found so far.

Key Implementation Detail: Robust Initialization
The line int smallest = Integer.MAX_VALUE; is the most important part of this code's design for finding the minimum.

Integer.MAX_VALUE is the constant representing the largest possible value for an int variable (approx. 2.147 billion).

Purpose: By starting smallest at this maximum value, the code ensures that the very first number the user enters (regardless of whether it's positive, zero, or negative) will always be less than the initial value of smallest. This correctly initializes the minimum tracking process, making the code reliable for any range of integer inputs.

Example Interaction/Output
If a user enters the numbers 500,−10,75,−5,90:

User Input	number	number < smallest	smallest (After update)	counter	Console Output Summary
(User enters 500)	500	500<MAX_VALUE (T)	500	1	...Smallest Number is:500
(User enters −10)	−10	−10<500 (T)	−10	2	...Smallest Number is:-10
(User enters 75)	75	75<−10 (F)	−10	3	...Smallest Number is:-10
(User enters −5)	−5	−5<−10 (F)	−10	4	...Smallest Number is:-10
(User enters 90)	90	90<−10 (F)	−10	5	...Smallest Number is:-10
(Loop ends)			
 */
package iterationlectpractice;

import java.util.Scanner;// to import Scanner library

/**
 *
 * @author User
 */
public class q1Smallestnesting_intmaxvalueinitial {

    public static void main(String[] args) {
        // TODO code application logic here
        Scanner input;
        input = new Scanner(System.in);// to declare input variable with scanner
        int counter = 0;// to declare couner variable
        int smallest = Integer.MAX_VALUE;// to declare first smallest value
        int number;//to declare number variable
        while (counter < 5) {//to check the condition 
            System.out.println("Enter your enter:");// to prompt user to collect user input
            number = input.nextInt();// to take number variable into input method

            if (number < smallest) {// to check number and smallest variable condition
                smallest = number;//to take the number ito smallest variable if the condition is true
            }
            counter += 1;// to increase the loop value
            System.out.println("your Number is:" + number);//to print the number
            System.out.println("Counter Number is: " + counter);// to print the counter 
            System.out.println("Smallest Number is:" + smallest);// to print the smallest number 
        }
        input.close();// to close the scanner object after use
    }
}
