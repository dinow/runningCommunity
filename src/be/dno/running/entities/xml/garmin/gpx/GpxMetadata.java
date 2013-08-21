package be.dno.running.entities.xml.garmin.gpx;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("metadata")
public class GpxMetadata {
	
	@XStreamAlias("link")
	private GpxLink link;
	
	@XStreamAlias("time")
	private String time;
	
	public GpxLink getLink() {
		return link;
	}
	public String getTime() {
		return time;
	}
	@Override
	public String toString() {
		return "[link=" + link + ", time=" + time + "]";
	}
	
	
	
}
