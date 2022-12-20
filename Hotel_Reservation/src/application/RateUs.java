package application;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class RateUs implements Initializable {
	public static String usn;
	@FXML
	private ChoiceBox<String> ratings;
	@FXML
	private TextArea feedback;
	private String data[] = {"1","2","3","4","5"};
	@Override	
	public void initialize(URL arg0, ResourceBundle arg1) {
		ratings.getItems().addAll(data);
	}
	public void saveReview(ActionEvent event) {
		try {
			String r = ratings.getValue();
			String f = feedback.getText();
			String historyDetails = "Reviews: "+" Rating: "+r+" feedback: "+f;
			FXMLLoader loader = new FXMLLoader(getClass().getResource("history.fxml"));
			Parent root = loader.load();
			History hist = loader.getController();
			hist.setHistory(historyDetails);
			Stage stage =(Stage)((Node)event.getSource()).getScene().getWindow(); 
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			stage.setScene(scene); 
			stage.show();
		} catch (Exception e) {
			System.out.println(e);
		} 
	}
	public void gotoMenu(ActionEvent event) throws IOException {
		Util.switchSceneTo(getClass(), event, "menu.fxml");
	}
}
