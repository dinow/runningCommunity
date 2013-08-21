package be.dno.running.entities.xml.garmin.tcx;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("Version")
public class TcxVersion {
	@XStreamAlias("VersionMajor")
	private String versionMajor;
	
	@XStreamAlias("VersionMinor")
	private String versionMinor;
	
	@XStreamAlias("BuildMajor")
	private String buildMajor;
	
	@XStreamAlias("BuildMinor")
	private String buildMinor;

	public String getVersionMajor() {
		return versionMajor;
	}

	public String getVersionMinor() {
		return versionMinor;
	}

	public String getBuildMajor() {
		return buildMajor;
	}

	public String getBuildMinor() {
		return buildMinor;
	}

	@Override
	public String toString() {
		return "Version [versionMajor=" + versionMajor + ", versionMinor="
				+ versionMinor + ", buildMajor=" + buildMajor + ", buildMinor="
				+ buildMinor + "]";
	}
	
	
}
