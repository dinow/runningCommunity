package be.dno.running.persistence;

import javax.jdo.PersistenceManager;
	
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
		
}

