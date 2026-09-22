/*
 6. Create another copy of the code from question 4 and modify it so it
uses a sentinel value to terminate input. This means that the program
should continue accepting trips until a specific value (examples: 0, -1)
is entered in the kilometers travelled or the time taken. Do not use a
for loop for this version of the application. Keep this as a separate
program.
 */
package Question_6_stopwith_1ifcondi;

import java.util.Scanner;//to import the scanner utility for capturing user input

/**
 *
 * @Md Alamgir Hossaain
 */
public class Question_6_stopwith_1ifcondi { // to define public class

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) { // to define main method and program will start from here.
        Scanner input;
        input = new Scanner(System.in);  //to delcare input variable inside scanner method
        double averageSpeed;         // to declare a double variable named averageSpeed 
        double totalSpeed = 0;      // to declare a double variable named totalSpeed with an initial value Zero
        int numberOfTrip = 0;       //to declare a int variable named numberOfTrip with an initial value Zero
        double travelDistance = 0; //to declare a double variable named travelDistance with an initial value Zero

        while (travelDistance != -1) { //to run a while loop until travel distance user input is not minus one(-1)
            double travelTime;      //to declare a double variable named travelTime 
            double carSpeed;        // to declare a double variable named carSpeed

            System.out.println("please Enter the Distance Travelled in KM:"); //to prompt user to enter travelling distance
            travelDistance = input.nextDouble();    //to store user input into travelDistance variable

            if (travelDistance == -1) {     // to end up the loop if user input is -1 for the variable travel distance
                System.out.println("Done: Program terminated");     // to let user know that program is being ended
                System.out.println("I am happy to share your result now:");//to print a line before print the result

            } else {
                System.out.println("please Enter the Time Taken in Hour:");     //to prompt user to enter travelling time
                travelTime = input.nextDouble();        //to store user input into travelTime variable
                carSpeed = travelDistance / travelTime; // to calculate speed from dividing distance by time

                System.out.printf("Car Speed is (kph):%.2f%n", carSpeed);   // to print car speed for every trip
                totalSpeed += carSpeed;     // to calculate total speed by adding every car speed

                numberOfTrip += 1;              // to increase number of trip for every input from user
            }

        }
        averageSpeed = totalSpeed / numberOfTrip;       // to calculate average speed dividing total speed by number of trip

        System.out.println("Total Number of trip is: " + numberOfTrip);     //to print number of trip
        System.out.printf("Average Car speed is (kph): %.2f%n", averageSpeed);  // to print average speed for all trip

        input.close();// to close the scanner object after use
    }

}
