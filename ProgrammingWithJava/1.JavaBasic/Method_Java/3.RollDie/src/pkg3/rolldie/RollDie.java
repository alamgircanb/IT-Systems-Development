/*
 4. Write an application that plays “guess my height” as follows: Your program chooses a random number
between 100cm and 200cm. The player inputs a first guess. Use a method to get the input (hint: declare a
scanner inside the method). The method should only return valid input. If the guess is incorrect, the
program should display “Too short, guess again” or “To tall, guess again” to help the player zero in on the
correct value. The program should prompt the user for the next guess. When the user enters the correct
answer, display “Congratulations, you guessed my height”, and allow the user to choose whether to play
again.
 */
package pkg3.rolldie;

import java.util.Scanner;
import java.util.Random;

public class RollDie {

    // Individual variables to store the count for each die face (1 through 6).
    static int countFace1 = 0;
    static int countFace2 = 0;
    static int countFace3 = 0;
    static int countFace4 = 0;
    static int countFace5 = 0;
    static int countFace6 = 0;

    // Total number of rolls performed in the simulation
    static int totalRolls = 0;

    /**
     * Simulates the rolling of a six-sided die.
     *
     * @return A random integer between 1 and 6 (inclusive).
     */
    public static int roll() {
        // We use a new Random object here for simplicity.
        Random random = new Random();

        // nextInt(6) generates numbers from 0 to 5.
        // Adding 1 shifts the range to 1 to 6 (the die faces).
        return random.nextInt(6) + 1;
    }

    /**
     * Displays the current frequency of each die face rolled by manually
     * calculating and printing the results for all six faces.
     */
    public static void displayResults() {
        if (totalRolls == 0) {
            System.out.println("\n--- Results ---");
            System.out.println("No rolls have been made yet.");
            return;
        }

        System.out.println("\n--- Current Roll ---");
        System.out.println("Total Rolls: " + totalRolls);
        System.out.println("---------------------------------");
        System.out.printf("%-10s %-10s %-10s\n", "Face", "Count", "Percentage");
        System.out.println("---------------------------------");

        // Display results for each face manually (without a loop)
        //  to calculate Face 1 percentile
        double percentage1 = (double) countFace1 / totalRolls * 100;
        System.out.printf("%-10d %-10d %-10.2f%%\n", 1, countFace1, percentage1);

        // to calculate Face 2 percentile
        double percentage2 = (double) countFace2 / totalRolls * 100;
        System.out.printf("%-10d %-10d %-10.2f%%\n", 2, countFace2, percentage2);

        // to calculate Face 3 percentile
        double percentage3 = (double) countFace3 / totalRolls * 100;
        System.out.printf("%-10d %-10d %-10.2f%%\n", 3, countFace3, percentage3);

        // to calculate Face 4 percentile
        double percentage4 = (double) countFace4 / totalRolls * 100;
        System.out.printf("%-10d %-10d %-10.2f%%\n", 4, countFace4, percentage4);

        // to calculate Face 5 percentile
        double percentage5 = (double) countFace5 / totalRolls * 100;
        System.out.printf("%-10d %-10d %-10.2f%%\n", 5, countFace5, percentage5);

        // to calculate Face 6 percentile
        double percentage6 = (double) countFace6 / totalRolls * 100;
        System.out.printf("%-10d %-10d %-10.2f%%\n", 6, countFace6, percentage6);

        System.out.println("---------------------------------");
    }

    public static void main(String[] args) {
        // Renamed the Scanner variable from 'scanner' to 'input'
        Scanner input;
        input = new Scanner(System.in);
        int choice = 0;

        System.out.println("Welcome to the Dice Rolling Simulator!");

        while (choice != 3) {   // to run a loop to prompt user option on main menu
            System.out.println("\nMenu Options:");
            System.out.println("1. Roll Die");
            System.out.println("2. Display Results");
            System.out.println("3. Exit Program");
            System.out.print("Enter your choice: ");

            if (input.hasNextInt()) {// Input handling using the 'input' variable
                choice = input.nextInt();

                switch (choice) {
                    case 1:
                        // 1. Roll the die
                        int result = roll();

                        // 2. Update the total rolls count
                        totalRolls++;

                        // 3. Update the frequency count using a switch statement
                        //    instead of array indexing.
                        switch (result) {// to count the each face when it show in the random variable
                            case 1:
                                countFace1++;
                                break;
                            case 2:
                                countFace2++;
                                break;
                            case 3:
                                countFace3++;
                                break;
                            case 4:
                                countFace4++;
                                break;
                            case 5:
                                countFace5++;
                                break;
                            case 6:
                                countFace6++;
                                break;
                        }

                        System.out.println("\n--- Die Rolled! ---");
                        System.out.println("Result: " + result);// to print the result
                        break;

                    case 2:

                        displayResults();     // Display the current statistics
                        break;

                    case 3:

                        System.out.println("\nExiting program. Final results:");
                        displayResults();        // to Exit the loop
                        System.out.println("Thank you for using the Dice Rolling Simulator!");
                        break;

                    default:
                        System.out.println("Invalid choice. Please enter 1, 2, or 3.");
                        break;
                }
            } else {
                System.out.println("Invalid input. Please enter a number.");
                // Consume the invalid input to prevent an infinite loop
                input.next();
            }
        }

        input.close();         // Close the 'input' scanner
    }
}
