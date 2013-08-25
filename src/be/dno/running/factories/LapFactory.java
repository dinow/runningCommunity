package be.dno.running.factories;

import be.dno.running.entities.Lap;
import be.dno.running.entities.xml.garmin.tcx.TcxLap;
import be.dno.running.helper.ConvertHelper;

public class LapFactory {
	public static Lap buildLap(TcxLap tcxLap, double activityAverageSpeed){
		Lap lap = new Lap();
		lap.setAverageHeartRateBpm(Integer.parseInt(tcxLap.getAverageHeartRateBpm()));
		lap.setCalories(Integer.parseInt(tcxLap.getCalories()));
		lap.setDistanceMeters(Double.parseDouble(tcxLap.getDistanceMeters()));
		lap.setMaximumHeartRateBpm(Integer.parseInt(tcxLap.getMaximumHeartRateBpm()));
		double maxMetersBySeconds = Double.parseDouble(tcxLap.getMaximumSpeed());
		lap.setMaximumSpeed(ConvertHelper.limitDecimal(maxMetersBySeconds*3.6));
		lap.setTotalTimeSeconds(Double.parseDouble(tcxLap.getTotalTimeSeconds()));
		lap.setStartTime(ConvertHelper.toDate(tcxLap.getStartTime()));
		lap.setSpeed(ConvertHelper.limitDecimal((lap.getDistanceMeters() / 1000) / (lap.getTotalTimeSeconds() / 60 / 60)));
		double secondsforonekilo = lap.getTotalTimeSeconds() / (lap.getDistanceMeters() / 1000);
		lap.setPace(ConvertHelper.toPace(Double.valueOf(secondsforonekilo).longValue()));
		lap.setTotalTime(ConvertHelper.toPace(Double.valueOf(lap.getTotalTimeSeconds() ).longValue()));

		if (activityAverageSpeed!=0.0){
			double decalageSpeed = ConvertHelper.limitDecimal(lap.getSpeed() - activityAverageSpeed); 
			if (decalageSpeed == 0.0){
				lap.setKmHeureDiffAverageActivity(0.0);
				lap.setTimeDiffAverageActivity("00:00:00");
			}else{
				lap.setKmHeureDiffAverageActivity(decalageSpeed);
				decalageSpeed = Math.abs(decalageSpeed);
				secondsforonekilo = (decalageSpeed * 1000) / 60;
				lap.setTimeDiffAverageActivity(ConvertHelper.toPace(Double.valueOf(secondsforonekilo).longValue()));
			}
		}
		return lap;
	}
}
