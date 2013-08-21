package be.dno.running.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import be.dno.running.entities.ActivityCategory;


@Controller
@RequestMapping(value = "/show_activities")
public class ActivityCategoryController {

	private static List<ActivityCategory> activityCategories = new ArrayList<ActivityCategory>();

     
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView get() {  
    	System.out.println("ModelAndView get");
    	activityCategories.clear();
    	ActivityCategoryForm activityCategoryForm = new ActivityCategoryForm();
    	activityCategoryForm.setActivityCategories(activityCategories);
        return new ModelAndView("show_activities" , "activityCategoryForm", activityCategoryForm);
	}
	
	public static List<ActivityCategory> getActivityCategories() {
		return activityCategories;
	}

	public static void setActivityCategories(
			List<ActivityCategory> activityCategories) {
		ActivityCategoryController.activityCategories = activityCategories;
	}
	
	

}
