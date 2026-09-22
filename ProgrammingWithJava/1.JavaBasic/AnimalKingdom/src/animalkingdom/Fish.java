/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package animalkingdom;

/**
 *
 * @author User
 */
public class Fish extends Animal implements Noisy{

    public Fish() {}

    public Fish(String name) {
        super(name);
    }
    @Override
    public void makeNoise()
    {
        System.out.println("Blub Blub Blub");
    }
    
}
