/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package indentation;

/**
 *
 * @author User
 */
public class debuggingStep {
    public static void main(String[] args) {
        int a = 5;
        int b = 3;

// ➡️ PAUSED HERE (Highlighted line is the NEXT line to execute)
        int sum = add(a, b);

        System.out.println("Result is: " + sum);
    }

    private static int add(int x, int y) {
        // Line A
        // Line B

        return x + y;
    }
}

