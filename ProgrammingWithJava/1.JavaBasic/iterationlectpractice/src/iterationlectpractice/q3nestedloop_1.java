/*
 3. Modify the program in question two so that it uses a nested loop to
validate the inputs. All marks entered must be between 0 and 100. You
will only need to submit this version of the program.
 */
package iterationlectpractice;

import java.util.Scanner;

/**
 *
 * @Md Alamgir Hossain, BIS
 */
public class q3nestedloop_1 {

    public static void main(String[] args) {// to define main method and program will start from here.

        Scanner input;
        input = new Scanner(System.in); // to declare a variable named input inside Scanner method
        int counter = 0;//to declare a variable named counter to keep track user inputs
        int passMark = 50;// to declare a variable named passMark with 50 initial value. this will set up minimum passmark
        int earnMark;//to declare a variable named earnMark to store user input earnMark

        while (counter < 5) {//to set while loop condition with how much time it will loop
            System.out.println("Enter your Mark:");//to prompt user to enter input/earn mark
            earnMark = input.nextInt();//to store user input into earnMark variable
            
            if (!input.hasNextInt()) {
                System.out.println("Please write whole number");
            }
            else{  
                while (earnMark < 0 || earnMark > 100) {// to set condition where it will check the value 0-100
                    System.out.println("Your Enter Wrong, Please input 0-100");//print if the condition is true mean the value is the out of range
                    earnMark = input.nextInt();//to store user input into earnMark variable
                }
                if (earnMark >= passMark) {//to set the 2nd condition earnMark is greater than or equal to passMark
                    counter += 1;// to increase the counter number untile while loop set condition meet.
                    System.out.println("Congratz: You Passed");//to print the result if the condition satisfy
                    System.out.println("Your mark is :" + earnMark);//to print the result if the condition satisfy
                    System.out.println("Minimum Pass Mark is:" + passMark);//to print pass mark for the user
                    System.out.println("Counter Number is: " + counter + "\n"); //to print counter of the input how many

                } else {// to set the condition if other conditions are not true
                    counter += 1;// to increase the counter number untile while loop set condition meet.
                    System.out.println("Sorry: You failed");//to print the result if the all other condition is not true
                    System.out.println("Your mark is :" + earnMark);//to print the result if the all other condition is not true
                    System.out.println("Minimum Pass Mark is:" + passMark);//to print pass mark for the user
                    System.out.println("Counter Number is: " + counter + "\n"); //to print counter of the input how many
                }
            }
            }
            input.close();// to close the scanner object after use
        }

    }
