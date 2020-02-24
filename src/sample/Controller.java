package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.*;

public class Controller implements UIBoardSubject, Initializable {

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

    Button[][] buttons = new Button[3][3];
    PlayerBehavior[][] players = new PlayerBehavior[2][2];
    TicTacToeController controller;
    TicTacToeBoard board;
    private int currentPlayerTurn = 0;
    Human human;
    ArrayList<UIBoardObserver> myobservers = new ArrayList<>();
    private boolean firstPlayer = true;

    public void initialize(URL location, ResourceBundle resources){
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

    public void onClicked(ActionEvent Event) {
        Button clickedButton = (Button) Event.getTarget();  //Stores the button being pressed
        int x = GridPane.getRowIndex(clickedButton);
        int y = GridPane.getColumnIndex(clickedButton);
        this.notifyObserver(x,y);
        System.out.println(" Row: " + x + " Col: " + y);

    }

    public void reDrawBoard(TicTacToeBoard board){
        System.out.println("Redraw is getting called ");
        for(int x = 0; x <board.getBoard().length; x++ ){
            for(int y = 0; y < board.getBoard().length;y++){
                    buttons[x][y].setText(Character.toString(board.getBoard()[x][y]));
                        System.out.println("If statement is true ");

                    }
            }
        }

        public void  start(){
            TicTacToeController gamecontroller = new TicTacToeController(this,true);
            gamecontroller.startGame(); // can be put in JavaFX controller
        }


    public void resetClicked(ActionEvent Event) {       //TESTING OUT need to Fix Reset button

        Button clickedButton = (Button) Event.getTarget();  //Stores the button being pressed
        start();
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

        TicTacToeController gamecontroller = new TicTacToeController(this,true);
        gamecontroller.startGame(); // can be put in JavaFX controller

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
    public void addObserver(UIBoardObserver o) {
        System.out.println("Add observer Controller");
        this.myobservers.add(o);
    }

    @Override
    public void removeObserver() {

    }


    @Override
    public void notifyObserver(int x, int y) {
        for (UIBoardObserver o : this.myobservers) {
            System.out.println("Notify obsever" + o);
            o.update(x,y);
        }
    }

}