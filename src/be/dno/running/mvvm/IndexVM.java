package be.dno.running.mvvm;

import java.io.Serializable;

import org.zkoss.bind.annotation.Init;
import org.zkoss.zk.ui.Executions;

import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

/**
 *
 * @author nowakdi
 */
public class IndexVM implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 922930848106533785L;
	UserService userService = UserServiceFactory.getUserService();
    
    @Init
    public void init() {
    	System.out.println("IndexVM.init...");
    	if (userService.isUserLoggedIn()){
    		System.out.println("redirecting to default...");
    		Executions.sendRedirect("/pages/defaultHome.zul");
    	}else{
    		System.out.println("redirecting to login...");
    		Executions.sendRedirect(userService.createLoginURL("/"));
    	}
    } 
}
