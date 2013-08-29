package be.dno.running.web;

import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import be.dno.running.entities.User;
import be.dno.running.persistence.GenericDao;

import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

@Controller
public class GenericController {
	private static final Logger log = Logger.getLogger(GenericController.class.getName());
	private static GenericDao<User> userDao = new GenericDao<User>(User.class);
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView gotohome(HttpServletRequest request) {
		UserService userService = UserServiceFactory.getUserService();
		User user = userDao.getById(userService.getCurrentUser().getUserId());
		if (user == null){
			log.info("First login of " + userService.getCurrentUser().getNickname());
			user = new User();
			user.setGoogleUserName(userService.getCurrentUser().getNickname());
			user.setUserID(userService.getCurrentUser().getUserId());
			user = userDao.create(user);
		}	
		return new ModelAndView("home");
	}
	
}
