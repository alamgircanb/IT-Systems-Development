/*
 4. Write an application that plays “guess my height” as follows: Your program chooses a random number
between 100cm and 200cm. The player inputs a first guess. Use a method to get the input (hint: declare a
scanner inside the method). The method should only return valid input. If the guess is incorrect, the
program should display “Too short, guess again” or “To tall, guess again” to help the player zero in on the
correct value. The program should prompt the user for the next guess. When the user enters the correct
answer, display “Congratulations, you guessed my height”, and allow the user to choose whether to play
again
 */
package pkg4.guessheight4.guessHeight;

import java.util.Scanner;// to import scanner class from utility library
import java.util.Random;//  to import random class from utility library 

public class GuessHeight {

    private static final int MIN_HEIGHT = 100;
    private static final int MAX_HEIGHT = 200;

    public static void main(String[] args) {

        Scanner input;// to declare a method named input inside scanner to use a single Scanner for all user input
        input = new Scanner(System.in);
        boolean playAgain;// to declare a boolean variable named playAgain to control do while loop

        System.out.println("Welcome to the Guess My Height Game!");
        System.out.printf("I am thinking of a height between %dcm and %dcm.\n\n", MIN_HEIGHT, MAX_HEIGHT);

        do {
            playGame(input);

            // Ask the user if they want to play again
            System.out.print("\nDo you want to play again? (yes/no): ");// to prompt user if want to continue the loop
            String playAgainInput = input.nextLine().trim().toLowerCase(); // to declare a string variable named playAgainInput to store the string input inside 
            playAgain = playAgainInput.startsWith("y");

            if (playAgain) {// to set a condition if your choose yes to play again
                System.out.println("\n--- Starting a new game! ---");
            }
        } while (playAgain);

        System.out.println("\nThanks for playing! Goodbye.");// to prompt user if select no more play
        input.close(); // to close input method
    }

    /*
     * @param inputScanner The Scanner object used for reading user input.
     */
    static void playGame(Scanner inputScanner) {
        Random random = new Random();
        int targetHeight = random.nextInt(MAX_HEIGHT - MIN_HEIGHT + 1) + MIN_HEIGHT;

        int guess = 0;
        int guessCount = 0;

        while (guess != targetHeight) {
            guessCount++;

            String prompt = String.format("Guess %d. Enter your height guess (between %d and %d): ",
                    guessCount, MIN_HEIGHT, MAX_HEIGHT);// to prompt user to ensure that the input is a valid number in the range.
            guess = getValidGuess(prompt, inputScanner);

            // --- Game Logic Feedback (Too short/Too tall) is handled here ---
            if (guess < targetHeight) {
                System.out.println("Too short, guess again.");// to print Too short message if the guess is smaller than target
            } else if (guess > targetHeight) {
                System.out.println("Too tall, guess again.");// to print Too tall message if the guess is bigger than target
            }
        }

        System.out.printf("\n You guessed my height of %dcm in %d guesses! \n",
                targetHeight, guessCount);// to print the target height and the guess count
    }
   
    static int getValidGuess(String prompt, Scanner inputScanner) {
        int guess = -1;
        boolean isValid = false;

        // Loop until a valid guess is received
        while (!isValid) {
            System.out.print(prompt);

            if (inputScanner.hasNextInt()) {
                guess = inputScanner.nextInt();
                inputScanner.nextLine(); // Consume the newline

                // Validate the input against the game's range
                if (guess >= MIN_HEIGHT && guess <= MAX_HEIGHT) {
                    isValid = true; // Input is valid (correct type AND in range)
                } else {
                    // Feedback for out-of-range input
                    System.out.printf("Please enter a number between %d and %d.\n", MIN_HEIGHT, MAX_HEIGHT);
                }
            } else {
                // Feedback for non-integer input
                System.out.println("Please enter a whole number");
                inputScanner.nextLine(); // Consume the invalid, non-integer input
            }
        }
        return guess;
    }
}
