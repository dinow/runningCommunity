package be.dno.running.persistence;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;


	
public class GenericDao <T>{
	
	private Class<T> type;
	private static final PersistenceManager pm = PMFactory.getPM();
	
	public GenericDao(Class<T> type) {
        this.type = type;
    }
	
	public T create(T o) {
		return pm.makePersistent(o);
	}
	
	public T getById(String id){
		return pm.getObjectById(type, id);
	}
	
	public List<T> getAll(){
		Query q = pm.newQuery(type);
		List<T> results = (List) q.execute();
		q.closeAll();
		return results;
	}
		
}

