package manager;

import dao.UcourierDao;
import entity.Ucourier;

public class UcourierManager {
	
	UcourierDao ucourierDao = new UcourierDao();
	
	public Ucourier selectById(Integer id) {
		return ucourierDao.selectById(id);
	}

}
