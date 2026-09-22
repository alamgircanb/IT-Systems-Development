/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package animalkingdom;

/**
 *
 * @author User
 */
public class Cat extends Animal implements Noisy{

    public Cat() {}

    // allows us to access the parent class constructor
    public Cat(String name) {
        super(name);
    }
    
    @Override
    
    public void makeNoise()
    {
        System.out.println(getName()+": MeoW");
    }
    public void purr()
    {
        System.out.println("Perrr");
    }
}
