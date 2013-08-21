package be.dno.running.entities.xml.garmin.tcx;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
@XStreamAlias("Activity")
public class XmlActivity {
	@XStreamAlias("Sport")
	@XStreamAsAttribute
	private String sport;
	
	@XStreamAlias("Id")
	private String id;
	
	@XStreamImplicit(itemFieldName="Lap")
	private List<Lap> laps;
	
	@XStreamAlias("Creator")
	private Creator creator;
	
	public String getSport() {
		return sport;
	}
	
	public String getId() {
		return id;
	}
	
	public List<Lap> getLaps() {
		return laps;
	}
	
	public Creator getCreator() {
		return creator;
	}
}
