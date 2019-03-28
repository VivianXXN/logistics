package dao;

import java.util.List;

public interface BaseDao<T> {
	
	public Integer insertBean(T bean);
	
	public void updateBean(T bean);
	
	public List<T> deleteById(Integer id);
	
	public List<T> selectAll();
	
	public T selectById(Integer id);
	
	public List<T> selectByName(String name);
}
