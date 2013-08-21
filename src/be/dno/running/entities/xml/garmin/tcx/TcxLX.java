package be.dno.running.entities.xml.garmin.tcx;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("LX")
public class TcxLX {
	
	@XStreamAlias("MaxRunCadence")
	private String maxRunCadence;
	
	@XStreamAlias("AvgRunCadence")
	private String avgRunCadence;
	
	@XStreamAlias("AvgSpeed")
	private String avgSpeed;
	
	@XStreamAlias("Steps")
	private String steps;

	public String getMaxRunCadence() {
		return maxRunCadence;
	}

	public String getAvgRunCadence() {
		return avgRunCadence;
	}

	public String getAvgSpeed() {
		return avgSpeed;
	}

	public String getSteps() {
		return steps;
	}
}
