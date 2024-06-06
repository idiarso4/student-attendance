package com.example.javafx0;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {

    @FXML
    private Button teacherLoginButton; // Reference to the button, add this

//    @FXML
//    private void showLoginScreen() throws IOException {
//        Stage stage           = (Stage) teacherLoginButton.getScene().getWindow();
//        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AttendanceSystem.fxml"));
//        Scene scene           = new Scene(fxmlLoader.load(), 600, 400);
//        stage.setScene(scene);
//    }



    @FXML
    private void showTeacherLoginScreen() throws IOException {
        Stage stage = (Stage) teacherLoginButton.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("TeacherLoginScreen.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 400, 300);
        stage.setScene(scene);
    }


    @FXML
    private void showFeedbackScreen() throws IOException {
        Stage stage = (Stage) teacherLoginButton.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FeedbackScreen.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 400, 300);
        stage.setScene(scene);
    }


//    // This method should be called after a successful login
//    @FXML
//    public void handleLoginSuccess() throws IOException {
//        Stage stage = (Stage) teacherLoginButton.getScene().getWindow();
//        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AttendanceSystem.fxml"));
//        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
//        stage.setScene(scene);
//    }


}
