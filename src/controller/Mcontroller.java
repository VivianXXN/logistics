package controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import entity.Cargo;
import entity.Order;
import entity.OrderInf;
import entity.Ucourier;
import entity.Umanager;
import entityex.OrderEX;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TableView.TableViewSelectionModel;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import manager.CargoManager;
import manager.OrderManager;
import manager.UcourierManager;
import manager.UserManager;
import session.UserLogin;

public class Mcontroller implements Initializable  {
	//Tab1
	ObservableList<Cargo> datacargo = null;	
	CargoManager cm = new CargoManager();
	@FXML
	private TableColumn<?, ?> cargo_name;
	@FXML
	private TableColumn<?, ?> cargo_number;
	@FXML
	private TableView<Cargo> tv_cargo;
	@FXML
	private TextField tf_cargoname;
	@FXML
	private Button bt_select_cargo;
	@FXML
	private Button bt_add_cargo;
	@FXML
	private Button bt_change_cargo;
	@FXML
	private Button bt_add_order;
	@FXML
	private Button bt_delete_cargo;
	@FXML
	private TextField tf_cargo_num;
	
	
	//Tab2

	ObservableList<Ucourier> datauser = null;
	UserManager um = new UserManager();
	UserLogin<Umanager> ul;
	@FXML
	private Label managerlb;		
	@FXML
	private TableColumn<?, ?> courier_id;
	@FXML
	private TableColumn<?, ?> courier_name;
	@FXML
	private TableColumn<?, ?> courier_number;
	@FXML
	private TableView<Ucourier> tv_courier;
	@FXML
	private TextField tf_couriername;
	@FXML
	private Button bt_select_courier;
	@FXML
	private Button bt_add_courier;
	@FXML
	private Button bt_change_courier;
	@FXML
	private Button bt_delete_courier;
	
	
	//Tab3
	ObservableList<Cargo> dateOrderInf = null;
	UcourierManager ucManager = new UcourierManager();
	OrderManager oMng = new OrderManager();
	@FXML
	private TableColumn<?, ?> OrderCargo_name;
	@FXML
	private TableColumn<?, ?> OrderCargo_number;
	@FXML
	private TableColumn<?, ?> Courier_name;
	@FXML
	private TextArea place1;
	@FXML
	private TextArea place2;
	@FXML
	private TableView<Cargo> tv_OrderCargo;
	@FXML
	private TableView<Ucourier> tv_courier_name;
	@FXML
	private Button OrderCargo_affirm;
	@FXML
	private Button OrderCargo_delete;
	
	//Tab4
	ObservableList<OrderEX> dataOrder = null;
	@FXML
	private TableView<OrderEX> tv_order_Inf;
	@FXML
	private TableColumn<?, ?> tc_order_id;
	@FXML
	private TableColumn<?, ?> tc_order_time;
	@FXML
	private TableColumn<?, ?> tc_order_umname;
	@FXML
	private TableColumn<?, ?> tc_order_ucname;
	@FXML
	private TableColumn<?, ?> tc_order_place1;
	@FXML
	private TableColumn<?, ?> tc_order_place2;
	@FXML
	private TableColumn<?, ?> tc_order_state;
	@FXML
	private Button bt_order_view;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		//Tab1
		datacargo = FXCollections.observableList(cm.selectAll());	
		cargo_name.setCellValueFactory(new PropertyValueFactory<>("name"));
		cargo_number.setCellValueFactory(new PropertyValueFactory<>("number"));
		tv_cargo.setItems(datacargo);
		
		//Tab2
		datauser = FXCollections.observableList(um.selectAll());	
		courier_id.setCellValueFactory(new PropertyValueFactory<>("id"));
		courier_name.setCellValueFactory(new PropertyValueFactory<>("name"));
		courier_number.setCellValueFactory(new PropertyValueFactory<>("tel"));
		tv_courier.setItems(datauser);
		
