/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package fivedigitsplitter;
import java.util.Scanner;//to import scanner package
/**
 *
 * @author User
 */
public class FiveDigitSplitterIntegerMethod {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int fiveDigitNum;// to declare a variable named fiveDigitNum where I will store user input
        int digit1;// to delcare a variable where I will store 1st splitted digit
        int digit2;// to delcare a variable where I will store 2nd splitted digit
        int digit3; // to delcare a variable where I will store 3rd splitted digit
        int digit4; // to delcare a variable where I will store 4rth splitted digit
        int digit5; // to delcare a variable where I will store 5th splitted digit
        Scanner input = new Scanner(System.in); // to declare input as method with scanner
        System.out.println("Please enter your Five Digit Number (int method):");// prompt to take user input
        fiveDigitNum = input.nextInt();//to declare variable for the user input
        System.out.println("Your Number Is:"+fiveDigitNum); //to confirm the input with user
        // to check the user input is exactly five digit
        if (fiveDigitNum<10000 || fiveDigitNum>99999){ //to check if the user input number is exactly 5digit or not
            System.out.println("Error!Your input is not a five digit number");// to print error message if the user input number is not 5 digit 
        }
        else {// to math calculate if the user input is number is 5digit number
        
        // to separate the digit with mathmatical calculaton considering decimal base 10.
            digit1 = (fiveDigitNum / 10000);// to separate 1st digit from the number
            digit2 = (fiveDigitNum / 1000) % 10; // to separate 2nd digit from the number
            digit3 = (fiveDigitNum / 100) % 10; // to separate 3rd digit from the number
            digit4= (fiveDigitNum / 10) % 10; // to separate 4th digit from the number
            digit5= (fiveDigitNum) % 10; // to separate 5th digit from the number
            
           // to print the digits with three space
        System.out.println( "Splitted Digits are:\n"+ digit1+"   "+digit2+"   "+digit3+"   "+digit4+"   "+digit5);

        }
        
        input.close();// to  close input method
    }
   
   
    
    
    
    
}
