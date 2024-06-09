package com.example.tubespbo.guru;
import com.example.tubespbo.Main;
import com.example.tubespbo.models.NilaiMapel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;

import java.io.IOException;

import static com.example.tubespbo.siswa.Siswa.getInstance;

public class NilaiGuruPage {
    @FXML
    private Button profileButton;

    @FXML
    private TableView<NilaiMapel> tableView;

    private Main main;

    public void setMain(Main main) {
        this.main = main;
    }

    @FXML
    private void profileButtonAction(ActionEvent event) throws IOException {
        main.switchScene("GuruPageDesign.fxml");
    }

    @FXML
    private void mapelButtonAction(ActionEvent event) throws IOException {
        main.switchScene("MapelGuruDesign.fxml");
    }


    String inputSiswa = getInstance().storedUsername;

    public void setData() {
        profileButton.setText(" " + inputSiswa);
    }

    @FXML
    private void initialize() {
        setData();
    }





}
