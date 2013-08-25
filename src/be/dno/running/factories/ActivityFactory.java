package be.dno.running.factories;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import javax.xml.bind.DatatypeConverter;

import be.dno.running.entities.Activity;
import be.dno.running.entities.Lap;
import be.dno.running.entities.xml.garmin.gpx.Gpx;
import be.dno.running.entities.xml.garmin.gpx.GpxTrkpt;
import be.dno.running.entities.xml.garmin.gpx.GpxTrkseg;
import be.dno.running.entities.xml.garmin.tcx.TcxAuthor;
import be.dno.running.entities.xml.garmin.tcx.TcxCreator;
import be.dno.running.entities.xml.garmin.tcx.TcxLap;
import be.dno.running.entities.xml.garmin.tcx.TcxTrackpoint;
import be.dno.running.entities.xml.garmin.tcx.TcxTrainingCenterDatabase;
import be.dno.running.helper.ConvertHelper;

import com.grum.geocalc.Coordinate;
import com.grum.geocalc.DegreeCoordinate;
import com.grum.geocalc.EarthCalc;
import com.grum.geocalc.Point;

public class ActivityFactory {
	private static final Logger log = Logger.getLogger(ActivityFactory.class.getName());
	static class ActivityCalculatedValues{
		private int averageBpm;
		private double elevation;
		private double totalDistance;
		private int maxBpm;
		private double totalTime;
		private int totalCalories;
		double avgLapSameDist;
		double avgLapSameTime;
		
		List<Lap> lapBySameDistance;
		
		List<Lap> lapBySameTime;
		
		private Map<Long, List<Lap>> lapsByDistance;
		
		public int getAverageBpm() {
			return averageBpm;
		}
		public void setAverageBpm(int averageBpm) {
			this.averageBpm = averageBpm;
		}
		public double getElevation() {
			return elevation;
		}
		public void setElevation(double elevation) {
			this.elevation = elevation;
		}
		public double getTotalDistance() {
			return totalDistance;
		}
		public void setTotalDistance(double totalDistance) {
			this.totalDistance = totalDistance;
		}
		public int getMaxBpm() {
			return maxBpm;
		}
		public void setMaxBpm(int maxBpm) {
			this.maxBpm = maxBpm;
		}
		public double getTotalTime() {
			return totalTime;
		}
		public void setTotalTime(double totalTime) {
			this.totalTime = totalTime;
		}
		public int getTotalCalories() {
			return totalCalories;
		}
		public void setTotalCalories(int totalCalories) {
			this.totalCalories = totalCalories;
		}
		public List<Lap> getLapBySameDistance() {
			return lapBySameDistance;
		}
		public void setLapBySameDistance(List<Lap> lapBySameDistance) {
			this.lapBySameDistance = lapBySameDistance;
		}
		public List<Lap> getLapBySameTime() {
			return lapBySameTime;
		}
		public void setLapBySameTime(List<Lap> lapBySameTime) {
			this.lapBySameTime = lapBySameTime;
		}
		public double getAvgLapSameDist() {
			return avgLapSameDist;
		}
		public void setAvgLapSameDist(double avgLapSameDist) {
			this.avgLapSameDist = avgLapSameDist;
		}
		public double getAvgLapSameTime() {
			return avgLapSameTime;
		}
		public void setAvgLapSameTime(double avgLapSameTime) {
			this.avgLapSameTime = avgLapSameTime;
		}
		public Map<Long, List<Lap>> getLapsByDistance() {
			return lapsByDistance;
		}
		public void setLapsByDistance(Map<Long, List<Lap>> lapsByDistance) {
			this.lapsByDistance = lapsByDistance;
		}
		
		
	}
	
