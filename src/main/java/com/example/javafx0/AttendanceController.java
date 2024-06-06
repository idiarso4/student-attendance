package com.example.javafx0;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AttendanceController {

    @FXML
    private TextField nameField;

    @FXML
    private TextField idField;

    @FXML
    private TextField dateField;

    @FXML
    private TableView<AttendanceRecord> attendanceTable;

    @FXML
    private TableColumn<AttendanceRecord, String> nameColumn;

    @FXML
    private TableColumn<AttendanceRecord, String> idColumn;

    @FXML
    private TableColumn<AttendanceRecord, String> dateColumn;

    @FXML
    private TableColumn<AttendanceRecord, String> statusColumn;


    private final String url = "jdbc:mysql://localhost:3306/attendance";
    private final String user = "root";
    private final String password = "12345678";

    @FXML
    public void initialize() {
        // Initialize the TableView columns
        nameColumn.setCellValueFactory(new   PropertyValueFactory<>("studentName"));
        idColumn.setCellValueFactory(new     PropertyValueFactory<>("studentId"));
        dateColumn.setCellValueFactory(new   PropertyValueFactory<>("date"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));
    }

    public void markPresent(ActionEvent event) {
        markAttendance("Present");
    }

    public void markAbsent(ActionEvent event) {
        markAttendance("Absent");
    }

    private void markAttendance(String status) {
        String studentName = nameField.getText();
        String studentId = idField.getText();
        String date = dateField.getText();

        String sql = "INSERT INTO attendance_records (student_id, date, student_name, status) " +
                "VALUES (?, ?, ?, ?) " +
                "ON DUPLICATE KEY UPDATE status = VALUES(status), student_name = VALUES(student_name)";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, studentId);
            pstmt.setString(2, date);
            pstmt.setString(3, studentName);
            pstmt.setString(4, status);

            pstmt.executeUpdate();
            System.out.println("Attendance marked successfully!");

            // Optionally, update the TableView here if needed
            loadData();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @FXML
    public void loadData() {
        ObservableList<AttendanceRecord> attendanceRecords = FXCollections.observableArrayList();

        String sql = "SELECT * FROM attendance_records";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs            = pstmt.executeQuery()) {

            while (rs.next()) {
                String studentName = rs.getString("student_name");
                String studentId   = rs.getString("student_id");
                String date        = rs.getString("date");
                String status      = rs.getString("status");

                AttendanceRecord record = new AttendanceRecord(studentName, studentId, date, status);
                attendanceRecords.add(record);
            }

            attendanceTable.setItems(attendanceRecords);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // Inner class to represent an attendance record
    public static class AttendanceRecord {
        private final String studentName;
        private final String studentId;
        private final String date;
        private final String status;

        public AttendanceRecord(String studentName, String studentId, String date, String status) {
            this.studentName = studentName;
            this.studentId   = studentId;
            this.date        = date;
            this.status      = status;
        }

        public String getStudentName() {
            return studentName;
        }

        public String getStudentId() {
            return studentId;
        }

        public String getDate() {
            return date;
        }

        public String getStatus() {
            return status;
        }
    }
}
