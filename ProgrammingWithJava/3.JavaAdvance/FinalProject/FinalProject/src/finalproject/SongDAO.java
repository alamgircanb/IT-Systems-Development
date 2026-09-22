/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package finalproject;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.*;

/**
 *handles all database operations.
 * @author User
 */
public class SongDAO {

    // getConnection
    // this code returns the Connection to an SQL database. Connections are needed
    // to send and receive data
    public Connection getConnection() {
        Connection conn = null;

        try {
            //load sQL server driver
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            
            //connection string
            String connectionUrl = "jdbc:sqlserver://localhost:1434;DatabaseName=Songs; "
                    + "User=javaApps;Password=Java233";
            //create connection
            conn = DriverManager.getConnection(connectionUrl);
            return conn;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return conn;
    }
    
    //returns an array list containing all songs in the database
    public ArrayList getSongs()
    {
        //create arraylist to return songs to user
        ArrayList songs = new ArrayList();
        
        //establish a connection to the database
        Connection conn = getConnection();
        
        //create a resultset to store the data from our query
        ResultSet rs = null;
        try
        {
            //create an sql statement
            Statement stmt = conn.createStatement();
            
            //send an sql query to get the data we need and store the returned 
            //data in our result set
            rs = stmt.executeQuery("SELECT id, title, artist, releaseYear, genreId, album FROM Songs");
            
            //parse the data that comes back into our arraylist
            while(rs.next())
            {
                //create a Song object to store a single record
                int id = Integer.parseInt(rs.getString(1));
                String title = rs.getString(2);
                String artist = rs.getString(3);
                int releaseYear = Integer.parseInt(rs.getString(4));
                int genreId = Integer.parseInt(rs.getString(5));
                String album = rs.getString(6);
                
                Song s = new Song(id, title, artist, album, releaseYear, genreId);
                
                //add the song to the arraylist to be returned
                songs.add(s);
            }
            
            //close connection to server
            conn.close();
        }
        catch(SQLException sqle)
        {
            System.out.println("There was a problem with the SQL when trying to get songs");
            sqle.printStackTrace();
        }
        catch(Exception e)
        {
            System.out.println("There was a problem trying to get songs");
            e.printStackTrace();
        }

        //return songs to user
        return songs;
    }
    
    //returns an array list containing all songs in the database
    public Song getSongById(int id)
    {
        //create variable to return to user
        Song s = new Song();
        
        //establish a connection to the database
        Connection conn = getConnection();
        
        //create a resultset to store the data from our query
        ResultSet rs = null;
        try
        {
            //create an sql statement
            Statement stmt = conn.createStatement();
            
            //send an sql query to get the data we need and store the returned 
            //data in our result set
            String query = "SELECT id, title, artist, releaseYear, genreId, album FROM Songs WHERE id=" + id;
            
            rs = stmt.executeQuery(query);
            
            //parse the data that comes back into our arraylist
            if(rs.next())
            {
                //create a Song object to store a single record       
                int songId = Integer.parseInt(rs.getString(1));
                String title = rs.getString(2);
                String artist = rs.getString(3);
                int releaseYear = Integer.parseInt(rs.getString(4));
                int genreId = Integer.parseInt(rs.getString(5));
                String album = rs.getString(6);
                
                s = new Song(songId, title, artist, album, releaseYear, genreId);
            }
            
            //close connection to server
            conn.close();
        }
        catch(SQLException sqle)
        {
            System.out.println("There was a problem with the SQL when trying to get songs");
            sqle.printStackTrace();
        }
        catch(Exception e)
        {
            System.out.println("There was a problem trying to get songs");
            e.printStackTrace();
        }
        
        //return songs to user
        return s;
    }
    
    //accepts a song object, reads the id value, then updates the database
    //item for that song id with the other info from the passed in song
    public void updateSongById(Song s)
    {
        //get connection to database
        Connection conn = getConnection();
        
        try
        {
            //make a statement
            Statement stmt = conn.createStatement();
            
            //create our update sql query
            String update = String.format("""
                                          UPDATE Songs SET Title = '%s',
                                          Artist = '%s',
                                          Album = '%s',
                                          ReleaseYear = %d,
                                          GenreId = %d
                                          WHERE id = %d""", s.getTitle(), s.getArtist(),
                                          s.getAlbum(), s.getReleaseYear(),
                                          s.getGenreId(), s.getId());
            
            //send our update sql query
            stmt.executeUpdate(update);
            
            //close connection to server
            conn.close();
        }
        catch(SQLException sqle)
        {
            System.out.println("An issue occured with the SQL when trying to update a song");
            sqle.printStackTrace();
        }
        catch(Exception e)
        {
            System.out.println("An issue occured when trying to update a song");
            e.printStackTrace();
        }
    }
    
    public void insertSong(Song s)
    {
        //establish connection
        Connection conn = getConnection();
        
        try
        {
            //create a statement
            Statement stmt = conn.createStatement();
            
            //write a sql insert statement
            String insert = String.format("""
                                          INSERT INTO Songs(title, artist, album, releaseYear, genreId)
                                          VALUES('%s', '%s', '%s', %d, %d)""",
                                          s.getTitle(), s.getArtist(),
                                          s.getAlbum(), s.getReleaseYear(), s.getGenreId());
            
            //execute the statement
            stmt.executeUpdate(insert);
            
            //close the connection
            conn.close();
        }
        catch(SQLException sqle)
        {
            System.out.println("There was an error with the SQL when inserting song");
            sqle.printStackTrace();
        }
        catch(Exception e)
        {
            System.out.println("There was an error when inserting song");
            e.printStackTrace();
        }
    }
    
    public void deleteSongById(int id)
    {
        //establish connection
        Connection conn = getConnection();
        
        try
        {
            //create a statement
            Statement stmt = conn.createStatement();
            
            //write a sql delete statement
            String delete = "DELETE FROM Songs WHERE id = "+id;
            
            //execute the statement
            stmt.executeUpdate(delete);
            
            //close the connection
            conn.close();
        }
        catch(SQLException sqle)
        {
            System.out.println("There was an error with the SQL when deleting song");
            sqle.printStackTrace();
        }
        catch(Exception e)
        {
            System.out.println("There was an error when deleting song");
            e.printStackTrace();
        }
    }
}
