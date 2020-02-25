package sample;

import java.util.*;

public class TicTacToeController implements GameObserver {

    private PlayerBehavior[] players = new PlayerBehavior[2];
    private int currentPlayerTurn = 0;
    private TicTacToeBoard board;
    ArrayList<GameObserver> observers;
    Controller controller;
    char whoWon;
    int wins;
    int loss;
    int draws;

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
    public TicTacToeController(Controller controller) {
        this.board = new TicTacToeBoard();
        this.controller = controller;
        players[0] = new Human('X',this.board,controller);
        players[1] = new Human('O',this.board,controller);
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
        processPlayerUpdate();
        controller.reDrawBoard(board);
    }

    private void processPlayerUpdate() {
        if(!board.isOver()){
            this.currentPlayerTurn = (this.currentPlayerTurn + 1) % 2;
            players[this.currentPlayerTurn].move();
        }
        else {
                whoWon = board.getWinner();
            if (players[0].getSymbol() == whoWon) {
                System.out.println("WINNER IS: " + whoWon);

                wins++;
            } else if (players[1].getSymbol() == whoWon) {

                System.out.println("WINNER IS: " + whoWon);
                loss++;
            } else {
                System.out.println("IT's a TIE!");
                draws++;
            }
            //this.controller.handleFinishedGame();
            controller.disableButtons();
            controller.displayWinner(wins,loss,draws,whoWon);
        }
    }
}