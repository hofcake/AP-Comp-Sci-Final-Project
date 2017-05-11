public class Board
{
    public int[][] board;
    public final String alpha = "ABCDEFGHIJKLMNOPQRTUVWXYZ"; //possibly to be used later
    public void newBoard(int size){
    board = new int[size][size];
    }
    public void newMark(int x, int y, int type){board[board.length-y-1][x] = type;} //0 = nothing, 1 = x, 2 = O
    public void removeMark(int x, int y){board[board.length-y-1][x] = 0;}
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
            for(int j = 0; j < board[0].length; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println("|"+(board.length-1-i));
        }
        for(int i = 0; i < board[0].length; i++){
            System.out.print("- ");
        }
        System.out.println();
        for(int i = 0; i < board[0].length; i++){
            System.out.print(i + " ");
        }
        System.out.println("\n");
    }
}
