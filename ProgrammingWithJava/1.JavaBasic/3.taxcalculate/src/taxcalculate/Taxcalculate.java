/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package taxcalculate;

import java.util.Scanner; //to import scanner package

/**
 *
 * @author User
 */
public class Taxcalculate {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // I will practice tax calculation here
        double productPrice; //to declare a variable named product price
        double gst; // to delcare a variable named gst where I store gst value
        double pst; // to declare a  variable named pst where I will store pst value
        double totalTax; // to declare a variable named totalTax 
        double totalPrice; // to  declare a  variable named totalPrice

        Scanner input = new Scanner(System.in); //to declare input method where I will store user input
        System.out.println("Please Enter your price: "); //to request user to input their value/price

        productPrice = input.nextDouble(); // to store user value into my variable productPrice
        
        gst = productPrice * .05; //to set gst variable value
        pst = productPrice * .06;// to set pst variable value
        
        totalTax = Double.sum(gst, pst);// to sum two taxes 
        totalPrice = Double.sum(productPrice, totalTax);// to sum product price and total tax
        
        
        System.out.printf("GST is 5%%: $%.2f \n", gst);//to display GST value upto 2decimal place
        System.out.printf("Pst is 6%%:$%.2f \n", pst);// to display PST value upto 2 decimal place
        System.out.printf("Total Tax:($ %.2f) \n", totalTax);//to display total tax upto 2 decimal place
        System.out.printf("Total Price with all Taxes:($ %.2f) \n", totalPrice);// to display price with tax upto 2 decimal place

    }

}
