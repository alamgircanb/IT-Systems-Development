/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.*;

/**
 *
 * @author nickj
 */
public class SongDAO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        SongDAO dbLayer = new SongDAO();

        ArrayList songs = dbLayer.getSongs();

        for (int i = 0; i < songs.size(); i++) {

            Song s = (Song) songs.get(i);

            System.out.println("ID: " + s.getId());
            System.out.println("Title: " + s.getTitle());
            System.out.println("Artist: " + s.getArtist());
            System.out.println("Release Year: " + s.getReleaseYear());
            System.out.println("Genre Id: " + s.getGenreId());
            System.out.println("Album: " + s.getAlbum());
            System.out.println("--------------------------");

        }
    }

    public ArrayList getSongs() {
        ArrayList songs = new ArrayList();

        Connection conn = getConnection();

        ResultSet rs = null;

        try {

            Statement stmt = conn.createStatement();

            rs = stmt.executeQuery("select id,title,artist,releaseYear,genreId,album from Songs");

            while (rs.next()) {

                Song s = new Song(Integer.parseInt(rs.getString(1)),
                        rs.getString(2), rs.getString(3), Integer.parseInt(rs.getString(4)), Integer.parseInt(rs.getString(5)), rs.getString(6));

                songs.add(s);

            }

        } catch (Exception e) {

            e.printStackTrace();

        }

        return songs;
    }

    public void updateSong(Song s) {
        Connection con = getConnection();

        try {
            Statement stmt = con.createStatement();
            String update = "UPDATE SONGS SET Title = '" + s.getTitle()
                    + "', Artist = '" + s.getArtist()
                    + "', Album = '" + s.getAlbum()
                    + "' WHERE Id=" + s.getId();

            stmt.executeUpdate(update);
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteSong(int id) {
        Connection con = getConnection();

        try {
            Statement stmt = con.createStatement();
            String delete = ("DELETE from Songs WHERE Id=" + id);
            stmt.executeUpdate(delete);
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Song getSongById(int id) {
        Song s = null;
        Connection con = getConnection();
        ResultSet rs = null;

        try {
            Statement stmt = con.createStatement();
            rs = stmt.executeQuery("select id,title,artist,releaseYear,genreId,album from Songs where id=" + id);
            System.out.println(id);
            if (rs.next()) {
                s = new Song(Integer.parseInt(rs.getString(1)),
                        rs.getString(2), rs.getString(3), Integer.parseInt(rs.getString(4)), Integer.parseInt(rs.getString(5)), rs.getString(6));
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return s;
    }

    public Connection getConnection() {
        Connection con = null;

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); //how to connect to server

            String connectionUrl = "jdbc:sqlserver://localhost:1434;DatabaseName=Songs;User=javaApps;Password=test123"; //connection string with necessary data
            con = DriverManager.getConnection(connectionUrl); //passing in connection
            return con;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
