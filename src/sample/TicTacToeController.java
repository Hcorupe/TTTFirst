package sample;

import javafx.beans.Observable;

import java.util.*;

public class TicTacToeController implements GameObserver {

    private PlayerBehavior[] players = new PlayerBehavior[2];
    private int currentPlayerTurn = 0;
    private TicTacToeBoard board;
    ArrayList<GameObserver> observers;
    Controller controller;
    boolean Checkplayer;

    public TicTacToeController(Controller controller,boolean Checkplayer) {
        this.board = new TicTacToeBoard();
        this.controller = controller;
        players[0] = new Human('X',this.board,controller);
        players[1] = new AI('O',this.board);
        currentPlayerTurn = 0;
        observers = new ArrayList<>();
        players[0].addObserver(this);
        players[1].addObserver(this);
    }

    public void startGame(){
        players[currentPlayerTurn].move();
    }

    @Override
    public void update() {
        System.out.println("Update getting called");
        processPlayerUpdate();
        controller.reDrawBoard(board);
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
        if(!board.isOver()){
            processBoardUpdate();
            this.currentPlayerTurn = (this.currentPlayerTurn + 1) % 2;
            players[this.currentPlayerTurn].move();
        }

    }

}






