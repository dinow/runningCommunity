package be.dno.running.entities.xml.garmin.tcx;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("Creator")
public class TcxCreator {
	
	@XStreamAlias("Name")
	private String name;
	
	
	@XStreamAlias("UnitId")
	private String unitId;
	
	@XStreamAlias("ProductID")
	private String productID;
	
	@XStreamAlias("Version")
	private TcxVersion version;
	
	public String getName() {
		return name;
	}

	public String getUnitId() {
		return unitId;
	}

	public String getProductID() {
		return productID;
	}

	public TcxVersion getVersion() {
		return version;
	}

	@Override
	public String toString() {
		return "TcxCreator [name=" + name + ", unitId=" + unitId
				+ ", productID=" + productID + ", version=" + version + "]";
	}
	
	
}
