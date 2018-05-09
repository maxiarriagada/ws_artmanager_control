package artmanager.dto;

public class User {
	
	private Long id;
	private Long uid;
	private String name;
	private String lastname;
	private String email;
	private String phone;
	private String username;
	private String preventorname;
	private String password;
	private String imei;
	private String logindate;
	private String logoutdate;
	private String role;
	private String token;
	private Boolean isdelete;
	private String createdate;
	private String deletedate;
	private String company;
	
	private Response response;
	private String urlws;
	
	public User() {
		
	}
	
	public User(artmanager.entity.User user) {
		if(user!=null){
			if(user.getId()!=null){this.setId(user.getId());}
			if(user.getUid()!=null){this.setUid(user.getUid());}
			if(user.getName()!=null){this.setName(user.getName());}
			if(user.getLastname()!=null){this.setLastname(user.getLastname());}
			if(user.getEmail()!=null){this.setEmail(user.getEmail());}
			if(user.getPhone()!=null){this.setPhone(user.getPhone());}
			if(user.getUsername()!=null){this.setUsername(user.getUsername());}
			if(user.getPreventorname()!=null){this.setPreventorname(user.getPreventorname());}
			if(user.getPassword()!=null){this.setPassword(user.getPassword());}
			if(user.getImei()!=null){this.setImei(user.getImei());}
			if(user.getLogindate()!=null){this.setLogindate(user.getLogindate());}
			if(user.getLogoutdate()!=null){this.setLogoutdate(user.getLogoutdate());}
			if(user.getRole()!=null){this.setRole(user.getRole());}		
			if(user.getToken()!=null){this.setToken(user.getToken());}

			if(user.getCreatedate()!=null){this.setCreatedate(user.getCreatedate());}
			if(user.getDeletedate()!=null){this.setDeletedate(user.getDeletedate());}
			if(user.getIsdelete()!=null){this.setIsdelete(user.getIsdelete());}
			
			if(user.getCompany()!=null){this.setCompany(user.getCompany());}	
		}
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getUid() {
		return uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
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

	public String getPreventorname() {
		return preventorname;
	}

	public void setPreventorname(String preventorname) {
		this.preventorname = preventorname;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Boolean getIsdelete() {
		return isdelete;
	}

	public void setIsdelete(Boolean isdelete) {
		this.isdelete = isdelete;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getCreatedate() {
		return createdate;
	}

	public void setCreatedate(String createdate) {
		this.createdate = createdate;
	}

	public String getDeletedate() {
		return deletedate;
	}

	public void setDeletedate(String deletedate) {
		this.deletedate = deletedate;
	}

	public Response getResponse() {
		return response;
	}

	public void setResponse(Response response) {
		this.response = response;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getUrlws() {
		return urlws;
	}

	public void setUrlws(String urlws) {
		this.urlws = urlws;
	}
	
	

}
