package entity;

import java.util.Date;

public class CargoLog {
	
	Integer id;
	
	Cargo cId;
	
	Integer numBefore;
	
	Integer numAfter;
	
	Umanager umId;
	
	Date time;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Cargo getcId() {
		return cId;
	}

	public void setcId(Cargo cId) {
		this.cId = cId;
	}

	public Integer getNumBefore() {
		return numBefore;
	}

	public void setNumBefore(Integer numBefore) {
		this.numBefore = numBefore;
	}

	public Integer getNumAfter() {
		return numAfter;
	}

	public void setNumAfter(Integer numAfter) {
		this.numAfter = numAfter;
	}

	public Umanager getUmId() {
		return umId;
	}

	public void setUmId(Umanager umId) {
		this.umId = umId;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

}
