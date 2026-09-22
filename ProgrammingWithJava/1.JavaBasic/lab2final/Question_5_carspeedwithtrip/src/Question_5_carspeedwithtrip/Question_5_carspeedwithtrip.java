/*
 5. Create a copy of the code from question 4 and modify it so that the
user can input the number of trips. Keep this as a separate program.
 */
package Question_5_carspeedwithtrip;

import java.util.Scanner; //to import the scanner utility for capturing user input

/**
 *
 * @Md Alamgir Hossain
 */
public class Question_5_carspeedwithtrip {  // to define public class

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) { // to define main method and program will start from here.

        Scanner input;
        input= new Scanner(System.in); // to declare input variable  inside scanner method
        double averageSpeed = 0;       // to declare a double variable named average speed with initial value Zero
        double totalSpeed = 0;          // to declare a double variable named totalSpeed with initial value Zero
        int numberOfTrip;             // to declare an integer variable named numberOfTrip 
        System.out.println("Please Enter your number of trip:");     // to prompt user to enter number of trips
        numberOfTrip = input.nextInt();        // to store number of trip inside input method
        if (numberOfTrip != (int) numberOfTrip) {    // to check number of trips is whole number or not
            System.out.println("Error: Please Enter a Whole number");  //to print if the condtion is true means the input is not whole number
        } else {                                     // to run the program if the user trip number is a whole number
            for (int counter = 1; counter <= numberOfTrip; counter++) {   // to run a for loop until the trip number given by user
                double travelDistance;       //to declare a variable named travelDistance to store the travel distance value
                double travelTime;       // to declare a variable named travelTime to store the travel time got from user
                double carSpeed;         // to declare a variable to store carSpeed getting from distance and time

                System.out.println("please Enter the Distance Travelled in KM:");      //to prompt user to enter travelling distance
                travelDistance = input.nextDouble();      // to store travelling distance into the variable

                System.out.println("please Enter the Time Taken in Hour:");     // to prompt user to enter travelling time 
                travelTime = input.nextDouble();           // to store user input into travelTime variable
                carSpeed = travelDistance / travelTime;       // to calculate trip speed for every trip

                System.out.printf("Car Speed For Trip Number %d is (kph):%.2f%n", counter, carSpeed);     // to print counter/trip number and car speed for every trip
                totalSpeed += carSpeed;             // to calculate total speed by adding every trip car speed
                averageSpeed = totalSpeed / counter;      // to calculate average speed dividing total speed by counter/trip number
            }
        }
        System.out.printf(" Average Car speed is (kph): %.2f%n", averageSpeed);     // to print the average speed for user
        input.close();// to close the scanner object after use
    }
}
