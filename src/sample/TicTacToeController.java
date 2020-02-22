package sample;

import javafx.beans.Observable;

import java.util.*;

public class TicTacToeController implements GameObserver,PlayerBehavior {

    private PlayerBehavior[] players;
    private int currentPlayerTurn = 0;
    private TicTacToeBoard board;
    ArrayList<GameObserver> observers;

    public TicTacToeController(PlayerBehavior[] players) {
        board = new TicTacToeBoard();
        players[0] = new Human('X',board,currentPlayerTurn);
        players[1] = new AI('o',board,currentPlayerTurn);
        currentPlayerTurn = 0;
        observers = new ArrayList<>();

        players[0].addObserver(this);
        players[1].addObserver(this);
        //board.addObserver(this);
    }

    public void startGame(){
        players[currentPlayerTurn].move();
    }

    @Override
    public void update(PlayerBehavior o, Object arg) {
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


    @Override
    public void addObserver(Observer o) {
        this.observers.add((GameObserver) o);
    }

    @Override
    public void update() {
        if(this.currentPlayerTurn == currentPlayerTurn){
            move();
            this.currentPlayerTurn = currentPlayerTurn++;
            notifyObserver();
        }
    }

    @Override
    public void notifyObserver() {
        for (GameObserver o : this.observers) {
            o.update();
        }
    }

    @Override
    public void move() {
        players[currentPlayerTurn].move();
    }

    @Override
    public void removeObserver() {

    }

}






