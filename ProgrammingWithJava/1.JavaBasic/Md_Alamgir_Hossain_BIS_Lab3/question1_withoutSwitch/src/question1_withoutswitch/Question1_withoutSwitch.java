/*
   *Question_1: A menu-based application to manage a person's name, age, and favorite
     * color. This version contains NO input validation and assumes correct input
     * types and non-empty strings.
        Use loops to create a repeating menu
      *Use decision operators to cleanly separate the code for each menu option
       *Create your code in such a way that menu options can effect the functionality or data in other menu options
  *Use well crafted loop conditions to ensure your application will exit without the need for breaks, continues, or exits

 */
package question1_withoutswitch;

import java.util.Scanner;// import scanner utility 

/**
 *
 * @author Md Alamgir Hossain, BIS, Saskpoly
 */
public class Question1_withoutSwitch {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // --code block to declare variable with initial value ---
        String name = "No Name Entered Yet"; //to declare a string variable named name to store name with a initial value"No Name Entered yet"
        int age = 0;// to declare a integer variable to store the age from user with an inital value "0"
        String favoriteColor = "No Color Entered Yet"; // to declare a string variable named favoriteColor with an initial value " No color entered yet"

        Scanner input;// to delcare a scanner variable named input 
        input = new Scanner(System.in);// to declare a variable named input inside Scanner
        boolean isRunning = true; //to declare a boolean variable to create a flag to control the main application loop.

        System.out.println("--- Welcome to the Person Data Manager ---");// to print a opening line for menu

        // --- 2. Main Application Loop ---
        while (isRunning) {// to start a while loop till the isRunning boolean value is true.

            // Code block to display the initial value and the menu for user.
            System.out.println("\n=============================");
            System.out.println("Current User: \nName: " + name + ",\nAge: " + age + ",\nColor: " + favoriteColor);
            System.out.println("--- Main Menu ---");
            System.out.println("1. Change name");
            System.out.println("2. Change age");
            System.out.println("3. Change favorite color");
            System.out.println("4. Display all information");
            System.out.println("5. Exit");
            System.out.println("-----------------");
            //-----------------------------------------
            System.out.print("Enter your choice (1-5): ");

            int choice = input.nextInt();  // to declare an integer variable named choice to collect choice from user.
            input.nextLine(); // Consume the newline left by nextInt()

            // --- ---------------------------------------
            //---Code block to check the choice
            if (choice == 1) { // check the condition if user select menu option 1
                System.out.print("Enter the new name: ");// to prompt user to enter the name if user select menu option 1
                String newName = input.nextLine(); // to declare a sting variable named newName to store uer 
                name = newName;// to update value of name variable with the value from newName.
                System.out.println("Name successfully updated to: " + name);// to prompt user that value has been updated
            } else if (choice == 2) { // to check the condition if user select menu option 2
                System.out.print("Enter the new age (whole number): ");//to prompt user to enter the name if user select menu option 2
                int newAge = input.nextInt();// to declare a integer variable named newAge inside input method to store user provided age input
                input.nextLine(); // Consume newline after reading age

                if (newAge >= 0 && newAge < 150) {// to check user input is greater than zero and smaller than 150
                    age = newAge;// to update age value with newAge value
                    System.out.println("Age successfully updated to: " + age);// to print update message and updated value of age
                } else {
                    System.out.println("Invalid age. Please enter a non-negative number (up to 149).");// to print error message if the age value is not greater than 0 and smaller than 150 years
                }
            } else if (choice == 3) { // to check the condition if user select menu option 3
                System.out.print("Enter the new favorite color: "); //to prompt user to enter new favorite color
                String newColor = input.nextLine(); // to declare a string variable named newColor inside input method
                favoriteColor = newColor;//to update favorite color the new color given by the user
                System.out.println("Favorite color successfully updated to: " + favoriteColor);// to print update message and update value of favorite color variable
            } else if (choice == 4) { //to check the condition if user select menu option 4
                System.out.println("\n--- Current Person Information ---");// to print a line before updated information printed
                System.out.println("Name: " + name);// to print updated name
                System.out.println("Age: " + age);// to print updated age
                System.out.println("Favorite Color: " + favoriteColor);// to print updated favorite color
                System.out.println("----------------------------------");// to print a dashline after all information printed
            } else if (choice == 5) { // to check the condition if user select menu option 4
                isRunning = false; // to set flag to false to exit the main loop as user chose option 4 to exit from the loop
                System.out.println("Exiting the application. Goodbye!");// to print the goodbye message when user chose to exit and select option 4
            } else {
                System.out.println("Invalid choice. Please enter a number between 1 and 5.");// to handles the error if user select options other than 1-5
            }
        }

        input.close();//to close input method
    }
}

// In this code, I intentionally avoided the use of switch, break, contiue, exit or validation as per instructions.

