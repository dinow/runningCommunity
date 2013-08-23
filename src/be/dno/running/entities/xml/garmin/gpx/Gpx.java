package be.dno.running.entities.xml.garmin.gpx;


import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("gpx")
public class Gpx {
	
	@XStreamAlias("metadata")
	private GpxMetadata metadata;
	
	@XStreamAlias("trk")
	private GpxTrk trk;
	
	public GpxMetadata getMetadata() {
		return metadata == null ? new GpxMetadata() : metadata;
	}
	public GpxTrk getTrk() {
		return trk;
	}
	
}
