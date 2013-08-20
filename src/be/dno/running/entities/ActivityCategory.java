package be.dno.running.entities;

import java.util.ArrayList;
import java.util.List;

public class ActivityCategory {
	private String label;
    private String id;
    private List<Activity> activities = new ArrayList<>();
    private boolean expended= true;
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public List<Activity> getActivities() {
		return activities;
	}
	public void setActivities(List<Activity> activities) {
		this.activities = activities;
	}
	public boolean isExpended() {
		return expended;
	}
	public void setExpended(boolean expended) {
		this.expended = expended;
	}
    
    
}
