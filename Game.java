public class Game
{
	public void promptForInput()
    {
        //Declare and initialize a scanner object called keyboard
	Scanner keyboard = new Scanner(System.in);
    String userEntry = "";
	userEntry = keyboard.nextLine();
	Board gameBoard = new Board(userEntry);
        while(!userEntry.equals("*")){
            System.out.print("\f");
            System.out.print(userEntry);
            System.out.print("Enter the x and y coordinates of the space you would like to fill or * to exit : ");
            userEntry = keyboard.nextLine();
		String[] coordinatesArray = userEntry.split(",");
        }
        System.out.print("\nGood Bye!");
    }
	/*public void oneGame(int size, boolean aiFirst){ //true is the AI starting first, false is the human
		Board gameBoard = new Board(size);
		if(aiFirst){
			while(!gameBoard.checkForWin){
				gameBoard.printBoard();
				//INSERT AI COMMANDS
				System.out.println("Choose your 
			}
		}
		else{
			while(!gameBoard.checkForWin){
				
		}
		}
	}*/
}
