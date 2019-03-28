package dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entity.Ucourier;
import entity.User;

public class UcourierDao implements BaseDao<Ucourier> {
	private String s0 = "Select * from Ucourier AS uc "
			+"join User AS u on uc.u_id = u.id "
			+"WHERE 1 = ? AND u.REMOVE != 1";
	private String[] param0 = {"1"};


	@Override
	public List<Ucourier> deleteById(Integer id) {
		Ucourier uc = selectById(id);
		dao.UserDao userDao = new dao.UserDao();
		if(uc != null){
			User user = userDao.selectById(uc.getuId().getId());
			userDao.deleteById(user.getId());
		}
		return selectAll();
	}

	@Override
	public List<Ucourier> selectAll() {
		return selectDemo(s0,param0);
	}

	@Override
	public List<Ucourier> selectByName(String name) {
		String s = "select * from Ucourier where name like ?";
		name = '%'+name+'%';
		String[] params = {name};		
		return selectDemo(s,params);
	}
	
	@Override
	public Ucourier selectById(Integer id) {
		String s = "select * from Ucourier where id = ?";
		String[] params = {id.toString()};
		List<Ucourier> list = selectDemo(s,params);
		if(list.isEmpty()){
			return null;
		}else{
			return list.get(0);
		}
	}

	public Integer insert(String[] params) {
		String s = "insert into Ucourier (name,tel,u_id) values(?,?,?)";
		return sqlHelper.update(s,params);
	}

	public void update(String[] params) {
		String s = "update Ucourier set name=?,tel=?"+"where id=?";
		sqlHelper.update(s,params);		
	}
	
	public Ucourier selectByUId(Integer uId) {
		String s = "select * from Ucourier where u_id = ?";
		String[] params = {uId.toString()};
		sqlHelper.query(s, params);
		List<Ucourier> list = selectDemo(s,params);
		if(list.isEmpty()){
			return null;
		}else{
			return list.get(0);
		}
	}
	
	private List<Ucourier> selectDemo(String s, String[] params){
		List<Ucourier> data = new ArrayList<Ucourier>();
		ResultSet rs = null;		
		try {
			rs = sqlHelper.query(s, params);											
			while(rs.next()) {
				Ucourier temp = new Ucourier();
				temp.setId(rs.getInt(1));
				temp.setName(rs.getString(2));
				temp.setTel(rs.getString(3));
				int uId = rs.getInt(4);
				temp.setuId(new dao.UserDao().selectById(uId));
				data.add(temp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			sqlHelper.close();
		}
		return data;
	}

	@Override
	public Integer insertBean(Ucourier bean) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateBean(Ucourier bean) {
		// TODO Auto-generated method stub
		
	}

	
	
}
