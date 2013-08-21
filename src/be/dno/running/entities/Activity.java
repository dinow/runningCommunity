package be.dno.running.entities;

import java.io.Serializable;

public class Activity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8618949354798328756L;

	private String id;
	private String dateDebut;
	private String distance;
	private String time;
	private String pace;
	private String denivele;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDateDebut() {
		return dateDebut;
	}
	public void setDateDebut(String dateDebut) {
		this.dateDebut = dateDebut;
	}
	public String getDistance() {
		return distance;
	}
	public void setDistance(String distance) {
		this.distance = distance;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getPace() {
		return pace;
	}
	public void setPace(String pace) {
		this.pace = pace;
	}
	public String getDenivele() {
		return denivele;
	}
	public void setDenivele(String denivele) {
		this.denivele = denivele;
	}


}
