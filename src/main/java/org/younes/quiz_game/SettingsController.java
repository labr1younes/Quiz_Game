package org.younes.quiz_game;
import java.io.IOException;
import java.sql.SQLException;

import io.github.palexdev.materialfx.controls.MFXButton;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.control.Label;

public class SettingsController {

	@FXML
    private MFXButton btnback;
	
	@FXML
	private MFXButton btnreset;

	@FXML
    private Label lblattemps;

	@FXML
	private Label lbloneattemp;

	@FXML
	private Label lblrestattemp;

	@FXML
	private Label lblsolvedlevels;

	@FXML
	private Label lbltwoattemps;
 
	 
    @FXML
    void initialize() {
    	btnback.setRippleAnimateBackground(false);
    	settinStatic();
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
    	settinStatic();
    }
    
    void settinStatic() {
    	int[] arr = DBConnect.getStatic();
    	
    	lblsolvedlevels.setText("36/"+arr[0]);
    	lbloneattemp.setText(""+arr[1]);
    	lbltwoattemps.setText(""+arr[2]);
    	lblrestattemp.setText(""+arr[3]);
    	lblattemps.setText(""+arr[4]);
    }
    
}
