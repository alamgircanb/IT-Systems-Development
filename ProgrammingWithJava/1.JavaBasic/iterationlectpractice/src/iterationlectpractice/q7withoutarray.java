/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package iterationlectpractice;

import java.util.Scanner;

/**
 *
 * @author User
 */
public class q7withoutarray {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Select an item:");
        System.out.println("1. Chips           $1.35");
        System.out.println("2. Chocolate Bar   $1.65");
        System.out.println("3. Pop             $2.00");
        System.out.println("4. Energy Drink    $3.75");
        System.out.print("Enter your choice (1-4): ");
        int choice = input.nextInt();
        double price = 0;
        double change;

        if (choice == 1) {
            price = 1.35;
            System.out.println("Your price is " + price);

        } else if (choice == 2) {
            price = 1.65;
            System.out.println("Your price is " + price);

        } else if (choice == 3) {
            price = 2.00;
            System.out.println("Your price is " + price);

        } else if (choice == 4) {
            price = 3.75;
            System.out.println("Your price is " + price);

        } else {
            System.out.println("Please select a correct option.");
        }
        System.out.print("Enter your payment: ");
        double payment = input.nextDouble();

        if (payment < price) {
            System.out.println("Insufficient payment.");
        } else {
            // Calculate change
            change = (int) Math.round((payment - price) * 100); // convert to cents
            System.out.println("Change to be returned: " + change + " cents");
            System.out.println("That means your will get change:" + (double) change / 100);

            // Coin denominations in cents
            int toonies = 0;
            int loonies = 0;
            int quarters = 0;
            int dimes = 0;
            int nickels = 0;
            int pennies = 0;
            while (change >= 200) {
                toonies++;
                change = change - 200;
            }
            while (change >= 100) {
                loonies++;
                change = change - 100;
            }
            while (change >= 25) {
                quarters++;
                change = change - 25;

            }
            while (change >= 10) {
                dimes++;
                change = change - 10;
            }
            while (change >= 5) {
                nickels++;
                change = change - 5;
            }
            while (change >= 1) {
                pennies++;
                change = change - 1;
            }
            System.out.printf("Toonies   : %d \n", toonies);
            System.out.printf("Loonies   :%d \n", loonies);
            System.out.printf("Quarters   :%d \n", quarters);
            System.out.printf("Dimes   :%d  \n", dimes);
            System.out.printf("Nickels   :%d \n", nickels);
            System.out.printf("Pennies   :%d \n", pennies);
        }
        input.close();// to close the scanner object after use
    }
}
