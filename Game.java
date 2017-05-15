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
            userEntry = userEntry.trim().toUpperCase();//convert userEntry to be trimmed and all upper case
        }
        System.out.print("\nGood Bye!");
    }  
}
