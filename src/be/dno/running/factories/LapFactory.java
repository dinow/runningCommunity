package be.dno.running.factories;

import be.dno.running.entities.Lap;
import be.dno.running.entities.xml.garmin.tcx.TcxLap;
import be.dno.running.helper.ConvertHelper;

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
		lap.setSpeed(ConvertHelper.limitDecimal((lap.getDistanceMeters() / 1000) / (lap.getTotalTimeSeconds() / 60 / 60)));
		double secondsforonekilo = lap.getTotalTimeSeconds() / (lap.getDistanceMeters() / 1000);
		lap.setPace(ConvertHelper.toPace(Double.valueOf(secondsforonekilo).longValue()));
		lap.setTotalTime(ConvertHelper.toPace(Double.valueOf(lap.getTotalTimeSeconds() ).longValue()));
		return lap;
	}
}
