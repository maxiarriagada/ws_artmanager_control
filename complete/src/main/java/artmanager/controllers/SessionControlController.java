package artmanager.controllers;

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
import artmanager.dto.User;
import artmanager.entity.SessionControl;
import artmanager.services.SessionService;
import artmanager.services.UserService;

@CrossOrigin
@RestController
@RequestMapping(value = "/session")
public class SessionControlController {

	@Autowired
	SessionService sessionService;

	@Autowired
	UserService userLogService;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<Response> login(@RequestBody User user) {

		Response response = null;

		
		return new ResponseEntity<Response>(response, HttpStatus.OK);

	}

	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public ResponseEntity<Boolean> logout(@RequestBody User user) {

		Boolean response = false;

	
		return new ResponseEntity<Boolean>(response, HttpStatus.OK);

	}
	

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<Response> create(@RequestBody SessionControl sessionControl) {

		Response response = null;

		try {
			
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return new ResponseEntity<Response>(response, HttpStatus.OK);

	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ResponseEntity<Response> update(@RequestBody SessionControl sessionControl) {

		Response response = null;

		try {
			
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return new ResponseEntity<Response>(response, HttpStatus.OK);

	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public ResponseEntity<Response> delete(@RequestBody SessionControl sessionControl) {

		Response response = null;

		try {
			
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return new ResponseEntity<Response>(response, HttpStatus.OK);

	}
	
	
	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	List<SessionControl> getAll() {
		System.out.println("getAll");
		return null;//userService.getAll();
	}

}
