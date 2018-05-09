package artmanager.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SessionControl")
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
	@Column
	private String urlws;

	
	public SessionControl(){}
	
	public SessionControl(artmanager.dto.SessionControl session){
		if(session!=null){
			if(session.getActive()!=null){this.setActive(session.getActive());}
			if(session.getActivesessions()!=null){this.setActivesessions(session.getActivesessions());}
			if(session.getAllowedsessions()!=null){this.setAllowedsessions(session.getAllowedsessions());}
			if(session.getCompany()!=null){this.setCompany(session.getCompany());}
			if(session.getUrlws()!=null){this.setUrlws(session.getUrlws());}
		}
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

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

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public String getUrlws() {
		return urlws;
	}

	public void setUrlws(String urlws) {
		this.urlws = urlws;
	}
}
