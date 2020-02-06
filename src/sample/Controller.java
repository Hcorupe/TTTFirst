package sample;

import javafx.event.ActionEvent;
import javafx.event.Event;

import java.awt.*;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import javax.swing.*;

public class Controller {

    int controlLoop = 0; //Adds 1 number per Button Click.. 0 % 2 = 0 -> (X) , 1 % 2 = 1 -> (O), 2 % 2 = 0 -> (X)
    // 3 % 2 = 1 -> (O), etc....
    int turn = 0;        //Determines who's turn it is by using control loop. (X or O)

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
    Label zeroZero;
    @FXML
    Label zeroOne;
    @FXML
    Label zeroTwo;
    @FXML
    Label oneZero;
    @FXML
    Label oneOne;
    @FXML
    Label OneTwo;
    @FXML
    Label twoZero;
    @FXML
    Label twoOne;
    @FXML
    Label twoTwo;

    public void onClicked(){
        turn = controlLoop % 2;
        if(turn == 0){
            System.out.println(controlLoop+"X");
            zeroZero.setPrefSize(200,200);
            zeroZero.setText("X");
        }
        else if(turn == 1){
            System.out.println(controlLoop+"O");
            zeroZero.setPrefSize(200,200);
            zeroZero.setText("O");
        }
        else{
            System.out.println(controlLoop+"SOMETHINGS WRONG");
        }

        controlLoop++;
    }
    public void onClicked2(){
        turn = controlLoop % 2;
        if(turn == 0){
            System.out.println(controlLoop+"X");
            zeroOne.setPrefSize(200,200);
            zeroOne.setText("X");
        }
        else if(turn == 1){
            System.out.println(controlLoop+"O");
            zeroOne.setPrefSize(200,200);
            zeroOne.setText("O");
        }
        else{
            System.out.println(controlLoop+"SOMETHINGS WRONG");
        }

        controlLoop++;
    }
    public void onClicked3(){
        turn = controlLoop % 2;
        if(turn == 0){
            System.out.println(controlLoop+"X");
            zeroTwo.setPrefSize(200,200);
            zeroTwo.setText("X");
        }
        else if(turn == 1){
            System.out.println(controlLoop+"O");
            zeroTwo.setPrefSize(200,200);
            zeroTwo.setText("O");
        }
        else{
            System.out.println(controlLoop+"SOMETHINGS WRONG");
        }

        controlLoop++;
    }
    public void onClicked4(){
        turn = controlLoop % 2;
        if(turn == 0){
            System.out.println(controlLoop+"X");
            oneZero.setPrefSize(200,200);
            oneZero.setText("X");
        }
        else if(turn == 1){
            System.out.println(controlLoop+"O");
            oneZero.setPrefSize(200,200);
            oneZero.setText("O");
        }
        else{
            System.out.println(controlLoop+"SOMETHINGS WRONG");
        }

        controlLoop++;
    }
    public void onClicked5(){
        turn = controlLoop % 2;
        if(turn == 0){
            System.out.println(controlLoop+"X");
            oneOne.setPrefSize(200,200);
            oneOne.setText("X");
        }
        else if(turn == 1){
            System.out.println(controlLoop+"O");
            oneOne.setPrefSize(200,200);
            oneOne.setText("O");
        }
        else{
            System.out.println(controlLoop+"SOMETHINGS WRONG");
        }

        controlLoop++;
    }
    public void onClicked6(){
        turn = controlLoop % 2;
        if(turn == 0){
            System.out.println(controlLoop+"X");
            OneTwo.setPrefSize(200,200);
            OneTwo.setText("X");
        }
        else if(turn == 1){
            System.out.println(controlLoop+"O");
            OneTwo.setPrefSize(200,200);
            OneTwo.setText("O");
        }
        else{
            System.out.println(controlLoop+"SOMETHINGS WRONG");
        }

        controlLoop++;
    }
    public void onClicked7(){
        turn = controlLoop % 2;
        if(turn == 0){
            System.out.println(controlLoop+"X");
            twoZero.setPrefSize(200,200);
            twoZero.setText("X");
        }
        else if(turn == 1){
            System.out.println(controlLoop+"O");
            twoZero.setPrefSize(200,200);
            twoZero.setText("O");
        }
        else{
            System.out.println(controlLoop+"SOMETHINGS WRONG");
        }

        controlLoop++;
    }
    public void onClicked8(){
        turn = controlLoop % 2;
        if(turn == 0){
            System.out.println(controlLoop+"X");
            twoOne.setPrefSize(200,200);
            twoOne.setText("X");
        }
        else if(turn == 1){
            System.out.println(controlLoop+"O");
            twoOne.setPrefSize(200,200);
            twoOne.setText("O");
        }
        else{
            System.out.println(controlLoop+"SOMETHINGS WRONG");
        }

        controlLoop++;
    }
    public void onClicked9(){
        turn = controlLoop % 2;
        if(turn == 0){
            System.out.println(controlLoop+"X");
            twoTwo.setPrefSize(200,200);
            twoTwo.setText("X");
        }
        else if(turn == 1){
            System.out.println(controlLoop+"O");
            twoTwo.setPrefSize(200,200);
            twoTwo.setText("O");
        }
        else{
            System.out.println(controlLoop+"SOMETHINGS WRONG");
        }

        controlLoop++;
    }


}