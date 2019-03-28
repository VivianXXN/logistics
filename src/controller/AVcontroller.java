package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import manager.CargoManager;

public class AVcontroller {
	@FXML
	private Button bt1;
	@FXML
	private Button bt2;
	@FXML
	private TextField tf1;
	@FXML
	private TextField tf2;
	CargoManager cm = new CargoManager();
	@FXML
	public void add(ActionEvent event){
		String[] params = new String[2] ;
		params[0] = tf1.getText().trim();
		params[1] = tf2.getText().trim();	
		
		cm.insert(params);
		((Node)event.getSource()).getScene().getWindow().hide();
		
	}
	
	@FXML
	public void close(ActionEvent event){
		((Node)event.getSource()).getScene().getWindow().hide();
		
	}	
}
