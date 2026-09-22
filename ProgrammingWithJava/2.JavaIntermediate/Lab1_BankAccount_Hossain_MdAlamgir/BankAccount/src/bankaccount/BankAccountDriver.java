/*
 * UML
BankAccountDriver
+ input : Scanner
+ accounts: BankAccount[]
 
+ BankAccountProgram()
+ getData() : void
+ showMenu() : int
+ executeChoices(int choice) : void
+ menuOption1() : void
+ menuOption2() : void
+ menuOption3() : void
+ menuOption4() : void
+ menuOption5() : void
+ menuOption6() : void
+ main(String[] args) : void
 */
package bankaccount;

import java.util.Scanner;// to import Scanner library from java utility package

/**
 *
 * @author alamgir
 */
public class BankAccountDriver {

    public Scanner input;// to create a Scanner type public object named input
    public BankAccount[] accounts;// to create an array instance named accounts

    public BankAccountDriver() {// to create a constructor 
        input = new Scanner(System.in);//to initialize the Scanner
    }

    public void getData() {
        accounts = new BankAccount[5];// to create an array to store exactly five BankAccount object references

        accounts[0] = new BankAccount(1001, "Danny", "Vito", 'D', 3200.50f, "07/09/23");// to store value of a BankAccount in position of 0 

        accounts[1] = new BankAccount(1002, "Kaitlyn", "Olsen", 'D', 6400.20f, "04/13/2022");//to store value of a BankAccount in position of 1
        accounts[2] = new BankAccount(1003, "Marjorie", "Simpson", 'J', 5576.57f, "01/18/2022");//to store value of a BankAccount in position of 2
        accounts[3] = new BankAccount(1004, "Tetsuo", "Shima", 'A', 2200.15f, "02/03/2021");//to store value of a BankAccount in position of 3
        accounts[4] = new BankAccount(1005, "Amy", "Santiago", 'B', 36000.40f, "09/08/2019");//to store value of a BankAccount in position of 4
    }

    public int showMenu() { // to create a method to display the menu options
        System.out.println("\n-----Menu------------");// to print menu header
        System.out.println("1.Display all Account");
        System.out.println("2.Display info for account by account number");
        System.out.println("3.Edit Information for account by account number");
        System.out.println("4.Deposit into account by account number");
        System.out.println("5.Withdraw from account by account number");
        System.out.println("6.Transfer from one account to another");
        System.out.println("7. Exit from Menu");
        System.out.println("-----------------------------------------");// to print a dash line to show the end of menu
        return input.nextInt();// Returns choice to calling point (input received from user)
    }

    public void executeChoices(int choice) {// to create a void method to excute options chosen by user.

        switch (choice) {
            case 1:
                menuOption1();// to call menuOption1 method when user input 1 as choice
                break;
            case 2:
                menuOption2();//to call menuOption2 method when user input 2 as choice
                break;
            case 3:
                menuOption3();//to call menuOption3 method when user input 3 as choice
                break;
            case 4:
                menuOption4();//to call menuOption4 method when user input 4 as choice
                break;
            case 5:
                menuOption5();//to call menuOption5 method when user input 5 as choice
                break;
            case 6:
                menuOption6();//to call menuOption6 method when user input 6 as choice
                break;
            case 7:
                System.out.println("You are at the end of program, thank you.");// to print a end message if user select 7.
                break;
            default:
                System.out.println("Invalid choice, Please input from 1 to 7");// to print invalid message if user select other than 0-7
        }
    }

    public void menuOption1() {// to create a void method to print all account number information
        for (BankAccount acc : accounts) {// // to create a temporary variable 'acc' by using the enhanced for-each loop and check every BankAccount object found inside the 'accounts' array.
            printAccount(acc);// to call printAccount method with the acc variable value to display all account information.
            System.out.println("------------");// to print a dash line after account information.
        }
    }

    public void menuOption2() {// to create a void method to print account information only if the account number match
        System.out.println("Enter Account Number:  ");// to prompt user to enter an account number to get account information
        int id = input.nextInt();// to declare an interger type variabl to store value received from user input
        BankAccount acc = findAccount(id);// to declare acc variable by calling findAccount method taking id variable value in it
        if (acc != null) {// to check negative value of acc variable
            printAccount(acc);// to call printAccount method to print account information if the account number found in the record
        }

    }

    public void menuOption3() {// to create a void method to edit account information calling setter method created in BankAccount class
        System.out.print("Enter Bank Account Index Number you want to edit (1-" + accounts.length + "): ");
        int accountIndex = input.nextInt(); // This is the "number between 1 and accounts.length"

        System.out.println("\nWhat field do you want to edit?");// to display the field sub-menu
        System.out.println("1. First Name");
        System.out.println("2. Last Name");
        System.out.println("3. Middle Initial");
        System.out.println("8. Cancel"); // Using 8 for cancel as usually 1 is First Name
        System.out.print("Enter your choice : ");// to prompt user to enter choice number for edit menu
        

        int choice = input.nextInt(); // to declare a integer type variable named choice to store user input
        input.nextLine(); // to clear buffer

        
        if (choice == 8) {// to check if the user input is 8 and exit from the loop
            System.out.println("Edit Cancelled.");// to print a edit cancellation message.
        } else if (choice == 1) {// to check if the suer input is 1
            System.out.print("Enter new first name: ");// to prompt user to enter new first name if the user input is 1
            accounts[accountIndex - 1].setFirstName(input.next());// to call the setter method to update first name with the new first name got from user
            System.out.println("Update successful.");// to print a sucessfull message for user
        } 
        else if (choice == 2) {//to check if the suer input is 2
            System.out.print("\n\nEnter new last name: ");//to prompt user to enter new last name if the user input is 2
            accounts[accountIndex - 1].setLastName(input.next());// to call the setter method to update last name with the new last name got from user
            System.out.println("Update successful.");// to print a sucessfull message for user
            
        } else if (choice == 3) {
            System.out.print("Enter new middle initial: ");//to check if the suer input is 3
            accounts[accountIndex - 1].setMiddleInit(input.next().charAt(0));// to call the setter method to update middle initial with the new middle initial got from user
            System.out.println("Update successful.");// to print a sucessfull message for user
        }
    }

