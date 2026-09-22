/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author nickj
 */
public class Song {
    private int id;
    private String title;
    private String artist;
    private int releaseYear;
    private int genreId;
    private String album;
    
    public Song(){}

    public Song(int id, String title, String artist, int releaseYear, int genreId, String album) {
        this.id = id;
        this.title = title;
        this.artist = artist;
        this.releaseYear = releaseYear;
        this.genreId = genreId;
        this.album = album;
    }
    
       public Song(int id, String title, String artist, String album, int releaseYear, int genreId) {
        this.id = id;
        this.title = title;
        this.artist = artist;
        this.releaseYear = releaseYear;
        this.genreId = genreId;
        this.album = album;
    }
    

    public Song(String title, String artist, int releaseYear, int genreId, String album) {
        this.title = title;
        this.artist = artist;
        this.releaseYear = releaseYear;
        this.genreId = genreId;
        this.album = album;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public int getGenreId() {
        return genreId;
    }

    public void setGenreId(int genreId) {
        this.genreId = genreId;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }
    
    
    
}
