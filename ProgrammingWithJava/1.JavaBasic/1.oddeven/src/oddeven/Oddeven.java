/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package oddeven;

import java.util.Scanner; //to import Scanner package

/**
 *
 * @author User
 */
public class Oddeven {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // I am writing this code to check even or odd number
        Scanner input = new Scanner(System.in); // To create a Scanner to read from System.in
        int usernumber; // to declare a variable named usernumber
        int reminder; // to declare a variable named reminder
        System.out.println("Please enter your number to check even or odd: "); //to Prompt the user to enter an integer
        
        usernumber = input.nextInt(); // to Read the integer into a variable
        reminder = usernumber % 2; // to Find remainder = number % 2.
        
        if (reminder == 0) {
            // to check the moduler math result is Zero
            System.out.println("Your number is:" + usernumber + " and it is even \n");
        } //
        else { // check if the value of reminder other than zero
            System.out.printf("Your number is: %d and it is odd\n", usernumber); // to check if the 2nd condition is true

            input.close(); // to close input method 
        }
    }

}
