package be.dno.running.helper;

public class ConvertHelper {

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
