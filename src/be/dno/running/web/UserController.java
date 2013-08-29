package be.dno.running.web;

import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import be.dno.running.entities.User;
import be.dno.running.helper.ConvertHelper;
import be.dno.running.persistence.GenericDao;

import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

@Controller
public class UserController {
	private static final Logger log = Logger.getLogger(UserController.class.getName());
	private static GenericDao<User> userDao = new GenericDao<User>(User.class);
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(HttpServletRequest request) {
		UserService userService = UserServiceFactory.getUserService();
		User user = userDao.getById(userService.getCurrentUser().getUserId());
		if (user == null){
			log.info("First login of " + userService.getCurrentUser().getNickname());
			user = new User();
			user.setGoogleUserName(userService.getCurrentUser().getNickname());
			user.setUserID(userService.getCurrentUser().getUserId());
			user = userDao.create(user);
			return new ModelAndView("editProfile","user",user);
		}	
		return new ModelAndView("home");
	}
	
	@RequestMapping(value = "/edit_profile", method = RequestMethod.GET)
	public ModelAndView redirectToProfil(HttpServletRequest request) {
		UserService userService = UserServiceFactory.getUserService();
		User user = userDao.getById(userService.getCurrentUser().getUserId());
		if (user != null){
			return new ModelAndView("editProfile","user",user);
		}	
		return new ModelAndView("home");
	}
	
	@RequestMapping(value = "/save_profile", method = RequestMethod.POST)
	public ModelAndView editUser(HttpServletRequest request) {
		String hfrUserName = request.getParameter("hfrUserName");
		String taille = request.getParameter("taille");
		String poids = request.getParameter("poids");
		
		UserService userService = UserServiceFactory.getUserService();
		User user = userDao.getById(userService.getCurrentUser().getUserId());
		
		if (hfrUserName != null && !hfrUserName.isEmpty()){
			user.setHfrUserName(hfrUserName);
		}
		
		if (taille != null && poids != null){
			int iTaille = Integer.parseInt(taille);
			
			double dPoids = Double.parseDouble(poids);
			double dTaille = ((double)iTaille / 100);
			//IMC = (Poids) / (Taille)²
			double IMC = (dPoids) / (dTaille*dTaille);
			IMC = ConvertHelper.limitDecimal(IMC);
			user.setIMC(IMC);
			user.setTaille(iTaille);
			user.setPoids(dPoids);
		}
		
		userDao.update(user);
		return new ModelAndView("editProfile","user",user);
	}
	
}