    public void menuOption4() {// to create a void method to call deposit method and update the deposit amount
        System.out.println("Enter account id: ");//to prompt user to enter account number where the amount will be deposited
        int id = input.nextInt();// to declare an integer type variable named id to store the user input 
        BankAccount acc = findAccount(id);// to declare a variable named acc to store id if it is found by calling findAccount method
        if (acc != null) {// to check if acc is not null
            System.out.println("Deposit Amount: ");// to prompt user to enter the deposit amount
            float amt = input.nextFloat();// to declare a float typed variable named amt to store user input amount value

            System.out.println("Date (MM/DD/YY): ");// to prompt user to enter a date when transaction took place
            String date = input.next();// to declare a string type variable named date to store the value getting from user

            acc.deposit(amt, date);//to update balance amount and date by calling deposit method 
            System.out.println("Deposit Amount Successfull");// to print a transaction sucessfull message for user
        }

    }

    public void menuOption5() {// to create a void method to call withdraw method and update the balance by substracting withdraw amount
        System.out.println("Enter account id: ");// to prompt user to enter account number where the amount will be withdrawn
        int id = input.nextInt();// to declare an integer type variable named id to store the user input 
        BankAccount acc = findAccount(id);// to declare a variable named acc to store id if it is found by calling findAccount method
        if (acc != null) {// to check if acc is not null
            System.out.println("Withdraw Amount: ");// to prompt user to enter the withdraw amount
            float amt = input.nextFloat();// to declare a float typed variable named amt to store user input amount value
            System.out.println("Date: (MM/DD/YY): \"");// to prompt user to enter a date when transaction took place
            String date = input.next();// to declare a string type variable named date to store the value getting from user
            acc.withdraw(amt, date);//to update balance amount and date by calling withdraw method 

        }
    }

    public void menuOption6() {// to create a void method to call transfer method to update the sender and receiver balance and transaction date
        System.out.println("Enter sender Id: ");// to prompt user to enter sender
        int senderId = input.nextInt();//  to declare an interger type variable named senderId to take user input
        BankAccount sender = findAccount(senderId);// to create a variable named sender by calling findAccount method to see if the uer input senderId is found

        System.out.println("Enter Receiver Id: ");//to prompt user to enter receiver id which will receive the transfered amount
        int receiverId = input.nextInt();// to declared an integer type variable to store user input for receiver id
        BankAccount receiver = findAccount(receiverId);// to declare a variable named receiver by calling findAccount if receiver id is found in record

        if (sender != null && receiver != null) {// to check if sender and receiver variable is not null
            System.out.println("Transfer Amount: ");// to prompt user to enter desired transfer amount
            float amt = input.nextFloat();//to declare a float type variable named amt to store the user input amount to transfer

            System.out.println("Date: (MM/DD/YY): \n");// to prompt user to enter a date of the transaction
            String date = input.next();// to declare a string type variable to store the user input transaction date
            sender.transfer(amt, receiver, date);// to update balance (sender and receiver) and transaction date by calling transfer method

        } else {
            System.out.println("One or both account IDs are invalid");//to print message if the any of the Ids is invalid or null
        }
    }

    private BankAccount findAccount(int id) {// to create a method named findAccount
        for (BankAccount acc : accounts) {// to start for loop to run through accounts array to check if the acc is in the accounts array
            if (acc.getAccountNumber() == id) {//to check the id passed through this method is equal to the account number getting from getter method
                return acc;//to return acc variable value if the above line condition is true
            }
        }
        System.out.println("Account not found. ");// to print a message if the above condition is false
        return null;//to return null value if the above condition is false.
    }

    private void printAccount(BankAccount acc) {// to create a void method to display account information 
        System.out.println("Account Number: " + acc.getAccountNumber());// to call getter method from BankAccount class to diplay account number
        System.out.println("Account Name: " + acc.getFirstName() + " " + acc.getLastName());// to call getter methods from BankAccount class named getFirstName() and getLastName() to diplay full name 
        System.out.println("Account Balance: " + acc.getBalance());// to call getter method named getBalance from BankAccount Class to display update balance
        System.out.println("Last Transaction Date: " + acc.getLastTransaction());// to call getter method named getLastTransaction method from BankAccount class to diplay last transation date.
    }

    public static void main(String[] args) {
        BankAccountDriver program = new BankAccountDriver();//to Instantiate the BankAccountDriver class to access its non-static methods.
        program.getData();// to Call getData() to initialize the array and populate it with the bank account data.
        int choice;//to declare a variable to store the user's menu selection.
        //to start a do-while loop, This will run the code inside at least once
        do {
            choice = program.showMenu();//display the menu and store the integer entered by the user.
            program.executeChoices(choice);// to pass the user's choice to the executor method to run the corresponding logic.
        } while (choice != 7);// to terminate the loop when choice equals 7 (Exit).
        System.out.println("Thank you for using our BankAccount Application.");// to print a goodbye message for user.
    }

}
