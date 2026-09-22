/*
Date
- month : int
- day : int
- year : int
+ Date( day : int, month : int, year : int)
+ setDay( int day) : void
+ setMonth(int month) : void //only 1 - 12
+ setYear(int year) : void
+ getDay() : int //should check leap year
+ getMonth() : int
+ getYear() : int
+ toString(): String
 */
package bankaccountwithdate;

/**
 *
 * @author User
 */
public class Date {
    private int month;
    private int day;
    private int year;

    public Date(int day, int month, int year) {
        this.month = month;
        this.day = day;
        this.year = year;
    }
    public void setDay(int day) {
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
    public void setYear(int year) {
        this.year = year;
    }
    public int getDay() {
            return day;
        }
    public int getMonth() {
        return month;
    }
    public int getYear() {
        return year;
    }
    public String toString() {
        return day + "/" + month + "/" + year;
    }
}
