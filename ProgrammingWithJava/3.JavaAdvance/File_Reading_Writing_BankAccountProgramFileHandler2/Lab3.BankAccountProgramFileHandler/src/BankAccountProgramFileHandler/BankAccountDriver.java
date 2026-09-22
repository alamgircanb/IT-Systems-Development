
package BankAccountProgramFileHandler;
import java.util.Scanner;

/**
 *
 * @author User
 */
public class BankAccountDriver {

    public static Scanner input;
    public static BankAccount[] accounts;

    public BankAccountDriver() {
        input = new Scanner(System.in);
    }
    public void getData() {
        FileHandler fh = new FileHandler();
        accounts =fh.getData("233BankAccountTestData.txt");
        
    }
/**
     * This method will display option menu for user and ask for user input and return it.
     * @return 
     */
    public int showMenu() {
        System.out.println("----------------------------------");
        System.out.println("1. Display all Account");
        System.out.println("2. Display info for account by account number");
        System.out.println("3. Edit Information for account by account number");
        System.out.println("4. Deposit into account by account number");
        System.out.println("5. Withdraw from account by account number");
        System.out.println("6. Transfer from one account to another");
        System.out.println("7. Add New Account ");
        System.out.println("8. Exit and Save");
        System.out.println("--------------------------------");
        return acceptNumberInBound("Please select an option", 1, 8);
    }
    /**
     *this method will check every option against user input and call the method as per.
     * @param choice
     */
public void executeChoices(int choice) {
        if (choice == 1) {
            menuOption1();
        } else if (choice == 2) {
            menuOption2();
        } else if (choice == 3) {
            menuOption3();
        } else if (choice == 4) {
            menuOption4();
        } else if (choice == 5) {
            menuOption5();
        } else if (choice == 6) {
            menuOption6();
        } else if (choice == 7) {
            menuOption7(); // Add New Account
        } else if (choice == 8) {
            menuOption8(); // Exit and Save
        }
    }
    /**
     *this method will print all accounts information
     */
    public void menuOption1() {
        for (int i = 0; i < accounts.length; i++) {
            // to Check if the slot is not empty (null) before printing
            if (accounts[i] != null) {
                System.out.println("Account Number: " + accounts[i].getAccountNumber());
                System.out.println("Account Name:   " + accounts[i].getFirstName() + " " + accounts[i].getLastName());
                System.out.printf("Account Balance: %.2f", accounts[i].getBalance());//to print dollar balance upto 2 decimal point
                System.out.println("\n Last Transaction: " + accounts[i].getLastTransaction());
            }
        }
    }

    /**
     *this method will print account
     */
    public void menuOption2() {
        System.out.print("Enter Account Number: ");
        int id = input.nextInt();
        boolean found = false;
        
        for (int i = 0; i < accounts.length; i++) {
            // Check if account exists and the ID matches
            if (accounts[i] != null && accounts[i].getAccountNumber() == id) {
                System.out.println("Account Number: " + accounts[i].getAccountNumber());
                System.out.println("Account Name:   " + accounts[i].getFirstName() + " " + accounts[i].getLastName());
                System.out.printf("Account Balance: %.2f", accounts[i].getBalance());//to print dollar balance upto 2 decimal point
                System.out.println("\nLast Transaction: " + accounts[i].getLastTransaction());
                found = true;
            }
        }
        if (!found) {
            System.out.println("Account with ID " + id + " not found.");
        }
    }
/**
 * this method will provide a sub menu to user 
 * this method will edit account information
 */
    public void menuOption3() {
        // to show Submenu showing all existing accounts
        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i] != null) {
                // to print a submenu for user containing all the accounts.
                System.out.println((i + 1) + "." + accounts[i].getAccountNumber() + ", " + accounts[i].getFirstName() + " " + accounts[i].getLastName());
            } else {
                System.out.println((i + 1) + "is not our account number");
            }
        }
        // call acceptNumberInBound to prompt user for a number between 1 and accounts.length (valid numbers of account in the array. 
        int choice = acceptNumberInBound(" Enter a number", 1, accounts.length);

        //to provide sub menu for fields, I did not use getNumberInBound method to get user input this block
        // as option 8 and 1-3 are from seperate range.
        System.out.println("\n Please choose an option to edit");
        System.out.println("1.First Name");
        System.out.println("2.Last Name");
        System.out.println("3.Middle Initial");
        System.out.println("8.Cancel");
        int choice2 = input.nextInt();

        // to handle the specific field edit
        if (choice2 == 1) {
            System.out.print("Enter new first name: ");
            accounts[choice - 1].setFirstName(input.next());
            System.out.println("First name updated.");
        } else if (choice2 == 2) {
            System.out.print("Enter new last name: ");
            accounts[choice - 1].setLastName(input.next());
            System.out.println("Last name updated.");
        } else if (choice2 == 3) {
            System.out.print("Enter new middle initial: ");
            accounts[choice - 1].setMiddleInit(input.next().charAt(0));
            System.out.println("Middle initial updated.");
        } else if (choice2 == 8) {
            System.out.println("Edit cancelled.");
        } else {
            System.out.println("Invalid field selection.");
        }
    }
