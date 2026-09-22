/**
+--------------------------------------------------------------------------------------+
|                                   RentalAccount                                      |
+--------------------------------------------------------------------------------------+
| // Static Constants (Shared Across All Accounts)                                      |
| - STORE_NAME: String (static final)      «store title for all accounts»               |
| - RENTAL_PRICE: double (static final)    «fixed price per rented movie»               |
+--------------------------------------------------------------------------------------+
| // Private Instance Fields                                                             |
| - accountID: int                                                                       |
| - firstName: String                                                                    |
| - lastName: String                                                                     |
| - balanceOwed: double                                                                  |
+--------------------------------------------------------------------------------------+
| // Composition: Parallel Arrays (Fixed Size = 5)                                       |
| - arraySize: int (final)                                                               |
| - movieIDs: int[5]            «each default = 9999»                                    |
| - movieTitles: String[5]      «each default = "NoMovie"»                               |
+--------------------------------------------------------------------------------------+
|                                     Constructor                                        |
+--------------------------------------------------------------------------------------+
| + RentalAccount(accountID:int, firstName:String, lastName:String)                      |
|   «initializes customer fields; fills arrays with sentinel defaults»                   |
+--------------------------------------------------------------------------------------+
|                                      Getters                                           |
+--------------------------------------------------------------------------------------+
| + getStoreName(): String (static)                                                      |
| + getAccountID(): int                                                                   |
| + getFirstName(): String                                                                |
| + getLastName(): String                                                                 |
| + getBalanceOwed(): double                                                              |
| + getMovieIDs(): int[]                                                                  |
+--------------------------------------------------------------------------------------+
|                                      Setters                                           |
+--------------------------------------------------------------------------------------+
| + setAccountID(id:int): void                                                            |
| + setFirstName(fName:String): void                                                      |
| + setLastName(lName:String): void                                                       |
+--------------------------------------------------------------------------------------+
|                                   Functional Methods                                   |
+--------------------------------------------------------------------------------------+
| + getFullNameFormatted(): String         «returns: lastName, firstName»                 |
| + printAllRentedMovies(): void           «only prints non-empty movie slots»            |
|--------------------------------------------------------------------------------------|
| + rentMovie(index:int, movieID:int, title:String): boolean                              |
|   «stores data into arrays, calls updateBalance()»                                      |
|--------------------------------------------------------------------------------------|
| + dropMovieByID(idToDrop:int): boolean                                                  |
|   «searches arrays, resets slot to sentinel values, calls updateBalance()»              |
+--------------------------------------------------------------------------------------+
|                               Private Utility Methods                                  |
+--------------------------------------------------------------------------------------+
| - getRentedMovieCount(): int             «counts movieIDs != 9999»                     |
|--------------------------------------------------------------------------------------|
| - updateBalance(): void                  «balanceOwed = (rentedCount × 3.99)»           |
+--------------------------------------------------------------------------------------+

*/

package MovieRentalApp;

import java.text.DecimalFormat;
import java.util.Arrays;

/**
 * CLASS: RentalAccount
 * Server Class / Business Logic Layer (The Model).
 * To define the state (data) and behavior (logic) of a single customer rental account. It strictly enforces Encapsulation by making all data private and controls the critical calculation of 'balanceOwed' internally.
 * NOTE: This class adheres to the strict requirement of using 9999 for empty movie IDs and "NoMovie" for empty movie titles as sentinel markers.
 */
public class RentalAccount {

    // STATIC FINAL PROPERTIES (Shared by ALL accounts)
    
    /**
     * Constant String for the name of the store.
     * to Provide a hardcoded, unchangeable value used in display messages.
     * it will called by Main.main(), Main.createAccount()
     * by declared as static I made it class variable
     */
    private static final String STORE_NAME = "SaskPoly Movies";
    
    /**
     * Constant double for the fixed rental price.
     * to ensure consistent and accurate balance calculation across all transactions.
     * it will be used by updateBalance() method
     * by declared as static I made it class variable
     */
    private static final double RENTAL_PRICE = 3.99;
    
