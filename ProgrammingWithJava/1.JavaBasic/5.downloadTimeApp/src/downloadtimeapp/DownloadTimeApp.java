/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package downloadtimeapp;
import java.util.Scanner;//to import scanner package
/**
 *
 * @author User
 */
public class DownloadTimeApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // to create scanner for receiving user iput
        Scanner input = new Scanner(System.in);// to declare input method inside scanner
        
        // to declare my variables
        double fileSizeGB; // to declare a variable named fileSizeGB where I will store user input
        double speedMBps;// to declare a variable named speedMBps where I will store speed parameter from user
        double seconds;// to declare a variable named seconds which I will use for my math calculation and display values
        double minutes;//to declare a variable named minutes which I will use for my math calculation and display values
        double hours;//to declare a variable named hours which I will use for my math calculation and display values
        long approxSeconds; // declare a long variable which I will use to get rounded seconds
        // to request for fileSize (GB) and Speed (mbs)
        System.out.println( "Please Enter your file Size(in GB): ");// prompt user to put data volume
        fileSizeGB = input.nextDouble();// to call a method and store user input into variable
        System.out.println("Please Enter download speed (in MB/s): ");// to promt user to put download speed
        speedMBps = input.nextDouble();//to call a method and store user input into variable
        
        // to check the speed if it is non-Zero number
        if (speedMBps <=0) {// to check if the speed input by user is less than or equal Zero(0)
        System.out.println("Error!!!:Speed must be greater than 0 MB/s: ");//to print error message if user input is less than and equal 0
        input.close();// to close method 
        return;//to exit if condition 
        }
        // to convert the time units
        seconds = (fileSizeGB*1024.0)/speedMBps;//( to convert GB to MB)
        minutes = (seconds/60.0);//to convert seconds into minutes
        hours = (seconds/3600); // or hours = (minutes/60.0);to convert seconds into hours
        
        //To display rounded whole-Seconds for user convenience
        
        approxSeconds = Math.round(seconds);// to round seconds
        
        //to print All of my three times units;
        System.out.printf(" Time in seconds: %.2f%n",seconds);//to print seconds upto 2 decimal place
        System.out.printf(" Time in minutes: %.2f%n",minutes);//to print minutes upto 2 decimal place
        System.out.printf(" Time in hours: %.2f%n",hours);//to print hours upto 2 decimal place
        
        
        //To print approximate seconds in rounded version
        System.out.printf("Approximate time (whole seconds): %d%n", approxSeconds);//to print round seconds values

        input.close();//to close input method
        }
        
        
        
        
    }
    

