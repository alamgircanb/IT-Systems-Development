/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package iterationlectpractice;

/**
 *
 * @author User
 */
public class dowhileprac {

    public static void main(String[] args) {
        // TODO code application logic here
        int counter = 0;
        while (counter < 5) {
            counter = counter + 1;//to increment variable if your put this line before the print it will start from 1 otherwise it print with 0
            System.out.println(counter);

            int j = 0;
            do {
                j++;
                System.out.println(j);

            } while (j < 10);
        }
    }
}
