package artmanager.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import artmanager.dto.User;

@Entity
@Table(name="UserLog")
public class UserLog implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column
	private Long id;
	@Column
	private String username;
	@Column
	private String logindate;
	@Column
	private String logoutdate;
	@Column 
	private String company;
	@Column 
	private String imei;
	
	public UserLog(){}
	
	public UserLog(User user){
		this.setCompany(user.getCompany());
		this.setLogindate(user.getLogindate());
		this.setUsername(user.getUsername());
		this.setId(user.getId());
		this.setLogoutdate(user.getLogoutdate());
		this.setImei(user.getImei());
	}
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getLogindate() {
		return logindate;
	}
	public void setLogindate(String logindate) {
		this.logindate = logindate;
	}
	public String getLogoutdate() {
		return logoutdate;
	}
	public void setLogoutdate(String logoutdate) {
		this.logoutdate = logoutdate;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}

	public String getImei() {
		return imei;
	}

	public void setImei(String imei) {
		this.imei = imei;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
