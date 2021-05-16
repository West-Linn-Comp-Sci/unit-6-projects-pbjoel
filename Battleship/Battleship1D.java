
/**
 * Write a description of class Battleship1D here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Battleship1D
{
    private boolean[] spaces;
    private int beginning;
    private int length;
    
    public Battleship1D(){
        length = 3;
        beginning = (int)(Math.random() * 4); // Replace 4 with 7 - length
        spaces = new boolean[length];
    }
    
    public int getBeginning(){
        return this.beginning;
    }
    
    public int getLength(){
        return this.length;
    }
    
    public void setHit(int space){
        spaces[space] = true;
    }
    
    public boolean checkSunk(){
        for (int i = 0; i < spaces.length; i++){
            if (spaces[i] == false){
                return false;
            }
        }
        return true;
    }
    
}
