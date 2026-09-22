/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BankAccountProgram;

/**
 * @author User
 */
public class Customer extends Person implements Comparable {

    private int customerId;

    public Customer() {
    }

    public Customer(int customerId, String firstName, String lastName, char middleInit) {
        super(firstName, lastName, middleInit);
        this.customerId = customerId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    /**
     * returns the details of the customer for display
     *
     * @return customer (customerID from this class and first name, last name
     * and middle initial from parent class (Person))
     */
    @Override
    public String toString() {
        return customerId + ": " + getLastName() + "," + getFirstName() + "," + getMiddleInit();
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof Customer customer) {
            if (this.customerId > customer.customerId) {
                return 1;
            } else if (this.customerId < customer.customerId) {
                return -1;
            } else {
                return 0;
            }
        }
        return 0;
    }

}
