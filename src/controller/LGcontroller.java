package controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import entity.Ucourier;
import entity.Umanager;
import entity.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import manager.UserManager;
import session.UserLogin;

public class LGcontroller{
	UserManager um = new UserManager();
	@FXML
	private TextField tf1;
	@FXML
	private PasswordField pf1;
	@FXML
	private Button bt1;
	@FXML
	private TextField tf2;
	@FXML
	private PasswordField pf2;
	@FXML
	private Button bt2;
			
	@FXML
	public void MannagerLogin(ActionEvent event){
		String UserName = tf1.getText();
		String PassWord = pf1.getText();
		List<User> listUser = um.selectByInf(UserName, PassWord, 1);
		if(!listUser.isEmpty()){
			UserLogin<Umanager> ul = new UserLogin<Umanager>();
			ul.setUser(um.managerLogin(listUser.get(0)));
			try {
				Stage stage = new Stage();	
				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/ManagerOpr.fxml"));
				Parent root = fxmlLoader.load(); 
				Mcontroller mController = fxmlLoader.getController();
				mController.setUl(ul);
				Scene scene = new Scene(root,970,650);
				stage.setTitle("¹ÜÀíÔ±²Ù×÷");
				stage.setScene(scene);
				stage.show();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				((Node)event.getSource()).getScene().getWindow().hide();
		}else{
			Alert a = new Alert(AlertType.WARNING);
			a.setTitle("¾¯¸æ");
			a.setHeaderText(null);
			a.setContentText("µÇÂ¼Ê§°Ü");
			a.showAndWait();
		}
	}
	
	@FXML
	public void CourierLogin(ActionEvent event){
		String UserName = tf2.getText();
		String PassWord = pf2.getText();
		List<User> listUser = um.selectByInf(UserName, PassWord, 2);
		if(!listUser.isEmpty()){
			UserLogin<Ucourier> ul = new UserLogin<Ucourier>();
			ul.setUser(um.courierLogin(listUser.get(0)));
			try {
				Stage stage = new Stage();	
				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/CourierOpr.fxml"));
				Parent root = fxmlLoader.load(); 
				Ccontroller cController = fxmlLoader.getController();
				cController.setUl(ul);
				Scene scene = new Scene(root,252,368);
				stage.setTitle("ÅäËÍÔ±²Ù×÷");
				stage.setScene(scene);
				stage.show();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			((Node)event.getSource()).getScene().getWindow().hide();
		
		}else{
			Alert a = new Alert(AlertType.WARNING);
			a.setTitle("¾¯¸æ");
			a.setHeaderText(null);
			a.setContentText("µÇÂ¼Ê§°Ü");
			a.showAndWait();
		}
		
	}
	
}