/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BankAccountProgramFileHandler;

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
 * @param amount will be added to balance each time if it is more then zero
 * @param lastTransaction value will be updated
 */
    public void deposit(float amount, Date lastTransaction) {
        if (amount > 0) {//to check negative amount
            balance = balance + amount;
            this.lastTransaction = lastTransaction;
        }
    }
/**
 * this method will do withdrawal
 * @param amount will be deducted from balance every time if is positive and greater than and equal balance
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
 * @param amount will be added to depositor account and deducted from sender account
 * @param account, this account is other account or receiving account
 * @param lastTransaction will be updated every time
 */
    public void transfer(float amount, BankAccount account, Date lastTransaction) {
        if (amount > 0 && balance >= amount) {//to  check negative amount and insufficient balance
            withdraw(amount, lastTransaction);
            account.deposit(amount, lastTransaction);
        } else {
            System.out.println("Amount Can not be transfered.");
        }

    }
/**
 * Converts the account object into a space-separated string record
 * @return a formatted string suitable for file storage.
 * We concatenate the fields using the addition (+) operator and spaces " "
 * Takes the current  values stored in the object's memory and glue them together to made a single line of text
 */
public String writeAsRecord ()
{
    String result=" ";
    result =accountNumber+" "+
            firstName+" "+
            lastName+" "+
            middleInit+" "+
            balance+" "+
            lastTransaction.getYear()+" "+
            lastTransaction.getMonth()+" "+
            lastTransaction.getDay();
    
    return result;
}
}