import javafx.application.*;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application{
    @Override
    public void start(Stage primayStage){
        Label label = new Label("Tekan aku: ");
        Button button = new Button("klik");

        button.setOnAction(e -> label.setText("hehe");
        VBox layout = new VBox(10);
        layout.getChildren().addAll(label,button);

        Scene scene = new Scene(layout, 200,200);

        primayStage.setTitle("hai");
        primayStage.setScene(scene);
        primayStage.show();
    }
}

public static void main(String[] args) {
}