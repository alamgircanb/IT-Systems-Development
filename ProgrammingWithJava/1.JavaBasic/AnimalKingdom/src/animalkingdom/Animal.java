/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package animalkingdom;

/**
 *
 * @author User
 */
public abstract class Animal {
    private String name;
    public Animal(){}
    public Animal(String name) {this.name = name;}

    public String getName() {return name;
    }

    public void setName(String name) {
        this.name = name;
    }
   /**
    * the dafaul implementation of the makeNoise function.
    */
    
    public abstract void makeNoise ();
}
