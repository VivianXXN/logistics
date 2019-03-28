package entity;

public class OrderInf {
	
	Integer id;
	
	Order oId;
	
	Cargo cId;
	
	Integer number;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Order getoId() {
		return oId;
	}

	public void setoId(Order oId) {
		this.oId = oId;
	}

	public Cargo getcId() {
		return cId;
	}

	public void setcId(Cargo cId) {
		this.cId = cId;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

}
