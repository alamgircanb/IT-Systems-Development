/*
+--------------------------------------------------------------------------------------+
|                                   MovieRentalApp                                     |
+--------------------------------------------------------------------------------------+
| // Static Resources                                                                   |
| - scanner: Scanner (static)                      «shared for all input operations»    |
| - account: RentalAccount (static)                «single composed account instance»   |
+--------------------------------------------------------------------------------------+
|                                      main()                                          |
+--------------------------------------------------------------------------------------+
| + main(args:String[]): void                                                           |
|   «application entry point; forces account creation; runs main menu loop»             |
+--------------------------------------------------------------------------------------+
|                               Private Helper / UI Methods                             |
+--------------------------------------------------------------------------------------+
| - displayMenu(): void                                                                 |
|   «prints the main menu options to the console»                                       |
|--------------------------------------------------------------------------------------|
| - createAccount(): void                                                               |
|   «prompts user for ID and names; instantiates RentalAccount»                         |
|--------------------------------------------------------------------------------------|
| - editAccountInfo(): void                                                             |
|   «allows user to edit firstName, lastName, or accountID via setters»                 |
|--------------------------------------------------------------------------------------|
| - rentMovie(): void                                                                   |
|   «finds first empty slot (9999), collects movie data, calls account.rentMovie()»     |
|--------------------------------------------------------------------------------------|
| - dropMovie(): void                                                                   |
|   «asks user for movie ID and calls account.dropMovieByID()»                          |
+--------------------------------------------------------------------------------------+

 */
package MovieRentalApp;

import java.util.Scanner;// to call scanner class from java utility library

/**
 * CLASS: MovieRentalApp Client Class / Driver Program (The Application Driver /
 * Presentation Layer). To manage the console User Interface (UI), handle user
 * input, and control the application flow. It interacts with the business logic
 * layer (RentalAccount) by calling its public methods.
 */
public class MovieRentalApp {// to start a public class

    // --- STATIC RESOURCES (Shared by ALL application instances) ---
    /**
     * Scanner object for reading user input from the console. Essential utility
     * for handling all standard input.
     */
    private static Scanner scanner = new Scanner(System.in);// to declare a private scanner object 

    /**
     * A single instance of the RentalAccount, representing the active customer
     * account. To hold the state and logic for the currently managed account.
     * Initialized to null.
     */
    private static RentalAccount account = null;

    /**
     * This is the the entry point of the application, out main class. to set up
     * the initial account and run the main menu loop. This class will be Called
     * by: Java Runtime Environment.
     *
     * @param args
     * @param
     */
    public static void main(String[] args) {// create main method with public access level

        System.out.println("Welcome to the COMP117 Movie Rental Management System!");// to print a text line (welcome message at the very beginning

        // MANDATORY: Force account creation before entering the main loop.
        while (account == null) {// check if the account has any value in it and start while loop
            System.out.println("\nPlease create an account to start.");// to prompt user to create an account
            createAccount(); // to call createAccount method-it will prompt user for ID and names; (instantiate RentalAccount 
        }

        boolean running = true;// to declare a boolean variable (to create a flag) to use in below while method to keep running menu
        while (running) {//to run a while loop to take a keyboard input from your to keep the menu display running

            displayMenu();//  to call the displayMenue method and will display the menu for customer to make choice

            // Input validation check
            if (!scanner.hasNextInt()) {// to check validity of the  input collected from user for option 
                System.out.println("\n! Invalid input. Please enter a number 1-6.");// to print an error message if the input is invalid
                scanner.next(); // Consume invalid input
                continue;
            }

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            switch (choice) {
                case 1:
                    account.displayAccountInfo();// to call displayAccountInfo() method from the RentalAccount if the option 1 is selected
                    break;
                case 2:
                    editAccountInfo();           // to call editAccountInfo() method if user input is 2
                    break;
                case 3:
                    rentMovie();                // to call rentMovie() method if user selects option 3
                    break;
                case 4:
                    dropMovie();                // to call dropMovie() method if the user input is 4
                    break;
                case 5:
                    account.printAllRentedMovies();             // to call printAllRentedMovies() from RentalAccount if user option is 5
                    break;
                case 6:
                    System.out.println("\nThank you for using the " + RentalAccount.getStoreName() + " system. Program exiting. See you later");//to print text (thanks message) line with getter method to show store name
                    running = false;            // to stop switch when user input is 6
                    break;
                default:
                    System.out.println("\n Invalid option. Please choose a number from the menu (1-6).");    // to print invalide message if the user input is other then 1-6
            }

            if (running) {                       // to pause before returning to the menu, and prompt user to enter menu option
                System.out.println("\nPress ENTER to continue to the main menu...");// to print a message or text line if the menu is running
                scanner.nextLine();
            }
        }
        scanner.close();// to closse the scanner 
    }

