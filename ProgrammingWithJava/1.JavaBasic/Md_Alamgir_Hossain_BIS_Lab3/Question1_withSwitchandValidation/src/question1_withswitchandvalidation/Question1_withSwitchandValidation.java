/* 
    *Question_1: A menu-based application to manage a person's name, age, and favorite
     * color. This version contains NO input validation and assumes correct input
     * types and non-empty strings.
        Use loops to create a repeating menu
      *Use decision operators to cleanly separate the code for each menu option
       *Create your code in such a way that menu options can effect the functionality or data in other menu options
  *Use well crafted loop conditions to ensure your application will exit without the need for breaks, continues, or exits

 */
package question1_withswitchandvalidation;

import java.util.Scanner;

/**
 *
 * @author Md Alamgir Hossain, BIS, Saskpoly
 */
public class Question1_withSwitchandValidation {

    /**
     * @param args the command line arguments
     */
   public static void main(String[] args) {
       
       // --- Code block to declare variable with initial value
        String name = "No Name Entered";// to declare a string variable named name with initial value "No Name Entered"
        int age = 0;// To declare an integer variable name age with initial value 0
        String favoriteColor = "No Color Entered"; // to declare a string variable named favorite color with initial value "No Color Entered"

        Scanner input;// to declare a scanner method
        input = new Scanner(System.in);// to put the input method inside scanner
        
        boolean isRunning = true;// to declare a boolean variable with initial value true

        System.out.println("--- Welcome to the Person Data Manager ---");// to print a text line before printing menu

        
        //---------------------------------------------------------
        // code block display menu
        while (isRunning) {// to run while loop untill the boolean variable isRunning value is true

            
            System.out.println("\n=============================");// to print a dash line before menu
           //---------------------------------------------------------
            System.out.println("Current User: Name: " + name + ", Age: " + age + ", Color: " + favoriteColor);
            System.out.println("--- Main Menu ---");
            System.out.println("1. Change name");
            System.out.println("2. Change age");
            System.out.println("3. Change favorite color");
            System.out.println("4. Display all information");
            System.out.println("5. Exit");
            System.out.println("-----------------");
            System.out.print("Enter your choice (1-5): ");

            // --------------------------
            int choice = -1; // Default to an invalid choice

            // to check user input a integer value for Menu Choice  ***
            if (input.hasNextInt()) {//method to check user input is integer
                choice = input.nextInt();// to store choice value if the user input is integer
                input.nextLine(); // Consume the newline character left by nextInt()
            } else {// check user input is not integer
                System.out.println("Invalid input type for menu choice. Please enter a number.");// to print error message if user input is not integer
                input.nextLine(); // Consume the invalid token to clear the buffer
                // choice remains -1, which is handled by the default case below
            }

            // code block to check to choice from user
            switch (choice) {
                case 1: // to check if option 1 is selected to change Name
                    System.out.print("Enter the new name: ");
                    String newName = input.nextLine().trim();

                    if (!newName.isEmpty()) {
                        name = newName;
                        System.out.println("Name successfully updated to: " + name);
                    } else {
                        System.out.println("Name cannot be empty. Update failed.");
                    }
                    break;

                case 2: // to check if option 2 is selected to change Age
                 
                    boolean validAgeEntered = false;// to declare a boolean variable to use a while loop for age validation, relying on hasNextInt()
                    
                    while (!validAgeEntered) {// to run while loop to check the age is a valid whole number
                        System.out.print("Enter the new age (positive whole number, e.g., 30): ");// print error message if age is not whole number

                        if (input.hasNextInt()) {//to run a if condition to check user input age integer
                            int newAge = input.nextInt();
                            input.nextLine(); // Consume newline after reading age

                            if (newAge >= 0 && newAge < 150) {// to check user input newAge is within a set range
                                age = newAge;// to update age with newAge if it comply all condition 
                                System.out.println("Age successfully updated to: " + age);// to print message for user that age updated
                                validAgeEntered = true; // to change boolean variable value into true to exit the while loop
                            } else {//to check the age does not comply above validation conditions
                                System.out.println("Invalid age. Please enter a non-negative number (up to 149).");
                            }
                        } else {
                            System.out.println("Invalid input type. Please enter a whole number for age.");
                            input.nextLine(); // Consume the invalid token (prevents infinite loop)
                        }
                    }
                    break;

                case 3: //to check if option 3 is selected to change favorite color
                    System.out.print("Enter the new favorite color: ");
                    String newColor = input.nextLine().trim();

                    if (!newColor.isEmpty()) {// to check if the user left this value not empty
                        favoriteColor = newColor;// update favorite color if the user input is valid
                        System.out.println("Favorite color successfully updated to: " + favoriteColor);// to print update message with udpate value
                    } else {// to check user input is empty
                        System.out.println("Color cannot be empty. Update failed.");// to print error message that user left this field empty
                    }
                    break;

                case 4: // to check if option 4 is selected to to print all the updated informations
                    System.out.println("\n--- Current Person Information ---");
                    System.out.println("Name: " + name);
                    System.out.println("Age: " + age);
                    System.out.println("Favorite Color: " + favoriteColor);
                    System.out.println("----------------------------------");
                    break;

                case 5: // to check if option 5 is selected to Exit
                    isRunning = false; // Gracefully set flag to false to exit the main loop
                    System.out.println("Exiting the application. Goodbye!");
                    break;

                default:// to check if user select any values out of the given range 1-5
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
                    break;
            }
        }
        input.close();// to close input method
    }
}
