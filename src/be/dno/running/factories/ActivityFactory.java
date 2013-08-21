package be.dno.running.factories;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.DatatypeConverter;

import com.grum.geocalc.Coordinate;
import com.grum.geocalc.DegreeCoordinate;
import com.grum.geocalc.EarthCalc;
import com.grum.geocalc.Point;

import be.dno.running.entities.Activity;
import be.dno.running.entities.Lap;
import be.dno.running.entities.xml.garmin.gpx.Gpx;
import be.dno.running.entities.xml.garmin.gpx.GpxTrkpt;
import be.dno.running.entities.xml.garmin.tcx.TcxLap;
import be.dno.running.entities.xml.garmin.tcx.TcxTrackpoint;
import be.dno.running.entities.xml.garmin.tcx.TcxTrainingCenterDatabase;

public class ActivityFactory {
	
	public static Activity buildActivity(Gpx gpx){
		Activity activity = new Activity();
		
		String description = gpx.getMetadata().toString();
		description += "</br>" + gpx.getTrk().getName();
		
		activity.setDescription(description);
		
		List<GpxTrkpt> trckPoints = gpx.getTrk().getTrkseg().getTrkpts();
		
		Calendar c = DatatypeConverter.parseDateTime(gpx.getMetadata().getTime());
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		
		activity.setDateDebut(sdf.format(c.getTime()));
		activity.setAverageBpm(getAverageBpmGpx(trckPoints));
		activity.setElevationPositive(getElevationPositiveGpx(trckPoints));
		activity.setMaxBpm(getMaxBpmGpx(trckPoints));
		activity.setTotalTime(getTotalTimeGpx(trckPoints));
		activity.setTotalDistance(getTotalDistanceGpx(trckPoints));
		activity.setSpeed((activity.getTotalDistance()) / (activity.getTotalTime() / 60 / 60));
		
		double secondsforonekilo = activity.getTotalTime() / activity.getTotalDistance();
		activity.setPace(toPace(Double.valueOf(secondsforonekilo).longValue()));
		return activity;
	}
	
	private static String toPace(long totalseconds){
		System.out.println("totalseconds : " + totalseconds);
		int seconds = (int) (totalseconds) % 60 ;
		int minutes = (int) ((totalseconds / (60)) % 60);
		int hours   = (int) ((totalseconds / (60*60)) % 24);
		return toDoubleDigit(hours) + ":" + toDoubleDigit(minutes) + ":" + toDoubleDigit(seconds);
	}
	
	private static String toDoubleDigit(int digit){
		String s = digit + "";
		return (s.length() == 1) ? "0"+s : s;
	}
	
	public static int getAverageBpmGpx(List<GpxTrkpt> trckPoints){
		int averageBpm = 0;
		int cptLapWithBPM = 0;
		for (GpxTrkpt lap : trckPoints){
			if (lap.getExtensions().getTrackPointExtension().getHr() != null){
				averageBpm += Integer.parseInt(lap.getExtensions().getTrackPointExtension().getHr());
				cptLapWithBPM++;
			}
		}
		if (cptLapWithBPM != 0){
			averageBpm /= cptLapWithBPM;
		}else{
			averageBpm = 0;
		}
		return averageBpm;
	}
	
	public static long getTotalTimeGpx(List<GpxTrkpt> trckPoints){
		long totalTime = 0;
		for (int i = 1; i < trckPoints.size(); i++){
			String sTimePrevious = trckPoints.get(i-1).getTime();
			String sTime = trckPoints.get(i).getTime();
			if (null != sTimePrevious && null != sTime){
				long msPrevious = DatatypeConverter.parseDateTime(sTimePrevious).getTimeInMillis();
				long msCurrent = DatatypeConverter.parseDateTime(sTime).getTimeInMillis();
				long elasped = msCurrent-msPrevious;
				totalTime += elasped;
			}
		}
		return totalTime / 1000;
	}
	
	public static double getTotalDistanceGpx(List<GpxTrkpt> trckPoints){
		double totalDistance = 0.0;
		for (int i = 1; i < trckPoints.size(); i++){
			Point pPrevious = getPointFromCoords(trckPoints.get(i-1).getLon(),trckPoints.get(i-1).getLat());
			Point pCurrent = getPointFromCoords(trckPoints.get(i).getLon(),trckPoints.get(i).getLat());
			if (null != pPrevious && null != pCurrent){
				double distance = EarthCalc.getDistance(pPrevious, pCurrent); //in meters
				totalDistance += distance;
			}
		}
		return totalDistance / 1000;
	}
	
	private static Point getPointFromCoords(String _lon, String _lat){
		Coordinate lat = new DegreeCoordinate(Double.parseDouble(_lat));
		Coordinate lng = new DegreeCoordinate(Double.parseDouble(_lon));
		return new Point(lat, lng);
	}
	
