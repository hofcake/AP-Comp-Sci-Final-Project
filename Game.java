import java.util.*;
public class Game
{ 
    int numberWins = 0;
    int numberAIWins = 0;
    Scanner keyboard = new Scanner(System.in);
    public void main(){
        System.out.println("How many points to a win?");
        int winTotal = Integer.valueOf(keyboard.nextLine());
        System.out.println("How big would you like the board");
        int size = Integer.valueOf(keyboard.nextLine());
        while((numberWins < winTotal) || (numberAIWins < winTotal))
            oneGame(size, false);
        if(numberWins > numberAIWins)
            System.out.println("YOU WON THE GAME!!!!");
        else
            System.out.println("You Lost The Game :P");
    }
    public int[] promptForInput(Board gameBoard){
        int[] coordArray = new int[2];
        boolean acceptable = false;
        String userEntry = "";
        String[] entryArray;
        while (acceptable == false){
            acceptable = true;
            System.out.println("Enter the x and y coordinates of the space you would like to fill or * to exit : ");
            userEntry = keyboard.nextLine();
            entryArray = userEntry.split(",");
            for(int i = entryArray.length - 1; i >= 0; i--){
                coordArray[i] = Integer.valueOf(entryArray[i]); //Convert to Integer
            }
            if(coordArray[0] > gameBoard.size()-1){
                acceptable = false;
                System.out.println("Your X cordinate was invalid");
            }
            if(coordArray[1] > gameBoard.size()-1){
                acceptable = false;
                System.out.println("Your Y conrdinate was invalid");
            }
            if(!(gameBoard.checkMark(coordArray[0],coordArray[1]))){
                acceptable = false;
                System.out.println("There is already a mark there");
            }
        }
        return coordArray;
    }

    public void oneGame(int size, boolean aiFirst){ //true is the AI starting first, false is the human
        Board gameBoard = new Board();
        gameBoard.newBoard(size);
        AI theAI = new AI(gameBoard);
        if(aiFirst){
            while((!gameBoard.isWinner()) && (!gameBoard.isFull())){
                gameBoard.newArrayMark(theAI.play(), 2);
                gameBoard.printBoard();
                gameBoard.newArrayMark(promptForInput(gameBoard), 1);
            }
        }
        else{
            while((!gameBoard.isWinner()) && (!gameBoard.isFull())){
                gameBoard.printBoard();
                gameBoard.newArrayMark(promptForInput(gameBoard),1);
                gameBoard.newArrayMark(theAI.play(), 2);
            }
        }
        if(gameBoard.getWinner() == 1){
            System.out.println("You Won This Round!!!!\nPress Enter To Continue");
            keyboard.nextLine();
        }
        else if (gameBoard.getWinner() == 2){
            System.out.println("You Lost :P\nPress Enter To Continue");
            keyboard.nextLine();
        }
        else{
            System.out.println("tie\nPress Enter To Continue");
            keyboard.nextLine();
        }
        gameBoard.printBoard();
    }
}
