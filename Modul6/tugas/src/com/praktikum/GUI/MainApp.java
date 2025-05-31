package com.praktikum.GUI;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        LoginPane loginPane = new LoginPane(primaryStage);
        primaryStage.setTitle("Aplikasi Laporan Barang");
        primaryStage.setScene(new Scene(loginPane, 300, 200));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
