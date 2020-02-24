package sample;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
<<<<<<< HEAD
=======

public class Human implements UIBoardObserver,PlayerBehavior{
//Sending updates to TicTacToeController
    //getting updates from Controller

    char symbol;
    TicTacToeBoard board;
    boolean isMyMove;

    ArrayList<GameObserver> observers = new ArrayList<>();

    public Human(char symbol,TicTacToeBoard board,Controller controller){
        this.symbol = symbol;
        this.board = board;
        controller.addObserver(this);
    }

    public char getSymbol() {
        return this.symbol;
    }

    @Override
    public void update(int x, int y) {
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
>>>>>>> 02958e3cc04c8843042e01acf2179461daa4b0dc
