package be.dno.running.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.google.appengine.api.datastore.Key;

@Entity
public class Record {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Key id;
	
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