    /**
     * Constant integer value for the empty Movie ID slot.
     * to meet REQUIRED CONSTRAINT: Hardcoded 9999 as the sentinel marker for movieIDs[], mentioned by requirement
     * by declared as static I made it class variable
     */
    private static final int ID_EMPTY_MARKER = 9999;
    
    /**
     * Constant String value for the empty Movie Title slot.
     * to meet REQUIRED CONSTRAINT: Hardcoded "NoMovie" as the sentinel marker for movieTitles[], mentioned by requirement.
     * * by declared as static I made it class variable
     */
    private static final String TITLE_EMPTY_MARKER = "NoMovie";
    
    
    // PRIVATE INSTANCE PROPERTIES (Unique to EACH account - Encapsulation) 
    /**
     * Unique identifier for the account.
     * Private, mutable state field. Can only be changed via the public setter 
     * will be used by setAccountID() called by Main.editAccountInfo().
     */
    private int accountID;
    
    /**
     * Customer's first name.
     * Private, mutable state field. Can only be changed via the public setter 
     * will be used by setFirstName() called by Main.editAccountInfo().
     */
    private String firstName;
    
    /**
     * Customer's last name.
     * Private, mutable state field. Can only be changed via the public setter 
     * will be used by setLastName() called by Main.editAccountInfo().
     */
    private String lastName;
    
    /**
     * The total balance currently owed by the customer.
     * Private, derived state field. CRITICAL: Has NO public setter and is modified
     * will be used only by the private method updateBalance(), enforcing business rules.
     */
    private double balanceOwed; 
    
    
    // Composition: Parallel Arrays (Fixed Size Storage)
    /**
     * The fixed size constraint for the rental arrays.
     * Hardcoded size limit of 5 rentals, meeting project constraints, mentioned by requirement.
     */
    private final int arraySize = 5; 
    
    /**
     * Array storing the ID of each rented movie.
     * Part of the Composition structure. ID 9999 is the sentinel marker for an empty slot.
     * it will be used by: rentMovie(), dropMovieByID(), getMovieIDs(), getRentedMovieCount(), updateBalance()
     */
    private final int[] movieIDs;      
    
    /**
     * Array storing the Title of each rented movie, parallel to movieIDs.
     * Part of the Composition structure. Title "NoMovie" is the sentinel marker for an empty slot.
     * will be used by: rentMovie(), dropMovieByID(), printAllRentedMovies()
     */
    private final String[] movieTitles; 

    /**
     * CONSTRUCTOR
     * Initializes customer details and sets up the required parallel array storage.
     * To create a valid RentalAccount object upon creation (called by Main.createAccount()).
     * @param id The account ID.
     * @param fName The customer's first name.
     * @param lName The customer's last name.
     */
    public RentalAccount(int id, String fName, String lName) {// to create a contructor of the RentalAccount class
        this.accountID = id;// to take the parameter value to accountID variable
        this.firstName = fName; // to take passed value by the fName parameter in firstName variable
        this.lastName = lName;// to take lName parameter passed value in lastName variable
        this.balanceOwed = 0.0;// to initialized balanceOwed variable with 0.0 value.     
        
        // Array Initialization (Composition setup)
        this.movieIDs = new int[arraySize];// to initialize movieIDs array by taking arraySize final variable
        this.movieTitles = new String[arraySize];// to initialize movieTitles array by taking arraySize final vriable value.
        
        // to meet MANDATORY INITIALIZATION: Populate arrays with default "empty" marker values.
        
        Arrays.fill(movieIDs, ID_EMPTY_MARKER);// to use constants for 9999 (ID) 
        Arrays.fill(movieTitles, TITLE_EMPTY_MARKER);//to use constants for "NoMovie" (Title).
    }

    
    // ACCESSORS (Getters/Setters)
    /**
     * Static Getter for the STORE_NAME.
     * to allow the Main class (client) to display the store name without accessing the field directly.
     * it will be called by: Main.main(), Main.createAccount()
     * @return The store name string.
     */
    public static String getStoreName() { return STORE_NAME; }// to create a getter method with return STORE_NAME, STORE_NAME is private in this class.
    
