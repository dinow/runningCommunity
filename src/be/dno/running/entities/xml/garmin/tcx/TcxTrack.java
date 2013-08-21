package be.dno.running.entities.xml.garmin.tcx;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

@XStreamAlias("Track")
public class TcxTrack {
	
	@XStreamImplicit(itemFieldName="Trackpoint")
	private List<TcxTrackpoint> trackpoints;

	public List<TcxTrackpoint> getTrackpoints() {
		return trackpoints;
	}
}
