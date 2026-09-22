/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package methodminibook;

import java.util.Scanner;

/**
 *
 * @author User
 */
public class Method_singular_Demo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        chapter2_demo();
        chapter3_demo();

        double printDouble = doubleInt(6);
        System.out.println("Double print value:" + printDouble);

        Scanner input = new Scanner(System.in);
        System.out.println("Please enter your first number: ");
        double a = input.nextDouble();
        int a2 =(int)a;
        System.out.println("Please enter your first number: ");
        double b = input.nextDouble();
        int b2=(int) b;
        System.out.println("Please enter your first number: ");
        double c = input.nextDouble();
        System.out.println("Please enter your first number: ");
        double d = input.nextDouble();

        double total = addDouble(a, b, c, d);
        double multresult = multiDouble(a, b, c, d);
        int addTwoNum = add2(a2,b2);
        System.out.println("Add First Two Number: " +addTwoNum);
        System.out.println("Total: " + total);
        System.out.println("multiple Result: " + multresult);

    }

    static void sayHello(String name) {
        System.out.println("Hello," + name + "!");

    }

    static void chapter2_demo() {
        sayHello("Rayhan");
        sayHello("Class");

    }

    static int add2(int a, int b) {
        // Since we want to add two input variables, we return their sum directly.
        return a + b;
    }

    static void chapter3_demo() {
        int s = add(7, 5);
        System.out.println("Sum=" + s);

    }

    static int add(int a, int b) {
        return a + b;
    }

    static double addDouble(double x, double y, double z, double f) {
        return x + y + z + f;
    }

    static double multiDouble(double x, double y, double z, double f) {
        return x * y * z * f;
    }

    static int doubleInt(int n) {
        return 2 * n;
    }

}
