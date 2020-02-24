package sample;

import java.util.Observable;

public class TicTacToeBoard extends Observable {

    private char[][] Board = new char[3][3];

    public TicTacToeBoard() {                       //init and sets board to ' '
        for (int i = 0; i < Board.length; i++) {
            for (int j = 0; j < Board.length; j++) {
                Board[i][j] = ' ';
            }
        }
    }

    public TicTacToeBoard(TicTacToeBoard oldTicTacToeBoard){ // Copy constructor clones board for minimax
        char[][] oldBoard;                                  //Create another char[][] to clone board to
        oldBoard = oldTicTacToeBoard.getBoard();            //assigns and gets board to oldboard
        for (int i = 0; i < Board.length; i++) {            //loops board length
            for (int j = 0; j < Board.length; j++) {
                Board[i][j] = oldBoard[i][j];
            }
        }
    }

    public char[][] getBoard() {
        return Board;
    } // gets and returns the Board

    public char getWinner() { //check rows cols diag compare chars
        // that are filled and return winners char that is stored in board.
        if(     Board[0][0] == 'X' && Board[1][0] == 'X' && Board[2][0] == 'X' ||//Checking rows
                Board[0][1] == 'X' && Board[1][1] == 'X' && Board[2][1] == 'X' ||//Checking rows
                Board[0][2] == 'X' && Board[1][2] == 'X' && Board[2][2] == 'X' ||//Checking rows
                Board[0][0] == 'X' && Board[0][1] == 'X' && Board[0][2] == 'X' ||//checking col
                Board[1][0] == 'X' && Board[1][1] == 'X' && Board[1][2] == 'X' ||//checking col
                Board[2][0] == 'X' && Board[2][1] == 'X' && Board[2][2] == 'X' ||//checking col
                Board[2][0] == 'X' && Board[1][1] == 'X' && Board[0][2] == 'X' ||//Checking diag
                Board[0][0] == 'X' && Board[1][1] == 'X' && Board[2][2] == 'X'){ //Checking diag
            return 'X';

        }else if (  Board[0][0] == 'O' && Board[1][0] == 'O' && Board[2][0] == 'O' ||//Checking rows
                Board[0][1] == 'O' && Board[1][1] == 'O' && Board[2][1] == 'O' ||//Checking rows
                Board[0][2] == 'O' && Board[1][2] == 'O' && Board[2][2] == 'O' ||//Checking rows
                Board[0][0] == 'O' && Board[0][1] == 'O' && Board[0][2] == 'O' ||//checking col
                Board[1][0] == 'O' && Board[1][1] == 'O' && Board[1][2] == 'O' ||//checking col
                Board[2][0] == 'O' && Board[2][1] == 'O' && Board[2][2] == 'O' ||//checking col
                Board[2][0] == 'O' && Board[1][1] == 'O' && Board[0][2] == 'O' ||//Checking diag
                Board[0][0] == 'O' && Board[1][1] == 'O' && Board[2][2] == 'O'){ //Checking diag
            return 'O';
        }else
            return ' ';

    }

    public boolean isOver() {
        if(getWinner() != ' ')
            return true;

        for(int x = 0; x < Board.length; x++){
            for(int y = 0; y < Board.length; y++){
                if(Board[x][y] == ' ')
                    return false;
            }
        }
        return true;
    }

    public void MoveMarked(int positionX, int positionY, char player) {  //Takes in posX posY and player
        Board[positionX][positionY] = player;                           // char (symbol X or O) to be placed on board.

    }

    public boolean isFree(int positionX, int positionY){
        return Board[positionX][positionY] == ' ';

    }

}
