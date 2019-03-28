package manager;

import java.util.List;

import dao.UcourierDao;
import dao.UmanagerDao;
import dao.UserDao;
import entity.Ucourier;
import entity.Umanager;
import entity.User;

public class UserManager implements BaseManager<Ucourier>{
	private UserDao userDao = new UserDao();
	private UmanagerDao umd = new UmanagerDao();
	private UcourierDao ud = new UcourierDao();
	@Override
	public List<Ucourier> selectAll(){
		List<Ucourier> a = ud.selectAll();
		return a;
	}
	
	@Override
	public List<Ucourier> selectByName(String name){
		List<Ucourier> a = ud.selectByName(name);
		return a;
	}


	@Override
	public List<Ucourier> deleteById(Integer id) {
		List<Ucourier> a = ud.deleteById(id);
		return a;
	}

	@Override
	public void insert(String[] params) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * Ìí¼Ó courier
	 */
	public void insertCourier(String name, String tel, String account) {
		String[] userParams = {account,"2"};
		Integer uId = userDao.insert(userParams);
		
		String[] CourierParams = {name,tel,uId.toString()};
		ud.insert(CourierParams);
	}
	
	@Override
	public void change(String[] params) {
		ud.update(params);
	}


	public List<User> selectByInf(String name,String password,Integer type){
		List<User> a = userDao.selectByInf(name,password,type);
		return a;
	}
	
	public Umanager managerLogin(User u) {
		return umd.selectByUId(u.getId());
	}
	
	public Ucourier courierLogin(User u) {
		return ud.selectByUId(u.getId());
	}

	
}
