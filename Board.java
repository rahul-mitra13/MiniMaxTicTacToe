/**
 * Project 2
 * This is a Board class which is used to represent the TicTacToe Board 
 * @version 1.2
 * @author Rahul Mitra
 *
 * @see util
 *
 */
import java.util.*;
class Board{
    //instance variables
    ArrayList<Move> emptySpots;//to store the empty spots
    char board[][] = new char[3][3];//to store the board in a 2D array
    ArrayList<Move> childrenScores;//to store the scores of all the children of the root
    /**
     * Constructor for the Board class
     * @param none
     * @return none
     */
    public Board(){
        for ( int i = 0; i < 3; i++){
            for ( int j = 0; j < 3 ; j++){
                board[i][j] = '_';//set the board to all blanks
            }
        }
    }
    /**
     * Method to check if the game is over
     * @param none
     * @return boolean true if game won, false otherwise
     */
    public boolean gameOver(){
        if ( this.humanWin() == true || this.AIWin() == true || this.getEmptySpots().isEmpty()){
            return true;
        }
        else{
            return false;
        }
    }
    /**
     * Method to check if the human has won
     * @param none
     * @return boolean true if human has won, false otherwise
     */
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
    /**
     * Method to check if the AI has won
     * @param none
     * @return boolean true if AI has won, false otherwise
     */
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
    /**
     * Method to get all the empty spots on the board
     * @param none
     * @return emptySpots ArrayList<Move> list of all moves that can be made 
     */
    public ArrayList<Move> getEmptySpots(){
        emptySpots = new ArrayList<>();
        for ( int i = 0; i < 3 ; i++){
            for ( int j = 0 ; j < 3; j ++){
                if (this.board[i][j] == '_'){
                    Move spot = new Move(i, j);//creating a Move object with only the position on the board
                    this.emptySpots.add(spot);
                }
            }
        }
        return this.emptySpots;
    }
    /**
     * Method to place a move on the board
     * @param someMove Move object that is to be placed on the board
     * @param player char the player that is making the move
     * @return none
     */
    public void makeMove(Move someMove, char player){
        this.board[someMove.rowIndex][someMove.colIndex] = player;
    }
    /**
     * @param index int index of where the human wants to place a move
     * @return result ArrayList<Integer> list of two elements - the first being
     * the human move's row index and the second being the human move's column index
     */
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
                    System.out.println("Incorrect Input.");
        }
        result.add(row);
        result.add(col);
        return result;
    }
    /**
     * Method to make a move based on minimax scores
     * @param depth int depth of tree that's passed to the minimax method
     * @param player char player that's passed to the minimax method
     * @return bestMove Move object that returns the best move for the AI
     */
    public Move MiniMaxDecision(int depth, char player){
        childrenScores = new ArrayList<>();
        this.minimax(depth, player);
        Move bestMove = this.getBestFromChildren(childrenScores);//getting the best move
        return bestMove;
    }
    /**
     * Method that calculates the minimax scores
     * @param depth int depth of tree that's passed to the minimax method
     * @param player player that's passed to the minimax method
     * @return int minimax score at each node
     */
    public int minimax(int depth, char player){
        //terminal tests for this recursive function
        if (this.AIWin()){
            return 1;//assume AI win is a score of +1
        }
        if (this.humanWin()){
            return -1;//assume human win is a score of -1
        }
        if ( this.getEmptySpots().isEmpty()){
            return 0;//assume a draw is a score of 0
        }
        ArrayList<Move> allowedMoves = this.getEmptySpots();//getting all the allowed moves
        ArrayList<Integer> scores = new ArrayList<Integer>();//list of scores
        for ( int i = 0 ; i < allowedMoves.size(); i++){//iterating through all the moves
            Move currentMove = allowedMoves.get(i);//current move
            if ( player == 'O'){//computer's turn
                this.makeMove(currentMove, 'O');//make the move
                int currentScore = minimax(depth + 1, 'X');//recursively increase the depth
                scores.add(minimax(depth + 1, 'X'));
                    if ( depth == 0){
                    Move toAdd = new Move(currentMove.rowIndex, currentMove.colIndex, currentScore);//this will create a Move object with the overrided constructor
                    this.childrenScores.add(toAdd);
                     }
            }
            else if ( player == 'X'){//human's turn
                this.makeMove(currentMove, 'X');//again, make the move
                scores.add(minimax(depth + 1, 'O'));//recursively increase the depth
            }
            this.board[currentMove.rowIndex][currentMove.colIndex] = '_';//make the position empty again
        }

        if (player == 'O'){//get max if it's the computer's turn
            return getMax(scores);
        }
        else{//get min if it's the human's turn
            return getMin(scores);
        }
    }
    /**
     * Method to check if the spot that the player is trying to move to is empty or not
     * @param someMove Move object that's checked against all previous moves
     * @return boolean true if the spot on the board is empty, false otherwise
     */
    public boolean isSpotEmpty(Move someMove){
        if (this.board[someMove.rowIndex][someMove.colIndex] != '_'){
            return false;
        }
        else{
            return true;
        }

    }
    /**
     * Method to print the board in a clean manner
     * @param none
     * @return none
     */
    public void print(){
        System.out.println();
        for ( int i = 0; i < 3; i++){
            for ( int j = 0 ; j < 3; j++){
                System.out.print(this.board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    
    //following are three helper functions to help in the implementation of minimax
    
    /**
     * Method to get the minimum element from an integer list
     * @param list ArrayList<Integer> list from which minimum element is to be found
     * @return int minimum element from list
     */
    public int getMin(ArrayList<Integer> list){
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
    /**
     * Method to get the maximum element from an integer list
     * @param list ArrayList<Integer> list from which maximum element is to be found
     * @return int maximum element from list
     */
    public int getMax(ArrayList<Integer> list){
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
    /**
     * Method to get the move with the highest score from all of the children nodes of the root node
     * @param none
     * @return Move object that represents the child of the root with the higest score
     */
    public Move getBestFromChildren(ArrayList<Move> list){
        int max = Integer.MIN_VALUE;
        int index = 0;
        for ( int i = 0; i < list.size(); i++){
            if ( list.get(i).score > max){
                max = list.get(i).score;
                index = i;
            }
        }
        return list.get(index);
    }//method
}//class
