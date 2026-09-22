/*
 4. A car company wants to determine the speed of their vehicles. Write a
program that allows them to input the distance travelled in kilometers
and the time taken for three trips. The program should calculate and
display the speed of each trip in kilometers per hour. Additionally, the
program should display the average speed of all the trips. These KPH
rates should be able to contain decimal values. Use counted repetition
(for loop) to obtain the data from the user.
 */
package Question_4_carspeed;

import java.util.Scanner;//to import the scanner utility for capturing user input

/**
 *
 * @author User
 */
public class Question_4_carspeed {// to define public class

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {// to define main method and program will start from here.

        Scanner input;// to declare a variable inside scanner
        input = new Scanner(System.in);            // to set input as new Scanner method inside Sanner utility
        double averageSpeed = 0;                           // to declare a variable named averageSpeed with initial value Zero.
        double totalSpeed = 0;                             // to declare a variable named totalSpeed with initial value Zero.
        for (int counter = 1; counter <= 3; counter++) {   //to start for loop to run until counter 3 with interger variable i initial value zero.
            double travelDistance;                         // to delcare variable named travelDistance to store distance in KM, it will be used to store user input
            double travelTime;                            //to delcare variable named travelTime to store time given by user
            double carSpeed;                              // to declare variable carSpeed to store speed for every trip
            
            System.out.println("please Enter the Distance Travelled in KM:");    //to prompt user to enter travel distance
            travelDistance = input.nextDouble();           //to store user travel distance in travelDistance variable
            
            System.out.println("please Enter the Time Taken in Hour:");   //to prompt user to enter travel time
            travelTime = input.nextDouble();               // to store user entered travel time into variable
            carSpeed = travelDistance / travelTime;        // to calculate car speed for every trip
           
            System.out.printf("Car Speed %d is (kph):%.2f%n", counter, carSpeed);   //to print trip number and trip spreed
            totalSpeed += carSpeed;                       //to calculate total speed by adding every trip speed
            averageSpeed = totalSpeed / counter;          // to calculate average speed speed from total speed and trip number
        }
        
        System.out.printf(" Average Car speed is (kph): %.2f%n", averageSpeed);   // to print average speed of all trip
        
        input.close();// to close the scanner object after use
    }
}
