package sample;

import java.util.List;
import java.util.ArrayList;

public abstract class Player implements ObservableObserver, ObservableSubject {

    protected String symbol;
    protected Board board;
    protected List<ObservableObserver> observers = new ArrayList<>();


    public Player(String symbol, Board board) {
        this.board = board;
        this.symbol = symbol;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public abstract void move();

    @Override
    public void addOberserver(ObservableObserver o) {
        observers.add(o);
    }
    @Override
    public void removeObserver(ObservableObserver o) {

    }
    @Override
    public void notifyOberserver(int x, int y) {
        for (ObservableObserver o : this.observers) {
            o.update(x, y);
        }
    }

    @Override
    public void update(int x, int y) {
        if(board.isFree(x, y)){
            board.MoveMarked(x, y, symbol);
            this.notifyObserver(x, y);
        }
    }
}
