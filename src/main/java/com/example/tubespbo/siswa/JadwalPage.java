package com.example.tubespbo.siswa;

    import com.example.tubespbo.DatabaseUtils;
    import com.example.tubespbo.Main;
    import com.example.tubespbo.models.JadwalMapel;
    import com.example.tubespbo.models.MataPelajaran;
    import javafx.beans.property.SimpleIntegerProperty;
    import javafx.collections.FXCollections;
    import javafx.collections.ObservableList;
    import javafx.event.ActionEvent;
    import javafx.fxml.FXML;
    import javafx.scene.control.Button;
    import javafx.scene.control.Label;
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


public class JadwalPage {

    @FXML
    private Button profileButton;

    @FXML
    private TableView<JadwalMapel> tableView;

    @FXML
    private Label namaUser;

    @FXML
    private Label idUser;

    private Main main;

    public void setMain(Main main) {
        this.main = main;
    }


    public void setDataProfil() {
        profileButton.setText(" " + getInstance().storedUsername);
    }

    public void setDataUsername(){
        namaUser.setText(getInstance().storedUsername);
    }

    public void setDataID(){
        idUser.setText(String.valueOf(getInstance().storedId));
    }


    @FXML
    private void initialize() {
        // Panggil metode untuk mengatur data ke dalam label saat halaman dibuka
        setDataProfil();
        setDataUsername();
        setDataID();
        setupTableView(this.tableView);
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
    private void absensiButtonAction(ActionEvent event) throws IOException {
        main.switchScene("AbsensiPageDesign.fxml");
    }

    @FXML
    public void nilaiButtonAction(ActionEvent event)  throws IOException {
        main.switchScene("NilaiPageDesign.fxml");
    }

    int inputId = getInstance().storedId;

    public void setupTableView(TableView<JadwalMapel> tableView) {
        // Initialize your data list (assuming you have a method to fetch data from the database)
        List<JadwalMapel> jadwalMapels = fetchDataFromDatabase();

        // Convert the list to an ObservableList
        ObservableList<JadwalMapel> data = FXCollections.observableArrayList(jadwalMapels);

        // Add columns to TableView
        if (tableView.getColumns().isEmpty()) {
            TableColumn<JadwalMapel, Integer> numberColumn = new TableColumn<>("Number");
            numberColumn.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().numberProperty().get()).asObject());

            TableColumn<JadwalMapel, String> dayColumn = new TableColumn<>("Day");
            dayColumn.setCellValueFactory(cellData -> cellData.getValue().dayProperty());

            TableColumn<JadwalMapel, String> startTimeColumn = new TableColumn<>("Start Time");
            startTimeColumn.setCellValueFactory(cellData -> cellData.getValue().startTimeProperty());

            TableColumn<JadwalMapel, String> endTimeColumn = new TableColumn<>("End Time");
            endTimeColumn.setCellValueFactory(cellData -> cellData.getValue().endTimeProperty());

            TableColumn<JadwalMapel, String> studySubjectsColumn = new TableColumn<>("Study Objects");
            studySubjectsColumn.setCellValueFactory(cellData -> cellData.getValue().studySubjectsProperty());

            tableView.getColumns().addAll(dayColumn, startTimeColumn, endTimeColumn, studySubjectsColumn);
        }
        // Set model to TableView
        tableView.setItems(data);
    }

    private List<JadwalMapel> fetchDataFromDatabase() {
        List<JadwalMapel> jadwalMapels = new ArrayList<>();
        // Fetch data from database and populate the list
        // Example:
        try (Connection conn = DatabaseUtils.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM jadwal WHERE iduser = " + inputId)) {
            int i = 0;
            while (rs.next()) {
                i++;
                String day = rs.getString("day");
                String startTime = rs.getString("startTime");
                String endTime = rs.getString("endTime");
                String studySubjects = rs.getString("mapel");

                MataPelajaran studySubject = new MataPelajaran(studySubjects, "","");

                JadwalMapel jadwalMapel = new JadwalMapel(day, startTime, endTime, studySubject);
                jadwalMapel.setNumber(i);

                jadwalMapels.add(jadwalMapel);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return jadwalMapels;
    }


}

