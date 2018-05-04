package artmanager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import artmanager.entity.SessionControl;
import artmanager.entity.User;

public interface UserRepository  extends JpaRepository<User, Long>{
	
	
	@Query(value="SELECT * FROM user WHERE user.username=:username AND user.password=:password AND user.role<>'preventor'", nativeQuery=true)
	 public User login(@Param("username") String username,@Param("password") String password);
	 
	 
	 @Query(value="SELECT * FROM user WHERE user.preventorname=:preventorname AND user.password=:password AND user.role='preventor'", nativeQuery=true)
	 public User loginPreventor(@Param("preventorname") String preventorname,@Param("password") String password);
	 
	 @Query(value="UPDATE user SET user.logoutdate = :logoutdate WHERE user.id = :id", nativeQuery=true)
	 public void logout(@Param("logoutdate") String logoutdate, @Param("id") Long id);
	
	 @Query(value="SELECT count(*) FROM user WHERE user.logindate is not null AND user.logoutdate is null AND user.id<>:id", nativeQuery=true)
	 public Integer countActiveUsers(@Param("id") Long id);
	 
	 @Query(value="SELECT * FROM user WHERE user.logindate is not null AND user.logoutdate is null AND user.id=:id", nativeQuery=true)
	 public User userIsLog(@Param("id") Long id);
	 
	 @Query(value="SELECT * FROM user WHERE user.imei=:imei", nativeQuery=true)
	 public User getByImei(@Param("imei") String imei);
	 
	 @Query(value="SELECT * FROM user WHERE user.preventorname=:preventorname", nativeQuery=true)
	 public User getByPreventorName(@Param("preventorname") String preventorname);
	 
	 @Query(value="SELECT * FROM user WHERE user.username=:username", nativeQuery=true)
	 public User getByUserName(@Param("username") String username);
	 
	 
	 @Query(value="SELECT * FROM user WHERE user.role=:role and isdelete<>1 order by createdate desc", nativeQuery=true)
	 public List<User> getAllByRole(@Param("role") String role);
	 
	 
}
