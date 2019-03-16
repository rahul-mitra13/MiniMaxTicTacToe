import java.util.*;
class Board{
    ArrayList<Move> emptySpots  = new ArrayList<Move>();
    char board[][] = new char[3][3];
    public Board(){
        for ( int i = 0; i < 3; i++){
            for ( int j = 0; j < 3 ; j++){
                board[i][j] = '_';
            }
        }
    }
    public boolean gameOver(){
        if ( humanWin() == true || AIWin() == true || getEmptySpots().isEmpty()){
            return true;
        }
        else{
            return false;
        }
    }
    public boolean humanWin(){
        if ( this.board[0][0] == 'X' && this.board[0][1] == 'X' && this.board[0][2] == 'X'){//top row
            return true;
        }
        else if (this.board[1][0] == 'X' && this.board[1][1] == 'X' && this.board[1][2] == 'X'){//second row
            return true;
        }
        else if (this.board[2][0] == 'X' && this.board[2][1] == 'X' && this.board[2][2] == 'X'){//third row
            return true;
        }
        else if (this.board[0][0] == 'X' && this.board[1][0] == 'X' && this.board[2][0] == 'X'){//first column
            return true;
        }
        else if (this.board[0][1] == 'X' && this.board[1][1] == 'X' && this.board[2][1] == 'X'){//second column
            return true;
        }
        else if (this.board[0][2] == 'X' && this.board[1][2] == 'X' && this.board[2][2] == 'X'){//third column
            return true;
        }
        else if (this.board[0][0] == 'X' && this.board[1][1] == 'X' && this.board[2][2] == 'X'){//main diagonal
            return true;
        }
        else if (this.board[0][2] == 'X' && this.board[1][1] == 'X' && this.board[2][0] == 'X'){//reverse diagonal
            return true;
        }
        else{
            return false;
        }
    }
    public boolean AIWin(){
        if (this.board[0][0] == 'O' && this.board[0][1] == 'O' && this.board[0][2] == 'O'){//top row
            return true;
        }
        else if (this.board[1][0] == 'O' && this.board[1][1] == 'O' && this.board[1][2] == 'O'){//second row
            return true;
        }
        else if (this.board[2][0] == 'O' && this.board[2][1] == 'O' && this.board[2][2] == 'O'){//third row
            return true;
        }
        else if (this.board[0][0] == 'O' && this.board[1][0] == 'O' && this.board[2][0] == 'O'){//first column
            return true;
        }
        else if (this.board[0][1] == 'O' && this.board[1][1] == 'O' && this.board[2][1] == 'O'){//second column
            return true;
        }
        else if (this.board[0][2] == 'O' && this.board[1][2] == 'O' && this.board[2][2] == 'O'){//third column
            return true;
        }
        else if (this.board[0][0] == 'O' && this.board[1][1] == 'O' && this.board[2][2] == 'O'){//main diagonal
            return true;
        }
        else if (this.board[0][2] == 'O' && this.board[1][1] == 'O' && this.board[2][0] == 'O'){//reverse diagonal
            return true;
        }
        else{
            return false;
        }
    }
    public ArrayList<Move> getEmptySpots(){
        for ( int i = 0; i < 3 ; i++){
            for ( int j = 0 ; j < 3; j ++){
                if ( this.board[i][j] == '_'){
                    Move spot = new Move(i, j);
                    emptySpots.add(spot);
                }
            }
        }
        return emptySpots;
    }
    public void makeMove(Move someMove, char player){
        board[someMove.rowIndex][someMove.colIndex] = player;
    }
    public ArrayList<Integer> humanTurn(int index){
        ArrayList<Integer> result = new ArrayList<Integer>();
        int row = 0;
        int col = 0;
        switch(index){
            case 1: 
                    row = 0;
                    col = 0;
                    break;
            case 2: 
                    row = 0;
                    col = 1;
                    break;
            case 3: 
                    row = 0;
                    col = 2;
                    break;
            case 4:
                    row = 1;
                    col = 0;
                    break;
            case 5: 
                    row = 1;
                    col = 1;
                    break;
            case 6: 
                    row = 1;
                    col = 2;
                    break;
            case 7: 
                    row = 2;
                    col = 0;
                    break;
            case 8: 
                    row = 2;
                    col = 1;
                    break;
            case 9: 
                    row = 2;
                    col = 2;
                    break;
            default:
                    System.out.println("Please enter a number between 1 and 9.");
        }
        result.add(row);
        result.add(col);
        return result;
    }
    //got to implement returnsBestMove() here
    public Move getBestMove(){
        int max = Integer.MIN_VALUE;
        int best = 0;
        for ( int i = 0; i < childrenScores.size(); i++){
            if ( childrenScores.get(i).score > max){
                max = childrenScores.get(i).score;
                best = i;
            }
        }
        return childrenScores.get(best).someMove;
    }
    public void print(){
        for ( int i = 0; i < 3; i++){
            for ( int j = 0 ; j < 3; j++){
                System.out.print(this.board[i][j] + " ");
            }
            System.out.println();
        }
    }
    public int getMinFromList(ArrayList<Integer> list){
        int min = Integer.MAX_VALUE;
        int index = 0;
        for ( int i = 0; i < list.size(); i++){
            if ( list.get(i) < min){
                min = list.get(i);
                index = i;
            }
        }
        return list.get(index);
    }
    public int getMaxFromList(ArrayList<Integer> list){
        int max = Integer.MIN_VALUE;
        int index = 0;
        for ( int i = 0; i < list.size(); i++){
            if ( list.get(i) > max){
                max = list.get(i);
                index = i;
            }
        }
        return list.get(index);
    }
    ArrayList<Score> childrenScores;
    public void invokeMiniMax(int depth, char player){
        childrenScores = new ArrayList<>();
        minimax(depth, player);
    }
    public int minimax(int depth, char player){
        if (humanWin()){
            return -1;
        }
        if (AIWin()){
            return 1;
        }
        ArrayList<Move> allowedMoves = getEmptySpots();
        if (allowedMoves.isEmpty()){
            return 0;
        }
        ArrayList<Integer> scores = new ArrayList<Integer>();
        for ( int i = 0 ; i < allowedMoves.size(); i++){
            Move currentMove = allowedMoves.get(i);
            if ( player == 'O'){
                makeMove(currentMove, 'O');
                int currentScore = minimax(depth + 1, 'X');
                scores.add(currentScore);
                if ( depth == 0){
                    Score currScore = new Score(currentScore, currentMove);
                    childrenScores.add(currScore);
                }
            }
            else if ( player == 'X'){
                makeMove(currentMove, 'X');
                scores.add(minimax(depth + 1, 'O'));
            }
            board[currentMove.rowIndex][currentMove.colIndex] = '_';
        }
        return player == 'O' ? getMaxFromList(scores): getMinFromList(scores);
    }
}
    