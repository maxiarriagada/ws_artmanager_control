package artmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import artmanager.entity.SessionControl;
import artmanager.entity.UserLog;

public interface UserLogRepository  extends JpaRepository<UserLog, Long>{
	
	
	 @Query(value="SELECT count(*) FROM user_log WHERE user_log.logindate is not null AND user_log.logoutdate is null AND user_log.id<>:id", nativeQuery=true)
	 public Integer countActiveUsers(@Param("id") Long id);
	 
	 @Query(value="SELECT * FROM user_log WHERE user_log.logindate is not null AND user_log.logoutdate is null AND user_log.id=:id", nativeQuery=true)
	 public UserLog userIsLog(@Param("id") Long id);
}
