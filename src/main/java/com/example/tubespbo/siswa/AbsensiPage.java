package com.example.tubespbo.siswa;
import com.example.tubespbo.Main;
import com.example.tubespbo.models.AbsensiSiswa;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Timer;
import java.util.TimerTask;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import com.example.tubespbo.DatabaseUtils;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.sql.Statement;


import static com.example.tubespbo.siswa.Siswa.getInstance;

public class AbsensiPage{
    @FXML
    private Button profileButton;

    private Main main;

    @FXML
    private Button hadirButton;

    @FXML
    private Button sakitButton;

    @FXML
    private Button izinButton;

    @FXML
    private TableView<AbsensiSiswa> tableView;

    private boolean buttonClicked = false;
    private boolean isMorningInterval = false;
    private boolean isAfternoonInterval = false;

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
    public void nilaiButtonAction(ActionEvent event)  throws IOException {
        main.switchScene("NilaiPageDesign.fxml");
    }

    public void setData() {
        profileButton.setText(" " + getInstance().storedUsername);
    }

    @FXML
    private void initialize() {
        this.tableView = tableView;
        setData();
        scheduleButtonVisibility();
        initializeTableView();
        loadDataToTable();
    }

    int inputId = getInstance().storedId;
    String inputUsername = getInstance().storedUsername;


    @FXML
    private void handleButtonPress(javafx.event.ActionEvent event) {
        Button button = (Button) event.getSource();
        insertDataToDatabase(button.getText());
        hideAllButtons();
    }

    private void hideAllButtons() {
        hadirButton.setVisible(false);
        izinButton.setVisible(false);
        sakitButton.setVisible(false);
    }

    private void scheduleButtonVisibility() {
        Timer timer = new Timer(true);
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                LocalTime now = LocalTime.now();
                boolean isMorning = now.getHour() >= 7 && now.getHour() < 8;
                boolean isAfternoon = now.getHour() >= 15 && now.getHour() < 16;

                // Reset buttonClicked status for next day
                if (now.getHour() == 0 && now.getMinute() == 0) {
                    buttonClicked = false;
                    isMorningInterval = false;
                    isAfternoonInterval = false;
                }

                // Check database for previous absences
                checkDatabaseForPreviousAbsences();

                // Show buttons only during the specified intervals
                javafx.application.Platform.runLater(() -> {
                    if ((isMorning && !isMorningInterval) || (isAfternoon && !isAfternoonInterval)) {
                        hadirButton.setVisible(true);
                        izinButton.setVisible(true);
                        sakitButton.setVisible(true);
                    } else {
                        hideAllButtons();
                    }
                });
            }
        }, 0, 1000); // Check every second
    }

    private void checkDatabaseForPreviousAbsences() {
        String url = "jdbc:mysql://localhost:3306/tubespbo";
        String user = "root";
        String password = "";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            // Check for morning absence
            String morningQuery = "SELECT * FROM absensi WHERE tanggal = ? AND absensi_pagi = TRUE AND nis = " + inputId;
            try (PreparedStatement stmt = conn.prepareStatement(morningQuery)) {
                stmt.setDate(1, java.sql.Date.valueOf(LocalDate.now()));
                try (ResultSet rs = stmt.executeQuery()) {
                    isMorningInterval = rs.next(); // If there's a morning absence, set the flag
                }
            }

            // Check for afternoon absence
            String afternoonQuery = "SELECT * FROM absensi WHERE tanggal = ? AND absensi_sore = TRUE AND nis = " + inputId;
            try (PreparedStatement stmt = conn.prepareStatement(afternoonQuery)) {
                stmt.setDate(1, java.sql.Date.valueOf(LocalDate.now()));
                try (ResultSet rs = stmt.executeQuery()) {
                    isAfternoonInterval = rs.next(); // If there's an afternoon absence, set the flag
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void insertDataToDatabase(String type) {
        String url = "jdbc:mysql://localhost:3306/tubespbo";
        String user = "root";
        String password = "";

        // Insert data absensi
        String absensiQuery = "INSERT INTO absensi (nis, nama, status, tanggal, jam) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement(absensiQuery)) {
            stmt.setString(1, String.valueOf(inputId));
            stmt.setString(2, inputUsername);
            stmt.setString(3, type);
            stmt.setDate(4, java.sql.Date.valueOf(LocalDate.now()));
            stmt.setTime(5, java.sql.Time.valueOf(LocalTime.now()));
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Update status absensi pagi atau sore
        if (type.equals("Izin") || type.equals("Hadir") || type.equals("Sakit")) {
            if (LocalTime.now().getHour() >= 7 && LocalTime.now().getHour() < 8) {
                absensiPagi();
            } else if (LocalTime.now().getHour() >= 15 && LocalTime.now().getHour() < 16) {
                absensiSore();
            }
        }
    }

    private void absensiPagi() {
        String url = "jdbc:mysql://localhost:3306/tubespbo";
        String user = "root";
        String password = "";
        String query = "UPDATE absensi SET absensi_pagi = TRUE WHERE tanggal = ? AND absensi_pagi = FALSE AND nis = " + inputId;

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setDate(1, java.sql.Date.valueOf(LocalDate.now()));
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void absensiSore() {
        String url = "jdbc:mysql://localhost:3306/tubespbo";
        String user = "root";
        String password = "";
        String query = "UPDATE absensi SET absensi_sore = TRUE WHERE tanggal = ? AND absensi_sore = FALSE AND nis = " + inputId;

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setDate(1, java.sql.Date.valueOf(LocalDate.now()));
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void initializeTableView() {
        TableColumn<AbsensiSiswa, LocalDate> tanggalColumn = new TableColumn<>("Tanggal");
        tanggalColumn.setCellValueFactory(cellData -> cellData.getValue().tanggalProperty());

        TableColumn<AbsensiSiswa, LocalTime> jamColumn = new TableColumn<>("Jam");
        jamColumn.setCellValueFactory(cellData -> cellData.getValue().jamProperty());

        TableColumn<AbsensiSiswa, String> namaColumn = new TableColumn<>("Nama");
        namaColumn.setCellValueFactory(cellData -> cellData.getValue().namaProperty());

        TableColumn<AbsensiSiswa, String> statusColumn = new TableColumn<>("Status");
        statusColumn.setCellValueFactory(cellData -> cellData.getValue().statusProperty());

        TableColumn<AbsensiSiswa, Integer> nisColumn = new TableColumn<>("NIS");
        nisColumn.setCellValueFactory(cellData -> cellData.getValue().nisProperty().asObject());

        tableView.getColumns().addAll(tanggalColumn, jamColumn, namaColumn, statusColumn, nisColumn);
    }

    private void loadDataToTable() {
        List<AbsensiSiswa> absensiList = fetchDataFromDatabase();
        ObservableList<AbsensiSiswa> data = FXCollections.observableArrayList(absensiList);
        tableView.setItems(data);
    }

    private List<AbsensiSiswa> fetchDataFromDatabase() {
        List<AbsensiSiswa> absensiList = new ArrayList<>();
        try (Connection conn = DatabaseUtils.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM absensi WHERE nis =" + inputId)) {
            while (rs.next()) {
                LocalDate tanggal = rs.getDate("tanggal").toLocalDate();
                LocalTime jam = rs.getTime("jam").toLocalTime();
                String nama = rs.getString("nama");
                String status = rs.getString("status");
                int nis = rs.getInt("nis");

                AbsensiSiswa absensi = new AbsensiSiswa(tanggal, jam, nama, status, nis);
                absensiList.add(absensi);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return absensiList;
    }
}
