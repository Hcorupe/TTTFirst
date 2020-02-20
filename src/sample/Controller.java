package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.GridPane;
import org.w3c.dom.events.EventException;

import java.util.Observer;

public class Controller {

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

    TicTacToeController control = new TicTacToeController();
    TicTacToeBoard game = new TicTacToeBoard();
    private boolean firstPlayer = true;

    char token;     //Either x or o's turn
    int posX;
    int posY;

    public void onClicked(ActionEvent Event) {
        Button clickedButton = (Button) Event.getTarget();  //Stores the button being pressed
        String buttonLabel = clickedButton.getText();       //Stores the button's Text (which starts off blank)
        if ("".equals(buttonLabel) && firstPlayer){       //Checking if button Text is empty and if its player 1's turn
            clickedButton.setText("X");                   //Makes the empty buttons Text into an "X"
            firstPlayer = false;                          //Switches players turn
            int x = GridPane.getRowIndex(clickedButton);
            int y = GridPane.getColumnIndex(clickedButton);
            System.out.println(" Row: " + x + " Col: " + y);
        }

        else if("".equals(buttonLabel) && !firstPlayer){  //Checking if button Text is empty and if its player 2's turn
            clickedButton.setText("O");                   //Makes the empty buttons Text into an "O"
            firstPlayer = true;                           //Switches players turn
            int x = GridPane.getRowIndex(clickedButton);
            int y = GridPane.getColumnIndex(clickedButton);
            System.out.println(" Row: " + x + " Col: " + y);
        }
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
        PlayerBehavior[] players = new PlayerBehavior[2];
        String testVsPlayer;
        MenuItem newVsPlayerButton = (MenuItem) vsPlayer.getTarget();
        testVsPlayer = newVsPlayerButton.getText();
        System.out.println("Testing " + testVsPlayer + " Button");
        gameType.setText(testVsPlayer);
        control.playerVsPlayer(players);
    }
    public void setPlayerVsAi(ActionEvent vsAi){
        PlayerBehavior[] players = new PlayerBehavior[2];
        String testVsAi;
        MenuItem newVsAiButton = (MenuItem) vsAi.getTarget();
        testVsAi = newVsAiButton.getText();
        System.out.println("Testing " + testVsAi + " Button");
        gameType.setText(testVsAi);
        control.playerVsAI(players);
    }

}