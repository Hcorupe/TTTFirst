package sample;

import javafx.event.ActionEvent;
import javafx.event.Event;

import java.awt.*;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import javax.swing.*;

public class Controller {

    int controlLoop = 0;
    int turn = 0;
    @FXML
    Label label;
    @FXML
    Label label2;
    @FXML
    Label label3;
    @FXML
    Label label4;
    @FXML
    Label label5;
    @FXML
    Label label6;
    @FXML
    Label label7;
    @FXML
    Label label8;
    @FXML
    Label label9;



    public void onClicked(){
        turn = controlLoop % 2;
        if(turn == 0){
            System.out.println(controlLoop+"X");
            label.setPrefSize(200,200);
            label.setText("X");
        }
        else if(turn == 1){
            System.out.println(controlLoop+"O");
            label.setPrefSize(200,200);
            label.setText("O");
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
            label2.setPrefSize(200,200);
            label2.setText("X");
        }
        else if(turn == 1){
            System.out.println(controlLoop+"O");
            label2.setPrefSize(200,200);
            label2.setText("O");
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
            label3.setPrefSize(200,200);
            label3.setText("X");
        }
        else if(turn == 1){
            System.out.println(controlLoop+"O");
            label3.setPrefSize(200,200);
            label3.setText("O");
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
            label4.setPrefSize(200,200);
            label4.setText("X");
        }
        else if(turn == 1){
            System.out.println(controlLoop+"O");
            label4.setPrefSize(200,200);
            label4.setText("O");
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
            label5.setPrefSize(200,200);
            label5.setText("X");
        }
        else if(turn == 1){
            System.out.println(controlLoop+"O");
            label5.setPrefSize(200,200);
            label5.setText("O");
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
            label6.setPrefSize(200,200);
            label6.setText("X");
        }
        else if(turn == 1){
            System.out.println(controlLoop+"O");
            label6.setPrefSize(200,200);
            label6.setText("O");
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
            label7.setPrefSize(200,200);
            label7.setText("X");
        }
        else if(turn == 1){
            System.out.println(controlLoop+"O");
            label7.setPrefSize(200,200);
            label7.setText("O");
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
            label8.setPrefSize(200,200);
            label8.setText("X");
        }
        else if(turn == 1){
            System.out.println(controlLoop+"O");
            label8.setPrefSize(200,200);
            label8.setText("O");
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
            label9.setPrefSize(200,200);
            label9.setText("X");
        }
        else if(turn == 1){
            System.out.println(controlLoop+"O");
            label9.setPrefSize(200,200);
            label9.setText("O");
        }
        else{
            System.out.println(controlLoop+"SOMETHINGS WRONG");
        }

        controlLoop++;
    }


}
