package be.dno.running.entities.xml;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("TrainingCenterDatabase")
public class TrainingCenterDatabase {
	
	@XStreamAlias("Activities")
	private Activities activities;
	
	@XStreamAlias("Author")
	private Author author;
	
	public Activities getActivities() {
		return activities;
	}
	public void setActivities(Activities activities) {
		this.activities = activities;
	}
	public Author getAuthor() {
		return author;
	}
	public void setAuthor(Author author) {
		this.author = author;
	} 
}
