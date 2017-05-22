public class AI
{
    Board gameBoard;
    public AI (Board gb)
    {
        gameBoard = gb;
    }

    public int[] play(){
        int[] coords = new int[2];
        int[] coordsArray = new int[2];
        if (defense() != 0){
            coords = defense();
        }
        else if (offense() != 0){
            coords = offense();
        }
        else{
            coords = 23;
        }
        coordsArray = makeCoordArray(coords);
        return coordsArray;
    }

    public int[] defense(){
        if (gameBoard.checkForAlmost(1) != 0){
            int[] coordinates = gameBoard.checkForAlmost(1);
            return coordinates;
        }
        else{
            return 0;}
    }

    public int offense(){
        if (gameBoard.checkForAlmost(2) != 0){
            int coordinates = gameBoard.checkForAlmost(2);
            return coordinates;
        }
        else{
            return 0;}
    }

    public int[] makeCoordArray(int coordinates){
        int[] coordinateArray = new int[2];
        coordinateArray[0] = coordinates.substring(0,1);
        coordinateArray[1] = coordinates.substring(1,2);
        return coordinateArray;
    }
}
