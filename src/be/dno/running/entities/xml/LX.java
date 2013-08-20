package be.dno.running.entities.xml;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("LX")
public class LX {
	
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

	public void setMaxRunCadence(String maxRunCadence) {
		this.maxRunCadence = maxRunCadence;
	}

	public String getAvgRunCadence() {
		return avgRunCadence;
	}

	public void setAvgRunCadence(String avgRunCadence) {
		this.avgRunCadence = avgRunCadence;
	}

	public String getAvgSpeed() {
		return avgSpeed;
	}

	public void setAvgSpeed(String avgSpeed) {
		this.avgSpeed = avgSpeed;
	}

	public String getSteps() {
		return steps;
	}

	public void setSteps(String steps) {
		this.steps = steps;
	}
	
	
}
