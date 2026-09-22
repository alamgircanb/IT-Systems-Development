/*
 This Java program calculates the average speed of a car over an unspecified number of trips, controlled by a sentinel value. It uses a while loop that continues as long as the distance entered is not -1.

This version is a significant improvement over the previous do-while version (q6terminate) because it correctly prevents the termination value (-1) from being included in the trip count or speed calculation.

Code Functionality
The program uses a while loop to repeatedly collect distance and time for car trips until the user enters the sentinel value of −1 for the distance.

1. Controlled Iteration
The loop runs as long as the travelDistance is not equal to −1 (while (travelDistance != -1)).

2. Immediate Termination Check
Inside the loop, the program immediately prompts for and reads the travelDistance.

It then uses an if statement to check if this newly read distance is −1.

If it is −1, the if block executes, printing termination messages. The loop condition (travelDistance != -1) will then be false at the end of the iteration, causing the loop to exit correctly.

If the distance is not −1, the else block executes, which contains all the calculation logic.

3. Calculation Logic (The else Block)
For a valid distance, the program:

Prompts for and reads the travelTime.

Calculates the carSpeed (Distance/Time).

Accumulates the carSpeed into totalSpeed.

Increments the numberOfTrip counter.

4. Final Output
After the loop terminates, the program calculates the final averageSpeed and prints the total number of trips and the final average speed.

Detailed Line-by-Line Explanation
Line(s)	Code/Comment	Explanation
13−14	Scanner input; input = new Scanner(System.in);	Initializes the Scanner object for console input.
15	double averageSpeed;	Declares a variable for the final average speed.
16	double totalSpeed = 0;	Initializes a double variable to accumulate the sum of all calculated speeds.
17	int numberOfTrip = 0;	Initializes an integer variable to count the number of valid trips.
18	double travelDistance = 0;	Initializes the distance variable. This initialization (0) ensures the while loop condition is true when the program starts.
20	while (travelDistance != -1) {	Starts the while loop. It will continue to run as long as the last entered distance is not equal to −1.
22−23	double travelTime; double carSpeed;	Declares temporary variables for the time and speed of the current segment.
24−25	System.out.println("...Distance..."); travelDistance = input.nextDouble();	Prompts the user for distance and reads the value. This value immediately determines the fate of the rest of the loop's iteration.
27	if (travelDistance == -1) {	Checks for the termination signal. If the user entered −1, the program enters this block.
28−29	System.out.println("Done: ..."); System.out.println("I am happy...");	Prints termination messages. No calculation or counting happens here.
31	} else {	The program enters this block only if a valid distance (not −1) was entered.
33	travelTime = input.nextDouble();	Reads the time for the current valid trip.
34	carSpeed = travelDistance / travelTime;	Calculates the speed (KM/H).
35	System.out.printf("Car Speed is (kph):%.2f%n", carSpeed);	Prints the current trip's speed.
36	totalSpeed += carSpeed;	Adds the current speed to the accumulator.
37	numberOfTrip += 1;	Increments the valid trip counter.
40	}	Closes the while loop. The program returns to line 20 to re-check while (travelDistance != -1).
41	averageSpeed = totalSpeed / numberOfTrip;	Calculates the final average using the accurately accumulated totalSpeed and numberOfTrip.
42	System.out.println("Total Number of trip is: " + numberOfTrip);	Prints the total count of valid trips.
43	System.out.printf("Average Car speed is (kph): %.2f%n", averageSpeed);	Prints the final average speed, formatted to two decimal places.
44	input.close();	Closes the scanner.

Export to Sheets
Logic Comparison to do-while 💡
This while loop with an if check is functionally superior for sentinel-controlled input than the basic do-while used in the previous example (q6terminate).

Method	Key Behavior	Result
Previous (do-while)	Reads distance, then performs calculations, then checks for −1.	The −1 input incorrectly results in 1 extra trip counted and a flawed speed calculation.
Current (while + if)	Reads distance, then checks for −1 with an if. Calculations are skipped if −1 is found.	The −1 input causes the loop to exit cleanly, leaving the counters and totals accurate.

 */
package iterationlectpractice;

import java.util.Scanner;

/**
 *
 * @author User
 */
public class q6terminateif {

    public static void main(String[] args) {
        // TODO code application logic here
        Scanner input;
        input = new Scanner(System.in);
        double averageSpeed;
        double totalSpeed = 0;
        int numberOfTrip = 0;
        double travelDistance = 0;

        while (travelDistance != -1) {

            double travelTime;
            double carSpeed;
            System.out.println("please Enter the Distance Travelled in KM:");
            travelDistance = input.nextDouble();

            if (travelDistance == -1) {
                System.out.println("Done: Program terminated");
                System.out.println("I am happy to share your result now:");

            } else {

                System.out.println("please Enter the Time Taken in Hour:");
                travelTime = input.nextDouble();
                carSpeed = travelDistance / travelTime;
                System.out.printf("Car Speed is (kph):%.2f%n", carSpeed);
                totalSpeed += carSpeed;
                numberOfTrip += 1;
            }

        }
        averageSpeed = totalSpeed / numberOfTrip;
        System.out.println("Total Number of trip is: " + numberOfTrip);
        System.out.printf("Average Car speed is (kph): %.2f%n", averageSpeed);
        input.close();// to close the scanner object after use

    }

}
