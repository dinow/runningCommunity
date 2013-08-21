package be.dno.running.entities.xml.garmin.tcx;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("Creator")
public class Build {
	@XStreamAlias("Version")
	private Version version;

	public Version getVersion() {
		return version;
	}

	@Override
	public String toString() {
		return "Build [version=" + version + "]";
	}

}
