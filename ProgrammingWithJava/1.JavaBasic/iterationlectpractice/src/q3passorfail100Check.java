/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package iterationlectpractice;

import java.util.Scanner;// to import scanner library

/**
 *
 * @author User
 */
public class q3passorfail100Check {

    public static void main(String[] args) {
        // TODO code application logic here
        Scanner input = new Scanner(System.in);
        int counter = 0;
        int passMark = 50;
        int earnMark;

        while (counter < 5) {
            System.out.println("Enter your enter:");
            earnMark = input.nextInt();
            if (earnMark < 0 || earnMark > 100) {
                System.out.println("Your Enter Wrong, Please input 0-100");
            } else {
                if (earnMark >= passMark) {

                    System.out.println("Congratz: You Passed");
                } else {
                    System.out.println("Sorry: You failed");
                }
            }
            counter += 1;
            System.out.println("Your Earned Mark is:" + earnMark);

            System.out.println("Pass Mark is:" + passMark);
            System.out.println("Counter Number is: " + counter);

        }
        input.close();// to close the scanner object after use
    }

}
