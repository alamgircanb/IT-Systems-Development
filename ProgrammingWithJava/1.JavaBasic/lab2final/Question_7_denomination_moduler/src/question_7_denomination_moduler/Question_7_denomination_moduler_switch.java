/*
 6. Create another copy of the code from question 4 and modify it so it
uses a sentinel value to terminate input. This means that the program
should continue accepting trips until a specific value (examples: 0, -1)
is entered in the kilometers travelled or the time taken. Do not use a
for loop for this version of the application. Keep this as a separate
program.
 */
package question_7_denomination_moduler;

import java.util.Scanner;// to import the scanner utility for capturing user input

/**
 *
 * @author User
 */
public class Question_7_denomination_moduler_switch { // to define public class

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) { //to define main method and program will start from here.
        // to print all the options for user to select
        System.out.println("===============Select an item===============");
        System.out.println("          1. Chips           $1.35");
        System.out.println("          2. Chocolate Bar   $1.65");
        System.out.println("          3. Pop             $2.00");
        System.out.println("          4. Energy Drink    $3.75");
        System.out.print("  Enter your choice (1-4): ");

        Scanner input; // to declare a variable inside scanner
        input = new Scanner(System.in);// to declare a variable named input inside scanner

        int choice = input.nextInt();// to declare a variable named choice inside input method
        double price = 0;// to declare a double variable named price with initial value 0
        
        switch (choice) {
            case 1:
                //to check that user chose the option 1
                price = 1.35;//to select the price value if the condition true means choice/option is one(1)
                System.out.println("Your price is " + price); //to print the price to confirm with user
                break;
            case 2:
                //to check that user chose the option 2
                price = 1.65; //to select the price value if the condition true means choice/option is two (2)
                System.out.println("Your price is " + price); //to print the price to confirm with user
                break;
            case 3:
                //to check that user chose the option 3
                price = 2.00; //to select the price value if the condition true means choice/option is three (3)
                System.out.println("Your price is " + price); //to print the price to confirm with user
                break;
            case 4:
                //to check that user choose the option 4
                price = 3.75; //to select the price value if the condition true means choice/option is four (4)
                System.out.println("Your price is " + price); //to print the price to confirm with user
                break;
            default:
                //to check that user chose the option other than 1-4
                System.out.println("Please select a correct option."); //to print message that user select incorrect option
                break;
        }
        System.out.print("Enter your payment: ");//to prompt user to enter payment amount
       
        double payment = input.nextDouble();// to declare payment variable and to store the user input into payment variable

        if (payment < price) {// to check payment is greater than price or not
            System.out.println("Insufficient payment.");// to print the message if condition is true
        } else {// to execute the code below if the first condition is not true

            // Calculate change
            int change; // to declare a variable named change to store the change (means payment minus price)
            change = (int) Math.round((payment - price) * 100); // to calculate, convert and round the change into cents
            System.out.println("Change to be returned: " + change + " cents");// to print the change in cents
            System.out.printf("That means you will get change: $%.2f%n", change / 100.0);// to print the change in exact dollar amount

            // Coin denominations in cents
            int toonies = change / 200; // to return number of toonies, it will return the interger value from dividing change by 200 cents
            change = change%200;// to check the leftover cents that aren’t enough to make another toonie.

            int loonies = change / 100;//to return number of loonies, it will return the interger value from dividing change by 100 cents
            change = change% 100;//to check the leftover cents that aren’t enough to make another loonie.

            int quarters = change / 25;//to return number of quarters, it will return the interger value from dividing change by 25 cents
            change = change% 25;//to check the leftover cents that aren’t enough to make another quarters.

            int dimes = change / 10;//to return number of dimes, it will return the interger value from dividing change by 10 cents
            change = change% 10;//to check the leftover cents that aren’t enough to make another dimes.

            int nickels = change / 5;//to return number of nickels, it will return the interger value from dividing change by 5 cents
            change = change% 5;//to check the leftover cents that aren’t enough to make another nickels.

            int pennies = change;//to return number of pennies

            // Print coin breakdown
            System.out.println("There is your change with coin breakdown:");// to print a label line
            System.out.printf("Toonies   : %d%n", toonies);// to print number of toonies
            System.out.printf("Loonies   : %d%n", loonies);//to print number of loonies
            System.out.printf("Quarters  : %d%n", quarters);//to print number of quarters
            System.out.printf("Dimes     : %d%n", dimes);//to print number of dimes
            System.out.printf("Nickels   : %d%n", nickels);//to print number of nickels
            System.out.printf("Pennies   : %d%n", pennies);//to print number of pennies
        }
        input.close();// to close the scanner object after use
    }

}
//I use switch loop in this code to replace if -else if-else