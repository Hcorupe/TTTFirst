package sample;

import java.util.Observer;

public interface GameObserver {
    void addObserver(Observer o);
    void update();
    void notifyObserver();
    void move();
}
