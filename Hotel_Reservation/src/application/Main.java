package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Main extends Application{
	public static void main(String[] args) {
		launch(args);
	}
	@Override
	public void start(Stage stage)  {		
		Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("/sceneFxml/homePage.fxml"));
		
		Scene scene = new Scene(root);			
		scene.getStylesheets().add(getClass().getResource("/styleSheets/application.css").toExternalForm());
		stage.setScene(scene);
		Image icon = new Image("icon.jpeg");
		stage.setTitle("SHABAK's Inn");
		stage.setResizable(false);
		stage.getIcons().add(icon);
		stage.show();
		}catch (IOException e) {
			System.out.println(e);
		}		
	}
}
