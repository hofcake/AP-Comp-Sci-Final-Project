import java.util.*;
public class Game
{
    public int[] promptForInput(Board gameBoard){
        int[] coordArray = new int[2];
        boolean acceptable = false;
        Scanner keyboard = new Scanner(System.in);//Declare and initialize a scanner object called keyboard
        String userEntry = "";
        String[] entryArray;
        userEntry = keyboard.nextLine();
        while(!userEntry.equals("*")){
            while (acceptable != true){
                System.out.print("\f");
                System.out.print(userEntry);
                System.out.print("Enter the x and y coordinates of the space you would like to fill or * to exit : ");
                userEntry = keyboard.nextLine();
                entryArray = userEntry.split(",");
                for(int i = 0; i < entryArray.length; i++){
                    coordArray[i] = Integer.valueOf(entryArray[i]);
                }
                for (int x = 0; x <=1; x ++){
                    if(coordArray[x] > gameBoard.size()){
                        System.out.println("These coordinates do not exist. Please enter new coordinates");
                    }
                    else{
                        acceptable = true;
                        return coordArray;
                    }
                }
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
                gameBoard.printBoard();
                gameBoard.newArrayMark(theAI.play(), 2);
                gameBoard.printBoard();
                gameBoard.newArrayMark(promptForInput(gameBoard), 1);
            }
        }
        else{
            while(!gameBoard.isWinner()){
                gameBoard.printBoard();
                gameBoard.newArrayMark(promptForInput(gameBoard),1);
                gameBoard.printBoard();
                gameBoard.newArrayMark(theAI.play(), 2);       
            }
        }
    }
}
