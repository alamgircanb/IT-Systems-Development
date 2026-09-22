/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BankAccountProgram;
import java.util.Scanner;

/**
 * @author User
 */
public class BankAccountDriver {

    public static Scanner input;
    public static BankAccount[] accounts;
    public static Customer[] customers;

    public BankAccountDriver() {
        input = new Scanner(System.in);
    }
    /**
     * will populate data to the customer's array and account's array
     */
    public void getInfo() {
        customers = new Customer[7];
        customers[0] = new Customer(005, "Danny", "Vito", 'D');
        customers[1] = new Customer(004, "Amy", "Santiago", 'B');
        customers[2] = new Customer(003, "Marjorie", "Simpson", 'J');
        customers[3] = new Customer(001, "Tetsuo", "Shima", 'A');
        customers[4] = new Customer(002, "Jonas", "Khanwald", 'M');
        customers[5] = new Customer(006, "Pedro", "Pascal", 'B');
        customers[6] = new Customer(007, "Kaitlyn", "Olsen", 'D');

        accounts = new BankAccount[10];
        accounts[0] = new ChequingAccount(1005, customers[2], 76.57f, new Date(2019, 11, 5), 10.50f);
        accounts[1] = new SavingsAccount(1001, customers[0], 6500.50f, new Date(2023, 9, 7), 10.0f);
        accounts[2] = new SavingsAccount(1003, customers[2], 5533.57f, new Date(2019, 12, 6), 1.0f);
        accounts[3] = new SavingsAccount(1006, customers[4], 0.60f, new Date(2020, 7, 7), 10.0f);
        accounts[4] = new ChequingAccount(1002, customers[1], 2576.57f, new Date(2022, 9, 8), 10.50f);
        accounts[5] = new ChequingAccount(1008, customers[0], 200.10f, new Date(2023, 12, 8), 10.0f);
        accounts[6] = new SavingsAccount(1009, customers[2], 33.21f, new Date(2021, 5, 6), 1.0f);
        accounts[7] = new ChequingAccount(1010, customers[5], 500000.97f, new Date(2020, 11, 1), 100.0f);
        accounts[8] = new SavingsAccount(1004, customers[3], 3000.60f, new Date(2017, 10, 3), 10.0f);
        accounts[9] = new ChequingAccount(1007, customers[6], 9000.50f, new Date(2022, 11, 3), 50f);
    }

    /**
     * This method will display option menu for user and ask for user input and return it.
     * @return an integer, received from user and will validate if the number is between 1 to 8
     */
    public int showMenu() {
        System.out.println("\n1. Display Accounts (Submenu)");
        System.out.println("2. Display All Customers");
        System.out.println("3. Accounts by Customer ID");
        System.out.println("4. Calculate Interest");
        System.out.println("5. Withdraw");
        System.out.println("6. Deposit");
        System.out.println("7. Transfer");
        System.out.println("8. Exit");
        return acceptNumberInBound("Enter choice", 1, 8);
    }

