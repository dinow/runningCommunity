package be.dno.running.entities.xml;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("Trackpoint")
public class Trackpoint {

	@XStreamAlias("Time")
	private String time;
	
	@XStreamAlias("Position")
	private Position position;
	
	@XStreamAlias("AltitudeMeters")
	private String altitudeMeters;
	
	@XStreamAlias("DistanceMeters")
	private String distanceMeters;
	
	@XStreamAlias("HeartRateBpm")
	private String heartRateBpm;
	
	@XStreamAlias("Extensions")
	private Extensions extensions;

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public String getAltitudeMeters() {
		return altitudeMeters;
	}

	public void setAltitudeMeters(String altitudeMeters) {
		this.altitudeMeters = altitudeMeters;
	}

	public String getDistanceMeters() {
		return distanceMeters;
	}

	public void setDistanceMeters(String distanceMeters) {
		this.distanceMeters = distanceMeters;
	}

	public String getHeartRateBpm() {
		return heartRateBpm;
	}

	public void setHeartRateBpm(String heartRateBpm) {
		this.heartRateBpm = heartRateBpm;
	}
	
	
}
