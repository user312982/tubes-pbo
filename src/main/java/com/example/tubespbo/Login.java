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
    private String storedPassword, storedAlamat, storedNumberPhone, storedUsername;;

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
            userLogin();
        } catch (IOException e) {
            wrongLogin.setText("Terjadi kesalahan: " + e.getMessage());
        }
    }

    public void userLogin() throws IOException {
        int inputId = Integer.parseInt(id.getText());
        if (inputId == storedId && password.getText().equals(storedPassword)) {
            main.switchToMenuPage();
        }else if (id.getText().isEmpty() && password.getText().isEmpty()) {
            wrongLogin.setText("Tambahkan data");
        } else {
            wrongLogin.setText("Wrong username or password");
        }
    }

    public void updateStoredCredentials() {
        Connection connection = null;
        ResultSet resultSet = null;
        int user = Integer.parseInt(id.getText());
        try {
            // Mendapatkan data pengguna berdasarkan NIM
            resultSet = DatabaseUtils.getUserById(user);

            // Menampilkan hasil query
            if (resultSet.next()) {
                storedId = resultSet.getInt("id");
                storedPassword = resultSet.getString("password");
                storedAlamat = resultSet.getString("alamat");
                storedNumberPhone = resultSet.getString("numberphone");
                storedUsername = resultSet.getString("nama");

                UserData userData = new UserData(storedId, storedUsername, storedAlamat, storedNumberPhone);
                UserData.setINSTANCE(userData);
            }

        } catch (SQLException e) {
            System.err.println("Kesalahan dalam query: " + e.getMessage());
        } finally {
            // Menutup koneksi
            DatabaseUtils.closeConnection(connection);
        }
    }

}
