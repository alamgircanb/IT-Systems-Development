/*
 This Java program calculates the average speed of a car over an indefinite number of trips, terminating the input process only when the user enters -1 for the travel distance. It uses a do-while loop for this input control.

Code Functionality
The program's key feature is the use of a do-while loop, which ensures that the block of code inside the loop executes at least once before checking the termination condition.

1. Trip Calculation Loop
The do block runs, prompting the user for:

Travel Distance (KM): Read into travelDistance.

Travel Time (Hours): Read into travelTime.

Inside the loop, it calculates the carSpeed, adds it to the running totalSpeed, and increments the numberOfTrip counter.

2. Termination Condition
The loop continues as long as the travelDistance entered is NOT equal to -1 (while (travelDistance != -1)).

3. Post-Loop Calculation and Error
After the loop terminates (meaning the user entered −1 for distance):

The program calculates the averageSpeed using: totalSpeed / numberOfTrip.

CRITICAL FLAW: When the user enters −1 to terminate the loop, this last, invalid input is included in the totalSpeed (though it was never used in the speed calculation) and, more importantly, the numberOfTrip counter is incremented one final time. This results in an incorrect average and trip count.

Detailed Line-by-Line Explanation
Line(s)	Code/Comment	Explanation
13−14	Scanner input; input = new Scanner(System.in);	Initializes the Scanner object to read user input.
15	double averageSpeed;	Declares a variable to store the final average speed.
16	double totalSpeed = 0;	Declares and initializes a variable to sum all the individual speeds.
17	int numberOfTrip = 0;	Declares and initializes a counter for the number of valid trips recorded.
18	double travelDistance;	Declares the variable for travel distance. This variable is used for the loop's termination condition.
20	do {	Starts the do-while loop. The code inside the do block executes first.
22−23	double travelTime; double carSpeed;	Declares variables inside the loop for time and speed of the current trip.
25	System.out.println("please Enter the Distance Travelled in KM:");	Prompts for distance.
26	travelDistance = input.nextDouble();	Reads the distance. If the user enters −1 here, the loop will terminate after this iteration.
27	System.out.println("please Enter the Time Taken in Hour:");	Prompts for time.
28	travelTime = input.nextDouble();	Reads the time. This step executes even if the distance was −1.
29	carSpeed = travelDistance / travelTime;	Calculates the speed. If travelDistance is −1, the calculated speed is −1/travelTime.
30	System.out.printf("Car Speed is (kph):%.2f%n", carSpeed);	Prints the calculated speed (which is incorrect if distance was −1).
31	totalSpeed += carSpeed;	Adds the (potentially incorrect) carSpeed to totalSpeed.
33	numberOfTrip++;	Increments the trip counter, even if the current "trip" was the −1 termination signal.
34	} while (travelDistance != -1);	Checks the condition. If travelDistance is not −1, the loop repeats from the top of the do block.
35	averageSpeed = totalSpeed / numberOfTrip;	Calculates the final average. This division uses the flawed totalSpeed and the inflated numberOfTrip.
36	System.out.println("Total Number of trip is: " + numberOfTrip);	Prints the final, inflated trip count.
37	System.out.printf(" Average Car speed is (kph): %.2f%n", averageSpeed);	Prints the final, incorrect average speed.
38	input.close();	Closes the scanner.

Export to Sheets
Correction for Robust Termination
To correct the flaw, the input validation and calculation should be wrapped in an if statement inside the loop, ensuring calculations and counting only happen for valid trips:

Java

// Inside the do-while loop, after reading travelDistance
if (travelDistance != -1) {
    // Read travelTime
    // Calculate carSpeed
    // Print carSpeed
    // totalSpeed += carSpeed;
    // numberOfTrip++;
}
// while (travelDistance != -1); // The condition remains the same
This ensures that the calculation and counting steps are skipped when the termination value is entered.
 */
package iterationlectpractice;

import java.util.Scanner;

/**
 *
 * @author User
 */
public class q6terminate {

    public static void main(String[] args) {
        // TODO code application logic here
        Scanner input;
        input = new Scanner(System.in);
        double averageSpeed;
        double totalSpeed = 0;
        int numberOfTrip = 0;
        double travelDistance;

        do {

            double travelTime;
            double carSpeed;

            System.out.println("please Enter the Distance Travelled in KM:");
            travelDistance = input.nextDouble();
            System.out.println("please Enter the Time Taken in Hour:");
            travelTime = input.nextDouble();
            carSpeed = travelDistance / travelTime;
            System.out.printf("Car Speed is (kph):%.2f%n", carSpeed);
            totalSpeed += carSpeed;

            numberOfTrip++;
        } while (travelDistance != -1);
        averageSpeed = totalSpeed / numberOfTrip;
        System.out.println("Total Number of trip is: " + numberOfTrip);
        System.out.printf(" Average Car speed is (kph): %.2f%n", averageSpeed);
        input.close();// to close the scanner object after use
    }
}
