package com.example.javafx0;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class TeacherLoginController {

    @FXML
    private TextField teacherIdField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private void handleLogin() {
        String username = teacherIdField.getText();
        String password = passwordField.getText();
        boolean isValid = DatabaseUtil.verifyTeacherCredentials(username, password);
//        to verify the credentials


        if (isValid) {
            try {
                handleLoginSuccess();
            } catch (IOException e) {
                e.printStackTrace();
                showAlert("Error", "Failed to load attendance screen.");
            }
        } else {
            showAlert("Login Failed", "Invalid username or password.");
        }
    }

    private void handleLoginSuccess() throws IOException {
        Stage stage = (Stage) teacherIdField.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AttendanceSystem.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setScene(scene);
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @FXML
    private void goBack(ActionEvent event) throws IOException {
        Stage stage           = (Stage) ((Button) event.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MainScreen.fxml"));
        Scene scene           = new Scene(fxmlLoader.load());
        stage.setScene(scene);
    }



}
