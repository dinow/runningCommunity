package be.dno.running.entities.xml.garmin.tcx;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

@XStreamAlias("Track")
public class Track {
	
	@XStreamImplicit(itemFieldName="Trackpoint")
	private List<Trackpoint> trackpoints;

	public List<Trackpoint> getTrackpoints() {
		return trackpoints;
	}
}
