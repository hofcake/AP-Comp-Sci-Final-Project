public class Board
{
    public int[][] board;
    public static void newBoard(int size){
        int[][] board = new int[size][size];
    }
    public void newMark(int x, int y, int type){board[y][x] = type;} //0 = nothing, 1 = x, 2 = O
    public void removeMark(int x, int y){board[y][x] = 0;}
    public void clear(){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                board[i][j] = 0;
            }
        }
    }
    public int checkMark(int x, int y){return board[y][x];}
    public void printBoard(){
		for(int i = 0; i < board.length; i++){
			for(int 
    }
}
