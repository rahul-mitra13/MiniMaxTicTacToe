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
        board.print();
        System.out.println("Welcome to TTT! Make your move(row-major order)");
        while (!board.gameOver()){
            System.out.println();
            int choice = sc.nextInt();
            ArrayList<Integer> humanMove = board.humanTurn(choice);//converting the human's choice from index to a Move object
            Move humansMove = new Move(humanMove.get(0),humanMove.get(1));
            while ( !board.isSpotEmpty(humansMove)){//making sure the human has moved to valid spot on the board 
                System.out.println();
                System.out.println("Please choose a spot that's not occupied.");
                System.out.println("Enter your move here: ");
                choice = sc.nextInt();
                humanMove = board.humanTurn(choice);
                humansMove = new Move(humanMove.get(0),humanMove.get(1));
                
            }
            board.makeMove(humansMove, 'X');
            board.print();
            if ( board.gameOver()){
                break;
            }
               board.invokeMiniMax(0, 'O');//calling the minimax method 
               board.makeMove(board.getBestMove(), 'O');//getting the move with the highest score from all of the children of the root node
               board.print();
         }
        if ( board.AIWin()){
            System.out.println("You lost!");
        }
        else if ( board.humanWin()){//if this happens I've made a mistake in my implementation of minimax
            System.out.println("You won!");
        }
        else{
            System.out.println("It's a draw!");
        }
        sc.close();
    }
   }
