package be.dno.running.entities.xml.garmin.tcx;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

@XStreamAlias("TrainingCenterDatabase")
public class TrainingCenterDatabase {
	
	@XStreamAlias("Activities")
	private Activities activities;
	
	@XStreamAlias("Author")
	private Author author;
	
	@XStreamOmitField
	private double totalTime = -1;
	
	@XStreamOmitField
	private int averageBpm = -1;
	
	@XStreamOmitField
	private int maxBpm = -1;
	
	@XStreamOmitField
	private double elevationPositive = -1;
	
	
	@XStreamOmitField
	private int totalCalories = -1;
	
	@XStreamOmitField
	private double totalDistance = -1;
	
	@XStreamOmitField
	private Map<String,List<Lap>> mapByDistance = null;
	
	@XStreamOmitField
	private Map<String, List<Lap>> mapByTime = null;
	
	@XStreamOmitField
	private List<Lap> lapsBySameDistance = null;
	
	@XStreamOmitField
	private List<Lap> lapsBySameTime = null;
	
	private double averageSecondForLapsBySameDistance = -1;
	private double averageDistanceForLapsBySameTime = -1;
	
	private double maxDeviationSecondForLapsBySameDistance = -1;
	private double maxDeviationDistanceForLapsBySameTime = -1;
	
	
	
	public String getMaxDeviationSecondForLapsBySameDistance() {
		if (maxDeviationSecondForLapsBySameDistance != -1) return maxDeviationSecondForLapsBySameDistance+"";
		maxDeviationSecondForLapsBySameDistance = 0;
		if (averageSecondForLapsBySameDistance == -1) getAverageSecondForLapsBySameDistance();
		for (Lap lap : lapsBySameDistance){
			double seconds = Double.parseDouble(lap.getTotalTimeSeconds());
			double deviation = Math.abs(seconds - averageSecondForLapsBySameDistance);
			if (deviation > maxDeviationSecondForLapsBySameDistance){
				maxDeviationSecondForLapsBySameDistance = deviation;
			}
		}
		
		return maxDeviationSecondForLapsBySameDistance+"";
	}

	public String getMaxDeviationDistanceForLapsBySameTime() {
		if (maxDeviationDistanceForLapsBySameTime != -1) return maxDeviationDistanceForLapsBySameTime+"";
		maxDeviationDistanceForLapsBySameTime = 0;
		if (averageDistanceForLapsBySameTime == -1) getAverageDistanceForLapsBySameTime();
		for (Lap lap : lapsBySameTime){
			double distance = Double.parseDouble(lap.getDistanceMeters());
			double deviation = Math.abs(distance - averageDistanceForLapsBySameTime);
			if (deviation > maxDeviationDistanceForLapsBySameTime){
				maxDeviationDistanceForLapsBySameTime = deviation;
			}
		}
		
		return maxDeviationDistanceForLapsBySameTime+"";
	}
	
	public String getAverageSecondForLapsBySameDistance() {
		if (averageSecondForLapsBySameDistance != -1) return averageSecondForLapsBySameDistance+"";
		if (lapsBySameDistance == null) getLapsBySameDistance();
		for (Lap lap : lapsBySameDistance){
			double seconds = Double.parseDouble(lap.getTotalTimeSeconds());
			averageSecondForLapsBySameDistance += seconds;
		}
		averageSecondForLapsBySameDistance /= lapsBySameDistance.size();
		return averageSecondForLapsBySameDistance+"";
	}

	public String getAverageDistanceForLapsBySameTime() {
		if (averageDistanceForLapsBySameTime != -1) return averageDistanceForLapsBySameTime+"";
		if (lapsBySameTime == null) getLapsBySameTime();
		for (Lap lap : lapsBySameTime){
			double meters = Double.parseDouble(lap.getDistanceMeters());
			averageDistanceForLapsBySameTime += meters;
		}
		averageDistanceForLapsBySameTime /= lapsBySameDistance.size();
		return averageDistanceForLapsBySameTime+"";
	}

