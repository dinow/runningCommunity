package be.dno.running.entities.xml.garmin.tcx;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("Creator")
public class TcxBuild {
	@XStreamAlias("Version")
	private TcxVersion version;

	@XStreamAlias("Type")
	private String type;
	
	@XStreamAlias("Time")
	private String time;
	
	@XStreamAlias("Builder")
	private String builder;
	
	public TcxVersion getVersion() {
		return version;
	}

	public String getType() {
		return type;
	}

	public String getTime() {
		return time;
	}

	public String getBuilder() {
		return builder;
	}

	

}