    /**
     * To Display the main menu options to the console. to provide navigational
     * guidance for the user. This method will be called by: main()
     */
    private static void displayMenu() {

        System.out.println("=====================================");// to print a text line
        System.out.println("\n\n--- Main Menu ---");               // to print a text line (Menu name)
        System.out.println("1. Display Account Information");      // to print a text line to show option 1
        System.out.println("2. Edit Account Information");         // to print a text line to show option 2

        System.out.println("3. Rent a Movie (Enter unique ID)");   // to print a text line to show option 3
        System.out.println("4. Drop/Return a Movie");              // to print a text line to show option 4
        System.out.println("5. Display Rented Movies List");       // to print a text line to show option 5
        System.out.println("6. Exit Program");                     // to print a text line to show option 6
        System.out.println("\n======================================");// to print a text line, it is just ornamental

        System.out.print("Enter your choice (1-6): ");             //to print a text line to prompt user to give a valid input

    }

    /**
     * Gathers required inputs (ID, first name, last name) and instantiates the
     * RentalAccount object. Factory method pattern for creating the Model
     * instance. This method will be called by: main()
     */
    private static void createAccount() {                  // to create a private access level static method with void type named createAccount
        System.out.println("\n Create New Account ---");   // to print a text line to user about a new account creation

        System.out.print("Enter Account ID (int): ");      // to prompt user to give a ID
        int id = 0;                                        // to declare an integer variable named id with initial value zero
        // Basic input validation for ID
        if (scanner.hasNextInt()) {                         //to check the validity of the input collected by scanner
            id = scanner.nextInt();                         // to store user input into id variable
        } else {
            System.out.println("Invalid ID format. Using 0.");// to print user for invalid ID input
            scanner.next();                                   // Consume invalid token
        }
        scanner.nextLine();                                   // Consume newline after int input

        System.out.print("Enter First Name: ");               // to prompt user to enter First Name
        String fName = scanner.nextLine();                    //to store user input into fName variable

        System.out.print("Enter Last Name: ");                //to prompt user to enter Last Name
        String lName = scanner.nextLine();                    //to store user input into lName variable

        // DELEGATION: Instantiates the RentalAccount object (the Model)
        account = new RentalAccount(id, fName, lName);        //to instantiate the RentalAccount object

        // Calls: RentalAccount.getFullNameFormatted() & RentalAccount.getStoreName() (static)
        System.out.println("\nAccount created successfully for " + account.getFullNameFormatted() + " at " + RentalAccount.getStoreName() + ".");
    }                                                        // to print message with two getters method to display full user name and store name

