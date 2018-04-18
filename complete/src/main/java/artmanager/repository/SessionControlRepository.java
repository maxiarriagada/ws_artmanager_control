package artmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import artmanager.entity.SessionControl;


public interface SessionControlRepository extends JpaRepository<SessionControl, Long>{

	 @Query(value="SELECT * FROM session_control WHERE session_control.company=:company AND session_control.active=1", nativeQuery=true)
	 public SessionControl get(@Param("company") String company);
	 
	
	 
}
