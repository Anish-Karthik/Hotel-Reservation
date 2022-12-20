package application;

import javafx.event.ActionEvent;

public class LoginPage {
	//Home
	public void gotoLoginPage(ActionEvent event) { 
		Util.switchSceneTo(getClass(), event, "login.fxml");
	} 
	public void gotoHomePage(ActionEvent event) { 		 
		Util.switchSceneTo(getClass(), event, "homePage.fxml");
	}
	public void gotoRegisterPage(ActionEvent event) {  
		Util.switchSceneTo(getClass(), event, "register.fxml");
	}
	public void gotoMenu(ActionEvent event) {
		Util.switchSceneTo(getClass(), event, "menu.fxml");
	}	 
	//Menu
 
	public void gotoProfile(ActionEvent event) {
		Util.switchSceneTo(getClass(), event, "profile.fxml");
	}
	public void gotoBookingMenu(ActionEvent event) {
		Util.switchSceneTo(getClass(), event, "bookingMenu.fxml");
	}
	public void gotoCancelRooms(ActionEvent event) {
		Util.switchSceneTo(getClass(), event, "cancelRoom.fxml");
	}
	public void gotoViewRoom(ActionEvent event) {
		Util.switchSceneTo(getClass(), event, "viewRoom.fxml"); 
	}
	public void gotoHistory(ActionEvent event) {
		Util.switchSceneTo(getClass(), event, "history.fxml"); 
	}	
	public void gotoRateUs(ActionEvent event) {
		Util.switchSceneTo(getClass(), event, "rateus.fxml"); 
	}
	
	//Rooms
	public void gotoCoupleRoom(ActionEvent event) {
		Util.switchSceneTo(getClass(), event, "coupleRoom.fxml"); 
	}
	public void gotoSingleRoom(ActionEvent event) {
		Util.switchSceneTo(getClass(), event, "singleRoom1.fxml");
	}
	public void gotoFamilyRoom(ActionEvent event) {
		Util.switchSceneTo(getClass(), event, "familyRoom.fxml");
	}
	public void gotoFriendsRoom(ActionEvent event) {
		Util.switchSceneTo(getClass(), event, "friendsRoom.fxml");
	}
	
	//Images
	public void gotoCoupleRoomImages(ActionEvent event) {
		Util.switchSceneTo(getClass(), event, "coupleRoomImages.fxml"); 
	}
	public void gotoSingleRoomImages(ActionEvent event) {
		Util.switchSceneTo(getClass(), event, "singleRoomImages.fxml");
	}
	public void gotoFamilyRoomImages(ActionEvent event) {
		Util.switchSceneTo(getClass(), event, "familyRoomImages.fxml");
	}
	public void gotoFriendsRoomImages(ActionEvent event) {
		Util.switchSceneTo(getClass(), event, "friendsRoomImages.fxml");
	}
}
