package artmanager.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import artmanager.dto.User;
import artmanager.entity.UserLog;
import artmanager.repository.UserLogRepository;


@Service
@Transactional
public class UserLogServiceImp implements UserLogService{

	@Autowired
	UserLogRepository userLogRepository;
	
	
	@Override
	public Boolean logLogin(User user) {
		UserLog userLog = new UserLog(user);
		userLogRepository.save(userLog);
		return Boolean.TRUE;
	}


	@Override
	public Integer countActiveUsers(User user) {
		return userLogRepository.countActiveUsers(user.getId());
	}


	@Override
	public User userIsLog(User user) {
		UserLog userLog = userLogRepository.userIsLog(user.getId());
	
		User userDto = null;
		
		if (userLog!=null){
			userDto= new User(userLog);
		}
		return userDto;
	}


	@Override
	public User get(User user) {
		UserLog userLog = userLogRepository.findOne(user.getId());
		
		User userDto = null;
		
		if (userLog!=null){
			userDto= new User(userLog);
		}
		return userDto;
	}
	
	
	


}
