/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package calculationareas;

import java.util.Scanner;

/**
 *
 * @author User
 */
public class CalculationAreas {

    double radius = 0;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double circumference = 0;
        System.out.println("----------------what you want to calculate-------");
        System.out.println("For circle input 1 \n For Cylender input 2\n For cone input 3");
        int option = input.nextInt();
        if (option == 1) {
            System.out.println("Please input Circle circumference to get radius: ");
            circumference = input.nextDouble();
            double area = circle(circumference);
            System.out.println("Your Area of circle is: " + circumference);
        } else if (option == 2) {
            System.out.println("Please input radius:");
            double radius = input.nextDouble();
            System.out.println("Please input height: ");
            double height = input.nextDouble();
            
        } else if (option == 3) {
            System.out.println("Please input radius:");
            double radius = input.nextDouble();
            System.out.println("Please input height: ");
            double height = input.nextDouble();
        } else {
            System.out.println("Your input should be 1-3");
        }
        
    }

    static double circle(double circumference) {
        double radius;
        double pi = 3.1416;
        radius = circumference / (2 * pi);
        double area = pi * Math.pow(radius, 2);
        return area;
    }

    static double cylinder(double radius, double height) {
        double pi = 3.1416;
        double volume = pi * Math.pow(radius, 2) * height;
        return volume;
    }

    static double cone(double radius, double height) {
        double pi = 3.1416;
        double volume = (1 / 3) * pi * Math.pow(radius, 2) * height;
        return volume;
    }
}
