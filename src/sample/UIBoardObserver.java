package sample;

import java.util.Observer;

public interface UIBoardObserver {
    void addObserver(Observer o);
    void removeObserver();
    void update(Human human);
    void notifyObserver();
    void move();
}
