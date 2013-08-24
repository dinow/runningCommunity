package be.dno.running.web;

import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import be.dno.running.persistence.ActivityDao;


@Controller
@RequestMapping(value = "/show_others_activities")
public class ShowOthersActivitiesController {
	
	private static final Logger log = Logger.getLogger(ShowActivitiesController.class.getName());
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView showActivities(HttpServletRequest request) {
		ActivityDao adao = new ActivityDao();
		return new ModelAndView("show_others_activities","activities",adao.getPublicActivities());
	}
}