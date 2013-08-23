package be.dno.running.entities.xml.garmin.gpx;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

@XStreamAlias("trkpt")
public class GpxTrkpt {
	
	@XStreamAsAttribute
	private String lon;
	
	@XStreamAsAttribute
	private String lat;
	
	@XStreamAlias("ele")
	private String ele;
	
	@XStreamAlias("sat")
	private String sat;
	
	@XStreamAlias("cmt")
	private String cmt;
	
	@XStreamAlias("time")
	private String time;
	
	@XStreamAlias("extensions")
	private GpxExtensions extensions;
	
	public String getLon() {
		return lon;
	}
	public void setLon(String lon) {
		this.lon = lon;
	}
	public String getLat() {
		return lat;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}
	public String getEle() {
		return ele;
	}
	public void setEle(String ele) {
		this.ele = ele;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public GpxExtensions getExtensions() {
		return extensions;
	}
	public void setExtensions(GpxExtensions extensions) {
		this.extensions = extensions;
	}
	public String getSat() {
		return sat;
	}
	public String getCmt() {
		return cmt;
	}
	
	
	
}
