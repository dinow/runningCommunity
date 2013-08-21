package be.dno.running.web;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import be.dno.running.entities.Activity;
import be.dno.running.entities.xml.garmin.gpx.Gpx;
import be.dno.running.entities.xml.garmin.tcx.TcxTrainingCenterDatabase;
import be.dno.running.factories.ActivityFactory;
import be.dno.running.persistence.GenericDao;
import be.dno.running.xml.XmlToJavaConverter;

@Controller
@RequestMapping(value = "/upload_activity")
public class UploadController {
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView postUpload(MultiPartFileUpload upload, HttpServletRequest request) {
        if (upload.getFile().getSize() != 0) {
            String fileContent = new String(upload.getFile().getBytes());
            Class mainClass = getFileCategory(fileContent);
            if (mainClass != null){
            	Object tcd = XmlToJavaConverter.convert(fileContent,mainClass); 
            	
            	Activity activity = null;
            	
            	if (tcd instanceof TcxTrainingCenterDatabase){
            		System.out.println(new Date() + " - TcxTrainingCenterDatabase Activity to be processed");
            		activity = ActivityFactory.buildActivity((TcxTrainingCenterDatabase)tcd);
            		System.out.println(new Date() + " - TcxTrainingCenterDatabase Activity processed ! ");
            	}else if (tcd instanceof Gpx){
            		System.out.println(new Date() + " - Gpx Activity to be processed");
            		activity = ActivityFactory.buildActivity((Gpx)tcd);
            		System.out.println(new Date() + " - Gpx Activity processed ! ");
            	}
            	
            	// Persistence de l'activité
            	System.out.println(new Date() + " - Attempting to create activity in datastore");
            	GenericDao<Activity> activityDao = new GenericDao<Activity>(Activity.class);
            	activity = activityDao.create(activity);
            	System.out.println(new Date() + " - Activity created with id: " + activity.getId());
            	
            	
            	return new ModelAndView("file_uploaded" , "fileContent", activity);
            }else{
            	return new ModelAndView("fail","message","Unknown file type");
            }
        }
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
