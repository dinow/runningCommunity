package be.dno.running.persistence;

import java.util.List;

import javax.jdo.JDOObjectNotFoundException;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import be.dno.running.entities.Activity;

import com.google.appengine.api.datastore.Key;

public class ActivityDao {
	
	protected static final PersistenceManager pm = PMFactory.getPM();

	public List<Activity> getPublicActivities(){
		Query q = pm.newQuery(Activity.class);
		q.setFilter("activityPrivate == false");
		List<Activity> results = (List) q.execute();
		q.closeAll();
		return results;
	}
}