		//Tab3
		OrderCargo_name.setCellValueFactory(new PropertyValueFactory<>("name"));
		OrderCargo_number.setCellValueFactory(new PropertyValueFactory<>("number"));
		tv_OrderCargo.setItems(dateOrderInf);
		Courier_name.setCellValueFactory(new PropertyValueFactory<>("name"));
		tv_courier_name.setItems(datauser);
		
		//Tab4
		tc_order_id.setCellValueFactory(new PropertyValueFactory<>("id"));
		tc_order_time.setCellValueFactory(new PropertyValueFactory<>("time"));
		tc_order_umname.setCellValueFactory(new PropertyValueFactory<>("umName"));
		tc_order_ucname.setCellValueFactory(new PropertyValueFactory<>("ucName"));
	
		tc_order_place1.setCellValueFactory(new PropertyValueFactory<>("fromInf"));
		tc_order_place2.setCellValueFactory(new PropertyValueFactory<>("toInf"));
		tc_order_state.setCellValueFactory(new PropertyValueFactory<>("orderState"));
		dataOrder = FXCollections.observableList(oMng.selectAllEX());
		tv_order_Inf.setItems(dataOrder);
		
	}
	
	//Tab1
	@FXML
	public void selectCargoByName(){
		String name = tf_cargoname.getText();
		datacargo = FXCollections.observableList(cm.selectByName(name));	
		tv_cargo.setItems(datacargo);
	}

	@FXML
	public void deleteCargo(){
		int index = selectOne(tv_cargo);
		if(index!=-1){
			Integer number = datacargo.get(index).getId();										
			datacargo = FXCollections.observableList(cm.deleteById(number));					
		}
		tv_cargo.setItems(datacargo);
	}
	

	@FXML
	public void addCargo(){
		try {
			Stage stage = new Stage();	
			Parent root = FXMLLoader.load(getClass().getResource("/view/addView.fxml")); 
			Scene scene = new Scene(root,335,194);
			stage.setTitle("添加");
			stage.setScene(scene);
			stage.showAndWait();
			datacargo = FXCollections.observableList(cm.selectAll());	
			tv_cargo.setItems(datacargo);		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	public void changeCargo(){
		try {
			int index = selectOne(tv_cargo);
			if(index!=-1){
				Cargo c = datacargo.get(index);	
				Stage stage = new Stage();	
				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/changeView.fxml"));
				Parent root = fxmlLoader.load(); 
				CVcontroller cmController = fxmlLoader.getController();
				cmController.setChangeCargo(c);
				Scene scene = new Scene(root,335,194);
				stage.setTitle("修改");
				stage.setScene(scene);
				stage.showAndWait();
				datacargo = FXCollections.observableList(cm.selectAll());	
				tv_cargo.setItems(datacargo);	
			}
				
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	Map<Integer,OrderInf> orderMap = new HashMap<Integer,OrderInf>();
	
	@FXML
	public void addOrder(){
		try {
			int index = selectOne(tv_cargo);
			if(index!=-1){
				OrderInf oi = new OrderInf();
				Cargo c = datacargo.get(index);	
				Integer number;
				try{
					number = Integer.parseInt(tf_cargo_num.getText());
					if(number<=0 || number >c.getNumber()){
						number = c.getNumber();
					}
				} catch (Exception e) {
					number = 0;
				}
				oi.setcId(c);
				oi.setNumber(number);
				OrderInf temp = orderMap.get(c.getId());
				if(temp == null){
					orderMap.put(c.getId(), oi);				
				}else if(number != 0){
					temp.setNumber(number);
				}
				List<Cargo> list = new ArrayList<Cargo>();
				for(OrderInf value : orderMap.values()) {
					Cargo co = new Cargo();
					co.setId(value.getcId().getId());
					co.setName(value.getcId().getName());
					co.setNumber(value.getNumber());
					list.add(co);
				}
				dateOrderInf = FXCollections.observableList(list);
				tv_OrderCargo.setItems(dateOrderInf);
			}
				
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//Tab2
	@FXML
	public void addUser(){
		try {
			Stage stage = new Stage();	
			Parent root = FXMLLoader.load(getClass().getResource("/view/addCourierView.fxml")); 
			Scene scene = new Scene(root,335,194);
			stage.setTitle("添加");
			stage.setScene(scene);
			stage.showAndWait();
			datauser = FXCollections.observableList(um.selectAll());	
			tv_courier.setItems(datauser);		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	public void selectUserByName(){
		String name = tf_couriername.getText();
		datauser = FXCollections.observableList(um.selectByName(name));	
		tv_courier.setItems(datauser);
		System.out.println(datauser.size());
	}
	
	@FXML
	public void deleteUser(){
		int index = selectOne(tv_courier);
		if(index!=-1){
			Integer number = datauser.get(index).getId();										
			datauser = FXCollections.observableList(um.deleteById(number));					
		}
		tv_courier.setItems(datauser);
	}
	
	@FXML
	public void changeUser(){
		try {
			int index = selectOne(tv_courier);
			if(index!=-1){
				Ucourier c = datauser.get(index);	
				Stage stage = new Stage();	
				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/ChangeCourierView.fxml"));
				Parent root = fxmlLoader.load(); 
				CCVcontroller ccvController = fxmlLoader.getController();
				ccvController.setChangeCargo(c);
				Scene scene = new Scene(root,335,194);
				stage.setTitle("修改");
				stage.setScene(scene);
				stage.showAndWait();
				datauser = FXCollections.observableList(um.selectAll());	
				tv_courier.setItems(datauser);	
			}
				
		} catch (Exception e) {
			e.printStackTrace();
		}
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

	public void setUl(UserLogin<Umanager> ul) {
		this.ul = ul;
		managerlb.setText(ul.getUser().getName());
	}	
	
	//Tab3
	@FXML
	public void	affirmOrder() {
		int index = selectOne(tv_courier_name);
		if(index!=-1){
			Order o = new Order();
			o.setFromInf(place1.getText());
			o.setToInf(place2.getText());
			o.setUmId(ul.getUser());
			Ucourier uc = datauser.get(index);										
			o.setUcId(uc);
			List<OrderInf> list = new ArrayList<OrderInf>();
			for(OrderInf value : orderMap.values()) {
				list.add(value);
			}
			oMng.insertOrder(list, o);
			orderMap.clear();
			datacargo = FXCollections.observableList(cm.selectAll());	
			tv_cargo.setItems(datacargo);
			dateOrderInf = FXCollections.observableList(new ArrayList<Cargo>());
			tv_OrderCargo.setItems(dateOrderInf);
			dataOrder = FXCollections.observableList(oMng.selectAllEX());
			tv_order_Inf.setItems(dataOrder);
		}
	}
	
	@FXML
	public void deleteOrderInf() {
		int index = selectOne(tv_OrderCargo);
		if(index!=-1){
			Cargo c = dateOrderInf.get(index);
			orderMap.remove(c.getId());
			List<Cargo> list = new ArrayList<Cargo>();
			for(OrderInf value : orderMap.values()) {
				Cargo co = new Cargo();
				co.setId(value.getcId().getId());
				co.setName(value.getcId().getName());
				co.setNumber(value.getNumber());
				list.add(co);
			}
			dateOrderInf = FXCollections.observableList(list);
			tv_OrderCargo.setItems(dateOrderInf);
		}
	}
	
	//Tab4
	@FXML
	public void viewOrderInf() {
		try {
			int index = selectOne(tv_order_Inf);
			if(index!=-1){
				OrderEX o = dataOrder.get(index);	
				Stage stage = new Stage();	
				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/OrderInfView.fxml"));
				Parent root = fxmlLoader.load(); 
				OIVcontroller oivController = fxmlLoader.getController();
				oivController.setOrderEX(o);
				Scene scene = new Scene(root,970,650);
				stage.setTitle("该订单详情");
				stage.setScene(scene);
				stage.showAndWait();	
			}
				
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
