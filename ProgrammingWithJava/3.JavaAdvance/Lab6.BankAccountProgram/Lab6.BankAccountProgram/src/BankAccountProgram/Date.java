/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */ 

package BankAccountProgram;

/**
 * @author User
 */
public class Date {

    private int year;
    private int month;
    private int day;

    public Date(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public void setDay(int day) {
        // creates a array to store last day of every months to validate the number of days in given month
        int[] days = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        //to check leap year
        if (month == 2 && day == 29 && (year % 400 == 0
                || (year % 4 == 0 && year % 100 != 0))) {
            this.day = day;
            System.out.println("day is valid");

            // to check day input is valid
        } else if (day < 1 || day > days[month]) {
            this.day = 1;
            System.out.println("day is not valid");
        } else {
            this.day = day;
            System.out.println("day is valid");
        }
    }

    public void setMonth(int month) {
        //to  validate the month, only 1 - 12 
        if (month >= 1 && month <= 12) {
            this.month = month;
        } else {
            // to take default value if month value is invalid or out of range
            this.month = 1;
        }
    }
    public void setYear(int year) {this.year = year;}
    public int getDay() {return day;}
    public int getMonth() {return month;}
    public int getYear() {return year;}

    /**
     * will be automatically called when Date object is called
     * @return a single text line of the date
     */
    @Override
    public String toString() {
        return year + ", " + month + ", " + day;
    }
}
