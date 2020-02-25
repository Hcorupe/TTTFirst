package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.GridPane;
import org.w3c.dom.events.EventException;

import java.net.URL;
import java.util.List;
import java.util.ArrayList;

import java.util.Observer;
import java.util.ResourceBundle;

public class Controller implements ObservableSubject, Initializable {

    /*              GAME BOARD
     *              |       |
     *      zeroZero|zeroOne|zeroTwo
     *      ________|_______|_______
     *              |       |
     *      oneZero |oneOne | oneTwo
     *      ________|_______|_______
     *              |       |
     *      twoZero |twoOne | twoTwo
     *              |       |
     */

    @FXML
    Button zeroZero,zeroOne,zeroTwo,oneZero,oneOne,oneTwo,twoZero,twoOne,twoTwo;
    @FXML
    Button resetButton, playButton;
    @FXML
    MenuButton gameType;
    @FXML
    MenuItem playerVsPlayer, playerVsAi;

    Board board = new Board();
    Button[][] buttons = new Button[3][3];
    Player player1 = new User("X", board);
    Player player2 = new AI("O", board);
    List<ObservableObserver> observers = new ArrayList<>();

    char token;     //Either x or o's turn
    int posX;
    int posY;

    public void onClicked(ActionEvent Event) {
        Button clickedButton = (Button) Event.getTarget();
        String buttonSymbol = clickedButton.getText();
        if (buttonSymbol.equals("")){
            clickedButton.setText(player1.getSymbol());
        }
        player2.move();
    }


    public void resetClicked(ActionEvent startOver) {       //TESTING OUT need to Fix Reset button
        zeroZero.setText("");
        zeroOne.setText("");
        zeroTwo.setText("");
        oneZero.setText("");
        oneOne.setText("");
        oneTwo.setText("");
        twoZero.setText("");
        twoOne.setText("");
        twoTwo.setText("");
    }

    public void playClicked(ActionEvent playGame) {       //TESTING OUT need to fix Play button
        String testPlay;
        Button newPlayButton = (Button) playGame.getTarget();
        testPlay = newPlayButton.getText();
        System.out.println("Testing " + testPlay + " Button");
    }

    public void setPlayerVsPlayer(ActionEvent vsPlayer){
        String testVsPlayer;
        MenuItem newVsPlayerButton = (MenuItem) vsPlayer.getTarget();
        testVsPlayer = newVsPlayerButton.getText();
        System.out.println("Testing " + testVsPlayer + " Button");
        gameType.setText(testVsPlayer);
    }

    public void setPlayerVsAi(ActionEvent vsAi){
        String testVsAi;
        MenuItem newVsAiButton = (MenuItem) vsAi.getTarget();
        testVsAi = newVsAiButton.getText();
        System.out.println("Testing " + testVsAi + " Button");
        gameType.setText(testVsAi);
    }

    @Override
    public void addObserver(ObservableObserver o) {
        this.observers.add(o);
    }

    @Override
    public void removeObserver(ObservableObserver o) {

    }

    @Override
    public void notifyObserver(int x, int y) {
        for (ObservableObserver o : this.observers) {
            o.update(x, y);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        buttons[0][0] = zeroZero;
        buttons[0][1] = zeroOne;
        buttons[0][2] = zeroTwo;
        buttons[1][0] = oneZero;
        buttons[1][1] = oneOne;
        buttons[1][2] = oneTwo;
        buttons[2][0] = twoZero;
        buttons[2][1] = twoOne;
        buttons[2][2] = twoTwo;
    }
}