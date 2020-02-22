package sample;
import java.util.Observable;
import java.util.Observer;


public class Human implements UIBoardObserver{

    int moveX;
    int moveY;
    char symbol;
    Controller controller;
    TicTacToeBoard board;
    int currentPlayerTurn;

    public Human(char symbol,TicTacToeBoard board,int currentPlayerTurn){
        this.symbol = symbol;
        this.board = board;
        this.currentPlayerTurn = currentPlayerTurn;
    }


    @Override
    public void addObserver(Observer o) {

    }

    @Override
    public void removeObserver() {

    }

    @Override
    public void update(Human human) {

    }

    @Override
    public void notifyObserver() {

    }

    @Override
    public void move() {

    }
}

/*

public class Human extends PlayerBehavior {
    int moveX;
    int moveY;
    Controller controller;


    public Human(char symbol, TicTacToeBoard board) {
        super(symbol, board);
    }

    @Override
    public void move() {
        board.MoveMarked(moveX, moveY, this.symbol);
    }





}
*/