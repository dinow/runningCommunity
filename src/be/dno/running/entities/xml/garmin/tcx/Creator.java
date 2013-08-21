package be.dno.running.entities.xml.garmin.tcx;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("Creator")
public class Creator {
	
	@XStreamAlias("Name")
	private String name;
	
	
	@XStreamAlias("UnitId")
	private String unitId;
	
	@XStreamAlias("ProductID")
	private String productID;
	
	@XStreamAlias("Version")
	private Version version;
	
	public String getName() {
		return name;
	}

	public String getUnitId() {
		return unitId;
	}

	public String getProductID() {
		return productID;
	}

	public Version getVersion() {
		return version;
	}
}
