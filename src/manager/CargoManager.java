package manager;

import java.util.List;

import dao.CargoDao;
import entity.Cargo;

public class CargoManager implements BaseManager<Cargo>{
	private CargoDao cd = new CargoDao();
	@Override
	public List<Cargo> selectAll(){
		List<Cargo> a = cd.selectAll();
		return a;
	}
	
	@Override
	public List<Cargo> selectByName(String name){
		List<Cargo> a = cd.selectByName(name);
		return a;
	}


	@Override
	public List<Cargo> deleteById(Integer id) {
		List<Cargo> a = cd.deleteById(id);
		return a;
	}

	@Override
	public void insert(String[] params) {
		cd.insert(params);
	}
	
	@Override
	public void change(String[] params) {
		cd.update(params);
	}

}
