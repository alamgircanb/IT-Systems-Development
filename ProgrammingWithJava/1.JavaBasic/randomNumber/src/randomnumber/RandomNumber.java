/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package randomnumber;
import java.util.Random;
import java.util.Scanner;
/**
 *
 * @author User
 */
public class RandomNumber {
private static Random rand = new Random();
    private static Scanner input = new Scanner(System.in);
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    static void main() {
        int secret = randomInRange(1, 500);
        int guesses = 0;

        System.out.println("I picked a secret number from 1 to 500.");
        System.out.println("Try to guess it!");

        while (true) {
            int g = readIntInRange(1, 500);
            guesses = guesses + 1;

            if (g < secret) {
                System.out.println("Higher");
            } else if (g > secret) {
                System.out.println("Lower");
            } else {
                System.out.println("Correct! You used " + guesses + " guesses.");
                break;
            }
        }
        static int randomInRange(int min, int max) {
        // The expression is rand.nextInt(range) + min, where range = (max - min) + 1
        return rand.nextInt(max - min + 1) + min;
    }
}
}