	private static ActivityCalculatedValues getTcxActivityCalculatedValues(List<TcxLap> laps){
		ActivityCalculatedValues acv = new ActivityCalculatedValues();
		
		int maxBpm = 0;
		int averageBpm = 0;
		int cptLapWithBPM = 0;
		int elevationPositive = 0;
		double totalDistance = 0.0;
		int totalCalories = 0;
		double totalTime =  0.0;
		List<Lap> lapsBySameDistance = new ArrayList<Lap>();
		Map<Double, List<Lap>> mapByDistance = new HashMap<Double, List<Lap>>();
		
		
		List<Lap> lapsBySameTime = new ArrayList<Lap>();
		Map<Double, List<Lap>> mapByTime = new HashMap<Double, List<Lap>>();
		
		for (TcxLap lap : laps){
			totalDistance += Double.parseDouble(lap.getDistanceMeters());
			totalCalories += Integer.parseInt(lap.getCalories());	
			totalTime += Double.parseDouble(lap.getTotalTimeSeconds());
		
			if (lap.getMaximumHeartRateBpm() != null){
				int lapMaxBpm = Integer.parseInt(lap.getMaximumHeartRateBpm());
				if (lapMaxBpm > maxBpm){
					maxBpm = lapMaxBpm;
				}
			}
			if (lap.getAverageHeartRateBpm() != null){
				averageBpm += Integer.parseInt(lap.getAverageHeartRateBpm());
				cptLapWithBPM++;
			}
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
			
			Double meters = Double.parseDouble(lap.getDistanceMeters());
			List<Lap> currentLapsForDistance = mapByDistance.get(meters);
			if (currentLapsForDistance == null) currentLapsForDistance = new ArrayList<Lap>();
			currentLapsForDistance.add(LapFactory.buildLap(lap,0.0));
			mapByDistance.put(meters, currentLapsForDistance);
			
			double seconds = Double.parseDouble(lap.getTotalTimeSeconds());
			List<Lap> currentLapsForTime = mapByTime.get(seconds);
			if (currentLapsForTime == null) currentLapsForTime = new ArrayList<Lap>();
			currentLapsForTime.add(LapFactory.buildLap(lap,0.0));
			mapByTime.put(seconds, currentLapsForTime);
		}
		
		
		
		for (Double key : mapByDistance.keySet()){
			List<Lap> listLap = mapByDistance.get(key);
			if (listLap.size() > 1){
				lapsBySameDistance.addAll(listLap);
			}
		}
		
		for (Double key : mapByTime.keySet()){
			List<Lap> listLap = mapByTime.get(key);
			if (listLap.size() > 1){
				lapsBySameTime.addAll(listLap);
			}
		}
		
		double averageSecondForLapsBySameDistance = 0.0;
		for (Lap lap : lapsBySameDistance){
			averageSecondForLapsBySameDistance += lap.getTotalTimeSeconds();
		}
		averageSecondForLapsBySameDistance /= lapsBySameDistance.size();
		
		double averageDistanceForLapsBySameTime = 0.0;
		for (Lap lap : lapsBySameTime){
			averageDistanceForLapsBySameTime += lap.getDistanceMeters();
		}
		averageDistanceForLapsBySameTime /= lapsBySameTime.size();
		
		if (cptLapWithBPM != 0){
			averageBpm /= cptLapWithBPM;
		}else{
			averageBpm = 0;
		}
		
		double averageSpeed = 0.0;
		for (Lap lap : lapsBySameTime){
			averageSpeed += lap.getSpeed();
		}
		averageSpeed /= lapsBySameTime.size();
		
		for (Lap lap : lapsBySameTime){
			lap.setDeviationMeters(ConvertHelper.limitDecimal(Math.abs(lap.getDistanceMeters() - averageDistanceForLapsBySameTime)));
			double decalageSpeed = ConvertHelper.limitDecimal(lap.getSpeed() - averageSpeed); 
			if (decalageSpeed == 0.0){
				lap.setKmHeureDiffAverageActivity(0.0);
				lap.setTimeDiffAverageActivity("00:00:00");
			}else{
				lap.setKmHeureDiffAverageActivity(decalageSpeed);
				decalageSpeed = Math.abs(decalageSpeed);
				double secondsforonekilo = (decalageSpeed * 1000) / 60;
				lap.setTimeDiffAverageActivity(ConvertHelper.toPace(Double.valueOf(secondsforonekilo).longValue()));
			}
		}
		
		averageSpeed = 0.0;
		for (Lap lap : lapsBySameDistance){
			averageSpeed += lap.getSpeed();
		}
		averageSpeed /= lapsBySameDistance.size();
		for (Lap lap : lapsBySameDistance){
			lap.setDeviationTimeSeconds(ConvertHelper.limitDecimal(Math.abs(lap.getTotalTimeSeconds() - averageSecondForLapsBySameDistance)));
			double decalageSpeed = ConvertHelper.limitDecimal(lap.getSpeed() - averageSpeed); 
			if (decalageSpeed == 0.0){
				lap.setKmHeureDiffAverageActivity(0.0);
				lap.setTimeDiffAverageActivity("00:00:00");
			}else{
				lap.setKmHeureDiffAverageActivity(decalageSpeed);
				decalageSpeed = Math.abs(decalageSpeed);
				double secondsforonekilo = (decalageSpeed * 1000) / 60;
				lap.setTimeDiffAverageActivity(ConvertHelper.toPace(Double.valueOf(secondsforonekilo).longValue()));
			}
		}
		
		
		acv.setMaxBpm(maxBpm);
		acv.setAverageBpm(averageBpm);
		acv.setElevation(elevationPositive);
		acv.setTotalDistance(ConvertHelper.limitDecimal(totalDistance));
		acv.setTotalCalories(totalCalories);
		acv.setTotalTime(totalTime);
		acv.setLapBySameDistance(lapsBySameDistance);
		acv.setLapBySameTime(lapsBySameTime);
		acv.setAvgLapSameDist(ConvertHelper.limitDecimal(averageSecondForLapsBySameDistance));
		acv.setAvgLapSameTime(ConvertHelper.limitDecimal(averageDistanceForLapsBySameTime));
		return acv;
	}
	
