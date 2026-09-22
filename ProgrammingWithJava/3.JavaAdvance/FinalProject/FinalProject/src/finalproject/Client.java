/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package finalproject;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 *This handles communication between GUI and Server.
 * connecting to the server, sending commands, receiving response and updating the GUI
 * @author User
 */
public class Client {

    //object to make connection client side
    static Socket client;
    
    //Declare IO pathways
    static ObjectOutputStream output;
    static ObjectInputStream input;

    //reference to the gui
    GUIClient gc;
    
    //id isnt displayed in gui so we can keep track here
    private int currentID = -1;

    public Client(GUIClient gc) {
        this.gc = gc;
    }

    public int getCurrentID() {
        return currentID;
    }

    public void setCurrentID(int currentID) {
        this.currentID = currentID;
    }

   /**
    * Connect to the server using socket
    */
    public void connectToServer() {
        try {
            //establish where we want to connect
            client = new Socket(InetAddress.getByName("127.0.0.1"), 3202);
            //establish io pathways
            output = new ObjectOutputStream(client.getOutputStream());
            output.flush();
            input = new ObjectInputStream(client.getInputStream());

            System.out.println("Connected to server!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /***
     * Creates lookup command (#select|3)
     * @param command command type
     * @param id song id
     * @return formatted command string
     */
    public String createLookupCommand(String command, int id) {
        //select by id to look up a record
        return command + "|" + id;
    }
    /***
     * Creates update command
     * @param command command type
     * @param title song title
     * @param artist artist name
     * @param album album name
     * @param year release year
     * @param genreId genre id
     * @return formatted command string
     */
    public String createUpdateCommand(String command, String title, String artist, String album, String year, int genreId) {
        //update id|title|artist|album|year|genreId
        return command + "|" + getCurrentID() + "|" + title + "|" + artist + "|" + album + "|" + year + "|" + genreId;
    }
    /***
     * creates insert command
     * @param command command type
     * @param title song title
     * @param artist artist name
     * @param album album name
     * @param year release year
     * @param genreId genre id
     * @return formatted command string
     */
    public String createInsertCommand(String command, String title, String artist, String album, String year, int genreId) {
         //insert title|artist|album|year|genreId
        return command + "|" + title + "|" + artist + "|" + album + "|" + year + "|" + genreId;
    }
    /***
     * Creates delete command
     * @param command command type
     * @param id song id
     * @return formatted command string
     */
    public String createDeleteCommand(String command, int id) {
         // delete by id
        return command + "|" + id;
    }
    
    /***
     * this method is to connect to server, send request to server and get response
     * @param command 
     */
    public void sendCommand(String command) {
        try {
            //connect to server
            connectToServer();
            //send command
            output.writeObject(command);
            //get response back from server
            String messageIn = (String) input.readObject();
            //get sql info back from server if command is select
            if(command.indexOf("#select") == 0)
            {
            //display info in GUI
                sendToGUI(messageIn);
                gc.setGoodMessage("Lookup successful");
            }
            else
            {
                gc.setGoodMessage(messageIn);
            }
            //disconnect
            disconnectFromServer();
        } catch (Exception e) {
             //error in gui if failed
             gc.setBadError("Error Communicating with Server");
             System.out.println("send command didnt work");
        }
    }
    /***
     * closes connection to server
     */
    public void disconnectFromServer() {
        try {
            client.close();
        } catch (Exception e) {
            System.out.println("disconnect failed");
        }
    }
    
    /***
     * Parses server response and updates GUI fields
     * @param command response string from server
     */
    public void sendToGUI(String command) {
        
        //split response into parts
        String[] commandArray = command.split("\\|", 6);
        
        //create new song object
        Song s = new Song(Integer.parseInt(commandArray[0]), commandArray[1], commandArray[2], commandArray[3], Integer.parseInt(commandArray[4]), Integer.parseInt(commandArray[5]));
        //Check if invalid ID (not found)
        if (s.getId()==0)
        {
            gc.setBadError("Invalid ID");
            return;
        }
        //set current id we got from database
        setCurrentID(s.getId());
        //update GUI fiedls
        gc.setTxtTitle(s.getTitle());
        gc.setTxtArtist(s.getArtist());
        gc.setTxtAlbum(s.getAlbum());
        gc.setTxtYear("" + s.getReleaseYear());
        //protect combo box
        if (s.getGenreId()>0)
        {
        gc.setComboGenre(s.getGenreId() - 1); //-1 as combobox starts from 0
        }
    }

}
