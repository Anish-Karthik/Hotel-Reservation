package application;

import java.io.IOException;
import java.util.HashMap;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Profile {

	@FXML
	private Label username,dob,mobileNumber,city,email;
	public static String txt;
	public Alert alert = new Alert(Alert.AlertType.NONE);
	public HashMap<String,String> details = new HashMap<String,String>();
	
	public void setProfile(String text) throws Exception {
		this.setDetails();
	}
	public void load(ActionEvent event) throws Exception {
		this.setDetails();
	}
	public void setDetails() {
		dob.setText((String) LoginRegister.customers.get(txt).get("dob"));
		mobileNumber.setText((String) LoginRegister.customers.get(txt).get("mobileNumber"));
		city.setText((String) LoginRegister.customers.get(txt).get("city"));
		email.setText((String) LoginRegister.customers.get(txt).get("email"));
		username.setText(txt);
		details.put("mobileNumber",mobileNumber.getText());
		details.put("city",city.getText());
		details.put("email",email.getText());
		details.put("dob",dob.getText());
		details.put("username",txt);
		details.put("password",(String)LoginRegister.customers.get(txt).get("password"));
	}
	public void gotoMenu(ActionEvent event) throws IOException {
		Util.switchSceneTo(getClass(), event, "menu.fxml");
	}
}
