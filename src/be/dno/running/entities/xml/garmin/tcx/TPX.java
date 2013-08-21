package be.dno.running.entities.xml.garmin.tcx;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("TPX")
public class TPX {
	@XStreamAlias("Speed")
	private String speed;
	
	@XStreamAlias("RunCadence")
	private String runCadence;

	public String getSpeed() {
		return speed;
	}

	public String getRunCadence() {
		return runCadence;
	}
}
