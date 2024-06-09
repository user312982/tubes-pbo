package com.example.tubespbo.siswa;

import com.example.tubespbo.Main;
import com.example.tubespbo.DatabaseUtils;
import com.example.tubespbo.models.NilaiMapel;
import javafx.beans.property.SimpleFloatProperty;
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

import static com.example.tubespbo.siswa.Siswa.getInstance;

public class NilaiPage {
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
        main.switchScene("MenuPageDesign.fxml");
    }

    @FXML
    private void mapelButtonAction(ActionEvent event) throws IOException {
        main.switchScene("MapelPageDesign.fxml");
    }

    @FXML
    private void jadwalButtonAction(ActionEvent event) throws IOException {
        main.switchScene("JadwalPageDesign.fxml");
    }

    @FXML
    public void absensiButtonAction(ActionEvent event)  throws IOException {
        main.switchScene("AbsensiPageDesign.fxml");
    }

    String inputSiswa = getInstance().storedUsername;

    public void setData() {
        profileButton.setText(" " + inputSiswa);
    }

    @FXML
    private void initialize() {
        setData();
        setupTableView(this.tableView);
    }

    int inputId = getInstance().storedId;



    public void setupTableView(TableView<NilaiMapel> tableView) {
        // Initialize your data list (assuming you have a method to fetch data from the database)
        List<NilaiMapel> nilaiMapels = fetchDataFromDatabase();

        // Convert the list to an ObservableList
        ObservableList<NilaiMapel> data = FXCollections.observableArrayList(nilaiMapels);

        // Add columns to TableView
        if (tableView.getColumns().isEmpty()) {
            TableColumn<NilaiMapel, Integer> numberColumn = new TableColumn<>("Number");
            numberColumn.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().numberProperty().get()).asObject());

            TableColumn<NilaiMapel, Float> nilaiTugasColumn = new TableColumn<>("nilaitugas");
            nilaiTugasColumn.setCellValueFactory(cellData -> new SimpleFloatProperty(cellData.getValue().nilaiTugasProperty().get()).asObject());

            TableColumn<NilaiMapel, Float> nilaiUtsColumn = new TableColumn<>("nilaiuts");
            nilaiUtsColumn.setCellValueFactory(cellData -> new SimpleFloatProperty(cellData.getValue().nilaiUtsProperty().get()).asObject());

            TableColumn<NilaiMapel, Float> nilaiUasColumn = new TableColumn<>("nilaiuas");
            nilaiUasColumn.setCellValueFactory(cellData -> new SimpleFloatProperty(cellData.getValue().nilaiUasProperty().get()).asObject());

            TableColumn<NilaiMapel, Float> nilaiAkhirColumn = new TableColumn<>("nilaiakhir");
            nilaiAkhirColumn.setCellValueFactory(cellData -> new SimpleFloatProperty(cellData.getValue().nilaiAkhirProperty().get()).asObject());

            TableColumn<NilaiMapel, Integer> inputIdColumn = new TableColumn<>("inputid");
            inputIdColumn.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().inputIdProperty().get()).asObject());

            TableColumn<NilaiMapel, String> inputSiswaColumn = new TableColumn<>("inputsiswa");
            inputSiswaColumn.setCellValueFactory(cellData -> cellData.getValue().inputSiswaProperty());

            tableView.getColumns().addAll(numberColumn, nilaiTugasColumn, nilaiUtsColumn, nilaiUasColumn, nilaiAkhirColumn, inputIdColumn, inputSiswaColumn);
        }
        // Set model to TableView
        tableView.setItems(data);
    }

    private List<NilaiMapel> fetchDataFromDatabase() {
        List<NilaiMapel> nilaiMapels = new ArrayList<>();
        try (Connection conn = DatabaseUtils.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM nilai WHERE iduser = " + inputId)) {
            int i = 0;
            while (rs.next()) {
                i++;
                Float nilaiTugas = rs.getFloat("nilaitugas");
                Float nilaiUts = rs.getFloat("nilaiuts");
                Float nilaiUas = rs.getFloat("nilaiuas");
                Float nilaiAkhir = rs.getFloat("nilaiakhir");

                NilaiMapel nilaiMapel = new NilaiMapel(nilaiTugas, nilaiUts, nilaiUas, nilaiAkhir, inputId, inputSiswa);
                nilaiMapel.setNumber(i);

                nilaiMapels.add(nilaiMapel);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nilaiMapels;
    }



}
