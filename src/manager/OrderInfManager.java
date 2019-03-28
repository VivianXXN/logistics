package manager;

import java.util.List;

import dao.OrderInfDao;
import entity.OrderInf;

public class OrderInfManager implements BaseManager<OrderInf> {
	
	private OrderInfDao dao = new OrderInfDao();

	@Override
	public void insert(String[] params) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void change(String[] params) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<OrderInf> deleteById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderInf> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderInf> selectByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<OrderInf> selectByOId(Integer oId) {
		return dao.selectByOId(oId);
	}

}