    /**
     * this method will check every option against user input and call the
     * method as per.
     *
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
            menuOption7();
        } else if (choice == 8) {
            menuOption8();
        }
    }

    /**
     * will display option to user to choose accounts by types or all 
     * will print all accounts information based on user choice
     */
    public void menuOption1() {
        System.out.println("1. Chequing Accounts");
        System.out.println("2. Savings Accounts");
        System.out.println("3. All Accounts");
        int subMenu = acceptNumberInBound("Select Choice", 1, 3);
        float total = 0;

        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i] != null) {

                // Filter based on subMenu choice
                if ((subMenu == 1 && accounts[i] instanceof ChequingAccount)
                        || (subMenu == 2 && accounts[i] instanceof SavingsAccount)
                        || (subMenu == 3)) {

                    Customer cs1 = accounts[i].getCustomer();

                    if (accounts[i] instanceof ChequingAccount c1) {
                        System.out.print("Chequing#" + c1.getAccountNumber() + ": ");
                    }
                    if (accounts[i] instanceof SavingsAccount s1) {
                        System.out.print("Savings#" + s1.getAccountNumber() + ": ");
                    }
                    System.out.println(cs1.getCustomerId() + ", "
                            + cs1.getLastName() + ", "
                            + cs1.getFirstName() + " "
                            + cs1.getMiddleInit() + ".");

                    System.out.printf("Balance: $%.2f\n", accounts[i].getBalance());
                    System.out.println("---------------------------");

                    total += accounts[i].getBalance();
                }
            }
        }
        System.out.printf("Total of displayed accounts: $%.2f\n", total);
    }

    /**
     * Display All Customers
     */
    public void menuOption2() {
        for (int i = 0; i < customers.length; i++) {
            if (customers[i] != null) {
                System.out.println(customers[i].toString());
            }
        }
    }

    /**
     * Search account/accounts by Customer ID
     */
    public void menuOption3() {
        System.out.print("Enter Customer ID: ");
        int id = input.nextInt();

        boolean found = false;

        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i] != null && accounts[i].getCustomer().getCustomerId() == id) {

                //Print the general info first
                System.out.print("Account Number: " + accounts[i].getAccountNumber()
                        + ", Name: " + accounts[i].getCustomer().getLastName()
                        + ", " + accounts[i].getCustomer().getFirstName()
                        + ", Balance: $" + accounts[i].getBalance());

                // Now print the child-specific info (casting)
                if (accounts[i] instanceof SavingsAccount s1) {

                    System.out.println(" Savings Interest Rate: " + s1.getInterestRate() + "%");
                } else if (accounts[i] instanceof ChequingAccount c1) {
                    System.out.println(" Chequing Overdraft Limit: $" + c1.getOverDraftLimit());
                }
                found = true;
            }
        }

        if (!found) {
            System.out.println("No accounts found for Customer ID: " + id);
        }
    }

    /**
     * Calculate Interest
     */
    public void menuOption4() {
        int id = acceptNumberInBound("Enter Saving Account ID", 1000, 9999);
        boolean found = false;

        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i] != null && accounts[i].getAccountNumber() == id) {
                found = true;

                // checks the type and creates the variable 's1' all at once
                if (accounts[i] instanceof SavingsAccount s1) {
                    System.out.print("Months: ");
                    s1.accrueInterest(input.nextInt());
                    System.out.println("Updated Balance: " + s1.getBalance());
                } else {
                    System.out.println("This account is not a Savings Account.");
                }
            }
        }
        if (!found) {
            System.out.println("Account ID not found.");
        }
    }

    /**
     * Withdraw (polymorphic call) This method will withdraw amount from selected account
     */
    public void menuOption5() {

        //Use my method to protect negative input
        int id = acceptNumberInBound("Enter Account ID", 1000, 9999);
        boolean found = false;
        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i] != null && accounts[i].getAccountNumber() == id) {
                //Get the amount using standard float input
                System.out.print("Enter Withdraw Amount: ");
                float amount = input.nextFloat();

                accounts[i].withdraw(amount, new Date(2026, 2, 4));
                found = true;
            }
        }
        if (!found) {
            System.out.println("Account ID " + id + " not found.");
        }
    }

    /**
     * Deposit if the accountId found, found will be true and loop will exit. 
     * if account is not found it will print failure message,
     */
    public void menuOption6() {
        int id = acceptNumberInBound("Enter Account ID", 1000, 9999);
        boolean found = false;

        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i] != null && accounts[i].getAccountNumber() == id) {
                System.out.print("Enter Deposit Amount: ");
                accounts[i].deposit(input.nextFloat(), new Date(2026, 2, 3));
                found = true;
            }
        }
        if (!found) {
            System.out.println("Account ID: " + id + " does not exist.");
        } else {
            System.out.println("Deposit Successful.");
        }
    }

    /**
     * transfer amount from one account to other account
     */
    public void menuOption7() {
        // Get the IDs using my safe method (acceptNumberInBound)
        int senderID = acceptNumberInBound("Enter Sender Account ID", 1000, 9999);
        int receiverID = acceptNumberInBound("Enter Receiver Account ID", 1000, 9999);

        // create placeholders for the actual account objects
        BankAccount sender = null;
        BankAccount receiver = null;

        //search the array for both accounts (sender and receiver)
        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i] != null) {
                if (accounts[i].getAccountNumber() == senderID) {
                    sender = accounts[i];
                }
                if (accounts[i].getAccountNumber() == receiverID) {
                    receiver = accounts[i];
                }
            }
        }
        // If both account numbers were found, proceed with the transfer
        if (sender != null && receiver != null) {
            System.out.print("Enter Transfer Amount: ");
            float amount = input.nextFloat();

            // This calls the transfer method in the parent class
            // 'receiver' is passed in as the 'otherAccount' of the transfer method
            sender.transfer(amount, receiver, new Date(2026, 2, 4));

            System.out.println("$" + amount + " transfer successful from " + senderID + " to " + receiverID);
        } else {
            System.out.println("One or both accounts not found.");
        }
    }

    /**
     * it is exit menu option, user will exit from the program by this options.
     */
    public void menuOption8() {
        System.out.println("Thank you for using our Bank Account Program.");
    }

    /**
     * This method will accept only the number between given lower and upper bounds. 
     * this method will check lower and upper bound
     * @param prompt text message to user based one menu requirements
     * @param lower will represent the lower bound of the given range passed throw this method
     * @param upper will represent the upper bound of the give range
     * @return value
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
        accountInfo.getInfo();
        int choice;
        // I used do-while loop to display the all options once ever if the condition false
        do {
            choice = accountInfo.showMenu();
            accountInfo.executeChoices(choice);
            // loop will exit when the user choice is exactly 8.
        } while (choice != 8);
    }
}
