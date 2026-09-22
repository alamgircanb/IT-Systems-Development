/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package iterationlectpractice;

import java.io.PrintStream;
import java.util.Scanner;

/**
 *
 * @author User
 */
public class percentOddEven7 {

    public static void main(String[] args) {
        // TODO code application logic here
        Scanner input = new Scanner(System.in);
        int counter = 0;
        double countOdd = 0;
        double percentOdd;
        double countEven = 0;
        double percentEven;
        int reminder;
        int number;
        while (counter < 7) {
            System.out.println("Enter your enter:");
            number = input.nextInt();
            reminder = number % 2; // to Find remainder = number % 2.

            if (reminder != 0) {
                // to check the moduler math result is Zero
                countOdd++;
                System.out.println("Even Count is :" + countEven);
                System.out.println(" Odd Count is: " + countOdd);

            } else if (reminder == 0) {
                // to check the moduler math result is Zero
                countEven++;
                System.out.println("Even Count is :" + countEven);
                System.out.println(" Odd Count is: " + countOdd);

            }
            counter++;
            System.out.println("Counter Number is: " + counter);

        }
        percentEven = (countEven / 7) * 100;
        percentOdd = (countOdd / 7) * 100;

        System.out.printf("ODD Percentile is: %.2f%n", percentOdd);
        System.out.printf("Even Percentile is:%.2f%n", percentEven);
    }
}
