package be.dno.running.persistence;

import java.util.List;

import javax.jdo.JDOObjectNotFoundException;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import com.google.appengine.api.datastore.Key;



public class GenericDao <T>{

	protected Class<T> type;
	protected static final PersistenceManager pm = PMFactory.getPM();

	public GenericDao(Class<T> type) {
        this.type = type;
    }

	public T create(T o) {
		return pm.makePersistent(o);
	}
	
	public void update(T o) {
		pm.refresh(o);
	}
	
	public T getById(Long id){
		try{
			return pm.getObjectById(type, id);
		}catch(JDOObjectNotFoundException nfound){
			return null;
		}
	}

	public T getById(String id){
		try{
			return pm.getObjectById(type, id);
		}catch(JDOObjectNotFoundException nfound){
			return null;
		}
	}
	
	public T getById(Key key){
		try{
			return pm.getObjectById(type, key);
		}catch(JDOObjectNotFoundException nfound){
			return null;
		}
	}

	public List<T> getAll(){
		Query q = pm.newQuery(type);
		List<T> results = (List) q.execute();
		q.closeAll();
		return results;
	}

}