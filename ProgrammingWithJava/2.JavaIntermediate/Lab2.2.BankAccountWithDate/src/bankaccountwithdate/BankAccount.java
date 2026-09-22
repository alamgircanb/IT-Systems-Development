/*
 *  UML   
-accountNumber : int
-firstName : String
-lastName : String
-middleInit : char
-balance : float
-lastTransaction : Date 
 + BankAccount()
 + BankAccount (accountNumber : int, firstName : String, lastName : String, middleInit : char,balance : float, lastTransaction : Date)
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
     + getLastTransaction() : Date
     + setLastTransaction (lastTransaction: Date)
     + deposit (amount : float, lastTransaction : Date)
//balance=balance+amount
//and set new lastTransaction date
//only set positive amounts
     + withdraw (amount : float, lastTransaction : Date)
     + transfer (amount : float, account : BankAccount, lastTransaction : Date)
 */
package bankaccountwithdate;

/**
 *
 * @author Alamgir
 */
public class BankAccount {
//to create instances for the class
    private int accountNumber;
    private String firstName;
    private String lastName;
    private char middleInit;
    private float balance;
    private Date lastTransaction;
    
// to create a default constructor
    public BankAccount() {

    }
    public BankAccount(int accountNumber, String firstName, String lastName, char middleInit, float balance, Date lastTransaction) {
        this.accountNumber = accountNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleInit = middleInit;
        this.balance = balance;
        this.lastTransaction = lastTransaction;
    }

    public int getAccountNumber() {
        return accountNumber;
    }
    public void setAccountNumber(int accountNumber) {
        if (accountNumber > 0) {//Non negative accountNumber only
            this.accountNumber = accountNumber;
        } else {
            System.out.println("Account Number must be positive");
        }
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public char getMiddleInit() {
        return middleInit;
    }
    public void setMiddleInit(char middleInit) {
        this.middleInit = middleInit;
    }

    public float getBalance() {
        return balance;
    }
    public void setBalance(float balance) {
        this.balance = balance;
    }
    public Date getLastTransaction() {
        return lastTransaction;
    }
    public void setLastTransaction(Date lastTransaction) {
        this.lastTransaction = lastTransaction;
    }
/**
 * this method will do deposit
 * @param amount
 * @param lastTransaction 
 */
    public void deposit(float amount, Date lastTransaction) {
        if (amount > 0) {//to check negative amount
            balance = balance + amount;
            this.lastTransaction = lastTransaction;
        }
    }
/**
 * this method will do withdrawal
 * @param amount
 * @param lastTransaction 
 */
    public void withdraw(float amount, Date lastTransaction) {
        if (amount > 0 && balance >= amount) {//to check negative amount and existing balance is greater than or equal withdraw amount
            balance = balance - amount;
            this.lastTransaction = lastTransaction;
            System.out.println("Transaction Successfull");
        } else {
            System.out.println("Amount Can not be withdrawn. ");
        }
    }
/**
 *this method will transfer amount from a account to another account
 * @param amount
 * @param account
 * @param lastTransaction 
 */
    public void transfer(float amount, BankAccount account, Date lastTransaction) {
        if (amount > 0 && balance >= amount) {//to  check negative amount and insufficient balance
            this.withdraw(amount, lastTransaction);
            account.deposit(amount, lastTransaction);
        } else {
            System.out.println("Amount Can not be transfered.");
        }

    }
}
