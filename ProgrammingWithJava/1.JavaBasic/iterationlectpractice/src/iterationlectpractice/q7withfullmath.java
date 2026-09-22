/*
 This Java program simulates a vending machine transaction, allowing a user to select an item, enter payment, and then calculates and displays the change in coin denominations. It uses an array and a nested loop structure to perform the change calculation efficiently.

Code Functionality
The program performs three main tasks: item selection, payment processing, and change calculation.

1. Item Selection and Price Setting
An if-else if chain determines the price based on the user's choice (1-4). If an invalid choice is made, an error is printed, and the price remains 0.

2. Payment and Change Calculation
The user inputs the payment amount.

The program checks if the payment is sufficient (payment < price).

If sufficient, the change is calculated:

change 
cents
​
 =⌊round((payment−price)×100)⌋

This method converts the dollar amount to an integer number of cents, ensuring accurate currency math.

3. Coin Breakdown using Iteration 💰
The most unique part of this code is how it uses an array of denominations (denominations) and a for loop with a nested while loop to calculate the change.

Arrays: Stores coin values (e.g., 200,100,25) and their names (e.g., "Toonies", "Loonies").

Outer for Loop: Iterates through each denomination in the array (Toonies, Loonies, Quarters, etc.).

Inner while Loop: For the current coin, this loop repeatedly subtracts the coin's value from the remaining change and increments the count until the coin can no longer be dispensed.

Output: If the count for a denomination is greater than 0, the coin name and count are printed.

Detailed Line-by-Line Explanation
Line(s)	Code/Comment	Explanation
10	Scanner input = new Scanner(System.in);	Initializes the Scanner object for input.
12−19	System.out.println(...); input.nextInt();	Prints the item menu, prompts for, and reads the integer choice.
20−21	double price = 0; double change;	Declares and initializes the price variable, and declares the change variable (which will hold the amount in cents).
23−40	if (choice == 1) { ... } else if (choice == 4) { ... }	if-else if chain: Sets the appropriate decimal price based on the user's integer choice (1-4).
42	} else { System.out.println("Please select a correct option."); }	Handles invalid choices outside the 1−4 range.
44	double payment = input.nextDouble();	Prompts for and reads the payment amount.
46−47	if (payment < price) { ... }	Checks for insufficient payment and prints an error if true.
49	} else {	The block for sufficient payment proceeds with change calculation.
50	change = (int) Math.round((payment - price) * 100);	Calculates total change in cents. Multiplies the remaining balance by 100, rounds it to prevent decimal errors, and casts it to an integer.
51−52	System.out.println(...); System.out.println(...);	Prints the total change amount in cents and converts it back to dollars for user display.
54	int[] denominations = {200, 100, 25, 10, 5, 1};	Declares an array holding the value of each coin in cents (Toonie to Penny).
55	String[] names = {"Toonies", "Loonies", ...};	Declares an array holding the corresponding names of the coins.
57	for (int i = 0; i < denominations.length; i++) {	Outer loop: Iterates through the index of the denominations array (i=0 for Toonies, i=5 for Pennies).
58	int count = 0;	Initializes a counter for the number of the current coin being checked.
59	while (change >= denominations[i]) {	Inner loop: Continues as long as the remaining change is greater than or equal to the current coin's value.
60	change -= denominations[i];	Subtracts the coin's value from the remaining change.
61	count++;	Increments the counter for that coin.
63	if (count > 0) {	Checks if at least one of the current coin was dispensed.
64	System.out.println(names[i] + ": " + count);	Prints the coin name and the count (e.g., "Quarters: 3").
65	input.close();	CRITICAL ERROR: The scanner should be closed after the loop is completely finished, not inside the loop. Closing it here will cause an error on the second iteration if the loop were to continue (though this program's loop will finish after the first iteration is done).
66	}	Closes the outer for loop.
68	}	Closes the main method.

 */
package iterationlectpractice;

import java.util.Scanner;

/**
 *
 * @author User
 */
public class q7withfullmath {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

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
            int[] denominations = {200, 100, 25, 10, 5, 1};// to declare an integer array to store the denomination corresponding values
            String[] names = {"Toonies", "Loonies", "Quarters", "Dimes", "Nickels", "Pennies"};// to declare a string array to store denominaion name

            for (int i = 0; i < denominations.length; i++) {// to loop and check the denomination length and run it till the array lenth
                int count = 0;// to declare a variable named counter to count the denomination number
                while (change >= denominations[i]) {// check the change and denomination to count
                    change -= denominations[i];
                    count++;
                }
                if (count > 0) {
                    System.out.println(names[i] + ": " + count);
                }
                input.close();// to close the scanner object after use
            }
        }
    }
}
