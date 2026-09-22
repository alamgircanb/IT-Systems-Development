/*
 * 1. Stock Prices
The following array contains the daily closing price of a stock for a two-week period:
closingPrice = {25.0, 38.25, 39.50, 38.75, 37.33, 37.22, 29.56, 31.05, 30.77, 38.25}
Write an application that performs the following tasks. Save your application code in a file calledtockPriceTest.java.

a)Display the stock’s highest closing price during this two-week period.
b)Display the stock’s lowest closing price during this two-week period.
c)Display the average closing price during this two-week period.
d)Call a method to calculate the number of days on which the closing price was below the average price. Then display the result.
e)Display how much it would have cost an investor to buy one stock at the closing price every day during this two-week period.
f)Create a new array type double called priceSummary that contains 3 empty elements.
g) Insert into the first 2 elements of the priceSummary array the highest closing price and the lowest closing price. 
Then assign the calculated average closing price from
question c) to the third element of the priceSummary array.
h)Display the elements of the array you created in the previous question.
i) Write a method called reverseSort( )bthat accepts an array typebdouble . The methodbfirst sorts the array in ascending order. 
Then the order of the elements is reversed. Thebmethod returns an array typebdouble whose elements are sorted from highest to lowestb(in descending order).
j) Use the method you created in the previous question to order in descending order the elements of the closingPrice array, 
so that the elements with the higher closing prices are displayed first. k) Display the elements of the closingPrice array. 
The highest closing price should appear in the first element, the second highest price in the second element, and so on.
 */
package labassignmentarray;

/**
 *
 * @author Md Alamgir Hossain
 */
public class StockPriceTest {
    public static void main(String[] args) {
        // Array containing the daily closing price of a stock for a two-week period.
        double[] closingPrice = {25.0, 38.25, 39.50, 38.75, 37.33, 37.22, 29.56, 31.05, 30.77, 38.25};// to declare a double type array with the value give in the requirement.

        System.out.println("--- 1. Stock Prices Analysis ---");// to print a text line before printing initial price.
        System.out.println("Initial Closing Prices: {25.00, 38.25, 39.50, 38.75, 37.33, 37.22, 29.56, 31.05, 30.77, 38.25}");// to print the array value
        System.out.println("--------------------------------\n");// to print a text line after the array value

        
        double highestPrice = Methods.findHighest(closingPrice);// to declare a double type variable named hightPrice by calling findHighest method from Methods Class.
        System.out.printf("a) Highest Closing Price: $%.2f%n", highestPrice);// a) to print the stock’s highest closing price during this two-week period as per requirement a.

        
        double lowestPrice = Methods.findLowest(closingPrice); // to declare a double type variable named lowestPrice by calling findHighest method from Methods Class.
        System.out.printf("b) Lowest Closing Price: $%.2f%n", lowestPrice);// b) to print the stock’s lowest closing price during this two-week period as per requirement b.

        
        double averagePrice = Methods.calculateAverage(closingPrice); /* To declare a double type variable named averagePrice by calling calculateAverage method 
            from Methods Class. There are two method in same name calculateAverage with different parameters, this variable will call the method with double type parameter*/
        System.out.printf("c) Average Closing Price: $%.2f%n", averagePrice);// c) to print the average closing price during this two-week period as per requirement c.

    
        int daysBelowAverage = Methods.countBelowValue(closingPrice, averagePrice);/* d) declare an integer variable named daysBelowAverage to call method named 
        count BelowValue from class method to calculate the number of days on which the closing price was below the average price. Then display the result.*/
        
        System.out.printf("d) Days Below Average Price ($%.2f): %d days%n", averagePrice, daysBelowAverage);// to print the averagePrice and the days count with below average price

       
        double totalCost = Methods.calculateSum(closingPrice);// to declare a double type variable named totalCost to call method named calculateSum from method class
        System.out.printf("e) Total Cost to Buy One Stock Daily: $%.2f%n", totalCost); // e) to print  how much it would have cost an investor to buy one stock at the closing price every day.

        
        double[] priceSummary = new double[3];// f) Create a new array type double called priceSummary that contains 3 empty elements.
        // The elements are initialized to 0.0

        // g) Insert into the first 2 elements of the priceSummary array the highest and lowest closing price.
        // Then assign the calculated average closing price to the third element.
        priceSummary[0] = highestPrice; // to store Highest price in the first index of priceSummary array
        priceSummary[1] = lowestPrice;  // to store Lowest price in the 2nd index of priceSummary array
        priceSummary[2] = averagePrice; // to store Average price in the 3rd index of priceSummary array

        
        System.out.println("\n Price Summary Array (Highest, Lowest, Average) ---");// to print a text line before the array 
        System.out.printf("h) priceSummary: {%.2f, %.2f, %.2f}%n", priceSummary[0], priceSummary[1], priceSummary[2]);// h) to print the elements of the array you created.

        // i) A method reverseSort() was created in the Methods class.

        // j) Use the method to order in descending order the elements of the closingPrice array.
        // NOTE: The instructions imply that the original closingPrice array should be updated/replaced for the
        // output in k), so we reassign the array variable.
        closingPrice = Methods.reverseSort(closingPrice);// to store reversed price into closingPrice by calling reverseSort method from Methods class

        
        Methods.displayArray(closingPrice, "k) Closing Prices Sorted in Descending Order");// k) to print the elements of the closingPrice array.
    }
}
