package manager;

import java.util.List;

public interface BaseManager<T> {
		
	public void insert(String[] params);
	
	public void change(String[] params);
	
	public List<T> deleteById(Integer id);
	
	public List<T> selectAll();
	
	public List<T> selectByName(String name);

}
