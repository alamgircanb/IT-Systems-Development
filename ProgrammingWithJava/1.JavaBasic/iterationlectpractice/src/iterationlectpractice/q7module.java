/*
 This Java program simulates a vending machine transaction, allowing a user to select an item, enter payment, and then calculates the change due in coins, using the modulus operator (%) to break down the amount into Canadian coin denominations.

Code Functionality
The program first presents a menu and collects the user's choice. It then determines the item's price using an if-else if structure. After collecting the payment, it calculates the change in cents and uses a series of division and modulus operations to find the optimal coin distribution.

1. Item Selection
An if-else if chain sets the price based on the user's choice (1-4). If an invalid choice is made, an error message is printed, and the price remains $0.

2. Payment and Change Calculation
The user inputs the payment amount.

An if statement checks if the payment is sufficient (payment < price).

If payment is insufficient, an error is printed, and the program effectively stops the transaction.

If payment is sufficient, the change is calculated:

Change 
cents
​
 =round((payment−price)×100)
Multiplying by 100 and rounding (Math.round) is a crucial technique to convert dollars to cents and prevent floating-point inaccuracies common in Java when dealing with currency.

3. Coin Breakdown (Greedy Algorithm)
The core logic uses a greedy approach to calculate the change using the largest possible coin denomination first:

Division (/): Finds the count of the current coin denomination that fits into the remaining change.

Modulus (%): Updates the change variable to the remaining amount after those coins have been dispensed.

This process repeats for each coin: Toonies (200), Loonies (100), Quarters (25), Dimes (10), and Nickels (5). The remaining amount is the number of Pennies (1).

Detailed Line-by-Line Explanation
Line(s)	Code/Comment	Explanation
10−20	Scanner... System.out.println... input.nextInt();	Initializes the Scanner, displays the menu of items and prices, and reads the user's integer choice (1-4).
21	double price=0;	Declares and initializes the item price to 0.0.
22	int change;	Declares an integer variable to store the change in cents.
24−40	if (choice == 1) { ... } else if (choice == 2) { ... } else if (choice == 3) { ... } else if (choice == 4) { ... }	Sets the price based on the user's selection and prints the chosen price.
42−43	} else { System.out.println("Please select a correct option."); }	Prints an error message if an invalid choice (not 1-4) was entered.
44−45	System.out.print("Enter your payment: "); double payment = input.nextDouble();	Prompts for and reads the amount the user paid.
47	if (payment < price) { ... }	Checks if the payment is less than the item's price. If so, prints an "Insufficient payment" error.
50	change = (int) Math.round((payment - price) * 100);	CORE CALCULATION: Calculates the change, multiplies by 100 (to convert to cents), and uses Math.round() to handle floating-point precision issues before casting to the integer change.
51−52	System.out.println... System.out.printf...	Prints the change amount in cents and as a formatted dollar amount.
56−57	int toonies = change / 200; change %= 200;	Calculates the number of Toonies (worth 200 cents) and updates change to the remaining amount.
59−60	int loonies = change / 100; change %= 100;	Calculates the number of Loonies (100 cents) from the remaining amount.
62−63	int quarters = change / 25; change %= 25;	Calculates the number of Quarters (25 cents) from the remaining amount.
65−66	int dimes = change / 10; change %= 10;	Calculates the number of Dimes (10 cents) from the remaining amount.
68−69	int nickels = change / 5; change %= 5;	Calculates the number of Nickels (5 cents) from the remaining amount.
71	int pennies = change;	The final remaining value in the change variable is the number of Pennies (1 cent).
74−81	System.out.println... System.out.printf...	Prints the final detailed breakdown of the change by coin denomination.
83	input.close();	Closes the scanner object.
 */
package iterationlectpractice;

import java.util.Scanner;

/**
 *
 * @author User
 */
public class q7module {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Select an item:");
        System.out.println("1. Chips           $1.35");
        System.out.println("2. Chocolate Bar   $1.65");
        System.out.println("3. Pop             $2.00");
        System.out.println("4. Energy Drink    $3.75");
        System.out.print("Enter your choice (1-4): ");
        int choice = input.nextInt();
        double price=0;
        int change;
        
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
            }
        else {
        // Calculate change
        change = (int) Math.round((payment - price) * 100); // in cents
        System.out.println("Change to be returned: " + change + " cents");
        System.out.printf("That means you will get change: $%.2f%n", change / 100.0);


        // Coin denominations in cents
        int toonies = change / 200;
        change %= 200;

        int loonies = change / 100;
        change %= 100;

        int quarters = change / 25;
        change %= 25;

        int dimes = change / 10;
        change %= 10;

        int nickels = change / 5;
        change %= 5;

        int pennies = change;

        // Print coin breakdown
        System.out.println("Coin Breakdown:");
        System.out.printf("Toonies   : %d%n", toonies);
        System.out.printf("Loonies   : %d%n", loonies);
        System.out.printf("Quarters  : %d%n", quarters);
        System.out.printf("Dimes     : %d%n", dimes);
        System.out.printf("Nickels   : %d%n", nickels);
        System.out.printf("Pennies   : %d%n", pennies);
    }
}

        
}

