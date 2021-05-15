import java.util.Arrays;
import java.util.ArrayList;
public class Lists
{
    // Remove all values of zero from the list
    public static void removeZeros(ArrayList<Integer> list){
        for (int i = 0; i < list.size(); i++){
            if (list.get(i) == 0){
                list.remove(i);
                i --;
            }
        }
    }
    
    // Count up and return the number of characters (letters, 
    // digits, blank spaces, etc.) in all of the strings of list
    public static int countLetters(ArrayList<String> list){
        int lengthSum = 0;
        for (int i = 0; i < list.size(); i++){
            lengthSum += list.get(i).length();
        }
        return lengthSum;
    }
    
    // Return the first subscript position within list in which 
    // keyValue is found. Otherwise, return -1
    public static int findPosition(ArrayList<Integer> list, int keyValue){
        for (int i = 0; i < list.size(); i++){
            if (list.get(i) == keyValue){
                return i;
            }
        }
        return -1;
    }
    
    // Break input up into individual letters and store each letter
    // into an ArrayList of strings that is instantiated as a local variable
    public static ArrayList parseIntoArrayList(String input){
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < input.length(); i++){
            list.add(input.substring(i, i + 1));
        }
        return list;
    }
    
    public static String findMin(ArrayList<Person> list){
        int minAgeIndex = -1;
        int minAge = Integer.MAX_VALUE;
        for (int i = 0; i < list.size(); i++){
            if (list.get(i).getAge() < minAge){
                minAge = list.get(i).getAge();
                minAgeIndex = i;
            }
        }
        return list.get(minAgeIndex).getName();
    }
    
    public static void main(String[] args){
        System.out.println("Test Remove Zeros");
        ArrayList<Integer> nums = new ArrayList<>(Arrays.asList(3,4,0,0,1,4,0,6,0));
        System.out.println("Starting List: " + nums);
        removeZeros(nums);
        System.out.println("Expected: [3, 4, 1, 4, 6] \n Actual: " + nums);

        System.out.println();

        ArrayList<String> words = new ArrayList<>(Arrays.asList("this", "is", "a", "list", "of", "words"));
        System.out.println("Test Letter Counter:");
        System.out.println(words);
        System.out.println("Expected: 18 \n Actual: " + countLetters(words));

        System.out.println();

        System.out.println("Test keyPosition: find a 1");
        System.out.println(nums);
        System.out.println("Expected: 2 \n Actual: " + findPosition(nums, 1));

        System.out.println();

        System.out.println("Test parse into array");
        System.out.println("Expected: [W, e, s, t,  , L, i, n, n] \n Actual: " + parseIntoArrayList("West Linn"));

        System.out.println();
        
        System.out.println("Test FindMin for Person objects");
        ArrayList<Person> people = new ArrayList<>(Arrays.asList(new Person(32, "Abe"),
                new Person(14, "Betty"), new Person(18, "Cris")));
        System.out.println("[Abe, Betty, Cris]");
        System.out.println("Expected: BETTY \n Actual: " + findMin(people));

        System.out.println();
        
        System.out.println("Purse Test:");
        Purse myPurse = new Purse();
        myPurse.add(new Coin(.25, "quarter"));
        myPurse.add(new Coin(.05, "nickel"));
        myPurse.add(new Coin(.01, "penny"));
        myPurse.add(new Coin(.25, "quarter"));

        Coin testCoin = new Coin(.01, "penny");
        
        System.out.println(myPurse);
        System.out.println("# of Quarters = " + myPurse.count(new Coin(.25, "quarter")));
        System.out.println("Smallest Coin = " + myPurse.findSmallest());
        System.out.println("Total of Purse = $" + myPurse.getTotal());
    }
}
