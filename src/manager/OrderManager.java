package manager;

import java.util.ArrayList;
import java.util.List;

import core.Constants;
import dao.CargoDao;
import dao.CargoLogDao;
import dao.OrderDao;
import dao.OrderInfDao;
import entity.Cargo;
import entity.CargoLog;
import entity.Order;
import entity.OrderInf;
import entity.Ucourier;
import entity.Umanager;
import entityex.OrderEX;

public class OrderManager implements BaseManager<Order>{
	private OrderDao orderDao = new OrderDao();
	private OrderInfDao orederInfDao = new OrderInfDao();
	private CargoDao cargoDao = new CargoDao();
	private CargoLogDao cargoLogDao = new CargoLogDao();
	@Override
	public void insert(String[] params) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void change(String[] params) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Order> deleteById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> selectAll() {
		List<Order> a = orderDao.selectAll();
		return a;
	}

	@Override
	public List<Order> selectByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<OrderEX> selectAllEX() {
		List<Order> list = selectAll();
		List<OrderEX> listex = new ArrayList<>();
		for(Order o : list) {
			listex.add(new OrderEX(o));
		}
		return listex;
	}
	
	public List<OrderEX> changeToEX(List<Order> list) {
		List<OrderEX> listex = new ArrayList<>();
		for(Order o : list) {
			listex.add(new OrderEX(o));
		}
		return listex;
	}

	public List<Order> selectBycourier(Ucourier user) {
		List<Order> a = orderDao.selectBycourier(user);
		return a;
	}
	
	public Integer insertOrder(List<OrderInf> orderInfList, Order bean) {
		Integer oId = orderDao.insertBean(bean);
		for(OrderInf oi : orderInfList){
			Order o = new Order();
			o.setId(oId);
			oi.setoId(o);
			orederInfDao.insertBean(oi);
			Cargo c = oi.getcId();
			Integer numBefore = c.getNumber();
			Integer numAfter = c.getNumber()-oi.getNumber();
			c.setNumber(numAfter);
			cargoDao.updateBean(c);
			CargoLog cl = new CargoLog();
			cl.setcId(c);
			cl.setNumBefore(numBefore);
			cl.setNumAfter(numAfter);
			cl.setUmId(bean.getUmId());
			cargoLogDao.insertBean(cl);
		}
		return oId;
	}
	
	public Integer confirmOrder(Integer id) {
		Order o = orderDao.selectById(id);
		if(o.getState() == Constants.ORDER_STATE_READY){
			orderDao.updateState(id, Constants.ORDER_STATE_ONWAY);
		}else if(o.getState() == Constants.ORDER_STATE_ONWAY) {
			orderDao.updateState(id, Constants.ORDER_STATE_SUCCESS);
		}
		return o.getId();
	}
	
	public Integer unConfirmOrder(Integer id) {
		Order o = orderDao.selectById(id);
		if(o.getState() == Constants.ORDER_STATE_READY || o.getState() == Constants.ORDER_STATE_ONWAY){
			orderDao.updateState(id, Constants.ORDER_STATE_FAIL);
			//TODO 将订单中的货物返回仓库
			List<OrderInf> oiList = orederInfDao.selectByOId(id);
			for(OrderInf oi : oiList) {
				Cargo c = oi.getcId();
				Integer numBefore = c.getNumber();
				Integer numAfter = c.getNumber()+oi.getNumber();
				c.setNumber(numAfter);
				cargoDao.updateBean(c);
				CargoLog cl = new CargoLog();
				cl.setcId(c);
				cl.setNumBefore(numBefore);
				cl.setNumAfter(numAfter);
				Umanager um = new Umanager();
				um.setId(2);
				cl.setUmId(um);
				cargoLogDao.insertBean(cl);
			}
		}
		return o.getId();
	}
	
}
