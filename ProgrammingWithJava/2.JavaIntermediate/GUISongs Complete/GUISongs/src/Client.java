/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;


/**
 *
 * @author nickj
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

    //connect to server
    public void connectToServer() {
        try {
            //establish where we want to connect
            client = new Socket(InetAddress.getByName("127.0.0.1"), 3202);
            //establish io pathways
            output = new ObjectOutputStream(client.getOutputStream());
            output.flush();
            input = new ObjectInputStream(client.getInputStream());

            System.out.println("Connected!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //command for lookup button ex. #select|5
    public String createLookupCommand(String command, int id) {
        return command + "|" + id;
    }
    
    public String createUpdateCommand(String command,String title, String artist, String album, String year, int genreId)
    {
        return command + "|" + getCurrentID() + "|" + title + "|" + artist + "|" + album + "|" +  year + "|" + genreId;
    }

    public void sendCommand(String command) {

        try {
            //connect to server
            connectToServer();
            //send command
            output.writeObject(command);
            //get sql info back from server
            String messageIn = (String) input.readObject();
            //display info in GUI
            sendToGUI(messageIn);
            //disconnect
            disconnectFromServer();
            //set message in GUI that it was successful
            gc.setGoodMessage("Update From Server Successful");
        } catch (Exception e) {
            //error in gui if failed
            gc.setBadError("Error Communicating with Server");
            System.out.println("send command didnt work");
        }
    }

    public void disconnectFromServer() {
        try {
            client.close();
        } catch (Exception e) {
            System.out.println("disconnect didnt work");
        }

    }

    public void sendToGUI(String command) {
        //example command back from a select:
        //4|Lose Yourself|Eminem|8 Mile Soundtrack|2002|3
        //cut string into how many we need(6)
        String[] commandArray = command.split("\\|", 6);
        //create new song object
        Song s = new Song(Integer.parseInt(commandArray[0]), commandArray[1], commandArray[2], commandArray[3], Integer.parseInt(commandArray[4]), Integer.parseInt(commandArray[5]));
        //set current id we got from database
        setCurrentID(s.getId());
        //send to gui
        gc.setTxtTitle(s.getTitle());
        gc.setTxtArtist(s.getArtist());
        gc.setTxtAlbum(s.getAlbum());
        gc.setTxtYear("" + s.getReleaseYear());
        gc.setComboGenre(s.getGenreId() - 1); //-1 as combobox starts from 0
    }

}
