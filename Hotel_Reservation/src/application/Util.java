package application;

import java.io.IOException;

import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Util {
	public static void switchSceneTo(Class aClass,Event event,String s) {
		try {
			 Parent root= FXMLLoader.load(aClass.getResource("/sceneFxml/"+s)); 
			 Stage stage =(Stage)((Node)event.getSource()).getScene().getWindow(); 
			 Scene scene = new Scene(root);
			 scene.getStylesheets().add(aClass.getResource("/styleSheets/application.css").toExternalForm()); 
			 stage.setScene(scene); 
			 Image icon = new Image("icon.jpeg");
			 stage.setTitle("SHABAK's Inn");
			 stage.setResizable(false);
			 stage.getIcons().add(icon);
			 stage.show(); 
		}catch(IOException e) {}
	 }
	
}
