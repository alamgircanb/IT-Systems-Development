/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */ 

package BankAccountProgram;

/**
 * @author User
 */
public abstract class BankAccount implements Comparable{
    
    private int accountNumber;
    private Customer customer;
    private float balance;
    private Date lastTransaction;
    
    public BankAccount() {}
    
    public BankAccount(int accountNumber, Customer customer, float balance, Date lastTransaction) {
        this.accountNumber = accountNumber;
        this.customer = customer;
        this.balance = balance;
        this.lastTransaction = lastTransaction;
    }
    
    public int getAccountNumber() {return accountNumber;}
    
    public void setAccountNumber(int accountNumber) {
        //Non negative accountNumber only
        if (accountNumber > 0) {
            this.accountNumber = accountNumber;
        } else {
            System.out.println("Account Number must be positive");
        }
    }
    
    public Customer getCustomer() {return customer;}
    public void setCustomer(Customer customer) {this.customer = customer;}
    public float getBalance() {return balance;}
    public void setBalance(float balance) {this.balance = balance;}
    public Date getLastTransaction() {return lastTransaction;}
    public void setLastTransaction(Date lastTransaction) {this.lastTransaction = lastTransaction;}

    /**
     * this method will do deposit
     * @param amount will be added to balance each time if it is more then zero
     * @param lastTransaction value will be updated
     */
    
    public void deposit(float amount, Date lastTransaction) {
        //to check negative amount
        if (amount > 0) {
            balance = balance + amount;
            this.lastTransaction = lastTransaction;
        }
    }

    /**
     * this method will transfer amount from a account to another account
     * @param amount will be deposited to receiving account and deducted from sender account
     * @param otherAccount, this account is other account or receiving account
     * @param lastTransaction will be updated every time
     */
    
    public void transfer(float amount, BankAccount otherAccount, Date lastTransaction) {
        if (amount > 0 && balance >= amount) {
            withdraw(amount, lastTransaction);
            otherAccount.deposit(amount, lastTransaction);
        } else {
            System.out.println("Amount Can not be transfered.");
        }
    }

    /**
     * an abstract method of this class,and will not have any logic inside it
     * @param amount will be deducted from balance every time if is positive and greater than and equal balance
     * @param lastTransaction
     */
    public abstract void withdraw(float amount, Date lastTransaction);
    
    @Override
    public int compareTo(Object o) {
        if(o instanceof BankAccount bankAccount)
        {
        if (this.accountNumber > bankAccount.accountNumber) {
            return 1;
        }
        else if (this.accountNumber < bankAccount.accountNumber) {
            return -1;
        } 
        else {
            return 0;
        }
        }
        return 0;
    }
}
