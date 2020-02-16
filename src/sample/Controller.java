package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.GridPane;
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
    GridPane gridPane;

    public int[][] board = new int[3][3];

    private boolean firstPlayer = true;

    public void onClicked(ActionEvent Event) {
        Button clickedButton = (Button) Event.getTarget();  //Stores the button being pressed
        String buttonLabel = clickedButton.getText();       //Stores the button's Text (which starts off blank)
        if ("".equals(buttonLabel) && firstPlayer){       //Checking if button Text is empty and if its player 1's turn
            clickedButton.setText("X");                   //Makes the empty buttons Text into an "X"
            firstPlayer = false;                          //Switches players turn
            int x = GridPane.getRowIndex(clickedButton);
            int y = GridPane.getColumnIndex(clickedButton);
            board[x][y] = 1;
            System.out.println(" Row: " + x + " Col: " + y);
        }

        else if("".equals(buttonLabel) && !firstPlayer){  //Checking if button Text is empty and if its player 2's turn
            clickedButton.setText("O");                   //Makes the empty buttons Text into an "O"
            firstPlayer = true;                           //Switches players turn
            int x = GridPane.getRowIndex(clickedButton);
            int y = GridPane.getColumnIndex(clickedButton);
            board[x][y] = -1;
            System.out.println(" Row: " + x + " Col: " + y);
        }
        checkWinner();
    }

    void checkWinner(){                   //TESTING OUT - We could check the winner like this (or find a better way)



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

}