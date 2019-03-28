package dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entity.CargoLog;

public class CargoLogDao implements BaseDao<CargoLog> {

	@Override
	public Integer insertBean(CargoLog bean) {
		String s = "insert into Cargo_Log (c_id,num_before,num_after,um_id,time)"
				+ " values (?,?,?,?,now())";
		String[] params = {
			bean.getcId().getId().toString(),
			bean.getNumBefore().toString(),
			bean.getNumAfter().toString(),
			bean.getUmId().getId().toString()
		};
		return sqlHelper.update(s, params);
	}

	@Override
	public void updateBean(CargoLog bean) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<CargoLog> deleteById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CargoLog> selectAll() {
		String s = "Select * from Cargo_Log where 1 = ?";
		String[] params = {"1"};
		return selectDemo(s,params);
	}

	@Override
	public CargoLog selectById(Integer id) {
		String s = "select * from Cargo_Log where id = ?";
		String[] params = {
			id.toString()
		};
		List<CargoLog> list = selectDemo(s,params);
		if(list.isEmpty()){
			return null;
		}else{
			return list.get(0);
		}
	}

	@Override
	public List<CargoLog> selectByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private List<CargoLog> selectDemo(String s, String[] params){
		List<CargoLog> data = new ArrayList<CargoLog>();
		ResultSet rs = null;		
		try {
			rs = sqlHelper.query(s, params);											
			while(rs.next()) {
				CargoLog temp = new CargoLog();
				temp.setId(rs.getInt("id"));
				temp.setcId(new CargoDao().selectById(rs.getInt("c_id")));
				temp.setNumBefore(rs.getInt("num_before"));
				temp.setNumAfter(rs.getInt("num_after"));
				temp.setUmId(new UmanagerDao().selectById(rs.getInt("um_id")));
				temp.setTime(rs.getDate("time"));
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