	public Activities getActivities() {
		return activities;
	}
	
	public Author getAuthor() {
		return author;
	}
	
	
	
	public List<Lap> getLapsBySameDistance() {
		if (lapsBySameDistance != null) return lapsBySameDistance;
		lapsBySameDistance = new ArrayList<>();
		List<Lap> laps = activities.getActivity().getLaps();
		mapByDistance = new HashMap<>();
		for (Lap lap : laps){
			List<Lap> currentLapsForDistance = mapByDistance.get(lap.getDistanceMeters());
			if (currentLapsForDistance == null) currentLapsForDistance = new ArrayList<>();
			currentLapsForDistance.add(lap);
			mapByDistance.put(lap.getDistanceMeters(), currentLapsForDistance);
		}
		
		for (String key : mapByDistance.keySet()){
			List<Lap> listLap = mapByDistance.get(key);
			if (listLap.size() > 1){
				lapsBySameDistance.addAll(listLap);
			}
		}
		
		return lapsBySameDistance;
	}

	public List<Lap> getLapsBySameTime() {
		if (lapsBySameTime != null) return lapsBySameTime;
		lapsBySameTime = new ArrayList<>();
		List<Lap> laps = activities.getActivity().getLaps();
		mapByTime = new HashMap<>();
		for (Lap lap : laps){
			List<Lap> currentLapsForTime = mapByTime.get(lap.getTotalTimeSeconds());
			if (currentLapsForTime == null) currentLapsForTime = new ArrayList<>();
			currentLapsForTime.add(lap);
			mapByTime.put(lap.getTotalTimeSeconds(), currentLapsForTime);
		}
		
		for (String key : mapByTime.keySet()){
			List<Lap> listLap = mapByTime.get(key);
			if (listLap.size() > 1){
				lapsBySameTime.addAll(listLap);
			}
		}
		return lapsBySameTime;
	}

	public String getTotalTime(){
		if (totalTime != -1) return totalTime+"";
		List<Lap> laps = activities.getActivity().getLaps();
		for (Lap lap : laps){
			totalTime += Double.parseDouble(lap.getTotalTimeSeconds());
		}
		return totalTime+"";
	}
	
	public String getAverageBpm(){
		if (averageBpm != -1) return averageBpm+"";
		List<Lap> laps = activities.getActivity().getLaps();
		int cptLapWithBPM = 0;
		for (Lap lap : laps){
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
		return averageBpm+"";
	}
	
	public String getTotalDistance(){
		if (totalDistance != -1) return totalDistance+"";
		List<Lap> laps = activities.getActivity().getLaps();
		for (Lap lap : laps){
			totalDistance += Double.parseDouble(lap.getDistanceMeters());
		}
		return totalDistance+"";
	}
	
	public String getTotalCalories(){
		if (totalCalories != -1) return totalCalories+"";
		List<Lap> laps = activities.getActivity().getLaps();
		for (Lap lap : laps){
			totalCalories += Integer.parseInt(lap.getCalories());
		}
		return totalCalories+"";
	}
	
	public String getMaxBpm(){
		if (maxBpm != -1) return maxBpm+"";
		List<Lap> laps = activities.getActivity().getLaps();
		for (Lap lap : laps){
			if (lap.getMaximumHeartRateBpm() != null){
				int lapMaxBpm = Integer.parseInt(lap.getMaximumHeartRateBpm());
				if (lapMaxBpm > maxBpm){
					maxBpm = lapMaxBpm;
				}
			}
		}
		return maxBpm+"";
	}

	public String getElevationPositive() {
		if (elevationPositive != -1) return elevationPositive+"";
		List<Lap> laps = activities.getActivity().getLaps();
		for (Lap lap : laps){
			List<Trackpoint> trackpoints = lap.getTrack().getTrackpoints();
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
		return elevationPositive+"";
	}
	
	
	
}
