package arraysminibook;

/**
 *
 * @author islammd
 */
// ==============================
// CHAPTER 5 – POPULATING ARRAYS WITH USER INPUT
// ==============================

/*
----------------------------------------
Chapter 5: Populating Arrays with User Input
----------------------------------------

WHAT THIS CHAPTER COVERS:
• Reading user input into an array using Scanner
• Combining loops with user-entered data
• Live Demo: storing numbers entered by the user
----------------------------------------
 */
import java.util.Scanner;
import java.util.Random;

class Chapter5_UserInput {

    /*
    ----------------------------------------
    CONCEPT:
    ----------------------------------------
    Arrays are often filled with data provided at runtime by the user.

    To read data:
      1. Create a Scanner.
      2. Use a loop to ask for input repeatedly.
      3. Store each input into the correct index.

    Example:
        int[] values = new int[3];
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < values.length; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            values[i] = in.nextInt();
        }
    ----------------------------------------
     */
    // ----------------------------------------
    // LIVE DEMO 5: Getting Numbers from the User
    // ----------------------------------------
    /*  public static void liveDemo5() {

        System.out.println("LIVE DEMO 5: Populating an Array with User Input");
        System.out.println("------------------------------------------------");

        Scanner input = new Scanner(System.in);
        int[] numbers = new int[5];

        System.out.println("Let's store 5 integers into an array.");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            numbers[i] = input.nextInt();
        }

        System.out.println("\nYou entered:");
        for (int i = 0; i < numbers.length; i++) {
            System.out.println("numbers[" + i + "] = " + numbers[i]);
        }

        int sum = 0;
        for (int n : numbers) {
            sum += n;
        }

        double average = (double) sum / numbers.length;
        System.out.println("\nAverage = " + average);

        System.out.println("\nExpected Output Example:");
        System.out.println("Enter number 1: 10");
        System.out.println("Enter number 2: 20");
        System.out.println("Enter number 3: 30");
        System.out.println("Enter number 4: 40");
        System.out.println("Enter number 5: 50");
        System.out.println("You entered: 10, 20, 30, 40, 50");
        System.out.println("Average = 30.0");
        System.out.println();

        System.out.println("Note: The output will vary depending on user input.");
    }*/

 /*
    ----------------------------------------
    NOTE:
    ----------------------------------------
    This live demo shows how control structures (loops + input)
    combine with arrays to manage data efficiently.

    This prepares students for exercises such as:
    - Populating arrays with random numbers (Practice Q1)
    - Reading and displaying names in reverse order (Practice Q2)
    ----------------------------------------

    TRY THIS:
    ----------------------------------------
    1. Create an array of 3 Strings to store your favorite movies.
    2. Use Scanner to fill the array from user input.
    3. Print the movie names backward (from last to first).
    ----------------------------------------
    *@author Md Alamgir Hossain
     */
    static void favMovies() {
        System.out.println("Live Prac: Creating Array and Storing Favourite Fruits");
        System.out.println("----------------------------------------");
        System.out.println("Challenges solution by Md Alamgir Hossain ");
        System.out.println("----------------------------------------");
        Scanner sc = new Scanner(System.in);
        String[] movies = new String[3];
        System.out.println("Please Enter your Favourite Movie name: ");

        for (int i = 0; i < movies.length; i++) {
            System.out.println("Enter Movie Name " + (i + 1) + " : ");
            movies[i] = sc.nextLine();

        }
        for (int i = movies.length - 1; i >= 0; i--) {
            System.out.println(" The movie name " + (i + 1) + " is :" + movies[i]);
        }
        Scanner input =new Scanner(System.in);
        String [] moviesFun=new String [4];
        System.out.println(" Please Enter fun Movie Name : ");
        
        for(int i=0;i<moviesFun.length;i++) {
            System.out.println("Enter fun movie Name "+(i+1)+" :");
            moviesFun[i]=input.nextLine();
            
        }
        for (int i=0;i<moviesFun.length;i++) {
            System.out.println("Enter Fun Movie Name " + (i+1)+ " is :"+moviesFun[i]);
        }

    }

    public static void main(String[] args) {
        // liveDemo5();
        favMovies();
    }
}
