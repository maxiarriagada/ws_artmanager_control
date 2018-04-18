package artmanager.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Log")
public class Log implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column
	private String description;
	@Column
	private String date;
	@Column
	private String classname;
	@Column
	private String type;
	@Column
	private String username;
	@Column
	private Long userid;

	public Log() {
	}

	public Log(artmanager.dto.Log log) {
		if (log.getClassname() != null) {
			this.setClassname(log.getClassname());
		}
		if (log.getDate() != null) {
			this.setDate(log.getDate());
		}
		if (log.getDescription() != null) {
			this.setDescription(log.getDescription().toString().trim());
		}
		if (log.getType() != null) {
			this.setType(log.getType());
		}
		if (log.getUser() != null) {
			this.setUserid(log.getUser().getId());
			this.setUsername(log.getUser().getUsername());
		}

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getClassname() {
		return classname;
	}

	public void setClassname(String classname) {
		this.classname = classname;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Long getUserid() {
		return userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}

}
