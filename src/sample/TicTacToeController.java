package sample;

import java.util.Observable;
import java.util.Observer;

public class TicTacToeController implements Observer {

    private PlayerBehavior[] players;
    private int currentPlayerTurn = 0;
    private TicTacToeBoard board;

    public TicTacToeController(PlayerBehavior[] players) {
        board = new TicTacToeBoard();
        players[0] = new Human('X',board);
        players[1] = new AI('o',board);
        currentPlayerTurn = 0;

        players[0].addObserver(this);
        players[1].addObserver(this);
        board.addObserver(this);
    }

    public TicTacToeController() {

    }

    public void playerVsPlayer(PlayerBehavior[] players){
        board = new TicTacToeBoard();
        players[0] = new Human('X',board);
        players[1] = new Human('o',board);
        currentPlayerTurn = 0;

        players[0].addObserver(this);
        players[1].addObserver(this);
        board.addObserver(this);

    }
    public void playerVsAI(PlayerBehavior[] players){
        board = new TicTacToeBoard();
        players[0] = new Human('X',board);
        players[1] = new AI('o',board);
        currentPlayerTurn = 0;

        players[0].addObserver(this);
        players[1].addObserver(this);
        board.addObserver(this);
    }

    public void startGame(){
        players[currentPlayerTurn].move();
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o == board) {
            processBoardUpdate();
        } else { processPlayerUpdate();
        }
    }

    private void processBoardUpdate() {
        if (board.isOver()) {
            char winner = board.getWinner();
            if (players[0].getSymbol() == winner) {

            } else if (players[1].getSymbol() == winner) {

            } else {
                //draw
            }
        }
    }

    private void processPlayerUpdate() {
        this.currentPlayerTurn = (this.currentPlayerTurn + 1) % 2;
        players[this.currentPlayerTurn].move();
    }
}






