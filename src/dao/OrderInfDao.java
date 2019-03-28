package dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entity.OrderInf;

public class OrderInfDao implements BaseDao<OrderInf>{
	@Override
	public Integer insertBean(OrderInf bean) {
		String s = "insert into Order_inf (o_id, c_id, number) "
				+ "values (?,?,?);";
		String[] params = {
				bean.getoId().getId().toString(),
				bean.getcId().getId().toString(),
				bean.getNumber().toString()
		};
		return sqlHelper.update(s, params);
	}

	@Override
	public void updateBean(OrderInf bean) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<OrderInf> deleteById(Integer id) {
		
		return null;
	}

	@Override
	public List<OrderInf> selectAll() {
		String s = "select * from Order_inf where 1 = ?";
		String[] params = {"1"};
		return selectDemo(s,params);
	}

	@Override
	public OrderInf selectById(Integer id) {
		String s = "select * from Order_inf where id = ?";
		String[] params = {id.toString()};
		List<OrderInf> list = selectDemo(s,params);
		if(list.isEmpty()){
			return null;
		}else{
			return list.get(0);
		}
	}

	@Override
	public List<OrderInf> selectByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<OrderInf> selectByOId(Integer oId) {
		String s = "select * from Order_inf where o_id = ?";
		String[] params = {oId.toString()};
		return selectDemo(s, params);
	}
	
	private List<OrderInf> selectDemo(String s, String[] params){
		List<OrderInf> data = new ArrayList<OrderInf>();
		ResultSet rs = null;		
		try {
			rs = sqlHelper.query(s, params);											
			while(rs.next()) {
				OrderInf temp = new OrderInf();
				temp.setId(rs.getInt("id"));
				temp.setoId(new OrderDao().selectById(rs.getInt("o_id")));
				temp.setcId(new CargoDao().selectById(rs.getInt("c_id")));
				temp.setNumber(rs.getInt("number"));
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
