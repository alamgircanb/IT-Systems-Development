/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */ 

package bankaccount;

/**
 *
 * @author Alamgir
 */
public class BankAccount {//To create a public class named BankAccount
//to create object instances

    private int accountNumber;
    private String firstName;
    private String lastName;
    private char middleInit;
    private float balance;
    private String lastTransaction;

    // to create a default constructor
    public BankAccount() {

    }

    public BankAccount(int accountNumber, String firstName, String lastName, char middleInit, float balance, String lastTransaction) {// to create a constructor with 6 parameter to update class instances. 
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
        if (accountNumber > 0) {//to check the number is Non negative
            this.accountNumber = accountNumber;
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {// to create a setter method to update firstName instance variable
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {// to create a setter method to update lastName instance variable
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

    public String getLastTransaction() {
        return lastTransaction;
    }

    public void setLastTransaction(String lastTransaction) {
        this.lastTransaction = lastTransaction;
    }

    /**
     * This method will do deposit operations and update the balance and
     * lastTransaction date
     *
     * @param amount
     * @param lastTransaction
     */
    public void deposit(float amount, String lastTransaction) {
        if (amount > 0) {//to check negative amount
            balance += amount;
            this.lastTransaction = lastTransaction;
        }
    }

    /**
     * This method will do withdrawal operations
     *
     * @param amount will update the balance
     * @param lastTransaction will be updated
     */
    public void withdraw(float amount, String lastTransaction) {//to create a void type method named withdraw with two parameters
        if (amount > 0 && balance >= amount) {//to check negative amount and existing balance is greater than or equal withdraw amount
            balance -= amount;
            this.lastTransaction = lastTransaction;
            System.out.println("Transaction Successfull");
        }
    }

    /**
     *
     * @param amount will update the balance
     * @param account balance will be updated
     * @param lastTransaction will be updated
     */
    public void transfer(float amount, BankAccount account, String lastTransaction) {//to create a void type method named transfer with three parameters
        if (amount > 0 && balance >= amount) {
            this.withdraw(amount, lastTransaction);
            account.deposit(amount, lastTransaction);
        }

    }
}
