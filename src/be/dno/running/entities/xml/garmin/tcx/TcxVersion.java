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
		return versionMajor == null ? "" : versionMajor;
	}

	public String getVersionMinor() {
		return versionMinor == null ? "" : versionMinor;
	}

	public String getBuildMajor() {
		return buildMajor == null ? "" : buildMajor;
	}

	public String getBuildMinor() {
		return buildMinor == null ? "" : buildMinor;
	}

	@Override
	public String toString() {
		return "Version [versionMajor=" + getVersionMajor() + ", versionMinor="
				+ getVersionMinor() + ", buildMajor=" + getBuildMajor() + ", buildMinor="
				+ getBuildMinor() + "]";
	}
	
	
}