    /**
     * to handle the submenu logic for editing the customer's identity fields
     * (First Name, Last Name, Account ID). to allows mutation of mutable,
     * non-critical state fields via public setters. it will be called by:
     * main()
     */
    private static void editAccountInfo() {
        System.out.println("\n--- Edit Account Information ---");                        // to print a text line (Menu name)

        System.out.println("1. Edit First Name (Current: " + account.getFirstName() + ")");//to call getter from RentalAccount to show first name as a option
        System.out.println("2. Edit Last Name (Current: " + account.getLastName() + ")");  //to call getter from RentalAccount to show last name as a option
        System.out.println("3. Edit Account ID (Current: " + account.getAccountID() + ")");//to call getter from RentalAccount to account id as a option
        System.out.print("Enter field to edit (1-3) or 0 to cancel: ");                    // to take user input to select any of the above options.

        int editChoice;                                                                  // to declare an integer variable to store the user input collected from previous line
        if (scanner.hasNextInt()) {                                                      // to check user input validity and store the value to editChoice variable
            editChoice = scanner.nextInt();                                              //to store the user input in editChoice variable
        } else {                         // to check if the user input is not valid
            scanner.next();
            System.out.println(" Invalid input. Returning to menu.");// to print a text line showing invalid input message to prompt user to return to menu
            return;
        }
        scanner.nextLine(); // to consume newline

        switch (editChoice) {// to start a switch control
            case 1:
                System.out.print("Enter new First Name: ");// to prompt user to enter new first name if option 1 selected
                account.setFirstName(scanner.nextLine());// to call RentalAccount.setFirstName() to update first name
                System.out.println("First name updated.");// to print a text line that first name is updated
                break;

            case 2:
                System.out.print("Enter new Last Name: ");//to prompt user to enter new last name if option 2 is selected 

                account.setLastName(scanner.nextLine());// to call RentalAccount.setLastName() to update last name
                System.out.println("Last name updated.");// to print a text line that first name is updated
                break;

            case 3:
                System.out.print("Enter new Account ID (int): ");// to prompt user to enter new Account ID if option 3 selected
                if (scanner.hasNextInt()) {//to  check the validity if the user input is integer

                    account.setAccountID(scanner.nextInt());// to call RentalAccount.setAccountID() to update Account ID
                    System.out.println("Account ID updated.");// to print a message line that will confirm user that Account ID is updated
                } else {
                    System.out.println(" Invalid ID format. Change is not possible.");// to prompt user message if the input is not valid
                    scanner.next(); // to consume invalid token
                }
                scanner.nextLine(); // to consume newline
                break;
            case 0:
                System.out.println("Editing cancelled.");// to cancel (break) edit option if user select 0 that means user are not interested to change any information
                break;
            default:
                System.out.println(" Invalid choice.");// to print a default message if no above option is selected
        }
    }

    /**
     * Searches for the index of the first available (9999/empty) rental slot.
     * Used to find the position for the new movie data. This method will be
     * called by: rentMovie()
     *
     * @return The index of the first available slot (0 to 4), or -1 if the
     * rental limit is reached.
     */
    private static int findNextAvailableSlot() {// to retrun array reference address with default value 9999
        // Reads a COPY of the private array state via public accessors for safe searching
        int[] movieIDs = account.getMovieIDs();// to declare integer type array named movieIDs by calling getter method from RentalAccount class
        int arraySize = account.getArraySize();//to declare integer type variable named arraySize by calling getter method (to get fixed size 5) from RentalAccount class
        int emptyMarker = account.getEmptySlotMarker(); //to declare integer type variable by calling getter method to retrieve the 9999 constant

        for (int i = 0; i < arraySize; i++) {// to start a for loop to create an array with movieIDs
            // Check for the 9999 marker
            if (movieIDs[i] == emptyMarker) { // check if the movieID is with emptyMarker (9999)
                return i;// to return reference address if the movieID is equal to emtyMarker (9999)
            }
        }
        return -1; // to return if Rental limit reached
    }

