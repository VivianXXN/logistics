package entityex;

import core.Constants;
import entity.Order;


public class OrderEX extends Order {

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getOrderState() {
		return orderState;
	}

	public void setOrderState(String orderState) {
		this.orderState = orderState;
	}

	private String tel;
	
	private String orderState;
	
	private String umName;
	
	private String ucName;
	
	public OrderEX(Order o){
		setId(o.getId());
		setTime(o.getTime());
		setUmId(o.getUmId());
		setUcId(o.getUcId());
		setFromInf(o.getFromInf());
		setToInf(o.getToInf());
		setState(o.getState());
		this.tel = o.getUcId().getTel();
		this.orderState = Constants.ORDER_STATE[o.getState()];
		this.umName = o.getUmId().getName();
		this.ucName = o.getUcId().getName();
	}

	public String getUmName() {
		return umName;
	}

	public void setUmName(String umName) {
		this.umName = umName;
	}

	public String getUcName() {
		return ucName;
	}

	public void setUcName(String ucName) {
		this.ucName = ucName;
	}
}
