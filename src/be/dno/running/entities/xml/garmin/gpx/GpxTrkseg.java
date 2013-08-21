package be.dno.running.entities.xml.garmin.gpx;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

@XStreamAlias("trkseg")
public class GpxTrkseg {
	
	@XStreamImplicit(itemFieldName="trkpt")
	List<GpxTrkpt> trkpts;

	public List<GpxTrkpt> getTrkpts() {
		return trkpts;
	}
	
}
