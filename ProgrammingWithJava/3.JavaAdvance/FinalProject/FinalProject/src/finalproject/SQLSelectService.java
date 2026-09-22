/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package finalproject;
import java.io.ObjectOutputStream;

/**
 *handles lookup (select) requests.
 * @author User
 */
public class SQLSelectService extends Service {
    //output stream to send response to client
    private ObjectOutputStream output;

    public SQLSelectService(String command, ObjectOutputStream output)
    {
        super(command);
        this.output = output;
    }
    /***
     * Performs select operation.
     */
    @Override
    public void doWork()
    {
        //split command into two parts (command and id)
        String[] commandArray = command.split("\\|", 2);
        //create DAO object
        SongDAO sd = new SongDAO();
        int id = Integer.parseInt(commandArray[1]);
        Song s = sd.getSongById(id);
        //convert song object into string response
        String command = s.getId() + "|" + s.getTitle() + "|" + s.getArtist() + "|" + s.getAlbum() + "|" + s.getReleaseYear() + "|" + s.getGenreId();
        
        try
        {
            //send response back to client
            output.writeObject(command);
            output.flush();
        }
        catch(Exception e)
        {
            System.out.println("error in select service");
        }
    }
}
