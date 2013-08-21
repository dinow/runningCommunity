package be.dno.running.entities.xml.garmin.tcx;

import com.thoughtworks.xstream.annotations.XStreamAlias;

public class Author {
	@XStreamAlias("Name")
	private String name;
	
	@XStreamAlias("Build")
	private Build build;
	
	@XStreamAlias("LangID")
	private String langID;
	
	@XStreamAlias("PartNumber")
	private String partNumber;

	public String getName() {
		return name;
	}

	public Build getBuild() {
		return build;
	}

	public String getLangID() {
		return langID;
	}

	public String getPartNumber() {
		return partNumber;
	}

	@Override
	public String toString() {
		return "Author [name=" + name + ", build=" + build + ", langID="
				+ langID + ", partNumber=" + partNumber + "]";
	}
	
	 
}
