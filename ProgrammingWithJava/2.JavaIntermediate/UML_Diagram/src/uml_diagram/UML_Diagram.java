/*
 
Question IIb:

1.	Create a UML diagram for a theoretical Wallet class to be used with question 2b. It should have a number of loonies, toonies, 5, 10, and 20 dollar bills, as well as the corresponding getters and setters. 
2.	Include functions for spending money (allow the user to specify amount and type of money spent) and receiving change back (allow the user to specify the amount and type of money received
3.	Choose appropriate variable types as to your best judgement
 */
package uml_diagram;

/**
 *
 * @author User
 */
public class UML_Diagram {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*

UML CLASS DIAGRAM (TEXT FORMAT)

This is the one most instructors require:

-----------------------------------------------
|                    Wallet                    |
-----------------------------------------------
| - loonies: int                               |
| - toonies: int                               |
| - fiveDollarBills: int                       |
| - tenDollarBills: int                        |
| - twentyDollarBills: int                     |
-----------------------------------------------
| + Wallet()                                   |
| + Wallet(ln: int, tn: int, five: int,        |
|          ten: int, twenty: int)              |
-----------------------------------------------
| + getLoonies(): int                          |
| + getToonies(): int                          |
| + getFiveDollarBills(): int                  |
| + getTenDollarBills(): int                   |
| + getTwentyDollarBills(): int                |
-----------------------------------------------
| + setLoonies(amount: int): void              |
| + setToonies(amount: int): void              |
| + setFiveDollarBills(amount: int): void      |
| + setTenDollarBills(amount: int): void       |
| + setTwentyDollarBills(amount: int): void    |
-----------------------------------------------
| + spendMoney(type: String, amount: int):     |
|        boolean                               |
| + receiveChange(type: String, amount: int):  |
|        void                                  |
-----------------------------------------------



*/
    }
    
}
