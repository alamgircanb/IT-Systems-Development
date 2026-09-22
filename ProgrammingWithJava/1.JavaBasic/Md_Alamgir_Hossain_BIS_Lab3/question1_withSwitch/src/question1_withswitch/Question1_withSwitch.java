/* 
    *Question_1: A menu-based application to manage a person's name, age, and favorite
     * color. This version contains NO input validation and assumes correct input
     * types and non-empty strings.
        Use loops to create a repeating menu
      *Use decision operators to cleanly separate the code for each menu option
       *Create your code in such a way that menu options can effect the functionality or data in other menu options
  *Use well crafted loop conditions to ensure your application will exit without the need for breaks, continues, or exits

 */
package question1_withswitch;

import java.util.Scanner;

/**
 *
 * @author Md Alamgir Hossain
 */
public class Question1_withSwitch {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // code block to declare variable with initial value---
        String name = "No Name Entered";
        int age = 0;
        String favoriteColor = "No Color Entered";

        Scanner input; // to declare a method named input inside scanner
        input = new Scanner(System.in);

        boolean isRunning = true;// to declare a boolean variable named isRunning with initial value true

        System.out.println("--- Welcome to the Person Data Manager ---");// to print a text line before menu

        while (isRunning) {// to run while loop until isRunning variable value is true

            // code block display menu ---
            System.out.println("\n=============================");
            System.out.println("Current User: \nName: " + name + ",\nAge: " + age + ",\nColor: " + favoriteColor);
            System.out.println("--- Main Menu ---");
            System.out.println("1. Change name");
            System.out.println("2. Change age");
            System.out.println("3. Change favorite color");
            System.out.println("4. Display all information");
            System.out.println("5. Exit");
            System.out.println("-----------------");
            System.out.print("Enter your choice (1-5): ");

            //----------------------- ---
            int choice = input.nextInt();// to declare a integer variable named choice inside input method
            input.nextLine(); // Consume the newline left by nextInt()

            // --- 3. Logic Control (switch statement) ---
            switch (choice) {// to start switch loop with choice value check
                case 1: // to check if option 1 selected to Change Name
                    System.out.print("Enter the new name: ");
                    String newName = input.nextLine();
                    name = newName;
                    System.out.println("Name successfully updated to: " + name);
                    break;

                case 2: // to check if option 2 selected to change Age
                    System.out.print("Enter the new age (whole number): ");
                    int newAge = input.nextInt();
                    input.nextLine(); // Consume newline after reading age
                    age = newAge;
                    System.out.println("Age successfully updated to: " + age);
                    break;

                case 3: // to check if option 3 selected to change favorite color
                    System.out.print("Enter the new favorite color: ");
                    String newColor = input.nextLine();
                    favoriteColor = newColor;
                    System.out.println("Favorite color successfully updated to: " + favoriteColor);
                    break;

                case 4: // to check if option 4 selected to display all information
                    System.out.println("\n--- Current Person Information ---");
                    System.out.println("Name: " + name);
                    System.out.println("Age: " + age);
                    System.out.println("Favorite Color: " + favoriteColor);
                    System.out.println("----------------------------------");
                    break;

                case 5: // to check if option 5 selected to exit the program
                    isRunning = false; // to change boolean variable isRunning to set flag to false to exit the main loop
                    System.out.println("Exiting the application. Goodbye!");// to print goodbye message
                    break;

                default:

                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");  // Handles out-of-range menu numbers
            }
        }

        input.close();// to close input method
    }
}

    //I used swith loop with break in this code
