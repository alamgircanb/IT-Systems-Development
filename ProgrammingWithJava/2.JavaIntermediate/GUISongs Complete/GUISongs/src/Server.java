

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
import java.io.*;
import java.net.*;
import java.util.concurrent.*;

/**
 *
 * @author nickj
 */
public class Server {

    //object to create port for incoming requests
    private ServerSocket server;
    //Declare IO pathways


    private ExecutorService responses;
    private static int HTTP_PORT = 3202;

    public Server() {
        try {
            server = new ServerSocket(HTTP_PORT, 100);
            responses = Executors.newFixedThreadPool(100);
        } catch (Exception e) {
            e.printStackTrace();
        }
     
    }

    public void start() {
        try {
            //set what port to establish listening on
            while (true) {
                //start listening for clients
                System.out.println("Waiting for client");
                ProcessSQL p = new ProcessSQL(server.accept());
                System.out.println("Client Connected");
                responses.execute(p);

            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Server s = new Server();
        s.start();
    }

}
