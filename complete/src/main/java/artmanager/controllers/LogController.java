package artmanager.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import artmanager.dto.Log;
import artmanager.services.LogService;

@CrossOrigin
@RestController
@RequestMapping(value = "/log")
public class LogController {

	@Autowired
	LogService logService;

	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public ResponseEntity<Boolean> logout(@RequestBody Log log) {

		Boolean response = false;

		try {
			logService.save(log);

		} catch (Exception ex) {
			System.out.println(ex);
		}
		return new ResponseEntity<Boolean>(response, HttpStatus.OK);

	}
}
