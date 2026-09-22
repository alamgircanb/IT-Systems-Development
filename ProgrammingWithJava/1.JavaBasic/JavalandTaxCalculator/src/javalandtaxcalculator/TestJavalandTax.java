/*
 6. The citizens of Javaland require a program that calculates the personal income tax owed by each taxpayer.
Write the code for a class method calculateTaxableIncome that accepts the following 5 inputs:
• General Income
• Investment Income
• Other Income
• Regular Deductions
• Other Deductions
The method calculates the amount of a citizen’s taxable income. Taxable income is obtained by summing
all income and subtracting all deductions. Note that only 50% of Other Deductions are tax deductible.
The signature for this method is:
public static double calculateTaxableIncome(double generalIncome, double investmentIncome,
double otherIncome, double regularDeductions,
double otherDeductions)
Note that all calculated monetary values should be rounded to 2 decimal places.
Write the code for a class method calculateIncomeTax that accepts the following input: Taxable Income.
The method calculates the amount of income tax due to the Government of Javaland based on a citizen’s
calculated taxable income. Income tax is calculated as a percentage of taxable income based on the
following rules:
15% on the first $20,000 of taxable income
20% on the next $20,000 of taxable income
25% on the next $20,000 of taxable income
30% on all remaining taxable income
2
The signature for this method is:
public static double calculateIncomeTax(double taxableIncome)
Note that all calculated monetary values should be rounded to 2 decimal places.
Save these methods’ source code in your methods class.
 */
package javalandtaxcalculator;

import java.util.Scanner;
import java.text.DecimalFormat;

/**
 * TestJavalandTax is the main application that prompts the user for financial
 * information, calculates tax using JavalandTaxCalculator, and displays the final
 * amount owed or refunded.
 */
public class TestJavalandTax {

    public static void main(String[] args) {
        Scanner input;
        input= new Scanner(System.in);
        // Used to format the output amounts to 2 decimal places
        DecimalFormat df = new DecimalFormat("0.00");

        System.out.println("--- Javaland Personal Income Tax Calculator ---");
        System.out.println("Please enter the following amounts:");

        // 1. prompt user to Get Income Inputs
        System.out.print("Enter General Income: $");
        double generalIncome = getPositiveDouble(input);
        // prompt user to enter investment income
        System.out.print("Enter Investment Income: $");
        double investmentIncome = getPositiveDouble(input);
// prompt user to enter other income
        System.out.print("Enter Other Income: $");
        double otherIncome = getPositiveDouble(input);

        // 2. Get Deduction Inputs
        //prompt user to enter regular deduction
        System.out.print("Enter Regular Deductions: $");
        double regularDeductions = getPositiveDouble(input);
// prompt user to enter other deductions
        System.out.print("Enter Other Deductions: $");
        double otherDeductions = getPositiveDouble(input);

        // 3. Get Previously Paid Tax
        System.out.print("Enter Income Tax Paid Previously: $");
        double taxPaid = getPositiveDouble(input);


        // Calculate Taxable Income
        // Note: This calls the method from the JavalandTaxCalculator class.
        double taxableIncome = JavalandTaxCalculator.calculateTaxableIncome(
            generalIncome, investmentIncome, otherIncome, regularDeductions, otherDeductions
        );

        // Calculate Income Tax Due
        double taxDue = JavalandTaxCalculator.calculateIncomeTax(taxableIncome);

        // Calculate Final Amount Owed / Return
        double taxOwed = taxDue - taxPaid;

        // --- Output Results ---
        System.out.println("\n--- Tax Summary ---");

        System.out.println("Calculated Taxable Income: $" + df.format(taxableIncome));
        System.out.println("Income Tax Due to Javaland: $" + df.format(taxDue));
        System.out.println("Previous Tax Payments: $" + df.format(taxPaid));
        System.out.println("--------------------------------");

        if (taxOwed < 0) {
            // Negative owed amount means a refund
            double returnAmount = Math.abs(taxOwed);
            System.out.println("You have a return of $" + df.format(returnAmount) + ".");
        } else if (taxOwed > 0) {
            // Positive owed amount means tax is still due
            System.out.println("Income Tax Still Owed: $" + df.format(taxOwed));
        } else {
            // Owed amount is exactly zero
            System.out.println("Tax obligation fully met. No further tax is owed.");
        }

        input.close();
    }
    
    /**
     * Helper method to ensure user input is a non-negative double.
     */
    private static double getPositiveDouble(Scanner scanner) {
        double value = -1;
        while (value < 0) {
            if (scanner.hasNextDouble()) {
                value = scanner.nextDouble();
                if (value < 0) {
                    System.out.print("Value cannot be negative. Please enter a non-negative amount: $");
                }
            } else {
                System.out.print("Invalid input. Please enter a number: $");
                scanner.next(); // consume invalid input
            }
        }
        return value;
    }
}