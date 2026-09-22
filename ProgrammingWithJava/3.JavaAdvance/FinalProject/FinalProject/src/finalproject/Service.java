/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package finalproject;

/**
 *Parent class for all SQL service classes
 * @author User
 */
public abstract class Service {
    
    String command;
    
    public Service(String command)
    {
        this.command = command;
    }
    /***
     * abstract method for this abstract class, each child write its own version of this method
     */
    public abstract void doWork();
}