/**
 * this method will do amount deposit into selected account
 */
    public void menuOption4() {
        System.out.print("Enter Account ID for Deposit: ");
        int id = input.nextInt();
        boolean found = false;
        // to check the validity of account number before deposit 
        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i] != null && accounts[i].getAccountNumber() == id) {
                found = true;
                System.out.print("Enter Deposit Amount: ");
                float amt = input.nextFloat();
                
                // call getNumberInBound method to prompt user for day and month
                int day = acceptNumberInBound("Enter Day", 1, 31);
                int month = acceptNumberInBound("Enter Month", 1, 12);

                System.out.print("Enter Year: ");
                int year = input.nextInt();
                Date depositDate = new Date(day, month, year);

                accounts[i].deposit(amt, depositDate);
                System.out.println("Deposit successful");
            }
        }
        if (!found) {
            System.out.println("Account with ID " + id + " not found.");
        }
    }

    /**
     *This method will do withdrawal amount from selected account
     */
    public void menuOption5() {
        System.out.print("Enter Account ID for Withdrawal: ");
        int id = input.nextInt();
        boolean found = false;
        // to check if the account is in the array 
        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i] != null && accounts[i].getAccountNumber() == id) {
                found = true;
                System.out.print("Enter Withdrawal Amount: ");
                float amt = input.nextFloat();
                // call getNumberInBound method to prompt user to get day and month
                int day = acceptNumberInBound("Enter Day", 1, 31);
                int month = acceptNumberInBound("Enter Month", 1, 12);

                System.out.print("Enter Year: ");
                int year = input.nextInt();

                Date withdrawalDate = new Date(day, month, year);
                accounts[i].withdraw(amt, withdrawalDate);
            }
        }
        if (!found) {
            System.out.println("Account with ID " + id + " not found.");
        }
    }

    /**
     *This method will transfer amount from sender account to receiving account
     */
    public void menuOption6() {
        System.out.print("Enter Sender Account ID: ");
        int senderId = input.nextInt();
        System.out.print("Enter Receiver Account ID: ");
        int receiverId = input.nextInt();

        BankAccount sender = null;
        BankAccount receiver = null;
        
        //to check the validity of sender account and receiver account 
        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i] != null) {
                if (accounts[i].getAccountNumber() == senderId) {
                    sender = accounts[i];
                    }
                if (accounts[i].getAccountNumber() == receiverId) {
                    receiver = accounts[i];
                     }
                 }
            }
        if (sender != null && receiver != null) {
            System.out.print("Enter Transfer Amount: ");
            float amt = input.nextFloat();
            // Call getNumberInBound method to prompt user to input day, month.
            int day = acceptNumberInBound("Enter Day", 1, 31);
            int month = acceptNumberInBound("Enter Month", 1, 12);
            
            // I did not use getNumberInBound method to prompt user for year, as year range is not given.
            System.out.print("Enter Year: ");
            int year = input.nextInt();
            Date transferDate = new Date(day, month, year);
            sender.transfer(amt, receiver, transferDate);
        } else {
            if (sender == null) {
                System.out.println("Sender account " + senderId + " not found.");
            }
            if (receiver == null) {
                System.out.println("Receiver account " + receiverId + " not found.");
                }
            }
        }
        public void menuOption7() {
        System.out.println("Enter New Account Details:");
        System.out.print("Account Number: ");
        int accountNumber = input.nextInt();
        System.out.print("First Name: ");
        String firstName = input.next();
        System.out.print("Last Name: ");
        String lastName = input.next();
        System.out.print("Middle Initial: ");
        char middleInIt = input.next().charAt(0);
        System.out.print("Account Opening Balance: ");
        float balance = input.nextFloat();
        System.out.print("Date (Year Month Day): ");
        Date lastTransaction = new Date(input.nextInt(), 
                                        input.nextInt(), 
                                        input.nextInt());

        BankAccount newAccount = new BankAccount(accountNumber, 
                                               firstName, 
                                               lastName, 
                                               middleInIt, 
                                               balance, 
                                               lastTransaction);

        // To create a new array, 1 cell bigger than the current array
        BankAccount[] tempAccounts = new BankAccount[accounts.length + 1];
        //To copy the od data to the new array
        System.arraycopy(accounts, 0, tempAccounts, 0, accounts.length);
        //To add te new account to the end of the array
        tempAccounts[tempAccounts.length - 1] = newAccount;
        //To assign the new array to te old reference
        accounts = tempAccounts;
        
        System.out.println("Account added. New total Account count: " + accounts.length);
    }
       public void menuOption8() {
        FileHandler.save(accounts);
        System.out.println("File saved and closed");
    } 
        
    /**
     * This method will accept only the number between given lower and upper
     * bounds.
     * this method is created to meet step4 requirement to check lower and upper bound
     * @param prompt text message to user based one menu requirements
     * @param lower will represent the lower bound of the given range passed throw this method
     * @param upper will represent the upper bound of the give range
     * @return
     */
    public int acceptNumberInBound(String prompt, int lower, int upper) {
        int value = 0;
        boolean found = false;
        while (!found) {
            System.out.print(prompt + " (" + lower + "-" + upper + "): ");
            value = input.nextInt();
            input.nextLine();
            if (value >= lower && value <= upper) {
                found = true;
            } else {
                System.out.println("Please enter a number between " + lower + " and " + upper);
            }
        }
        return value;
    }
/**
 * BankAccountProram will start from here
 * @param args 
 */
    public static void main(String[] args) {
        BankAccountDriver accountInfo = new BankAccountDriver();
        accountInfo.getData();
        int choice;
// I used do-while loop to display the all options once ever if the condition false
        do {
            choice = accountInfo.showMenu();
            accountInfo.executeChoices(choice);
            // loop will exit when the user choice is exactly 8.
        } while (choice != 8);
        System.out.println("Thank you for using our BankAccount Application.");
    }

}
