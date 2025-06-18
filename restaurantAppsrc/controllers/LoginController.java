package controllers;


import applicationrest.DBConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Parent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginController {

    @FXML private TextField userField;
    @FXML private PasswordField passField;

    @FXML
    private void onLogin(ActionEvent event) {
        String user = userField.getText().trim();
        String pass = passField.getText().trim();

        if (user.isEmpty() || pass.isEmpty()) {
            showAlert("Error", "Username and password are required!");
            return;
        }

        try {
            Connection conn = DBConnection.getConnection();
            String query = "SELECT * FROM accounts WHERE username=? AND password=?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, user);
            stmt.setString(2, pass);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                // Load the dashboard
                Parent root = FXMLLoader.load(getClass().getResource("/views/dashboard.fxml"));
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(new Scene(root));
                stage.setTitle("Dashboard");
                stage.show();
            } else {
                showAlert("Login Failed", "Invalid username or password.");
            }

            rs.close();
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
            showAlert("Error", "An error occurred during login.");
        }
    }

    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}

