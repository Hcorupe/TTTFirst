package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

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
    Button zeroZero,zeroOne,zeroTwo,oneZero,oneOne,oneTwo,twoZero,twoOne,twoTwo;
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
    Label winnerBox;

    TicTacToeBoard board;
    Button[][] buttons = new Button[3][3];
    ArrayList<UIBoardObserver> myobservers = new ArrayList<>();
    Boolean PvP = true;
    int won,loss,draw;

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
        int x = GridPane.getRowIndex(clickedButton);        //Gets UI Input of X
        int y = GridPane.getColumnIndex(clickedButton);     //Gets UI Input of Y
        this.notifyObserver(x,y);                           //Notifies the Observer
    }

    public void reDrawBoard(TicTacToeBoard board){
        for(int x = 0; x <board.getBoard().length; x++ ){
            for(int y = 0; y < board.getBoard().length;y++){
                    buttons[x][y].setText(Character.toString(board.getBoard()[x][y]));
                    System.out.println("Re draw called "  + board.getBoard()[x][y]);
                    }
            }
        }

//start - starts the game and checks whether the user chose Player vs Player or Vs AI
    public void  start(){
        if(PvP){
            TicTacToeController gamecontroller = new TicTacToeController(this);
            gamecontroller.startGame(); // can be put in JavaFX controller
            gameType.setText("Player vs Player");
        }
        else{
            TicTacToeController gamecontroller = new TicTacToeController(this,true);
            gamecontroller.startGame(); // can be put in JavaFX controller
            gameType.setText("Player vs AI");
        }
    }

    public void resetClicked() {
        disableButtons();
        resetStringInButtons();
    }

    public void playClicked() {
        resetClicked();
        ableButtons();
        start();
    }
    public void setPlayerVsPlayer(){
        disableButtons();
        resetStringInButtons();
        PvP = true;
    }

    public void setPlayerVsAi(){
        disableButtons();
        resetStringInButtons();
        PvP = false;
    }

    void ableButtons(){             //Enables UI Buttons
        for(int x = 0; x <3; x++ ){
            for(int y = 0; y <3;y++){
                buttons[x][y].setDisable(false);
            }
        }
    }
    void disableButtons(){      //Disables UI Buttons
        for(int x = 0; x <3; x++ ){
            for(int y = 0; y <3;y++){
                buttons[x][y].setDisable(true);
            }
        }
    }
    void resetStringInButtons(){
        for(int x = 0; x <3; x++ ){
            for(int y = 0; y <3;y++){
                buttons[x][y].setText("");
            }
        }
    }

    public void handleFinishedGame() {
        Alert alertBox = new Alert(Alert.AlertType.CONFIRMATION, "Game OutCome", ButtonType.OK, ButtonType.CANCEL);
        alertBox.setContentText("The OutCome is " );
        alertBox.showAndWait();
        if(alertBox.getResult() == ButtonType.OK) {
            alertBox.close();
        }
        else {
            alertBox.close();
        }
    }

    void displayWinner(int win, int lose, int tie,char token){
        won += win;
        loss += lose;
        draw += tie;
        winnerBox.setText("Won: " + won + " Loss: " + loss + " Draws: " + draw);
    }

    @Override
    public void addObserver(UIBoardObserver o) {
        this.myobservers.add(o);
    }
    @Override
    public void removeObserver() {

    }
    @Override
    public void notifyObserver(int x, int y) {
        for (UIBoardObserver o : this.myobservers) {
            o.update(x,y);
        }
    }


}