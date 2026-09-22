/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.io.ObjectOutputStream;
/**
 *
 * @author nickj
 */
public class SQLSelectService extends Service{
    private ObjectOutputStream output;
    
        public SQLSelectService(String command,ObjectOutputStream output)
    {
        super(command);
        this.output=output;
    }
    
    public void doWork()    
    {
        String[] commandArray = command.split("\\|", 2);
        SongDAO sd = new SongDAO(); 
        int id = Integer.parseInt(commandArray[1]);
        Song s =  sd.getSongById(id);
        
        String command = s.getId() + "|" + s.getTitle() + "|" + s.getArtist() + "|" + s.getAlbum() + "|" + s.getReleaseYear() + "|" + s.getGenreId();
        
        try{
        output.writeObject(command);
        }
        catch(Exception e)
        {
            System.out.println("error in select service");
        }
    }
}
