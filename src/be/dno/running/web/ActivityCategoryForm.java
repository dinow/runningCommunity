package be.dno.running.web;

import java.util.List;

import be.dno.running.entities.ActivityCategory;

public class ActivityCategoryForm {
	private List<ActivityCategory> activityCategories;

	public List<ActivityCategory> getActivityCategories() {
		return activityCategories;
	}

	public void setActivityCategories(List<ActivityCategory> activityCategories) {
		this.activityCategories = activityCategories;
	}
	
}
