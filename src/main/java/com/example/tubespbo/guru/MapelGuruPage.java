package com.example.tubespbo.guru;

import com.example.tubespbo.DatabaseUtils;
import com.example.tubespbo.Main;
import com.example.tubespbo.models.MapelGuru;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static com.example.tubespbo.siswa.Siswa.getInstance;

public class MapelGuruPage {
    @FXML
    private TableView<MapelGuru> tableView;

    @FXML
    private Button profileButton;

    private Main main;

    public void setMain(Main main) {
        this.main = main;
    }

    public void setDataProfil() {
        profileButton.setText(" " + getInstance().storedUsername);
    }

    @FXML
    private void profileButtonAction(ActionEvent event) throws IOException {
        main.switchScene("GuruPageDesign.fxml");
    }

    @FXML
    public void nilaiButtonAction(ActionEvent event)  throws IOException {
        main.switchScene("NilaiGuruDesign.fxml");
    }

    public void setData() {
        profileButton.setText(" " + getInstance().storedUsername);
    }

    @FXML
    private void initialize() {
        // Panggil metode untuk mengatur data ke dalam label saat halaman dibuka
        setDataProfil();
        setupTableView();
    }

    int inputId = getInstance().storedId;

    public void setupTableView() {
        // Initialize your data list
        List<MapelGuru> mapelGuruList = fetchDataFromDatabase();

        // Convert the list to an ObservableList
        ObservableList<MapelGuru> data = FXCollections.observableArrayList(mapelGuruList);

        // Add columns to TableView
        if (tableView.getColumns().isEmpty()) {
            TableColumn<MapelGuru, Integer> numberColumn = new TableColumn<>("Number");
            numberColumn.setCellValueFactory(new PropertyValueFactory<>("number"));

            TableColumn<MapelGuru, Integer> nipColumn = new TableColumn<>("NIP");
            nipColumn.setCellValueFactory(new PropertyValueFactory<>("nip"));

            TableColumn<MapelGuru, String> mapelColumn = new TableColumn<>("Mata Pelajaran");
            mapelColumn.setCellValueFactory(new PropertyValueFactory<>("mapel"));

            tableView.getColumns().addAll(numberColumn, nipColumn, mapelColumn);
        }

        // Set model to TableView
        tableView.setItems(data);
    }

    private List<MapelGuru> fetchDataFromDatabase() {
        List<MapelGuru> mapelGuruList = new ArrayList<>();
        // Fetch data from database and populate the list
        try (Connection conn = DatabaseUtils.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM mapelguru WHERE nip = " + inputId)) {
            int i = 0;
            while (rs.next()) {
                i++;
                Integer nip = rs.getInt("nip");
                String mapel = rs.getString("mapel");

                MapelGuru mapelGuru = new MapelGuru(nip, mapel);
                mapelGuru.setNumber(i);

                mapelGuruList.add(mapelGuru);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mapelGuruList;
    }
}
