package be.dno.running.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import be.dno.running.entities.Challenge;
import be.dno.running.persistence.GenericDao;


@Controller
@RequestMapping(value = "/show_all_challenges")
public class ShowAllChallengesControler {
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView showAllChallenges(HttpServletRequest request) {
		GenericDao<Challenge> challengeDao = new GenericDao<Challenge>(Challenge.class);
		return new ModelAndView("show_all_challenges","challenges", challengeDao.getAll());
	}
}
