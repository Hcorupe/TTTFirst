package sample;

import java.util.Observable;
import java.util.Observer;

public class TicTacToeBoard extends Observable {

    private int positionX;
    private int positionY;
    private int piece;
    private boolean isWinner;
    private boolean isOver;
    //private PlayerBehavior[][] Board;
    private char[][] Board;

    public TicTacToeBoard() {

        for (int i = 0; i < Board.length; i++) {
            for (int j = 0; j < Board.length; j++) {
                Board[i][j] = ' ';
            }
        }
    }

    public TicTacToeBoard(TicTacToeBoard oldTicTacToeBoard){ // clones board for minimax
        char[][] oldBoard;
        oldBoard = oldTicTacToeBoard.getBoard();
        for (int i = 0; i < Board.length; i++) {
            for (int j = 0; j < Board.length; j++) {
                Board[i][j] = oldBoard[i][j];
            }
        }
    }

    public char[][] getBoard() {
        return Board;
    }

    public int getPositionY() {
        return positionY;
    }

    public char getWinner() {
        for (int i = 0; i < Board.length; i++) {
            //check rows cols diag compare chars that are filled and return winners char that is stored in board.
        }
        return ' ';
    }

    public boolean isOver() {


        //call getwinner if(!getwinner == ' ')
        // check if any avaliable moves !null
        //if (!getWinner() == ' ') {
            //avaliable moves method
        // /*

        return false;

    }

    public void MoveMarked(int positionX, int positionY, char player) {
        Board[positionX][positionY] = player;

    }
    public void addObserver() {
    }

    public boolean isFree(int positionX, int positionY){
        return Board[positionX][positionY] == ' ';

    }

}

