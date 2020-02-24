package sample;

import javafx.application.Application;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Tic-Tac-Toe");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.setMaxHeight(400);
        primaryStage.setMaxWidth(600);
        primaryStage.setMinHeight(400);
        primaryStage.setMinWidth(600);
        root.getStylesheets().add("test.css");
        //root.getStylesheets().add(getClass().getResource("test.css").toExternalForm());
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}






