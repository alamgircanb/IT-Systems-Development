/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package derivationinclass;

/**
 *
 * @author User
 */
public class Person {

    private String firstName;
    private String lastName;
    private char middleInit;

    public Person(String firstName, String lastName, char middleInit) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleInit = middleInit;

    }

    public String getFirstName() {return firstName;}

    public String getLastName() {return lastName;}

    public char getMiddlInit() {return middleInit;}

    public void setFirstName(String firstName) {this.firstName = firstName;}

    public void setLastName(String lastName) {this.lastName = lastName;}

    public void setMiddlInit(char middleInit) {this.middleInit = middleInit;}

    public String toString() {
        return lastName + "," + firstName + " " + middleInit + ".";
    }

}
