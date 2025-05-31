package com.praktikum.GUI;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class MahasiswaDashboard extends VBox {
    public MahasiswaDashboard() {
        createMahasiswaDashboard();
    }

    private void createMahasiswaDashboard() {
        Label label = new Label("Selamat datang di Dashboard Mahasiswa");
        getChildren().add(label);
        // Tambahkan elemen UI lainnya untuk dashboard mahasiswa
    }
}