	public static Activity buildActivity(TcxTrainingCenterDatabase tcd, String userId){
		Activity activity = new Activity(userId);
		TcxAuthor author = tcd.getAuthor();
		TcxCreator creator = tcd.getActivities().getActivity().getCreator();
		String description = author != null ? author.toString() : "";
		try{
			description += "</br>Sport: " + tcd.getActivities().getActivity().getSport();
		}catch(Exception ex){
			
		}
		try{
			description += "</br>Creator: " + creator != null ? creator.toString() : "";
		}catch(Exception ex){
			
		}
		
		activity.setDescription(description);
		final List<TcxLap> laps = tcd.getActivities().getActivity().getLaps();
		
		ActivityCalculatedValues acv = getTcxActivityCalculatedValues(laps);
		
		activity.setAverageBpm(acv.getAverageBpm());
		activity.setDateDebut(ConvertHelper.toDate(tcd.getActivities().getActivity().getId()));
		activity.setElevationPositive(acv.getElevation());
		activity.setTotalDistance(acv.getTotalDistance() / 1000);
		activity.setMaxBpm(acv.getMaxBpm());
		activity.setTotalTime(acv.getTotalTime());
		activity.setTotalCalories(acv.getTotalCalories());
		
		activity.setLapsBySameDistance(acv.getLapBySameDistance());
		activity.setLapsBySameTime(acv.getLapBySameTime());
		
		activity.setAverageDistanceForLapsBySameTime(acv.getAvgLapSameTime());
		activity.setAverageSecondForLapsBySameDistance(acv.getAvgLapSameDist());
		
		activity.setAverageTimeForLapsBySameDistance(ConvertHelper.toPace(Double.valueOf(acv.getAvgLapSameDist()).longValue()));
		
		activity.setMaxDeviationDistanceForLapsBySameTime(getMaxDeviationDistanceForLapsBySameTime(acv.getLapBySameTime(), acv.getAvgLapSameTime()));
		activity.setMaxDeviationSecondForLapsBySameDistance(getMaxDeviationSecondForLapsBySameDistance(acv.getLapBySameDistance(), acv.getAvgLapSameDist()));
		
		
		activity.setSpeed(ConvertHelper.limitDecimal((activity.getTotalDistance()) / (activity.getTotalTime() / 60 / 60)));
		
		double secondsforonekilo = activity.getTotalTime() / activity.getTotalDistance();
		activity.setPace(ConvertHelper.toPace(Double.valueOf(secondsforonekilo).longValue()));
		
		List<Lap> intLap = new ArrayList<Lap>();
		for (TcxLap lap : laps){
			intLap.add(LapFactory.buildLap(lap,activity.getSpeed()));
		}
		activity.setLaps(intLap);	
		
		return activity;
	}	
	
