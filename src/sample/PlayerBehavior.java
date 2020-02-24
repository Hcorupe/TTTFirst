package sample;

interface PlayerBehavior {

    void addObserver(GameObserver O);
    void removeObserver();
    void notifyObserver();
    void move();
    char getSymbol();
}
