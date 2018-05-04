package artmanager.services;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import artmanager.dto.User;
import artmanager.repository.UserRepository;

@Service
@Transactional
public class UserServiceImp implements UserService {

	@Autowired
	UserRepository userRepository;

	@Override
	public User create(User object) {
		artmanager.entity.User user = new artmanager.entity.User(object);
		return  new User(userRepository.save(user));
	}

	@Override
	public Boolean delete(User object) {
		artmanager.entity.User user = new artmanager.entity.User(object);
		user.setIsdelete(Boolean.TRUE);
		userRepository.save(user);
		return Boolean.TRUE;
	
	}

	@Override
	public User update(User object) {
		artmanager.entity.User user = new artmanager.entity.User(object);
		user=userRepository.save(user);
		object.setId(user.getId());
		return object;
	}

	@Override
	public User get(Long id) {
		return new User(userRepository.getOne(id));
		
	}

	@Override
	public List<User> getAll() {		
		return this.userListEntityToDto(userRepository.findAll());
	}

	@Override
	public User login(User user) {
		//artmanager.entity.User userE = new artmanager.entity.User(user);
		return new User(userRepository.login(user.getUsername(), user.getPassword()));
	}

	@Override
	public Boolean logout(User user) {
		userRepository.logout(user.getLogoutdate(),user.getId());
		return Boolean.TRUE;
	}
	
	private List<artmanager.dto.User> userListEntityToDto(List<artmanager.entity.User> userList){
		List<artmanager.dto.User> userDtoList = new ArrayList<artmanager.dto.User> ();
		for (artmanager.entity.User userEntity : userList) {
			userDtoList.add(new User(userEntity));
		}
		return userDtoList;
		
	}

	@Override
	public User getByPreventorName(User user) {
		// TODO Auto-generated method stub
		return new User(userRepository.getByPreventorName(user.getPreventorname()));
	}

	@Override
	public User loginPreventor(User user) {
		// TODO Auto-generated method stub
		return new User(userRepository.loginPreventor(user.getPreventorname(), user.getPassword()));
	}

	@Override
	public List<User> getAllPreventors() {
		return this.userListEntityToDto(userRepository.getAllByRole("preventor"));
	}

	@Override
	public User getByUserName(User user) {
		return new User(userRepository.getByUserName(user.getUsername()));
	}

	

}