	public static Activity buildActivity(Gpx gpx, String userId){
		Activity activity = new Activity(userId);
		
		String description = gpx.getMetadata().toString();
		description += "</br>" + gpx.getTrk().getName();
		
		activity.setDescription(description);
		List<GpxTrkseg> trkSegs = gpx.getTrk().getTrkseg();
		List<GpxTrkpt> trckPoints = new ArrayList<GpxTrkpt>();
		for (GpxTrkseg trkSeg : trkSegs){
			trckPoints.addAll(trkSeg.getTrkpts());
		}
		
		try{
			activity.setDateDebut(ConvertHelper.toDate(gpx.getMetadata().getTime()));
		}catch(Exception ex){
			log.severe(ex.getMessage());
		}
		
		activity.setAverageBpm(getAverageBpmGpx(trckPoints));
		activity.setElevationPositive(getElevationPositiveGpx(trckPoints));
		activity.setMaxBpm(getMaxBpmGpx(trckPoints));
		activity.setTotalTime(getTotalTimeGpx(trckPoints));
		activity.setTotalDistance(ConvertHelper.limitDecimal(getTotalDistanceGpx(trckPoints)));
		activity.setSpeed(ConvertHelper.limitDecimal((activity.getTotalDistance()) / (activity.getTotalTime() / 60 / 60)));
		
		double secondsforonekilo = activity.getTotalTime() / activity.getTotalDistance();
		activity.setPace(ConvertHelper.toPace(Double.valueOf(secondsforonekilo).longValue()));
		buildLapsByDistanceGpx(trckPoints);
		//activity.setLapsByDistance(buildLapsByDistanceGpx(trckPoints));
		
		
		return activity;
	}
	
	
	public static Map<String,List<Lap>> buildLapsByDistanceGpx(List<GpxTrkpt> trckPoints){
		Map<String,List<Lap>> returnMap = new HashMap<String, List<Lap>>();
		Integer[] distances = new Integer[]{250,500,1000,2000,5000,10000};
		Map<Integer, Lap> trackingCounters = new HashMap<Integer,Lap>();
		
		for (int i = 1; i < trckPoints.size(); i++){
			Point pPrevious = getPointFromCoords(trckPoints.get(i-1).getLon(),trckPoints.get(i-1).getLat());
			Point pCurrent = getPointFromCoords(trckPoints.get(i).getLon(),trckPoints.get(i).getLat());
			long elasped = 1000;
			String sTimePrevious = trckPoints.get(i-1).getTime();
			String sTime = trckPoints.get(i).getTime();
			if (null != sTimePrevious && null != sTime){
				long msPrevious = DatatypeConverter.parseDateTime(sTimePrevious).getTimeInMillis();
				long msCurrent = DatatypeConverter.parseDateTime(sTime).getTimeInMillis();
				elasped = msCurrent-msPrevious;			
			}
			
			if (null != pPrevious && null != pCurrent){
				double distance = EarthCalc.getDistance(pPrevious, pCurrent); //in meters
				if (!"NaN".equals(distance+"")){
					//Add this distance for all counters, and check if we reached the limit
					for (Integer split : distances){
						Lap tempLap = trackingCounters.get(split);
						if (tempLap == null) tempLap = new Lap();
						tempLap.setDistanceMeters(tempLap.getDistanceMeters()+distance);
						tempLap.setTotalTimeSeconds(tempLap.getTotalTimeSeconds()+elasped);
						if (tempLap.getDistanceMeters() >= split){
							Lap splittedLap = new Lap();
							splittedLap.setDistanceMeters(tempLap.getDistanceMeters());
							splittedLap.setTotalTimeSeconds(tempLap.getTotalTimeSeconds() + (elasped / 1000));
							splittedLap.setAverageHeartRateBpm(tempLap.getAverageHeartRateBpm());
							double secondsforonekilo = splittedLap.getTotalTimeSeconds() / splittedLap.getDistanceMeters();
							splittedLap.setPace(ConvertHelper.toPace(Double.valueOf(secondsforonekilo).longValue()));
							List<Lap> lapsForThisSplit = returnMap.get("m"+split);
							if (lapsForThisSplit == null) lapsForThisSplit = new ArrayList<Lap>();
							lapsForThisSplit.add(splittedLap);
							returnMap.put("m"+split, lapsForThisSplit);
							tempLap = new Lap();
						}
						trackingCounters.put(split, tempLap);
					}
				}
			}
		}
		
		for (String key : returnMap.keySet()){
			System.out.println("KEY : " + key);
			for (Lap lap : returnMap.get(key)){
				System.out.println(lap);
			}
		} 
		
		return returnMap;
	}
	
	
	public static int getAverageBpmGpx(List<GpxTrkpt> trckPoints){
		int averageBpm = 0;
		int cptLapWithBPM = 0;
		for (GpxTrkpt lap : trckPoints){
			if (lap.getExtensions() != null && lap.getExtensions().getTrackPointExtension() != null && lap.getExtensions().getTrackPointExtension().getHr() != null){
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
			}else{
				totalTime += 1000;
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
				if ("NaN".equals(distance+"")){
					log.warning("Cannot get distance for some points...");
					log.fine("pPrevious : " + pPrevious);
					log.fine("pCurrent : " + pCurrent);
					log.fine("distance : " + distance);
				}else{
					totalDistance += distance;
				}
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
			if (lap.getExtensions() != null && lap.getExtensions().getTrackPointExtension() != null && lap.getExtensions().getTrackPointExtension().getHr() != null){
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
	


	private static double getMaxDeviationSecondForLapsBySameDistance(List<Lap> lapsBySameDistance, double averageSecondForLapsBySameDistance) {
		double maxDeviationSecondForLapsBySameDistance = 0.0;
		for (Lap lap : lapsBySameDistance){
			double seconds = lap.getTotalTimeSeconds();
			double deviation = Math.abs(seconds - averageSecondForLapsBySameDistance);
			if (deviation > maxDeviationSecondForLapsBySameDistance){
				maxDeviationSecondForLapsBySameDistance = deviation;
			}
		}

		return ConvertHelper.limitDecimal(maxDeviationSecondForLapsBySameDistance);
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

		return ConvertHelper.limitDecimal(maxDeviationDistanceForLapsBySameTime);
	}
}
