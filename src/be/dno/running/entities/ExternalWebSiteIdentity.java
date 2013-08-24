package be.dno.running.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.google.appengine.api.datastore.Key;

public class ExternalWebSiteIdentity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Key id;
	
	private ExternalWebSite externalWebSite;
	private String externalID;
	public ExternalWebSite getExternalWebSite() {
		return externalWebSite;
	}
	public void setExternalWebSite(ExternalWebSite externalWebSite) {
		this.externalWebSite = externalWebSite;
	}
	public String getExternalID() {
		return externalID;
	}
	public void setExternalID(String externalID) {
		this.externalID = externalID;
	}
	
}
