package sample;

import static java.lang.Integer.max;
import static java.lang.Integer.min;

public class AI extends Player {

    Board TicTacToeBoard;
    String otherplayer;


    public AI(String symbol, Board board) {

        super(symbol, board);
        if (this.symbol == "X") {
            this.otherplayer = "O";

        } else
            this.otherplayer = "X";
        }

    @Override
    public void move() {

        int moveX = -1;
        int moveY = -1;
        int curmax = -10000;
        int val = -10000;

        for (int x = 0; x < 2; x++) {
            for (int y = 0; y < 2; y++) {
                if (board.isFree(x, y)) {
                    TicTacToeBoard newBoard = new TicTacToeBoard(board);
                    val = minimax(newBoard, 100, true);
                    if (val > curmax) {
                        curmax = val;
                        moveX = x;
                        moveY = y;
                    }
                }
            }
        }
        this.notifyOberserver(moveX, moveY);
    }


    private int minimax(Board ticTacToeBoard, int depth, Boolean maximizingPlayer) {
        int maxEval;
        int minEval;

        if (depth == 0 || board.gameOver()){
            return board.changeStringtoInt(super.getSymbol()) * board.getWinner() * depth;
        }

        if (maximizingPlayer) {
            maxEval = -10000;
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    if (board.isFree(i, j)) {
                        Board newBoard = new Board(board);
                        newBoard.MoveMarked(i, j, this.symbol);
                        maxEval = max(maxEval, minimax(board, depth - 1, false));

                    }
                }
            }
            return maxEval;
        }
        else {
            minEval = 10000;
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    if (board.isFree(i, j)) {
                        Board newBoard = new Board(board);
                        newBoard.MoveMarked(i, j, this.otherplayer);
                        minEval = min(minEval, minimax(board, depth - 1, false));
                    }

                }
            }
            return minEval;
        }
    }
}