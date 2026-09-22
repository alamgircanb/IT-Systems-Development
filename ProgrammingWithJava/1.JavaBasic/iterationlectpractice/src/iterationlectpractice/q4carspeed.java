/*
 This Java program calculates the individual speed and the average speed of a car over three separate travel segments. It uses a for loop to iterate three times, collecting distance and time for each segment.

Code Functionality
The program uses a for loop to run exactly three times (counter = 1 to 3). In each iteration (representing one travel segment), it:

Collects Input: Prompts the user to enter the distance traveled (in KM) and the time taken (in hours).

Calculates Segment Speed: Computes the speed using the formula: Speed=Distance/Time.

Prints Segment Speed: Displays the calculated speed for that segment, formatted to two decimal places.

Updates Totals: Adds the newly calculated carSpeed to the totalSpeed.

Calculates Running Average: Calculates the averageSpeed by dividing the totalSpeed by the current counter (which acts as the count of segments processed so far).

After the loop finishes, the program prints the final overall average speed and closes the scanner.

Detailed Line-by-Line Explanation
Line(s)	Code/Comment	Explanation
13−14	Scanner input; input = new Scanner(System.in);	Initializes the Scanner object input to read user data from the console.
15	double averageSpeed = 0;	Declares and initializes a double variable to track the average of the speeds.
16	double totalSpeed = 0;	Declares and initializes a double variable to accumulate the sum of all calculated speeds.
17	for (int counter = 1; counter <= 3; counter++) {	Starts a for loop. It initializes the counter to 1, runs as long as it's ≤3 (running for 1,2,3), and increments the counter by 1 after each iteration.
18−20	double travelDistance; double travelTime; double carSpeed;	Declares three double variables inside the loop to hold the input and result for the current segment.
21−22	System.out.println("...Distance..."); travelDistance = input.nextDouble();	Prompts the user and reads the distance (KM) as a decimal number.
23−24	System.out.println("...Time..."); travelTime = input.nextDouble();	Prompts the user and reads the time (Hours) as a decimal number.
25	carSpeed = travelDistance / travelTime;	Calculates the speed (kph) for the current segment.
26	System.out.printf("Car Speed %d is (kph):%.2f%n", counter, carSpeed);	Prints the current segment's speed, using printf to format the output to two decimal places.
27	totalSpeed += carSpeed;	Adds the current carSpeed to the totalSpeed accumulator.
28	averageSpeed = totalSpeed / counter;	Calculates the running average speed by dividing the accumulated total by the number of segments processed so far (counter).
29	}	Closes the for loop.
30	System.out.printf(" Average Car speed is (kph): %.2f%n", averageSpeed);	Prints the final average speed once the loop completes, again formatted to two decimal places.
31	input.close();	Closes the Scanner object to release system resources.

Export to Sheets
Example Calculation
Assume the user enters the following data:

Segment	Distance (KM)	Time (Hours)	Calculation (Speed)
1	100	2.0	100/2.0=50.00
2	150	3.0	150/3.0=50.00
3	200	4.0	200/4.0=50.00

Export to Sheets
Counter	carSpeed	totalSpeed	averageSpeed (totalSpeed / counter)
1	50.00	50.00	50.00/1=50.00
2	50.00	100.00	100.00/2=50.00
3	50.00	150.00	150.00/3=50.00

Export to Sheets

 */
package iterationlectpractice;

import java.util.Scanner;

/**
 *
 * @author User
 */
public class q4carspeed {

    public static void main(String[] args) {
        // TODO code application logic here
        Scanner input;
        input = new Scanner(System.in);
        double averageSpeed = 0;
        double totalSpeed = 0;
        for (int counter = 1; counter <= 3; counter++) {
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
        System.out.printf(" Average Car speed is (kph): %.2f%n", averageSpeed);
        input.close();// to close the scanner object after use
    }

}
