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
		return track == null ? new TcxTrack() :track;
	}

	public TcxExtensions getExtensions() {
		return extensions == null ? new TcxExtensions() :extensions;
	}
	
	public String getIntensity() {
		return intensity == null ? "" : intensity;
	}
	
	public String getTriggerMethod() {
		return triggerMethod == null ? "" : triggerMethod;
	}
	
	public String getStartTime() {
		return startTime == null ? "" : startTime;
	}
	
	public String getTotalTimeSeconds() {
		return totalTimeSeconds == null ? "0.0" : totalTimeSeconds;
	}
	
	public String getDistanceMeters() {
		return distanceMeters == null ? "0.0" : distanceMeters;
	}
	
	public String getMaximumSpeed() {
		return maximumSpeed == null ? "0.0" : maximumSpeed;
	}
	public String getCalories() {
		return calories == null ? "0" : calories;
	}
	public String getAverageHeartRateBpm() {
		return averageHeartRateBpm == null ? "0" : averageHeartRateBpm.toString();
	}
	
	public String getMaximumHeartRateBpm() {
		return maximumHeartRateBpm == null ? "0" : maximumHeartRateBpm.toString();
	}
	
}
