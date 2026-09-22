/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package compositionclass;

/**
 *
 * @author User
 */
public class CompositionClass {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Student s1=new Student (1001,"Mike");
        
        Course c1= new Course(233, "OOP with Java");// additinal code
        //add course c1 to the students courses array at position 0
        s1.enroll(0, new Course(233, "OOP with Java"));
        System.out.println("The student Has been enrolled in: "+c1);
        System.out.println("The student Has been enrolled in: "+s1);
        System.out.println("The student Has been enrolled in: "+s1.getCourseByIndex(0));
        System.out.println("The student Has been enrolled in: "+s1.getCourseByIndex(0).getCourseName());
        s1.getCourseByIndex(0).setCourseName("Alamgir");
        System.out.println("The student Has been enrolled in: "+s1.getCourseByIndex(0).getCourseName());
      
    }
    
    
}
