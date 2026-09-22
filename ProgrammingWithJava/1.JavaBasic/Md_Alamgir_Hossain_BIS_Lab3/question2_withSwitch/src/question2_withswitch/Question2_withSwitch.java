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
/**
 * Using switch
 */
package question2_withswitch;

import java.util.Scanner;

/**
 *
 * @author Md Alamgir Hossain
 */
public class Question2_withSwitch {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        double totalPrice = 0.0;// to define a double variable named totalPrice with intial value 0.0

        // to define constant item prices
        double RICE_PRICE = 15.99;
        double CHEESE_PRICE = 4.99;
        double EGGS_PRICE = 3.99;
        double TOFU_PRICE = 8.99;
        double BREAD_PRICE = 2.99;

        Scanner input;// to declare scanner method
        input = new Scanner(System.in);// to take input method inside scanner utility

        boolean isRunning = true; // to declare a boolean value to create a flag for the main menu loop

        System.out.println("--- Welcome to our Grocery Store ---");// to print a welcome message before main menu print for user

        // --code block to start main menu while Loop ---
        while (isRunning) {//to start while loop until boolean variable isRunning value is true

            // code block to display Main Menu ---
            System.out.println("\n=============================");
            System.out.println("--- Main Menu ---");
            System.out.println("1. Add items to cart");
            System.out.println("2. Check total price of cart");
            System.out.println("3. Exit");
            System.out.println("-----------------");
            System.out.print("Enter your choice (1-3): ");

            // Read Main Menu Choice 
            int mainMenuChoice = input.nextInt();// to declare an integer variable named mainMenuChoice inside input method
            input.nextLine(); // Consume newline after nextInt()

            // -Code block to start Main Menu case choice ---
            switch (mainMenuChoice) {// start switch with mainMenuChoice variable
                case 1: // to check case 1: Add items to cart (Opens Sub-Menu)
                {
                    boolean isAddingItems = true; // to declare a boolean variable named isAddingItem to create a flag for the sub-menu loop
                    System.out.println("\n-------- Opening Shopping Cart --------");// to print text line before price menu print

                    // code block to display Sub-Menu Loop ---
                    while (isAddingItems) {// to start while loop until boolean variable isAddinItems value is true.

                        // --- Sub-Menu Display ---
                        System.out.println("\n--- Add Item Sub-Menu ---");
                        System.out.printf("1. Rice\t\t - $%.2f%n", RICE_PRICE);
                        System.out.printf("2. Cheese\t - $%.2f%n", CHEESE_PRICE);
                        System.out.printf("3. Eggs\t\t - $%.2f%n", EGGS_PRICE);
                        System.out.printf("4. Tofu\t\t - $%.2f%n", TOFU_PRICE);
                        System.out.printf("5. Bread\t - $%.2f%n", BREAD_PRICE);
                        System.out.println("6. Stop adding to Cart");
                        System.out.println("-------------------------");

                        System.out.print("Enter item choice (1-6): ");// to prompt user to enter a choice 

                        // code block to read Sub-Menu Choice
                        int itemChoice = input.nextInt();// to declare a integer variable named itemChoice inside input method
                        input.nextLine(); // Consume newline after nextInt()

                        double itemPrice; // declare a double variable named itemPrice
                        String itemName;// to declare a string variable named itemName

                        // code block to start switch loop for Sub-Menu choice ---
                        switch (itemChoice) {// to start switch loop with itemChoice value
                            case 1: // Rice
                                itemPrice = RICE_PRICE;// to update item price with rice price if user select option 1
                                itemName = "Rice"; //to update item
                                totalPrice += itemPrice;// to update total price with selected item price
                                System.out.printf("Added %s to cart. Current total: $%.2f%n", itemName, totalPrice);
                                break;
                            case 2: // Cheese
                                itemPrice = CHEESE_PRICE; //to update item price with cheese price if user select option 2
                                itemName = "Cheese";//to update item
                                totalPrice += itemPrice;// to update total price with selected item price
                                System.out.printf("Added %s to cart. Current total: $%.2f%n", itemName, totalPrice);
                                break;
                            case 3: // Eggs
                                itemPrice = EGGS_PRICE;//to update item price with eggs price if user select option 3
                                itemName = "Eggs";//to update item
                                totalPrice += itemPrice;// to update total price with selected item price
                                System.out.printf("Added %s to cart. Current total: $%.2f%n", itemName, totalPrice);
                                break;
                            case 4: // Tofu
                                itemPrice = TOFU_PRICE;//to update item price with tofu price if user select option 4
                                itemName = "Tofu";//to update item
                                totalPrice += itemPrice;// to update total price with selected item price
                                System.out.printf("Added %s to cart. Current total: $%.2f%n", itemName, totalPrice);
                                break;
                            case 5: // Bread
                                itemPrice = BREAD_PRICE;//to update item price with bread price if user select option 5
                                itemName = "Bread";//to update item
                                totalPrice += itemPrice;// to update total price with selected item price
                                System.out.printf("Added %s to cart. Current total: $%.2f%n", itemName, totalPrice);
                                break;
                            case 6: // to stop adding item to cart if the user select option 6 
                                isAddingItems = false; // Exit the sub-menu loop
                                System.out.println("*** Shopping cart closed. Returning to Main Menu. ***");// to print message about shoppinng cart close
                                break;
                            default:// to validate if the user select menu other than 1-6
                                System.out.println("Invalid item choice. Please select a number between 1 and 6.");
                                break;
                        }
                    }
                    break;
                }

                case 2: // to Check total price of cart
                {
                    System.out.println("\n---------------------------------");

                    System.out.printf("Your current cart total is: $%.2f%n", totalPrice);// Displays the running total formatted to two decimal places.
                    System.out.println("---------------------------------");
                    break;
                }

                case 3: // 3. Exit
                {
                    isRunning = false; // Set flag to false to exit the main loop
                    System.out.printf("Thank you for shopping! Your final total is $%.2f. Goodbye!%n", totalPrice);
                    break;
                }

                default: {

                    System.out.println("Invalid choice. Please enter a number between 1 and 3.");  // Handles out-of-range menu numbers
                    break;
                }
            }
        }

        input.close();// to close input method.
    }
}
// I used switch loop to replace if - else if -else
