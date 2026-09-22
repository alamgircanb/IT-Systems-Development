/*
 Ask user to to give two number and compare them 
 */
package comparetwonum;

import java.util.Scanner;//to import library

/**
 *
 * @author User
 */
public class CompareTwoNum {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
// To compare two number if one is larger, smaller or equal to other
        Scanner input = new Scanner(System.in);
        double firstNum; // to declare variable named firstNum
        double secondNum; // to declare variable named secondNum

        System.out.println("Please put your first number here");// to request first number from user
        firstNum = input.nextDouble();// to store the value in my variable

        System.out.println("Please put your second number here"); // to request second number from user
        secondNum = input.nextDouble(); // to store the value in my variable
        double x = 5;
        double y= 10;
        
        if (firstNum < secondNum) {
            System.out.printf("Second (%.2f) is larger than First (%.2f)\n", secondNum, firstNum);
            
             System.out.println(add(x, y));
            // to check if the second variable is lareger
        } else if (firstNum > secondNum) {
            // to check if the second variable is smaller than first 
            System.out.printf("Second (%.2f) is smaller than First (%.2f)\n", secondNum, firstNum);
        } else { //to check other condition if the first two condition is not true
            System.out.printf("Second (%.2f) is equal to First (%.2f)\n", firstNum, secondNum);
            System.out.println(add(x, y));
        }
    }

    private static double add(double x, double y) {
        // Line A
        double result = x + y;

        // Line B
        return result;
    }
}
