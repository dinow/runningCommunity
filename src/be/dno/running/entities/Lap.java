package be.dno.running.entities;

import java.io.Serializable;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;

@PersistenceCapable
public class Lap implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4968183579101802958L;

	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Key id;
	
	@Persistent
	private String startTime;
	
	@Persistent
	private double distanceMeters;
	
	@Persistent
	private double totalTimeSeconds;
	
	@Persistent
	private double maximumSpeed;
	
	@Persistent
	private double calories;
	
	@Persistent
	private int averageHeartRateBpm;
	
	@Persistent
	private int maximumHeartRateBpm;

	public Key getId() {
		return id;
	}
	
	public void setId(Key id) {
		this.id = id;
	}
	
	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public double getMaximumSpeed() {
		return maximumSpeed;
	}

	public void setMaximumSpeed(double maximumSpeed) {
		this.maximumSpeed = maximumSpeed;
	}

	public double getCalories() {
		return calories;
	}

	public void setCalories(double calories) {
		this.calories = calories;
	}

	public int getAverageHeartRateBpm() {
		return averageHeartRateBpm;
	}

	public void setAverageHeartRateBpm(int averageHeartRateBpm) {
		this.averageHeartRateBpm = averageHeartRateBpm;
	}

	public int getMaximumHeartRateBpm() {
		return maximumHeartRateBpm;
	}

	public void setMaximumHeartRateBpm(int maximumHeartRateBpm) {
		this.maximumHeartRateBpm = maximumHeartRateBpm;
	}

	public double getTotalTimeSeconds() {
		return totalTimeSeconds;
	}

	public void setTotalTimeSeconds(double totalTimeSeconds) {
		this.totalTimeSeconds = totalTimeSeconds;
	}

	public double getDistanceMeters() {
		return distanceMeters;
	}

	public void setDistanceMeters(double distanceMeters) {
		this.distanceMeters = distanceMeters;
	}
	
	
}
