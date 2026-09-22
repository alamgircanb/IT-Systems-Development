/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.io.*;
import java.io.*;
import java.net.*;


/**
 *
 * @author nickj
 */
public class ProcessSQL implements Runnable {

    private Socket connection;
    private ObjectOutputStream output;
    private ObjectInputStream input;
    private String command;
    public ProcessSQL(Socket connection) {
        this.connection = connection;
    }

    public void run() {

        try{
                  //establish io connections
           output = new ObjectOutputStream(connection.getOutputStream());
            output.flush();
            input = new ObjectInputStream(connection.getInputStream());
            
            command = (String)input.readObject();

            
            
            if(command.indexOf("#select")==0)
            {
            Service s = new SQLSelectService(command,output);
            s.doWork();
            }
            else if(command.indexOf("#update")==0)
            {
            Service s = new SQLUpdateService(command);
            s.doWork();
            }
        
        connection.close();
        }
        catch(Exception e)
        {
            System.out.println("error in process");
        }
      
    }

}
