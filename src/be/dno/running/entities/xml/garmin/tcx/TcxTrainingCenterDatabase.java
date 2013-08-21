package be.dno.running.entities.xml.garmin.tcx;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("TrainingCenterDatabase")
public class TcxTrainingCenterDatabase {
	
	@XStreamAlias("Activities")
	private TcxActivities activities;
	
	@XStreamAlias("Author")
	private TcxAuthor author;

	public TcxActivities getActivities() {
		return activities;
	}
	
	public TcxAuthor getAuthor() {
		return author;
	}
	
}
