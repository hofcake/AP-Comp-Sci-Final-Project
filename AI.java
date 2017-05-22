public class AI
{
    Board gameBoard;
    public AI (Board gb)
    {
        gameBoard = gb;
    }

    public int[] play(){
        int[] coords = new int[2];
        if (defense() != 0){
            coords = defense();
        }
        else if (offense() != 0){
            coords = offense();
        }
        else{
            coords[0] = 2;
            coords[1] = 1;
        }
        return coords;
    }

    public int[] defense(){
        int[] coordinates = new int[2];
        if (gameBoard.checkForAlmost(1) != 0){
            int[] coordinates = gameBoard.checkForAlmost(1);
            return coordinates;
        }
        coordinates[0] = -1;
        coordinates[1] = -1;
        return coordinates;
    }

    public int[] offense(){
        int[] coordinates = new int[2];
        if (gameBoard.checkForAlmost(2) != 0){
            int coordinates = gameBoard.checkForAlmost(2);
            return coordinates;
        }
        coordinates[0] = -1;
        coordinates[1] = -1;
        return coordinates;
    }

}
