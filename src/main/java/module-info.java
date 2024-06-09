module com.example.tubespbo {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.tubespbo to javafx.fxml;
    exports com.example.tubespbo;
    exports com.example.tubespbo.siswa;
    opens com.example.tubespbo.siswa to javafx.fxml;
    exports com.example.tubespbo.guru;
    opens com.example.tubespbo.guru to javafx.fxml;
    exports com.example.tubespbo.models;
    opens com.example.tubespbo.models to javafx.fxml;
}