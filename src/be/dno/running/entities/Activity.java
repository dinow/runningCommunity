package be.dno.running.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import be.dno.running.helper.ConvertHelper;

import com.google.appengine.api.datastore.Key;

@PersistenceCapable
public class Activity implements Serializable {
	
	private static final long serialVersionUID = -4239127223646826296L;

	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Key id;
	
	@Persistent
	private String name;
	
	@Persistent
	private String description;
	
	@Persistent
	private String dateDebut;
	
	@Persistent
	private String pace;
	
	@Persistent
	private double speed;
	
	@Persistent
	private List<Lap> laps = new ArrayList<Lap>();
	
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
	private List<Lap> lapsBySameDistance = null;
	
	@Persistent
	private List<Lap> lapsBySameTime = null;
	
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
		this.laps = new ArrayList<Lap>();
		this.lapsBySameDistance = new ArrayList<Lap>();
		this.lapsBySameTime = new ArrayList<Lap>();
	}
	
	public Activity() {
		super();
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

	public Key getId() {
		return id;
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
	public String getDateDebut() {
		return dateDebut;
	}
	public void setDateDebut(String dateDebut) {
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
	
	/*public List<Lap> getLaps() {
		return laps == null ? new ArrayList<Lap>() : laps;
	}
	public void setLaps(List<Lap> laps) {
		this.laps = laps;
	}*/
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
	
	/*public List<Lap> getLapsBySameDistance() {
		return lapsBySameDistance == null ? new ArrayList<Lap>() : lapsBySameDistance;
	}
	public void setLapsBySameDistance(List<Lap> lapsBySameDistance) {
		this.lapsBySameDistance = lapsBySameDistance;
	}
	public List<Lap> getLapsBySameTime() {
		return lapsBySameTime == null ? new ArrayList<Lap>() : lapsBySameTime;
	}
	public void setLapsBySameTime(List<Lap> lapsBySameTime) {
		this.lapsBySameTime = lapsBySameTime;
	}*/
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
	
	
	
	
}
