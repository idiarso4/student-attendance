package com.example.javafx0;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
//        FXMLLoader: This is a utility class provided by JavaFX to load FXML files. FXML files describe the user interface of the JavaFX application using XML.

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("MainScreen.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 400, 300);
        stage.setTitle("Attendance System");
        stage.setScene(scene);
        stage.show();

//        fxmlLoader.load(): This method loads the FXML file and returns the root node of the scene graph defined in the FXML file. Essentially, it parses the MainScreen.fxml file and constructs the UI components described within it.
    }

    public static void main(String[] args) {
        launch();
    }
}
