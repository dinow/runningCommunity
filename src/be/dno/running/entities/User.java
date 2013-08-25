package be.dno.running.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class User implements Serializable{
	
	private static final long serialVersionUID = 1527601931838521296L;
	
	@PrimaryKey
	@Persistent
	private String id;
	
	@Persistent
	private String googleUserName;
	
	@Persistent
	private String hfrUserName;
	
	//Liste des id pour GarminConnect, Strava, ...
	/*@ManyToOne(fetch=FetchType.EAGER)
	private List<ExternalWebSiteIdentity> externalWebSiteIdentities;*/
	
	//private String localisation;
	
	/*@ManyToOne(fetch=FetchType.EAGER)
	private List<Challenge> completedChallenges;
	
	@ManyToOne(fetch=FetchType.EAGER)
	private List<Challenge> ongoingChallenges;
	
	@ManyToOne(fetch=FetchType.EAGER)
	private List<Badge> earnedBadges;*/
	
	/*private int poids;
	
	private int poidsSelonMoyenneHFR;
	
	private double pointure;
	
	private int taille;
	
	private char sexe;
	
	private double VMA;
	
	private double IMC;

	private double IMG;
	
	private Date dateNaissance;*/
	
	/*@ManyToOne(fetch=FetchType.EAGER)
	private List<Record> records;*/
	
	@Persistent
	private List<Long> activities;
	
	/*private double cuisse;
	
	private double mollet;
	
	private int fcRepos;
	
	private int fcMaxReele;
	
	private int fcMaxTheorique;*/
	

	public User() {
		super();
	}
	
	public List<Long> getActivities() {
		return activities;
	}
	public void setActivities(List<Long> activities) {
		this.activities = activities;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@Override
	public String toString() {
		return "User [userID=" + id + ", googleUserName=" + googleUserName
				+ "]";
	}
	
}
