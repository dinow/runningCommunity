package be.dno.running.entities.xml.garmin.tcx;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

@XStreamAlias("Extensions")
public class Extensions {
	@XStreamAlias("TPX")
	private TPX tpx;
	
	@XStreamImplicit(itemFieldName="LX")
	private List<LX> lx;

	public TPX getTpx() {
		return tpx;
	}

	public List<LX> getLx() {
		return lx;
	}
}
