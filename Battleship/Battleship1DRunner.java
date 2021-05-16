import java.util.Scanner;
public class Battleship1DRunner
{
    private int[] field;
    private int misses;
    private int hits;
    private int guesses;
    
    public Battleship1DRunner(){
        field = new int[7];
        misses = 0;
        guesses = 0;
        hits = 0;
    }
    
    public void placeShip(Battleship1D ship){
        for (int i = ship.getBeginning(); i  < ship.getLength() + ship.getBeginning(); i++){
            field[i] = 1;
        }
    }
    
    public void takeGuess(int guess, Battleship1D ship){
        if (field[guess - 1] == 0){
            System.out.println("You missed! *sad trombone noises*");
            misses++;
        } else if (field[guess - 1] == 1){
            ship.setHit(guess - ship.getBeginning() - 1);
            field[guess - 1] = 2;
            System.out.println("You got a hit at spot " + (guess) + "!");
            hits++;
        } else if (field[guess - 1] == 2){
            System.out.println("You've already got a hit there!");
        }
        guesses++;
    }
    
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        Battleship1D myShip = new Battleship1D();
        Battleship1DRunner game = new Battleship1DRunner();
        
        game.placeShip(myShip);
        boolean shipSunk = false;
        
        System.out.println("-----       ---     ----------------  ----       --------   ------   ---- ----  ----  -------  ");
        System.out.println("|    \\     /   \\    |              |  |  |       |    __|  /      \\  |  | |  |  |  |  |      \\");
        System.out.println("| ||  |    |   |    ---  ------  ---  |  |       |   |     |  ||__|  |  | |  |  |  |  |  ||   |");
        System.out.println("| ||  |   /     \\     |  |    |  |    |  |       |   |__   |  |___   |  | |  |  |  |  |  ||   |");
        System.out.println("|    /    |     |     |  |    |  |    |  |       |    __|  \\      \\  |  |_|  |  |  |  |       |");
        System.out.println("|    \\    | ( ) |     |  |    |  |    |  |       |   |      \\___  |  |   _   |  |  |  |   ___/");
        System.out.println("| ||  |  /       \\    |  |    |  |    |  |       |   |      __ |  |  |  | |  |  |  |  |  |");
        System.out.println("| ||  |  |  ___  |    |  |    |  |    |  |_____  |   |__   |  ||  |  |  | |  |  |  |  |  |");
        System.out.println("|    /  /  |   |  \\   |  |    |  |    |        | |      |  \\      /  |  | |  |  |  |  |  |");
        System.out.println("-----   ----   ----   ----    ----    ---------- --------   ------   ---- ----  ----  ----");
        // It looks good in the program I swear
        
        System.out.println("\t\t\t\tWelcome to scuffed Battleship!\n");
        System.out.println("This game might be a bit different to regular Battleship. There's only 1 row (for now)...");
        System.out.println("But let's get ready to play! Type your name to start the game!");
        
        String userName = in.nextLine();
        
        while (!shipSunk){
            System.out.print("Pick a space on the field by typing an integer between 1 and 7!");
            int userChoice = in.nextInt();
            
            if (userChoice > 7 || userChoice < 1){
                System.out.println("That isn't an integer between 1 and 7!\n");
                break;
            }
            
            game.takeGuess(userChoice, myShip);
            System.out.println();
            
            shipSunk = myShip.checkSunk();
        }
        
        System.out.println("Congratulations " + userName + "! You sunk all the battleships!");
        System.out.println("\n\n~~Your stats:~~");
        System.out.println("Total guesses: " + game.guesses);
        System.out.println("Misses: " + game.misses);
        System.out.println("Hits: " + game.hits);
        System.out.println();
        
        double accuracy = ((double)game.hits / game.guesses) * 100.0;
        System.out.println("Your hit accuracy out of " + game.guesses + " total guesses was " + accuracy + " percent!");
        System.out.println("\nWell done! Hope you come back to play soon!");
    }
}
