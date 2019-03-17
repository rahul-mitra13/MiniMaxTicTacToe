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
            ArrayList<Integer> humanMove = board.humanTurn(choice);
            Move humansMove = new Move(humanMove.get(0),humanMove.get(1));
            while ( !board.isMoveEmpty(humansMove)){
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
               board.invokeMiniMax(0, 'O');
               board.makeMove(board.getBestMove(), 'O');
               board.print();
         }
        if ( board.AIWin()){
            System.out.println("You lost!");
        }
        else if ( board.humanWin()){//lol never going to happen
            System.out.println("You won!");
        }
        else{
            System.out.println("It's a draw!");
        }
        sc.close();
    }
   }
