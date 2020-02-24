<<<<<<< HEAD
=======
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

    Button[][] buttons = new Button[3][3];
    ArrayList<UIBoardObserver> myobservers = new ArrayList<>();
    Boolean PvP = true;

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
    }

    public void reDrawBoard(TicTacToeBoard board){
        for(int x = 0; x <board.getBoard().length; x++ ){
            for(int y = 0; y < board.getBoard().length;y++){
                    buttons[x][y].setText(Character.toString(board.getBoard()[x][y]));
                    }
            }
        }

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


    public void resetClicked(ActionEvent Event) {       //TESTING OUT need to Fix Reset button
        ableButtons();
        start();
        resetStringInButtons();
    }

    public void playClicked(ActionEvent playGame) {       //TESTING OUT need to fix Play button
        ableButtons();
        start();
    }
    public void setPlayerVsPlayer(ActionEvent vsPlayer){
        resetStringInButtons();
        PvP = true;
        start();
    }

    public void setPlayerVsAi(ActionEvent vsAi){
        resetStringInButtons();
        PvP = false;
        start();
    }

    void ableButtons(){
        for(int x = 0; x <3; x++ ){
            for(int y = 0; y <3;y++){
                buttons[x][y].setDisable(false);
            }
        }
    }
    void disableButtons(){
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
>>>>>>> 02958e3cc04c8843042e01acf2179461daa4b0dc
