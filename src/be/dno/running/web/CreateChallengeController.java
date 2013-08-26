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

public class CreateChallengeController {
	private static final Logger log = Logger.getLogger(CreateChallengeController.class.getName());
	
	@RequestMapping(value = "/createChallenge", method = RequestMethod.POST)
	public ModelAndView createChallenge(HttpServletRequest request) {
		UserService userService = UserServiceFactory.getUserService();
		String userID = userService.getCurrentUser().getUserId();
		
		Challenge challenge = new Challenge(userID);
		challenge.setName(request.getParameter("name"));
		challenge.setDistance(Double.parseDouble(request.getParameter("distance")));
		challenge.setElevation(Double.parseDouble(request.getParameter("elevation")));
		Date startDate = new Date();
		Date endDate = new Date();
		try {
			startDate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("startDate"));
			endDate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("endDate"));
		} catch (ParseException e) {
			log.severe("Parse error");
			e.printStackTrace();
		}
		challenge.setStartDate(startDate);
		challenge.setEndDate(endDate);
		GenericDao<Challenge> challengeDao = new GenericDao<Challenge>(Challenge.class);
		challenge = challengeDao.create(challenge);
		
		log.fine("Challenge created with id: "+ challenge.getId());
		
		return new ModelAndView("home");
	}
	
	
}
