package controller;

import entity.Ucourier;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import manager.UserManager;

public class CCVcontroller{
	private Ucourier changeUser;
	@FXML
	private Button bt1;
	@FXML
	private Button bt2;
	@FXML
	private TextField tf1;
	@FXML
	private TextField tf2;
	UserManager um = new UserManager();
	
	@FXML
	public void change(ActionEvent event){
		String[] params = new String[3] ;
		params[0] = tf1.getText().trim();
		params[1] = tf2.getText().trim();
		params[2] = changeUser.getId().toString();
		
		um.change(params);
		((Node)event.getSource()).getScene().getWindow().hide();
		
	}
	@FXML
	public void close(ActionEvent event){
		((Node)event.getSource()).getScene().getWindow().hide();
		
	}

	public void setChangeCargo(Ucourier c) {
		this.changeUser = c;
		tf1.setText(c.getName());
		tf2.setText(c.getTel());
	}
}
