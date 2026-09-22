/*
 *  UML   
    BankAccount
    -accountNumber : int
    -firstName : String
    -lastName : String
    -middleInit : char
    -balance : float
    -lastTransaction : String //date string 

     + BankAccount()
     + BankAccount (accountNumber : int, firstName : String, lastName : String, middleInit : char,balance : float, lastTransaction : String)
     + getAccountNumber() : int
     + setAccountNumber (accountNumber : int)//Non negative accountNumber only
     + getFirstName() : String
     + setFirstName(firstName : String)
     + getLastName() : String
     + setLastName(lastName : String)
     + getMiddleInit() : char
     + setMiddleInit( middleInit : char)
     + getBalance() : float
     + setBalance (balance : float)
     + getLastTransaction() : String
     + setLastTransaction (lastTransaction : String)
     + deposit (amount : float, lastTransaction : String)
//balance=balance+amount
//and set new lastTransaction date
//only set positive amounts
     + withdraw (amount : float, lastTransaction : String)
     + transfer (amount : float, otheccount : BankAccount, lastTransaction : String)


assumption: amount can not be withdrawn or transfered if it is greater then existing balance. There is not chance to get negative bank account balance.
 */
package bankaccount;

/**
 *
 * @author Alamgir
 */
public class BankAccount {//To create a public class named BankAccount

    private int accountNumber;// to create an interger type class instance variable named accountNumber to store account number
    private String firstName;// to create a string type class instance variable named firstName to store first name of the account
    private String lastName;// to create a string type class instance variable named lastName to store last name of the account 
    private char middleInit;// to create a char type class instance variable named middleInit to store middle initial 
    private float balance;// to create a float type class instance variable named balance to store account balance.
    private String lastTransaction; //to create a string type class instance variable named lastTransaction to store transaction date  as string

// Class Constructor Block
    public BankAccount() {// to create a constructor without any parameter

    }

    public BankAccount(int accountNumber, String firstName, String lastName, char middleInit, float balance, String lastTransaction) {// to create a constructor with 6 parameter to update class instances. 
        setAccountNumber(accountNumber);// to update accountNumvber by calling setter method (setAccountNumber), this method will update accountNumber and will check for non negative
        this.firstName = firstName;// to store the value passed by firstName parameter into class private instance firstName.
        this.lastName = lastName;//to store the value passed by lastName parameter into class private instance lastName.
        this.middleInit = middleInit;//to store the value passed by middleInit parameter into class private instance middleInit.
        this.balance = balance;//to store the value passed by balance parameter into class private instance balance.
        this.lastTransaction = lastTransaction;//to store the value passed by lastTransaction parameter into class private instance lastTransaction.
    }

    // Getter and Setter Block to access and update class private instances
    public int getAccountNumber() {// to create a getter method to get view only access to privte instance accountNumber
        return accountNumber;// return accountNumber (view only)
    }

    public void setAccountNumber(int accountNumber)// to create a setter method to update accountNumber instance variable 
    {// it will update the value of instance accountNumber with the passed through value of the parameter when this method called.
        if (accountNumber > 0) {//Non negative accountNumber only
            this.accountNumber = accountNumber;//to update the value of private class instance with the value passed through method parameter accountNumber
        }
    }

    public String getFirstName() {//to create a getter method to get view only access to privte instance firstName
        return firstName;//return first Name (view only)
    }

    public void setFirstName(String firstName) {// to create a setter method to update firstName instance variable
        this.firstName = firstName;//to update the value of private class instance firstName with the value passed through method parameter firstName
    }

    public String getLastName() {//to create a getter method to get view only access to privte instance lastName
        return lastName;//return last name (view only)
    }

    public void setLastName(String lastName) {// to create a setter method to update lastName instance variable
        this.lastName = lastName;//to update the value of private class instance lastName with the value passed through method parameter lastName
    }

    public char getMiddleInit() {//to create a getter method to get view only access to privte instance middle initial
        return middleInit;//return middle initial (view only)
    }

    public void setMiddleInit(char middleInit) {// to create a setter method to update middleInit instance variable
        this.middleInit = middleInit;//to update the value of private class instance middle initial with the value passed through method parameter middle initial
    }

    public float getBalance() {//to create a getter method to get view only access to privte instance balance
        return balance;//return balance (view only)
    }

    public void setBalance(float balance) {// to create a setter method to update balance instance variable
        this.balance = balance;//to update the value of private class instance balance with the value passed through method parameter balance
    }

    public String getLastTransaction() {//to create a getter method to get view only access to privte instance lastTransaction
        return lastTransaction;//return lastTransaction (view only)
    }

    public void setLastTransaction(String lastTransaction) {// to create a setter method to update lastTransaction instance variable
        this.lastTransaction = lastTransaction;//to update the value of private class instance lastTransaction with the value passed through method parameter lastTransaction
    }
// Void method block, they will update the private instance by calculating or doing mathmetical operation inside them.

    public void deposit(float amount, String lastTransaction) {//to create a void type method named deposit with two parameters
        if (amount > 0) {//to check negative amount
            this.balance += amount;//to update the value of class instance variable balance by adding amount every time called deposit method (balance=balance+amount)
            this.lastTransaction = lastTransaction;//to udpate the value of private class instance variable value every time when the deposit method is called (set new lastTransaction date)
        }
    }

    public void withdraw(float amount, String lastTransaction) {//to create a void type method named withdraw with two parameters
        if (amount > 0 && this.balance >= amount) {//to check negative amount and existing balance is greater than or equal withdraw amount
            this.balance -= amount;//to update the value of class instance variable balance by substracting amount every time called withdraw method (balance=balance-amount)
            this.lastTransaction = lastTransaction;//to udpate the value of private class instance variable value every time when the deposit method is called (set new lastTransaction date)
            System.out.println("Transaction Successfull");// to print a transaction sucessfull message for user
        } else {
            System.out.println("Amount Can not be withdrawn. ");// to print an unsuccessfull message
        }
    }

    public void transfer(float amount, BankAccount otherAccount, String lastTransaction) {//to create a void type method named transfer with three parameters
        if (amount > 0 && this.balance >= amount) {//to check negative amount and existing balance is greater than transfer amount
            this.withdraw(amount, lastTransaction);// to call withdraw method to update the instance variable value, it will substract the amount from balance
            otherAccount.deposit(amount, lastTransaction);// to call deposit method to update the otherAccount value, it will add the amount to otherAccount.
        } else {
            System.out.println("Amount Can not be transfered.");//to print an unsuccessfull message for user
        }

    }
}
