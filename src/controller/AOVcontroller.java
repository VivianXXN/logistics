package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import entity.Cargo;
import entity.Order;
import entityex.OrderEX;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import manager.OrderManager;

public class AOVcontroller implements Initializable{//ÒÑ¾­É¾³ý
	ObservableList<OrderEX> dataorder = null;            
	OrderManager om = new OrderManager();
	@FXML
	private TableColumn<?, ?> order_id;
	@FXML
	private TableColumn<?, ?> order_time;
	@FXML
	private TableColumn<?, ?> order_ctel;
	@FXML
	private TableColumn<?, ?> order_from;
	@FXML
	private TableColumn<?, ?> order_to;
	@FXML
	private TableColumn<?, ?> order_state;
	@FXML
	private TableView<OrderEX> tv_order;
	@FXML
	private TextField tf_orderid;
	@FXML
	private Button bt_select_order;
	@FXML
	private Button bt_add_order;
	@FXML
	private Button bt_change_order;
	@FXML
	private Button bt_delete_order;
	@FXML
	private Button bt_add_this;
	@FXML
	private Label cargolb;
	private Cargo addCargo;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		List<Order> list = om.selectAll();
		List<OrderEX> listex = new ArrayList<>();
		for(Order o : list) {
			listex.add(new OrderEX(o));
		}
		dataorder = FXCollections.observableList(listex);	
		order_id.setCellValueFactory(new PropertyValueFactory<>("id"));
		order_time.setCellValueFactory(new PropertyValueFactory<>("time"));
		order_ctel.setCellValueFactory(new PropertyValueFactory<>("tel"));
//		order_ctel.setCellValueFactory(new Callback<CellDataFeatures<Order, String>, ObservableValue<String>>() {
//			@Override
//			public ObservableValue<String> call(CellDataFeatures<Order, String> param) {
//				
//				return new ReadOnlyObjectWrapper<String>(param.getValue().getUcId().getTel());
//			}
//		});
		order_from.setCellValueFactory(new PropertyValueFactory<>("fromInf"));
		order_to.setCellValueFactory(new PropertyValueFactory<>("toInf"));
		order_state.setCellValueFactory(new PropertyValueFactory<>("orderState"));
		tv_order.setItems(dataorder);
		
	}
	
	@FXML
	public void addthis(ActionEvent event){
//		try {
//			
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
	}

	public void setAddCargo(Cargo addCargo) {
		this.addCargo = addCargo;
		cargolb.setText(addCargo.getName());
	}
	
}
