package be.dno.running.helper;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

import com.google.appengine.api.utils.SystemProperty;

public class JspHelper {
	
	@SuppressWarnings("rawtypes") 
	public static boolean isCollectionEmpty(Collection c){
		return c == null || c.isEmpty();
	}
	
	public static String htmlEncode(String input){
		return input.replaceAll("\"", "'");
	}
	
	public static String htmlDecode(String input){
		return input.replaceAll("'", "\"");
	}
	
	public static String getCleanVersion(){
		String version = SystemProperty.applicationVersion.get();
		String[] versions = version.split("\\.");
		String ret = versions[0];
		try{
			Date uploadDate = new Date(Long.parseLong(versions[1]) / (2 << 27) * 1000);
			SimpleDateFormat sdf = new SimpleDateFormat ("yyyy/MM/dd HH:mm:ss");
			ret += " since " + sdf.format(uploadDate) + " GMT";
		}catch(Exception ex){}
		return ret;
	}
}
