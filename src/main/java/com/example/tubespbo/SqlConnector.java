package com.example.tubespbo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SqlConnector {
    // Konfigurasi koneksi
    private static final String URL = "jdbc:mysql://localhost:3306/tubespbo"; // Nama database
    private static final String USER = "root"; // Sesuaikan dengan username MySQL
    private static final String PASSWORD = ""; // Sesuaikan dengan password MySQL (kosong jika tidak ada)

    // Metode untuk mendapatkan koneksi
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // Metode untuk menutup koneksi
    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                System.err.println("Gagal menutup koneksi: " + e.getMessage());
            }
        }
    }
}

