package be.dno.running.entities.xml.garmin.gpx;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("link")
public class GpxLink {
	
	@XStreamAlias("text")
	private String text;

	public String getText() {
		return text;
	}

	@Override
	public String toString() {
		return text;
	}
}
