package be.dno.running.persistence;

import java.io.Serializable;
import java.util.List;

import javax.jdo.JDOObjectNotFoundException;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;



public class GenericDao <T>{

	protected Class<T> type;
	protected static final PersistenceManager pm = PMFactory.getPM();

	public GenericDao(Class<T> type) {
        this.type = type;
    }

	public T create(T o) {
		return pm.makePersistent(o);
	}
	
	public void delete(Serializable id){
		pm.deletePersistent(this.getById(id));
	}
	
	public void update(T o) {
		pm.refresh(o);
	}
	
	/*public T getById(Long id){
		try{
			return pm.getObjectById(type, id);
		}catch(JDOObjectNotFoundException nfound){
			return null;
		}
	}*/

	public T getById(Serializable id){
		try{
			return pm.getObjectById(type, id);
		}catch(JDOObjectNotFoundException nfound){
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public List<T> getAll(){
		Query q = pm.newQuery(type);
		List<T> results = (List<T>) q.execute();
		q.closeAll();
		return results;
	}

}