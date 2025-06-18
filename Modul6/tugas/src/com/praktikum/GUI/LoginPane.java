package com.praktikum.GUI;

import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import com.praktikum.main.LoginSystem;
import com.praktikum.data.DataStore;
import com.praktikum.user.Admin;
import com.praktikum.user.Mahasiswa;
import com.praktikum.user.User;

public class LoginPane {

    private VBox root;
    private ComboBox<String> userTypeComboBox;
    private TextField idField;
    private PasswordField passwordField;
    private Label messageLabel;

    public LoginPane() {
        initializeUI();
    }

    private void initializeUI() {
        Label titleLabel = new Label("Login Sistem Lost & Found");
        titleLabel.setFont(new Font("System Bold", 18));

        userTypeComboBox = new ComboBox<>();
        userTypeComboBox.setItems(FXCollections.observableArrayList("Admin", "Mahasiswa"));
        userTypeComboBox.setValue("Mahasiswa");

        idField = new TextField();
        idField.setPromptText("Username / Nama");

        passwordField = new PasswordField();
        passwordField.setPromptText("Password / NIM");

        Button loginButton = new Button("Login");
        loginButton.setPrefWidth(80);

        messageLabel = new Label();
        messageLabel.setTextFill(Color.RED);

        loginButton.setOnAction(event -> handleLogin());

        root = new VBox(10);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(20, 20, 20, 20));
        root.getChildren().addAll(titleLabel, userTypeComboBox, idField, passwordField, loginButton, messageLabel);
    }

    private void handleLogin() {
        String userType = userTypeComboBox.getValue();
        String id = idField.getText();
        String passwordOrNim = passwordField.getText();

        if (userType == null || id.isEmpty() || passwordOrNim.isEmpty()) {
            messageLabel.setText("Semua field harus diisi!");
            return;
        }

        User authenticatedUser  = LoginSystem.authenticateUser (userType, id, passwordOrNim);

        if (authenticatedUser  != null) {
            messageLabel.setText("Login Berhasil!");
            if (authenticatedUser  instanceof Admin) {
                MainApp.loadAdminDashboard();
            } else if (authenticatedUser  instanceof Mahasiswa) {
                MainApp.loadMahasiswaDashboard((Mahasiswa) authenticatedUser );
            }
        } else {
            messageLabel.setText("Login gagal, periksa kredensial.");
        }
    }

    public Parent getRoot() {
        return root;
    }
}
