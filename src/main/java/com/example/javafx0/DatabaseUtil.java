package com.example.javafx0;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseUtil {

    private static final String URL = "jdbc:mysql://localhost:3306/attendance";
    private static final String USER = "root";
    private static final String PASSWORD = "12345678";

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new SQLException("MySQL JDBC Driver not found", e);
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
}

