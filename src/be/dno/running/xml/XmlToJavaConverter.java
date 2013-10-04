package be.dno.running.xml;

import java.util.logging.Logger;


import com.wappworks.xstream.XStreamGae;

public class XmlToJavaConverter {
	private static final Logger log = Logger.getLogger(XmlToJavaConverter.class.getName());
	@SuppressWarnings("rawtypes")
	public static Object convert(String xml, Class mainClass){
		XStreamGae xstream = new XStreamGae();
		Object ret = null;
		try{
			log.fine("Init XmlToJavaConverter with class " + mainClass);
			xstream.processAnnotations(mainClass);
			ret = (Object) xstream.fromXML(xml);
			log.fine("Object created");
		}catch(Exception ex){
			log.severe(ex.getMessage());
		}
		return ret;
	}
}
