package be.dno.running.helper;

import java.util.Collection;

public class JspHelper {
	public static boolean isCollectionEmpty(Collection c){
		return c == null || c.isEmpty();
	}
	
	public static String htmlEncode(String input){
		return input.replaceAll("\"", "'");
	}
	
	public static String htmlDecode(String input){
		return input.replaceAll("'", "\"");
	}
}
