/**
 * This is a driver program for the TicTacToe game using the minimax algorithm
 * Project 2
 * @version 1.2
 * @author Rahul Mitra
 *
 * @see Scanner
 * @see util
 */

import java.util.Scanner;//IO class
import java.util.*;
public class TicTacToe{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        Board board = new Board();
        System.out.println();
        System.out.println("Welcome to TTT! Make your move(row-major order)");
        board.print();
        while (!board.gameOver()){//if the game is over, get out of the loop
            System.out.println();
            int choice = sc.nextInt();
            System.out.println();
            ArrayList<Integer> humanMove = board.humanTurn(choice);//converting the human's choice from index to a Move object
            Move humansMove = new Move(humanMove.get(0),humanMove.get(1));//make the human's index a Move object
            while ( !board.isSpotEmpty(humansMove) || choice < 1 || choice > 9){//making sure the human has moved to a valid spot on the board
                System.out.println();
                System.out.println("Please enter a valid move.");
                System.out.println("Enter your move here: ");
                System.out.println();
                choice = sc.nextInt();
                humanMove = board.humanTurn(choice);
                humansMove = new Move(humanMove.get(0),humanMove.get(1));

            }
            board.makeMove(humansMove, 'X');//make the human's move
            System.out.println("After your move, this is the new board: ");
            System.out.println();
            board.print();
            if ( board.gameOver()){
                break;
            }
               board.makeMove(board.MiniMaxDecision(0,'O'), 'O');//getting the move with the highest minimax score for the computer and making the move
               System.out.println("The machine has played. This is what the new board looks like: ");
               System.out.println();
               board.print();
         }//while 
        if ( board.AIWin()){
            System.out.println("You lost!");
            System.out.println();
        }
        else if ( board.humanWin()){//if this case is executed, my code is wrong
            System.out.println("You won!");//you should never win!
            System.out.println();
        }
        else{
            System.out.println("It's a draw!");
            System.out.println();
        }
        sc.close();
    }//main
   }//class
