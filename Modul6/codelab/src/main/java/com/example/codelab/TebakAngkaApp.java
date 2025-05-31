package com.example.codelab;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import java.util.concurrent.ThreadLocalRandom;

public class TebakAngkaApp extends Application {

    private int angkaTarget;
    private int percobaan;
    private Label feedbackLabel;
    private Label percobaanLabel;
    private TextField inputField;
    private Button actionButton;

    @Override
    public void start(Stage primaryStage) {
        resetGame();

        Label iconLabel = new Label("\u31BB");
        iconLabel.setFont(Font.font(30));
        Label titleLabel = new Label("Tebak Angka 1–100");
        titleLabel.setFont(Font.font(20));
        HBox titleBox = new HBox(10, iconLabel, titleLabel);
        titleBox.setAlignment(Pos.CENTER);

        Label subtitle = new Label("Masukkan tebakanmu!");
        subtitle.setFont(Font.font(12));

        feedbackLabel = new Label(" ");
        feedbackLabel.setFont(Font.font(12));

        inputField = new TextField();
        inputField.setPromptText("Masukkan angka di sini");
        inputField.setPrefWidth(200);

        actionButton = new Button("Coba Tebak!");
        actionButton.setStyle("-fx-background-color: #28a745; -fx-text-fill: white; -fx-font-weight: bold;");
        actionButton.setOnAction(e -> handleAction());

        HBox inputBox = new HBox(9, inputField, actionButton);
        inputBox.setAlignment(Pos.CENTER);

        percobaanLabel = new Label("Jumlah percobaan: 0");
        percobaanLabel.setFont(Font.font(10));

        VBox root = new VBox(5,
                titleBox,
                subtitle,
                feedbackLabel,
                inputField,
                percobaanLabel,
                actionButton
        );

        root.setPadding(new Insets(20));
        root.setAlignment(Pos.CENTER);
        root.setStyle("-fx-background-color: #F5F5DC;");

        Scene scene = new Scene(root, 400, 300);
        primaryStage.setTitle("Tebak Angka Advance");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void handleAction() {
        String btnText = actionButton.getText();
        if ("Main Lagi".equals(btnText)) {
            resetGame();
            feedbackLabel.setText(" ");
            percobaanLabel.setText("Jumlah percobaan: 0");
            inputField.clear();
            inputField.setDisable(false);
            actionButton.setText("Coba Tebak!");
            actionButton.setStyle("-fx-background-color: #FAEBD7; -fx-text-fill: white; -fx-font-weight: bold;");
            return;
        }

        String teks = inputField.getText().trim();
        int tebakan;
        try {
            tebakan = Integer.parseInt(teks);
        } catch (NumberFormatException ex) {
            feedbackLabel.setText("\u26A0 Masukkan angka yang valid!");
            return;
        }

        percobaan++;
        percobaanLabel.setText("Jumlah percobaan: " + percobaan);

        if (tebakan < angkaTarget) {
            feedbackLabel.setText("\u25BC Terlalu kecil!");
            feedbackLabel.setTextFill(Color.CHOCOLATE);
        } else if (tebakan > angkaTarget) {
            feedbackLabel.setText("\u26A0 Terlalu besar!");
            feedbackLabel.setTextFill(Color.CHOCOLATE);
        } else {
            feedbackLabel.setText("\u2714 Tebakan benar!");
            feedbackLabel.setTextFill(Color.BLUE);
            inputField.setDisable(true);
            actionButton.setText("Main Lagi");
            actionButton.setStyle("-fx-background-color: #FAEBD7; -fx-text-fill: white; -fx-font-weight: bold;");
        }

        inputField.clear();
    }

    private void resetGame() {
        angkaTarget = ThreadLocalRandom.current().nextInt(1, 101);
        percobaan = 0;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
