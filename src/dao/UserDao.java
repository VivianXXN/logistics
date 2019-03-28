package dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entity.User;

public class UserDao implements BaseDao<User>{
	
	private sqlHelper helper = new sqlHelper();

	public Integer insert(String[] params) {
		
		String s = "insert into User (account,password,type,REMOVE) values(?,MD5('123456'),?,0)";
		return helper.update(s,params);
	}

	public void update(String[] params) {
		String s = "update User set password=? "+"where id=?";
		helper.update(s,params);
	}
	
	@Override
	public List<User> deleteById(Integer id) {
		String s = "update User set REMOVE=1 "+"where id=?";
		String[] params = {id.toString()};
		helper.update(s, params);
		return null;
	}

	@Override
	public List<User> selectAll() {
		
		return null;
	}

	@Override
	public List<User> selectByName(String id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<User> selectByInf(String name, String password, Integer type) {
		
		String s = "select *from User "
				+ "where account = ? "
				+ "AND password = MD5(?)"
				+ "AND type = ?";
		String[] params = {name,password,type.toString()};	
		return selectDemo(s,params);
	}

	@Override
	public User selectById(Integer id) {
		String s = "select *from User "
				+ "where id = ?";
		String[] params = {id.toString()};
		List<User> list = selectDemo(s,params);
		if(list.isEmpty()){
			return null;
		}else{
			return list.get(0);
		}
	}
	
	private List<User> selectDemo(String s, String[] params){
		List<User> data = new ArrayList<User>();
		ResultSet rs = null;		
		try {
			rs = helper.query(s, params);											
			while(rs.next()) {
				User temp = new User();
				temp.setId(rs.getInt(1));
				temp.setAccount(rs.getString(2));
				temp.setPassword(rs.getString(3));
				temp.setType(rs.getInt(4));
				data.add(temp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			helper.close();
		}
		return data;
	}

	@Override
	public Integer insertBean(User bean) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateBean(User bean) {
		// TODO Auto-generated method stub
		
	}

}
