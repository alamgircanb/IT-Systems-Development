/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package finalproject;
import java.io.*;
import java.net.*;

/**
 *Handles one client request
 * reads the command from the client, sends the work to the correct service class based on command type.
 * @author User
 */
public class ProcessSQL implements Runnable {

    private Socket connection;
    private ObjectOutputStream output;
    private ObjectInputStream input;
    private String command;
    
    public ProcessSQL(Socket connection)
    {
        this.connection = connection;
    }

    /**
     *Runs the client request in a separate thread
     */
    @Override
    public void run()
    {
        try
        {
            //establish io connections (create output stream, flush it and then create input stream)
            output = new ObjectOutputStream(connection.getOutputStream());
            output.flush();
            input = new ObjectInputStream(connection.getInputStream());
            
            //read command from client
            command = (String)input.readObject();
            
            //write command to log file
            LoggerUtil.logCommand(command);
            
            //choose service based on command type
            if(command.indexOf("#select") == 0)
            {
                Service s = new SQLSelectService(command, output);
                s.doWork();
            }
            else if(command.indexOf("#update") == 0)
            {
                Service s = new SQLUpdateService(command, output);
                s.doWork();
            }
            else if(command.indexOf("#insert") == 0)
            {
                Service s = new SQLInsertService(command, output);
                s.doWork();
            }
            else if(command.indexOf("#delete") == 0)
            {
                Service s = new SQLDeleteService(command, output);
                s.doWork();
            }
            
            //close connection
            connection.close();
        }
        catch(Exception e)
        {
            System.out.println("error in process");
        }
    }
}
