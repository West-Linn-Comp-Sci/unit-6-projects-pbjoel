/**
 * Write a description of class LibrarySearchSort here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class LibrarySearchSort
{
    MusicLibrary program;
    Album[] library;
    
    public LibrarySearchSort(){
        program = new MusicLibrary();
        library = program.getLibrary();
    }
    
    public String findUnsorted(int searchFor, String search){
        if (searchFor == 0){
            for (int selected = 0; selected < library.length; selected++){
                if (library[selected].getTitle().equals(search)){
                    return "An album of this title is album number " + (selected + 1);
                }
            }
            return "Your library does not have any albums of this title.";
        } else if (searchFor == 1){
            for (int selected = 0; selected < library.length; selected++){
                if (library[selected].getArtist().equals(search)){
                    return "Your artist is in album number " + (selected + 1);
                }
            }
            return "Your library does not have any albums by this artist.";
        }
        return "Invalid input. Please try again.";
    }
    
    public void sortTitle(){
        int min;
        Album temp;
        
        for (int selected = 0; selected < library.length; selected++){
            min = selected;
            for (int compared = selected + 1; compared < library.length; compared++){
                int i = library[selected].getTitle().compareTo(library[compared].getTitle());
                if (i < 0){
                   min = compared; 
                }
            }
            
            temp = library[min];
            library[min] = library[selected];
            library[selected] = temp;
        }
        
        program.sorted = true;
    }
    
    public void sortArtist(){
        for(int selected = 1; selected < library.length; selected++){
            Album key = library[selected];
            int compared = selected;
            
            while (compared > 0 && library[selected].getArtist().compareTo(library[compared].getArtist()) > 0){
                library[compared] = library[compared - 1];
                compared--;
            }
            library[compared] = key;
        }
        
        program.sorted = true;
    }
    
    public String searchSorted(int searchFor, String search){
        if (!(program.sorted)){
            return "You can't use this yet! The library isn't sorted, so this won't work!";
        } else {
            boolean isFound = false;
            int lower = 0;
            int upper = library.length - 1;
            if (searchFor == 0){
                while (!isFound){
                    int middle = (lower + upper) / 2;
                    int comparison = library[middle].getTitle().compareTo(search);
                    if (comparison == 0){
                        isFound = true;
                        return "Success! The album with that title is album number " + (middle + 1) + ".";
                    } else if (comparison < 0){
                        lower = middle;
                    } else {
                        upper = middle;
                    }
                }
            } else if (searchFor == 1){
                while (!isFound){
                    int middle = (lower + upper) / 2;
                    int comparison = library[middle].getArtist().compareTo(search);
                    if (comparison == 0){
                        isFound = true;
                        return "Album found! An album by that artist is album number " + (middle + 1) + ".";
                    } else if (comparison < 0){
                        lower = middle;
                    } else {
                        upper = middle;
                    }
                }
            }
        }
        return "Invalid input. Please try again.";
    }
}
