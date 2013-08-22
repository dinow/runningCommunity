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
		return name == null ? "" : name;
	}

	public String getUnitId() {
		return unitId == null ? "" : unitId;
	}

	public String getProductID() {
		return productID == null ? "" : productID;
	}

	public TcxVersion getVersion() {
		return version == null ? new TcxVersion() : version;
	}

	@Override
	public String toString() {
			return "TcxCreator [name=" + getName() + ", unitId=" + getUnitId()
				+ ", productID=" + getProductID() + ", version=" + getVersion().toString() + "]";
	}
	
	
}
