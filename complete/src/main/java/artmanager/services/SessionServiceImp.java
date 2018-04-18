package artmanager.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import artmanager.entity.SessionControl;
import artmanager.repository.SessionControlRepository;

@Service
@Transactional
public class SessionServiceImp implements SessionService{
	
	
	@Autowired
	SessionControlRepository sessionControlRepository;
	
	public SessionControl get(String company) {
		return sessionControlRepository.get(company);
	}

	@Override
	public Boolean updateActiveSession(SessionControl session) {
		 sessionControlRepository.save(session);
		 return Boolean.TRUE;
	}
	
	

}
