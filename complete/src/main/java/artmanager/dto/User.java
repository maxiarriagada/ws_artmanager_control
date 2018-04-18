package artmanager.dto;

import artmanager.entity.UserLog;

public class User {
	
	private Long id;
	private String username="";
	private String password="";
	private String imei;
	private String statusText;
//	private Long uid;
	private String logindate;
	private String logoutdate;
	private String company;
	
	
	public User() {
		
	}
	
public User(UserLog user) {
	if(user!=null){
	this.setCompany(user.getCompany());
	this.setLogindate(user.getLogindate());
	this.setUsername(user.getUsername());
	this.setId(user.getId());
	this.setLogoutdate(user.getLogoutdate());
	this.setImei(user.getImei());
	}
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	/*public Long getUid() {
		return uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}*/

	
	public String getStatusText() {
		return statusText;
	}

	public void setStatusText(String statusText) {
		this.statusText = statusText;
	}

	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getImei() {
		return imei;
	}
	public void setImei(String imei) {
		this.imei = imei;
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
	
	

}
