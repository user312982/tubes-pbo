package com.example.tubespbo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

import static com.example.tubespbo.Siswa.getInstance;

public class MenuPage {

    @FXML
    private Button profileButton;

    private Main main;

    // Metode untuk meneruskan objek Main dari kelas Main ke MenuPage
    public void setMain(Main main) {
        this.main = main;
    }

    @FXML
    private void jadwalButtonAction(ActionEvent event) throws IOException {
        main.switchScene("JadwalPageDesign.fxml");
    }

    @FXML
    private void mapelButtonAction(ActionEvent event) throws IOException {
        main.switchScene("MapelPageDesign.fxml");
    }

    @FXML
    private void absensiButtonAction(ActionEvent event) throws IOException {
        main.switchScene("AbsensiPageDesign.fxml");
    }

    @FXML
    public void nilaiButtonAction(ActionEvent event)  throws IOException {
        main.switchScene("NilaiPageDesign.fxml");
    }

    public void setData() {
        Siswa instance = Siswa.getInstance();
        profileButton.setText(" " + instance.getStoredUsername());
    }

    @FXML
    private void initialize() {
        // Panggil metode untuk mengatur data ke dalam label saat halaman dibuka
        setData();
    }

}

