package sample;

import java.util.Observable;
//subject
interface PlayerBehavior {

    void addObserver(GameObserver O);
    void removeObserver();
    void notifyObserver();
    void move();
    char getSymbol();
}

/*

abstract class PlayerBehavior {

    protected char symbol;
    protected TicTacToeBoard board;


    public PlayerBehavior(char symbol, TicTacToeBoard board) {
        this.board = board;
        this.symbol = symbol;

    }

    public char getSymbol() {
        return this.symbol;
    }

    public abstract void move();

}


 */