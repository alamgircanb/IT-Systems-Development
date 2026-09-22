/*
 Code Functionality
The program runs an external while loop that executes five times (counter < 5). In each iteration, it performs the following logic:

Input Collection: Prompts the user to "Enter your Mark:" and reads the integer into the earnMark variable.

Input Validation (Outer if-else):

It checks if earnMark is less than 0 OR greater than 100 (earnMark < 0 || earnMark > 100).

If the mark is invalid, it prints an error message ("Your Enter Wrong, Please input 0-100").

If the mark is valid (between 0 and 100), it proceeds to the else block for the pass/fail check.

Pass/Fail Determination (Inner if-else):

It checks if the valid earnMark is greater than or equal to the passMark (which is 50).

If earnMark >= 50, it prints "Congratz: You Passed".

Otherwise, it prints "Sorry: You failed".

Loop Control & Output: The counter is incremented by 1, and the program prints the entered mark, the required pass mark (50), and the current counter value.

Key Features and Output Analysis
1. Nested Conditional Logic
The use of nested if-else statements is crucial here. The code first validates the input, and only if the input is valid does it execute the core pass/fail logic.

2. Loop Control
The loop is strictly set to run five times. A critical observation is that invalid inputs still count toward the five attempts. If a user enters five wrong numbers (e.g., 5 times the number 101), the loop will finish, and no valid grades will have been processed.

Example Interaction
Here is a summary of the execution if the user enters the sequence: 65,−5,49,100,50:

| Input (earnMark) | Validation Check (< 0 || > 100) | Pass/Fail Check (>= 50) | Output Message | counter |
| :---: | :---: | :---: | :--- | :---: |
| 65 | False (Valid) | 65≥50 (True) | Congratz: You Passed | 1 |
| −5 | −5<0 (True) | (Skipped) | Your Enter Wrong, Please input 0-100 | 2 |
| 49 | False (Valid) | 49≥50 (False) | Sorry: You failed | 3 |
| 100 | False (Valid) | 100≥50 (True) | Congratz: You Passed | 4 |
| 50 | False (Valid) | 50≥50 (True) | Congratz: You Passed | 5 |
| (Loop ends) | | | | |
1	package iterationlectpractice;	Declares the package this class belongs to, organizing the code.
3	import java.util.Scanner;	Imports the Scanner class, which is necessary to read input from the console (keyboard).
8	public class q3nestedif {	Declares the main class where the program resides.
13	public static void main(String[] args) {	The main method—the starting point of all Java programs.
15	// TODO code application logic here	A standard placeholder comment.
17−18	Scanner input; input = new Scanner(System.in);	Initializes the Scanner object named input to read data from the standard input stream (System.in), which is the console.
19	int counter = 0;	Declares and initializes an integer variable counter to 0. This variable will track how many times the loop has run.
20	int passMark = 50;	Declares and initializes an integer variable passMark to 50. This is the minimum score needed to pass.
21	int earnMark;	Declares an integer variable earnMark. This will store the mark entered by the user.
23	while (counter < 5) {	Starts the while loop. The code inside the curly braces will repeat as long as counter is less than 5. (It will run 5 times: when counter is 0,1,2,3,4).
24	System.out.println("Enter your Mark:");	Prints a message to the console, prompting the user to enter their mark.
25	earnMark = input.nextInt();	Reads the integer value the user types and stores it in the earnMark variable.
26	`if (earnMark < 0	
27	System.out.println("Your Enter Wrong, Please input 0-100");	Prints an error message if the mark is outside the valid range of 0 to 100.
28	} else {	The code enters this block only if the mark is valid (i.e., between 0 and 100).
29	if (earnMark >= passMark) {	Starts the pass/fail check. It checks if the valid earnMark is greater than or equal to 50.
31	System.out.println("Congratz: You Passed");	Prints "Passed" if the mark meets or exceeds the passMark.
32	} else {	The code enters this block if the pass condition is false (i.e., valid mark is less than 50).
33	System.out.println("Sorry: You failed");	Prints "Failed" if the mark is valid but below the passMark.
36	counter += 1;	Increments the counter by 1. This is the step that ensures the loop eventually terminates.
37	System.out.println("Your Earned Mark is:" + earnMark);	Prints the mark the user just entered.
38	System.out.println("Pass Mark is:" + passMark);	Prints the required passing mark (50).
39	System.out.println("Counter Number is: " + counter);	Prints the current value of the loop counter (the number of marks processed so far).
41	}	Closes the while loop. The program returns to line 23 to check the condition.
42	input.close();	Closes the Scanner object, releasing system resources.
44	}	Closes the main method.
46	}	Closes the q3nestedif class.
 */
package iterationlectpractice;

import java.util.Scanner;//to import scanner library

/**
 *
 * @author User
 */
public class q3nestedif {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Scanner input;
        input = new Scanner(System.in); // to declare a variable inside Scanner method
        int counter = 0;//to declare a variable named counter
        int passMark = 50;// to declare a variable named passMark
        int earnMark;//to declare a variable named earnMark

        while (counter < 5) {//to set while loop condition how much time it will run
            System.out.println("Enter your Mark:");//to prompt user to enter input
            earnMark = input.nextInt();//to store user input into earnMark variable
            if (earnMark < 0 || earnMark > 100) {// to set condition where it will check the value 0-100
                System.out.println("Your Enter Wrong, Please input 0-100");//print if the condition is true mean the value is the out of range
            } else {
                if (earnMark >= passMark) {//to set the 2nd condition earnMark is greater than or equal to passMark

                    System.out.println("Congratz: You Passed");//to print the result if the condition satisfy
                } else {// to set the condition if other conditions are not true
                    System.out.println("Sorry: You failed");//to print the result if the all other condition is not true
                }
            }

            counter += 1;// to increase the counter number untile while condition meet.
            System.out.println("Your Earned Mark is:" + earnMark);//to print earMark for the user
            System.out.println("Pass Mark is:" + passMark);//to print pass mark for the user
            System.out.println("Counter Number is: " + counter); //to print counter of the input how many number it has already checked

        }
        input.close();// to close the scanner object after use

    }

}
