package be.dno.running.helper;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.DatatypeConverter;

public class ConvertHelper {

	private static SimpleDateFormat sdf_out = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	
	public static Date toDate(String input){
		if (input == null || input.isEmpty()){
			return new Date();
		}
		return DatatypeConverter.parseDateTime(input).getTime();
	}
	
	public static String dateToString(Date in){
		if (in == null) return "";
		return sdf_out.format(in);
	}
	
	public static String toPace(long totalseconds){
		int seconds = (int) (totalseconds) % 60 ;
		int minutes = (int) ((totalseconds / (60)) % 60);
		int hours   = (int) ((totalseconds / (60*60)) % 24);
		return toDoubleDigit(hours) + ":" + toDoubleDigit(minutes) + ":" + toDoubleDigit(seconds);
	}
	
	public static String toDoubleDigit(int digit){
		String s = digit + "";
		return (s.length() == 1) ? "0"+s : s;
	}
	
	public static String toDoubleDigit(long digit){
		String s = digit + "";
		return (s.length() == 1) ? "0"+s : s;
	}
	
	public static double limitDecimal(double digit){
		return (double)Math.round(digit * 10) / 10;
	}

}
