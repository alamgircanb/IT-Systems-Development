/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package finalproject;
import java.io.ObjectOutputStream;
/**
 *Handles insert requests
 * @author User
 */
public class SQLInsertService extends Service {
    //output stream to send response to client.
    private ObjectOutputStream output;
    
    public SQLInsertService(String command, ObjectOutputStream output)
    {
        super(command);
        this.output=output;
    }
    /**
     * Performs insert operation.
     */
    @Override
    public void doWork()
    {
        //split command into the number of parts whatever I need
        String[] commandArray = command.split("\\|",6);
        SongDAO sd = new SongDAO();
        
        Song s = new Song(commandArray[1], commandArray[2], commandArray[3], Integer.parseInt(commandArray[4]), Integer.parseInt(commandArray[5]));
        
        sd.insertSong(s);
    
        try
        {
            output.writeObject("Song inserted successfully");
            output.flush();
        }
        catch(Exception e)
        {
            System.out.println("Error in inserting message");
        }
    }
}
