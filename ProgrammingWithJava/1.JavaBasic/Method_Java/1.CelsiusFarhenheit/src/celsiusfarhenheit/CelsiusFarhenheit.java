/*
 1. Implement the following methods:
a. Method Celsius( ) returns the Celsius equivalent of a Fahrenheit temperature, using the calculation:
Celsius = 5.0 / 9.0 * (Fahrenheit – 32);
b. Method Fahrenheit ( ) returns the Fahrenheit equivalent of a Celsius temperature, using the
calculation:
Fahrenheit = 9.0 / 5.0 * Celsius + 32;
c. Use the methods from part (a) and part (b) to write an application that enables the user either to
enter a Fahrenheit temperature and display the Celsius equivalent or to enter a Celsius temperature
and display the Fahrenheit equivalent.
1
 */
package celsiusfarhenheit;

import java.util.Scanner;// to import Scanner library from java utility


public class CelsiusFarhenheit {

   
    static double fahrenheitToCelsius(double fahrenheit) {
        // Use floating-point division (5.0 / 9.0) for accurate results.
        return 5.0 / 9.0 * (fahrenheit - 32);// to return the celsius result from farhenheir
    }


    static double celsiusToFahrenheit(double celsius) {
        // Use floating-point division (9.0 / 5.0) for accurate results.
        return 9.0 / 5.0 * celsius + 32; // to return the farhenheit result from celsius
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        Scanner input;
        input= new Scanner(System.in);
        System.out.println("--- Temperature Conversion ---");// to print a text line before display options
        
        System.out.println("Please select an option from below:");// to prompt user to choose
        System.out.println("1. Convert Celsius (C) to Fahrenheit (F)");// to prompt user option one
        System.out.println("2. Convert Fahrenheit (F) to Celsius (C)");// to prompt user option two
        System.out.print("Enter choice (1 or 2): ");

        // Read the user's choice
        int option = input.nextInt();// to store te user chosen option into option variable
        
        // Use a simple switch statement to handle the conversion
        switch (option) {
            case 1:
                System.out.print("Enter temperature in Celsius (C): ");
                double celsiusInput = input.nextDouble();// to declare a variable inside input method
                double resultFahrenheit = celsiusToFahrenheit(celsiusInput);// to call the method
                System.out.printf("\nResult: %.2f C is equal to %.2f F\n", celsiusInput, resultFahrenheit);// to print the result
                break;

            case 2:
                System.out.print("Enter temperature in Fahrenheit (F): ");
                double fahrenheitInput = input.nextDouble();// to declare a variable inside input method named farhenheit
                double resultCelsius = fahrenheitToCelsius(fahrenheitInput);// to call the method farhenheitToCelsius
                System.out.printf("\nResult: %.2f F is equal to %.2f C\n", fahrenheitInput, resultCelsius);// to print the result
                break;

            default:
                System.out.println("\nInvalid option selected. Program exiting.");// to print the invalid message
                break;
        }

        input.close();// to close in the input message
    }
}