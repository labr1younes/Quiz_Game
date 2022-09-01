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
	    private boolean[] solvedarray ;
	    
	    @FXML
	    void initialize() {
	    	solvedarray = DBConnect.getLevelsolved();
	    	
	    	btnlvl02.setDisable(solvedarray[0]);btnlvl03.setDisable(solvedarray[1]);btnlvl04.setDisable(solvedarray[2]);
			btnlvl05.setDisable(solvedarray[3]);btnlvl06.setDisable(solvedarray[4]);btnlvl07.setDisable(solvedarray[5]);btnlvl08.setDisable(solvedarray[6]);
			btnlvl09.setDisable(solvedarray[7]);btnlvl10.setDisable(solvedarray[8]);btnlvl11.setDisable(solvedarray[9]);btnlvl12.setDisable(solvedarray[10]);
			btnlvl13.setDisable(solvedarray[11]);btnlvl14.setDisable(solvedarray[12]);btnlvl15.setDisable(solvedarray[13]);btnlvl16.setDisable(solvedarray[14]);
			btnlvl17.setDisable(solvedarray[15]);btnlvl18.setDisable(solvedarray[16]);btnlvl19.setDisable(solvedarray[17]);btnlvl20.setDisable(solvedarray[18]);
			btnlvl21.setDisable(solvedarray[19]);btnlvl22.setDisable(solvedarray[20]);btnlvl23.setDisable(solvedarray[21]);btnlvl24.setDisable(solvedarray[22]);
			btnlvl25.setDisable(solvedarray[23]);btnlvl26.setDisable(solvedarray[24]);btnlvl27.setDisable(solvedarray[25]);btnlvl28.setDisable(solvedarray[26]);
			btnlvl29.setDisable(solvedarray[27]);btnlvl30.setDisable(solvedarray[28]);btnlvl31.setDisable(solvedarray[29]);btnlvl32.setDisable(solvedarray[30]);
			btnlvl33.setDisable(solvedarray[31]);btnlvl34.setDisable(solvedarray[32]);btnlvl35.setDisable(solvedarray[33]);btnlvl36.setDisable(solvedarray[34]);

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
