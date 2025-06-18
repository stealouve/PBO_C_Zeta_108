package com.praktikum.GUI;

import javafx.collections.*;
import javafx.geometry.*;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import com.praktikum.data.Item;
import com.praktikum.data.DataStore;
import com.praktikum.user.Mahasiswa;
import com.praktikum.user.User;

import java.util.Iterator;

public class AdminDashboard {

    private VBox root;
    private ListView<String> reportedItemsListView; //daftar barang
    private TextField itemIndexToClaimField; //input menandai item
    private Label itemMessageLabel;

    private ListView<String> userListView;
    private TextField newUserNameField;
    private TextField newUserNimField;
    private Label userMessageLabel;

    private Button addUserButton;
    private Button removeUserButton;

    public AdminDashboard() {
        initializeUI();
        updateReportedItemsList();
        updateUserList();
    }

    private void initializeUI() {
        // manageitems
        Label welcomeLabel = new Label("Halo, Administrator admin");
        welcomeLabel.setFont(new Font(18));

        Separator separator1 = new Separator();

        Label itemReportsTitle = new Label("Laporan Barang");
        itemReportsTitle.setFont(new Font(14));
        reportedItemsListView = new ListView<>();
        itemIndexToClaimField = new TextField();
        itemIndexToClaimField.setPromptText("Indeks");
        Button claimItemButton = new Button("Tandai Claimed");
        itemMessageLabel = new Label();
        itemMessageLabel.setTextFill(Color.RED);
        HBox itemActionBox = new HBox(10, itemIndexToClaimField, claimItemButton);
        itemActionBox.setPadding(new Insets(5, 0, 0, 0));

        VBox itemReportsSection = new VBox(10, itemReportsTitle, reportedItemsListView, itemActionBox, itemMessageLabel);
        itemReportsSection.setPrefWidth(400);
        VBox.setMargin(itemReportsSection, new Insets(0, 10, 0, 0));


        //buat manageusers
        Label userDataTitle = new Label("Data Mahasiswa");
        userDataTitle.setFont(new Font(14));
        userListView = new ListView<>();

        newUserNameField = new TextField();
        newUserNameField.setPromptText("Nama");
        newUserNameField.setMaxWidth(150);

        newUserNimField = new TextField();
        newUserNimField.setPromptText("NIM");
        newUserNimField.setMaxWidth(150);

        HBox inputFieldsVBox = new HBox(25);
        inputFieldsVBox.getChildren().addAll(newUserNameField, newUserNimField);
        inputFieldsVBox.setAlignment(Pos.CENTER);

        addUserButton = new Button("Tambah");
        addUserButton.setPrefWidth(80);

        removeUserButton = new Button("Hapus");
        removeUserButton.setPrefWidth(80);

        HBox actionButtonsBox = new HBox(15, addUserButton, removeUserButton);
        actionButtonsBox.setAlignment(Pos.CENTER);
        VBox.setMargin(actionButtonsBox, new Insets(20, 0, 0, 0));

        userMessageLabel = new Label();
        userMessageLabel.setTextFill(Color.RED);
        userMessageLabel.setAlignment(Pos.CENTER);

        VBox userDataSection = new VBox(10);
        userDataSection.setPrefWidth(400);
        userDataSection.getChildren().addAll(userDataTitle, userListView, inputFieldsVBox, actionButtonsBox, userMessageLabel);
        userDataSection.setAlignment(Pos.TOP_CENTER);

        HBox mainContent = new HBox(20, itemReportsSection, userDataSection);

        Button logoutButton = new Button("Logout");

        claimItemButton.setOnAction(e -> handleClaimItem());
        addUserButton.setOnAction(e -> handleAddUser ());
        removeUserButton.setOnAction(e -> handleRemoveUser ());
        logoutButton.setOnAction(e -> MainApp.loadLoginScene());

        updateReportedItemsList();
        updateUserList();

        root = new VBox(10);
        root.setPadding(new Insets(14));
        root.getChildren().addAll(welcomeLabel, separator1, mainContent, logoutButton);
    }

