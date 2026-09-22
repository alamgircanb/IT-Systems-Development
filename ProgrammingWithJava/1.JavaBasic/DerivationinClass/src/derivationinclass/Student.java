/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package derivationinclass;

/**
 *
 * @author User
 */
public class Student extends Person {
    private int id;
    private String programName;
    private int Score;
    
    Student(String firstName, String lastName, char middleInit, int id, String programName, int Score)
    {
        super (firstName, lastName, middleInit);
        this.id=id;
        this.programName=programName;
    }
    public int getId () {return id;}
    public String getProgamName () {return programName;}
    
    public void setId (int id) {this.id =id;}
    public void setProgamName (String position) {this.programName=programName;}
    
    @Override
    public String toString()
    {
        return id+":"+getLastName()+","+getFirstName();
    }
    
}
