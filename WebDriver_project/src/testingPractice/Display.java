package testingPractice;

import javafx.collections.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.event.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

public class Display extends Application{
	Stage window;
	Scene scene;
	Button gButton, cButton;


	public static void main(String [] args){
		launch(args);
	}

	@SuppressWarnings("restriction")
@Override
	public void start (Stage primaryStage) throws Exception {
		window = primaryStage;
		window.setTitle("Testing");

		VBox center = new VBox(10);
		center.setAlignment(Pos.CENTER);
		
		Label title = new Label();
		title.setText("Lets start testing");
		title.setFont(Font.font("Times new Roman", FontWeight.BOLD, 20));

		gButton = new Button();
		gButton.setText("GO");
		gButton.setAlignment(Pos.CENTER);
		gButton.setPrefWidth(150);
		gButton.setPrefHeight(100);
        //Now start the test
		gButton.setOnAction(e -> {
			Exercise_3 exercise_3 = new Exercise_3();
		});

		cButton = new Button();
		cButton.setText("Cancel");
		cButton.setAlignment(Pos.CENTER);
		cButton.setPrefHeight(100);
		cButton.setPrefWidth(150);
		cButton.setOnAction(e -> window.close());
		
		center.getChildren().addAll(title, gButton, cButton);

		scene = new Scene(center, 600, 600);

		window.setScene(scene);
		window.show();

	}

}