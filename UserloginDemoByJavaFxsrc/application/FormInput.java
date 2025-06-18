package application;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class FormInput extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Labels and Inputs
        Label userLabel = new Label("Username:");
        TextField usernameField = new TextField();

        Label passLabel = new Label("Password:");
        PasswordField passwordField = new PasswordField();

        Label emailLabel = new Label("Email:");
        TextField emailField = new TextField();

        Label phoneLabel = new Label("Phone Number:");
        TextField phoneField = new TextField();

        Label genderLabel = new Label("Gender:");
        RadioButton maleRadio = new RadioButton("Male");
        RadioButton femaleRadio = new RadioButton("Female");
        RadioButton otherRadio = new RadioButton("Other");

        ToggleGroup genderGroup = new ToggleGroup();
        maleRadio.setToggleGroup(genderGroup);
        femaleRadio.setToggleGroup(genderGroup);
        otherRadio.setToggleGroup(genderGroup);

        HBox genderBox = new HBox(10, maleRadio, femaleRadio, otherRadio);

        Button submitButton = new Button("Submit");

        // Layout
        GridPane grid = new GridPane();
        grid.setVgap(10);
        grid.setHgap(10);
        grid.setStyle("-fx-padding: 20;");

        grid.add(userLabel, 0, 0);
        grid.add(usernameField, 1, 0);
        grid.add(passLabel, 0, 1);
        grid.add(passwordField, 1, 1);
        grid.add(emailLabel, 0, 2);
        grid.add(emailField, 1, 2);
        grid.add(phoneLabel, 0, 3);
        grid.add(phoneField, 1, 3);
        grid.add(genderLabel, 0, 4);
        grid.add(genderBox, 1, 4);
        grid.add(submitButton, 1, 5);

        // Submit action
        submitButton.setOnAction(e -> {
            String username = usernameField.getText();
            String password = passwordField.getText();
            String email = emailField.getText();
            String phone = phoneField.getText();

            RadioButton selectedGender = (RadioButton) genderGroup.getSelectedToggle();
            String gender = (selectedGender != null) ? selectedGender.getText() : "Not selected";

            // Output in console or use Alert
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Form Submitted");
            alert.setHeaderText("User Details");
            alert.setContentText("Username: " + username + "\n" +
                                 "Password: " + password + "\n" +
                                 "Email: " + email + "\n" +
                                 "Phone: " + phone + "\n" +
                                 "Gender: " + gender);
            alert.showAndWait();
        });

        Scene scene = new Scene(grid, 400, 350);
        primaryStage.setTitle("User Registration Form");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

