package com.example.tubespbo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseUtils {

    // Konfigurasi koneksi
    private static final String URL = "jdbc:mysql://localhost:3306/tubespbo";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    // Metode untuk mendapatkan koneksi
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // Method untuk mendapatkan data pengguna berdasarkan NIM
    public static ResultSet getUserById(int id) throws SQLException {
        Connection connection = getConnection();
        String query = "SELECT * FROM user WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, id);
        return preparedStatement.executeQuery();
    }


    // Method untuk menutup koneksi
    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


}
