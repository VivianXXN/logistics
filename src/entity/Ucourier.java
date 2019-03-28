package entity;

public class Ucourier {
	Integer id;
	
	String name;
	
	String tel;
	
	User uId;

	public User getuId() {
		return uId;
	}

	public void setuId(User uId) {
		this.uId = uId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	
}
