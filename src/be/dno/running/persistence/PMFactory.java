package be.dno.running.persistence;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;

public final class PMFactory {
    private static final PersistenceManagerFactory pmfInstance =
        JDOHelper.getPersistenceManagerFactory("transactions-optional");

    private PMFactory() {}

    public static PersistenceManagerFactory get() {
        return pmfInstance;
    }
    
    public static PersistenceManager getPM() {
    	return pmfInstance.getPersistenceManager();
    }
} 
