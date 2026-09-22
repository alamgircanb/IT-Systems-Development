/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package compositionclass;

/**
 *
 * @author User
 */

public class Student {
    public int id;
    private String name;
    private Course[] courses;
public Student(){
    courses =new Course[5];
}
public Student (int id, String name){
    this.id=id;
    this.name  = name;
    courses =new Course[5];
}
public int getId(){
    return id; 
}
public String getName(){
    return name;
}
public void setId(int id){
    this.id=id;
}
public void setName(String name){
        this.name=name;
}
/**
 * Allows course to be added to students courses array
 * @param index the place in the array the course will be added to 
 * @param course the course to add
 */
// Constructors, getters, setters, toString, they need JavaDoc comments
//enroll

public void enroll (int index, Course course){
    
    courses[index]=course;
}
/**
 * this function returns a course from the students course array at a given position.
 * @param index the index of the course to return
 * @return the course the student is enrolled in 
 */
public Course getCourseByIndex(int index) {
    Course result= new Course();//creating a new object called result
    result =courses [index];//assigning result to be equal to a course at te five index
    return result;
    
}
}

