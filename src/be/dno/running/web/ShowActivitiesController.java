package be.dno.running.web;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import be.dno.running.entities.Activity;
import be.dno.running.entities.User;
import be.dno.running.persistence.GenericDao;

import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

@Controller
@RequestMapping(value = "/show_my_activities")
public class ShowActivitiesController {

	private static final Logger log = Logger.getLogger(ShowActivitiesController.class.getName());
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView showActivities(HttpServletRequest request) {
		UserService userService = UserServiceFactory.getUserService();
		if(userService.getCurrentUser() == null){
			log.warning("Not logged in user tried to access show_activities page...");
			return new ModelAndView("fail","message","Unknown user");
		}
		GenericDao<User> userDao = new GenericDao<User>(User.class); 
		User currentUser = userDao.getById(userService.getCurrentUser().getUserId());
		List<Activity> activities = new ArrayList<Activity>();
		GenericDao<Activity> activityDao = new GenericDao<Activity>(Activity.class);
		for(Long activityId : currentUser.getActivities()){
			Activity activity = activityDao.getById(activityId);
			activities.add(activity);
		}
		log.info("activities: " + currentUser.getActivities());
		return new ModelAndView("show_activities" , "activities", activities);
	}
	
}
