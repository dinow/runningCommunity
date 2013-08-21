package be.dno.running.factories;

import be.dno.running.entities.Lap;
import be.dno.running.entities.xml.garmin.tcx.TcxLap;

public class LapFactory {
	public static Lap buildLap(TcxLap tcxLap){
		Lap lap = new Lap();
		lap.setAverageHeartRateBpm(Integer.parseInt(tcxLap.getAverageHeartRateBpm()));
		lap.setCalories(Integer.parseInt(tcxLap.getCalories()));
		lap.setDistanceMeters(Double.parseDouble(tcxLap.getDistanceMeters()));
		lap.setMaximumHeartRateBpm(Integer.parseInt(tcxLap.getMaximumHeartRateBpm()));
		lap.setMaximumSpeed(Double.parseDouble(tcxLap.getMaximumSpeed()));
		lap.setTotalTimeSeconds(Double.parseDouble(tcxLap.getTotalTimeSeconds()));
		lap.setStartTime(tcxLap.getStartTime());
		return lap;
	}
}
