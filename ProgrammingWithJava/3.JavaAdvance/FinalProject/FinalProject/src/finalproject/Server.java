/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package finalproject;

import java.io.*;
import java.net.*;
import java.util.concurrent.*;

/**
 *listens for incoming client connections
 * Uses a thread pool to handle multiple clients at the same time.
 * @author User
 */
public class Server {

    //server socket for listening or incomming communication
    private ServerSocket server;
    
    //thread pool for handling client responses
    private ExecutorService responses;
    //server port
    private static int HTTP_PORT = 3202;

    public Server()
    {
        try
        {
            //create server socket with port and backlog size (waiting queue)
            server = new ServerSocket(HTTP_PORT, 100);
            //create thread pool (maximum 100 thread capacity, maximum 100 clients processed at the same time)
            responses = Executors.newFixedThreadPool(100);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    /**
     * Starts the server and listens for clients
     */
    public void start()
    {
        try
        {
            //server will keep listening for clients
            while(true)
            {
                System.out.println("Waiting for client");
                ProcessSQL p = new ProcessSQL(server.accept());
                System.out.println("Client Connected");
                responses.execute(p);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    //Main method to start server
    public static void main(String[] args)
    {
        Server s = new Server();
        s.start();
    }
}
