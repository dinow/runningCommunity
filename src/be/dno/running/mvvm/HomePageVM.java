package be.dno.running.mvvm;

import java.io.Serializable;

import org.zkoss.bind.annotation.Init;

import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

import be.dno.running.entities.User;

public class HomePageVM implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2750774568249831376L;
	User currentUser;
	UserService userService = UserServiceFactory.getUserService();
	
	@Init
    public void init() {
		System.out.println("HomePageVM.init...");
		currentUser = new User();
		currentUser.setGoogleUserName(userService.getCurrentUser().getNickname());
	}

	public User getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(User currentUser) {
		this.currentUser = currentUser;
	}
	
	
}