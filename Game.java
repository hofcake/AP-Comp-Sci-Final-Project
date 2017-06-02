import java.util.*;
public class Game
{ 
    int numberWins = 0;
    int numberAIWins = 0;
    Scanner keyboard = new Scanner(System.in);
    public void main(){
        System.out.print("\f");
        System.out.println("How many points to a win?");
        int winTotal = Integer.valueOf(keyboard.nextLine());
        System.out.println("");
        System.out.println("How big would you like the board");
        int size = Integer.valueOf(keyboard.nextLine());
        while((numberWins < winTotal) && (numberAIWins < winTotal)){
            oneGame(size);
            if(numberWins > numberAIWins)
                System.out.println("YOU WON THE GAME!!!!");
            else
                System.out.println("You Lost The Game :P");
        }
    }

    public int[] promptForInput(Board gameBoard){
        int[] coordArray = new int[2];
        boolean acceptable = false;
        String userEntry = "";
        String[] entryArray;
        while (acceptable == false){
            acceptable = true;
            System.out.println("Enter the X and Y coordinates of the space you would like to fill: ");
            userEntry = keyboard.nextLine();
            userEntry.replaceAll("\\s","");
            entryArray = userEntry.split(",");
            for(int i = entryArray.length - 1; i >= 0; i--){
                try{coordArray[i] = Integer.valueOf(entryArray[i]);}
                catch(NumberFormatException nfe){
                    System.out.print("\n");
                    gameBoard.printBoard();
                    System.out.println("Please enter valid coordinates");
                    coordArray = promptForInput(gameBoard);}
            }
            if(coordArray[0] > gameBoard.size()-1){
                acceptable = false;
                System.out.print("\n");
                gameBoard.printBoard();
                System.out.println("Your X coordinate was invalid");
                coordArray = promptForInput(gameBoard);
            }
            if(coordArray[1] > gameBoard.size()-1){
                acceptable = false;
                System.out.print("\n");
                gameBoard.printBoard();
                System.out.println("Your Y coordinate was invalid");
                coordArray = promptForInput(gameBoard);
            }
            if(!(gameBoard.checkMark(coordArray[0],coordArray[1]))){
                acceptable = false;
                System.out.print("\n");
                gameBoard.printBoard();
                System.out.println("There is already a mark there");
                coordArray = promptForInput(gameBoard);
            }
        }
        return coordArray;
    }

    public void oneGame(int size){ //true is the AI starting first, false is the human
        Board gameBoard = new Board();
        gameBoard.newBoard(size);
        AI theAI = new AI(gameBoard);
        Random rand = new Random();
        boolean first = rand.nextBoolean();
        int counter;
        if(first)
            counter = 1;
        else
            counter = 0;
        gameBoard.printBoard();
        while((!gameBoard.isWinner()) && (!gameBoard.isFull())){
            if(counter%2 == 0)
                gameBoard.newArrayMark(promptForInput(gameBoard),1);
            else
                gameBoard.newAIArrayMark(theAI.play(), 2);
            gameBoard.printBoard();
            counter++;
        }
        if(gameBoard.getWinner() == 1){
            System.out.println("You Won This Round!\nPress Enter To Continue");
            keyboard.nextLine();
            numberWins++;
        }
        else if(gameBoard.getWinner() == 2){
            System.out.println("You Lost This Round!\nPress Enter To Continue");
            keyboard.nextLine();
            numberAIWins++;
        }
        else{
            System.out.println("You Tied The AI This Round!\nPress Enter To Continue");
            keyboard.nextLine();
        }
        gameBoard.printBoard();
    }
}
