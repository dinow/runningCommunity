package be.dno.running.entities.xml;

import com.thoughtworks.xstream.annotations.XStreamAlias;

public class ValueString {
	@XStreamAlias("Value")
	private String value;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return value;
	}
	
}
