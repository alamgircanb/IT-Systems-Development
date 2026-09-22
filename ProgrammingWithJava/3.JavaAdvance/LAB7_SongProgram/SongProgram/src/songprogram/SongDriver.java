/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package songprogram;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author User
 */
public class SongDriver {
    private ArrayList songs;
    private Song song;
    private Scanner input= new Scanner (System.in);
    
    /**
     * Main entry point for the SongProgram.
     * Declares an instance of SongDriver
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        SongDriver driver = new SongDriver();
        driver.run();
    }
    /**
     * controls the main execution loop of application
     * continues to display the menu and process user input until user chooses 5 to exit
     */
    public void run(){
        int choice =0;
        // while choice is not 5(exit), continue the loop
        while (choice!=5){
            choice = displayMenu();
        processChoice(choice);
        }
    }
    /**
     * to print the menu to the console and captures the user's selection.
     * @return integer choice entered by the user.
     */
    public int displayMenu() {
        System.out.println("\n---------SONG MENU--------------");
        System.out.println("1. Display All Songs");
        System.out.println("2. Get Song by ID");
        System.out.println("3. Update Song by ID");
        System.out.println("4. Delete Song by ID");
        System.out.println("5. Exit from the menu loop");
        System.out.println("----------------------------------");
        System.out.print("Enter your choice: ");
        return input.nextInt();
    }
    /**
     * go through the user's menu choice to the corresponding method to execute
     * @param choice the integer received from the user to execute the respective function.
     */
    public void processChoice(int choice) {
        if (choice == 1) {
            displayAllSongs();
        } else if (choice == 2) {
            getSongById();
        } else if (choice == 3) {
            updateSongbyId();
        } else if (choice == 4) {
            DeleteSongbyId();
        } else if (choice == 5) {
            System.out.println("Exiting the program");
        } else {
            // This acts as the 'default' case
            System.out.println("Please try again");
        }
    }
    /**
     * Retrieves all songs from the database using the DAO and prints thheir ID and Titles to thhe console
     */
    public void displayAllSongs() {
        // Local instance as per UML
        SongDAO dao = new SongDAO();
        songs = dao.getSongs();
        
        for (int i = 0; i < songs.size(); i++) {
            Song s = (Song) songs.get(i);
            System.out.println("ID: " + s.getId() + " | Title: " + s.getTitle());
        }
    }
    /**
     * asks the user for a song ID, gets the matching data from database
     */
    public void getSongById() {
        System.out.print("Enter Song ID: ");
        int id = input.nextInt();
        
        SongDAO dao = new SongDAO();
        song = dao.getSongById(id);
        
        if (song != null) {
            System.out.println("Found: " + song.getTitle() + " by " + song.getArtist());
        } else {
            System.out.println("Song not found.");
        }
    }
    
    /**
     * updates an existing song by ID
     * asks user to give updated information
     */
    public void updateSongbyId() {
        System.out.print("Enter Song ID to update: ");
        int id = input.nextInt();
        
        SongDAO dao = new SongDAO();
        song = dao.getSongById(id);
        
        if (song != null) {
            //to confirm old title with user
            System.out.println("Old Title: " + song.getTitle());
            // to promt user to input information of new song.
            System.out.print("Enter New Title: ");
            song.setTitle(input.next());
            
            System.out.print("Enter New Artist: ");
            song.setArtist(input.next());
   
            System.out.print("Enter New Album: ");
            song.setAlbum(input.next());
            
            dao.updateSongById(song);
            System.out.println("Update successful.");
        } else {
            System.out.println("Song not found.");
        }
    }
    /**
     * deletes record from database based on user given ID
     */
    public void DeleteSongbyId() {
        System.out.print("Enter Song ID to delete: ");
        int id = input.nextInt();
        
        SongDAO dao = new SongDAO();
        dao.deleteSong(id);
        System.out.println("Record deleted.");
    }
}
