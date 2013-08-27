package be.dno.running.web;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import be.dno.running.entities.Challenge;
import be.dno.running.persistence.GenericDao;

import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

@Controller
public class ChallengeController {
	private static final Logger log = Logger.getLogger(ChallengeController.class.getName());
	
	GenericDao<Challenge> challengeDao = new GenericDao<Challenge>(Challenge.class);
	
	@RequestMapping(value = "/show_all_challenges", method = RequestMethod.GET)
	public ModelAndView showAllChallenges(HttpServletRequest request) {
		GenericDao<Challenge> challengeDao = new GenericDao<Challenge>(Challenge.class);
		return new ModelAndView("show_all_challenges","challenges", challengeDao.getAll());
	}
	
	@RequestMapping(value = "/createChallenge", method = RequestMethod.POST)
	public ModelAndView createChallenge(HttpServletRequest request) {
		UserService userService = UserServiceFactory.getUserService();
		String userID = userService.getCurrentUser().getUserId();
		
		Challenge challenge = new Challenge(userID);
		
		String name = request.getParameter("name");
		String time = request.getParameter("time");
		String comptype = request.getParameter("Comptype");
		String distance = request.getParameter("distance");
		String elevation = request.getParameter("elevation");
		String startDateStr = request.getParameter("startDate");
		String endDateStr = request.getParameter("endDate");
		
		if (name == null){
			return new ModelAndView("fail","message","No name provided"); 
		}
		challenge.setName(name);
		if (null != time){
			challenge.setSeconds(Integer.parseInt(time));
		}
		challenge.setCriteria(request.getParameter(comptype));
		if (null != distance){
			challenge.setDistance(Double.parseDouble(distance));
		}
		if (null != elevation){
			challenge.setElevation(Double.parseDouble(elevation));
		}
		Date startDate = new Date();
		Date endDate = new Date();
		try {
			startDate = new SimpleDateFormat("yyyy-MM-dd").parse(startDateStr);
			endDate = new SimpleDateFormat("yyyy-MM-dd").parse(endDateStr);
		} catch (ParseException e) {
			log.severe("Parse error");
			e.printStackTrace();
		}
		challenge.setStartDate(startDate);
		challenge.setEndDate(endDate);
		
		challenge = challengeDao.create(challenge);
		
		log.fine("Challenge created with id: "+ challenge.getId());
		
		return new ModelAndView("home");
	}
	
	
}
