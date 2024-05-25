package com.example.tubespbo;

import java.sql.*;

public class DatabaseUtils {

    // Konfigurasi koneksi
    private static final String URL = "jdbc:mysql://localhost:3306/tubespbo"; // Nama database
    private static final String USER = "root"; // Sesuaikan dengan username MySQL
    private static final String PASSWORD = ""; // Sesuaikan dengan password MySQL (kosong jika tidak ada)

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
