/**
 * This is a driver program for the TicTacToe game using the miimax algorithm
 * Project 2
 * @version 1.2
 * @author Rahul Mitra
 *
 * @see Scanner
 * @see util
 */
import java.util.Scanner;
import java.util.*;
public class TicTacToe{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        Board board = new Board();
        System.out.println();
        System.out.println("Welcome to TTT! Make your move(row-major order)");
        board.print();
        while (!board.gameOver()){
            System.out.println();
            int choice = sc.nextInt();
            System.out.println();
            ArrayList<Integer> humanMove = board.humanTurn(choice);//converting the human's choice from index to a Move object
            Move humansMove = new Move(humanMove.get(0),humanMove.get(1));
            while ( !board.isSpotEmpty(humansMove)){//making sure the human has moved to valid spot on the board
                System.out.println();
                System.out.println("Please choose a spot that's not occupied.");
                System.out.println("Enter your move here: ");
                System.out.println();
                choice = sc.nextInt();
                humanMove = board.humanTurn(choice);
                humansMove = new Move(humanMove.get(0),humanMove.get(1));

            }
            board.makeMove(humansMove, 'X');
            System.out.println("After your move, this is the new board: ");
            System.out.println();
            board.print();
            if ( board.gameOver()){
                break;
            }
               board.makeMove(board.invokeMiniMax(0,'O'), 'O');//getting the move with the highest score
               System.out.println("The machine has played. This is what the new board looks like: ");
               System.out.println();
               board.print();
         }
        if ( board.AIWin()){
            System.out.println("You lost!");
        }
        else if ( board.humanWin()){//if this case is executed, I've made a mistake in my implementation of minimax
            System.out.println("You won!");
        }
        else{
            System.out.println("It's a draw!");
        }
        sc.close();
    }
   }
