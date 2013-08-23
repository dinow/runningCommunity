package be.dno.running.web;

import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import be.dno.running.entities.Activity;
import be.dno.running.entities.xml.garmin.gpx.Gpx;
import be.dno.running.entities.xml.garmin.tcx.TcxTrainingCenterDatabase;
import be.dno.running.factories.ActivityFactory;
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
            	if (activity != null ){ //on va �viter d'uploader n'importe quoi...
            		log.fine("Attempting to create activity in datastore");
	            	//GenericDao<Activity> activityDao = new GenericDao<Activity>(Activity.class);
	            	//activity = activityDao.create(activity);
            		log.fine("Activity created with id: " + activity.getId());
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
