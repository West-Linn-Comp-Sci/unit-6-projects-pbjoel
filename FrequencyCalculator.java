
/**
 * Write a description of class FrequencyCalculator here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Scanner;
import java.util.ArrayList;
public class FrequencyCalculator
{
    public static void main(String [] args){
        Scanner in = new Scanner(System.in);
        int range0 = 0, range10 = 0, range20 = 0, range30 = 0, range40 = 0, range50 = 0, range60 = 0, range70 = 0, range80 = 0, range90 = 0;
        boolean run = true;
        ArrayList<Integer> numList = new ArrayList<Integer>();
        
        System.out.println("Welcome to the frequency calculator.");
        while (run == true){
            System.out.print("Please insert an integer between 0 and 100, ");
            System.out.println("or type \"stop\" to end the entries.");
            String userChoice = in.nextLine();
            if (userChoice.toLowerCase().equals("stop")){
                run = false;
            } else {
                int choiceInt = Integer.parseInt(userChoice);
                numList.add(choiceInt);
            }
        }
        System.out.println("\nNumber entry complete.");
        for (Integer int : numList){
            
        }
    }
}
