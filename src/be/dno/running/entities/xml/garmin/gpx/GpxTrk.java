package be.dno.running.entities.xml.garmin.gpx;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

@XStreamAlias("trk")
public class GpxTrk {
	
	@XStreamAlias("name")
	private String name;
	
	@XStreamAlias("type")
	private String type;
	
	@XStreamAlias("src")
	private String src;
	
	@XStreamImplicit(itemFieldName="trkseg")
	private List<GpxTrkseg> trkseg;
	
	@XStreamAlias("link")
	private GpxLink link;
	
	public String getName() {
		return name;
	}
	
	public List<GpxTrkseg> getTrkseg() {
		return trkseg;
	}

	public String getType() {
		return type;
	}
	public String getSrc() {
		return src;
	}
	public GpxLink getLink() {
		return link;
	}
	
}
