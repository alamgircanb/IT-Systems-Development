/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */ 

package BankAccountProgram;

/**
 * @author User
 */
public class ChequingAccount extends BankAccount {

    private float overDraftLimit;

    public ChequingAccount() {}

    public ChequingAccount(int accountNumber, Customer customer, float balance, Date lastTransaction, float overDraftLimit) {
        super(accountNumber, customer, balance, lastTransaction);
        this.overDraftLimit = overDraftLimit;
    }

    public float getOverDraftLimit() {return overDraftLimit;}
    public void setOverDraftLimit(float overDraftLimit) {this.overDraftLimit = overDraftLimit;}
    
    /**
     * @param amount
     * @param lastTransaction 
     */
    @Override
    public void withdraw(float amount, Date lastTransaction) {
        //Check if current balance + limit is enough to cover the amount 
        if (amount > 0 && (getBalance() + overDraftLimit) >= amount) {
            // Deduct amount from balance (can result in negative balance)
            setBalance(getBalance() - amount);
            setLastTransaction(lastTransaction);
            System.out.println("Transaction Successful (Chequing)");
        } else {
            System.out.println("Amount exceeds overdraft limit of " + overDraftLimit);
        }
    }
}
