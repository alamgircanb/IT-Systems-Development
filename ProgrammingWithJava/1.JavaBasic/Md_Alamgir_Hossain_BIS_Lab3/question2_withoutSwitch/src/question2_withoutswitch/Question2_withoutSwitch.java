/**
 * 2. Create a menu based application for a grocery store. This application
 * will allow the user to buy various grocery items and store the total
 * price of their shopping cart. The main menu should have the following
 * options:
 * 1. Add items to cart
 * 2. Check total price of cart
 * 3. Exit
 * a. Option 1 should open up a sub menu. A sub menu is a term for
 * when one of the options in a menu contains another menu of
 * options. This submenu should loop, allowing the user to add
 * items one at a time into their cart. When the user is done adding
 * items to the cart they will select the “Stop adding items to car”
 * option. This sub menu should have the following options:
 * 1. Rice – $15.99
 * 2. Cheese – $4.99
 * 3. Eggs – $3.99
 * 4. Tofu – $8.99
 * 5. Bread – $2.99
 * 6. Stop adding to Cart
 * b. Option 2 should display the running total for all of the prices
 * added. Note: make sure to format this option in case the user
 * has not added any items into their cart yet.
 * Page 2 of 3
 *
 */
package question2_withoutswitch;

import java.util.Scanner;// to import scanner utility

/**
 *
 * @author Md Alamgir Hossain, BIS, Saskpoly
 */
public class Question2_withoutSwitch {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        double totalPrice = 0.0;// to declqare a double variable named totalPrice with initial value 0.0

        // code block to define constant item prices
        final double RICE_PRICE = 15.99;
        final double CHEESE_PRICE = 4.99;
        final double EGGS_PRICE = 3.99;
        final double TOFU_PRICE = 8.99;
        final double BREAD_PRICE = 2.99;

        Scanner input;//to declare scanner input method inside scanner utility.
        input = new Scanner(System.in);//to store input method inside scanner utility.
        boolean isRunning = true; // to create a flag for the main application loop

        System.out.println("--- Welcome to the ByteMart Grocery Store (Simplified) ---");//to print a line before promting manue

        // --- 2. Main Application Loop ---
        while (isRunning) {// to run a while loop till boolean variable isRunning is true.

            // ---code block to display Main Menu Display ---
            System.out.println("\n=============================");
            System.out.println("--- Main Menu ---");
            System.out.println("1. Add items to cart");
            System.out.println("2. Check total price of cart");
            System.out.println("3. Exit");
            System.out.println("-----------------------------------");
            System.out.print("Enter your choice (1-3): ");
            //-------------------------------------------------

            int mainMenuChoice = input.nextInt();// to declare an integer variable named mainMenuChoice inside input method
            input.nextLine(); // Consume newline after nextInt()

            if (mainMenuChoice == 1) { // 1. Add items to cart (Opens Sub-Menu)

                boolean isAddingItems = true; // to create a flag for the sub-menu loop to collect item options from user
                System.out.println("\n------ Opening Shopping Cart ---------");

                // --- Sub-Menu Loop ---
                while (isAddingItems) {// to run while loop to collect user input about item adding till boolean variable isAddingItem is true.

                    // ---code block to display Sub-Menu Display ---
                    System.out.println("\n--- Add Item Sub-Menu ---");// to print a text line as menu headline
                    System.out.printf("1. Rice\t\t - $%.2f%n", RICE_PRICE);// to display rice price for user
                    System.out.printf("2. Cheese\t - $%.2f%n", CHEESE_PRICE);// to display cheese price for user
                    System.out.printf("3. Eggs\t\t - $%.2f%n", EGGS_PRICE);// to display eggs price for user
                    System.out.printf("4. Tofu\t\t - $%.2f%n", TOFU_PRICE);// to display tofu price for user
                    System.out.printf("5. Bread\t - $%.2f%n", BREAD_PRICE);// to display bread price for user
                    System.out.println("6. Stop adding to Cart");// to prompt user to select option to stop adding item to cart
                    System.out.println("-------------------------");// to print a dash line after the menu 
                    System.out.print("Enter item choice (1-6): ");// to prompt user to enter choice value.

                    int itemChoice = input.nextInt();// to declare a variable inside input method
                    input.nextLine(); // Consume newline after nextInt()

                    double itemPrice = 0.0;//to declare a double variable named itemPrice with initial value 0.0
                    String itemName = "No Item";// to declare a string variable itemName with initial value "No Item"

                    // code block to update item price based on user input options.
                    if (itemChoice == 1) { // to check user select option 1 to add rice price to cart
                        itemPrice = RICE_PRICE;// to store rice price into itemPrice if user select option 1
                        itemName = "Rice";
                    } else if (itemChoice == 2) { // to check user select option 2 to add cheese price to cart
                        itemPrice = CHEESE_PRICE; //to store chees price into itemPrice if user select option 2
                        itemName = "Cheese";
                    } else if (itemChoice == 3) { // to check user select option 3 to add eggs price to cart
                        itemPrice = EGGS_PRICE;//to store eggs price into itemPrice if user select option 3
                        itemName = "Eggs";
                    } else if (itemChoice == 4) { // to check user select option 4 to add tofu price to cart
                        itemPrice = TOFU_PRICE;//to store tofu price into itemPrice if user select option 4
                        itemName = "Tofu";
                    } else if (itemChoice == 5) { // to check user select option 5 to add bread price to cart
                        itemPrice = BREAD_PRICE;//to store bread price into itemPrice if user select option 5
                        itemName = "Bread";
                    } else if (itemChoice == 6) { // to check user select option 6 to stop adding item
                        isAddingItems = false; // to update value of boolean variable isAddingItem into false if user select to exit from submenu.
                        System.out.println("--------Shopping cart closed. Returning to Main Menu.------");// to print a message about submenu closing
                    } else {
                        System.out.println("Invalid item choice. Please select a number between 1 and 6.");//to print a error message if user select value other than 1-6
                    }

                    // ---code block to update Price---
                    // Only update the price if a valid item (1-5) was selected
                    if (itemChoice >= 1 && itemChoice <= 5) {// to check condition that user chose right option for price
                        totalPrice += itemPrice;// to update total price each time user select a valid submenu option.
                        System.out.printf("Added %s to cart. Current total: $%.2f%n", itemName, totalPrice);// to print running cart total price.
                    }
                }
            } else if (mainMenuChoice == 2) { // to check if user select option 2 for menu choice
                System.out.println("\n---------------------------------"); // to print a dash line before total price
                System.out.printf("Your current cart total is: $%.2f%n", totalPrice);// to print total price result
                System.out.println("---------------------------------");// to print a dash line after total price result
            } else if (mainMenuChoice == 3) { // to check if user select option 3 for menu exit.
                isRunning = false; // to set flag to false to exit the main loop as user select option 3 to exit from loop
                System.out.printf("Thank you for shopping! Your final total is $%.2f. Goodbye!%n", totalPrice);//to print thank you message with total price value
            } else {// to  check if user select user other than valid menu.
                // Handles out-of-range menu numbers
                System.out.println("Invalid choice. Please enter a number between 1 and 3.");
            }
        }

        input.close();// to close scanner method.
    }

}
