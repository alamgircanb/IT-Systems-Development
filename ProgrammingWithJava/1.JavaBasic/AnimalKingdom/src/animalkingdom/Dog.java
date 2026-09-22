/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package animalkingdom;

/**
 *
 * @author User
 */
public class Dog extends Animal implements Noisy{

    public Dog() {
    }
    public Dog (String name)
    {
     super(name);
    }
    
    @Override
    public void makeNoise()
    {
        System.out.println(getName()+":Bark");
    }
    public void fetch()
    {
        System.out.println("sdkjfkdsjfksdjfkdsjdkfjds");
    }
}
