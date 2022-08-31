package org.younes.quiz_game;

import java.io.IOException;

import io.github.palexdev.materialfx.controls.MFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class LevelsController {

	    @FXML
	    private MFXButton btnlvl01;

	    @FXML
	    private MFXButton btnlvl02;

	    @FXML
	    private MFXButton btnlvl03;

	    @FXML
	    private MFXButton btnlvl04;

	    @FXML
	    private MFXButton btnlvl05;

	    @FXML
	    private MFXButton btnlvl06;

	    @FXML
	    private MFXButton btnlvl07;

	    @FXML
	    private MFXButton btnlvl08;

	    @FXML
	    private MFXButton btnlvl09;

	    @FXML
	    private MFXButton btnlvl10;

	    @FXML
	    private MFXButton btnlvl11;

	    @FXML
	    private MFXButton btnlvl12;

	    @FXML
	    private MFXButton btnlvl13;

	    @FXML
	    private MFXButton btnlvl14;

	    @FXML
	    private MFXButton btnlvl15;

	    @FXML
	    private MFXButton btnlvl16;

	    @FXML
	    private MFXButton btnlvl17;

	    @FXML
	    private MFXButton btnlvl18;

	    @FXML
	    private MFXButton btnlvl19;

	    @FXML
	    private MFXButton btnlvl20;

	    @FXML
	    private MFXButton btnlvl21;

	    @FXML
	    private MFXButton btnlvl22;

	    @FXML
	    private MFXButton btnlvl23;

	    @FXML
	    private MFXButton btnlvl24;

	    @FXML
	    private MFXButton btnlvl25;

	    @FXML
	    private MFXButton btnlvl26;

	    @FXML
	    private MFXButton btnlvl27;

	    @FXML
	    private MFXButton btnlvl28;

	    @FXML
	    private MFXButton btnlvl29;

	    @FXML
	    private MFXButton btnlvl30;

	    @FXML
	    private MFXButton btnlvl31;

	    @FXML
	    private MFXButton btnlvl32;

	    @FXML
	    private MFXButton btnlvl33;

	    @FXML
	    private MFXButton btnlvl34;

	    @FXML
	    private MFXButton btnlvl35;

	    @FXML
	    private MFXButton btnlvl36;
	    
	    @FXML
	    private MFXButton btnback ;
	      
	    private Stage stage ;
	    private Scene scene ; 
	    private AnchorPane root ;
	    
	    
	    @FXML
	    void initialize() {
    
	    	btnlvl02.setDisable(true);btnlvl03.setDisable(true);btnlvl04.setDisable(true);
			btnlvl05.setDisable(true);btnlvl06.setDisable(true);btnlvl07.setDisable(true);btnlvl08.setDisable(true);
			btnlvl09.setDisable(true);btnlvl10.setDisable(true);btnlvl11.setDisable(true);btnlvl12.setDisable(true);
			btnlvl13.setDisable(true);btnlvl14.setDisable(true);btnlvl15.setDisable(true);btnlvl16.setDisable(true);
			btnlvl17.setDisable(true);btnlvl18.setDisable(true);btnlvl19.setDisable(true);btnlvl20.setDisable(true);
			btnlvl21.setDisable(true);btnlvl22.setDisable(true);btnlvl23.setDisable(true);btnlvl24.setDisable(true);
			btnlvl25.setDisable(true);btnlvl26.setDisable(true);btnlvl27.setDisable(true);btnlvl28.setDisable(true);
			btnlvl29.setDisable(true);btnlvl30.setDisable(true);btnlvl31.setDisable(true);btnlvl32.setDisable(true);
			btnlvl33.setDisable(true);btnlvl34.setDisable(true);btnlvl35.setDisable(true);btnlvl36.setDisable(true);

	    }
	    
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
	    void openlevel(ActionEvent event) throws IOException {
	    	// we get the node that was clicked 
	    	// and we do casting to it 
	    	Object node = event.getSource();
	    	MFXButton b = (MFXButton)node;
	    	
	    	FXMLLoader loader = new FXMLLoader(getClass().getResource("Level.fxml"));
	    	root = loader.load();
	    	
	    	// create a LevelController object so we can open new 
	    	// window and setting specific things , like image , level name 
	    	// One Level.fxml , new data every time 
	    	LevelController levelcontroller = loader.getController();
	    	
	    	// I named the levels(id) buttons like this btnlvl01 , btnlvl02 ...
	    	// so i getting it back and putting it in the level name
	    	String lvlname = b.getId().substring(3);

	    	Level new_lvl = DBConnect.getLevelData(lvlname);
	    	
	    	levelcontroller.changelbllevel(new_lvl.getLevelname());  	
	    	levelcontroller.setimagelevel(new_lvl.getPhotodir());
	    	levelcontroller.new_lvl_data = new_lvl ;
	    	
	    	stage = (Stage)((Node)event.getSource()).getScene().getWindow() ;
	    	scene = new Scene(root);
	    	stage.setScene(scene);
	    	stage.show();
	    	
	   	    }
	    
}
