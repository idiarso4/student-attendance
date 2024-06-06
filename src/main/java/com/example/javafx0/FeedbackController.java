package com.example.javafx0;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class FeedbackController {

    @FXML
    private TextArea feedbackText;

    @FXML
    private TableView<Feedback> feedbackTable;

    @FXML
    private TableColumn<Feedback, String> feedbackColumn;

    // Database connection parameters
    private final String url = "jdbc:mysql://localhost:3306/attendance";
    private final String user = "root";
    private final String password = "12345678";

    @FXML
    public void initialize() {
        feedbackColumn.setCellValueFactory(new PropertyValueFactory<>("feedbackText"));
    }

    @FXML
    public void submitFeedback() {
        String feedback = feedbackText.getText();

        String sql = "INSERT INTO feedback (feedback_text) VALUES (?)";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, feedback);
            pstmt.executeUpdate();
            System.out.println("Feedback submitted successfully!");

            feedbackText.clear(); // Clear the text area after submission

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @FXML
    public void loadFeedback() {
        ObservableList<Feedback> feedbackList = FXCollections.observableArrayList();

        String sql = "SELECT * FROM feedback";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                String feedbackText = rs.getString("feedback_text");

                Feedback feedback = new Feedback(feedbackText);
                feedbackList.add(feedback);
            }

            feedbackTable.setItems(feedbackList);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // Inner class to represent a feedback record
    public static class Feedback {
        private final String feedbackText;

        public Feedback(String feedbackText) {
            this.feedbackText = feedbackText;
        }

        public String getFeedbackText() {
            return feedbackText;
        }
    }

    @FXML
    private void goBack(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MainScreen.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
    }
}
