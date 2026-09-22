/*
This Java code is designed to repeatedly check if a user's earned mark is a passing mark five times using a while loop.

Here's a breakdown of what the code does, how it works, and its output structure:

Code Functionality Overview
The program uses a while loop to iterate exactly five times (since counter goes from 0 to 4). In each iteration, it:

01.Prompts the user to enter a mark.

02.Reads the integer mark entered by the user.

03.Compares the entered mark (earnMark) to a fixed passing mark (passMark, which is 50).

04.Prints a "Passed" or "Failed" message based on the comparison.

05.Increments the loop counter.

06.Prints the earned mark, the pass mark, and the current counter number.

Detailed Explanation
Line(s)	Code Snippet	Purpose
13	Scanner input = new Scanner(System.in);	Initializes a Scanner object to read input from the console.
14	int counter = 0;	Initializes the loop control variable (counter) to 0.
15	int passMark = 50;	Sets the required passing mark to 50.
16	int earnMark;	Declares a variable to store the user's input mark.
17	while (counter < 5) {	Starts a loop that will continue as long as counter is less than 5 (running 5 times: for counter values 0,1,2,3,4).
18	System.out.println("Enter your enter:");	Displays a prompt asking the user to enter their mark.
19	earnMark = input.nextInt();	Reads the integer entered by the user and stores it in earnMark.
21	if (earnMark >= passMark) { ... } else { ... }	Checks if earnMark is greater than or equal to 50 and prints "Congratz: You Passed" or "Sorry: You failed" accordingly.
26	counter += 1;	Increments the counter by 1 to move toward the loop's termination condition.
27-29	System.out.println(...)	Prints the mark entered, the pass mark (50), and the current count number for user feedback.
32	input.close();	Closes the Scanner object after the loop finishes to free up system resources.

Export to Sheets
Example Interaction/Output
The output depends on the marks the user enters. Here's an example of what it might look like if a user enters the marks 60,45,50,70,30:

User Input	Program Output
(User enters 60)	Enter your enter: Congratz: You Passed Your Earned Mark is:60 Pass Mark is:50 Counter Number is: 1
(User enters 45)	Enter your enter: Sorry: You failed Your Earned Mark is:45 Pass Mark is:50 Counter Number is: 2
(User enters 50)	Enter your enter: Congratz: You Passed Your Earned Mark is:50 Pass Mark is:50 Counter Number is: 3
(User enters 70)	Enter your enter: Congratz: You Passed Your Earned Mark is:70 Pass Mark is:50 Counter Number is: 4
(User enters 30)	Enter your enter: Sorry: You failed Your Earned Mark is:30 Pass Mark is:50 Counter Number is: 5
(Loop ends)	
 */
package iterationlectpractice;

import java.util.Scanner;// to import Scanner library

/**
 *
 * @author User
 */
public class q2passorfail {

    public static void main(String[] args) {
        // TODO code application logic here
        Scanner input;
        input = new Scanner(System.in);// to declare input variable in scanner method
        int counter = 0;// to declare variable
        int passMark = 50;// to declare variable passMark
        int earnMark;// to declare variable earnMark
        while (counter < 5) {//to check condition
            System.out.println("Enter your enter:");//to prompt user to collect user input
            earnMark = input.nextInt();// to store user input into input method

            if (earnMark >= passMark) {// to check earnMark and passMark values
                System.out.println("Congratz: You Passed");// to print the result if condition is true
            } else {
                System.out.println("Sorry: You failed");// to print the result if condition is false
            }
            counter += 1;// to increase the couter value
            System.out.println("Your Earned Mark is:" + earnMark);// to print the user input mark

            System.out.println("Pass Mark is:" + passMark);// to print the passMark variable value
            System.out.println("Counter Number is: " + counter);// to print the Counter number

        }
        input.close();// to close the scanner object after use
    }
}
