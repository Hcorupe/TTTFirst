package sample;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class Human implements UIBoardObserver,PlayerBehavior{
//Sending updates to TicTacToeController
    //getting updates from Controller
    int moveX;
    int moveY;
    char symbol;
    Controller controller;
    TicTacToeBoard board;
    int currentPlayerTurn;
    boolean isMyMove;

    ArrayList<GameObserver> observers = new ArrayList<>();

    public Human(char symbol,TicTacToeBoard board,Controller controller){
        this.symbol = symbol;
        this.board = board;
        this.currentPlayerTurn = currentPlayerTurn;
        controller.addObserver(this);
    }

    public char getSymbol() {
        return this.symbol;
    }

    @Override
    public void update(int x, int y) {
        System.out.println("Human Update call");
        if(isMyMove && board.isFree(x,y)){
            board.MoveMarked(x,y,symbol);
            isMyMove = false;
            this.notifyObserver();
        }
    }

    @Override
    public void addObserver(GameObserver O) {
        observers.add(O);
    }

    @Override
    public void removeObserver() {

    }

    @Override
    public void notifyObserver() {
        for (GameObserver O : this.observers) {
            O.update();
        }
    }

    public void move(){
        isMyMove = true;
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