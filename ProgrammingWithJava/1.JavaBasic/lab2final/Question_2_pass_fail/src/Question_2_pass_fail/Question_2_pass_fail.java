/*
 02.Write an application that takes as input the marks of ten students,
determines how many pass (Mark >= 50) then prints the result.
 */
package Question_2_pass_fail;

import java.util.Scanner;// to import the scanner utility for capturing user input

/**
 *
 * @ Md Alamgir Hossain, BIS
 */
public class Question_2_pass_fail {

    public static void main(String[] args) {
        Scanner input;           // to declare input variable in scanner method
        input = new Scanner(System.in);
        int counter = 0;         // // to declare an integer variable named counter initialized with zero
        int passMark = 50;        // // to declare an integer variable named passMark initialized with zero, it will set minimum pass mark
        int earnMark;            // to // to declare an integer variable named earnMark initialized with zero

        while (counter < 10) {     //to loop until 5 times to take user inpute and check it
            System.out.println("Enter your Mark:");  //to prompt user to collect user input
            earnMark = input.nextInt();              // to store user input into input method

            if (earnMark >= passMark) {              // to check earnMark and passMark values which one is smaller
                System.out.println("Congratz: You Passed");   // to print the result if earnMark is greater
            } else {
                System.out.println("Sorry: You failed");      // to print the result if earnMark is Smaller
            }

            counter += 1;    // to increase the couter by 1 after each loop

            System.out.println("Your Earned Mark is:" + earnMark); // to print the user input mark
            System.out.println("Pass Mark is:" + passMark);      // to print the passMark variable value
            System.out.println("Counter Number is: " + counter);  // to print the Counter number

        }
        input.close();// to close the scanner object after use

    }
}
