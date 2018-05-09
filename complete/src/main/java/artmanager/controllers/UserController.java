package artmanager.controllers;

import java.text.DecimalFormat;

import java.time.LocalDateTime;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import artmanager.dto.Response;
import artmanager.dto.SessionControl;
import artmanager.dto.User;
import artmanager.services.SessionService;
import artmanager.services.UserService;
import artmanager.util.UtilBase64;

@CrossOrigin
@RestController
@RequestMapping(value = "/user")
public class UserController {

	@Autowired
	UserService userService;

	@Autowired
	SessionService sessionService;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<User> login(@RequestBody User user) {
		System.out.println("Login User: " + user.getUsername());
		User usersession = null;
		SessionControl session = null;
		Boolean loginSuccess = Boolean.FALSE;

		try {
			user.setPassword(UtilBase64.decode(user.getPassword()));

			if (user.getRole() != null && user.getRole().equals("preventor")) {

				user.setPreventorname(UtilBase64.decode(user.getPreventorname()));
				usersession = userService.getByPreventorName(user);
				session = sessionService.get(usersession.getCompany());
				

				if (usersession != null && usersession.getId() != null && usersession.getIsdelete()!=Boolean.TRUE) {
					if (usersession.getPassword() != null && usersession.getPassword().equals(user.getPassword())) {
						if (user.getImei().equals(usersession.getImei()) || usersession.getImei() == null
								|| user.getImei().equals('0')) {

							if (session != null && session.getCompany() != null) {
								if (session.getActivesessions() == null) {
									session.setActivesessions(0);
								}
								session.setActivesessions(session.getActivesessions() + 1);
								if (session.getActivesessions() <= session.getAllowedsessions()) {
									usersession.setImei(user.getImei());
									usersession.setLogindate(this.getCurrentDate());
									usersession.setUrlws(session.getUrlws());
									userService.create(usersession);
									sessionService.updateActiveSession(session);
									loginSuccess = Boolean.TRUE;
									
								} else {
									usersession.setResponse(Response.EXCEEDED_SESSIONS);
								}

							} else {
								usersession.setResponse(Response.COMPANY_NOT_FOUND);
							}

						} else {
							usersession.setResponse(Response.INVALID_PHONE);
						}
					} else {
						usersession.setResponse(Response.ERROR_PASSWORD);
					}
				} else {
					usersession.setResponse(Response.ERROR_USERNAME);
				}

			} else {
				user.setUsername(UtilBase64.decode(user.getUsername()));

				usersession = userService.getByUserName(user);
				// usersession = userService.login(user);
				if (usersession != null) {
					if (usersession.getUsername() != null && usersession.getIsdelete()!=Boolean.TRUE) {
						if (usersession.getPassword() != null && usersession.getPassword().equals(user.getPassword())) {
							usersession.setLogindate(this.getCurrentDate());
							userService.create(usersession);
							loginSuccess = Boolean.TRUE;
						} else {
							usersession.setResponse(Response.ERROR_PASSWORD);
						}
					} else {
						usersession.setResponse(Response.ERROR_USERNAME);
					}
				}

			}

			if (!loginSuccess) {
				usersession.setId(null);
				usersession.setImei(null);
				usersession.setUsername(null);
			}else{
				usersession.setResponse(Response.LOG_OK);
			}
			usersession.setPassword(null);
			
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return new ResponseEntity<User>(usersession, HttpStatus.OK);

	}

	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public ResponseEntity<Boolean> logOut(@RequestBody User user) {
		System.out.println("LogOut - userid: " + user.getId());
		try {

			user = userService.get(user.getId());
			if (user != null) {
				user.setLogoutdate(this.getCurrentDate());
				userService.create(user);
			}

			SessionControl session = null;

			session = sessionService.get(user.getCompany());
			if (session != null) {
				if (session.getActivesessions() == null) {
					session.setActivesessions(0);
				}
				session.setActivesessions(session.getActivesessions() - 1);
				if (session.getActivesessions() >= 0) {
					sessionService.updateActiveSession(session);
				}
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<Boolean>(Boolean.TRUE, HttpStatus.OK);

	}

	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	List<User> getAll() {
		System.out.println("getAll");
		return userService.getAll();
	}

	@RequestMapping(value = "/getAllPreventors", method = RequestMethod.GET)
	List<User> getAllPreventors() {
		System.out.println("getAllPreventors");
		List<User> preventors = userService.getAllPreventors();
		return preventors;
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<User> create(@RequestBody User user) {
		System.out.println("create");

		user.setCreatedate(this.getCurrentDate());
		user.setIsdelete(Boolean.FALSE);

		try {
			User userAux = userService.getByPreventorName(user);
			
			if (userAux==null || userAux.getId()==null) {
				user = userService.create(user);
				user.setResponse(Response.USER_CREATE_SUCCESS);
			} else {
				user.setResponse(Response.INVALID_PREVENTOR_NAME);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return new ResponseEntity<User>(user, HttpStatus.OK);

	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public ResponseEntity<User> update(@RequestBody User user) {
		System.out.println("update");
		User userdto = null;
		try {
			User userAux = userService.getByPreventorName(user);
			if(userAux.getId()==null || (userAux.getId()!=null && userAux.getId().equals(user.getId())) ){
				userdto = userService.update(user);
				userdto.setResponse(Response.USER_UPDATE_SUCCESS);
			}else{
				userdto= user;
				userdto.setId(null);
				userdto.setResponse(Response.INVALID_PREVENTOR_NAME);
			}
			

		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<User>(userdto, HttpStatus.OK);

	}
	
	
	@RequestMapping(value = "/changepassword", method = RequestMethod.PUT)
	public ResponseEntity<User> changepassword(@RequestBody User user) {
		System.out.println("changepassword");
		User userdto = null;
		try {
			if(user!=null && user.getId()!=null && user.getPassword()!=null){
				User userAux = userService.get(user.getId());
				
				if(userAux!=null && userAux.getId()!=null && userAux.getId().equals(user.getId())){
					userAux.setPassword(UtilBase64.decode(user.getPassword()));
					userdto = userService.update(userAux);
					userdto.setResponse(Response.USER_UPDATE_PASSWORD_SUCCESS);
				}else{
					userdto= user;
					userdto.setId(null);
					userdto.setResponse(Response.USER_UPDATE_PASSWORD_ERROR);
				}
			
			}else{
				userdto= user;
				userdto.setId(null);
				userdto.setResponse(Response.USER_UPDATE_PASSWORD_ERROR);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<User>(userdto, HttpStatus.OK);

	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public ResponseEntity<User> delete(@RequestBody User user) {
		System.out.println("DELETE");

		try {
			userService.delete(user);
			user.setResponse(Response.USER_DELETE_SUCCESS);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new ResponseEntity<User>(user, HttpStatus.OK);

	}

	@RequestMapping(value = "/checkpreventorname", method = RequestMethod.POST)
	public ResponseEntity<Response> checkpreventorname(@RequestBody User user) {
		System.out.println("checkpreventorname: " + user.getPreventorname());

		Response response = null;
		try {
			User userAux = userService.getByPreventorName(user);
			if (userAux != null) {
				response = Response.INVALID_PREVENTOR_NAME;
			} else {
				response = Response.VALID_PREVENTOR_NAME;
			}

		} catch (Exception ex) {
			System.out.println(ex);
		}
		return new ResponseEntity<Response>(response, HttpStatus.OK);

	}

	private String getCurrentDate() {
		LocalDateTime dateCreate = LocalDateTime.now();
		DecimalFormat mFormat = new DecimalFormat("00");
		System.out.println("mFormat " + mFormat.format(dateCreate.getMonthValue()));

		String currentDate = dateCreate.getYear() + "-" + mFormat.format(dateCreate.getMonthValue()) + "-"
				+ mFormat.format(dateCreate.getDayOfMonth()) + " " + mFormat.format(dateCreate.getHour()) + ":"
				+ mFormat.format(dateCreate.getMinute()) + ":" + mFormat.format(dateCreate.getSecond());
		return currentDate;
	}

}
