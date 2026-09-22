package compositionclass;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author User
 */
public class Course {

    //int courseCode
    private int courseCode;
    //string courseName
    private String courseName;
/** 
 * constructor to put default value for every course code.
 * 
 */
    //Blank construtor Default
    public Course() {
        courseCode = 999;
    }
/** 
 * 
 * @param courseCode
 * @param courseName 
 */
    //parameterized constructor
    public Course(int courseCode, String courseName) {
        this.courseCode = courseCode;
        this.courseName = courseName;
    }
/**
 * 
 * @return 
 */
    //getters and setters
    public int getCourseCode() {
        return courseCode;
    }
/**
 * 
 * @return 
 */
    public String getCourseName() {
        return courseName;
    }
/**
 * 
 * @param courseCode 
 */
    public void setCourseCode(int courseCode) {
        this.courseCode = courseCode;
    }
/**
 * 
 * @param courseName 
 */
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
/**
 * 
 * @return 
 */
    @Override
    public String toString() {
        return courseCode + ":" + courseName;
    }
}
