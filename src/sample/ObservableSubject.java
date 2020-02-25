package sample;

import javafx.beans.Observable;

public interface ObservableSubject {
    void addObserver(ObservableObserver o);
    void removeObserver(ObservableObserver o);
    void notifyObserver(int x,int y);
}
