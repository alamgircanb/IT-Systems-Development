/*
 7. Write an application TestJavalandTax that tests the methods you created in the previous question. Your
test application should prompt the user for the following pieces of information: general income,
investment income, other income, regular deductions, other deductions.
The application should display the following results: the taypayer’s calculated taxable income formatted
to 2 decimal places, and the amount of income tax due to the Government of Javaland, also formatted to
2 decimal places.
Some citizens pay their taxes in installments. Any previously paid income tax is subtracted from the
amount of tax that is due for a specific year. Ask the user to enter the amount of income tax paid
previously.
The application subtracts from the calculated income tax the amount of income tax already paid and
displays the amount of income tax still owed by the taxpayer.
If the amount of income tax owed is a negative value, then display the message: “You have a return of
$amoun
* I called two method from JavalanTaxCalculator.java file 
 */
package pkg6.pkg7.texcalculatorandtest;

import java.util.Scanner;
import java.text.DecimalFormat;

/**
 * TestJavalandTax is the main application that prompts the user for financial
 * information, calculates tax using JavalandTaxCalculator, and displays the final
 * amount owed or refunded.
 */
public class TexCalculatorAndTest {

    public static void main(String[] args) {
        Scanner scanner;
        scanner= new Scanner(System.in);
        // Used to format the output amounts to 2 decimal places
        DecimalFormat df = new DecimalFormat("0.00");

        System.out.println("--- Javaland Personal Income Tax Calculator ---");
        System.out.println("Please enter the following amounts:");

        // 1. Get Income Inputs
        System.out.print("Enter General Income: $");
        double generalIncome = getPositiveDouble(scanner);

        System.out.print("Enter Investment Income: $");
        double investmentIncome = getPositiveDouble(scanner);

        System.out.print("Enter Other Income: $");
        double otherIncome = getPositiveDouble(scanner);

        // 2. Get Deduction Inputs
        System.out.print("Enter Regular Deductions: $");
        double regularDeductions = getPositiveDouble(scanner);

        System.out.print("Enter Other Deductions: $");
        double otherDeductions = getPositiveDouble(scanner);

        // 3. Get Previously Paid Tax
        System.out.print("Enter Income Tax Paid Previously: $");
        double taxPaid = getPositiveDouble(scanner);

        // --- Calculation ---

        // Calculate Taxable Income
        double taxableIncome = JavalandTaxCalculator.calculateTaxableIncome( //to call calculateTaxableIncome method from JavalandTaxCalculator file 
            generalIncome, investmentIncome, otherIncome, regularDeductions, otherDeductions
        );

       // to calculate income tax
        double taxDue = JavalandTaxCalculator.calculateIncomeTax(taxableIncome);// to call calculateIncomeTax method from JavalandTaxCalculator file 

        // Calculate Final Amount Owed / Return
        double taxOwed = taxDue - taxPaid;

        //to display Output Results ---
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

        scanner.close();
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
