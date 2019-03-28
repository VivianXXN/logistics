package dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entity.Cargo;


public class CargoDao implements BaseDao<Cargo> {
	private String s0 = "select*from Cargo where 1=?";
	private String[] param0 = {"1"};

	public Integer insert(String[] params) {
		String s = "insert into Cargo (name,number) values(?,?)";
		return sqlHelper.update(s,params);
	}

	public void update(String[] params) {
		String s = "update Cargo set name=?"+"where id=?";
		sqlHelper.update(s,params);		
	}

	@Override
	public Cargo selectById(Integer id) {
		String s = "select * from Cargo where id = ?";
		String[] params = {id.toString()};
		List<Cargo> list = selectDemo(s,params);
		if(list.isEmpty()){
			return null;
		}else{
			return list.get(0);
		}
	}

	@Override
	public Integer insertBean(Cargo bean) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateBean(Cargo bean) {
		String s = "update Cargo set name=?, number=?"+"where id=?";
		String[] params = {
			bean.getName(),
			bean.getNumber().toString(),
			bean.getId().toString()
		};
		sqlHelper.update(s,params);	
	}

	@Override
	public List<Cargo> deleteById(Integer id) {
		String s = "delete from Cargo where id = ?";
		String[] params = {id.toString()};
		sqlHelper.update(s, params);
		return selectAll();
	}

	@Override
	public List<Cargo> selectAll() {
		return selectDemo(s0, param0);
	}

	@Override
	public List<Cargo> selectByName(String name) {
		String s = "select * from Cargo where name like ?";
		name = '%'+name+'%';
		String[] params = {name};		
		return selectDemo(s,params);
	}
	
	private List<Cargo> selectDemo(String s, String[] params){
		List<Cargo> data = new ArrayList<Cargo>();
		ResultSet rs = null;		
		try {
			rs = sqlHelper.query(s, params);											
			while(rs.next()) {
				Cargo temp = new Cargo();
				temp.setId(rs.getInt("id"));
				temp.setName(rs.getString("name"));
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
