package artmanager.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="User")
public class User implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(unique=true)
	private Long uid;
	@Column
	private String name;
	@Column
	private String lastname;
	@Column
	private String email;
	@Column
	private String phone;
	@Column
	private String username;
	@Column(unique=true,nullable = true)
	private String preventorname;
	@Column
	private String password;
	@Column
	private String imei;
	@Column
	private String logindate;
	@Column
	private String logoutdate;
	@Column
	private String role;
	@Column
	private String token;
	@Column
	private Boolean isdelete;
	@Column
	private String createdate;
	@Column
	private String deletedate;
	@Column
	private String company;

	public Long getUid() {
		return uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}

	public User(){}
	
	public User(artmanager.dto.User user){
	
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

	public String getImei() {
		return imei;
	}

	public void setImei(String imei) {
		this.imei = imei;
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

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
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
}
