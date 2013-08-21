package be.dno.running.entities.xml.garmin.gpx;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("trk")
public class GpxTrk {
	private String name;
	
	@XStreamAlias("trkseg")
	private GpxTrkseg trkseg;
	
	public String getName() {
		return name;
	}
	public GpxTrkseg getTrkseg() {
		return trkseg;
	}
	
}
