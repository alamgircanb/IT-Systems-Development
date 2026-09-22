/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */




/**
 *
 * @author nickj
 */
public class SQLUpdateService extends Service{

    public SQLUpdateService(String command) {
        super(command);
    }
    
    public void doWork()
    {
           String[] commandArray = command.split("\\|", 7);
        SongDAO sd = new SongDAO(); 
     
        Song s = new Song(Integer.parseInt(commandArray[1]),commandArray[2],commandArray[3],commandArray[4],Integer.parseInt(commandArray[5]),Integer.parseInt(commandArray[6]));
        
        sd.updateSong(s);
        
       


    }
    
}
