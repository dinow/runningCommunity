package be.dno.running.entities;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class ExternalWebSiteIdentity {
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.SEQUENCE)
	private Long id;
	
	@Persistent
	private Long externalWebSiteId;
	
	@Persistent
	private String externalID;
	
	public Long getExternalWebSiteId() {
		return externalWebSiteId;
	}
	public void setExternalWebSiteId(Long externalWebSiteId) {
		this.externalWebSiteId = externalWebSiteId;
	}
	public Long getId() {
		return id;
	}
	public String getExternalID() {
		return externalID;
	}
	public void setExternalID(String externalID) {
		this.externalID = externalID;
	}
	
}
