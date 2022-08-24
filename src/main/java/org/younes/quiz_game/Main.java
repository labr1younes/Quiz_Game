package org.younes.quiz_game;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application  {
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		try {
			AnchorPane root = FXMLLoader.load(getClass().getResource("Main.fxml"));
			Scene scene = new Scene(root,750,500);
//			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			primaryStage.setTitle("Quiz Game");
			primaryStage.setResizable(false);
			
//			DBConnect cnt = new DBConnect();
//			cnt.connect();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) {
		
		launch(args);
		System.out.println("Hello world .... ");

	}



}
