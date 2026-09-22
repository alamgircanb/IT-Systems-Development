/*
 Question II:

1.	Write a class called ChangeMachine to model a machine that accepts a $5 or $10 or $20 bill and then returns change in loonies and toonies. The change machine’s data and methods are listed in the UML class diagram on the next page.
2.	Code the checkStatus( ) method to check if there is a sufficient number of coins in the machine to return change. This method checks how many coins are currently in the machine. The number of coins required to make change is the number of loonies and toonies needed to give change for a single $5 or $10 or $20 bill. This method calls a setter to set the status property to true if there is a sufficient number of coins, or false if there are not enough coins. The latter reflects a situation in which there aren’t enough coins and the machine needs refilling.
3.	Code the setter methods so that they cannot accept coin numbers lower than zero. If the number is a negative value, display the message "You cannot have a negative number of coins!" and then check if the machine has enough coins to continue operating. If the number is a positive value, then add the value to the machine’s existing number of coins, and then check if the machine has enough coins to continue operating.
4.	In the constructor use the setter methods to fill the machine with coins. Then check that there is a sufficient number of coins in the machine for it to return change for each bill type.
5.	Code the makeChange( ) method to calculate the number of loonies or toonies that make up the change after a bill is inserted into the machine. This method displays the number of loonies and toonies that form the change. It also deducts the appropriate number of coins from the machine’s coin supply. To simplify matters, program the machine so it does not return loonies for the $10 and $20 bills; return 1 loonie and 2 toonies for the 5$ bill.
6.	Code the acceptMoney( ) method to accept a bill. This method gets the machine’s status to see if the machine is in working order. If the machine is not working, it displays the message “Out of Order! Here is your bill back.” If the machine is working, the method checks if a valid bill was inserted. If an invalid amount was entered the message “You must insert a $5 or $10 or $20 bill. Try again.” appears on the screen. If a valid amount was inserted, this method calls the makeChange( ) method. After the change is made, use the acceptMoney( ) method to check that there is enough coins left in the machine for another operation.
7.	In the driver program TestChangeMachine, test your change machine by carrying out the following operations:
a.	Create an instance of the ChangeMachine and fill it with a number of loonies and toonies.
b.	Check the machine's status before accepting the first bill. If the machine does not have enough coins to start working, display the message "Out of order! Cannot accept ANY bills. Please call technician to repair the machine." and stop the program. If the machine is in working order, then proceed to accept the first bill.
c.	Insert a single $5 or $10 or $20 bill.
d.	Display the number of loonies and toonies that make up the change.
e.	Repeat the procedure over and over.
f.	When the machine does not have enough coins to make change for the bills, please display the message "Out of order! Cannot accept any more bills. Please call the technician to refill the machine."
g.	Model the situation in which a technician opens the machine with a key and fills it with coins. Ask the technician to enter a valid PIN of 333. If a valid PIN is entered, then ask the technician for the number of $1 and $2 coins and add these coins to the existing ones in the machine. If the machine is in working order, display "Machine is ready." The loop structure in your program should continue to prompt the user to insert a bill. If the technician entered an invalid PIN, display "Invalid PIN!" Your program should end here.
 */
package bankmachine;

/**
 *
 * @author User
 */
import java.util.Scanner;// to import libarary
import java.util.InputMismatchException;// to import library

/**
 * ChangeMachine.java
 * Models a machine that accepts $5, $10, or $20 bills and returns change in loonies and toonies.
 */
public class ChangeMachine {// to declare a private class
    
    // Instance variables (properties)
    private int loonies; // $1 coins// to declare a private instance
    private int toonies; // $2 coins //to declare a private instance
    private boolean status; // operational status //to declare a private instance

    // Constants for bill types and change requirements
    public static final int BILL_5 = 5;// to delare public instance with final or nonchangable initial
    public static final int BILL_10 = 10;//to delare public instance with final or nonchangable initial
    public static final int BILL_20 = 20;//to delare public instance with final or nonchangable initial

