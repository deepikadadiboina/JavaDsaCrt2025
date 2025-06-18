package application;


	import javafx.application.Application;
	import javafx.scene.Scene;
	import javafx.scene.control.*;
	import javafx.scene.layout.*;
	import javafx.stage.Stage;

	public class HelloApp extends Application {

	    @Override
	    public void start(Stage primaryStage) {
	        Label nameLabel = new Label("Enter your name:");
	        TextField nameField = new TextField();
	        Button submitButton = new Button("Submit");

	        VBox inputLayout = new VBox(10);
	        inputLayout.setStyle("-fx-padding: 20;");
	        inputLayout.getChildren().addAll(nameLabel, nameField, submitButton);
	        Scene scene1 = new Scene(inputLayout, 300, 200);

	        Label greetingLabel = new Label();
	        VBox greetingLayout = new VBox(10);
	        greetingLayout.setStyle("-fx-padding: 20;");
	        greetingLayout.getChildren().add(greetingLabel);
	        Scene scene2 = new Scene(greetingLayout, 300, 200);

	        submitButton.setOnAction(e -> {
	            String name = nameField.getText();
	            greetingLabel.setText("Hello, " + name + "!");
	            primaryStage.setScene(scene2);
	        });

	        primaryStage.setTitle("Welcome App");
	        primaryStage.setScene(scene1);
	        primaryStage.show();
	    }

	    public static void main(String[] args) {
	        launch(args);
	    }
	}



