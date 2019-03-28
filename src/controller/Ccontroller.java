package controller;

import java.net.URL;
import java.util.ResourceBundle;

import entity.Order;
import entity.Ucourier;
import entityex.OrderEX;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TableView.TableViewSelectionModel;
import javafx.scene.control.cell.PropertyValueFactory;
import manager.OrderManager;
import session.UserLogin;

public class Ccontroller implements Initializable{
	ObservableList<OrderEX> datacourierorder = null;            
	OrderManager oMng = new OrderManager();
	@FXML
	private TableColumn<?, ?> courier_order_time;
	@FXML
	private TableColumn<?, ?> courier_order_to;
	@FXML
	private TableColumn<?, ?> courier_order_state;
	@FXML
	private TableView<OrderEX> tv_courier_order;
	@FXML
	private Button bt_affirm;
	@FXML
	private Button bt_fail;
	@FXML
	private Label courierlb;
	private UserLogin<Ucourier> ul;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		courier_order_time.setCellValueFactory(new PropertyValueFactory<>("time"));
		courier_order_to.setCellValueFactory(new PropertyValueFactory<>("toInf"));
		courier_order_state.setCellValueFactory(new PropertyValueFactory<>("orderState"));
	}
	
	public void setUl(UserLogin<Ucourier> ul) {
		this.ul = ul;
		courierlb.setText(ul.getUser().getName());
		datacourierorder = FXCollections.observableList(oMng.changeToEX(oMng.selectBycourier(ul.getUser())));	
		tv_courier_order.setItems(datacourierorder);
	}
	
	public int selectOne(TableView<?> tv){
		TableViewSelectionModel<?> temp = tv.getSelectionModel();
		int index = temp.getSelectedIndex();
		if(index == -1) {
			Alert a = new Alert(AlertType.WARNING);
			a.setTitle("警告");
			a.setHeaderText(null);
			a.setContentText("请选择一行");
			a.showAndWait();				
			return -1;
		}
		return index;
	}
	
	@FXML
	public void confirm() {
		int index = selectOne(tv_courier_order);
		if(index!=-1){
			Order o = datacourierorder.get(index);
			oMng.confirmOrder(o.getId());
			datacourierorder = FXCollections.observableList(oMng.changeToEX(oMng.selectBycourier(ul.getUser())));	
			tv_courier_order.setItems(datacourierorder);
		}
	}
	
	@FXML
	public void unConfirm() {
		int index = selectOne(tv_courier_order);
		if(index!=-1){
			Order o = datacourierorder.get(index);
			oMng.unConfirmOrder(o.getId());
			datacourierorder = FXCollections.observableList(oMng.changeToEX(oMng.selectBycourier(ul.getUser())));	
			tv_courier_order.setItems(datacourierorder);
		}
	}



	
}
