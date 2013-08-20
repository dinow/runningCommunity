package be.dno.running.entities.xml;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("Activities")
public class Activities {
	@XStreamAlias("Activity")
	private XmlActivity activity;

	public XmlActivity getActivity() {
		return activity;
	}

	public void setActivity(XmlActivity activity) {
		this.activity = activity;
	}
	
}
