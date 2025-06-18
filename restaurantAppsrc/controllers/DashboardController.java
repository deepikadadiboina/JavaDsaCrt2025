package controllers;



import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Parent;

public class DashboardController {

    @FXML private StackPane mainPane;

    private void loadUI(String fxml) {
        try {
            Pane pane = FXMLLoader.load(getClass().getResource("/views/" + fxml + ".fxml"));
            mainPane.getChildren().setAll(pane);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML private void loadMenu() {
        loadUI("menu");
    }

    @FXML private void loadBilling() {
        loadUI("billing");
    }

    @FXML private void loadStaff() {
        loadUI("staff");
    }

    @FXML private void loadFeedback() {
        loadUI("feedback");
    }

    @FXML private void loadRestaurantInfo() {
        loadUI("restaurant_info");
    }

    @FXML private void handleLogout(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/views/login.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Login");
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

