public class Game
{
        public void promptForInput()
    {
        //Declare and initialize a scanner object called keyboard
        Scanner keyboard = new Scanner(System.in);
        String userEntry = "";
        while(! userEntry.equals("*"))
        {
            System.out.print("\f");
            System.out.print(userEntry);
            System.out.print("Enter Letter to Guess or * to exit : ");
            userEntry = keyboard.nextLine();
            //convert userEntry to be trimmed and all upper case
            userEntry = userEntry.trim().toUpperCase();
        }
        System.out.print("\nGood Bye!");
    }  
}
