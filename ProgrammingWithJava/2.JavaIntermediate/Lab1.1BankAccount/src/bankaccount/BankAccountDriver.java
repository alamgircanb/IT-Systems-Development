/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */ 

package bankaccount;

import java.util.Scanner;

/**
 *
 * @author alamgir
 */
public class BankAccountDriver {
//made static as per comments from instructor.
    public static Scanner input;
    public static BankAccount[] accounts;

    public BankAccountDriver() {
        input = new Scanner(System.in);
    }
    /**
     *this method will display all the accounts information
     */
    public void getData() {
        accounts = new BankAccount[5];
        accounts[0] = new BankAccount(1001, "Danny", "Vito", 'D', 3200.50f, "07/09/23");
        accounts[1] = new BankAccount(1002, "Md Alamgir", "Hossain", 'A', 7430.20f, "04/13/22");
        accounts[2] = new BankAccount(1003, "Moqsudul", "Hoque", 'M', 7076.57f, "01/18/22");
        accounts[3] = new BankAccount(1004, "Anish", "Chakma", 'A', 15000.15f, "02/03/21");
        accounts[4] = new BankAccount(1005, "Amara", "Butt", 'B', 300.40f, "09/08/19");
    }
    /**
     * to show the menu and collect user choice
     *
     * @return a integer received from the user
     */
    public int showMenu() {
        System.out.println("-----------------------------------");
        System.out.println("1.Display all Account");
        System.out.println("2.Display info for account by account number");
        System.out.println("3.Edit Information for account by account number");
        System.out.println("4.Deposit into account by account number");
        System.out.println("5.Withdraw from account by account number");
        System.out.println("6.Transfer from one account to another");
        System.out.println("7.Exit from Menu");
        System.out.println("----------------------------------");
        System.out.println("Choice:  ");
        return input.nextInt();
    }
    /**
     * to check every option against user input
     *
     * @param choice
     */
    public void executeChoices(int choice) {// to create a void method to excute options chosen by user.
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
            System.out.println("You are at the end of program, thank you.");
        } else {
            System.out.println("Invalid choice, Please input from 1 to 7");// to print invalid message if user select other than 0-7
        }
    }
    /**
     * display all account information
     */
    public void menuOption1() {
        for (int i = 0; i < accounts.length; i++) {
            // Check if the slot is not empty (null) before printing
            if (accounts[i] != null) {
                System.out.println("Account Number: " + accounts[i].getAccountNumber());
                System.out.println("Account Name:   " + accounts[i].getFirstName() + " " + accounts[i].getLastName());
                System.out.printf("Account Balance: %.2f", accounts[i].getBalance());
                System.out.println("\nLast Transaction: " + accounts[i].getLastTransaction());
            }
        }
    }
    /**
     * this method will print account information as per user choice
     */
    public void menuOption2() {
        System.out.print("Enter Account Number: ");
        int id = input.nextInt();
        boolean foundAccount = false;// to initate a boolean flag to check if the account number 
        for (int i = 0; i < accounts.length; i++) {
            // Check if account exists and the ID matches
            if (accounts[i] != null && accounts[i].getAccountNumber() == id) {
                System.out.println("Account Number: " + accounts[i].getAccountNumber());
                System.out.println("Account Name:   " + accounts[i].getFirstName() + " " + accounts[i].getLastName());
                System.out.printf("Account Balance:  %.2f", accounts[i].getBalance());
                System.out.println("Last Transaction: " + accounts[i].getLastTransaction());
                foundAccount = true;
            }
        }
        if (!foundAccount) {
            System.out.println("Account with ID " + id + " not found.");
        }
    }
    /**
     * It will display a sub-menu containing all accounts and then a sub-menu for
     * edit option this method is created to edit account information
     */
    public void menuOption3() {
        // to show Submenu containing all existing accounts
        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i] != null) {
                System.out.println((i + 1) + "," + accounts[i].getFirstName() + " " + accounts[i].getLastName());
            } else {
                System.out.println((i + 1) + "is not our account number");
            }
        }
        //To prompt user for a number between 1 and accounts.length to choose account to edit
        System.out.print("\nEnter account number to edit 1-" + accounts.length + " :");
        int choice = input.nextInt();

        //to provide submenu for a field choice to edit
        System.out.println("\nPlease a field to edit");
        System.out.println("1. First Name");
        System.out.println("2. Last Name");
        System.out.println("3. Middle Initial");
        System.out.println("8. Cancel");
        int choice2 = input.nextInt();

        // to handle the specific field to edit
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
            System.out.println("Please select 1-3 or 8.");
        }
    }
    /**
     * This method will do deposit operations
     */
    public void menuOption4() {
        System.out.print("Enter Account ID for Deposit: ");
        int id = input.nextInt();
        boolean found = false;
        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i] != null && accounts[i].getAccountNumber() == id) {
                found = true;
                System.out.println("Deposit Amount: ");
                float amt = input.nextFloat();
                System.out.println("Date (MM/DD/YY): ");
                String date = input.next();
                input.nextLine();
                accounts[i].deposit(amt, date);
                System.out.println("Deposit Amount Successfull");
            }
        }
        if (!found) {
            System.out.println("Account with ID " + id + " not found.");
        }
    }
    /**
     * this method will do withdrawal operations
     */
    public void menuOption5() {
        System.out.print("Enter Account ID for Withdraw: ");
        int id = input.nextInt();
        boolean found = false;
        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i] != null && accounts[i].getAccountNumber() == id) {
                found = true;
                System.out.println("Withdraw Amount: ");
                float amt = input.nextFloat();
                System.out.println("Date (MM/DD/YY): ");
                String date = input.next();
                input.nextLine();
                accounts[i].withdraw(amt, date);
                System.out.println("Withdraw Amount Successfull");
            }
        }
        if (!found) {
            System.out.println("Account with ID " + id + " not found.");
        }
    }
    /**
     * This method will do transfer operations, withdraw from sender account and
     * deposit to receiver account
     */
    public void menuOption6() {
        System.out.print("Enter Sender Account ID: ");
        int senderId = input.nextInt();
        System.out.print("Enter Receiver Account ID: ");
        int receiverId = input.nextInt();

        BankAccount sender = null;
        BankAccount receiver = null;

        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i] != null) {
                //to check if the sender account exits in accounts array
                if (accounts[i].getAccountNumber() == senderId) {
                    sender = accounts[i];
                }
                //to check if the receiver account exits in accounts array
                if (accounts[i].getAccountNumber() == receiverId) {
                    receiver = accounts[i];
                }
            }
        }
        //to check if the sender and receiver account number any of them are null 
        if (sender != null && receiver != null) {
            System.out.println("Transfer Amount: ");
            float amt = input.nextFloat();

            System.out.println("Date: (MM/DD/YY): ");
            String date = input.next();
            sender.transfer(amt, receiver, date);
        } else {
            System.out.println("One or both account IDs are invalid");
        }
    }

    /**
     * BankAccountProgramm all activities will start from here.
     *
     * @param args
     */
    public static void main(String[] args) {
        BankAccountDriver accountinfo = new BankAccountDriver();
        accountinfo.getData();
        int choice;
        // to run the menu atlead once ever if the condition is false
        do {
            choice = accountinfo.showMenu();
            accountinfo.executeChoices(choice);
            // to exit from the loop if user input is exactly 7
        } while (choice != 7);
        System.out.println("Thank you for using our BankAccount Program.");
    }
}