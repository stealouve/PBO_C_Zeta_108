package com.praktikum.GUI;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import com.praktikum.data.Item;
import com.praktikum.data.DataStore;
import com.praktikum.user.Mahasiswa;
import javafx.scene.control.cell.PropertyValueFactory;

public class MahasiswaDashboard {

    private VBox root;
    private Label welcomeLabel;
    private ComboBox<String> itemNameComboBox;
    private TextField itemDescriptionField;
    private TextField itemLocationField;
    private Button reportButton;
    private Label reportMessageLabel;
    private TableView<Item> reportedItemsTable;

    private Mahasiswa currentUser ;

    public MahasiswaDashboard(Mahasiswa mahasiswa) {
        this.currentUser  = mahasiswa;
        initializeUI();
        updateReportedItemsList();
    }

    private void initializeUI() {
        welcomeLabel = new Label("Selamat datang, " + currentUser .getNama());
        welcomeLabel.setFont(new Font(18));

        Separator separator1 = new Separator();

        itemNameComboBox = new ComboBox<>();
        itemNameComboBox.getItems().addAll("Dompet", "HP");
        itemNameComboBox.setPromptText("Pilih Barang");

        itemDescriptionField = new TextField();
        itemDescriptionField.setPromptText("Deskripsi Barang");
        itemLocationField = new TextField();
        itemLocationField.setPromptText("Lokasi Terakhir/Ditemukan");

        reportButton = new Button("Laporkan");
        reportMessageLabel = new Label();
        reportMessageLabel.setTextFill(Color.RED);

        HBox reportFields = new HBox(10, itemNameComboBox, itemDescriptionField, itemLocationField, reportButton);
        reportFields.setAlignment(Pos.CENTER);

        Separator separator2 = new Separator();

        reportedItemsTable = new TableView<>();
        TableColumn<Item, String> nameColumn = new TableColumn<>("Nama");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("itemNama")); // Menggunakan nama properti

        TableColumn<Item, String> locationColumn = new TableColumn<>("Lokasi");
        locationColumn.setCellValueFactory(new PropertyValueFactory<>("location")); // Menggunakan nama properti

        reportedItemsTable.getColumns().addAll(nameColumn, locationColumn);
        reportedItemsTable.setItems(FXCollections.observableArrayList());

        Button logoutButton = new Button("Logout");

        reportButton.setOnAction(event -> handleReportItem());
        logoutButton.setOnAction(event -> MainApp.loadLoginScene());

        root = new VBox(10);
        root.setPadding(new Insets(14));
        root.getChildren().addAll(welcomeLabel, separator1,
                reportFields,
                reportMessageLabel,
                separator2,
                reportedItemsTable,
                logoutButton);
    }

    private void handleReportItem() {
        String itemName = itemNameComboBox.getValue();
        String description = itemDescriptionField.getText();
        String location = itemLocationField.getText();

        if (itemName == null || description.isEmpty() || location.isEmpty()) {
            reportMessageLabel.setText("Harap lengkapi semua field laporan!");
            return;
        }

        Item item = new Item(itemName, location, description, currentUser );
        DataStore.getReportedItems().add(item);
        reportMessageLabel.setText("Barang berhasil dilaporkan!");
        itemDescriptionField.clear();
        itemLocationField.clear();
        updateReportedItemsList();
    }

    private void updateReportedItemsList() {
        ObservableList<Item> items = FXCollections.observableArrayList();
        for (Item item : DataStore.getReportedItems()) {
            if (item.getReported().equals(currentUser .getNim())) {
                items.add(item);
            }
        }
        reportedItemsTable.setItems(items);
    }

    public Parent getRoot() {
        return root;
    }
}
