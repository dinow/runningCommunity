package be.dno.running.entities;

import java.io.Serializable;
import java.util.Date;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;

import be.dno.running.helper.ConvertHelper;

@PersistenceCapable
public class Lap implements Serializable {
	
	private static final long serialVersionUID = 4968183579101802958L;

	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Key id;
	
	@Persistent
	private int number;
	
	@Persistent
	private Date startTime;
	
	@Persistent
	private double deviationTimeSeconds;
	
	@Persistent
	private double deviationMeters;

	@Persistent
	private String totalTime;

	@Persistent
	private String pace;

	@Persistent
	private double speed;

	@Persistent
	private double deviationTime;

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

	@Persistent
	private double kmHeureDiffAverageActivity;
	
	@Persistent
	private String timeDiffAverageActivity;
	
	public Lap() {
		super();
	}
	
	public double getKmHeureDiffAverageActivity() {
		return kmHeureDiffAverageActivity;
	}

	public void setKmHeureDiffAverageActivity(double kmHeureDiffAverageActivity) {
		this.kmHeureDiffAverageActivity = kmHeureDiffAverageActivity;
	}

	public String getTimeDiffAverageActivity() {
		return timeDiffAverageActivity;
	}



	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public void setTimeDiffAverageActivity(String timeDiffAverageActivity) {
		this.timeDiffAverageActivity = timeDiffAverageActivity;
	}

	public String getCss(){
		if (kmHeureDiffAverageActivity > 0.0) return "lapPositive";
		if (kmHeureDiffAverageActivity < 0.0) return "lapNegative";
		return "lapNeutral";
	}

	public Key getId() {
		return id;
	}
	
	public Date getStartTime() {
		return startTime;
	}
	
	public String getStrStartTime() {
		return ConvertHelper.dateToString(startTime);
	}

	public void setStartTime(Date startTime) {
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

	public double getDeviationTimeSeconds() {
		return deviationTimeSeconds;
	}

	public void setDeviationTimeSeconds(double deviationTimeSeconds) {
		this.deviationTimeSeconds = deviationTimeSeconds;
	}

	public String getTotalTime() {
		return totalTime;
	}

	public void setTotalTime(String totalTime) {
		this.totalTime = totalTime;
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

	public double getDeviationTime() {
		return deviationTime;
	}

	public void setDeviationTime(double deviationTime) {
		this.deviationTime = deviationTime;
	}

	public double getDeviationMeters() {
		return deviationMeters;
	}

	public void setDeviationMeters(double deviationMeters) {
		this.deviationMeters = deviationMeters;
	}

	@Override
	public String toString() {
		return "Lap [totalTime=" + totalTime + ", pace=" + pace
				+ ", distanceMeters=" + distanceMeters + ", totalTimeSeconds="
				+ totalTimeSeconds + "]";
	}

	
	
	
}