    // Public Getters for private fields (Read-only access)
    public int getAccountID() { return accountID; } // Called by Main.editAccountInfo()
    public double getBalanceOwed() { return balanceOwed; } // Called by Main.displayAccountInfo()
    public String getFirstName() { return firstName; } // Called by Main.editAccountInfo()
    public String getLastName() { return lastName; } // Called by Main.editAccountInfo()
    public int getArraySize() { return arraySize; } // Called by Main.findNextAvailableSlot()
    public int getEmptySlotMarker() { return ID_EMPTY_MARKER; } // Called by Main.findNextAvailableSlot()
    
    // to creae Public Setters (Controlled write access, called by Main.editAccountInfo())
    public void setAccountID(int id) { this.accountID = id; } 
    public void setFirstName(String name) { this.firstName = name; } 
    public void setLastName(String name) { this.lastName = name; } 
    
    /**
     * to provide read access to the internal movieIDs array (returns a COPY).
     * it is necessary for the Main class to perform the client-side logic of finding the next available slot (by searching for the 9999 marker).
     * to return a copy to protect the integrity of the private array state (Encapsulation).
     * will be called by: Main.findNextAvailableSlot()
     * @return A copy of the internal movieIDs array.
     */
    public int[] getMovieIDs() { 
        return Arrays.copyOf(movieIDs, arraySize); 
    } 
    
    /**
     * to Compute property for the customer's full name.
     * to format the private first and last names into the required "LastName, FirstName" format.
     * will be called by: Main.createAccount(), displayAccountInfo()
     * @return The formatted full name.
     */
    public String getFullNameFormatted() {// to return read only value (full name) by adding last name and first name
        return lastName + ", " + firstName;
    }

    
    
    // --- CORE BUSINESS LOGIC ---

    /**
     * to rent a movie by assigning its data to a specific array slot.
     * to delegate the data update logic from the Main class. It ensures array consistency and calls the private balance update method.
     * will be called by: Main.rentMoviePrompt()
     * @param slot The index (0-4) where the movie will be placed (determined by Main).
     * @param id The UNIQUE INTEGER ID of the movie being rented.
     * @param title The title of the movie.
     * @return true if the rental was successful.
     */
    public boolean rentMovie(int slot, int id, String title) {// to declare a boolean type method 
        // Validation check to ensure the slot is valid and actually empty (double-check after Main's check)
        if (slot >= 0 && slot < arraySize && movieIDs[slot] == ID_EMPTY_MARKER) {
            
            // 1. to update the state (Composition array contents)
            movieIDs[slot] = id;
            movieTitles[slot] = title;
            
            // 2. MANDATORY: to recalculate and update the private balance (Encapsulation enforcement).
            updateBalance(); // will Calls private method
            return true;
        }
        return false; 
    }

    /**
     * to drop/return a movie by searching for its ID, resetting the slot, and updating the balance.
     * to delegate the complex logic (search, reset, and balance update) from the Main class,
     * maintaining Encapsulation over the private arrays and balance.
     * will be called by: Main.dropMoviePrompt()
     * @param id The ID of the movie to return.
     * @return true if the ID was found and returned, false otherwise.
     */
    public boolean dropMovieByID(int id) {// to create a boolean type method with integer parameter id.
        // Search all 5 slots
        for (int i = 0; i < arraySize; i++) {// to loop through full array (until arraySize) to check which movieID will be dropped
            if (movieIDs[i] == id) {// to check if any of the value inside movideID array is equal to the method parameter id.
                
                movieIDs[i] = ID_EMPTY_MARKER;// 1. to reset the array slot to default "empty" marker values (9999)
                movieTitles[i] = TITLE_EMPTY_MARKER; // to use reset the array slot "NoMovie" (Title)
                
                // 2. MANDATORY: Recalculate and update the private balance (Encapsulation enforcement).
                updateBalance(); // to call private method updateBalance method to update the rentedMovie balance.
                return true;// will return true if the movie id is found
            }
        }
        return false; // will return false if no Movie ID is found
    }

    
    
