package dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entity.Umanager;

public class UmanagerDao implements BaseDao<Umanager> {

	private sqlHelper helper = new sqlHelper();
	
	@Override
	public List<Umanager> deleteById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Umanager> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Umanager selectById(Integer id) {
		String s = "select * from Umanager where id = ?";
		String[] params = {id.toString()};
		List<Umanager> list = selectDemo(s,params);
		if(list.isEmpty()){
			return null;
		}else{
			return list.get(0);
		}
	}

	@Override
	public List<Umanager> selectByName(String id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Umanager selectByUId(Integer uId) {
		String s = "select * from Umanager where u_id = ?";
		String[] params = {uId.toString()};
		helper.query(s, params);
		List<Umanager> list = selectDemo(s,params);
		if(list.isEmpty()){
			return null;
		}else{
			return list.get(0);
		}
	}
	
	private List<Umanager> selectDemo(String s, String[] params){
		List<Umanager> data = new ArrayList<Umanager>();
		ResultSet rs = null;		
		try {
			rs = helper.query(s, params);											
			while(rs.next()) {
				Umanager temp = new Umanager();
				temp.setId(rs.getInt(1));
				temp.setName(rs.getString(2));
				int uId = rs.getInt(3);
				temp.setuId(new dao.UserDao().selectById(uId));
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
	public Integer insertBean(Umanager bean) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateBean(Umanager bean) {
		// TODO Auto-generated method stub
		
	}

}
