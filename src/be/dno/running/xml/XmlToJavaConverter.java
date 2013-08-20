package be.dno.running.xml;

import be.dno.running.entities.xml.Activities;
import be.dno.running.entities.xml.Author;
import be.dno.running.entities.xml.Creator;
import be.dno.running.entities.xml.Lap;
import be.dno.running.entities.xml.TrainingCenterDatabase;
import be.dno.running.entities.xml.XmlActivity;

import com.thoughtworks.xstream.XStream;
import com.wappworks.xstream.XStreamGae;

public class XmlToJavaConverter {
	public static TrainingCenterDatabase convert(String xml){
		XStreamGae xstream = new XStreamGae();
		TrainingCenterDatabase tcd = null;
		Class[] classes = {Activities.class, Author.class, Creator.class, Lap.class, TrainingCenterDatabase.class, XmlActivity.class};
		try{
			System.out.println("Will deserialize from XML");
			xstream.processAnnotations(classes);
			tcd = (TrainingCenterDatabase) xstream.fromXML(xml);
			System.out.println("tcd --> " + tcd);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
		return tcd;
	}
}
