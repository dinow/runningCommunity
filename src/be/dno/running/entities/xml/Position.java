package be.dno.running.entities.xml;

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

	public void setLatitudeDegrees(String latitudeDegrees) {
		this.latitudeDegrees = latitudeDegrees;
	}

	public String getLongitudeDegrees() {
		return longitudeDegrees;
	}

	public void setLongitudeDegrees(String longitudeDegrees) {
		this.longitudeDegrees = longitudeDegrees;
	}
	
	
}
