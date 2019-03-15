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

    }