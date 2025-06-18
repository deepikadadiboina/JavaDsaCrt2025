package Application;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage stage) {
        TextField nameField = new TextField();
        nameField.setPromptText("Enter Name");

        TextField emailField = new TextField();
        emailField.setPromptText("Enter Email");

        Button submit = new Button("Add Student");

        submit.setOnAction(e -> {
            String name = nameField.getText();
            String email = emailField.getText();
            DBHandler.insertStudent(name, email);
        });

        VBox vbox = new VBox(10, nameField, emailField, submit);
        Scene scene = new Scene(vbox, 300, 200);
        stage.setScene(scene);
        stage.setTitle("Student App");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}

