package application;

import java.net.URL;
import java.util.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

public class History implements Initializable {
	@FXML
	private ListView<String> history;
	public static String usn;
	public String str;
	public static ArrayList<String> list = new ArrayList<String>();
	public static HashMap<String,ArrayList<String>> map = new HashMap<String,ArrayList<String>>();
	public void gotoMenu(ActionEvent event) {
		Util.switchSceneTo(getClass(), event, "menu.fxml");
	}

	public void setHistory(String txt) {
		 this.str = txt;
		 if(map.isEmpty() || !map.containsKey(usn))
			 map.put(usn,list);
		 map.get(usn).add(str);
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		if(str!=null)
			history.getItems().add(str);
	}
	public void load(ActionEvent event) {
			for(String s:map.get(usn)) 
				if(!history.getItems().contains(s))
					history.getItems().add(s);

	}
}
