/*
 5. Write a method that takes three int parameters and sums them. Overload this method twice: once to
allow for double parameters and again to allow for four parameters. In the end you should have three
different sum methods.
 */
package pkg5.methodoverloading;

/**
 * Demonstrates method overloading by defining multiple 'sum' methods
 * with different parameter signatures (type or count).
 */
public class MethodOverloading {

    // 1. Sum method taking three integers (The initial requirement)
    static int sum(int a, int b, int c) {
        System.out.println("sum(int, int, int)");
        return a + b + c;
    }

    // 2. Overload 1: Sum method taking three doubles
    // The signature changes based on parameter *type*.
    static double sum(double a, double b, double c) {
        System.out.println("sum(double, double, double)");
        return a + b + c;
    }

    // 3. Overload 2: Sum method taking four integers
    // The signature changes based on parameter *count*.
    static int sum(int a, int b, int c, int d) {
        System.out.println("sum(int, int, int, int)");
        return a + b + c + d;
    }

    public static void main(String[] args) {

      
        int result1 = MethodOverloading.sum(10, 20, 30);  // Demonstration of the 3-int sum method
        System.out.println("Sum of three integers (10, 20, 30): " + result1);
        System.out.println("----------------------------------------");

     
        double result2 = MethodOverloading.sum(15.5, 2.5, 3.0);    // Demonstration of the 3-double sum method (Overload 1)
        System.out.println("Sum of three doubles (15.5, 2.5, 3.0): " + result2);
        System.out.println("----------------------------------------");

     
        int result3 = MethodOverloading.sum(5, 10, 15, 20);//to overload 4 parameters
        System.out.println("Sum of four integers (5, 10, 15, 20): " + result3);
    }
}