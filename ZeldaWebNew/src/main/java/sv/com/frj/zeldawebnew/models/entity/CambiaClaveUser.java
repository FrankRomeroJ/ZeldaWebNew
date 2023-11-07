package sv.com.frj.zeldawebnew.models.entity;

import javax.persistence.Embeddable;


@Embeddable
public class CambiaClaveUser {
	
	


	
	
	private String passwordA;
	
	private String passwordN;
	
	private String passwordR;
	
	
	public CambiaClaveUser() {
	}
	
	

	public CambiaClaveUser( String passwordA, String passwordN, String passwordR) {
	
		this.passwordA = passwordA;
		this.passwordN = passwordN;
		this.passwordR = passwordR;
	}



	public String getPasswordA() {
		return passwordA;
	}


	public void setPasswordA(String passwordA) {
		this.passwordA = passwordA;
	}


	public String getPasswordN() {
		return passwordN;
	}


	public void setPasswordN(String passwordN) {
		this.passwordN = passwordN;
	}


	public String getPasswordR() {
		return passwordR;
	}


	public void setPasswordR(String passwordR) {
		this.passwordR = passwordR;
	}



	@Override
	public String toString() {
		return "CambiaClaveUser [passwordA=" + passwordA + ", passwordN=" + passwordN
				+ ", passwordR=" + passwordR + "]";
	}

	
}
