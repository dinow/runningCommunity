package be.dno.running.entities.xml.garmin.gpx;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("gpxtpx:TrackPointExtension")
public class GpxTrackPointExtension{
	@XStreamAlias("gpxtpx:hr")
	private String hr;
	
	@XStreamAlias("gpxtpx:cad")
	private String cad;

	public String getHr() {
		return hr;
	}

	public void setHr(String hr) {
		this.hr = hr;
	}

	public String getCad() {
		return cad;
	}

	public void setCad(String cad) {
		this.cad = cad;
	}
	
	
}
