package application;

import java.util.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class LoginRegister extends LoginPage {
	private Stage stage;
	private Scene scene;
	private Parent root;
	@FXML
	private TextField isUsername,username,dob,mobileNumber,city,email;
	@FXML
	private PasswordField isPassword,password,confirmPassword;
	public Alert alert = new Alert(Alert.AlertType.NONE);
	public static HashMap<String,HashMap> customers = new HashMap<String,HashMap>();
	public HashMap<String,String> details = new HashMap<String,String>();
	public static String usn;
	
	public void register(ActionEvent event) throws Exception{ 
		alert.setAlertType(Alert.AlertType.WARNING);
		Optional<ButtonType> res;
		if(customers.containsKey(username.getText())) {
			alert.setTitle("Warning");
			alert.setContentText("Already an user\n do you want to login instead");			
			res = alert.showAndWait();
			try {
				if(res.get() == ButtonType.OK)
					this.gotoLoginPage(event);
				}catch(Exception e) {}
			return;
		}
		if(password.getText().equals(confirmPassword.getText())) {
			details.put("username",username.getText());
			details.put("mobileNumber",mobileNumber.getText());
			details.put("city",city.getText());
			details.put("email",email.getText());
			details.put("dob",dob.getText());
			details.put("password",password.getText());
			
			alert.setAlertType(Alert.AlertType.INFORMATION);
			alert.setTitle("Successfully registered");
			alert.setContentText("Successfully registered");
			customers.put(username.getText(),details);
			res = alert.showAndWait();
			try {
				if(res.get() == ButtonType.OK)
					this.gotoLoginPage(event);
			}catch(Exception e) {}
			return;
		}
		
		alert.setTitle("Warning");
		alert.setContentText("Passwords didn't match");
		System.out.println("password: "+password.getText()+" ConfirmPassword: "+
				confirmPassword.getText()+'\n');
		res = alert.showAndWait();
	}
	public void login(ActionEvent event) {
		try {
		alert.setAlertType(Alert.AlertType.WARNING);	
		if(!(customers.containsKey(isUsername.getText()))) {
			alert.setTitle("Invalid UserName");
			alert.setContentText("No user found");
			alert.showAndWait();
			return;
		}
		if(!(customers.get(isUsername.getText()).get("password").equals(isPassword.getText()))) {
			alert.setTitle("Invalid Password");
			alert.setContentText("password doesn't match");
			alert.showAndWait();
			return;
		}
		try {
			//Util.switchSceneTo(getClass(), event, "menu.fxml");
			alert.setAlertType(Alert.AlertType.INFORMATION);
			alert.setTitle("Welcome");
			Booking.UserName = Profile.txt = usn = History.usn = RateUs.usn = 
					isUsername.getText();		
			 
			
			alert.setContentText("Welcome to SHABAK's INN "+ isUsername.getText());
			alert.show();
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/sceneFxml/profile.fxml"));
			root = loader.load();
			Profile prof = loader.getController();
			prof.setProfile(usn);
			
			if(!History.map.containsKey(usn))
				History.map.put(usn, new ArrayList<String>());
			//System.out.println(History.map.entrySet().toString());
			
			stage =(Stage)((Node)event.getSource()).getScene().getWindow(); 
			scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("/styleSheets/application.css").toExternalForm());
			stage.setScene(scene); 
			stage.show(); 
			//Util.switchSceneTo(getClass(), event, "profile.fxml");
		} catch (Exception e) {

			System.out.println(e+"   in LoginRegister.java");
		}
		
		
	}
	
	catch(Exception e) {
		System.out.println(e);
	}
	}
}
