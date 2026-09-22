/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BankAccountProgramFileHandler;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.IllegalStateException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class FileHandler {

    private static BankAccount[] accounts;
    private static Scanner input;

    /**
     * Read a data file and populate an array with its contents
     *
     * @param fileName the name of the file (including extension)
     * @return CompositionBankAccount array with contents of file
     */
    public BankAccount[] getData(String fileName) {
        try {
            input = new Scanner(new File(fileName));
            //to get the array size 
            int numAccounts = input.nextInt();
            accounts = new BankAccount[numAccounts];

            for (int i = 0; i < numAccounts; i++) {
                //read the data from the file
                int accountNum = input.nextInt();
                String firstName = input.next();// will read upto next space
                String lastName = input.next();
                char init = input.next().charAt(0);//to indicate the first character
                float balance = input.nextFloat();
                Date transactionDate = new Date(input.nextInt(),//year
                        input.nextInt(),//day
                        input.nextInt());//dat
                // create an account
                accounts[i] = new BankAccount(accountNum, firstName, lastName, init, balance, transactionDate);
            }
        } 
        catch (FileNotFoundException fnfe) 
        {
            System.out.println("File not found");
        } 
        catch (NoSuchElementException nsee) 
        {
            System.out.println("File Format Error");
        } 
        catch (IllegalStateException ise) 
        {
            System.out.println("Error Reading Error");
        } 
        catch (Exception e) 
        {
            System.out.println("An unknown error occoured");
            e.printStackTrace();
        }

        return accounts;
    }

    /**
     * Writes the data of BankAccounts to a file
     *
     * @param accountsToSave BankAccount[] -an array of bank accounts to
     * populate the text file
     */
    public static void save(BankAccount[] accountsToSave) {
        try {
            //create a file writer
            //string- file name
            // boolean - whether to append the new data or overwrite the existing file
            FileWriter fw = new FileWriter("233BankAccountTestData.txt", false);

            //write the number of accounts
            // convert the number of accounts to a string to prevent issues when
            //writing to file
            String numAccounts = String.valueOf(accountsToSave.length);
            fw.write(numAccounts);
            fw.write(System.lineSeparator());

            //write the contents of the array to the file
            for (int i = 0; i < accountsToSave.length; i++) {
                fw.write(accountsToSave[i].writeAsRecord());
                fw.write(System.lineSeparator());
            }

            //save the file
            // close the file
            fw.close();
        } 
        catch (IOException ioe) 
        {
            System.out.println("Unknown IO Exception occured");
            ioe.printStackTrace();
        }
    }
   
}
