/**
 * Write a description of class Album here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Album
{
    private String title;
    private String artist;
    private int numSongs;
    private double playTime;
    
    public Album(String albumName, String albumArtist, int songs, double albumTime){
        title = albumName;
        artist = albumArtist;
        numSongs = songs;
        playTime = albumTime;
    }
    
    public String getTitle(){
        return this.title;
    }
    
    public String getArtist(){
        return this.artist;
    }
    
    public int getNumTracks(){
        return this.numSongs;
    }
    
    public double getPlaytime(){
        return this.playTime;
    }
    
    public String toString(){
        return "\nAlbum Title: " + this.title + "\nAlbum Artist: " + this.artist + "\nNumber of Songs: " + this.numSongs + "\nAlbum Playtime: " + this.playTime;
    }
}

