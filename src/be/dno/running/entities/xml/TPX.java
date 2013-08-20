package be.dno.running.entities.xml;

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

	public void setSpeed(String speed) {
		this.speed = speed;
	}

	public String getRunCadence() {
		return runCadence;
	}

	public void setRunCadence(String runCadence) {
		this.runCadence = runCadence;
	}
	
	
}
