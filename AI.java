public class AI
{
    Board gameBoard;
    public AI (Board gb)
    {
        gameBoard = gb;
    }

    public int[] play(){
        int[] test = new int[2];
        int[] coords = new int[2];
        test = defense();
        if (test[0] != -1){
            coords = defense();
            return coords;
        }
        test = offense();
        if (test[1] != -1){
            coords = offense();
            return coords;
        }
        coords[0] = 2;
        coords[1] = 1;
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
        coordinates = gameBoard.checkForAlmost(1);
        if (coordinates[0] != -1){
            int coordinates = gameBoard.checkForAlmost(2);
            return coordinates;
        }
        coordinates[0] = -1;
        coordinates[1] = -1;
        return coordinates;
    }

}
