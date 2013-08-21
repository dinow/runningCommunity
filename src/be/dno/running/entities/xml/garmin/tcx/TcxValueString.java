package be.dno.running.entities.xml.garmin.tcx;

import com.thoughtworks.xstream.annotations.XStreamAlias;

public class TcxValueString {
	@XStreamAlias("Value")
	private String value;

	public String getValue() {
		return value;
	}

	@Override
	public String toString() {
		return value;
	}
	
}
