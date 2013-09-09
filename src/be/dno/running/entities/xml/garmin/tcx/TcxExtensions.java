package be.dno.running.entities.xml.garmin.tcx;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

@XStreamAlias("Extensions")
public class TcxExtensions {
	@XStreamAlias("TPX")
	private TcxTPX tpx;
	
	@XStreamAlias("FatCalories")
	private TcxValueString fatCalories;
	
	@XStreamImplicit(itemFieldName="LX")
	private List<TcxLX> lx;

	public TcxTPX getTpx() {
		return tpx;
	}

	public List<TcxLX> getLx() {
		return lx;
	}

	public TcxValueString getFatCalories() {
		return fatCalories;
	}
	
}