	public static int getMaxBpmGpx(List<GpxTrkpt> trckPoints){
		int maxBpm = 0;
		for (GpxTrkpt lap : trckPoints){
			if (lap.getExtensions().getTrackPointExtension().getHr() != null){
				int lapMaxBpm = Integer.parseInt(lap.getExtensions().getTrackPointExtension().getHr());
				if (lapMaxBpm > maxBpm){
					maxBpm = lapMaxBpm;
				}
			}
		}
		return maxBpm;
	}

	public static int getElevationPositiveGpx(List<GpxTrkpt> trckPoints) {
		int elevationPositive = 0;
		for (int i = 1; i < trckPoints.size(); i++){
			String sAltPre = trckPoints.get(i-1).getEle();
			String sAlt = trckPoints.get(i).getEle();
			if (null != sAltPre && null != sAlt){
				double alttpprevious = Double.parseDouble(sAltPre);
				double alttp = Double.parseDouble(sAlt);
				double elevGain = alttp-alttpprevious;
				if (elevGain > 0.0){
					elevationPositive += (elevGain);
				}
			}
		}
		return elevationPositive;
	}
	
	
	public static Activity buildActivity(TcxTrainingCenterDatabase tcd){
		Activity activity = new Activity();
		String description = tcd.getAuthor().toString();
		description += "</br>Sport: " + tcd.getActivities().getActivity().getSport();
		description += "</br>Creator: " + tcd.getActivities().getActivity().getCreator().toString();
		activity.setDescription(description);
		final List<TcxLap> laps = tcd.getActivities().getActivity().getLaps();
		activity.setAverageBpm(getAverageBpm(laps));
		activity.setDateDebut(tcd.getActivities().getActivity().getId());
		activity.setElevationPositive(getElevationPositive(laps));
		activity.setTotalDistance(getTotalDistance(laps) / 1000);
		activity.setMaxBpm(getMaxBpm(laps));
		activity.setTotalTime(getTotalTime(laps));
		activity.setTotalCalories(getTotalCalories(laps));
		
		List<Lap> lapBySameDistance = getLapsBySameDistance(laps);
		List<Lap> lapBySameTime = getLapsBySameTime(laps);
		
		double avgLapSameDist = getAverageSecondForLapsBySameDistance(lapBySameDistance);
		double avgLapSameTime = getAverageDistanceForLapsBySameTime(lapBySameTime);
		
		activity.setLapsBySameDistance(lapBySameDistance);
		activity.setLapsBySameTime(lapBySameTime);
		
		activity.setAverageDistanceForLapsBySameTime(avgLapSameTime);
		activity.setAverageSecondForLapsBySameDistance(avgLapSameDist);
		
		activity.setMaxDeviationDistanceForLapsBySameTime(getMaxDeviationDistanceForLapsBySameTime(lapBySameTime, avgLapSameTime));
		activity.setMaxDeviationSecondForLapsBySameDistance(getMaxDeviationSecondForLapsBySameDistance(lapBySameDistance, avgLapSameDist));
		
		List<Lap> intLap = new ArrayList<Lap>();
		for (TcxLap lap : laps){
			intLap.add(LapFactory.buildLap(lap));
		}
		activity.setLaps(intLap);	
		activity.setSpeed((activity.getTotalDistance()) / (activity.getTotalTime() / 60 / 60));
		
		double secondsforonekilo = activity.getTotalTime() / activity.getTotalDistance();
		activity.setPace(toPace(Double.valueOf(secondsforonekilo).longValue()));
		
		return activity;
	}
	
	
	private static double getMaxDeviationSecondForLapsBySameDistance(List<Lap> lapsBySameDistance, double averageSecondForLapsBySameDistance) {
		double maxDeviationSecondForLapsBySameDistance = 0.0;
		for (Lap lap : lapsBySameDistance){
			double seconds = lap.getTotalTimeSeconds();
			double deviation = Math.abs(seconds - averageSecondForLapsBySameDistance);
			if (deviation > maxDeviationSecondForLapsBySameDistance){
				maxDeviationSecondForLapsBySameDistance = deviation;
			}
		}
		
		return maxDeviationSecondForLapsBySameDistance;
	}

	private static double getMaxDeviationDistanceForLapsBySameTime(List<Lap> lapsBySameTime, double averageDistanceForLapsBySameTime) {
		double maxDeviationDistanceForLapsBySameTime = 0.0;
		for (Lap lap : lapsBySameTime){
			double distance = lap.getDistanceMeters();
			double deviation = Math.abs(distance - averageDistanceForLapsBySameTime);
			if (deviation > maxDeviationDistanceForLapsBySameTime){
				maxDeviationDistanceForLapsBySameTime = deviation;
			}
		}
		
		return maxDeviationDistanceForLapsBySameTime;
	}
	
	private static double getAverageSecondForLapsBySameDistance(List<Lap> lapsBySameDistance) {
		double averageSecondForLapsBySameDistance = 0.0;
		for (Lap lap : lapsBySameDistance){
			averageSecondForLapsBySameDistance += lap.getTotalTimeSeconds();
		}
		averageSecondForLapsBySameDistance /= lapsBySameDistance.size();
		return averageSecondForLapsBySameDistance;
	}

