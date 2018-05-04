package artmanager.services;

import java.util.List;

public interface IService<T>{
	
	public T create(T object);
	public Boolean delete(T object);
	public T update(T object);
	public T get(Long id);
	public List<T> getAll();
}
