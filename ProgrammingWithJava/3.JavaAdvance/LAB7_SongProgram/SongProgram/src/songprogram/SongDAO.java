/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package songprogram;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.*;
/**
 *
 * @author User
 */
public class SongDAO {
    /**
     * This function establishes a connection to the sql database and retrun it
     * @return Connection -returns the connection to the database
     */
    public Connection getConnection()
    {
        Connection conn=null;
        try{
          // Tells the DriverManager how to talk to the database using the JDBC Driver
          Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
          
          // Connection string for the local SQL server
          String connectionUrl ="jdbc:sqlserver://localhost:1434;"+
                   "DatabaseName=Songs;"+
                    "User=javaApps;"+ 
                    "Password=Java233;";
          conn = DriverManager.getConnection(connectionUrl);
          return conn;       
        }
        catch(Exception e)
        {
            System.out.println("An error occured when establishing the connection"+
                    "to the database");
            e.printStackTrace();
         }
        // return the connection
        return conn;
    }
    
    /**
     * Establish a connection with the database and get back a list of all songs.
     * Retrieves all songs
     * @return ArrayList -an arraylist of songs returned from the database;
     */
    public ArrayList getSongs()
    {
        ArrayList songs= new ArrayList();
        //Establish connection with the database
        Connection conn = getConnection();
        try {
        //create an sql statement
        Statement stmt= conn.createStatement();
        String query="SELECT id, title, artist, releaseYear, genreId, album FROM Songs";
        //send that sql statement
        ResultSet rs=stmt.executeQuery(query);
        //parse the results
        //it will  read every data rest, every time any data left it will loop
        while(rs.next())
        {
          // store the data from the result set as a Song object
            Song s = new Song(rs.getInt(1),//id
                    rs.getString(2),// title
                    rs.getString(3),//artist
                    rs.getInt(4),//Release Year
                    rs.getInt(5),//genreId
                    rs.getString(6));//album
            //add the song to the ArrayList
            songs.add(s);
        }
        //close the connection with the database
        conn.close();
        } catch (SQLException sqle) {
            System.out.println("There was an error with the SQL sent to the server"+
                    "When retriving all songs");
            sqle.printStackTrace();
        }   
        catch(Exception e)
        {
            System.out.println("There was an unknown error"+
                    "When retreiving all songs");
            e.printStackTrace();
        }
        return songs;
    }
    /**Retrieves a specific song record from the databased by id
     * 
     * @param id thhe unique integer ID of the song to search for
     * @return song that match against id.
     */
    public Song getSongById(int id) {
        Song s = null;
        Connection conn = getConnection();
        try {
            Statement stmt = conn.createStatement();
            String query = "SELECT id, title, artist, releaseYear, genreId, album FROM Songs WHERE id=" + id;
            ResultSet rs = stmt.executeQuery(query);
            if (rs.next()) {
                s = new Song(
                        Integer.parseInt(rs.getString(1)),//song id
                        rs.getString(2),//song title
                        rs.getString(3),//song artist
                        Integer.parseInt(rs.getString(4)), //song release year
                        Integer.parseInt(rs.getString(5)),//song genre id
                        rs.getString(6));//song album
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return s;
    }
    /**
     * Establishes a connection with the database and sends an update command
     * to update the song with the corresponding ID
     * @param s the information we need to update the database
     */
    public void updateSongById(Song s)
    {
        // stablish a connection with the database
        Connection conn= getConnection();
        try
        {
        Statement stmt =conn.createStatement();
        // create a statement to send
        String query ="UPDATE Songs SET "+
                "title='"+s.getTitle()+"',"+
                "artist='"+s.getArtist()+"',"+
                "releaseYear='"+s.getReleaseYear()+"',"+
                "genreId="+s.getGenreId()+","+
                "album='"+s.getAlbum()+"'"+
                "WHERE id="+s.getId();
        //send our statement to the database. execute update is also for inserting and deleting
        stmt.executeUpdate(query);
        //close our statement with the database
        conn.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    /**
     * Deletes a song from the database based on ID
     * @param id of the song to delete
     */
    public void deleteSong (int id){
        
        // establish a connection with the database
        Connection conn = getConnection();
        try{
            Statement stmt=conn.createStatement();
            //sql query to delete string
            String delete ="DELETE FROM Songs WHERE Id="+id;
            stmt.executeUpdate(delete);
            //close our statement with the database
            conn.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
