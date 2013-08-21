package be.dno.running.entities.xml.garmin.tcx;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("Activities")
public class Activities {
	@XStreamAlias("Activity")
	private XmlActivity activity;

	public XmlActivity getActivity() {
		return activity;
	}	
}
