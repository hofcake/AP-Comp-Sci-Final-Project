import java.util.*;
public class Game
{
    public int[] promptForInput(Board gameBoard){
        int[] coordArray = new int[2];
        int counter = 0;
        boolean acceptable = false;
        Scanner keyboard = new Scanner(System.in);//Declare and initialize a scanner object called keyboard
        String userEntry = "";
        String[] entryArray;
        userEntry = keyboard.nextLine();
        while (acceptable == false){
            System.out.print("\f");
            System.out.print(userEntry);
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
            while(gameBoard.isWinner() != true){
                gameBoard.printBoard();
                gameBoard.newArrayMark(theAI.play(), 2);
                gameBoard.printBoard();
                gameBoard.newArrayMark(promptForInput(gameBoard), 1);
            }
        }
        else{
            while(!gameBoard.isWinner() != true){
                gameBoard.printBoard();
                gameBoard.newArrayMark(promptForInput(gameBoard),1);
                gameBoard.printBoard();
                gameBoard.newArrayMark(theAI.play(), 2);
            }
        }
        System.out.print("you win");
    }
}
