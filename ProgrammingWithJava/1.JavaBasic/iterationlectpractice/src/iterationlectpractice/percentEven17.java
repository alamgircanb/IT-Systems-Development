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
public class percentEven17 {
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner input = new Scanner(System.in);
        double evenCount = 0;
        double percentEven;
        int number = 0;
        int reminder =0;
        
        for (int counter = 1;counter < 17; counter++) {
            System.out.println("Enter your enter:");
            number = input.nextInt();
            reminder = number%2;
            if (reminder == 0) {
                // to check the moduler math result is Zero
                evenCount++;
        }    
       
        }
        percentEven = (evenCount / 17.0) * 100;
        System.out.println("Total even number is:"+evenCount);
        System.out.printf("Even Percentile is: %.2f%n", percentEven);
    }  
}
