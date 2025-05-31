package com.praktikum.GUI;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LoginPane extends VBox {
    private Stage primaryStage;

    public LoginPane(Stage primaryStage) {
        this.primaryStage = primaryStage;
        createLoginUI();
    }

    private void createLoginUI() {
        Label titleLabel = new Label("Login Sistem");
        titleLabel.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");

        TextField usernameField = new TextField();
        usernameField.setPromptText("Username");

        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Password");

        Button loginButton = new Button("Login");

        loginButton.setOnAction(e -> {
            String username = usernameField.getText().trim();
            String password = passwordField.getText().trim();
            handleLogin(username, password);
        });

        this.setAlignment(Pos.CENTER);
        this.setPadding(new Insets(20));
        this.setSpacing(10);
        this.getChildren().addAll(titleLabel, usernameField, passwordField, loginButton);
    }

    private void handleLogin(String username, String password) {
        if (username.equals("admin") && password.equals("admin123")) {
            AdminDashboard adminDashboard = new AdminDashboard();
            primaryStage.setScene(new Scene(adminDashboard, 600, 400));
        } else if (username.equals("mhs01") && password.equals("mhs123")) {
            MahasiswaDashboard mahasiswaDashboard = new MahasiswaDashboard();
            primaryStage.setScene(new Scene(mahasiswaDashboard, 600, 400));
        } else {
            showAlert("Login Gagal", "Username atau password salah.");
        }
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
