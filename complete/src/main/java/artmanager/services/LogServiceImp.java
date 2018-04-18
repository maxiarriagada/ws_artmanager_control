package artmanager.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import artmanager.dto.Log;
import artmanager.repository.LogRepository;

@Service
@Transactional
public class LogServiceImp implements LogService {

	@Autowired
	LogRepository logRepository;

	@Override
	public Boolean save(Log log) {
		artmanager.entity.Log logEntity = new artmanager.entity.Log(log);
		logRepository.save(logEntity);
		return true;
	}

}
