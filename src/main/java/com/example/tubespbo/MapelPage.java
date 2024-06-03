package com.example.tubespbo;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static com.example.tubespbo.Siswa.getInstance;

public class MapelPage {
    @FXML
    private TableView<MataPelajaran> tableView;

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
        main.switchScene("MenuPageDesign.fxml");
    }

    @FXML
    private void jadwalButtonAction(ActionEvent event) throws IOException {
        main.switchScene("JadwalPageDesign.fxml");
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
        profileButton.setText(" " + getInstance().storedUsername);
    }

    @FXML
    private void initialize() {
        // Panggil metode untuk mengatur data ke dalam label saat halaman dibuka
        setDataProfil();
        setupTableView(this.tableView);
    }

    int inputId = getInstance().storedId;

    public void setupTableView(TableView<MataPelajaran> tableView) {
        // Initialize your data list (assuming you have a method to fetch data from the database)
        List<MataPelajaran> mataPelajaran = fetchDataFromDatabase();

        // Convert the list to an ObservableList
        ObservableList<MataPelajaran> data = FXCollections.observableArrayList(mataPelajaran);

        // Add columns to TableView
        if (tableView.getColumns().isEmpty()) {
            TableColumn<MataPelajaran, Integer> numberColumn = new TableColumn<>("Number");
            numberColumn.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().numberProperty().get()).asObject());

            TableColumn<MataPelajaran, String> mapelColumn = new TableColumn<>("mapel");
            mapelColumn.setCellValueFactory(cellData -> cellData.getValue().mapelProperty());

            TableColumn<MataPelajaran, String> kelasColumn = new TableColumn<>("kelas");
            kelasColumn.setCellValueFactory(cellData -> cellData.getValue().kelasProperty());

            TableColumn<MataPelajaran, String> jurusanColumn = new TableColumn<>("jurusan");
            jurusanColumn.setCellValueFactory(cellData -> cellData.getValue().jurusanProperty());

            tableView.getColumns().addAll(mapelColumn, kelasColumn, jurusanColumn);
        }
        // Set model to TableView
        tableView.setItems(data);
    }

    private List<MataPelajaran> fetchDataFromDatabase() {
        List<MataPelajaran> mataPelajarans = new ArrayList<>();
        // Fetch data from database and populate the list
        // Example:
        try (Connection conn = DatabaseUtils.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM mapel WHERE iduser = " + inputId)) {
            int i = 0;
            while (rs.next()) {
                i++;
                String mapel = rs.getString("mapel");
                String kelas = rs.getString("kelas");
                String jurusan = rs.getString("jurusan");

                MataPelajaran mataPelajaran = new MataPelajaran(mapel, kelas, jurusan);
                mataPelajaran.setNumber(i);

                mataPelajarans.add(mataPelajaran);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mataPelajarans;
    }
}
