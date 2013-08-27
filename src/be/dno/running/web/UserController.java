package be.dno.running.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(HttpServletRequest request) {
		return new ModelAndView();
	}
	
	@RequestMapping(value = "/editUser", method = RequestMethod.POST)
	public ModelAndView editUser(HttpServletRequest request) {
		return new ModelAndView();
	}
	
}
