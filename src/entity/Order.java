package entity;

import java.util.Date;

public class Order {
	
	Integer id;
	
	Date time;
	
	Umanager umId;
	
	Ucourier ucId;
	
	String fromInf;
	
	String toInf;
	
	Integer state;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public Umanager getUmId() {
		return umId;
	}

	public void setUmId(Umanager umId) {
		this.umId = umId;
	}

	public Ucourier getUcId() {
		return ucId;
	}

	public void setUcId(Ucourier ucId) {
		this.ucId = ucId;
	}

	public String getFromInf() {
		return fromInf;
	}

	public void setFromInf(String fromInf) {
		this.fromInf = fromInf;
	}

	public String getToInf() {
		return toInf;
	}

	public void setToInf(String toInf) {
		this.toInf = toInf;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}
	
	
}
