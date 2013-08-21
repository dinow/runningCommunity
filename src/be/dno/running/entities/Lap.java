package be.dno.running.entities;

public class Lap {
	private String startTime;
	private double distanceMeters;
	private double totalTimeSeconds;
	private double maximumSpeed;
	private double calories;
	private int averageHeartRateBpm;
	private int maximumHeartRateBpm;
	
	
	
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
