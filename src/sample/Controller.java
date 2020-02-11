package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

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

    private boolean firstPlayer = true;

    public void onClicked(ActionEvent Event) {
        Button clickedButton = (Button) Event.getTarget();  //Stores the button being pressed
        String buttonLabel = clickedButton.getText();       //Stores the button's Text (which starts off blank)

        if ("".equals(buttonLabel) && firstPlayer){       //Checking if button Text is empty and if its player 1's turn
            clickedButton.setText("X");                   //Makes the empty buttons Text into an "X"
            firstPlayer = false;                          //Switches players turn
        }
        else if("".equals(buttonLabel) && !firstPlayer){  //Checking if button Text is empty and if its player 2's turn
            clickedButton.setText("O");                   //Makes the empty buttons Text into an "O"
            firstPlayer = true;                           //Switches players turn
        }
        checkWinner();
    }

    void checkWinner(){                   //TESTING OUT - We could check the winner like this (or find a better way)

        if(zeroZero.getText().equals(zeroOne.getText()) && zeroOne.getText().equals(zeroTwo.getText())){
            System.out.println("Row 1");
        }
        if(oneZero.getText().equals(oneOne.getText()) && oneOne.getText().equals(oneTwo.getText())){
            System.out.println("Row 2");
        }
        if(twoZero.getText().equals(twoOne.getText()) && twoOne.getText().equals(twoTwo.getText())){
            System.out.println("Row 3");
        }

        if(zeroZero.getText().equals(oneZero.getText()) && oneZero.getText().equals(twoZero.getText())){
            System.out.println("Col 1");
        }
        if(zeroZero.getText().equals(zeroOne.getText()) && zeroOne.getText().equals(zeroTwo.getText())){
            System.out.println("Col 2");
        }
        if(zeroZero.getText().equals(zeroOne.getText()) && zeroOne.getText().equals(zeroTwo.getText())){
            System.out.println("Col 3");
        }

    }

    public void resetClicked(ActionEvent startOver) {       //TESTING OUT need to Fix Reset button
        String testReset;
        Button newStartOverButton = (Button) startOver.getTarget();
        testReset = newStartOverButton.getText();
        System.out.println("Testing " + testReset + " Button");

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

}