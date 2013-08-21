package be.dno.running.entities.xml.garmin.tcx;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

@XStreamAlias("Lap")
public class TcxLap {
	
	@XStreamAlias("StartTime")
	@XStreamAsAttribute
	private String startTime;
	
	@XStreamAlias("TotalTimeSeconds")
	private String totalTimeSeconds;
	
	@XStreamAlias("DistanceMeters")
	private String distanceMeters;
	
	@XStreamAlias("MaximumSpeed")
	private String maximumSpeed;
	
	@XStreamAlias("Calories")
	private String calories;
	
	@XStreamAlias("AverageHeartRateBpm")
	private TcxValueString averageHeartRateBpm;
	
	@XStreamAlias("MaximumHeartRateBpm")
	private TcxValueString maximumHeartRateBpm;
	
	@XStreamAlias("Intensity")
	private String intensity;
	
	@XStreamAlias("TriggerMethod")
	private String triggerMethod;
	
	@XStreamAlias("Track")
	private TcxTrack track;
	
	@XStreamAlias("Extensions")
	private TcxExtensions extensions;
	
	
	
	public TcxTrack getTrack() {
		return track;
	}

	public TcxExtensions getExtensions() {
		return extensions;
	}
	
	public String getIntensity() {
		return intensity;
	}
	
	public String getTriggerMethod() {
		return triggerMethod;
	}
	
	public String getStartTime() {
		return startTime;
	}
	
	public String getTotalTimeSeconds() {
		return totalTimeSeconds;
	}
	
	public String getDistanceMeters() {
		return distanceMeters;
	}
	
	public String getMaximumSpeed() {
		return maximumSpeed;
	}
	public String getCalories() {
		return calories;
	}
	public String getAverageHeartRateBpm() {
		return averageHeartRateBpm == null ? "0" : averageHeartRateBpm.toString();
	}
	
	public String getMaximumHeartRateBpm() {
		return maximumHeartRateBpm == null ? "0" : maximumHeartRateBpm.toString();
	}
	
}
