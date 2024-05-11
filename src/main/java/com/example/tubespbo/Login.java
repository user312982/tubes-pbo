package com.example.tubespbo;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;


public class Login  {
    @FXML
    private Button button;
    @FXML
    private Label wrongLogin;
    @FXML
    private TextField nim;
    @FXML
    private PasswordField password;

    private String storedNim;
    private String storedPassword;

    @FXML
    private void initialize() {
        // Menambahkan listener ke TextField untuk mendeteksi perubahan teks
        nim.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                // Menjalankan aksi ketika teks berubah
                databaseConnection(); // Panggil metode untuk mengupdate data
            }
        });

        password.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                // Menjalankan aksi ketika teks berubah
                databaseConnection(); // Panggil metode untuk mengupdate data
            }
        });

        button.setOnAction(this::handleButtonAction);
    }

    private void handleButtonAction(ActionEvent event) {
        try {
            userLogin(event);
        } catch (IOException e) {
            wrongLogin.setText("Terjadi kesalahan: " + e.getMessage());
        }
    }

    public void userLogin(ActionEvent event) throws IOException{
        checkLogin();
    }

    public void checkLogin() throws IOException{
        Main m = new Main();
        if(nim.getText().equals(storedNim) && password.getText().equals(storedPassword)){

            m.changeScene("menuPageDesign.fxml");
        }

        else if (nim.getText().isEmpty() && password.getText().isEmpty()) {
            wrongLogin.setText("tambahkan data");
        }

        else {
            wrongLogin.setText("wrong username or password"+storedNim);

        }
    }



    public void databaseConnection() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String user = nim.getText();
        String passwordUser = password.getText();

        try {
            // Menggunakan koneksi dari DatabaseUtils
            connection = SqlConnector.getConnection();

            // Mengeksekusi query untuk mendapatkan data
            String query = "SELECT * FROM user WHERE nim = ?";
            preparedStatement = connection.prepareStatement(query); // Gunakan PreparedStatement
            preparedStatement.setString(1, user); // Setel parameter query
            resultSet = preparedStatement.executeQuery();

            // Menampilkan hasil query
            while (resultSet.next()) {
                storedNim = resultSet.getString("nim");
                storedPassword = resultSet.getString("password");
            }


        } catch (SQLException e) {
            System.err.println("Kesalahan dalam query: " + e.getMessage());
        } finally {
            // Menutup koneksi dengan DatabaseUtils
            SqlConnector.closeConnection(connection);
        }
    }
}
