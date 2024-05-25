package com.example.tubespbo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;


public class Main extends Application {

    private static Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws IOException {
        Main.primaryStage = primaryStage;
        primaryStage.setResizable(false);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("loginFormDesign.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root, 800,500);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Login");
        primaryStage.show();

        // Menetapkan objek Main ke controller Login
        Login loginController = loader.getController();
        loginController.setMain(this);
    }

    public void switchScene(String fxmlFile) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
        Parent root = loader.load();
        primaryStage.setScene(new Scene(root, 900,500));
        primaryStage.show();
        // Menetapkan objek Main ke controller Menu
        if (fxmlFile.equals("MainPageDesign.fxml")) {
            Login controller = loader.getController();
            controller.setMain(this);
        } else if (fxmlFile.equals("MenuPageDesign.fxml")) {
            MenuPage controller = loader.getController();
            controller.setMain(this);
        } else if (fxmlFile.equals("MapelPageDesign.fxml")) {
            MapelPage controller = loader.getController();
            controller.setMain(this);
        }
    }

    public void switchToMenuPage() throws IOException {
        switchScene("MenuPageDesign.fxml");
    }

    public static void main(String[] args) {
        launch(args);
    }

}