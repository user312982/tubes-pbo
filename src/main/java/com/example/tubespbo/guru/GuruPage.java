package com.example.tubespbo.guru;

import com.example.tubespbo.Main;
import com.example.tubespbo.siswa.Siswa;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class GuruPage {
    @FXML
    private Button profileButton;

    private Main main;

    // Metode untuk meneruskan objek Main dari kelas Main ke MenuPage
    public void setMain(Main main) {
        this.main = main;
    }

    @FXML
    private void mapelButtonAction(ActionEvent event) throws IOException {
        main.switchScene("MapelGuruDesign.fxml");
    }

    @FXML
    private void nilaiButtonAction(ActionEvent event) throws IOException {
        main.switchScene("NilaiGuruDesign.fxml");
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

