package be.dno.running.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import be.dno.running.helper.ConvertHelper;

@PersistenceCapable
public class Activity implements Serializable {
	
	private static final long serialVersionUID = -4239127223646826296L;

	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.SEQUENCE)
	private Long id;
	
	@Persistent
	private String userName;
	
	@Persistent
	private Date uploadDate;
	
	@Persistent 
	String userId;
	
	@Persistent
	private String name;
	
	@Persistent
	private String description;
	
	@Persistent
	private Date dateDebut;
	
	@Persistent
	private String pace;
	
	@Persistent
	private double speed;
	
	@Persistent
	private List<Lap> laps;
	
	@Persistent
	private List<Lap> lapsBySameDistance;
	
	@Persistent
	private List<Lap> lapsBySameTime;
	
	@Persistent
	private List<Lap> lapsBySplitDistance;
	
	@Persistent
	private long totalTime = -1;
	
	@Persistent
	private int averageBpm = -1;
	
	@Persistent
	private int maxBpm = -1;
	
	@Persistent
	private double elevationPositive = -1;
	
	@Persistent
	private int totalCalories = -1;
	
	@Persistent
	private double totalDistance = -1;	
	
	@Persistent
	private double averageSecondForLapsBySameDistance = -1;
	
	@Persistent
	private String averageTimeForLapsBySameDistance;
	
	@Persistent
	private double averageDistanceForLapsBySameTime = -1;
	
	@Persistent
	private double maxDeviationSecondForLapsBySameDistance = -1;
	
	@Persistent
	private double maxDeviationDistanceForLapsBySameTime = -1;

	@Persistent
	private String activityCategory;
	
	@Persistent
	private boolean activityPrivate;
	
	public Activity(String userId) {
		super();
		this.userId = userId;
	}
	
	public Date getUploadDate() {
		return uploadDate;
	}

	public void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	}

	public Activity() {
		super();
	}

	public boolean isActivityPrivate() {
		return activityPrivate;
	}

	public void setActivityPrivate(boolean activityPrivate) {
		this.activityPrivate = activityPrivate;
	}

	public String getActivityCategory() {
		return activityCategory;
	}

	public void setActivityCategory(String activityCategory) {
		this.activityCategory = activityCategory;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getDateDebut() {
		return dateDebut;
	}
	
	public String getStrDateDebut() {
		return ConvertHelper.dateToString(dateDebut);
	}
	
	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}
	
	public String getPace() {
		return pace;
	}
	public void setPace(String pace) {
		this.pace = pace;
	}
	public double getSpeed() {
		return speed;
	}
	public void setSpeed(double speed) {
		this.speed = speed;
	}
	
	public double getTotalTime() {
		return totalTime;
	}
	
	public String getTotalTimeStr() {
		return ConvertHelper.toPace(totalTime);
	}
	
	public void setTotalTime(double totalTime) {
		this.totalTime = Double.valueOf(totalTime).longValue();
	}
	public int getAverageBpm() {
		return averageBpm;
	}
	public void setAverageBpm(int averageBpm) {
		this.averageBpm = averageBpm;
	}
	public int getMaxBpm() {
		return maxBpm;
	}
	public void setMaxBpm(int maxBpm) {
		this.maxBpm = maxBpm;
	}
	public double getElevationPositive() {
		return elevationPositive;
	}
	public void setElevationPositive(double elevationPositive) {
		this.elevationPositive = elevationPositive;
	}
	public int getTotalCalories() {
		return totalCalories;
	}
	public void setTotalCalories(int totalCalories) {
		this.totalCalories = totalCalories;
	}
	public double getTotalDistance() {
		return totalDistance;
	}
	public void setTotalDistance(double totalDistance) {
		this.totalDistance = totalDistance;
	}
	public double getAverageSecondForLapsBySameDistance() {
		return averageSecondForLapsBySameDistance;
	}
	public void setAverageSecondForLapsBySameDistance(
			double averageSecondForLapsBySameDistance) {
		this.averageSecondForLapsBySameDistance = averageSecondForLapsBySameDistance;
	}
	public double getAverageDistanceForLapsBySameTime() {
		return averageDistanceForLapsBySameTime;
	}
	public void setAverageDistanceForLapsBySameTime(
			double averageDistanceForLapsBySameTime) {
		this.averageDistanceForLapsBySameTime = averageDistanceForLapsBySameTime;
	}
	public double getMaxDeviationSecondForLapsBySameDistance() {
		return maxDeviationSecondForLapsBySameDistance;
	}
	public void setMaxDeviationSecondForLapsBySameDistance(
			double maxDeviationSecondForLapsBySameDistance) {
		this.maxDeviationSecondForLapsBySameDistance = maxDeviationSecondForLapsBySameDistance;
	}
	public double getMaxDeviationDistanceForLapsBySameTime() {
		return maxDeviationDistanceForLapsBySameTime;
	}
	public void setMaxDeviationDistanceForLapsBySameTime(
			double maxDeviationDistanceForLapsBySameTime) {
		this.maxDeviationDistanceForLapsBySameTime = maxDeviationDistanceForLapsBySameTime;
	}

	public String getAverageTimeForLapsBySameDistance() {
		return averageTimeForLapsBySameDistance;
	}

	public void setAverageTimeForLapsBySameDistance(
			String averageTimeForLapsBySameDistance) {
		this.averageTimeForLapsBySameDistance = averageTimeForLapsBySameDistance;
	}

	public void setTotalTime(long totalTime) {
		this.totalTime = totalTime;
	}

	public Long getId() {
		return id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public List<Lap> getLaps() {
		return laps;
	}

	public void setLaps(List<Lap> laps) {
		this.laps = laps;
	}

	public List<Lap> getLapsBySameDistance() {
		return lapsBySameDistance;
	}

	public void setLapsBySameDistance(List<Lap> lapsBySameDistance) {
		this.lapsBySameDistance = lapsBySameDistance;
	}

	public List<Lap> getLapsBySameTime() {
		return lapsBySameTime;
	}

	public void setLapsBySameTime(List<Lap> lapsBySameTime) {
		this.lapsBySameTime = lapsBySameTime;
	}

	public List<Lap> getLapsBySplitDistance() {
		return lapsBySplitDistance;
	}

	public void setLapsBySplitDistance(List<Lap> lapsBySplitDistance) {
		this.lapsBySplitDistance = lapsBySplitDistance;
	}

	public String getUserid() {
		return userId;
	}

	public void setUserid(String userid) {
		this.userId = userid;
	}
	
}
