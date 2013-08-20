package be.dno.running.entities.xml;

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



	public void setName(String name) {
		this.name = name;
	}



	public Build getBuild() {
		return build;
	}



	public void setBuild(Build build) {
		this.build = build;
	}



	public String getLangID() {
		return langID;
	}



	public void setLangID(String langID) {
		this.langID = langID;
	}



	public String getPartNumber() {
		return partNumber;
	}



	public void setPartNumber(String partNumber) {
		this.partNumber = partNumber;
	}



	@Override
	public String toString() {
		return "Author [name=" + name + ", build=" + build + ", langID="
				+ langID + ", partNumber=" + partNumber + "]";
	}
	
	 
}
