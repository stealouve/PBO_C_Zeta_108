module com.example.baru {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.baru to javafx.fxml;
    exports com.example.baru;
}