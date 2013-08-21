package be.dno.running.entities.xml.garmin.tcx;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("Creator")
public class TcxBuild {
	@XStreamAlias("Version")
	private TcxVersion version;

	public TcxVersion getVersion() {
		return version;
	}

	@Override
	public String toString() {
		return "Build [version=" + version + "]";
	}

}
