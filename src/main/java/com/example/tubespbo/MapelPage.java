package com.example.tubespbo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

import static com.example.tubespbo.UserData.getInstance;

public class MapelPage {

    @FXML
    private Button profileButton;
    
    private Main main;

    public void setMain(Main main) {
        this.main = main;
    }

    @FXML
    private void profileButtonAction(ActionEvent event) throws IOException {
        main.switchScene("MenuPageDesign.fxml");
    }

    @FXML
    private void jadwalButtonAction(ActionEvent event) throws IOException {
        main.switchScene("JadwalPageDesign.fxml");
    }

    public void setData() {
        profileButton.setText(" " + getInstance().storedUsername);
    }

    @FXML
    private void initialize() {
        // Panggil metode untuk mengatur data ke dalam label saat halaman dibuka
        setData();
    }

}
