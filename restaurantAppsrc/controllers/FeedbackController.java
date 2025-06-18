package controllers;

import applicationrest.DBConnection;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.paint.Color;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class FeedbackController {

    @FXML private TextField nameField;
    @FXML private ChoiceBox<String> ratingBox;
    @FXML private TextArea commentArea;
    @FXML private Label statusLabel;

    @FXML
    public void initialize() {
        ratingBox.getItems().addAll("Excellent", "Good", "Average", "Poor");
        ratingBox.getSelectionModel().selectFirst();
        statusLabel.setText("");
    }

    @FXML
    private void handleSubmitFeedback() {
        String name = nameField.getText().trim();
        String rating = ratingBox.getValue();
        String comments = commentArea.getText().trim();

        if (name.isEmpty() || comments.isEmpty()) {
            statusLabel.setTextFill(Color.RED);
            statusLabel.setText("Please fill in all fields.");
            return;
        }

        try {
            Connection conn = DBConnection.getConnection();
            String query = "INSERT INTO feedback (name, rating, comments) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, name);
            stmt.setString(2, rating);
            stmt.setString(3, comments);

            int rowsInserted = stmt.executeUpdate();

            if (rowsInserted > 0) {
                statusLabel.setTextFill(Color.GREEN);
                statusLabel.setText("Thank you for your feedback!");

                // Clear form
                nameField.clear();
                commentArea.clear();
                ratingBox.getSelectionModel().selectFirst();
            } else {
                statusLabel.setTextFill(Color.RED);
                statusLabel.setText("Failed to submit feedback.");
            }

            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
            statusLabel.setTextFill(Color.RED);
            statusLabel.setText("Database error occurred.");
        }
    }
}
