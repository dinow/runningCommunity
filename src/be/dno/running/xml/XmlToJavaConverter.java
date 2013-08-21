package be.dno.running.xml;

import java.util.Date;

import com.wappworks.xstream.XStreamGae;

public class XmlToJavaConverter {
	public static Object convert(String xml, Class mainClass){
		XStreamGae xstream = new XStreamGae();
		Object ret = null;
		try{
			System.out.println(new Date() + " - Init converter with class " + mainClass);
			xstream.processAnnotations(mainClass);
			ret = (Object) xstream.fromXML(xml);
			System.out.println(new Date() + " - Object created");
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return ret;
	}
}
