package sample;

public interface UIBoardSubject {
    void addObserver(UIBoardObserver o);
    void removeObserver();
    void notifyObserver(int x,int y);

}
