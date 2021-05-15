import java.util.ArrayList;
public class Purse { 
    private ArrayList<Coin> coins; 
 
    public Purse(){ 
        coins = new ArrayList<Coin>(); 
    }
 
    // adds aCoin to the purse 
    public void add(Coin aCoin){ coins.add(aCoin); } 
 
    // returns total value of all coins in purse 
    public double getTotal(){ 
        double total = 0.0;
        for (int i = 0; i < coins.size(); i++){
            total += coins.get(i).getValue();
        }
        return total;
    } 
 
    // returns the number of coins in the Purse that matches aCoin 
    // (both myName & myValue) 
    public int count(Coin aCoin){
        int matched = 0;
        for (int i = 0; i < coins.size(); i++){
            if(coins.get(i).isEqual(aCoin)){
                matched++;
            }
        }
        return matched;
    }
    
    public Coin findSmallest(){
        int minIndex = Integer.MAX_VALUE;
        double minValue = Integer.MAX_VALUE;
        for (int i = 0; i < coins.size(); i++){
            if (coins.get(i).getValue() < minValue){
                minValue = coins.get(i).getValue();
                minIndex = i;
            }
        }
        return coins.get(minIndex);
    }
}