    // Minimum requirements based on assignment rules:
    // $20 change requires 10 toonies.
    // $10 change requires 5 toonies.
    // $5 change requires 1 loonie and 2 toonies.
    // Machine must handle the maximum change needed: 10 toonies AND 1 loonie.
    private static final int MIN_TOONIES_REQUIRED = 10;//to delare private instance with final or nonchangable initial
    private static final int MIN_LOONIES_REQUIRED = 1;//to delare private instance with final or nonchangable initial


    /**
     * 1. Constructor. Fills the machine and checks the initial status.
     * @param initialLoonies
     * @param initialToonies
     */
    public ChangeMachine(int initialLoonies, int initialToonies) {// to create a parameterized constructor 
        // 4. Use setter methods to fill the machine (setters include validation and status check)
        System.out.println("Initializing Change Machine...");
        // Initially set the coins. Setters check for non-negative and then check status.
        this.loonies = 0; // Initialize to 0 before calling setters to ensure "add" logic works
        this.toonies = 0;
        
        setLoonies(initialLoonies);// to set value from the parameter
        setToonies(initialToonies);// to set value from the parameter
    }

   

    public int getLoonies() {// to create a getter method with return type
        return loonies;
    }

    public int getToonies() {// to create a getter method with return type
        return toonies;
    }

    public boolean getStatus() {// to create a getter method with return type
        return status;
    }

    // --- Setters ---

    /**
     * 3. Setter for loonies. Adds coins if positive, validates for negative, and updates status.
     * @param newLoonies
     */
    public void setLoonies(int newLoonies) {// to create a setter method with void return type
        if (newLoonies < 0) {// to validate if the newLooines parameter value is smaller than zero
            System.out.println("You cannot have a negative number of coins!");
        } else {
            // Add the value to the machine’s existing number of coins
            this.loonies += newLoonies;// to add the value of parameter if the value is non negative.
        }
        // Then check if the machine has enough coins to continue operating.
        checkStatus();
    }

    /**
     * 3. Setter for toonies. Adds coins if positive, validates for negative, and updates status.
     * @param newToonies
     */
    public void setToonies(int newToonies) {// to declare a setter method with void return type
        if (newToonies < 0) {// to validate the parameter value
            System.out.println("You cannot have a negative number of coins!");// to print the message if the value is negative
        } else {
            // Add the value to the machine’s existing number of coins
            this.toonies += newToonies;// to add the parameter passed through value if it is non negative
        }
        // Then check if the machine has enough coins to continue operating.
        checkStatus();
    }

    /**
     * Internal setter to update operational status.
     */
    private void setStatus(boolean status) {// to declare a setter with void return type
        this.status = status;// to take thhe value from parameter to local variable status
    }

    // --- Core Methods (Behaviors) ---

    /**
     * 2. Checks if there is a sufficient number of coins to handle *any* bill ($5, $10, or $20).
     * Sets the status property accordingly.
     */
    public void checkStatus() {
        // Must meet the highest requirement: 10 toonies (for $20) AND 1 loonie (for $5)
        if (this.toonies >= MIN_TOONIES_REQUIRED && this.loonies >= MIN_LOONIES_REQUIRED) {
            setStatus(true); // Machine is fully operational
        } else {
            setStatus(false); // Machine needs refilling
        }
    }

    /**
     * 5. Calculates, displays, and deducts the appropriate change from the coin supply.
     */
    private void makeChange(int billAmount) {
        int dispensedLoonies = 0;
        int dispensedToonies = 0;

        // Determine change based on assignment rules
        if (billAmount == BILL_5) {
            // $5 bill: return 1 loonie and 2 toonies
            dispensedLoonies = 1;
            dispensedToonies = 2;
        } else if (billAmount == BILL_10) {
            // $10 bill: does not return loonies; return 5 toonies
            dispensedToonies = 5;
        } else if (billAmount == BILL_20) {
            // $20 bill: does not return loonies; return 10 toonies
            dispensedToonies = 10;
        }

        // Deduct the coins from the machine's supply
        this.loonies -= dispensedLoonies;
        this.toonies -= dispensedToonies;

        // Display the change
        System.out.printf("\n--- Change Dispensed for $%d Bill ---\n", billAmount);// to print the billAmount
        System.out.printf("Dispensing: %d loonies ($1)\n", dispensedLoonies);// to print loonies amount
        System.out.printf("Dispensing: %d toonies ($2)\n", dispensedToonies);// to rint toonies amount
        System.out.printf("Total Change: $%d\n", billAmount);// to print total change
    }

