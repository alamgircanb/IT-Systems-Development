/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fivedigitsplitter;

import java.util.Scanner;//to import scanner package

/**
 *
 * @author User
 */
public class FiveDigitSplitterStringMethod {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); //to declare input method in scanner method
        System.out.println("Enter your Five Digit number (string method):");// to request user input
        String userNum = input.next(); //to store user input into my variable named userName
        System.out.println("Your number is:"+userNum);// to reconfirm user input with the user
        
        if (userNum.length() != 5 || !userNum.chars().allMatch(Character::isDigit)) {//to check user digit is exactly 5 digit or not
            System.out.println("Error: number must be exactly 5 digits.");// to print error message
            return;// to exit from if condition 
        }

        char c1 = userNum.charAt(0), c2 = userNum.charAt(1), c3 = userNum.charAt(2), c4 = userNum.charAt(3), c5 = userNum.charAt(4);// to declare variable and spaces
        System.out.printf("Splitted Digits are: \n %c   %c   %c   %c   %c%n", c1, c2, c3, c4, c5);
        input.close();// to close method
    }
}
