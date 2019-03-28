package controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import entity.Cargo;
import entity.OrderInf;
import entityex.OrderEX;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import manager.OrderInfManager;

public class OIVcontroller implements Initializable {
	@FXML
	private TableColumn<?, ?> tc_cargo_name;
	@FXML
	private TableColumn<?, ?> tc_cargo_number;
	@FXML
	private TableView<Cargo> tv_order_inf;

	@FXML
	private Label lb_order_time;
	@FXML
	private Label lb_manager_name;
	@FXML
	private Label lb_courier_name;
	@FXML
	private Label lb_courier_tel;
	@FXML
	private Label lb_order_place1;
	@FXML
	private Label lb_order_place2;
	@FXML
	private Label lb_order_state;
	
	private OrderEX orderEX;
	private ObservableList<Cargo> dataCargo = null;
	private OrderInfManager oiMng = new OrderInfManager();

	public OrderEX getOrderEX() {
		return orderEX;
	}

	public void setOrderEX(OrderEX orderEX) {
		this.orderEX = orderEX;
		lb_order_time.setText(orderEX.getTime().toString());
		lb_manager_name.setText(orderEX.getUmName());
		lb_courier_name.setText(orderEX.getUcName());
		lb_courier_tel.setText(orderEX.getTel());
		lb_order_place1.setText(orderEX.getFromInf());
		lb_order_place2.setText(orderEX.getToInf());
		lb_order_state.setText(orderEX.getOrderState());
		
		Integer oId = orderEX.getId();
		List<OrderInf> oiList = oiMng.selectByOId(oId);
		List<Cargo> cList = new ArrayList<Cargo>();
		for(OrderInf oi : oiList) {
			Cargo c = new Cargo();
			c.setName(oi.getcId().getName());
			c.setNumber(oi.getNumber());
			cList.add(c);
		}
		dataCargo = FXCollections.observableList(cList);
		tv_order_inf.setItems(dataCargo);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		tc_cargo_name.setCellValueFactory(new PropertyValueFactory<>("name"));
		tc_cargo_number.setCellValueFactory(new PropertyValueFactory<>("number"));
	}
	
}
