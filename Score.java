/**
 * This is a class to handle Move objects and their respective scores
 * 
 * Project 2
 * 
 * @version 1.0
 * @author Rahul Mitra 
 */
public class Score{
    int score;//to store the score
    Move someMove;//to store the move
    /**
     * Constructor of the Score class
     * @param s int score of the Move object
     * @param m Move Move object
     * @return none
     */
    public Score(int s, Move m){
        this.score = s;
        this.someMove = m;
    }
}