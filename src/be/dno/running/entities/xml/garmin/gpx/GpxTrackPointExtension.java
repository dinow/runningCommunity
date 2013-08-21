package be.dno.running.entities.xml.garmin.gpx;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("gpxtpx:TrackPointExtension")
public class GpxTrackPointExtension {
	@XStreamAlias("gpxtpx:hr")
	private String hr;

	public String getHr() {
		return hr;
	}

	public void setHr(String hr) {
		this.hr = hr;
	}
	
	
}