    //=============================================================================================================================
    /**
     * to manage the movie rental process, prompting the user for a unique ID
     * and movie title. to Encapsulate the transactional logic of renting a
     * movie, including input validation. it will be called by: main() (in
     * switch Case 3) if user select option 3
     */
    private static void rentMovie() {// to create a method with private access to work with movie rent
        System.out.println("\n Rent Movie ---");// to print a text line about rent movie

        int availableSlot = findNextAvailableSlot();// to declare an integer variable named availableSlot with the value from findNextAvailableSltot for available movie ID

        if (availableSlot == -1) {// to pre-check for maximum rental limit
            // it will call RentalAccount.getArraySize() to check maximum array size
            System.out.println(" Cannot rent: Account has reached maximum rental limit (" + account.getArraySize() + " movies).");// to prompt message if the account reached max limit
            return;
        }

        // 1. Get a unique Movie ID from the user
        int uniqueMovieId = -1;// to declare an integer variable named uniqueMovieId with -1 initialization,(-1 can not be a value of it)
        boolean isUnique = false;

        // to use accessor/getter methods to check uniqueness against existing IDs
        int[] existingIDs = account.getMovieIDs();// to create an array by calling a getter (array method) from RentalAccount
        int emptyMarker = account.getEmptySlotMarker();//to declare an integer variable to take empty stlo marker from RentalAccount

        while (!isUnique) {//to run a while loop until isUnique value is not false (true)
            System.out.print("Enter the UNIQUE Integer Movie ID (Must not be 9999): ");// to prompt user to enter Movie ID other than 9999

            if (!scanner.hasNextInt()) {// to check if the user input is invalid number
                System.out.println("! Invalid input. Please enter a valid integer ID.");// to prompt a message if the user id is invalid
                scanner.nextLine();
                continue;// loop will go to while condition and loop again
            }

            uniqueMovieId = scanner.nextInt();// to store the user input in the variable named uniqueMovieId
            scanner.nextLine(); // to consume newline

            isUnique = true;// to terminate the loop and exit. It will accept the user input as valid

            // it is to prevent using the reserved empty marker (9999) as a movie ID
            if (uniqueMovieId == emptyMarker) {// to check if the uniqueMovieID means user input id is equal to emptyMarker (9999)
                System.out.println("Error: ID " + uniqueMovieId + " is reserved (default Marker) for system use. Please enter a different ID.");// to print a error message if the above condition meets
                isUnique = false;// as we need another input from user, so we will keep it false to loop again
                continue;// if condition match it will go while condition and loop again
            }

            // Check against currently rented IDs and loop through array to check every existing ids
            for (int id : existingIDs) {// to start a for loop to check every items in the existing movie Id
                if (id == uniqueMovieId) {// to check any existing movie id matches with user input new movie id
                    System.out.println(" Error: Movie ID " + uniqueMovieId + " is already rented. Please enter a different ID.");// to print a error message if the new id is not unique
                    isUnique = false;// to change boolean flag value into false
                    break;// exit from the loop
                }
            }

            if (isUnique) {// to check if the user input id is unique and does not meet above two condition
                System.out.println("Movie ID " + uniqueMovieId + " accepted.");// to print a message that movie Id has been accepted
            }
        }

        // 2. Get Movie Title from user
        System.out.print("Enter Movie Title: ");// to prompt user to give a movie titles
        String title = scanner.nextLine();// to store movie titles in title variable

        // to Pass the found slot index, the unique integer ID, and data to the RentalAccount
        // it will Call RentalAccount.rentMovie()
        if (account.rentMovie(availableSlot, uniqueMovieId, title)) {

            System.out.printf("\nSUCCESS: Rented '%s' into slot %d. ID: %d. New balance: $%.2f%n",
                    title, availableSlot, uniqueMovieId, account.getBalanceOwed()); // to print SUCCESS message by calling RentalAccount.getBalanceOwed()
        } else {
            // FAILURE due to unexpected array state
            System.out.println("\n! RENTAL FAILED: Slot was unexpectedly occupied or invalid.");// to print FAILED message if the rent movie is not successfull
        }
    }

    //===================================================================================================================
    /**
     * to Manage the movie return input and delegation process. to facilitate
     * the return of a movie by its unique ID. it will be called by: main() (in
     * switch Case 4)
     */
    private static void dropMovie() {// to declare a private access class with void type
        account.printAllRentedMovies(); // to display current rentals first for user reference

        System.out.println("\n Drop/Return Movie ---");// to print a text line on menu name
        System.out.print("Enter the UNIQUE Integer Movie ID to return: ");// to prompt user to give a valid movie id

        if (!scanner.hasNextInt()) {// to check the validity of the movie id
            System.out.println("Invalid input. Please enter a valid integer ID.");// to print an invalid message if the movie id is not valid
            scanner.nextLine(); // to consume the newline
            return;
        }
        int idToDrop = scanner.nextInt();// to store the droped movie id in the variable named idToDrop
        scanner.nextLine(); // to consume newline

        // to Pass the ID to the RentalAccount object for processing (search, reset, and balance update).
        // it will call RentalAccount.dropMovieByID()
        if (account.dropMovieByID(idToDrop)) {// to call dropMovieByID method from RentalAccount to update drop movie by taking idToDrop variable as parameter

            System.out.printf("\nSUCCESS: Movie with ID %d has been returned. New balance: $%.2f%n",
                    idToDrop, account.getBalanceOwed());// to print SUCCESS message by calling RentalAccount.getBalanceOwed()
        } else {

            System.out.println("\n! RETURN FAILED: Movie ID " + idToDrop + " not found in your rentals."); // to print a FAILURE (ID not found) message
        }
    }
}
