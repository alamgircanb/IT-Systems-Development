/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package derivationinclass;

/**
 *
 * @author User
 */
public class Employee extends Person {
    private int id;
    private String position;
    
    
    //constructors will  go here
    public Employee (String firstName, String lastName, char middleInit, 
            int id, String position)
    {
        // super calls the constructor of the parent class
        super (firstName, lastName, middleInit);// super call the constructor of parent class
        this.id =id;
        this.position=position;
    }
    
    
    public int getId () {return id;}
    public String getPosition () {return position;}
    
    public void setId (int id) {this.id =id;}
    public void setPosition (String position) {this.position=position;}
    
    @Override
    public String toString()
    {
        return id+":"+getLastName()+","+getFirstName();
    }
    
}