    // --- DISPLAY METHODS ---
    /**
     * to print all customer and financial information to the console.
     * to delegate the responsibility of displaying the internal state in a formatted way.
     * will be called by: Main.main() (switch Case 1)
     */
    public void displayAccountInfo() {// to create a public access void method to diplay all user information
        // Dependency: Uses DecimalFormat for standard financial formatting.
        DecimalFormat df = new DecimalFormat("#,##0.00");// to create method for giving currency format (0,000.00) inside DecimalFormat class. 
        System.out.println("====================================");// to print a text line
        System.out.println("\n  Account Details ");// to print menu headline
        System.out.println("Store Name:        " + STORE_NAME);// to print store name
        System.out.println("Account ID:        " + accountID);// to print accountID
        
        // will call: getFullNameFormatted()
        System.out.println("Customer Name:     " + getFullNameFormatted()); // to print customer full name by calling getFullnameFormatted getter method
       
        // will call: getRentedMovieCount() (private)
        int rentedCount = getRentedMovieCount();// to store movie count or number of movie rented by calling getRentedMovieCount() getter method.
        System.out.println("Movies Rented:     " + rentedCount + " / " + arraySize);
        System.out.println("Balance Owed:      $" + df.format(balanceOwed));
        System.out.println("=====================================");
    }

    
    
    /**
     * to print a formatted list of all currently rented movies.
     * to provide the user with a view of the current array contents, filtering out the empty slots.
     * will be called by: Main.main() (switch Case 5)
     */
    public void printAllRentedMovies() {// to create a public access method to print the list of all rented movie
        System.out.println("\n--- Rented Movies List ---");
        int count = 0;
        for (int i = 0; i < arraySize; i++) {
            // it will Only print if the slot is occupied (ID is not the marker 9999)
            if (movieIDs[i] != ID_EMPTY_MARKER) {// to exclude the empty marker id
                System.out.println("Slot " + i + ": ID " + movieIDs[i] + " - " + movieTitles[i]);
                count++;
            }
        }
        
        if (count == 0) {// to check if no movie is rented
            System.out.println("No movies currently rented.");
        }
        System.out.println("Total Rented: " + count + " / " + arraySize);// to print total number of movie rented
    }
    
    
    
    
    // --- PRIVATE UTILITY METHODS (Encapsulation Enforcement) ---
    /**
     * to count the number of occupied movie slots.
     * A helper method used internally to determine the current count for the balance calculation.
     * will be called by: displayAccountInfo(), updateBalance()
     * @return The number of occupied slots (0 to 5).
     */
    private int getRentedMovieCount() {// to declare a private access method for movie counting
        int count = 0;
        for (int id : movieIDs) {// to loop through movieIDs array to check how many reference address has value on it .
            // Check for non-9999 slot
            if (id != ID_EMPTY_MARKER) {// to exclude our empty marker 9999
                count++;// to count and increase the count every time found slot has value other than 9999
            }
        }
        return count;// to return the final movie count value when the the method is called.
    }

    /**
     * to recalculate and set the private balance owed.
     * MANDATORY private method to ensure the balance is only updated based on the specific business rule (count * $3.99). 
     * This prevents external classes (Main) from setting the balance directly (strong Encapsulation).
     * will be called by: rentMovie(), dropMovieByID()
     */
    private void updateBalance() {// to calculate the update balance for each customer, it is a internal business logic or method 
        
        int count = getRentedMovieCount(); // to get total rented movie count by calling private method getRentedMovieCount()
        
        this.balanceOwed = count * RENTAL_PRICE;// to meet the REQUIREMENT: Formula is (number of rented movies * 3.99).
        // this line will update the balance every time any movied is rented. It will collect rented movie id from getRentedMovieCount method
        // will do same calculation every time to update the balance.
    }
}