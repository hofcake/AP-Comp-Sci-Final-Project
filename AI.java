public class AI
{
    Board gameBoard;
    public AI (Board gb)
    {
        gameBoard = gb;
    }

    public int[] play(){
        int[] coords = new int[2];
        if (gameBoard.isFull()){
        	coords[0] = -1;
        	coords[1] = -1;
        	return coords;
        }
        coords = offense();
        if (coords[0] != -1 && gameBoard.checkMarkAI(coords[0],coords[1])){
            return coords;
        }
        coords = defense();
        if (coords[0] != -1 && gameBoard.checkMarkAI(coords[0],coords[1])){
            return coords;
        }
        coords[0] = (int) (Math.random() * (gameBoard.size() - 1));
        coords[1] = (int) (Math.random() * (gameBoard.size() - 1));
        while ((!gameBoard.checkMarkAI(coords[0],coords[1]) || coords[0] >= gameBoard.size() || coords[1] >= gameBoard.size()))
        {
            coords[0] = (int) (Math.random() * (gameBoard.size() - 1));
            coords[1] = (int) (Math.random() * (gameBoard.size() - 1));
        }
        return coords;
    }

    public int[] defense(){
        int[] coordinates = new int[2];
        coordinates = gameBoard.checkForAlmost(1);
        if (coordinates[0] != -1){
            coordinates = gameBoard.checkForAlmost(1);
            return coordinates;
        }
        coordinates[0] = -1;
        coordinates[1] = -1;
        return coordinates;
    }

    public int[] offense(){
        int[] coordinates = new int[2];
        coordinates = gameBoard.checkForAlmost(2);
        if (coordinates[0] != -1){
            coordinates = gameBoard.checkForAlmost(2);
            return coordinates;
        }
        coordinates[0] = -1;
        coordinates[1] = -1;
        return coordinates;
    }
}