	private static double getAverageDistanceForLapsBySameTime(List<Lap> lapsBySameTime) {
		double averageDistanceForLapsBySameTime = 0.0;
		for (Lap lap : lapsBySameTime){
			averageDistanceForLapsBySameTime += lap.getDistanceMeters();
		}
		averageDistanceForLapsBySameTime /= lapsBySameTime.size();
		return averageDistanceForLapsBySameTime;
	}
	
	public static List<Lap> getLapsBySameDistance(List<TcxLap> laps) {
		List<Lap> lapsBySameDistance = new ArrayList<Lap>();
		
		Map<Double, List<Lap>> mapByDistance = new HashMap<Double, List<Lap>>();
		for (TcxLap lap : laps){
			Double meters = Double.parseDouble(lap.getDistanceMeters());
			List<Lap> currentLapsForDistance = mapByDistance.get(meters);
			if (currentLapsForDistance == null) currentLapsForDistance = new ArrayList<Lap>();
			currentLapsForDistance.add(LapFactory.buildLap(lap));
			mapByDistance.put(meters, currentLapsForDistance);
		}
		
		for (Double key : mapByDistance.keySet()){
			List<Lap> listLap = mapByDistance.get(key);
			if (listLap.size() > 1){
				lapsBySameDistance.addAll(listLap);
			}
		}
		
		return lapsBySameDistance;
	}

	public static List<Lap> getLapsBySameTime(List<TcxLap> laps) {
		List<Lap> lapsBySameTime = new ArrayList<Lap>();
		Map<Double, List<Lap>> mapByTime = new HashMap<Double, List<Lap>>();
		for (TcxLap lap : laps){
			double seconds = Double.parseDouble(lap.getTotalTimeSeconds());
			List<Lap> currentLapsForTime = mapByTime.get(seconds);
			if (currentLapsForTime == null) currentLapsForTime = new ArrayList<Lap>();
			currentLapsForTime.add(LapFactory.buildLap(lap));
			mapByTime.put(seconds, currentLapsForTime);
		}
		
		for (Double key : mapByTime.keySet()){
			List<Lap> listLap = mapByTime.get(key);
			if (listLap.size() > 1){
				lapsBySameTime.addAll(listLap);
			}
		}
		return lapsBySameTime;
	}

	public static double getTotalTime(List<TcxLap> laps){
		double totalTime = 0.0;
		for (TcxLap lap : laps){
			totalTime += Double.parseDouble(lap.getTotalTimeSeconds());
		}
		return totalTime;
	}
	
	public static int getAverageBpm(List<TcxLap> laps){
		int averageBpm = 0;
		int cptLapWithBPM = 0;
		for (TcxLap lap : laps){
			if (lap.getAverageHeartRateBpm() != null){
				averageBpm += Integer.parseInt(lap.getAverageHeartRateBpm());
				cptLapWithBPM++;
			}
		}
		if (cptLapWithBPM != 0){
			averageBpm /= cptLapWithBPM;
		}else{
			averageBpm = 0;
		}
		return averageBpm;
	}
	
	public static double getTotalDistance(List<TcxLap> laps){
		double totalDistance = 0.0;
		for (TcxLap lap : laps){
			totalDistance += Double.parseDouble(lap.getDistanceMeters());
		}
		return totalDistance;
	}
	
	public static int getTotalCalories(List<TcxLap> laps){
		int totalCalories = 0;
		for (TcxLap lap : laps){
			totalCalories += Integer.parseInt(lap.getCalories());
		}
		return totalCalories;
	}
	
	public static int getMaxBpm(List<TcxLap> laps){
		int maxBpm = 0;
		for (TcxLap lap : laps){
			if (lap.getMaximumHeartRateBpm() != null){
				int lapMaxBpm = Integer.parseInt(lap.getMaximumHeartRateBpm());
				if (lapMaxBpm > maxBpm){
					maxBpm = lapMaxBpm;
				}
			}
		}
		return maxBpm;
	}

	public static int getElevationPositive(List<TcxLap> laps) {
		int elevationPositive = 0;
		for (TcxLap lap : laps){
			List<TcxTrackpoint> trackpoints = lap.getTrack().getTrackpoints();
			for (int i = 1; i < trackpoints.size(); i++){
				String sAltPre = trackpoints.get(i-1).getAltitudeMeters();
				String sAlt = trackpoints.get(i).getAltitudeMeters();
				if (null != sAltPre && null != sAlt){
					double alttpprevious = Double.parseDouble(sAltPre);
					double alttp = Double.parseDouble(sAlt);
					double elevGain = alttp-alttpprevious;
					if (elevGain > 0.0){
						elevationPositive += (elevGain);
					}
				}
			}
		}
		return elevationPositive;
	}
}
