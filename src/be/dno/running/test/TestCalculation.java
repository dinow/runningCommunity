package be.dno.running.test;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.junit.Test;

import be.dno.running.entities.Activity;
import be.dno.running.entities.xml.garmin.gpx.Gpx;
import be.dno.running.entities.xml.garmin.tcx.TcxTrainingCenterDatabase;
import be.dno.running.factories.ActivityFactory;
import be.dno.running.persistence.GenericDao;
import be.dno.running.xml.XmlToJavaConverter;

public class TestCalculation {
	private static GenericDao<Activity> activityDao = new GenericDao<Activity>(Activity.class); 
	
	@Test
	public void test() throws FileNotFoundException, IOException {
		File gpxFile = new File("E:\\Development\\activity_382293747.gpx");
		String fileContent = new String(IOUtils.toByteArray(new FileInputStream(gpxFile)));
		Gpx gpx = (Gpx) XmlToJavaConverter.convert(fileContent,Gpx.class);
		Activity activity = ActivityFactory.buildActivity(gpx,"1");
		
		activity = activityDao.create(activity);
	}

}
