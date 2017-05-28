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
        boolean full = gameBoard.checkMark(coords[0],coords[1]);
        coords = defense();
        full = gameBoard.checkMark(coords[0],coords[1]);
        if (coords[0] != -1 && full != false){
            return coords;
        }
        coords = offense();
        full = gameBoard.checkMark(coords[0],coords[1]);
        if (coords[0] != -1 && full != false){
            return coords;
        }
        while (full != true || coords[0] >= gameBoard.size() || coords[1] >= gameBoard.size())
        {
            coords[0] = (int) (Math.random() * gameBoard.size() - 1);
            coords[1] = (int) (Math.random() * gameBoard.size() - 1);
            full = gameBoard.checkMark(coords[0],coords[1]);
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
        coordinates = gameBoard.checkForAlmost(1);
        if (coordinates[0] != -1){
            coordinates = gameBoard.checkForAlmost(2);
            return coordinates;
        }
        coordinates[0] = -1;
        coordinates[1] = -1;
        return coordinates;
    }

}
