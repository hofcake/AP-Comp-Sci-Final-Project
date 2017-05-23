public class Board
{
    public int[][] board;
    public final String alpha = "ABCDEFGHIJKLMNOPQRTUVWXYZ"; //possibly to be used later
    public void newBoard(int size){
        board = new int[size][size];
    }

    public void newMark(int x, int y, int type){board[board.length-y-1][x] = type;} //0 = nothing, 1 = x, 2 = O
    
    public void removeMark(int x, int y){board[board.length-y-1][x] = 0;}

    public void newArrayMark(int[] input, int type){board[board.length-input[1]-1][input[0]] = type;}

    public void clear(){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                board[i][j] = 0;
            }
        }
    }

    public int size(){
        return board.length;	
    }

    public boolean checkMark(int x, int y){
        if(board[y][x] == 0)
            return true;
        return false;
    }

    public void printBoard(){
        System.out.print("\f");
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

    public boolean checkHorizontal(int sign){
        boolean win = true;
        for(int i = 0; i < board.length; i++){
            win = true;
            for(int j = 0; j < board[0].length; j++){
                if((board[i][j] == sign)&&(win))
                    win = true;
                else
                    win = false;
            }
        }
        return win;
    }

    public boolean checkVertical(int sign){
        boolean win = true;
        for(int i = 0; i < board.length; i++){
            win = true;
            for(int j = 0; j < board[0].length; j++){
                if((board[j][i] == sign)&&(win))
                    win = true;
                else
                    win = false;
            }
        }
        return win;
    }

    public boolean checkDiagonal(int sign){
        boolean win = true;
        int index = 0;
        while(index < board.length){
            if(board[index][index] != sign)
                win = false;
            index++;
        }
        if(win == true)
            return true;
        index = board.length-1;
        while(index >= 0){
            if(board[index][board[0].length-1-index] != sign)
                win = false;
            index--;
        }
        return win;
    }

    public boolean checkForWin(int sign){return(checkDiagonal(sign) || checkVertical(sign) || checkHorizontal(sign));}

    public boolean isFull(){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == 0)
                    return false;
            }
        }
        return true;
    }

    public int getWinner(){
        if(checkForWin(1))
            return 1;
        else if(checkForWin(2))
            return 2;
        else
            return 0;
    }

    public boolean isWinner(){
        if(checkForWin(1))
            return true;
        else if(checkForWin(2))
            return true;
        else
            return false;
    }

    public int[] checkHorizontalAlmost(int sign){
        int[] almost = new int[2];
        int row = 0;
        int column = 0;
        for(int j = 0; j < board[0].length; j++){
            if((board[1][j] == sign))
                row = 1;
            column = j;
            almost[0] = row;
            almost[1] = column;
            return almost;
        }
        for(int j = 0; j < board[0].length; j++){
            if((board[board.length - 2][j] == sign)){
                row = board.length - 2;
                column = j;
                almost[0] = row;
                almost[1] = column;
                return almost;
            }
        }
        almost[0] = -1;
        almost[1] = -1;
        return almost;
    }

    public int[] checkVerticalAlmost(int sign){
        int[] almost = new int[2];
        int row = 0;
        int column = 0;
        for(int i = 0; i < board[0].length; i++){
            if((board[i][1] == sign)){
                row = i;
                column = 1;
                almost[0] = row;
                almost[1] = column;
                return almost;
            }
        }
        for(int i = 0; i < board[0].length; i++){
            if((board[i][board.length - 2] == sign)){
                row = i;
                column = board.length - 2;
                almost[0] = row;
                almost[1] = column;
                return almost;
            }
        }
        almost[0] = -1;
        almost[1] = -1;
        return almost;
    }

    public int[] checkForAlmost(int sign){
        int[] test1 = checkVerticalAlmost(sign);
        if (test1[0] != -1){
            return checkVerticalAlmost(sign);}
        else{
            return checkHorizontalAlmost(sign);}
    }

}
