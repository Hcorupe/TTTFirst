package sample;
<<<<<<< HEAD
=======

import java.util.ArrayList;
import java.util.Observer;

import static java.lang.Integer.max;
import static java.lang.Integer.min;

public class AI implements PlayerBehavior {

    char otherplayer;
    char symbol;
    TicTacToeBoard board;
    ArrayList<GameObserver> observer = new ArrayList<>();

    public AI(char symbol, TicTacToeBoard board ) {

        this.symbol = symbol;
        this.board = board;
        //super(symbol, board);
        if (this.symbol == 'X') {
            this.otherplayer = 'O';

        } else
            this.otherplayer = 'X';
        }

    public char getSymbol() {
        return this.symbol;
    }

    @Override
    public void addObserver(GameObserver O) {
        this.observer.add(O);
    }

    @Override
    public void removeObserver() {

    }

    @Override
    public void notifyObserver() {
        for (GameObserver O : this.observer) {
            O.update();
        }
    }

    @Override
    public void move() {
        int moveX = -1;
        int moveY = -1;
        int curmax = -10001;
        int val = -10000;

        for (int x = 0; x <= 2; x++) {
            for (int y = 0; y <= 2; y++) {
                if (board.isFree(x, y)) {
                    TicTacToeBoard newBoard = new TicTacToeBoard(board);
                    newBoard.MoveMarked(x, y, this.symbol);
                    val = minimax(newBoard, 100, false);
                    if (val > curmax) {
                        curmax = val;
                        moveX = x;
                        moveY = y;
                    }
                }
            }
        }
        board.MoveMarked(moveX, moveY, this.symbol);
        this.notifyObserver();
    }

    private int minimax(TicTacToeBoard ticTacToeBoard, int depth, Boolean maximizingPlayer) {
        int maxEval;
        int minEval;

        if (depth == 0 || ticTacToeBoard.isOver())
            if (ticTacToeBoard.getWinner() == this.symbol)
                return 10000;
            else if (ticTacToeBoard.getWinner() == this.otherplayer)
                return -10000;
            else return 0;

        if (maximizingPlayer) {
            maxEval = -10000;
            for (int i = 0; i <= 2; i++) {
                for (int j = 0; j <= 2; j++) {
                    if (ticTacToeBoard.isFree(i, j)) {
                        TicTacToeBoard newBoard = new TicTacToeBoard(ticTacToeBoard);  //clone
                        newBoard.MoveMarked(i, j, this.symbol);
                        maxEval = max(maxEval, minimax(newBoard, depth - 1, false));
                    }
                }
            }
            return maxEval;

        } else {
            minEval = 10000;
            for (int i = 0; i <= 2; i++) {
                for (int j = 0; j <= 2; j++) {
                    if (ticTacToeBoard.isFree(i, j)) {
                        TicTacToeBoard newBoard = new TicTacToeBoard(ticTacToeBoard);
                        newBoard.MoveMarked(i, j, this.otherplayer);
                        minEval = min(minEval, minimax(newBoard, depth - 1, true));
                    }
                }
            }
            return minEval;
        }
    }
>>>>>>> 02958e3cc04c8843042e01acf2179461daa4b0dc
}