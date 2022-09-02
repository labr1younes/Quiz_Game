package org.younes.quiz_game;
import java.io.IOException;
import java.sql.SQLException;

import org.sqlite.core.DB;

import io.github.palexdev.materialfx.controls.MFXButton;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class SettingsController {

	@FXML
    private MFXButton btnback;
	
	 @FXML
	 private MFXButton btnreset;


    @FXML
    void initialize() {
    	btnback.setRippleAnimateBackground(false);

    }

    private Stage stage ;
    private Scene scene ; 
    private AnchorPane root ; 
    
    @FXML
    void goback(ActionEvent event) throws IOException {

    	root = FXMLLoader.load(getClass().getResource("Main.fxml"));
    	stage = (Stage)((Node)event.getSource()).getScene().getWindow() ;
    	scene = new Scene(root);
    	stage.setScene(scene);
    	stage.show();
    	System.out.println("go back to main ");
    	
    }
    
    @FXML
    void resetdata(ActionEvent event) throws SQLException {
    	DBConnect.resetInitial();
    	
    }
    
}
