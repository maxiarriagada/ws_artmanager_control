package artmanager.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class UserKey implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "imei", nullable = false)
    private String imei;

    @Column(name = "preventorname", nullable = false)
    private String preventorname;

    public UserKey(){}
    
	public String getImei() {
		return imei;
	}

	public void setImei(String imei) {
		this.imei = imei;
	}

	public String getPreventorname() {
		return preventorname;
	}

	public void setPreventorname(String preventorname) {
		this.preventorname = preventorname;
	}

}
