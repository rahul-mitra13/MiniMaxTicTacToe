import java.util.*;
class Board{
    ArrayList<Move> emptySpots;
    char board[][];
    public Board(){
        board = new char[3][3];
        emptySpots = new ArrayList<Move>();
    }
    public boolean gameOver(){
        if ( humanWin() == true || AIWin() == true || this.emptySpots.size() == 0 ){
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
                if ( this.board[i][j] != 'X' && this.board[i][j] != 'O'){
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
    public void humanTurn(){
        Scanner sc = new Scanner(System.in);
        char human = 'X';
        int choice = sc.nextInt();
        int row = 0;
        int col = 0;
        switch(choice){
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
        Move thisMove = new Move(row,col);
        makeMove(thisMove, human);
        sc.close();
    }
    
}