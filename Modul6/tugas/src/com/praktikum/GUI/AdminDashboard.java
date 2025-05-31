package com.praktikum.GUI;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class AdminDashboard extends VBox {
    public AdminDashboard() {
        createAdminDashboard();
    }

    private void createAdminDashboard() {
        Label label = new Label("Selamat datang di Dashboard Admin");
        getChildren().add(label);

    }
}