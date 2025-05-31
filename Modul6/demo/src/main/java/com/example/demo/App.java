package com.example.demo;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class App extends Application {

    private int angkaBenar;
    private int jumlahTebakan;

    private Label statusLabel = new Label("🎯 Tebak Angka 1–100");
    private Label hasilLabel = new Label("");
    private TextField inputField = new TextField();
    private Label percobaanLabel = new Label("Jumlah percobaan: 0");

    private Scene menuScene, gameScene;

    @Override
    public void start(Stage primaryStage) {

        //Menu
        Button mulaiButton = new Button("▶ Mulai Permainan");
        Button keluarButton = new Button("Keluar");
        VBox menuLayout = new VBox(20, new Label("Selamat Datang!"), mulaiButton, keluarButton);
        menuLayout.setAlignment(Pos.CENTER);
        menuScene = new Scene(menuLayout, 400, 300);

        //Game
        resetGame();

        statusLabel.setFont(new Font("Arial", 24));
        hasilLabel.setFont(new Font(16));
        percobaanLabel.setFont(new Font(14));

        inputField.setPromptText("Masukkan angka di sini");
        inputField.setMaxWidth(200);

        Button tebakButton = new Button("Tebak");
        Button mainLagiButton = new Button("🔄 Main Lagi");
        Button kembaliKeMenuButton = new Button("⬅ Kembali ke Menu");

        tebakButton.setOnAction(e -> {
            try {
                int tebakan = Integer.parseInt(inputField.getText());
                jumlahTebakan++;
                percobaanLabel.setText("Jumlah percobaan: " + jumlahTebakan);

                if (tebakan < angkaBenar) {
                    hasilLabel.setText("Angka terlalu kecil!");
                    hasilLabel.setTextFill(Color.ORANGE);
                } else if (tebakan > angkaBenar) {
                    hasilLabel.setText("Angka terlalu besar!");
                    hasilLabel.setTextFill(Color.ORANGE);
                } else {
                    hasilLabel.setText("Tebakan benar!");
                    hasilLabel.setTextFill(Color.GREEN);
                }
            } catch (NumberFormatException ex) {
                hasilLabel.setText("Masukkan angka valid!");
                hasilLabel.setTextFill(Color.RED);
            }
        });

        mainLagiButton.setOnAction(e -> resetGame());
        keluarButton.setOnAction(e -> System.exit(0));
        kembaliKeMenuButton.setOnAction(e -> primaryStage.setScene(menuScene));
        mulaiButton.setOnAction(e -> primaryStage.setScene(gameScene));

        HBox inputArea = new HBox(5, inputField, tebakButton);
        inputArea.setAlignment(Pos.CENTER);

        HBox tombolBawah = new HBox(10, mainLagiButton, kembaliKeMenuButton);
        tombolBawah.setAlignment(Pos.CENTER);

        VBox gameLayout = new VBox(10, statusLabel, inputArea, tombolBawah, hasilLabel, percobaanLabel);
        gameLayout.setAlignment(Pos.CENTER);
        gameLayout.setStyle("-fx-background-color:rgb(74, 136, 230);");

        gameScene = new Scene(gameLayout, 500, 350);

        primaryStage.setTitle("Game Tebak Angka");
        primaryStage.setScene(menuScene);
        primaryStage.show();
    }

    private void resetGame() {
        angkaBenar = (int) (Math.random() * 100) + 1;
        jumlahTebakan = 0;
        hasilLabel.setText("");
        percobaanLabel.setText("Jumlah percobaan: 0");
        inputField.setText("");
    }

    public static void main(String[] args) {
        launch(args);
    }
}
