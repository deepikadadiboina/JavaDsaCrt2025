package controllers;



import javafx.fxml.FXML;
import javafx.scene.control.*;

public class RestaurantInfoController {

    @FXML private Label nameLabel;
    @FXML private Label addressLabel;
    @FXML private Label hoursLabel;
    @FXML private Label contactLabel;
    @FXML private TextArea aboutTextArea;

    @FXML
    public void initialize() {
        nameLabel.setText("Spice & Spoon Restaurant");
        addressLabel.setText("123 Food Street, Hyderabad, India");
        hoursLabel.setText("Mon-Sun: 10:00 AM - 11:00 PM");
        contactLabel.setText("+91-9876543210");
        aboutTextArea.setText("Welcome to Spice & Spoon, where tradition meets taste! "
            + "We serve a wide range of Indian, Chinese, and Continental dishes. "
            + "Our commitment is to provide high-quality food and excellent customer service.");
    }
}
