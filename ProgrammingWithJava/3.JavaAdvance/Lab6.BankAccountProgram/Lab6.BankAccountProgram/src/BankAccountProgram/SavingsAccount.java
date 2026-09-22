/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */ 

package BankAccountProgram;

/**
 * @author User
 */
public class SavingsAccount extends BankAccount {
    private float interestRate;

    public SavingsAccount() {}
    public SavingsAccount(int accountNumber, Customer customer, float balance, Date lastTransaction, float interestRate) {
        super(accountNumber, customer, balance, lastTransaction);
        this.interestRate = interestRate;
    }

    public float getInterestRate() {return interestRate;}
    public void setInterestRate(float interestRate) {this.interestRate = interestRate;}

    /**
     * Accrues interest over a given number of months. 
     * The balance is multiplied by (1 + interestRate) for each month.
     * @param months
     */
    public void accrueInterest(int months) {
        float currentBalance = getBalance();
        for (int i = 0; i < months; i++) {
            // Multiply the balance by the rate for every month, 10% interest rate means balance * 1.10
            currentBalance = currentBalance * (1 + (interestRate / 100));
        }
        setBalance(currentBalance);
        System.out.println("Interest accrued for " + months + " months.");
    }

    /**
     * Overrides the abstract withdraw method from BankAccount. 
     * Savings accounts do not allow overdrafting.
     */
    @Override
    public void withdraw(float amount, Date lastTransaction) {
        //must have sufficient balance 
        if (amount > 0 && getBalance() >= amount) {
            setBalance(getBalance() - amount);
            setLastTransaction(lastTransaction);
            System.out.println("Transaction Successful (Savings)");
        } else {
            System.out.println("Insufficient funds in Savings Account.");
        }
    }
}
