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
import be.dno.running.entities.xml.garmin.gpx.Gpx;
import be.dno.running.entities.xml.garmin.tcx.TcxTrainingCenterDatabase;
import be.dno.running.factories.ActivityFactory;
import be.dno.running.helper.JspHelper;
import be.dno.running.persistence.GenericDao;
import be.dno.running.xml.XmlToJavaConverter;

import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

@Controller

public class UploadController {
	private static final Logger log = Logger.getLogger(UploadController.class.getName());
	
	@RequestMapping(value = "/saveAction", method = RequestMethod.POST)
	public ModelAndView updateActivity(HttpServletRequest request) {
		String activityID = JspHelper.htmlDecode(request.getParameter("activityId"));
		String isPrivate = request.getParameter("private");
		String type = request.getParameter("type");
		
		UserService userService = UserServiceFactory.getUserService();
		String userID = userService.getCurrentUser().getUserId();
	
		GenericDao<User> userDao = new GenericDao<User>(User.class);
		GenericDao<Activity> activityDao = new GenericDao<Activity>(Activity.class); 
		User user = userDao.getById(userID);
		Activity activity = null;
		List<Activity> activities = new ArrayList<Activity>();
		for(Long activityId : user.getActivityIds()){
			activities.add(activityDao.getById(activityId));
		}
		for(final Activity tactivity : activities){
			if (tactivity.getId().longValue() == Long.parseLong(activityID)){
				activity = tactivity;
			}
		}
		
		
		if(activity != null){
			activity.setActivityPrivate(null != isPrivate);
			activity.setActivityCategory(type);
			userDao.update(user);
		}else{
			log.severe("Err: Activity is null");
		}
		return new ModelAndView("home");
	}
	
	
	@RequestMapping(value = "/upload_activity", method = RequestMethod.GET)
	public ModelAndView postUploadRedirect(MultiPartFileUpload upload, HttpServletRequest request) {
		return new ModelAndView("upload_activity");
	}
	
	@RequestMapping(value = "/upload_activity", method = RequestMethod.POST)
	public ModelAndView postUpload(MultiPartFileUpload upload, HttpServletRequest request) {
		UserService userService = UserServiceFactory.getUserService();
		String userID = userService.getCurrentUser().getUserId();
		GenericDao<User> userDao = new GenericDao<User>(User.class);
		User user = userDao.getById(userID);
		if (user == null){
			log.fine("User is new, creating...");
			user = new User();
			user.setGoogleUserName(userService.getCurrentUser().getNickname());
			user.setUserID(userID);
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
            		GenericDao<Activity> activityDao = new GenericDao<Activity>(Activity.class);
            		
            		
            		if (userService.getCurrentUser() != null){
            			log.fine("User is still connected");
            			activity.setUserName(userService.getCurrentUser().getNickname());
            			activity = activityDao.create(activity);
            			if (user.getActivityIds() == null){
            				user.setActivityIds(new ArrayList<Long>());
            			}
            			user.getActivityIds().add(activity.getId());
            			userDao.create(user);
            		}
            		System.out.println("Activity id " + activity.getId());
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
