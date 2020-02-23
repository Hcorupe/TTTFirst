package sample;

import javafx.application.Application;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    private static Controller controller;

    public static void controller (Controller c){
        controller = c;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Tic-Tac-Toe");
        primaryStage.setScene(new Scene(root, 600, 400));
        root.getStylesheets().add("test.css");
        //root.getStylesheets().add(getClass().getResource("test.css").toExternalForm());
        primaryStage.show();
        TicTacToeController gamecontroller = new TicTacToeController(controller);
        gamecontroller.startGame(); // can be put in JavaFX controller

    }

    public static void main(String[] args) {
        launch(args);


    }
}






