package be.dno.running.web;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import be.dno.running.entities.Activity;
import be.dno.running.entities.User;
import be.dno.running.entities.xml.garmin.gpx.Gpx;
import be.dno.running.entities.xml.garmin.tcx.TcxTrainingCenterDatabase;
import be.dno.running.factories.ActivityFactory;
import be.dno.running.helper.MultiPartFileUpload;
import be.dno.running.persistence.ActivityDao;
import be.dno.running.persistence.GenericDao;
import be.dno.running.xml.XmlToJavaConverter;

import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

@Controller
public class ActivityController {
	
	private static final Logger log = Logger.getLogger(ActivityController.class.getName());
	private static GenericDao<Activity> activityDao = new GenericDao<Activity>(Activity.class); 
	private static GenericDao<User> userDao = new GenericDao<User>(User.class);
	
	@RequestMapping(value = "/deleteActivity", method = RequestMethod.POST)
	public ModelAndView deleteActivity(HttpServletRequest request) {
		Long activityId = Long.parseLong(request.getParameter("activityId"));
		GenericDao<User> userDao = new GenericDao<User>(User.class);
		UserService userService = UserServiceFactory.getUserService();
		String userID = userService.getCurrentUser().getUserId();
		User user = userDao.getById(userID);
		if (user != null){
			System.out.println("removing activity with id " + activityId);
			System.out.println("Before : " + user.getActivityIds());
			user.getActivityIds().remove(activityId);
			System.out.println("After : " + user.getActivityIds());
			userDao.update(user);
		}
		activityDao.delete(activityId);
		return new ModelAndView("show_activities");
	}
	
	@RequestMapping(value = "/show_my_activities", method = RequestMethod.GET)
	public ModelAndView showActivities(HttpServletRequest request) {
		UserService userService = UserServiceFactory.getUserService();
		if(userService.getCurrentUser() == null){
			log.warning("Not logged in user tried to access show_activities page...");
			return new ModelAndView("fail","message","Unknown user");
		}
		User currentUser = userDao.getById(userService.getCurrentUser().getUserId());
		
		List<Activity> activities = new ArrayList<Activity>();
		if (currentUser == null){
			return new ModelAndView("show_activities" , "activities", activities);
		}
		for(Long activityId : currentUser.getActivityIds()){
			activities.add(activityDao.getById(activityId));
		}
		
		log.info("activities: " + activities);
		return new ModelAndView("show_activities" , "activities", activities);
	}
	
	@RequestMapping(value = "/show_others_activities", method = RequestMethod.GET)
	public ModelAndView showOtherActivities(HttpServletRequest request) {
		ActivityDao adao = new ActivityDao();
		return new ModelAndView("show_others_activities","activities",adao.getPublicActivities());
	}
	
	@RequestMapping(value = "/saveActivity", method = RequestMethod.POST)
	public ModelAndView updateActivity(HttpServletRequest request) {
		Long activityID = Long.parseLong(request.getParameter("activityId"));
		String isPrivate = request.getParameter("private");
		String type = request.getParameter("type");
		String name = request.getParameter("name");
		
		UserService userService = UserServiceFactory.getUserService();
		String userID = userService.getCurrentUser().getUserId();
	
		Activity activity = activityDao.getById(activityID); //pas nécessaire de boucler
		
		if(activity != null){
			if(activity.getUserid().equals(userID)){
				activity.setActivityPrivate(null != isPrivate);
				activity.setActivityCategory(type);
				activity.setName(name);
				activityDao.update(activity);
			}
			else {
				log.severe("Err: Operation not allowed");
			}
			
		}else{
			log.severe("Err: Activity is null");
		}
		return new ModelAndView("show_activities");
	}
	
	
	@RequestMapping(value = "/upload_activity", method = RequestMethod.GET)
	public ModelAndView postUploadRedirect(MultiPartFileUpload upload, HttpServletRequest request) {
		return new ModelAndView("upload_activity");
	}
	
	
	
	@RequestMapping(value = "/upload_activity", method = RequestMethod.POST)
	public ModelAndView postUpload(MultiPartFileUpload upload, HttpServletRequest request) {
		UserService userService = UserServiceFactory.getUserService();
		String userID = userService.getCurrentUser().getUserId();
		User user = userDao.getById(userID);
		if (user == null){
			log.fine("User is new, creating...");
			user = new User();
			user.setGoogleUserName(userService.getCurrentUser().getNickname());
			user.setUserID(userID);
			userDao.create(user); // On crée le user maintenant, on le modifie après
		}else{
			log.fine("User retrieved with id " + user.getUserID());
		}
		
		if (upload.getFile().getSize() != 0) {
            String fileContent = new String(upload.getFile().getBytes());
            Class mainClass = getFileCategory(fileContent);
            if (mainClass != null){
            	Object tcd = XmlToJavaConverter.convert(fileContent,mainClass); 
            	
            	Activity activity = null;
            	
            	if (tcd instanceof TcxTrainingCenterDatabase){
            		log.fine("TcxTrainingCenterDatabase Activity to be processed");
            		activity = ActivityFactory.buildActivity((TcxTrainingCenterDatabase)tcd,userID);
            		log.fine("TcxTrainingCenterDatabase Activity processed ! ");
            	}else if (tcd instanceof Gpx){
            		log.fine("Gpx Activity to be processed");
            		activity = ActivityFactory.buildActivity((Gpx)tcd,userID);
            		log.fine("Gpx Activity processed ! ");
            	}
            	
            	// Persistence de l'activité
            	if (activity != null ){ //on va éviter d'uploader n'importe quoi...
            		activity.setActivityCategory("run");
            		activity.setActivityPrivate(false);
            		log.fine("Attempting to add activity into user in datastore");
            		
            		if (userService.getCurrentUser() != null){
            			log.fine("User is still connected");
            			activity.setUserName(userService.getCurrentUser().getNickname());
            			activity.setUploadDate(new Date());
            			activity = activityDao.create(activity);
            			if (user.getActivityIds() == null){
            				user.setActivityIds(new ArrayList<Long>());
            			}
            			user.getActivityIds().add(activity.getId());
            			userDao.update(user); //update ici car le create écrase un user existant
            		}
	            	return new ModelAndView("file_uploaded" , "fileContent", activity);
            	}else{
            		log.severe("cannot create activity...");
            		return new ModelAndView("fail","message","cannot create activity");
            	}
            }else{
            	log.warning("Unknown file type ("+upload.getFile().getName()+")");
            	return new ModelAndView("fail","message","Unknown file type");
            }
        }
		log.warning("No uploaded file ???");
	    return new ModelAndView("fail","message","No uploaded file ???");
	}

	private Class getFileCategory(String fileContent) {
		if(fileContent.contains("<TrainingCenterDatabase")){
			return TcxTrainingCenterDatabase.class;
		}
		
		if(fileContent.contains("<gpx")){
			return Gpx.class;
		}
		
		return null;
	}
}
