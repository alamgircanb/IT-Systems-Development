/*
 * This Java code uses a while loop to find the smallest of five integer numbers entered by the user.

Code Functionality
The program performs the following steps five times (while counter < 5):

It prompts the user to enter a number.

It reads the integer and stores it in the number variable.

It uses an if statement to compare the entered number with the current value of the smallest variable.

If the entered number is less than the current smallest, it updates smallest to the new number.

It prints the number just entered, the current count, and the smallest number found so far.

It increments the counter.

Detailed Explanation of Variables
Variable	Initial Value	Purpose
input	new Scanner(System.in)	Used to read the user's input from the console.
counter	0	Controls the loop, ensuring it runs exactly five times.
smallest	100	Stores the smallest number encountered so far. It's initialized to 100 so that the first number the user enters (which is likely less than 100) will immediately become the new smallest.
number	(Not initialized)	Temporarily holds the number the user enters in each iteration.

Export to Sheets
Example Interaction/Output
If a user enters the numbers 55,90,30,75,10:

User Input	number	Is number<smallest?	smallest (After update)	counter	Console Output
(User enters 55)	55	55<100 (True)	55	0→1	your Number is:55 Counter Number is: 0 Smallest Number is:55
(User enters 90)	90	90<55 (False)	55	1→2	your Number is:90 Counter Number is: 1 Smallest Number is:55
(User enters 30)	30	30<55 (True)	30	2→3	your Number is:30 Counter Number is: 2 Smallest Number is:30
(User enters 75)	75	75<30 (False)	30	3→4	your Number is:75 Counter Number is: 3 Smallest Number is:30
(User enters 10)	10	10<30 (True)	10	4→5	your Number is:10 Counter Number is: 4 Smallest Number is:10
(Loop ends)		
 */
package iterationlectpractice;

import java.util.Scanner;// to import Scanner library

/**
 *
 * @author User
 */
public class q1Smallestnesting {

    public static void main(String[] args) {
        Scanner input;
        input = new Scanner(System.in);// to declare input variable with scanner
        int counter = 0;// to declare couner variable
        int smallest = 100;// to declare smallest
        int number;//to declare number variable
        while (counter < 5) {//to check the condition 
            System.out.println("Enter your enter:");// to prompt user to collect user input
            number = input.nextInt();// to take number variable into input method

            if (number < smallest) {// to check number and smallest variable condition
                smallest = number;//to take the number ito smallest variable if the condition is true
            }
            System.out.println("your Number is:" + number);//to print the number
            System.out.println("Counter Number is: " + counter);// to print the counter 
            System.out.println("Smallest Number is:" + smallest);// to print the smallest number 
            counter += 1;// to increase the loop value
        }
        input.close();// to close the scanner object after use
    }
}
