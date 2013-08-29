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
	private String userID;
	
	@Persistent
	private String googleUserName;
	
	@Persistent
	private String hfrUserName;
	
	//Liste des id pour GarminConnect, Strava, ...
	/*@ManyToOne(fetch=FetchType.EAGER)
	private List<ExternalWebSiteIdentity> externalWebSiteIdentities;*/
	
	/*@ManyToOne(fetch=FetchType.EAGER)
	private List<Challenge> completedChallenges;
	
	@ManyToOne(fetch=FetchType.EAGER)
	private List<Challenge> ongoingChallenges;
	
	@ManyToOne(fetch=FetchType.EAGER)
	private List<Badge> earnedBadges;*/
	
	private double poids;
	
	private double poidsSelonMoyenneHFR;
	
	private double pointure;
	
	private int taille;
	
	private char sexe;
	
	private double VMA;
	
	private double IMC;

	private double IMG;
	
	private Date dateNaissance;
	
	/*@ManyToOne(fetch=FetchType.EAGER)
	private List<Record> records;*/
	
	@Persistent
	private List<Long> activityIds;
	
	private double cuisse;
	
	private double mollet;
	
	private int fcRepos;
	
	private int fcMaxReele;
	
	private int fcMaxTheorique;
	

	public User() {
		super();
	}
	
	
	public double getPoids() {
		return poids;
	}


	public void setPoids(double poids) {
		this.poids = poids;
	}


	public double getPoidsSelonMoyenneHFR() {
		return poidsSelonMoyenneHFR;
	}


	public void setPoidsSelonMoyenneHFR(double poidsSelonMoyenneHFR) {
		this.poidsSelonMoyenneHFR = poidsSelonMoyenneHFR;
	}


	public double getPointure() {
		return pointure;
	}


	public void setPointure(double pointure) {
		this.pointure = pointure;
	}


	public int getTaille() {
		return taille;
	}


	public void setTaille(int taille) {
		this.taille = taille;
	}


	public char getSexe() {
		return sexe;
	}


	public void setSexe(char sexe) {
		this.sexe = sexe;
	}


	public double getVMA() {
		return VMA;
	}


	public void setVMA(double vMA) {
		VMA = vMA;
	}


	public double getIMC() {
		return IMC;
	}


	public void setIMC(double iMC) {
		IMC = iMC;
	}


	public double getIMG() {
		return IMG;
	}


	public void setIMG(double iMG) {
		IMG = iMG;
	}


	public Date getDateNaissance() {
		return dateNaissance;
	}


	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}


	public double getCuisse() {
		return cuisse;
	}


	public void setCuisse(double cuisse) {
		this.cuisse = cuisse;
	}


	public double getMollet() {
		return mollet;
	}


	public void setMollet(double mollet) {
		this.mollet = mollet;
	}


	public int getFcRepos() {
		return fcRepos;
	}


	public void setFcRepos(int fcRepos) {
		this.fcRepos = fcRepos;
	}


	public int getFcMaxReele() {
		return fcMaxReele;
	}


	public void setFcMaxReele(int fcMaxReele) {
		this.fcMaxReele = fcMaxReele;
	}


	public int getFcMaxTheorique() {
		return fcMaxTheorique;
	}


	public void setFcMaxTheorique(int fcMaxTheorique) {
		this.fcMaxTheorique = fcMaxTheorique;
	}


	public List<Long> getActivityIds() {
		return activityIds;
	}

	public void setActivityIds(List<Long> activityIds) {
		this.activityIds = activityIds;
	}

	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
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
		return "User [userID=" + userID + ", googleUserName=" + googleUserName
				+ "]";
	}
	
}
