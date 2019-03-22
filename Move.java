/**
 * This is a class to handle Move objects
 *
 * Project 2
 *
 * @version 1.0
 * @author Rahul Mitra
 */
public class Move{
    //instance variables
    int rowIndex;//row index of move
    int colIndex;//column index of move
    int score;//to store the score associated with a move
    /**
     * Constructor of the Move class which initializes a Move object using only position on the board
     * @param rowI int row index of the move
     * @param colI int column index of the move
     * @return none
     */
    public Move(int rowI, int colI){
        this.rowIndex = rowI;
        this.colIndex = colI;
    }
    /**
     * Overrided constructor for the Move class which initializes a Move object using position
     * on the board as well as associated score
     * @param rowI int row index of the move
     * @param colI int column index of the move
     * @param score int score associated with the move
     * @return none
     */
    public Move(int rowI, int colI, int score){
        this.rowIndex = rowI;
        this.colIndex = colI;
        this.score = score;
    }//constructor 
}//class
