package artmanager.controllers;

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
import artmanager.services.UserLogService;

@CrossOrigin
@RestController
@RequestMapping(value = "/session")
public class SessionControlController {

	@Autowired
	SessionService sessionService;

	@Autowired
	UserLogService userLogService;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<Response> login(@RequestBody User user) {

		Response response = null;

		try {
			
			SessionControl session = sessionService.get(user.getCompany());

			if (session != null) {
				// chequeo
				User userLog = userLogService.get(user);

				if (userLog != null) {// esta
					if (userLog.getLogoutdate() != null) {// no esta activo
						if (userLog.getImei() != null && userLog.getImei().equals(user.getImei())) {
							session.setActivesessions(session.getActivesessions() + 1);
							if (session.getActivesessions() <= session.getAllowedsessions()) {
								sessionService.updateActiveSession(session);
								userLogService.logLogin(user);
								response = Response.OK;
							} else {
								response = Response.EXCEEDED_SESSIONS;
							}
						} else if (userLog.getImei() == null) {
							session.setActivesessions(session.getActivesessions() + 1);
							if (session.getActivesessions() <= session.getAllowedsessions()) {
								sessionService.updateActiveSession(session);
								userLogService.logLogin(user);
								
								response = Response.OK;
							} else {
								response = Response.EXCEEDED_SESSIONS;
							}
						} else if (!userLog.getImei().equals(user.getImei())) {
							response = Response.INVALID_PHONE;
						}
					} else {
						response = Response.ACTIVE_SESSION;
					}

				} else {
					session.setActivesessions(session.getActivesessions() + 1);
					if (session.getActivesessions() <= session.getAllowedsessions()) {
						sessionService.updateActiveSession(session);
						userLogService.logLogin(user);
						response = Response.OK;
					} else {
						response = Response.EXCEEDED_SESSIONS;
					}
				}

			} else {
				response = Response.COMPANY_NOT_FOUND;
			}

		} catch (Exception ex) {
			System.out.println(ex);
		}

		return new ResponseEntity<Response>(response, HttpStatus.OK);

	}

	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public ResponseEntity<Boolean> logout(@RequestBody User user) {

		Boolean response = false;

		try {
			SessionControl session = sessionService.get(user.getCompany());
			if (session != null) {
				session.setActivesessions(session.getActivesessions() - 1);
				if (session.getActivesessions() >= 0) {
					sessionService.updateActiveSession(session);
					userLogService.logLogin(user);
					response = true;
				}
			}

		} catch (Exception ex) {
			System.out.println(ex);
		}
		return new ResponseEntity<Boolean>(response, HttpStatus.OK);

	}

}
