/*
 This Java program calculates the average speed of a car over a user-specified number of trips. It prompts the user for the number of trips first, then iterates that many times to collect distance and time for each segment.

Code Functionality
The program first asks the user for the number of trips they want to analyze. It uses this number to control a for loop.

1. Trip Initialization
The program prompts for and reads the desired number of trips into the numberOfTrip integer variable.

The code includes a seemingly redundant check: if (numberOfTrip != (int) numberOfTrip). Since numberOfTrip is already declared as an int and read using input.nextInt(), it will always be an integer. This check doesn't provide practical input validation for this specific setup and will always evaluate to false.

2. Iteration and Calculation
If the (always true) validation passes, a for loop runs from counter = 1 up to and including the value of numberOfTrip.

Inside the loop, for each trip, the user inputs the distance (KM) and time (Hours).

Segment Speed is calculated: carSpeed = travelDistance / travelTime.

This segment speed is printed, added to the totalSpeed accumulator, and used to calculate the running averageSpeed by dividing totalSpeed by the current counter.

3. Final Output
After the loop completes, the program prints the final overall average car speed, formatted to two decimal places.

Detailed Line-by-Line Explanation
Line(s)	Code/Comment	Explanation
13−14	Scanner input; input = new Scanner(System.in);	Initializes the Scanner object for reading input.
15−16	double averageSpeed = 0; double totalSpeed = 0;	Declares and initializes double variables to track the average and the sum of all calculated segment speeds.
17	int numberOfTrip;	Declares an integer variable to store the number of trips the user wants to calculate.
18−19	System.out.println("Please Enter..."); numberOfTrip = input.nextInt();	Prompts the user for the number of trips and reads the integer input.
20	if (numberOfTrip != (int) numberOfTrip) {	Validation Check: This line is logically redundant as numberOfTrip is an int and input.nextInt() ensures an integer is read. If the user enters non-integer text, the program will crash with an InputMismatchException before this line is reached.
21	System.out.println("Error: Please Enter a Whole number");	The error message that would be printed if the redundant check were true (it never will be, but handles the if block).
22	} else {	The primary program logic executes here.
23	for (int counter = 1; counter <= numberOfTrip; counter++) {	Starts a for loop that runs numberOfTrip times, with counter tracking the current trip number (from 1 up to numberOfTrip).
24−26	double travelDistance; double travelTime; double carSpeed;	Declares double variables to hold the input and calculated speed for the current trip.
27−30	System.out.println("please Enter..."); travelDistance = input.nextDouble(); System.out.println("please Enter..."); travelTime = input.nextDouble();	Prompts for and reads the distance (KM) and time (Hours) for the current trip.
31	carSpeed = travelDistance / travelTime;	Calculates the speed for the current segment (KM/H).
32	System.out.printf("Car Speed %d is (kph):%.2f%n", counter, carSpeed);	Prints the current trip's speed, formatted to two decimal places.
33	totalSpeed += carSpeed;	Accumulates the current segment speed into the totalSpeed variable.
34	averageSpeed = totalSpeed / counter;	Calculates the running average speed by dividing the sum of speeds by the number of trips completed so far (counter).
35	}	Closes the for loop.
37	System.out.printf(" Average Car speed is (kph): %.2f%n", averageSpeed);	Prints the final average speed after all trips have been processed.
38	input.close();	Closes the Scanner object.
 */
package iterationlectpractice;

import java.util.Scanner;

/**
 *
 * @author User
 */
public class q5carspeedwithtrip {

    public static void main(String[] args) {

        Scanner input;
        input = new Scanner(System.in);
        double averageSpeed = 0;
        double totalSpeed = 0;
        int numberOfTrip;
        System.out.println("Please Enter your number of trip:");
        numberOfTrip = input.nextInt();
        if (numberOfTrip != (int) numberOfTrip) {
            System.out.println("Error: Please Enter a Whole number");
        } else {
            for (int counter = 1; counter <= numberOfTrip; counter++) {
                double travelDistance;
                double travelTime;
                double carSpeed;
                System.out.println("please Enter the Distance Travelled in KM:");
                travelDistance = input.nextDouble();
                System.out.println("please Enter the Time Taken in Hour:");
                travelTime = input.nextDouble();
                carSpeed = travelDistance / travelTime;
                System.out.printf("Car Speed %d is (kph):%.2f%n", counter, carSpeed);
                totalSpeed += carSpeed;
                averageSpeed = totalSpeed / counter;
            }
        }
        System.out.printf(" Average Car speed is (kph): %.2f%n", averageSpeed);
        input.close();// to close the scanner object after use
    }
}
