package artmanager.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import artmanager.dto.SessionControl;
import artmanager.repository.SessionControlRepository;

@Service
@Transactional
public class SessionServiceImp implements SessionService{
	
	
	@Autowired
	SessionControlRepository sessionControlRepository;
	
	public SessionControl get(String company) {
		return new SessionControl(sessionControlRepository.get(company));
	}

	@Override
	public Boolean updateActiveSession(SessionControl session) {
		artmanager.entity.SessionControl sessionE = new artmanager.entity.SessionControl(session);
		 sessionControlRepository.save(sessionE);
		 return Boolean.TRUE;
	}
	
	

}
