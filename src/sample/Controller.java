package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

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
    }
}