import java.util.*;
public class Game
{ 
    Scanner keyboard = new Scanner(System.in);
    public int[] promptForInput(Board gameBoard){
        int[] coordArray = new int[2];
        int counter = 0;
        boolean acceptable = false;
        String userEntry = "";
        String[] entryArray;
        while (acceptable == false){
            System.out.println("Enter the x and y coordinates of the space you would like to fill or * to exit : ");
            userEntry = keyboard.nextLine();
            entryArray = userEntry.split(",");
            for(int i = entryArray.length - 1; i >= 0; i--){
                coordArray[i] = Integer.valueOf(entryArray[i]);
            }
            for (int x = 0; x <= 1; x ++){
                if(coordArray[x] >= gameBoard.size() || coordArray[x] < 0){
                    acceptable = false;
                }
            }
            if((coordArray[0] < gameBoard.size() && coordArray[0] >= 0) && (coordArray[1] < gameBoard.size() && coordArray[1] >= 0)){
                acceptable = true;
            }
        }
        return coordArray;
    }

    public void oneGame(int size, boolean aiFirst){ //true is the AI starting first, false is the human
        Board gameBoard = new Board();
        gameBoard.newBoard(size);
        AI theAI = new AI(gameBoard);
        if(aiFirst){
            while(!gameBoard.isWinner()){
                gameBoard.newArrayMark(theAI.play(), 2);
                gameBoard.printBoard();
                gameBoard.newArrayMark(promptForInput(gameBoard), 1);
            }
        }
        else{
            while(!gameBoard.isWinner()){
                gameBoard.printBoard();
                gameBoard.newArrayMark(promptForInput(gameBoard),1);
                gameBoard.newArrayMark(theAI.play(), 2);
            }
        }
        System.out.print("you win");
    }
}
