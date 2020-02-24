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
