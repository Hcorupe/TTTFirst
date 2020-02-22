package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Observer;

public class Controller implements UIBoardObserver{

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
    Button zeroZero;
    @FXML
    Button zeroOne;
    @FXML
    Button zeroTwo;
    @FXML
    Button oneZero;
    @FXML
    Button oneOne;
    @FXML
    Button oneTwo;
    @FXML
    Button twoZero;
    @FXML
    Button twoOne;
    @FXML
    Button twoTwo;
    @FXML
    Button resetButton;
    @FXML
    Button playButton;
    @FXML
    MenuButton gameType;
    @FXML
    MenuItem playerVsPlayer;
    @FXML
    MenuItem playerVsAi;
    @FXML
    GridPane gridPane;

    private int currentPlayerTurn = 0;
    Human human;

    ArrayList<Observer> myobservers = new ArrayList<>();

    private boolean firstPlayer = true;

    public void onClicked(ActionEvent Event) {
        Button clickedButton = (Button) Event.getTarget();  //Stores the button being pressed
        String buttonLabel = clickedButton.getText();       //Stores the button's Text (which starts off blank)
        if ("".equals(buttonLabel) && firstPlayer){       //Checking if button Text is empty and if its player 1's turn
            clickedButton.setText("X");                   //Makes the empty buttons Text into an "X"
            firstPlayer = false;                          //Switches players turn
            int x = GridPane.getRowIndex(clickedButton);
            int y = GridPane.getColumnIndex(clickedButton);
            //board[x][y] = 1;
            System.out.println(" Row: " + x + " Col: " + y);
            //board.MoveMarked(x,y,'X');
        }

        else if("".equals(buttonLabel) && !firstPlayer){  //Checking if button Text is empty and if its player 2's turn
            clickedButton.setText("O");                   //Makes the empty buttons Text into an "O"
            firstPlayer = true;                           //Switches players turn
            int x = GridPane.getRowIndex(clickedButton);
            int y = GridPane.getColumnIndex(clickedButton);
            //board[x][y] = -1;
            System.out.println(" Row: " + x + " Col: " + y);
            //board.MoveMarked(x,y,'O');
        }
        //ticTacToeBoard.isOver();
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
        //if(newPlayButton.equals(playerVsPlayer))
            //controller.startGame();
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
    public void addObserver(Observer o) {
        this.myobservers.add(o);
    }

    @Override
    public void removeObserver() {

    }

    @Override
    public void update(Human human) {
        if(this.currentPlayerTurn == currentPlayerTurn){
            move();
            this.currentPlayerTurn++;
            notifyObserver();
        }
    }

    @Override
    public void notifyObserver() {
        for (Observer o : this.myobservers) {
            o.update(o);
        }
    }

    @Override
    public void move() {

    }
}