package be.dno.running.entities.xml;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

@XStreamAlias("Lap")
public class Lap {
	
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
	private ValueString averageHeartRateBpm;
	
	@XStreamAlias("MaximumHeartRateBpm")
	private ValueString maximumHeartRateBpm;
	
	@XStreamAlias("Intensity")
	private String intensity;
	
	@XStreamAlias("TriggerMethod")
	private String triggerMethod;
	
	@XStreamAlias("Track")
	private Track track;
	
	@XStreamAlias("Extensions")
	private Extensions extensions;
	
	
	
	public Track getTrack() {
		return track;
	}

	public Extensions getExtensions() {
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
		return averageHeartRateBpm.toString();
	}
	
	public String getMaximumHeartRateBpm() {
		return maximumHeartRateBpm.toString();
	}
	
}
