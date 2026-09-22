/*

Total Text Requirement: 
 Part 1: UML Diagram
Use the following description to create a UML Diagram using Microsoft Word (hand in your document with the rest of your project). Remember proper UML formatting and use brief comments in the diagram to indicate functionality requirements.
Saskatchewan Polytechnic is creating a new Movie Rental Management System and has asked you to design a class called RentalAccount. You must create a UML Diagram based on the following requirements before moving on to the Java implementation.
•	RentalAccount Properties
•	All properties must be private.
There should be a static variable called storeName (type String) to represent the name of the rental store. This static variable is shared across all RentalAccount objects.
Additionally, the account must have the following properties:
•	accountID (type int)
•	firstName (type String)
•	lastName (type String)
•	balanceOwed (type double)
Because the database is not yet complete, the system will temporarily use two parallel arrays to store information about the movies currently rented by an account.
You must include:
•	An integer array called movieIDs. It will have 5 items, all set to 9999 by default.
•	A String array called movieTitles. It will also have 5 items, all set to “NoMovie” by default.
Reminder: Parallel arrays store related information at the same index. For example, if movieIDs[2] is 451, then movieTitles[2] must contain the title of movie 451.

RentalAccount Methods
The following requirements apply to getters and setters:
•	All properties must have getters that return their values.
•	Public setters must exist for: accountID, firstName, and lastName.
•	Two private setters must be created:
•	setMovieIDByIndex(int index, int newMovieID)
•	setMovieTitleByIndex(int index, String newMovieTitle)
These private setters will allow you to change a single element in each array.

Functional Methods Required:
•	A public method that returns the account holder’s full name formatted as: lastName, firstName
•	A public method that prints all rented movies formatted as: movieID: movieTitle
•	A public method dropMovieByID(int idToDrop) which:
•	searches the movieIDs array
•	When the ID is found, it retrieves that index
•	sets movieIDs[index] to 9999
•	sets movieTitles[index] to “NoMovie” using private setters
•	A public method rentMovie(int index, int movieID, String title) that uses the private setters
•	A private method that updates the balance using the formula:
•	number of rented movies × 3.99
This private method must be called at the end of both rentMovie and dropMovieByID.


Part 2: Class and Main Method
You are responsible for designing and implementing the RentalAccount class based on your UML. The class must include all properties, constructors (if needed), required methods, array logic, and the private balance update.

Your menu-driven application must:
•	Create a RentalAccount (user enters all information except movies and balance)
•	Display all account information.
•	Allow editing of basic account information.
•	Display all rented movies.
•	Allow renting a movie.
•	Allow dropping a movie.

The main method will be graded on:
•	Clear menu design
•	Looping back to the menu after each task
•	Clear prompts
•	Correct use of loops, if statements, switch statements
•	Bug-free execution
•	Comments





Part 3: Walkthrough
You must present your project to your instructor. You must submit your project to Brightspace before your walkthrough. You must come prepared with NetBeans open to your final project and Word open to your UML.
Walkthroughs are approximately 30 minutes. If you are next, please wait quietly outside.
Your coding grade is tied to your walkthrough grade. If your walkthrough grade is below 70%, your coding grade will be capped at your walkthrough percentage.
Example:
If you receive 50% on the walkthrough, your coding mark cannot exceed 50%, even if your code is fully complete.
You must understand your code and be prepared to explain your decisions.
 


UML
01. MovieRentalApp — UML Class Diagram (Styled Format)
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




02. RentalAccount — UML Class Diagram (Styled Format)

 +--------------------------------------------------------------------------------------+
|                                   RentalAccount                                      |
+--------------------------------------------------------------------------------------+
| // Static (Shared Across All Accounts)                                               |
| - STORE_NAME: String (static final)                                                  |
| - RENTAL_PRICE: double (static final)                                                |
|--------------------------------------------------------------------------------------|
| // Private Instance Fields                                                           |
| - accountID: int                                                                     |
| - firstName: String                                                                  |
| - lastName: String                                                                   |
| - balanceOwed: double                                                                |
|--------------------------------------------------------------------------------------|
| // Composition: Parallel Arrays (Fixed Size = 5)                                     |
| - arraySize: int (final)                                                             |
| - movieIDs: int[5]          «default value per slot = 9999»                          |
| - movieTitles: String[5]    «default value per slot = "NoMovie"»                     |
+--------------------------------------------------------------------------------------+
|                                     Constructor                                      |
+--------------------------------------------------------------------------------------+
| + RentalAccount(id:int, fName:String, lName:String)                                  |
+--------------------------------------------------------------------------------------+
|                                      Getters                                         |
| + getStoreName(): String (static)                                                    |
| + getAccountID(): int                                                                |
| + getFirstName(): String                                                             |
| + getLastName(): String                                                              |
| + getBalanceOwed(): double                                                           |
| + getMovieIDs(): int[]                                                               |
|--------------------------------------------------------------------------------------|
|                                      Setters                                         |
| + setAccountID(id:int): void                                                         |
| + setFirstName(name:String): void                                                    |
| + setLastName(name:String): void                                                     |
+--------------------------------------------------------------------------------------+
|                                   Functional Methods                                 |
+--------------------------------------------------------------------------------------+
| + getFullNameFormatted(): String     «returns "LastName, FirstName"»                 |
| + printAllRentedMovies(): void       «prints only slots where movieID != 9999»       |
|--------------------------------------------------------------------------------------|
| + rentMovie(slot:int, movieID:int, title:String): boolean                            |
|   «writes into arrays, calls updateBalance()»                                        |
|--------------------------------------------------------------------------------------|
| + dropMovieByID(id:int): boolean                                                     |
|   «searches arrays, resets slot to defaults, calls updateBalance()»                  |
+--------------------------------------------------------------------------------------+
|                               Private Utility Methods                                |
+--------------------------------------------------------------------------------------+
| - getRentedMovieCount(): int        «counts movieIDs != 9999»                        |
|--------------------------------------------------------------------------------------|
| - updateBalance(): void             «balanceOwed = (rentedCount × RENTAL_PRICE)»     |
+--------------------------------------------------------------------------------------+





03. Combined Multi-Class UML Diagram (Detailed, Styled Format)( to show the relation between to driver)
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
|   «prints main menu options»                                                          |
|--------------------------------------------------------------------------------------|
| - createAccount(): void                                                               |
|   «prompts user for ID and names; instantiates RentalAccount»                         |
|--------------------------------------------------------------------------------------|
| - editAccountInfo(): void                                                             |
|   «edits firstName, lastName, or accountID using public setters»                      |
|--------------------------------------------------------------------------------------|
| - rentMovie(): void                                                                   |
|   «finds first empty slot (9999), collects movie input, calls account.rentMovie()»    |
|--------------------------------------------------------------------------------------|
| - dropMovie(): void                                                                   |
|   «prompts for movie ID and calls account.dropMovieByID()»                            |
+--------------------------------------------------------------------------------------+

                                         |
                                         |  uses / has-a (composition)(Strong object to object relation
                                         v

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



Code structure

classDiagram
    class MovieRentalApp {
        +$main(args: String[])
        +$displayMenu()
        +$createAccount()
        +$editAccountInfo()
        +$rentMovie()
        +$dropMovie()
        +$scanner
        +$account
    }
    class RentalAccount {
        +$STORE_NAME
        +$RENTAL_PRICE
        +accountID
        +firstName
        +lastName
        +balanceOwed
        +RentalAccount(id: int, fName: String, lName: String)
        +$getStoreName()
        +getAccountID()
        +getBalanceOwed()
        +getFirstName()
        +getLastName()
        +setAccountID(id: int)
        +setFirstName(name: String)
        +setLastName(name: String)
        +getMovieIDs()
        +getFullNameFormatted()
        +rentMovie(slot: int, id: int, title: String)
        +dropMovieByID(id: int)
        +displayAccountInfo()
        +printAllRentedMovies()
    }
    class Scanner {}
    class movieIDs {}
    class movieTitles {}

    MovieRentalApp *-- RentalAccount : composition
    MovieRentalApp o-- Scanner : aggregation
    RentalAccount *-- movieIDs : composition
    RentalAccount *-- movieTitles : composition




A. Application Startup Sequence (interection flow)
------------------------------------------------------------------


User            MovieRentalApp                       RentalAccount
 |                   |                                     |
 |--- run program --->|                                     |
 |                   |-- main() --------------------------->|
 |                   |                                     |
 |                   |-- createAccount() ------------------>|
 |                   |         (constructor)                |
 |                   |------------------------------------->|
 |<--------- account created message -----------------------|



B. Rent Movie Use Case (interection flow)
------------------------------------------------------------

User            MovieRentalApp                       RentalAccount
 |                   |                                     |
 |--- selects "Rent Movie" ------------------------------->|
 |                   |                                     |
 |                   |-- rentMovie()                        |
 |                   |   (scans array for 9999)            |
 |                   |                                     |
 |                   |-- rentMovie(slot,id,title) -------->|
 |                   |         writes movieIDs[]            |
 |                   |         writes movieTitles[]         |
 |                   |         calls updateBalance()        |
 |                   |<-------------- true ----------------|
 |<---- print “Movie Rented Successfully” -----------------|



C. Drop/Return Movie Use Case (interection flow)
--------------------------------------------------------------


User            MovieRentalApp                       RentalAccount
 |                   |                                     |
 |--- selects "Drop Movie" ------------------------------->|
 |                   |                                     |
 |                   |-- dropMovie()                       |
 |                   |                                     |
 |                   |-- dropMovieByID(id) --------------->|
 |                   |         search movieIDs[]            |
 |                   |         reset to defaults            |
 |                   |         updateBalance()              |
 |                   |<-------------- true ----------------|
 |<----- print “Movie Returned Successfully” --------------|


 */



package MovieRentalApp;

/**
 *
 * @author User
 */
public class UML {

    /**
     * @param args the command line arguments
     */
    public static void Uml(String[] args) {
        // TODO code application logic here
    }
    
}
