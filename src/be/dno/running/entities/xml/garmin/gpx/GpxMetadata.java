package be.dno.running.entities.xml.garmin.gpx;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("metadata")
public class GpxMetadata {
	
	@XStreamAlias("link")
	private GpxLink link;
	
	@XStreamAlias("author")
	private GpxAuthor author;
	
	@XStreamAlias("time")
	private String time;
	
	@XStreamAlias("name")
	private String name;
	
	@XStreamAlias("bounds ")
	private String bounds;
	
	public GpxLink getLink() {
		return link;
	}
	public String getTime() {
		return time;
	}
	
	public GpxAuthor getAuthor() {
		return author;
	}
	
	public String getName() {
		return name == null ? "" : name;
	}
	public String getBounds() {
		return bounds;
	}
}
