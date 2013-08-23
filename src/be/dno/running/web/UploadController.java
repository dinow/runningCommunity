package be.dno.running.web;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

import be.dno.running.entities.Activity;
import be.dno.running.entities.User;
import be.dno.running.entities.xml.garmin.gpx.Gpx;
import be.dno.running.entities.xml.garmin.tcx.TcxTrainingCenterDatabase;
import be.dno.running.factories.ActivityFactory;
import be.dno.running.persistence.GenericDao;
import be.dno.running.xml.XmlToJavaConverter;

@Controller
@RequestMapping(value = "/upload_activity")
public class UploadController {
	private static final Logger log = Logger.getLogger(UploadController.class.getName());
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView postUpload(MultiPartFileUpload upload, HttpServletRequest request) {
		if (upload.getFile().getSize() != 0) {
            String fileContent = new String(upload.getFile().getBytes());
            Class mainClass = getFileCategory(fileContent);
            if (mainClass != null){
            	Object tcd = XmlToJavaConverter.convert(fileContent,mainClass); 
            	
            	Activity activity = null;
            	
            	if (tcd instanceof TcxTrainingCenterDatabase){
            		log.fine("TcxTrainingCenterDatabase Activity to be processed");
            		activity = ActivityFactory.buildActivity((TcxTrainingCenterDatabase)tcd);
            		log.fine("TcxTrainingCenterDatabase Activity processed ! ");
            	}else if (tcd instanceof Gpx){
            		log.fine("Gpx Activity to be processed");
            		activity = ActivityFactory.buildActivity((Gpx)tcd);
            		log.fine("Gpx Activity processed ! ");
            	}
            	
            	// Persistence de l'activit�
            	if (activity != null ){ //on va éviter d'uploader n'importe quoi...
            		log.fine("Attempting to add activity into user in datastore");
            		GenericDao<User> userDao = new GenericDao<User>(User.class);
            		UserService userService = UserServiceFactory.getUserService();
            		if (userService.getCurrentUser() != null){
            			log.fine("User is still connected");
            			String userID = userService.getCurrentUser().getUserId();
            			
            			User user = userDao.getById(userID);
            			if (user == null){
            				log.fine("User is new, creating...");
            				user = new User();
            				user.setGoogleUserName(userService.getCurrentUser().getNickname());
            				user.setUserID(userID);
            			}else{
            				log.fine("User retrieved with id " + user.getUserID());
            			}
            			
            			List<Activity> activities = user.getActivities();
            			if (activities == null){
            				log.fine("Creating empty list of activity");
            				activities = new ArrayList<Activity>();
            			}
            			activities.add(activity);
            			log.fine("Total activities for user " + activities.size());
            			user = userDao.create(user);
            			System.out.println("User created / updated with id " + user.getUserID());
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
