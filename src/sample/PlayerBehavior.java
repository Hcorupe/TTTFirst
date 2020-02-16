package sample;


import java.util.Observable;

abstract class PlayerBehavior extends Observable {

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
