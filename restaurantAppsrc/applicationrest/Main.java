package applicationrest;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/views/login.fxml"));
            Scene scene = new Scene(root);
            primaryStage.setTitle("Restaurant Management System");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch(Exception e) {
            e.printStackTrace(); // This prints FXML loading issues in console
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
