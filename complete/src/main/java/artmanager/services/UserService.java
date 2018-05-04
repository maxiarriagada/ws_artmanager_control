package artmanager.services;

import java.util.List;

import artmanager.dto.User;

public interface UserService extends IService<User>{
	

	public User getByPreventorName(User user);
	public User getByUserName(User user);
	public User login(User user);
	public User loginPreventor(User user);
	public Boolean logout(User user);
	public List<User> getAllPreventors();
	
	
}
