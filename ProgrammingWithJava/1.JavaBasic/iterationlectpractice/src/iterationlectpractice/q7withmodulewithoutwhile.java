/*
 This Java program simulates a vending machine transaction, allowing a user to select an item, enter payment, and then calculates and displays the change due in Canadian coin denominations. It uses a series of separate while loops (one for each coin) to perform the change breakdown instead of the more common modulus (%) operator method.

Code Functionality
The program is divided into three main parts: item selection, payment processing, and iterative change calculation.

1. Item Selection and Price Setting
An if-else if-else chain is used to determine the price based on the user's integer choice (1-4). If the choice is invalid, an error message is printed, and the program proceeds with a price of 0.

2. Payment and Change Calculation
The user inputs the payment amount.

An if statement checks for insufficient payment.

If payment is sufficient, the change is calculated:

change 
cents
​
 =⌊round((payment−price)×100)⌋

This method converts the remaining dollar amount to an integer number of cents, which is essential for accurate coin calculation.

3. Coin Breakdown using Sequential while Loops 🪙
This section uses a greedy algorithm implemented with six individual while loops, one for each coin denomination (Toonies, Loonies, Quarters, Dimes, Nickels, Pennies).

Goal: To find the maximum number of the current largest coin that fits into the remaining change.

Mechanism: Each while loop checks if the remaining change is greater than or equal to the coin's value.

If true, it increments the coin's counter (e.g., toonies++) and subtracts the coin's value from the change (e.g., change = change - 200).

The loop repeats until the coin no longer fits.

Flow: The remaining change is sequentially passed from the Toonies loop down to the Pennies loop, ensuring the most efficient breakdown.

Detailed Line-by-Line Explanation
Line(s)	Code/Comment	Explanation
10−23	Scanner... System.out.println... double payment = input.nextDouble();	Initialization and Input: Initializes the Scanner, displays the menu, reads the item choice, sets the decimal price via the if-else if block, and reads the user's payment amount.
25−45	if (payment < price) { ... } else if (choice == 4) { ... }	Price Setting: This if-else if block determines the item's price based on choice.
47−49	System.out.print("Enter your payment: "); double payment = input.nextDouble();	Prompts for and reads the amount paid.
51−53	if (payment < price) { ... }	Insufficient Payment Check: Prints an error if payment is too low.
55	} else {	Block for sufficient payment.
57	change = (int) Math.round((payment - price) * 100);	Calculates the change in cents by converting the dollar difference to an integer (using Math.round() to manage floating-point issues).
58−59	System.out.println(...);	Prints the total change in cents and dollars.
62−67	int toonies = 0; ... int pennies = 0;	Initializes integer counters for each coin denomination to zero.
68−71	while (change >= 200) { toonies++; change = change - 200; }	Toonies Loop: Counts how many $2.00 coins (200 cents) can be given, subtracting 200 from change in each iteration.
72−75	while (change >= 100) { loonies++; change = change - 100; }	Loonies Loop: Counts the $1.00 coins (100 cents) from the remaining change.
76−80	while (change >= 25) { quarters++; change = change - 25; }	Quarters Loop: Counts the 25 cent coins.
81−84	while (change >= 10) { dimes++; change = change - 10; }	Dimes Loop: Counts the 10 cent coins.
85−88	while (change >= 5) { nickels++; change = change - 5; }	Nickels Loop: Counts the 5 cent coins.
89−92	while (change >= 1) { pennies++; change = change - 1; }	Pennies Loop: Counts the 1 cent coins. The change variable should be 0 after this loop finishes.
93−98	System.out.printf("Toonies : %d \n", toonies); ...	Prints the final coin breakdown using formatted output.
100	input.close();	Closes the Scanner object.

 */
package iterationlectpractice;

import java.util.Scanner;

/**
 *
 * @author User
 */
public class q7withmodulewithoutwhile {

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
        double price = 0;
        double change;

        if (choice == 1) {
            price = 1.35;
            System.out.println("Your price is " + price);

        } else if (choice == 2) {
            price = 1.65;
            System.out.println("Your price is " + price);

        } else if (choice == 3) {
            price = 2.00;
            System.out.println("Your price is " + price);

        } else if (choice == 4) {
            price = 3.75;
            System.out.println("Your price is " + price);

        } else {
            System.out.println("Please select a correct option.");
        }
        System.out.print("Enter your payment: ");
        double payment = input.nextDouble();

        if (payment < price) {
            System.out.println("Insufficient payment.");
        } else {
            // Calculate change
            change = (int) Math.round((payment - price) * 100); // convert to cents
            System.out.println("Change to be returned: " + change + " cents");
            System.out.println("That means your will get change:" + (double) change / 100);

            // Coin denominations in cents
            int toonies = 0;
            int loonies = 0;
            int quarters = 0;
            int dimes = 0;
            int nickels = 0;
            int pennies = 0;
            while (change >= 200) {
                toonies++;
                change = change - 200;
            }
            while (change >= 100) {
                loonies++;
                change = change - 100;
            }
            while (change >= 25) {
                quarters++;
                change = change - 25;

            }
            while (change >= 10) {
                dimes++;
                change = change - 10;
            }
            while (change >= 5) {
                nickels++;
                change = change - 5;
            }
            while (change >= 1) {
                pennies++;
                change = change - 1;
            }
            System.out.printf("Toonies   : %d \n", toonies);
            System.out.printf("Loonies   :%d \n", loonies);
            System.out.printf("Quarters   :%d \n", quarters);
            System.out.printf("Dimes   :%d  \n", dimes);
            System.out.printf("Nickels   :%d \n", nickels);
            System.out.printf("Pennies   :%d \n", pennies);
        }
        input.close();// to close the scanner object after use
    }
}
