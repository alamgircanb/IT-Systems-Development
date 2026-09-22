/*----------------------------------
 *|  TestChangeMachine              |
  |---------------------------------
  | TestChangeMachine               |
  | + main(args: String[]): void    |
  |---------------------------------|
 */
package bankmachine;

/**
 *
 * @author User
 */
import java.util.Scanner;// to import Scanner package from util library
import java.util.InputMismatchException;// import InputMismatchException library

/**
 * TestChangeMachine.java
 * Driver program to test the functionality of the ChangeMachine class, including
 * coin depletion, out-of-order state, and technician refill.
 */
public class TestChangeMachine {// to create a public class
    public static void main(String[] args) {// to declare main class
        Scanner scanner;
        scanner= new Scanner(System.in);

        // 7a. Create an instance of the ChangeMachine and fill it with coins.
        // Start with a small amount (2 loonies, 15 toonies) to ensure it runs out quickly.
        ChangeMachine machine = new ChangeMachine(2, 15);

        // 7b. Check the machine's status before accepting the first bill.
        System.out.println("\n" + machine);
        if (!machine.getStatus()) {
            System.out.println("Out of order! Cannot accept ANY bills. Please call technician to repair the machine.");
            scanner.close();
            return; 
        } else {
            System.out.println("Machine is in working order. Proceeding to accept bills.");
        }
        
        // Loop structure for repeating the procedure (7e)
        boolean running = true;
        while (running) {
            
            System.out.print("\nInsert a bill ($5, $10, $20) or enter '0' for technician access: ");
            int billAmount = -1;
            
            try {
                if (scanner.hasNextInt()) {
                    billAmount = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                } else {
                    scanner.nextLine(); // Clear buffer
                    System.out.println("Invalid input. Please enter a number.");
                    continue;
                }
            } catch (InputMismatchException e) {
                // Should be caught by hasNextInt() but included as a safeguard
                scanner.nextLine(); 
                System.out.println("Invalid input format.");
                continue;
            }
            
            if (billAmount == 0) {
                //to meet the requirement 7g. Technician refill attempt
                if (!machine.technicianRefill(scanner)) {
                    // to handle invalid PIN entered, program should end here
                    running = false; 
                }
                continue; 
            }

            // If machine is globally out of order, do not accept bills (7f)
            if (!machine.getStatus()) {
                System.out.println("Out of order! Cannot accept any more bills. Please call the technician to refill the machine.");
                continue; 
            }

            // 7c & 7d. Insert bill, acceptMoney handles change and display.
            machine.acceptMoney(billAmount);
            
            // Display internal status after operation
            System.out.println(machine);
        }

        System.out.println("\n--- Program Terminated ---");
        scanner.close();
    }
}