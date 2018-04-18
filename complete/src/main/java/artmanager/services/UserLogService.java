package artmanager.services;

import artmanager.dto.User;


public interface UserLogService {
	
	public Boolean logLogin(User userLog);
	public Integer countActiveUsers(User user);
	public User userIsLog(User user);
	public User get(User user);

}
