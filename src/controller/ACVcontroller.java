package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import manager.UserManager;

public class ACVcontroller {
	@FXML
	private Button bt1;
	@FXML
	private Button bt2;
	@FXML
	private TextField tf1;
	@FXML
	private TextField tf2;
	@FXML
	private TextField tf3;
	UserManager um = new UserManager();
	@FXML
	public void add(ActionEvent event){
		String name = tf1.getText().trim();
		String tel = tf2.getText().trim();
		String account = tf3.getText().trim();
		
		um.insertCourier(name, tel, account);
		((Node)event.getSource()).getScene().getWindow().hide();
		
	}
	
	@FXML
	public void close(ActionEvent event){
		((Node)event.getSource()).getScene().getWindow().hide();
		
	}	
}
