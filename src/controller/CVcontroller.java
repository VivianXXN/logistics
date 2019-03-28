package controller;

import entity.Cargo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import manager.CargoManager;

public class CVcontroller{
	private Cargo changeCargo;
	@FXML
	private Button bt1;
	@FXML
	private Button bt2;
	@FXML
	private TextField tf1;
	CargoManager cm = new CargoManager();
	
	@FXML
	public void change(ActionEvent event){
		String[] params = new String[2] ;
		params[0] = tf1.getText().trim();
		params[1] = changeCargo.getId().toString();
		
		cm.change(params);
		((Node)event.getSource()).getScene().getWindow().hide();
		
	}
	@FXML
	public void close(ActionEvent event){
		((Node)event.getSource()).getScene().getWindow().hide();
		
	}

	public void setChangeCargo(Cargo changeCargo) {
		this.changeCargo = changeCargo;
		tf1.setText(changeCargo.getName());
	}
}
