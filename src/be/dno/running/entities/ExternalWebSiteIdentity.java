package be.dno.running.entities;

public class ExternalWebSiteIdentity {
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
