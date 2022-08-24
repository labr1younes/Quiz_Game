package org.younes.quiz_game;


import java.io.IOException;

import io.github.palexdev.materialfx.controls.MFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
//import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MainController {
    @FXML
    private MFXButton btnLevels;

    @FXML
    private MFXButton btnSettings;
    
    private Stage stage ;
    private Scene scene ; 
    private AnchorPane root ; 
    
    @FXML
    void change2Levels(ActionEvent event) throws IOException {
    	 root = FXMLLoader.load(getClass().getResource("Levels.fxml"));
    	 stage = (Stage)((Node)event.getSource()).getScene().getWindow() ;
    	 scene = new Scene(root);
    	 stage.setScene(scene);
    	 stage.show();
    }

    @FXML
    void change2Settings(ActionEvent event) throws IOException {
    	root = FXMLLoader.load(getClass().getResource("Settings.fxml"));
   	 	stage = (Stage)((Node)event.getSource()).getScene().getWindow() ;
   	 	scene = new Scene(root);
   	 	stage.setScene(scene);
   	 	stage.show();
    }
}
