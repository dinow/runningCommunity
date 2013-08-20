package be.dno.running.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import be.dno.running.entities.Activity;
import be.dno.running.entities.ActivityCategory;


@Controller
@RequestMapping(value = "/show_activities")
public class ActivityCategoryController {
	//http://viralpatel.net/blogs/spring-mvc-multi-row-submit-java-list/
	private static List<ActivityCategory> activityCategories = new ArrayList<>();
	 
   
     
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView get() {  
    	System.out.println("ModelAndView get");
    	activityCategories.clear();
    	fillActivities();
    	System.out.println(" --> " + activityCategories.size());
    	ActivityCategoryForm activityCategoryForm = new ActivityCategoryForm();
    	activityCategoryForm.setActivityCategories(activityCategories);
        return new ModelAndView("show_activities" , "activityCategoryForm", activityCategoryForm);
    }
    
    private void fillActivities(){
		String[] categories = {"Course", "EF", "SL", "Fractions", "Fartlek"};
		for (String category : categories){
			ActivityCategory ac = new ActivityCategory();
			List<Activity> activities = new ArrayList<>();
			ac.setExpended(true);
			ac.setId(category);
			ac.setLabel(category);
			
			int nbMax = getRandom(15);
			
			for (int i = 0; i < nbMax; i++){
				Activity a = new Activity();
				a.setId(i+"");
				a.setDateDebut(""+new java.util.Date());
				a.setDenivele(""+getRandom(300));
				a.setDistance(""+getRandom(42));
				a.setPace(getRandom(3,6)+":"+getRandom(59));
				a.setTime(getRandom(2)+":"+getRandom(60)+":"+getRandom(60));
				activities.add(a);
			}
			ac.setActivities(activities);
			activityCategories.add(ac);
		}
		
		
	}
	
	private int getRandom(int max){
		return getRandom(0,max);
	}
	
	private int getRandom(int min, int max){
		return min + (int)(Math.random() * ((max - min) + 1));
	}

	public static List<ActivityCategory> getActivityCategories() {
		return activityCategories;
	}

	public static void setActivityCategories(
			List<ActivityCategory> activityCategories) {
		ActivityCategoryController.activityCategories = activityCategories;
	}
	
	

}
