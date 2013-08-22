package be.dno.running.entities.xml.garmin.gpx;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("author")
public class GpxAuthor {
	@XStreamAlias("name")
	private String name;
	
	@XStreamAlias("email")
	private String email;

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	@Override
	public String toString() {
		return "GpxAuthor [name=" + name + ", email=" + email + "]";
	}
	
	
	
}
