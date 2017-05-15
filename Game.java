public class Game
{
	int[] coordArray = new int[2];
	public void promptForInput()
    {
	boolean acceptable = false;
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
		coordArray = userEntry.split(",");
		while (acceptable != true){
		for (x = 0; x <=1; x ++){
				if(coordArray[x] > gameBoard.size()){
				System.out.println("These coordinates do not exist. Please enter new coordinates");
				System.out.println
				}
				}
		}
        }
        System.out.print("\nGood Bye!");
    }
	/*public void oneGame(int size, boolean aiFirst){ //true is the AI starting first, false is the human
		Board gameBoard = new Board(size);
		if(aiFirst){
			while(!gameBoard.checkForWin){
				gameBoard.printBoard();
				//INSERT AI COMMANDS
				promptForInput();
			}
		}
		else{
			while(!gameBoard.checkForWin){
				
		}
		}
	}*/
}
