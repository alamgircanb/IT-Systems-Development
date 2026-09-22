/*
 1. Write a Java application that allows a user to enter 5 integers and
determines and prints the smallest integer entered.
 */
package Question_1_smallestNestedloop;

import java.util.Scanner;// to import the scanner utility for capturing user input

/**
 *
 * @Md Alamgir Hossain
 */
public class Question_1_smallestNestedloop {// to define public class

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {  // to define main method and program will start from here.

        Scanner input;
        input = new Scanner(System.in);// to create a scanner object named input
        int counter = 0;       // to declare an integer variable named counter initialized to zero to keep track of how many numbers have been entered
        int smallest = 100;   // to declare an interger variable named smallest initialized by 100 (assuming no user input will be greater 100)
        int number;            //to declare an integer variable named number to store the user's input.

        while (counter < 5) {  //to start while loop which will run as long as counter less than 5. 
            System.out.println("Enter your number:");  // to prompt the user to enter a number.
            number = input.nextInt();          // to take number variable into input method

            if (number < smallest) {         // to check number and smallest variable if condition true smallest variable will be updated with number
                smallest = number;         //to update the smallest variable when the previous line condition is true
            }
            counter += 1; // to increase the loop value by updating counter variable every time loops run.

            System.out.println("your Number is:" + number);     //to print the user input to confirm with user
            System.out.println("Counter Number is: " + counter);// to print the count how many number user input
            System.out.println("Smallest Number is:" + smallest);// to print the smallest number

        }
        input.close();// to close the scanner object after use
    }
}
