package org.younes.quiz_game;

import java.io.IOException;

import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class LevelController {

    Level new_lvl_data  ;
    private Stage stage ;
    private Scene scene ; 
    private AnchorPane root ;
    
    @FXML
    private MFXButton btnback;

    @FXML
    private MFXButton btncheck;

    @FXML
    private ImageView imgvimage;

    @FXML
    private Label lbllevel;

    @FXML
    private MFXTextField txtfieldanswer;

    @FXML
    void initialize() {
    	btnback.setRippleAnimateBackground(false);btncheck.setRippleAnimateBackground(false);

    }
    
    @FXML
    void checkanswer(ActionEvent event) {
    	if (new_lvl_data.getSolution().equals(txtfieldanswer.getText())) {
    		DBConnect.updateSolved(new_lvl_data.id);
    		DBConnect.updateAttempts(new_lvl_data.id);
    		System.out.println("Answer coorect ");
    	} 
    	else System.out.println("Wrong answer ");
    }
    
    
    @FXML
    void goback(ActionEvent event) throws IOException {
    	root = FXMLLoader.load(getClass().getResource("Levels.fxml"));
    	stage = (Stage)((Node)event.getSource()).getScene().getWindow() ;
    	scene = new Scene(root);
    	stage.setScene(scene);
    	stage.show();

    	System.out.println("go back to levels ");
    }
    
    public void changelbllevel(String name) {
    	
    	lbllevel.setText(name);
    	
    }
    
    public void setimagelevel(String name) {
    	Image image1 = new Image(getClass().getResourceAsStream("Photos\\"+name));
    	
    	imgvimage.setImage(image1);
    	
    }
    
}
