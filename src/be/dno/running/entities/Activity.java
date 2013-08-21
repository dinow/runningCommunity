package be.dno.running.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;



@PersistenceCapable
public class Activity implements Serializable {
	
	/**
	 * 
	 */
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
	private double averageDistanceForLapsBySameTime = -1;
	
	@Persistent
	private double maxDeviationSecondForLapsBySameDistance = -1;
	
	@Persistent
	private double maxDeviationDistanceForLapsBySameTime = -1;
	
	public Key getId() {
		return id;
	}
	
	public void setId(Key id) {
		this.id = id;
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
	
	public List<Lap> getLaps() {
		return laps;
	}
	public void setLaps(List<Lap> laps) {
		this.laps = laps;
	}
	public double getTotalTime() {
		return totalTime;
	}
	
	public String getTotalTimeStr() {
		long tempTotalTime = totalTime;
		long diff[] = new long[] { 0, 0, 0, 0 };
	    /* sec */diff[3] = (tempTotalTime >= 60 ? tempTotalTime % 60 : tempTotalTime);
	    /* min */diff[2] = (tempTotalTime = (tempTotalTime / 60)) >= 60 ? tempTotalTime % 60 : tempTotalTime;
	    /* hours */diff[1] = (tempTotalTime = (tempTotalTime / 60)) >= 24 ? tempTotalTime % 24 : tempTotalTime;
	    /* days */diff[0] = (tempTotalTime = (tempTotalTime / 24));

		
		return toDoubleDigit(diff[1])+":"+toDoubleDigit(diff[2])+":"+toDoubleDigit(diff[3]);
	}
	
	private static String toDoubleDigit(long digit){
		String s = digit + "";
		return (s.length() == 1) ? "0"+s : s;
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
	
	
	
	
}
