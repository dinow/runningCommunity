package be.dno.running.entities;

import java.io.Serializable;

public class User implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1527601931838521296L;
	private String googleUserName;
	private String hfrUserName;
	
	public String getGoogleUserName() {
		return googleUserName;
	}
	public void setGoogleUserName(String googleUserName) {
		this.googleUserName = googleUserName;
	}
	public String getHfrUserName() {
		return hfrUserName;
	}
	public void setHfrUserName(String hfrUserName) {
		this.hfrUserName = hfrUserName;
	}
	
	
	
}
