package be.dno.running.entities;

public class Record {
	private int distanceInMeter;
	private long timeInMs;
	private String displayName;
	
	public String getDisplayName() {
		return displayName;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	public int getDistanceInMeter() {
		return distanceInMeter;
	}
	public void setDistanceInMeter(int distanceInMeter) {
		this.distanceInMeter = distanceInMeter;
	}
	public long getTimeInMs() {
		return timeInMs;
	}
	public void setTimeInMs(long timeInMs) {
		this.timeInMs = timeInMs;
	}
	
}
