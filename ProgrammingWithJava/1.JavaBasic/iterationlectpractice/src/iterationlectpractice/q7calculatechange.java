/*
 * This Java program simulates a simple vending machine transaction. It prompts the user to select an item, enter a payment amount, and then calculates the change or informs the user if the payment is insufficient.

Code Functionality
The program's main function is to use an if-else if-else chain to determine the price of an item based on the user's choice and then process the payment.

Menu Display: The program displays a menu of four items and their prices.

Input Collection: It reads the user's integer choice (1-4) and the floating-point payment amount.

Price Determination: The if-else if structure checks the choice:

If choice is 1,2,3, or 4, the price variable is set to the corresponding item's cost.

Payment Processing: Inside each item's block, there is a nested if-else statement that checks the payment:

Insufficient Payment: If payment < price, it prints an error message (" please put more than price").

Sufficient Payment: If payment >= price, it calculates change (payment−price) and prints the payment received and the calculated change.

Invalid Choice: If the choice is not 1,2,3, or 4, the final else block executes, printing an error message ("Please select a correct option.").

Detailed Line-by-Line Explanation
Line(s)	Code/Comment	Explanation
10	Scanner input = new Scanner(System.in);	Initializes the Scanner object to read input from the console.
12−17	System.out.println(...);	Prints the menu options and prices to the console.
18	System.out.print("Enter your choice (1-4): ");	Prompts the user to select an item.
19	int choice = input.nextInt();	Reads the user's integer choice.
20−21	double price; double change;	Declares double variables to hold the selected item's price and the calculated change.
22	System.out.print("Enter your payment: ");	Prompts the user to enter the amount paid.
23	double payment = input.nextDouble();	Reads the user's payment amount as a decimal number.
24	if (choice == 1) {	Starts the main conditional structure for Choice 1 (Chips).
26	price = 1.35;	Sets the price for Chips.
27	System.out.println("Your price is " + price);	Prints the selected price.
28	if (payment < price) {	Checks for insufficient payment (nested if).
29	System.out.println(" please put more than price");	Prints error if payment is too low.
30−33	} else { ... change = payment - price; ... System.out.println("Your change is:" + change);	If payment is sufficient, calculates and prints the change.
36−54	} else if (choice == 2) { ... } else if (choice == 3) { ... } else if (choice == 4) { ... }	These blocks repeat the exact same logic (set price, check payment, calculate change) for Choices 2, 3, and 4.
86	} else {	The final else block runs if the choice was not 1,2,3, or 4.
87	System.out.println("Please select a correct option.");	Prints the error message for an invalid menu choice.
89	input.close();	Closes the Scanner object.

Export to Sheets
Note on Code Style
The code uses highly repetitive conditional blocks (if (choice == 1), else if (choice == 2), etc.). In professional Java development, this pattern 
is often simplified using a switch statement or by using an array/map to store prices, 
reducing code duplication.
 */
package iterationlectpractice;

import java.util.Scanner;

/**
 *
 * @author User
 */
public class q7calculatechange {

    public static void main(String[] args) {
        Scanner input;
        input= new Scanner(System.in);

        System.out.println("Select an item:");
        System.out.println("1. Chips           $1.35");
        System.out.println("2. Chocolate Bar   $1.65");
        System.out.println("3. Pop             $2.00");
        System.out.println("4. Energy Drink    $3.75");
        System.out.print("Enter your choice (1-4): ");
        int choice = input.nextInt();
        double price;
        double change;
        System.out.print("Enter your payment: ");
        double payment = input.nextDouble();
        if (choice == 1) 
        {
            price = 1.35;
            System.out.println("Your price is " + price);
            if (payment < price) {
                System.out.println(" please put more than price");
            } else {
                change = payment - price;
                System.out.println("Your payment is: " + payment);
                System.out.println("Your change is:" + change);
            }

        } else if (choice == 2) {
            price = 1.65;
            System.out.println("Your price is " + price);
            if (payment < price) {
                System.out.println(" please put more than price");
            } else {
                change = payment - price;
                System.out.println("Your payment is: " + payment);
                System.out.println("Your change is:" + change);
            }
        } else if (choice == 3) {
            price = 2.00;
            System.out.println("Your price is " + price);
            if (payment < price) {
                System.out.println(" please put more than price");
            } else {
                change = payment - price;
                System.out.println("Your payment is: " + payment);
                System.out.println("Your change is:" + change);
            }
        } else if (choice == 4) {
            price = 3.75;
            System.out.println("Your price is " + price);
            if (payment < price) {
                System.out.println(" please put more than price");
            } else {
                change = payment - price;
                System.out.println("Your payment is: " + payment);
                System.out.println("Your change is:" + change);
            }
        } else {
            System.out.println("Please select a correct option.");
        }
         input.close();// to close the scanner object after use
    }

}
