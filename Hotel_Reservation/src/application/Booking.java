package application;

import java.time.format.*;
import java.util.*;
import java.time.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Booking extends LoginPage{
	public static HashMap<Integer,Integer> availableRooms = new HashMap<Integer,Integer>();
	@FXML
	private Label noOfRoomsSelected,price,available,cost;
	@FXML
	private TextField roomCount;
	@FXML
	private Label roomError,dateError;
	@FXML
	private DatePicker datePicker;
	//@FXML 
	//private ChoiceBox<String> TimePicker;
	int amt,count,avail;
	Optional<ButtonType> res;
	LocalDate today,date;
	String s;
	static String UserName;
	Alert alert;
	public HashMap<Integer,HashMap> bookings = new HashMap<Integer,HashMap>();
	
	public HashMap map = new HashMap();
	public static HashMap<String,Integer> bookingCount = new HashMap<String,Integer>();
	//private String[] timing = {"Morning","AfterNoon","Evening","Night"};
	public void book(ActionEvent event){
		try {
			res = java.util.Optional.empty();
			amt = Integer.parseInt(cost.getText());
			count = Integer.parseInt(roomCount.getText()); 
			//System.out.println(availableRooms.entrySet().toString());
			if(!availableRooms.containsKey(amt)) {
				initialize();
				//System.out.println(availableRooms.entrySet().toString());
			}
			available.setText(Integer.toString(availableRooms.get(amt)));
			avail = availableRooms.get(amt);
			if(!bookingCount.containsKey(UserName))
				bookingCount.put(UserName,0);
			
			noOfRoomsSelected.setText(Integer.toString(count));
			price.setText(Integer.toString(count*amt));
			today = LocalDate.now();
			date = datePicker.getValue();
			
			s = date.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
			alert = new Alert(Alert.AlertType.CONFIRMATION);	
			
			
			if(avail<count) {
				roomError.setText("Insufficient rooms");
			}else {
				roomError.setText(" ");
				if(date.compareTo(today)<0) {
					dateError.setText("Invalid Date");
				}
				else {
					dateError.setText(" ");
					alert.setContentText("noOfRoomsSelected : "+noOfRoomsSelected.getText()+
							"\nPrice :"+price.getText()+"\nCheck in date: "+s+
							"\n Click ok to pay");
					res = alert.showAndWait();
				}	
			}
			
			
			try {
				if(res.get() == ButtonType.OK) {
					alert.setAlertType(Alert.AlertType.INFORMATION);				
					alert.setContentText("Payment successful on Price :"+price.getText());
				    avail-=count;
					availableRooms.put(amt,avail);
					available.setText(Integer.toString(avail));
					String costs = price.getText();
					map.put("price", costs);
					map.put("date", date);
					map.put("count", count);
					switch(amt) {
						case 100:
						map.put("roomType", "single");break;
						case 200:
							map.put("roomType", "couple");break;
						case 250:
							map.put("roomType", "family");break;
						case 300:
							map.put("roomType", "friends");break;
					}
					
					String historyDetails = "Bookings: "+"Date: "+s+" roomType: "+map.get("roomType")+
							" count: "+map.get("count")+" price: "+map.get("price");
					FXMLLoader loader = new FXMLLoader(getClass().getResource("history.fxml"));
					Parent root = loader.load();
					History hist = loader.getController();
					hist.setHistory(historyDetails);
					Stage stage =(Stage)((Node)event.getSource()).getScene().getWindow(); 
					Scene scene = new Scene(root);
					scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
					stage.setScene(scene); 
					stage.show(); 
					
					//Util.switchSceneTo(getClass(), event, "menu.fxml");
					
				}
			}catch(Exception e) {
				System.out.println(e);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return;
	}

	public static void initialize() {
		availableRooms.put(100, 15);
		availableRooms.put(200, 15);
		availableRooms.put(250, 15);
		availableRooms.put(300, 15);
	}
	public void refresh(ActionEvent event) throws Exception{
		amt = Integer.parseInt(cost.getText());
		if(!availableRooms.containsKey(amt)) {
			initialize();
		}
		available.setText(Integer.toString(availableRooms.get(amt)));
		avail = availableRooms.get(amt);
	}

}
