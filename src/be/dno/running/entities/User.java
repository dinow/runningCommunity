package be.dno.running.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class User implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1527601931838521296L;
	private String googleUserName;
	private String hfrUserName;
	//Liste des id pour GarminConnect, Strava, ...
	private List<ExternalWebSiteIdentity> externalWebSiteIdentities;
	private String localisation;
	private List<Challenge> completedChallenges;
	private List<Challenge> ongoingChallenges;
	private List<Badge> earnedBadges;
	private int poids;
	private int poidsSelonMoyenneHFR;
	private double pointure;
	private int taille;
	private char sexe;
	private double VMA;
	private double IMC;
	private double IMG;
	private Date dateNaissance;
	private List<Record> records;
	private double cuisse;
	private double mollet;
	private int fcRepos;
	private int fcMaxReele;
	private int fcMaxTheorique;
	
	
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
	public List<ExternalWebSiteIdentity> getExternalWebSiteIdentities() {
		return externalWebSiteIdentities;
	}
	public void setExternalWebSiteIdentities(
			List<ExternalWebSiteIdentity> externalWebSiteIdentities) {
		this.externalWebSiteIdentities = externalWebSiteIdentities;
	}
	public String getLocalisation() {
		return localisation;
	}
	public void setLocalisation(String localisation) {
		this.localisation = localisation;
	}
	public List<Challenge> getCompletedChallenges() {
		return completedChallenges;
	}
	public void setCompletedChallenges(List<Challenge> completedChallenges) {
		this.completedChallenges = completedChallenges;
	}
	public List<Challenge> getOngoingChallenges() {
		return ongoingChallenges;
	}
	public void setOngoingChallenges(List<Challenge> ongoingChallenges) {
		this.ongoingChallenges = ongoingChallenges;
	}
	public List<Badge> getEarnedBadges() {
		return earnedBadges;
	}
	public void setEarnedBadges(List<Badge> earnedBadges) {
		this.earnedBadges = earnedBadges;
	}
	public int getPoids() {
		return poids;
	}
	public void setPoids(int poids) {
		this.poids = poids;
	}
	public int getPoidsSelonMoyenneHFR() {
		return poidsSelonMoyenneHFR;
	}
	public void setPoidsSelonMoyenneHFR(int poidsSelonMoyenneHFR) {
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
	public List<Record> getRecords() {
		return records;
	}
	public void setRecords(List<Record> records) {
		this.records = records;
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
}
