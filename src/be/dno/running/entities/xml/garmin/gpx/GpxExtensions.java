package be.dno.running.entities.xml.garmin.gpx;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("extensions")
public class GpxExtensions {
	
	@XStreamAlias("gpxtpx:TrackPointExtension")
	private GpxTrackPointExtension trackPointExtension;

	public GpxTrackPointExtension getTrackPointExtension() {
		return trackPointExtension;
	}

	public void setTrackPointExtension(GpxTrackPointExtension trackPointExtension) {
		this.trackPointExtension = trackPointExtension;
	}
	
	
}
