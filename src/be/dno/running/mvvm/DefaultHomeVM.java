package be.dno.running.mvvm;

import java.io.Serializable;

import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.zk.ui.Executions;

import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

public class DefaultHomeVM implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6347035911595366067L;
	private String frameSrc;
	UserService userService = UserServiceFactory.getUserService();
	
	@Init
    public void init() {
		System.out.println("DefaultHomeVM.init...");
		frameSrc = "/pages/homePage.zul";
    }

	
	@Command
    public void logout(){
		//Executions.sendRedirect(userService.createLogoutURL(Executions.getCurrent().getDesktop().getRequestPath()));
    }

	public String getFrameSrc() {
		return frameSrc;
	}


	public void setFrameSrc(String frameSrc) {
		this.frameSrc = frameSrc;
	}
	 
	
	
	
}
