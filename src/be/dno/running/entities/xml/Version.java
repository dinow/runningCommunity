package be.dno.running.entities.xml;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("Version")
public class Version {
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

	public void setVersionMajor(String versionMajor) {
		this.versionMajor = versionMajor;
	}

	public String getVersionMinor() {
		return versionMinor;
	}

	public void setVersionMinor(String versionMinor) {
		this.versionMinor = versionMinor;
	}

	public String getBuildMajor() {
		return buildMajor;
	}

	public void setBuildMajor(String buildMajor) {
		this.buildMajor = buildMajor;
	}

	public String getBuildMinor() {
		return buildMinor;
	}

	public void setBuildMinor(String buildMinor) {
		this.buildMinor = buildMinor;
	}

	@Override
	public String toString() {
		return "Version [versionMajor=" + versionMajor + ", versionMinor="
				+ versionMinor + ", buildMajor=" + buildMajor + ", buildMinor="
				+ buildMinor + "]";
	}
	
	
}
