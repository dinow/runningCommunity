package be.dno.running.persistence;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import be.dno.running.entities.Activity;

public class ActivityDao {
	
	protected static final PersistenceManager pm = PMFactory.getPM();

	public List<Activity> getPublicActivities(){
		Query q = pm.newQuery(Activity.class);
		q.setFilter("activityPrivate == false");
		List<Activity> results = (List) q.execute();
		q.closeAll();
		if (results == null) results = new ArrayList<Activity>();
		return results;
	}
}
