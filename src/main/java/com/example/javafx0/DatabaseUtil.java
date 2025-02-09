package com.example.javafx0;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseUtil {

    private static final String URL = "jdbc:postgresql://localhost:5432/attendance";
    private static final String USER = "postgres";
    private static final String PASSWORD = "root"; // Ganti dengan password PostgreSQL yang benar

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new SQLException("PostgreSQL JDBC Driver not found", e);
        }
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static boolean verifyTeacherCredentials(String teacherId, String password) {
        String sql = "SELECT * FROM teacher WHERE username = ? AND password = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, teacherId);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();

            return rs.next(); // returns true if a match is found

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Tambahkan di bawah method verifyTeacherCredentials

// Fungsi untuk menambah absensi
public static boolean markAttendance(String studentName, String studentId, String date, String status) {
    String sql = "INSERT INTO student_attendance (student_name, student_id, date, status) VALUES (?, ?, ?::date, ?)";
    try (Connection conn = getConnection();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {
        
        pstmt.setString(1, studentName);
        pstmt.setString(2, studentId);
        pstmt.setString(3, date);
        pstmt.setString(4, status);
        
        int rowsAffected = pstmt.executeUpdate();
        return rowsAffected > 0;
        
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}

// Fungsi untuk mengambil semua data absensi
public static ResultSet getAllAttendance() {
    String sql = "SELECT * FROM student_attendance ORDER BY date DESC";
    try {
        Connection conn = getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        return pstmt.executeQuery();
    } catch (SQLException e) {
        e.printStackTrace();
        return null;
    }
}

// Fungsi untuk mengupdate status absensi
public static boolean updateAttendance(int id, String status) {
    String sql = "UPDATE student_attendance SET status = ? WHERE id = ?";
    try (Connection conn = getConnection();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {
        
        pstmt.setString(1, status);
        pstmt.setInt(2, id);
        
        int rowsAffected = pstmt.executeUpdate();
        return rowsAffected > 0;
        
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}

// Fungsi untuk menghapus data absensi
public static boolean deleteAttendance(int id) {
    String sql = "DELETE FROM student_attendance WHERE id = ?";
    try (Connection conn = getConnection();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {
        
        pstmt.setInt(1, id);
        
        int rowsAffected = pstmt.executeUpdate();
        return rowsAffected > 0;
        
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}



}

