package org.younes.quiz_game;

import java.io.IOException;
import java.sql.SQLException;

import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.NodeOrientation;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
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
    void checkanswer(ActionEvent event) throws SQLException {
    	DBConnect.updateAttempts(new_lvl_data.id);
    	if (new_lvl_data.getSolution().equals(txtfieldanswer.getText())) {
    		DBConnect.updateSolved(new_lvl_data.id);
    		
    		Alert alert = new Alert(AlertType.INFORMATION);
    		alert.setTitle("إجابة صحيحة");
    		alert.setHeaderText(null);;
    		alert.getDialogPane().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
    		
    		alert.setContentText("احسنت احسنت اجابة صحيحة");
    		
    		if ((alert.showAndWait().get() == ButtonType.OK ))
				try {
					goback(event) ;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    		
    	} 
    	else txtfieldanswer.clear();
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
    	
    	lbllevel.setText("المستوى " + name.substring(3));
    	
    }
    
    public void setimagelevel(String name) {
    	Image image1 = new Image(getClass().getResourceAsStream("Photos\\"+name));
    	
    	imgvimage.setImage(image1);
    	
    }
    
}
