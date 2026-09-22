package javalandtaxcalculator;

/**
 * JavalandTaxCalculator contains static methods for calculating taxable income
 * and the final income tax amount based on Javaland's rules.
 */
public class JavalandTaxCalculator {

    /**
     * Entry point for running the utility class, though the main application
     * logic is handled in TestJavalandTax.java.
     */
    private static double round(double value) {
        // Use Math.round to handle the rounding operation
        return Math.round(value * 100.0) / 100.0;
    }

    /**
     * Calculates the taxpayer's taxable income. Taxable Income = Total Income -
     * (Regular Deductions + 50% of Other Deductions).
     * @param generalIncome
     * @param investmentIncome
     * @param otherIncome
     * @param regularDeductions
     * @param otherDeductions
     * @return 
     */
    public static double calculateTaxableIncome(double generalIncome, double investmentIncome,
            double otherIncome, double regularDeductions,
            double otherDeductions) {

        // Total Income
        double totalIncome = generalIncome + investmentIncome + otherIncome;

        // Total Deductions (only 50% of otherDeductions are deductible)
        double deductibleOther = otherDeductions * 0.50;
        double totalDeductions = regularDeductions + deductibleOther;

        // Calculate Taxable Income
        double taxableIncome = totalIncome - totalDeductions;

        // Ensure taxable income is not negative before rounding, as tax is usually applied to positive income.
        if (taxableIncome < 0) {
            taxableIncome = 0.0;
        }

        return round(taxableIncome);
    }

    /**
     * Calculates the total income tax due based on the progressive tax rules:
     * 15% on the first $20,000 20% on the next $20,000 25% on the next $20,000
     * 30% on all remaining taxable income
     *
     * @param taxableIncome The calculated taxable income amount.
     * @return The total income tax due, rounded to 2 decimal places.
     */
    public static double calculateIncomeTax(double taxableIncome) {
        double tax = 0.0;
        double remainingIncome = taxableIncome;

        // Tier 1: 15% on the first $20,000
        double tier1Limit = 20000.00;
        if (remainingIncome > 0) {
            double taxedAmount = Math.min(remainingIncome, tier1Limit);
            tax += taxedAmount * 0.15;
            remainingIncome -= taxedAmount;
        }

        // Tier 2: 20% on the next $20,000 (up to $40,000 total)
        double tier2Limit = 20000.00;
        if (remainingIncome > 0) {
            double taxedAmount = Math.min(remainingIncome, tier2Limit);
            tax += taxedAmount * 0.20;
            remainingIncome -= taxedAmount;
        }

        // Tier 3: 25% on the next $20,000 (up to $60,000 total)
        double tier3Limit = 20000.00;
        if (remainingIncome > 0) {
            double taxedAmount = Math.min(remainingIncome, tier3Limit);
            tax += taxedAmount * 0.25;
            remainingIncome -= taxedAmount;
        }

        // Tier 4: 30% on all remaining taxable income (above $60,000)
        if (remainingIncome > 0) {
            tax += remainingIncome * 0.30;
        }

        return round(tax);
    }
}
