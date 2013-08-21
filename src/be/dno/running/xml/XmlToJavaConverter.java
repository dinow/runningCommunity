package be.dno.running.xml;

import be.dno.running.entities.xml.garmin.gpx.Gpx;
import be.dno.running.entities.xml.garmin.tcx.TrainingCenterDatabase;

import com.wappworks.xstream.XStreamGae;

public class XmlToJavaConverter {
	public static Object convert(String xml, String fileCategory){
		XStreamGae xstream = new XStreamGae();
		if (fileCategory.equals("TCX_GARMIN")){
			TrainingCenterDatabase tcd = null;
			Class[] classes = {TrainingCenterDatabase.class};
			try{
				xstream.processAnnotations(classes);
				tcd = (TrainingCenterDatabase) xstream.fromXML(xml);
			}catch(Exception ex){
				ex.printStackTrace();
			}
			return tcd;
		}else if (fileCategory.equals("GPX_GARMIN")){
			Gpx gpx = null;
			Class[] classes = {Gpx.class};
			try{
				xstream.processAnnotations(classes);
				gpx = (Gpx) xstream.fromXML(xml);
			}catch(Exception ex){
				ex.printStackTrace();
			}
			return gpx;
		}
		return null;
	}
}
