package dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entity.Order;
import entity.Ucourier;

public class OrderDao implements BaseDao<Order> {

	@Override
	public Integer insertBean(Order bean) {
		String s = "insert into t_Order (time, um_id, uc_id, from_inf, to_inf, state) "
				+ "values (now(),?,?,?,?,0);";
		String[] params = {
			bean.getUmId().getId().toString(),
			bean.getUcId().getId().toString(),
			bean.getFromInf(),
			bean.getToInf()
		};
		return sqlHelper.update(s,params);
	}

	@Override
	public void updateBean(Order bean) {
		return;
	}
	
	public void updateState(Integer id, Integer state) {
		String s = "update t_Order set state = ? where id = ?";
		String[] params = {
				state.toString(),
				id.toString()
		};
		sqlHelper.update(s, params);
	}
	
	@Override
	public List<Order> deleteById(Integer id) {
		return null;
	}

	@Override
	public List<Order> selectAll() {
		String s0 = "Select * from t_Order where 1 = ?";
		String[] param0 = {"1"};
		return selectDemo(s0,param0);
	}

	@Override
	public Order selectById(Integer id) {
		String s = "select * from t_Order where id = ?";
		String[] params = {id.toString()};
		List<Order> list = selectDemo(s,params);
		if(list.isEmpty()){
			return null;
		}else{
			return list.get(0);
		}
	}

	@Override
	public List<Order> selectByName(String name) {
		String s = "select * from t_Order where name like ?";
		name = '%'+name+'%';
		String[] params = {name};		
		return selectDemo(s,params);
	}
	
	public List<Order> selectBycourier(Ucourier user) {
		String s = "select * from t_Order where uc_id = ?";
		String[] params = {user.getId().toString()};		
		return selectDemo(s,params);
	}
	
	private List<Order> selectDemo(String s, String[] params){
		List<Order> data = new ArrayList<Order>();
		ResultSet rs = null;		
		try {
			rs = sqlHelper.query(s, params);											
			while(rs.next()) {
				Order temp = new Order();
				temp.setId(rs.getInt("id"));
				temp.setTime(rs.getTimestamp("time"));
				temp.setUmId(new UmanagerDao().selectById(rs.getInt("um_id")));
				temp.setUcId(new UcourierDao().selectById(rs.getInt("uc_id")));
				temp.setFromInf(rs.getString("from_inf"));
				temp.setToInf(rs.getString("to_inf"));
				temp.setState(rs.getInt("state"));
				data.add(temp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			sqlHelper.close();
		}
		return data;
	}



}
