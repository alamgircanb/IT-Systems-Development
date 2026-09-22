/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package finalproject;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *writes server activities to a log file
 * @author User
 */
public class LoggerUtil {
    /***
     * logs a command into server_log.txt file
     * @param command received from client
     */
    public static void logCommand(String command)
    {
        try
        {
            //create timestamp for the log info.
            String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
            //combine timestamp with command
            String log = timeStamp + " | " + command;
            //write to file (append mode)
            PrintWriter out = new PrintWriter(new FileWriter("server_log.txt", true));
            out.println(log);
            out.close();
            //also print to console
            System.out.println(log);
        }
        catch(Exception e)
        {
            System.out.println("error writing to log file");
        }
    }
}
