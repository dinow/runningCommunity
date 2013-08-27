package be.dno.running.entities;

import java.util.Date;
import java.util.List;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class Challenge {
	
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.SEQUENCE)
	private Long id;
	
	@Persistent
	private String name;
	
	@Persistent
	private Date startDate;
	
	@Persistent
	private Date endDate;
	
	@Persistent
	private double distance;
	
	@Persistent
	private double elevation;
	
	@Persistent 
	private int seconds; //En plus de la distance, style faire sub 40 :o
	
	@Persistent
	private String criteria; //Style "plus de", "moins de", "au moins", "au plus", faire une liste
	
	@Persistent
	private String creatorId;
	
	@Persistent
	private List<Long> badgeIds;
	
	public Challenge(String creatorId){
		super();
		this.creatorId = creatorId;
	}
	
	public String getCriteria() {
		return criteria;
	}

	public void setCriteria(String criteria) {
		this.criteria = criteria;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public List<Long> getBadgeIds() {
		return badgeIds;
	}
	public void setBadgeIds(List<Long> badgeIds) {
		this.badgeIds = badgeIds;
	}
	
	public int getSeconds() {
		return seconds;
	}

	public void setSeconds(int seconds) {
		this.seconds = seconds;
	}

	public String getCreatorId() {
		return creatorId;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public double getDistance() {
		return distance;
	}
	public void setDistance(double distance) {
		this.distance = distance;
	}
	public double getElevation() {
		return elevation;
	}
	public void setElevation(double elevation) {
		this.elevation = elevation;
	}
	
	
	
}
