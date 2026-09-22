/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package animalkingdom;

/**
 *
 * @author User
 */
public interface Noisy {
    //all properties in an interface must be final (constant)
    public final boolean isNoisy = true;
    
    
    // all methods in an interface are abstract by default, so you do not need
    // the keyword "abstract"
    public void makeNoise();
    
}