    private void updateReportedItemsList() {
        ObservableList<String> items = FXCollections.observableArrayList();
        if (DataStore.getReportedItems().isEmpty()) {
            items.add("Belum ada barang yang dilaporkan.");
        } else {
            int i = 1;
            for (Item item : DataStore.getReportedItems()) {
                items.add("[" + i++ + "] " + item.getItemNama() + " | Lokasi: " + item.getLocation() + " | Status: " + item.getStatus());
            }
        }
        reportedItemsListView.setItems(items);
    }

    private void updateUserList() {
        ObservableList<String> users = FXCollections.observableArrayList();
        int i = 1;
        for (User  user : DataStore.getUserList()) {
            if (user instanceof Mahasiswa) {
                users.add("[" + i++ + "] Nama: " + user.getNama() + ", NIM: " + user.getNim());
            }
        }
        if (users.isEmpty()) {
            users.add("Belum ada mahasiswa yang terdaftar.");
        }
        userListView.setItems(users);
    }

    private void handleClaimItem() {
        String indexText = itemIndexToClaimField.getText();
        if (indexText.isEmpty()) {
            itemMessageLabel.setText("Masukkan indeks barang!");
            return;
        }

        try {
            int indeks = Integer.parseInt(indexText);
            if (indeks <= 0 || indeks > DataStore.getReportedItems().size()) {
                itemMessageLabel.setText("Indeks tidak valid.");
                return;
            }
            Item item = DataStore.getReportedItems().get(indeks - 1);
            item.setStatus("Claimed");
            itemMessageLabel.setText("Barang '" + item.getItemNama() + "' berhasil ditandai sebagai 'Claimed'.");
            updateReportedItemsList();
        } catch (NumberFormatException e) {
            itemMessageLabel.setText("Input harus berupa angka!");
        } catch (IndexOutOfBoundsException e) {
            itemMessageLabel.setText("Indeks di luar jangkauan!");
        } finally {
            itemIndexToClaimField.clear();
        }
    }

    private void handleAddUser () {
        String nama = newUserNameField.getText();
        String nim = newUserNimField.getText();

        if (nama.isEmpty() || nim.isEmpty()) {
            userMessageLabel.setText("Nama dan NIM harus diisi!");
            return;
        }

        // Cek apakah NIM sudah ada (untuk mencegah duplikasi)
        for (User  user : DataStore.getUserList()) {
            if (user instanceof Mahasiswa && user.getNim().equals(nim)) {
                userMessageLabel.setText("Mahasiswa dengan NIM tersebut sudah ada!");
                return;
            }
        }

        Mahasiswa mhs = new Mahasiswa(nama, nim);
        DataStore.getUserList().add(mhs);
        userMessageLabel.setText("Mahasiswa '" + nama + "' berhasil ditambahkan.");
        newUserNameField.clear();
        newUserNimField.clear();
        updateUserList(); // Perbarui daftar pengguna
    }

    private void handleRemoveUser () {
        String nimToRemove = newUserNimField.getText(); // Menggunakan newUser NimField
        if (nimToRemove.isEmpty()) {
            userMessageLabel.setText("Masukkan NIM mahasiswa di field NIM untuk dihapus!");
            return;
        }

        boolean removed = false;
        Iterator<User> iterator = DataStore.getUserList().iterator();
        while (iterator.hasNext()) {
            User user = iterator.next();
            // Hanya hapus jika itu Nama dan NIM cocok
            if (user instanceof Mahasiswa && user.getNim().equals(nimToRemove)) {
                iterator.remove();
                removed = true;
                userMessageLabel.setText("Mahasiswa dengan NIM " + nimToRemove + " berhasil dihapus.");
                break;
            }
        }
        if (!removed) {
            userMessageLabel.setText("Mahasiswa dengan NIM tersebut tidak ditemukan.");
        }
        newUserNameField.clear(); // Hapus juga nama jika sudah diisi
        newUserNimField.clear(); // Kosongkan field NIM setelah hapus
        updateUserList(); // Perbarui daftar pengguna
    }

    public Parent getRoot() {
        return root;
    }
}
