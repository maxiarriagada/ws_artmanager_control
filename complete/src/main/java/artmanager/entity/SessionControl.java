package artmanager.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="SessionControl")
public class SessionControl implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column
	private String company;
	@Column
	private Integer activesessions;
	@Column
	private Integer allowedsessions;
	@Column
	private Boolean active;
	
	

	public Integer getActivesessions() {
		return activesessions;
	}
	public void setActivesessions(Integer activesessions) {
		this.activesessions = activesessions;
	}
	public Integer getAllowedsessions() {
		return allowedsessions;
	}
	public void setAllowedsessions(Integer allowedsessions) {
		this.allowedsessions = allowedsessions;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public Boolean getActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}
	
	
	
	
}
