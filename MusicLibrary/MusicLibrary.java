

/**
 * Write a description of class MusicLibrary here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Arrays;
public class MusicLibrary
{
    private Album[] library;
    private double totalPlaytime;
    private int totalTracks;
    boolean sorted;
    
    public MusicLibrary(){
        library = new Album[10];
        totalPlaytime = 0;
        totalTracks = 0;
        sorted = false;
    }
    
    public Album[] getLibrary(){
        return library;
    }
    
    public double getTotalPlaytime(){
        return this.totalPlaytime;
    }
    
    public int getTotalTracks(){
        return this.totalTracks;
    }
    
    public Album getAlbum(int index){
        return library[index];
    }
    
    public void add(Album added){
        // Scan through each element of the library array. When the earliest value 
        // that is null is found, replace it with /added/. If there are no available
        // spaces, display an error message.
        boolean hasSpace = false;
        for (Album album : library){
            if (album == null){
                hasSpace = true;
            }
        }
        
        if (hasSpace){
            for (int selected = 0; selected < library.length; selected++){
                if (hasSpace && library[selected] == null){
                    library[selected] = added;
                    hasSpace = false;
                    System.out.println("+++Added new album " + added.getTitle() + "+++\n");
                    
                    this.totalPlaytime += added.getPlaytime();
                    this.totalTracks += added.getNumTracks();
                }
            }
        } else {
            System.out.println("There is no more room in this library!");
        }
    }
    
    public void doubleSize(){
        if (library.length == 10){
            Album[] newLibrary = new Album[20];
            for (int i = 0; i < library.length; i++){
                newLibrary[i] = library[i];
            }
            library = newLibrary;
            System.out.println("Doubled the size of your library!");
        } else {
            System.out.print("You have already increased the size of your library. ");
            System.out.println("This can only be done once.\n");
        }
    }
    
    public void remove(int remove){
        this.totalTracks -= library[remove].getNumTracks();
        this.totalPlaytime -= library[remove].getPlaytime();
        
        library[remove] = null;
        System.out.println("***Removed album number " + (remove + 1) + "***\n");
    }
    
    public String toString(){
        String libraryString = "~~~Your library has several albums:~~~";
        libraryString += "\nIt has " + totalTracks + "total songs, for a total runtime of " + totalPlaytime + "minutes.";
        int selected = 0;
        for (Album al : library){
            if (al != null){
                libraryString += "\n\nAlbum number: " + (selected + 1) + "\n";
                libraryString += al.toString();
            }
            selected++;
        }
        return libraryString;
    }
}