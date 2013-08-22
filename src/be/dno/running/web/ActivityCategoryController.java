package be.dno.running.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import be.dno.running.entities.Activity;
import be.dno.running.entities.ActivityCategory;
import be.dno.running.persistence.GenericDao;


@Controller
@RequestMapping(value = "/show_activities")
public class ActivityCategoryController {

	GenericDao<Activity> activityDao = new GenericDao<Activity>(Activity.class);
     
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView get() {  
    	System.out.println("ActivityCategoryController get");
    	ActivityCategoryForm activityCategoryForm = new ActivityCategoryForm();
    	List<ActivityCategory> acs = new ArrayList<ActivityCategory>();
    	ActivityCategory ac = new ActivityCategory();
    	ac.setLabel("run");
    	List<Activity> myActivities = activityDao.getAll();
    	
    	if (myActivities.isEmpty()){
    		
    	}
    	ac.setActivities(myActivities);
    	acs.add(ac);
    	activityCategoryForm.setActivityCategories(acs);
        return new ModelAndView("show_activities" , "activityCategoryForm", activityCategoryForm);
	}
}
