package be.dno.running.entities;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class Record {
	
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.SEQUENCE)
	private Long id;
	
	@Persistent
	private int distanceInMeter;
	
	@Persistent
	private long timeInMs;
	
	@Persistent
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
	public Long getId() {
		return id;
	}
	
}
