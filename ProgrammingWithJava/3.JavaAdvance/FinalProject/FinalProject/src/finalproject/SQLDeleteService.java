/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package finalproject;
import java.io.ObjectOutputStream;
/**
 *handles delete requests.
 * @author User
 */
public class SQLDeleteService extends Service {
    //output stream to send response to client
    private ObjectOutputStream output;

    public SQLDeleteService(String command, ObjectOutputStream output)
    {
        super(command);
        this.output= output;
    }
    /**
     * Performs delete operation
     */
    @Override
    public void doWork()
    {
        //split command into maximum two parts.
        String[] commandArray = command.split("\\|", 2);
        SongDAO sd = new SongDAO();
        int id = Integer.parseInt(commandArray[1]);
        
        sd.deleteSongById(id);
        
        try
        {
            output.writeObject("Song Deleted Successfully");
            output.flush();
        }
        catch (Exception e)
        {
            System.out.println("Error in Deleting Message");
        }
    }
}
