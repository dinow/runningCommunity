package be.dno.running.entities.xml;

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

	public void setTpx(TPX tpx) {
		this.tpx = tpx;
	}

	public List<LX> getLx() {
		return lx;
	}

	public void setLx(List<LX> lx) {
		this.lx = lx;
	}

	
	
	
}
