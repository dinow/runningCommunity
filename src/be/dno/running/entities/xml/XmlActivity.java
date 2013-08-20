package be.dno.running.entities.xml;

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
	public void setSport(String sport) {
		this.sport = sport;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public List<Lap> getLaps() {
		return laps;
	}
	public void setLaps(List<Lap> laps) {
		this.laps = laps;
	}
	public Creator getCreator() {
		return creator;
	}
	public void setCreator(Creator creator) {
		this.creator = creator;
	}
	
	
}
