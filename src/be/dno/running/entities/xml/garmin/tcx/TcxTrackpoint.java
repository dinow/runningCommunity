package be.dno.running.entities.xml.garmin.tcx;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("Trackpoint")
public class TcxTrackpoint {

	@XStreamAlias("Time")
	private String time;
	
	@XStreamAlias("Position")
	private TcxPosition position;
	
	@XStreamAlias("AltitudeMeters")
	private String altitudeMeters;
	
	@XStreamAlias("DistanceMeters")
	private String distanceMeters;
	
	@XStreamAlias("HeartRateBpm")
	private String heartRateBpm;
	
	@XStreamAlias("Extensions")
	private TcxExtensions extensions;

	public String getTime() {
		return time;
	}

	public TcxPosition getPosition() {
		return position;
	}

	public String getAltitudeMeters() {
		return altitudeMeters;
	}

	public String getDistanceMeters() {
		return distanceMeters;
	}

	public String getHeartRateBpm() {
		return heartRateBpm;
	}
}
