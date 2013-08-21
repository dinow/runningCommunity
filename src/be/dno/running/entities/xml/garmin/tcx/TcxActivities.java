package be.dno.running.entities.xml.garmin.tcx;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("Activities")
public class TcxActivities {
	@XStreamAlias("Activity")
	private TcxActivity activity;

	public TcxActivity getActivity() {
		return activity;
	}	
}
