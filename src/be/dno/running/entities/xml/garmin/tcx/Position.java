package be.dno.running.entities.xml.garmin.tcx;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("Position")
public class Position {
	@XStreamAlias("LatitudeDegrees")
	private String latitudeDegrees;
	
	@XStreamAlias("LongitudeDegrees")
	private String longitudeDegrees;

	public String getLatitudeDegrees() {
		return latitudeDegrees;
	}

	public String getLongitudeDegrees() {
		return longitudeDegrees;
	}
}
