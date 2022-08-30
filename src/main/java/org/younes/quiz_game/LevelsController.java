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
	    	btnback.setRippleAnimateBackground(false);
	    	btnlvl01.setRippleAnimateBackground(false);btnlvl02.setRippleAnimateBackground(false);btnlvl03.setRippleAnimateBackground(false);btnlvl04.setRippleAnimateBackground(false);
			btnlvl05.setRippleAnimateBackground(false);btnlvl06.setRippleAnimateBackground(false);btnlvl07.setRippleAnimateBackground(false);btnlvl08.setRippleAnimateBackground(false);
			btnlvl09.setRippleAnimateBackground(false);btnlvl10.setRippleAnimateBackground(false);btnlvl11.setRippleAnimateBackground(false);btnlvl12.setRippleAnimateBackground(false);
			btnlvl13.setRippleAnimateBackground(false);btnlvl14.setRippleAnimateBackground(false);btnlvl15.setRippleAnimateBackground(false);btnlvl16.setRippleAnimateBackground(false);
			btnlvl17.setRippleAnimateBackground(false);btnlvl18.setRippleAnimateBackground(false);btnlvl19.setRippleAnimateBackground(false);btnlvl20.setRippleAnimateBackground(false);
			btnlvl21.setRippleAnimateBackground(false);btnlvl22.setRippleAnimateBackground(false);btnlvl23.setRippleAnimateBackground(false);btnlvl24.setRippleAnimateBackground(false);
			btnlvl25.setRippleAnimateBackground(false);btnlvl26.setRippleAnimateBackground(false);btnlvl27.setRippleAnimateBackground(false);btnlvl28.setRippleAnimateBackground(false);
			btnlvl29.setRippleAnimateBackground(false);btnlvl30.setRippleAnimateBackground(false);btnlvl31.setRippleAnimateBackground(false);btnlvl32.setRippleAnimateBackground(false);
			btnlvl33.setRippleAnimateBackground(false);btnlvl34.setRippleAnimateBackground(false);btnlvl35.setRippleAnimateBackground(false);btnlvl36.setRippleAnimateBackground(false);
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
	    	// and we do "encapcilation" to it 
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
