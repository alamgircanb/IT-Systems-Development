/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package finalproject;
import java.io.ObjectOutputStream;
/**
 *Handles update requests.
 * @author User
 */
public class SQLUpdateService extends Service {
    //output stream to send response back to client
    private ObjectOutputStream output;

    public SQLUpdateService(String command,ObjectOutputStream output)
    {
        super(command);
        this.output=output;
    }
    /**
     * Performs update operation
     */
    @Override
    public void doWork()
    {
        //split command into maximum 7 parts
        String[] commandArray = command.split("\\|", 7);
        SongDAO sd = new SongDAO();
        
        Song s = new Song(Integer.parseInt(commandArray[1]), commandArray[2], commandArray[3], commandArray[4], Integer.parseInt(commandArray[5]), Integer.parseInt(commandArray[6]));
        
        sd.updateSongById(s);

        try
        {
            output.writeObject("Song updated successfully");
            output.flush();
        }
        catch(Exception e)
        {
            System.out.println("Error in updating song data");
        }
    }
}