    /**
     * 6. Accepts a bill, checks status, validates bill amount, and initiates change.
     * Re-checks status after successful change operation.
     * @param billAmount
     */
    public void acceptMoney(int billAmount) {
        // Check 1: Machine global status
        if (!getStatus()) {// to check the validity of thhe get status mean it can dispense coin any more, otherwise print outof order.
            System.out.println("\nOut of Order! Here is your bill back. (Machine needs full refill)");// to print out of order if the message 
            return;
        }

        // Check 2: Valid bill amount
        if (billAmount != BILL_5 && billAmount != BILL_10 && billAmount != BILL_20) {
            System.out.println("\nInvalid Amount: You must insert a $5 or $10 or $20 bill. Try again.");
            return;
        }

        // Check 3: Sufficient coins for this specific transaction (must be done just before makeChange)
        boolean canMakeChange = true;
        if (billAmount == BILL_5 && (this.loonies < 1 || this.toonies < 2)) {
             canMakeChange = false;
        } else if (billAmount == BILL_10 && this.toonies < 5) {
             canMakeChange = false;
        } else if (billAmount == BILL_20 && this.toonies < 10) {
             canMakeChange = false;
        }

        if (canMakeChange) {
            // Valid amount and enough specific coins
            System.out.printf("\nAccepted $%d bill. Processing change...\n", billAmount);
            makeChange(billAmount);
            
            // Check status immediately after transaction (Question 6)
            checkStatus(); 
            if (!getStatus()) {
                // f. Out of order message if change resulted in insufficient inventory
                System.out.println("Out of order! Cannot accept any more bills. Please call the technician to refill the machine.");
            }
        } else {
            // Although checkStatus() was true initially, this transaction failed due to specific coin shortage
            System.out.println("\nOut of Order! Cannot make change for a $" + billAmount + " bill. Here is your bill back.");
            checkStatus(); // Ensure status is updated if it wasn't already
        }
    }
    
    /**
     * 7g. Models technician refill process with PIN access.
     * @param scanner The Scanner object for input.
     * @return true if the machine is ready to continue, false if program should end (invalid PIN).
     */
    public boolean technicianRefill(Scanner scanner) {
        final int VALID_PIN = 333;
        System.out.print("\nTECHNICIAN ACCESS: Enter PIN: ");

        if (!scanner.hasNextInt()) {
            scanner.nextLine();
            System.out.println("Invalid PIN format!");
            return false;
        }
        
        int pinAttempt = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (pinAttempt != VALID_PIN) {
            System.out.println("Invalid PIN!");
            return false; // Program should end here
        }

        System.out.println("Access Granted. Refilling Machine.");

        // Get loonies to add (must be positive)
        int refillLoonies = 0;
        do {
            System.out.print("Enter number of $1 coins to add (must be >= 0): ");
            try {
                refillLoonies = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter an integer.");
                scanner.nextLine();
                refillLoonies = -1;
            }
        } while (refillLoonies < 0);

        // Get toonies to add (must be positive)
        int refillToonies = 0;
        do {
            System.out.print("Enter number of $2 coins to add (must be >= 0): ");
            try {
                refillToonies = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter an integer.");
                scanner.nextLine();
                refillToonies = -1;
            }
        } while (refillToonies < 0);
        
        // Add coins using setters (which will validate and check status)
        setLoonies(refillLoonies);
        setToonies(refillToonies);

        if (getStatus()) {
            System.out.println("Machine is ready. Current Inventory: " + this.loonies + " loonies, " + this.toonies + " toonies.");
        } else {
             System.out.println("Refill complete, but machine is still OUT OF ORDER. Inventory: " + this.loonies + " loonies, " + this.toonies + " toonies.");
        }
        
        return true;
    }
    
    /**
     * Provides a string representation of the machine's internal status.
     * @return 
     */
    @Override
    public String toString() {
        return String.format("ChangeMachine Status | Operational: %s | Loony Count: %d | Toony Count: %d", 
               (status ? "READY" : "OUT OF ORDER"), loonies, toonies);
    }
}