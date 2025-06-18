package com.praktikum.GUI;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import com.praktikum.user.*;

public class MainApp extends Application {

    private static Stage primaryStage;
    private static User loggedInUser ;

    @Override
    public void start(Stage stage) {
        primaryStage = stage;
        primaryStage.setTitle("Lost & Found Kampus");
        loadLoginScene();
    }

    public static void loadLoginScene() {
        LoginPane loginPane = new LoginPane();
        Scene scene = new Scene(loginPane.getRoot(), 320, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void loadMahasiswaDashboard(Mahasiswa mahasiswa) {
        loggedInUser  = mahasiswa;
        MahasiswaDashboard mhsDashboard = new MahasiswaDashboard(mahasiswa);
        Scene scene = new Scene(mhsDashboard.getRoot(), 800, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Lost & Found Kampus - Mahasiswa Dashboard");
        primaryStage.show();
    }

    public static void loadAdminDashboard() {
        AdminDashboard adminDashboard = new AdminDashboard();
        Scene scene = new Scene(adminDashboard.getRoot(), 900, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Lost & Found Kampus - Admin Dashboard");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
