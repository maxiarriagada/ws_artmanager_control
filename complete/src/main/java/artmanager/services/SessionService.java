package artmanager.services;

import artmanager.dto.SessionControl;

public interface SessionService {

	public SessionControl get(String company);
	public Boolean updateActiveSession(SessionControl session);
}
